package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Genesee County, NY
Contact: rtripp@2ki.net
Contact: Robert Bennett <rbennett8994@gmail.com>
Sender: 911center@co.genesee.ny.us

Contact: Steve Sharpe <ssharp7597@gmail.com>
Sender: 777393903612
GENESEE COUNTY DISPATCH Unit:GS94 Status:Dispatched ** Test Call ** GCSO** 165 PARK RD , BATAVIA ** back room ** INITIAL DISPATCH ** VETERANS MEMORIAL DR / RICHMOND AVE ** 06/13/13 11:18 ** 2013-00013125 TXT STOP to opt-out\r

Contact: Ryan <hinz_ryan@yahoo.com>
Sender: 777396077042
GENESEE COUNTY DISPATCH Unit:AX10 Status:Dispatched ** Acc PIAA ** ** BROADWAY RD , MAIN ST ALEXANDER ** ** CAR DEER M INJ E OF 98 ON RT 20 ** ** 06/16/13 14:

Contact: Stephen Smelski <steveepfd@gmail.com>
Sender: 777416718972
GENESEE COUNTY DISPATCH ** Fire Auto ** 401.3 RT 90 E** , CORFU ** ** TIRE FIRE ON TRAILER ** I 90, ALLEGHANY RD / EXIT 48A RAMP, ALLEGHANY RD ** 07/11/13 16:29 ** 2013-00000104 TXT STOP to opt-out  4 min??
GENESEE COUNTY DISPATCH ** EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA ** LOT 27 ** UNC MALE SICK ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 07/11/13 14:22 ** 2013-00000152 TXT STOP to opt-out
GENESEE COUNTY DISPATCH Unit:EP57 Status:Dispatched ** Alarm EMS ** ** 1838 MAIN RD , PEMBROKE ** ** EMS ALARM UNK ** CLEVELAND RD / BOYCE RD ** 07/09/13 12:30 * 2013-00000150 TXT STOP to opt-out

General alerts
(Dispatch) RAILROAD CROSSINGS CLOSED FROM WORTENDYKE WEST BY CSX - WONT BE IN SERVICE TILL SOMETIME TOMORROW AT EARLIEST\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) All CSX RR crossings are now open.\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Railroad Crossing update - Per CSX  Colby Rd and Fargo Rd are OPEN - Estimating other 3 will be open by this afternoon - No work scheduled for Upton and Donahue that they are aware of\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: East Pembroke Volunteer Fire Department
Location: East Pembroke, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) ** EMD Charlie ** ** 2637 BROWN RD , BATAVIA ** ** 73 YOF CHEST PAINS ** HALSTEAD RD, WILKINSON RD / RIDGE RD ** 06/14/13 06:34 ** 2013-00000126\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched ** EMD Charlie ** ** 2637 BROWN RD , BATAVIA ** ** ** HALSTEAD RD, WILKINSON RD / RIDGE RD ** 06/14/13 06:34 ** 2013-00000126\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched ** EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA ** LOT 29A ** 76YOF - CONFUSION / FEVER  ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 06/13/13 11:17 ** 2013-00000125\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Alpha ** ** 8495 LOVERS LANE RD , BATAVIA - ** BACK PAIN ** SOUTH MAIN STREET RD / PEARL STREET RD ** 06/10/13 07:01 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Alpha ** ** 8495 LOVERS LANE RD , BATAVIA - ** BACK PAIN ** SOUTH MAIN STREET RD / PEARL STREET RD ** 06/10/13 07:01 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 2799 STEGMAN RD , BATAVIA - ** 54 YO FEMALE DIABETIC PROBLEM ** POWERS RD / MILLER RD ** 06/08/13 21:40 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 2799 STEGMAN RD , BATAVIA - ** ** POWERS RD / MILLER RD ** 06/08/13 21:40 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP60 Status:Dispatched Fire Service Call ** ** 2785 PRATT RD , BATAVIA - ** WATER IN BASEMENT ** POWERS RD / APPLE GROVE MOBILE HOME PK ** 06/08/13 15:23 ** 2013-00000121 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** ** 8190 NORTH PEMBROKE RD , PEMBROKE - ** 29 YO FEMALE WITH DIFFICULTY BREATHING ** INDIAN FALLS RD / BECKWITH RD ** 06/07/13 19:15 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Fire HazMat ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** DIESEL FUEL LEAK FROM TRACTOR TRAILER ** CLEVELAND RD / PRATT RD ** 06/07/13 15:31 ** 2013-00000119 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** ** 3276 PEARL STREET RD , BATAVIA - ** MINI VAN VS SEMI UNK INJURIES BLOCKING TRAFFIC ** WORTENDYKE RD / UPTON RD ** 06/07/13 12:54 ** 2013-00000118 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** AREA 51 MOTOCROSS** 3500 HARLOFF RD , BATAVIA - ** 21 YO MALE DIRT BIKE ACCIDENT ** No Cross Streets Found ** 06/04/13 18:43 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** National Fuel Gas** 3593 W  MAIN STREET RD , BATAVIA - ** ONE CAR OFF THE RD UNK INJURIES  ** KELSEY RD / COUNTY BLDG ** 06/04/13 16:21 ** 2013-00000116 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 2846 STEGMAN RD , BATAVIA - ** 68 YO MALE TROUBLE BREATHING ** POWERS RD / MILLER RD ** 06/01/13 15:06 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 8662 HARTSHORN RD , BATAVIA - ** 65YO MALE DIZZYNESS ** W MAIN STREET RD / PEARL STREET RD, WILKINSON RD ** 06/01/13 14:55 ** 2013-00000114 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Alarm Fire ** ** 2614 W  MAIN STREET RD , BATAVIA - ** 2ND FLOOR SMOKE - ZONE 14 ** READ RD, MAIN RD / EAST AVE ** 06/01/13 10:18 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** 52 YO FEMALE - CHEST PAIN ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Bravo ** ** 3314 W MAIN STREET RD , BATAVIA - ** 78 YO FEMALE - UNKNOWN  ** BATAVIA MOBILE HOME PK / HOPKINS RD ** 05/29/13 13:38 ** 2013-00000111 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched Alarm EMS ** ** 1838 MAIN RD , PEMBROKE - ** Fall Pevis injury ** CLEVELAND RD / BOYCE RD ** 05/24/13 22:09 ** 2013-00000110 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** FALL INJ TO HEAD ** CLEVELAND RD / PRATT RD ** 05/23/13 10:48 ** 2013-00000108 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP58 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 4 ** 90 YO M WITH GENERALIZED WEAKNESS  ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/21/13 12:59 ** 2013-00000106 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Fire Structure ** ** 3827 W  MAIN STREET RD , BATAVIA - ** HOUSE FIRE ** UNKNOWN / COUNTY BLDG ** 05/18/13 20:19 ** 2013-00000105 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** ** 3522 W MAIN STREET RD , BATAVIA - LOT 23 ** SEIZURE ** UNKNOWN / KELSEY RD ** 05/17/13 22:08 ** 2013-00002051 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** ** 2679 GALLOWAY RD , BATAVIA - ** CAR PED ** SLUSSER RD, MACOMBER RD / DOWNEY RD ** 05/17/13 16:10 ** 2013-00010895 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 3540 W MAIN STREET RD , BATAVIA - LOT 24 ** 18 MONTH OLD FEMALE SEIZURE ** UNKNOWN / KELSEY RD ** 05/17/13 16:07 ** 2013-00000101 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP56 Status:Dispatched Alarm Fire ** Pembroke Primary School** 2486 MAIN RD , PEMBROKE - ** GENERAL FIRE ALARM ** WEST AVE / INDIAN FALLS RD ** 05/17/13 14:38 ** 2013-00000100 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:EP57 Status:Dispatched Alarm EMS ** Ridgewood Village Mobile Home Park** 3233 PRATT RD , BATAVIA - LOT 14A ** EMS ALARM ACTIVATION, 90 YO FEMALE FALLEN WITH HEAD INJURY ** RIDGEWOOD VILLAGE PK / RIDGEWOOD VILLAGE PK ** 05/16/13 21:33 ** 2013-00000099 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - 33 ** 73 YOM POSSIBLE STROKE \n ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/16/13 07:36 ** 2013-00000098 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Town Of Batavia FD
Location: Batavia, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:251 Status:Dispatched ** Alarm Fire ** ** 29 EDGEWOOD DR , BATAVIA ** ** GENERAL FIRE ALARM HOMEOWNER IS ON LOC  ** UNKNOWN / WOODLAND DR ** 06/13/13 11:13 ** 2013-00000128\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Service Call ** TOWN OF BATAVIA FD STA 1** 8382 LEWISTON RD , BATAVIA - ** TOWN OF BATAVIA FIRE TO STAND BY IN QUARTERS ** PARK RD / W MAIN STREET RD, W MAIN ST ** 06/10/13 17:08 ** 2013-00000127 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Mutual Aid ** EAST PEMBROKE FIRE DEPT.** 2623 W  MAIN STREET RD , BATAVIA - ** ONE ENGINE FILL IN ** EAST AVE / READ RD, MAIN RD ** 06/07/13 16:27 ** 2013-00000126 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:TB24 Status:Dispatched Fire Nat Propane Gas ** EAST PEMBROKE FIRE DEPT.** 2623 W  MAIN STREET RD , BATAVIA - ** ONE ENGINE FILL IN ** EAST AVE / READ RD, MAIN RD ** 06/07/13 16:27 ** 2013-00000126 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire CO Detector ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - BDLG D 302 ** MALE W/ HEADACHE ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/06/13 07:10 ** 2013-00000125 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** Hodgins Engraving** 3817 W  MAIN STREET RD , BATAVIA - ** office and print shop fire  ** UNKNOWN / COUNTY BLDG ** 06/06/13 06:55 ** 2013-00000124 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** ** 4 TREADEASY AVE , BATAVIA - E ** GENERAL FIRE ALARM ** PEARL STREET RD / INDUSTRIAL BLVD ** 06/05/13 19:51 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - PINE ** GENERAL FIRE ALARM \n\n ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/04/13 20:28 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - PINE ** GENERAL FIRE ALARM \n ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/04/13 20:28 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** TRAVELODGE** 8204 PARK RD , BATAVIA - ** SOUTH HALL 1 ST FLOOR  ** OAK ST, EXIT 48 ON RAMP, EXIT 48 OFF RAMP / VETERANS MEMORIAL DR ** 06/03/13 10:58 ** 2013-00000121 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side - TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Investigation ** ** 8173 STATE STREET RD , BATAVIA - ** TREE ON FIRE - NEAR THE ROAD ** DEAD END / I 90 ** 06/02/13 14:46 ** 2013-00000119 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** ** 8423 STRINGHAM DR , BATAVIA - ** GENERAL ALARM ** DEAD END / DANA WAY ** 06/02/13 14:32 ** 2013-00000118 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Investigation ** ** 3730 ROSE RD , BATAVIA - ** TRANSFORMER SMOKING ** DONAHUE RD / WORTENDYKE RD ** 06/01/13 18:13 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched EMD Charlie ** Batavia Downs Western Regional Off Track Betting** 8315 PARK RD , BATAVIA - ** 72 YO MALE WITH POSSIBLE STROKE ** RICHMOND AVE / VETERANS MEMORIAL DR ** 05/30/13 21:27 ** 2013-00002257 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Acc PIAA ** ** 9084 CREEK RD , BATAVIA - ** ONE VEHICLE ROLL OVER ** DORMAN RD / LEHIGH AVE ** 05/29/13 18:49 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Wire Down ** ** 7778 OAK ORCHARD RD , BATAVIA - ** UNK TYPE OF WIRE DOWN \n ** BATAVIA ELBA TOWNLINE RD / W SAILE DR ** 05/29/13 12:25 ** 2013-00001270 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:252 Status:Dispatched Fire Wire Down ** ** OAK ORCHARD RD , W  SAILE DR BATAVIA - ** UNK TYPE OF WIRE DOWN \n ** ** 05/29/13 12:25 ** 2013-00001270 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** BARN FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 8224 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Acc PIAA ** ** LEWISTON RD , VETERANS MEMORIAL DR BATAVIA - ** 2 CAR PIAA ** ** 05/23/13 15:15 ** 2013-00011407 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:TB25 Status:Dispatched EMD Delta ** Buffalo Federal Detention Center** 4250 FEDERAL DR , BATAVIA - ** MALE UNC ON ROOF ** DEAD END / COMMERCE DR ** 05/23/13 14:32 ** 2013-00002141 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:TB18 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - SPRUCE ** GENERAL FIRE ALARM ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 05/20/13 15:35 ** 2013-00000109 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:252 Status:Dispatched Fire Grass ** ** I 90 , STATE STREET RD BATAVIA - ** GRASS FIRE  ** ** 05/20/13 11:36 ** 2013-00000108 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Acc PIAA ** 386.4 RT 90 W** , STAFFORD - ** 1 CAR ROLL OVER ** CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR ** 05/20/13 11:00 ** 2013-00000107 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Acc PIAA ** 386.4 RT 90 W** , STAFFORD - ** 1 CAR ** CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR ** 05/20/13 11:00 ** 2013-00000107 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Darien Volunteer Fire Dept.
Location: Darien, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Fire Structure ** ** 3105 COUNTY LINE RD , DARIEN - ** DIESEL TANK NEXT TO BARN ** SUMNER RD / SUMNER RD ** 10/03/12 01:53 ** 2012-00000226 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched Fire Structure ** ** 3105 COUNTY LINE RD , DARIEN - ** DEISEL TANK NEXT TO BARN ** SUMNER RD / SUMNER RD ** 10/03/12 01:53 ** 2012-00000226 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** DARIEN 1 TANKER TO WARSAW FIRE HALL ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** DARIEN 1 TANKER TO WARSAW FIRE HALL ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched EMD Bravo ** ** 1649 SUMNER RD , DARIEN - ** 68 YO FEMALE WITH OVERDOSE ** COLBY RD / ALLEGHANY RD ** 10/01/12 18:54 ** 2012-00000224 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched Acc PIAA ** ** 9768 COLBY RD , DARIEN - ** CAR/POLE UNKNOWN INJURIES ** RICHLEY RD / SUMNER RD ** 09/29/12 22:30 ** 2012-00002280 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched EMD Bravo ** DARIEN TOWN HALL** 10569 ALLEGHANY RD , DARIEN - ** HEAD LACERATION ** BROADWAY RD / SUMNER RD ** 09/29/12 19:38 ** 2012-00000222 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:501 Status:Dispatched EMD Delta ** ** 2064 RICHLEY RD , DARIEN - ** 67 YO MALE DIABETIC PROBLEM SEMI CONSCIOUS ** SIMONDS RD / HARPER RD ** 09/26/12 15:44 ** 2012-00000221 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Le Roy Fire Department
Location: Le Roy, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:LE65 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched ** Fire Service Call ** ** 27 W MAIN ST , LE ROY ** ** 1-1/2 feet of water in basemenr ** CRAIGIE ST / CLAY ST, LAKE ST, MAIN ST ** 06/13/13 19:35 ** 2013-00000125\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Service Call ** ** MAIN ST , BANK ST LE ROY - ** WASH DOWN REQUESTED BY LEROY EMS\n ** ** 06/09/13 22:10 ** 2013-00000124 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Mutual Aid ** ** 2667 YORK RD W , YORK - ** STAND-BY IN YORK FIRE DEPT. ** MAIN ST, YORK RD E / LIMERICK RD ** 06/07/13 17:51 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Mutual Aid ** ** <UNKNOWN> , - ** STAND-BY IN YORK FIRE DEPT. ** ** 06/07/13 17:51 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LE63 Status:Dispatched Alarm Fire ** Pavilion Central School** 7014 BIG TREE RD , PAVILION - ** GEN FIRE ALARM ** YORK RD / EAST PARK ST ** 06/07/13 06:08 ** 2013-00000102 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** 0.6 RT 490 W** , LE ROY - ** car deer ** I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490 ** 06/06/13 07:03 ** 2013-00000142 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Auto ** 381.0 RT 90 W** , LE ROY - ** SMOKE COMING FROM TT ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Auto ** 381.0 RT 90 W** , LE ROY - ** ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** ** W  MAIN ST , CLAY ST LE ROY - ** CAR VS SEMI NO INJ BLOCKING  ** ** 06/04/13 14:47 ** 2013-00001755 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Auto ** 378.2 RT 90 W** , LE ROY - ** TT Fire ** I 90, I-90 CONNECTOR / I 90 ** 05/31/13 19:50 ** 2013-00000538 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Auto ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** TT Fire ** UNKNOWN / UNKNOWN ** 05/31/13 19:50 ** 2013-00000538 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** Oatka Creek Public Fishing Stream NYS DEC** 8116 OATKA TRL , LE ROY - ** MOTORCYCLE VS TREE ** GULLY RD / CIRCULAR HILL RD ** 05/30/13 17:37 ** 2013-00000531 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Wire Down ** ** 6488 RANDALL RD , STAFFORD - ** UNKOWN TYPE WIRES DOWN  ** BUCKLEY RD / RICHMOND RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7488 RANDALL RD , LE ROY - ** UNKOWN TYPE WIRES DOWN  ** LAKE STREET RD, NORTH STREET RD / WEST BERGEN RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 23 E  MAIN ST , LE ROY - ** SMOKE ALARM ** TRIGON PK / TRIGON PK ** 05/29/13 11:54 ** 2013-00000114 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Wire Down ** ** 7152 W MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** LeRoy Meadows Apartments** 18 GENESEE ST , LE ROY - BLDG 7 ** FIRE ALARM ACTIVATION  ** LATHROP AVE / NORTH ST ** 05/27/13 06:26 ** 2013-00000112 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** UNRESPONSIVE MALE  ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Fire Investigation ** ** 94 MYRTLE ST , LE ROY - ** BURNED FOOD ON STOVE/SMOKE IN RESIDENCE ** CRAIGIE ST / GILBERT ST, ROYAL DR ** 05/24/13 02:23 ** 2013-00000110 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:702 Status:Dispatched Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 9200 ASBURY RD , LE ROY - ** FIRE ALARM ** E MAIN RD / HARRIS RD ** 05/20/13 14:47 ** 2013-00000107 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Bergen Fire Department
Location: Bergen, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:301 Status:Dispatched ** Fire Other ** ** 6377 N  LAKE RD , BERGEN ** ** FEMALE IN WATER - UP ON LOG ** SACKETT RD / BISSELL RD ** 06/15/13 11:50 ** 2013-00000147\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched ** Fire Wire Down ** ** S LAKE AVE , BUFFALO RD BERGEN ** ** UNK TYPE WIRE DOWN PARTIALLYIN ROADWAY  ** ** 06/13/13 14:41 ** 2013-00000146\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 7150 TOWNLINE RD , BERGEN - ** TV FALLEN ON 5YO - UNRESPONSIVE/BREATHING ** WEST BERGEN RD / TRIPP RD ** 06/10/13 09:00 ** 2013-00002412 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG269 Status:Dispatched Medical ** ** 7150 TOWNLINE RD , BERGEN - ** TV FALLEN ON 5YO - UNRESPONSIVE/BREATHING ** WEST BERGEN RD / TRIPP RD ** 06/10/13 09:00 ** 2013-00002412 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7445 MAPLE AVE , BERGEN - ** 80 YOF CHEST PAINS TROUBLE BREATHING  ** CONNELLY RD / CLINTON STREET RD ** 06/08/13 11:17 ** 2013-00000144 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG27 Status:Dispatched Fire Mutual Aid ** ** 175 LYELL AVE , SPENCERPORT - ** ONE ENGINE FILL IN AT SPENCERPORT FD ** PROSPECT ST / S UNION ST ** 06/06/13 17:17 ** 2013-00000143 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Acc PIAA ** 0.6 RT 490 W** , LE ROY - ** car deer ** I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490 ** 06/06/13 07:03 ** 2013-00000142 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG269 Status:Dispatched Mental ** ** 1 MCCABE CT , BERGEN - ** CALLERS DAUGHTER HAS THREATWENESD TO HARM HERSELF  ** DEAD END / SPRINGDALE LN ** 06/05/13 14:15 ** 2013-00001335 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7450 WARBOYS RD , BERGEN - ** 75yr old male heart prob. ** WEST SWEDEN RD / COOK RD ** 06/05/13 07:24 ** 2013-00000140 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 7450 WARBOYS RD , BERGEN - ** ** WEST SWEDEN RD / COOK RD ** 06/05/13 07:24 ** 2013-00000140 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Echo ** ** 7285 NORTH BERGEN RD , BERGEN - ** 82 YOM NOT BREATHING \n ** WOOD RD / WEST SWEDEN RD ** 06/04/13 09:40 ** 2013-00000139 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Echo ** ** 7285 NORTH BERGEN RD , BERGEN - ** ** WOOD RD / WEST SWEDEN RD ** 06/04/13 09:40 ** 2013-00000139 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 7285 NORTH BERGEN RD , BERGEN - ** ** WOOD RD / WEST SWEDEN RD ** 06/04/13 09:40 ** 2013-00000139 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched Acc PIAA ** ** , - ** TRUCK VS ATV ** HUNTER ST, CHURCH ST / SWAMP RD, JERICO RD, WEST SWEDEN RD ** 06/03/13 16:45 ** 2013-00000138 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7960 SACKETT RD , BERGEN - ** 71YOF TROUBLE BREATHING  ** N LAKE RD / WEST SWEDEN RD ** 06/03/13 07:35 ** 2013-00000137 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 7960 SACKETT RD , BERGEN - ** ** N LAKE RD / WEST SWEDEN RD ** 06/03/13 07:35 ** 2013-00000137 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched Mental ** ** 37 MUNGER ST , BERGEN - ** VOL MENTAL HEALTH TX  ** BUFFALO RD / CLINTON ST ** 06/03/13 06:22 ** 2013-00000136 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7960 SACKETT RD , BERGEN - ** 71 YO TROUBLE BREATHING\n ** N LAKE RD / WEST SWEDEN RD ** 05/31/13 19:02 ** 2013-00000135 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7960 SACKETT RD , BERGEN - ** ** N LAKE RD / WEST SWEDEN RD ** 05/31/13 19:02 ** 2013-00000135 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7960 SACKETT RD , BERGEN - ** ** N LAKE RD / WEST SWEDEN RD ** 05/31/13 19:02 ** 2013-00000135 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) 701 REQ ENGINE STAND BY IN QUARTERS\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG29 Status:Dispatched Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7378 COOK RD , BERGEN - ** SUBJECT CHOKING ** WEST SWEDEN RD, CREAMERY RD / WARBOYS RD ** 05/30/13 16:36 ** 2013-00000133 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** Byron Bergen Central School** 6917 WEST BERGEN RD , BERGEN - ** 51 YO MALE CHEST PAINS ** UNKNOWN / TOWNLINE RD ** 05/29/13 17:28 ** 2013-00000132 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Sugar Creek Bergen** 8132 BUFFALO RD , BERGEN - ** 80 YO FML CLEAR EVIDENCE OF A STROKE ** CLINTON STREET RD, S LAKE RD, S LAKE AVE / APPLETREE AVE ** 05/27/13 13:51 ** 2013-00002196 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** Sugar Creek Bergen** 8132 BUFFALO RD , BERGEN - ** ** CLINTON STREET RD, S LAKE RD, S LAKE AVE / APPLETREE AVE ** 05/27/13 13:51 ** 2013-00002196 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 46 S  LAKE AVE , BERGEN - ** 51 Y/O MALE SEIZURE W/ HISTORY OF A STROKE ** MCKENZIE ST / PARKVIEW DR ** 05/26/13 02:38 ** 2013-00000130 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 46 S  LAKE AVE , BERGEN - ** ** MCKENZIE ST / PARKVIEW DR ** 05/26/13 02:38 ** 2013-00000130 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Other ** 3.6 RT 490 E** , RIGA - ** CAR DEER MVA WITH FLUID LEAKAGE ** I 490, EXIT 2 ON RAMP E / I 490, SHERIDAN RD ** 05/23/13 01:43 ** 2013-00000129 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 75 NORTHFIELD DR , BERGEN - ** 73 YO MALE UNCONSCIOUS ** WOODSIDE DR / WOODSIDE DR ** 05/22/13 21:37 ** 2013-00000128 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7 HILLTOP DR , BERGEN - ** 77 YO FEMALE WITH DIFFICULTY BREATHING ** UNKNOWN / HIDDEN MEADOWS DR ** 05/20/13 22:03 ** 2013-00000126 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Acc PIAA ** ** 6377 N  LAKE RD , BERGEN - ** PDAA - ONE CAR - SMOKE FROM VEHICLE  ** SACKETT RD / BISSELL RD ** 05/20/13 06:58 ** 2013-00011081 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Auto ** ** 6377 N  LAKE RD , BERGEN - ** PDAA - ONE CAR - SMOKE FROM VEHICLE  ** SACKETT RD / BISSELL RD ** 05/20/13 06:58 ** 2013-00011081 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 12 CHURCH ST , BERGEN - ** 88 YO FEMALE FALLEN WITH LEFT HIP PAIN ** GATES ST / GIBSON ST ** 05/17/13 18:32 ** 2013-00000124 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7523 GILBERT RD , BERGEN - ** 46 YO MALE ALLERGIC REACTION ** CLINTON STREET RD / WEST BERGEN RD ** 05/16/13 22:15 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG26 Status:Dispatched Fire Mutual Aid ** ** 38 MARKET ST , BROCKPORT - ** ONE LADDER TO FILL IN AT BROCKPORT STA 1 ** WATER ST / PARK AVE ** 05/16/13 17:23 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Alarm Fire ** BERGEN FIRE DEPT.** 10 HUNTER ST , BERGEN - ** TOWN HALL SIDE ** N LAKE AVE, N LAKE RD / SWAMP RD, CHURCH ST ** 05/16/13 06:42 ** 2013-00000121 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Alarm Fire ** BERGEN FIRE DEPT.** 10 HUNTER ST , BERGEN - ** ** N LAKE AVE, N LAKE RD / SWAMP RD, CHURCH ST ** 05/16/13 06:42 ** 2013-00000121 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Acc PDAA ** ** 7020 CLINTON STREET RD , BERGEN - ** rolled three times\n\n\n ** WEST BERGEN RD / OLD STATE RD ** 05/16/13 03:15 ** 2013-00010733 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 53 WOODSIDE DR , BERGEN - ** POSS STROKE ** No Cross Streets Found ** 05/15/13 06:50 ** 2013-00000119 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** Barbary Coast Mobile Home Park** 7862 CLINTON STREET RD , BERGEN - LOT 3 ** TROUBLE BREATHING ** UNKNOWN / DUBLIN RD ** 05/14/13 22:41 ** 2013-00000118 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 528 JOHNSON RD , RIGA - ** ABDOMINAL PAIN 47 YOM ** CHILI AVE, CHILI RIGA CENTER RD / SHERIDAN RD ** 05/13/13 23:37 ** 2013-00000117 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched Acc PIAA ** 382.1 RT 90 E** , LE ROY - ** POSSIBLE 3 INJURED\n ** I 90, I-90 CONNECTOR / I 90, I-90 CONNECTOR ** 05/12/13 14:55 ** 2013-00000101 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 7322 SWAMP RD , BERGEN - PH  BOX 102 ** ADULT MALE CHEST PAIN / DIAPHORETIC ** POCOCK RD / JERICO RD, WEST SWEDEN RD ** 05/12/13 02:21 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 7322 SWAMP RD , BERGEN - PH  BOX 102 ** ** POCOCK RD / JERICO RD, WEST SWEDEN RD ** 05/12/13 02:21 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7322 SWAMP RD , BERGEN - PH  BOX 102 ** ** POCOCK RD / JERICO RD, WEST SWEDEN RD ** 05/12/13 02:21 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Wire Down ** ** BREW RD , CHILI AVE RIGA - ** UNK TYPE WIRE DOWN ** ** 05/11/13 11:40 ** 2013-00000114 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 18 RICHMOND AVE , BERGEN - ** 34 YO MALE DIFFICULTY BREATHING ** MCCABE CT / BUFFALO ST ** 05/10/13 18:08 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched EMD Delta ** ** 18 RICHMOND AVE , BERGEN - ** ** MCCABE CT / BUFFALO ST ** 05/10/13 18:08 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Acc PDAA ** ** 6499 N  LAKE RD , BERGEN - ** HEARD BOOM THEN LIGHTS WENT OUT ** BISSELL RD / SACKETT RD ** 05/10/13 01:23 ** 2013-00010329 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Suspicious Cond ** ** 6499 N  LAKE RD , BERGEN - ** HEARD BOOM THEN LIGHTS WENT OUT ** BISSELL RD / SACKETT RD ** 05/10/13 01:23 ** 2013-00010329 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Alarm Fire ** Liberty Pumps** 7000 APPLETREE AVE , BERGEN - ** GENERAL FIRE ALARM  ** LIBERTY WAY / BUFFALO RD ** 05/09/13 09:13 ** 2013-00000111 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Nat Propane Gas ** Bank of America LeRoy** 20 MAIN ST , LE ROY - ** SMELL OF GAS ** BANK ST / MILL ST ** 05/09/13 08:47 ** 2013-00000097 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Auto ** 0.1 RT 490 E** , LE ROY - ** TT FIRE - Rear wheels ** EXIT 47 OFF RAMP, I 490 / VALLANCE RD, I 490 ** 05/08/13 19:13 ** 2013-00000095 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 2193 REED RD , BERGEN - ** 36 YO FM Illness ** DRIVEWAY / WEST SWEDEN RD, W SWEDEN RD ** 05/05/13 16:10 ** 2013-00000108 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 7512 CLINTON STREET RD , BERGEN - ** 941 ISSUE ** MAPLE AVE / LYMAN RD ** 05/03/13 23:01 ** 2013-00000107 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Bravo ** ** 15 BUFFALO ST , BERGEN - ** 18 YO POSSIBLE NON TRAMATIC HEAD INJURY ** S LAKE AVE, ROCHESTER ST, N LAKE AVE / CHURCH ST ** 05/02/13 19:48 ** 2013-00000106 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Bravo ** ** 15 BUFFALO ST , BERGEN - ** ** S LAKE AVE, ROCHESTER ST, N LAKE AVE / CHURCH ST ** 05/02/13 19:48 ** 2013-00000106 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** Hidden Meadows Mobile Home Park** 7289 S LAKE RD , BERGEN - 29 ** 89 YO F FELL  UNK IN JURIES  ** WOODSIDE DR / CLINTON STREET RD ** 05/02/13 14:41 ** 2013-00000105 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 7525 WEST BERGEN RD , BERGEN - ** FEMALE WITH OVERDOSE ** GILBERT RD / OLD STATE RD ** 05/01/13 23:35 ** 2013-00000104 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Grass ** 3.5 RT 490 W** , BERGEN - ** BURNING COALS ON THE SIDE OF ROAD NEAR EXIT 2 ** EXIT 2 OFF RAMP W, I 490 / EXIT 2 ON RAMP W, I 490 ** 04/30/13 21:38 ** 2013-00000103 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 20 S  LAKE AVE , BERGEN - PH ** 90 FEMALE FALLEN SHOULDER INJURY ** BUFFALO ST, ROCHESTER ST, N LAKE AVE / MCKENZIE ST ** 04/30/13 19:12 ** 2013-00000102 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Other ** WEST BERGEN RD RRX** , BERGEN - ** TRAIN TRACTION MOTOR FIRE  ** WEST BERGEN RD, DUBLIN RD / WEST BERGEN RD ** 04/30/13 05:34 ** 2013-00000101 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Other ** WEST BERGEN RD RRX** , BERGEN - ** TRACTION MOTOR FIRE  ** WEST BERGEN RD, DUBLIN RD / WEST BERGEN RD ** 04/30/13 05:34 ** 2013-00000101 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG27 Status:Dispatched Fire Mutual Aid ** ** 38 MARKET ST , BROCKPORT - ** 1 ENGINE FILL-IN BROCKPORT ** WATER ST / PARK AVE ** 04/28/13 13:31 ** 2013-00000100 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** SUGAR CREEK BERGEN** 8132 BUFFALO RD , BERGEN - ** 59 YO MALE SEIZURE ** CLINTON STREET RD, S LAKE RD, S LAKE AVE / APPLETREE AVE ** 04/24/13 20:52 ** 2013-00000099 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Grass ** 2.7 RT 490 W** , BERGEN - ** SMALL GRASS FIRE ROADSIDE ** BREW RD, UNNAMED ST / EXIT 2 OFF RAMP E, CHILI AVE ** 04/22/13 13:29 ** 2013-00000098 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG26 Status:Dispatched Fire Structure ** ** 8706 HAVEN LN , LE ROY - ** ODOR OF SOMETHING BURNING UPSTAIRS ** DEAD END / DEAD END ** 04/21/13 23:05 ** 2013-00000075 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Acc PIAA ** 4.5 RT 490 E** , RIGA - ** ONE VEHICLE ACCIDENT UNKNOWN INJURY ** I 490, SHERIDAN RD / I 490, EXIT 2 ON RAMP E ** 04/20/13 17:39 ** 2013-00000096 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched Medical ** ** 11 S  LAKE AVE , BERGEN - ** 60YO MALE WITH NAUSEA ** BUFFALO ST, ROCHESTER ST, N LAKE AVE / MCKENZIE ST ** 04/20/13 11:21 ** 2013-00000095 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 80 NORTHFIELD DR , BERGEN - ** 78YO MALE SLURRED SPEECH ** No Cross Streets Found ** 04/20/13 07:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Byron Bergen Central School** 6917 WEST BERGEN RD , BERGEN - ** 15 YO F PASSED OUT - MINOR HEAD INJURY  ** UNKNOWN / TOWNLINE RD ** 04/19/13 14:05 ** 2013-00000093 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** Byron Bergen Central School** 6917 WEST BERGEN RD , BERGEN - ** ** UNKNOWN / TOWNLINE RD ** 04/19/13 14:05 ** 2013-00000093 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Alarm Fire ** Byron Bergen Central School** 6917 WEST BERGEN RD , BERGEN - ** COMMERCIAL FIRE ALARM, ZONE 1  ** UNKNOWN / TOWNLINE RD ** 04/18/13 22:31 ** 2013-00000092 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 37 BUFFALO ST , BERGEN - ** 53 YOM LIFTING ASSISTANCE ** RICHMOND AVE / EMILY CT ** 04/16/13 02:38 ** 2013-00000091 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** Bergen Village Hall** 11 BUFFALO ST , BERGEN - FRONT ** 28 YO FEMALE NEAR FAINTING ** S LAKE AVE, ROCHESTER ST, N LAKE AVE / CHURCH ST ** 04/14/13 16:11 ** 2013-00000090 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire CO Detector ** ** 7581 S  LAKE RD , BERGEN - ** CO DETECTOR ACTIVATION IN KITCHEN ** LAKE RD / MAPLE AVE, BOVEE RD ** 04/14/13 07:09 ** 2013-00000089 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Acc PIAA ** ** , - ** ATV ACCIDENT WITH INJURY ** SWAMP RD, JERICO RD, WEST SWEDEN RD / SWAMP RD, HUNTER ST, CHURCH ST ** 04/13/13 16:33 ** 2013-00000088 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:301 Status:Dispatched Fire Service Call ** ** 10 HUNTER ST , BERGEN - ** EMS/FIRE POLICE DETAIL ** N LAKE AVE, N LAKE RD / SWAMP RD, CHURCH ST ** 04/13/13 14:20 ** 2013-00000087 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG26 Status:Dispatched Fire Structure ** LeRoy Meadows Apartments** 18 GENESEE ST , LE ROY - 9B ** smoke in the apt ** LATHROP AVE / NORTH ST ** 04/12/13 18:56 ** 2013-00000063 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Alpha ** ** 7589 S  LAKE RD , BERGEN - ** WIFE FELL BROKEN ANKLE\n ** LAKE RD / MAPLE AVE, BOVEE RD ** 04/12/13 05:52 ** 2013-00000085 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG26 Status:Dispatched Fire Structure ** ** 33 LAKE ST , LE ROY - APT A ** SMOKE FILLED APARTMENT ** SCHOOL ST / BACON ST ** 04/11/13 14:47 ** 2013-00000061 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Service Call ** ** 7637 BUFFALO RD , RIGA - ** BG19 ON LOCATION ** SHERIDAN RD, W BUFFALO ST / ROCHESTER ST ** 04/11/13 13:51 ** 2013-00000083 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG19 Status:Dispatched Fire Service Call ** ** 7667 BUFFALO RD , RIGA - ** BG19 ON LOCATION ** SHERIDAN RD, W BUFFALO ST / ROCHESTER ST ** 04/11/13 13:51 ** 2013-00000083 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG29 Status:Dispatched Fire Structure ** ** 6471 HUDSON RD , PAVILION - ** FEED BUNK FIRE ** ** 04/07/13 14:07 ** 2013-00000072 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Delta ** ** 6578 N  LAKE RD , BERGEN - ** scene is no secured39 YO FM overdose ** BISSELL RD / HUNTER ST, N LAKE AVE ** 04/05/13 21:01 ** 2013-00007493 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** BERGEN TOWN HALL** 10 HUNTER ST , BERGEN - ** ADULT MALE PASSED OUT - CONSCIOUS ** N LAKE AVE, N LAKE RD / SWAMP RD, CHURCH ST ** 04/03/13 17:55 ** 2013-00000080 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BG30 Status:Dispatched EMD Charlie ** ** 10 HUNTER ST , BERGEN - ** ADULT MALE PASSED OUT - CONSCIOUS ** N LAKE AVE, N LAKE RD / SWAMP RD, CHURCH ST ** 04/03/13 17:55 ** 2013-00000080 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Town of Alabama Fire
Location: Alabama, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:AL19 Status:Dispatched ** EMD Echo ** ** 1750 ROBERTS RD , ALABAMA ** ** ** SOUR SPRINGS RD / KNOWLESVILLE RD ** 06/14/13 19:13 ** 2013-00000140\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched ** EMD Charlie ** ** 385 BLOOMINGDALE RD , TONAWANDA IR ** ** 26 YO MALE WITH DIFFICULTY BREATHING ** SHANKS RD / MARTIN RD ** 06/13/13 19:44 ** 2013-00000126\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53YOF ABD PAIN  ** LONE RD / SKYE RD ** 06/11/13 11:48 ** 2013-00000138 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** ** LONE RD / SKYE RD ** 06/11/13 11:48 ** 2013-00000138 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 734 BLOOMINGDALE RD , TONAWANDA IR - ** 37 YO FEMALE WITH SEVERE HEADACHE ** POODRY RD / REUBEN RD ** 06/10/13 17:12 ** 2013-00000137 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 734 BLOOMINGDALE RD , TONAWANDA IR - ** ** POODRY RD / REUBEN RD ** 06/10/13 17:12 ** 2013-00000137 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched Alarm EMS ** Leisure Timers Apartments** 364 BLOOMINGDALE RD , ALABAMA - 105 ** UNRESPONSIVE  ** SHANKS RD / TESNOW RD ** 06/10/13 08:42 ** 2013-00000136 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 890 JUDGE RD , TONAWANDA IR - ** 50 YO MALE NOT ALERT IS BREATHING ** GRIFFEN RD / POODRY RD ** 06/09/13 20:22 ** 2013-00002406 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Delta ** ** 890 JUDGE RD , TONAWANDA IR - ** ** GRIFFEN RD / POODRY RD ** 06/09/13 20:22 ** 2013-00002406 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53 YO FEMALE ABDOMINAL PAIN ** LONE RD / SKYE RD ** 06/09/13 07:58 ** 2013-00000134 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched Acc PIAA ** Doc's Smoke Shop** 672 BLOOMINGDALE RD , TONAWANDA IR - ** 2 CARS ** POODRY RD / SANDHILL RD, MEADVILLE RD ** 06/08/13 15:29 ** 2013-00001356 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 895 LEWISTON RD , ALABAMA - ** 19 YO FEMALE WITH A SEIZURE ** CASEY RD / FEEDER RD ** 06/07/13 23:43 ** 2013-00000132 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 895 LEWISTON RD , ALABAMA - ** ** CASEY RD / FEEDER RD ** 06/07/13 23:43 ** 2013-00000132 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 2251 JUDGE RD , ALABAMA - ** 40 YO FEMALE W/ ABDOMINAL PAIN ** MAPLE RD, KNOWLESVILLE RD / MORGAN RD ** 06/07/13 04:55 ** 2013-00000131 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 2251 JUDGE RD , ALABAMA - ** ** MAPLE RD, KNOWLESVILLE RD / MORGAN RD ** 06/07/13 04:55 ** 2013-00000131 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53 YO FEMALE ABDOMINAL PAIN ** LONE RD / SKYE RD ** 06/01/13 21:00 ** 2013-00000129 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** 51 yo male semi cons ** No Cross Streets Found ** 06/01/13 19:40 ** 2013-00000128 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** ** No Cross Streets Found ** 06/01/13 19:40 ** 2013-00000128 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Grass ** ** 890 JUDGE RD , TONAWANDA IR - ** FIELD FIRE - UNKNOWN ADDRESS ** GRIFFEN RD / POODRY RD ** 06/01/13 15:12 ** 2013-00000127 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched Fire Grass ** ** JUDGE RD , ALLEGHANY RD ALABAMA - ** FIELD FIRE - UNKNOWN ADDRESS ** ** 06/01/13 15:12 ** 2013-00000127 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** Leisure Timers Apartments** 364 BLOOMINGDALE RD , ALABAMA - Apt 206 ** 52 YO FEMALE WITH DIFFICULTY BREATHING ** SHANKS RD / TESNOW RD ** 05/30/13 13:36 ** 2013-00000126 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 1323 SUMNER RD , ALABAMA - ** 86 YO FEMALE WITH DIFFICULTY BREATHING ** DEAD END / ALLEGHANY RD ** 05/29/13 16:54 ** 2013-00000125 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched Fire Grass ** ** 649 BLOOMINGDALE RD , TONAWANDA IR - ** FIELD ON FIRE ** SANDHILL RD, MEADVILLE RD / POODRY RD ** 05/26/13 10:47 ** 2013-00000124 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** 51 YO Male - semi alert ** No Cross Streets Found ** 05/24/13 15:51 ** 2013-00000123 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - 206 ** DIFF BREATHING ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** DIFF BREATHING ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:AL19 Status:Dispatched EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 7712 SAND HILL RD , TONAWANDA IR - ** MALE WITH ABDOMINAL PAINS ** No Cross Streets Found ** 05/21/13 19:43 ** 2013-00000121 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Stafford Fire Department Inc.
Location: Stafford, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:ST91 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched ** EMD Charlie ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD ** ** ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 06/15/13 00:25 ** 2013-00000107\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 5511 SCHOOL RD , STAFFORD - ** 55YOM TROUBLE BREATHING  ** UNKNOWN / BYRON RD ** 06/11/13 23:31 ** 2013-00000106 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched EMD Delta ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD - ** 54 YOF PSYNCOPE NOT ALERT TROUBLE BREATHING ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 06/11/13 14:46 ** 2013-00000105 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire CO Detector ** ** 8597 PROLE RD , STAFFORD - ** CO DETECTOR  ** UNKNOWN / HORSESHOE LAKE RD ** 06/09/13 11:50 ** 2013-00000104 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Auto ** ** 5729 MAIN RD , STAFFORD - ** CAR FIRE ** FARGO RD, PROLE RD / SANDERS RD ** 06/06/13 23:22 ** 2013-00012599 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Auto ** HANSON AGGREGATES PLANT 464 STAFFORD** 5870 MAIN RD , STAFFORD - ** CAR FIRE ** UNKNOWN / SANDERS RD ** 06/06/13 23:22 ** 2013-00012599 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched Fire Structure ** ** 5942 GRISWOLD RD , STAFFORD - ** SMOKE IN THE RESIDENCE ** CASWELL RD / GODFREYS POND ** 06/05/13 17:29 ** 2013-00000102 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Nat Propane Gas ** ** 7763 BYRON RD , STAFFORD - ** SMELL OF PROPANE GAS INSIDE RESIDENCE ** GRISWOLD RD / WALKERS CORNER RD ** 06/04/13 17:37 ** 2013-00000101 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST94 Status:Dispatched Fire Wire Down ** ** 6488 RANDALL RD , STAFFORD - ** UNKOWN TYPE WIRES DOWN  ** BUCKLEY RD / RICHMOND RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Alpha ** ** 8122 BYRON RD , STAFFORD - ** ** BATAVIA STAFFORD TOWNLINE RD / PROLE ROAD EXT ** 05/28/13 08:21 ** 2013-00000099 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Echo ** Golden Mobile Home Park** 5610 MAIN RD , STAFFORD - LOT 15 ** TROUBLE BREATHING ** UNKNOWN / FARGO RD, PROLE RD ** 05/28/13 01:28 ** 2013-00000098 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched Medical ** Golden Mobile Home Park** 5610 MAIN RD , STAFFORD - LOT 15 ** TROUBLE BREATHING ** UNKNOWN / FARGO RD, PROLE RD ** 05/28/13 01:28 ** 2013-00000098 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Acc PIAA ** ** 6742 EAST BETHANY LE ROY RD , STAFFORD - ** MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN ** COVELL RD / WESTCOTT RD ** 05/27/13 16:15 ** 2013-00000097 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 9134 BATER RD , STAFFORD - PH ** SICK FEMALE ** SWEETLAND RD, COLE RD / MAIN RD, NILESVILLE RD, W MAIN RD ** 05/27/13 09:35 ** 2013-00000096 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 6303 MAIN RD , STAFFORD - APT 8 ** 50YOF CHEST PAIN  ** UNKNOWN / TRANSIT RD, RT 237 ** 05/21/13 13:09 ** 2013-00000095 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched EMD Charlie ** ** 5387 MAIN RD , STAFFORD - ** 61 YOM DIABETIC PROBLEM ** BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD ** 05/20/13 23:15 ** 2013-00000093 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Domestic ** ** 5374 MAIN RD , STAFFORD - ** 18YR OLD FEMALE HITING CALLER ** BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD ** 05/19/13 11:02 ** 2013-00001186 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Delta ** Red Osier** 6492 MAIN RD , STAFFORD - ** TROUBLE BREATHING ** UNKNOWN / ROANOKE RD ** 05/18/13 19:42 ** 2013-00002068 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched Animal Complaint ** ** 6284 MAIN RD , STAFFORD - ** dog bite  ** UNKNOWN / TRANSIT RD, RT 237 ** 05/17/13 11:08 ** 2013-00010862 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched EMD Bravo ** ** 8771 RT 237 , STAFFORD - ** 86 YO MALE WITH HEAD INJURY ** TRANSIT RD, MAIN RD / PRENTICE RD ** 05/14/13 15:03 ** 2013-00000089 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched EMD Alpha ** ** 6180 EAST MORGANVILLE RD , STAFFORD - ** AB PAIN 32YRO MALE ** MORGANVILLE RD / RT 237, RANDALL RD ** 05/14/13 14:11 ** 2013-00000088 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Mutual Aid ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD - ** STAND BY IN QUARTERS ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 05/12/13 15:17 ** 2013-00000087 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 5693 GRISWOLD RD , STAFFORD - ** possible electrical fire in wall ** GODFREYS POND / BYRON RD ** 05/11/13 23:19 ** 2013-00000086 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 5691 ELLICOTT STREET RD , BETHANY - ** SHED FIRE ** PAUL RD / FARGO RD ** 05/11/13 19:00 ** 2013-00000048 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST92 Status:Dispatched Fire Structure ** ** ELLICOTT STREET RD , PAUL RD BETHANY - ** SHED FIRE ** ** 05/11/13 19:00 ** 2013-00000048 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 9615 TRANSIT RD , STAFFORD - ** BARN STRUCK BY LIGHTNING ** WESTACOTT RD / EAST BETHANY LE ROY RD ** 05/10/13 17:40 ** 2013-00000084 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Genesee County Emergency Services
Location: Batavia, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:801 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:GM2 Status:Dispatched Fire HazMat ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** DIESEL FUEL LEAK FROM TRACTOR TRAILER ** CLEVELAND RD / PRATT RD ** 06/07/13 15:31 ** 2013-00000119 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 30 THOMAS AVE , BATAVIA - ** PORCH FIRE ** WASHINGTON AVE, LINCOLN AVE / W MAIN ST ** 06/06/13 22:37 ** 2013-00000840 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:ST95 Status:Dispatched Fire Structure ** ** 5942 GRISWOLD RD , STAFFORD - ** SMOKE IN THE RESIDENCE ** CASWELL RD / GODFREYS POND ** 06/05/13 17:29 ** 2013-00000102 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side - TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:351 Status:Dispatched Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:GM1 Status:At Scene Traffic Stop ** ** CRAIGIE ST , W  MAIN ST LE ROY - ** SCENE MAY BE UNSECURE ** ** 06/03/13 04:50 ** 2013-00000033 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** Oatka Creek Public Fishing Stream NYS DEC** 8116 OATKA TRL , LE ROY - ** MOTORCYCLE VS TREE ** GULLY RD / CIRCULAR HILL RD ** 05/30/13 17:37 ** 2013-00000531 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** 52 YO FEMALE - CHEST PAIN ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** BARN FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 8224 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** ** 6742 EAST BETHANY LE ROY RD , STAFFORD - ** MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN ** COVELL RD / WESTCOTT RD ** 05/27/13 16:15 ** 2013-00000097 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 222 RICHMOND AVE , BATAVIA - ** POSSIBLE ELECTRICAL FIRE OAK LODGE ** BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR ** 05/27/13 01:01 ** 2013-00000778 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 34 WOODROW RD , BATAVIA - ** SMOKE COMING FROM UPSTAIRS WINDOWS ** SOCCIO ST / WEST AVE ** 05/22/13 08:42 ** 2013-00000753 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:751 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched EMD Bravo ** ** 349 WRIGHT RD , ALABAMA - ** 61YO MALE FALLEN FROM LADDER - ANKLE INJURY ** TESNOW RD / DEAD END ** 05/21/13 11:21 ** 2013-00002106 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched EMD Delta ** ** 1376 MAIN RD , PEMBROKE - ** 57 YO MALE POSS HEART ATTACK ** BOYCE RD / ALLEGHANY RD ** 05/21/13 07:48 ** 2013-00000071 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 160 BANK ST , BATAVIA - ** ELECTRICAL FIRE IN BASEMENT ** NORTH ST / WASHINGTON AVE ** 05/20/13 22:40 ** 2013-00000743 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 3827 W  MAIN STREET RD , BATAVIA - ** HOUSE FIRE ** UNKNOWN / COUNTY BLDG ** 05/18/13 20:19 ** 2013-00000105 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched EMD Charlie ** Darien Lake State Park** 10475 HARLOW RD , DARIEN - SITE 34 ** 72 YO FEMALE POSS STROKE ** BROADWAY RD / SUMNER RD, FARGO RD ** 05/18/13 17:34 ** 2013-00000080 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** ** 10 HUTCHINS PL , BATAVIA - ** 12YO FEMALE - FOOT RUN OVER BY FATHER IN DRIVEWAY ** STATE ST / LEWIS PL ** 05/18/13 17:47 ** 2013-00006314 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 109 OAK ST , BATAVIA - ** SMOKE COMING FROM POWER OUTLET ** PICKTHORN DR / CECERE DR ** 05/15/13 15:46 ** 2013-00000713 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 331 MAPLE RD , PEMBROKE - ** MF5 LANDING ZONE AT PEMBROKE FIRE HALL ** S LAKE RD / SIEHL RD, COUNTY LINE RD ** 05/15/13 08:46 ** 2013-00001998 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:MFW Status:Dispatched EMD Charlie ** ** 331 MAPLE RD , PEMBROKE - ** 81YO MALE POSS STROKE ** S LAKE RD / SIEHL RD, COUNTY LINE RD ** 05/15/13 08:46 ** 2013-00001998 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 5693 GRISWOLD RD , STAFFORD - ** possible electrical fire in wall ** GODFREYS POND / BYRON RD ** 05/11/13 23:19 ** 2013-00000086 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Corfu Fire Department
Location: Corfu, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:CO41 Status:Dispatched ** EMD Alpha ** Pembroke Town Park** 8813 ALLEGHANY RD , PEMBROKE ** ** 12YO MALE WITH FACIAL LAC ** MAIN RD / COHOCTON RD ** 06/15/13 12:25 ** 2013-00000067\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched ** Missing Person ** ** 17 W  MAIN ST , CORFU ** ** chidren were picked up from school w/o permission ** PROSPECT ST / E MAIN ST, ALLEGHANY RD ** 06/14/13 17:40 ** 2013-00000534\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 42 ALLEGHANY RD , CORFU - APT 1 ** 54 YOF - CHEST PAINS\n ** W MAIN ST, E MAIN ST / WATER ST ** 06/11/13 01:29 ** 2013-00000065 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 42 ALLEGHANY RD , CORFU - APT 1 ** ** W MAIN ST, E MAIN ST / WATER ST ** 06/11/13 01:29 ** 2013-00000065 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 49 ALLEGHANY RD , CORFU - ** GREEN NEON IN LOT 26 YO MALE FEELS LIKE HE IS GOING TO PASS OUT ** W MAIN ST, E MAIN ST / WATER ST ** 06/09/13 20:43 ** 2013-00000064 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Mutual Aid ** CORFU FIRE DEPT.** 116 E  MAIN ST , CORFU - ** TO STANDBY IN QUARTERS ** GENESEE ST / THOMPSON DR ** 06/07/13 16:48 ** 2013-00000063 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 31 E  MAIN ST , CORFU - ** 31yo fml chest pain  ** MAPLE AVE / LAWRENCE AVE ** 06/06/13 07:22 ** 2013-00000062 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 31 E  MAIN ST , CORFU - ** ** MAPLE AVE / LAWRENCE AVE ** 06/06/13 07:22 ** 2013-00000062 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - ** SEMI VS CAR UNK INJ  ** FIELDCREST DR / PROSPECT ST ** 06/04/13 16:57 ** 2013-00000061 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Delta ** Genesee Heights Estates Mobile Home Park** 66 W MAIN ST , CORFU - LOT 9 ** 38WEEK PREGNANT FML - 6th CHILD - 2 MINS APART  ** GENESEE ST / FIELDCREST DR ** 05/30/13 14:00 ** 2013-00000060 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 955 GENESEE ST , PEMBROKE - ** ** GENESEE HGTS / ETZOLD RD ** 05/28/13 10:13 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Bravo ** ** 735 GENESEE ST , PEMBROKE - APT 2 ** MENTAL HEALTH EVALUATION ** FARGO RD / ETZOLD RD ** 05/22/13 01:58 ** 2013-00000058 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 31 E MAIN ST , CORFU - LOWER ** 30 YO FEMALE HIGH HEART RATE - AND CHEST PAIN ** MAPLE AVE / LAWRENCE AVE ** 05/18/13 16:35 ** 2013-00000057 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Delta ** ** 31 E MAIN ST , CORFU - LOWER ** ** MAPLE AVE / LAWRENCE AVE ** 05/18/13 16:35 ** 2013-00000057 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:453 Status:Dispatched EMD Bravo ** PEMBROKE TOWN PARK** 8813 ALLEGHANY RD , PEMBROKE - ** arm laceration  ** MAIN RD / COHOCTON RD ** 05/18/13 15:35 ** 2013-00002061 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** CORFU FIRE DEPT.** 116 E  MAIN ST , CORFU - ** 51YO MALE FEELS FAINT/TROUBLE BREATHING ** GENESEE ST / THOMPSON DR ** 05/18/13 15:31 ** 2013-00000055 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO43 Status:Dispatched Alarm Fire ** Pembroke Primary School** 2486 MAIN RD , PEMBROKE - ** GENERAL FIRE ALARM ** WEST AVE / INDIAN FALLS RD ** 05/17/13 14:38 ** 2013-00000100 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 10271 ALLEGHANY RD , DARIEN - ** 2 CAR  W AIR BAG DEPLOYMENT  ** SUMNER RD / BROADWAY RD ** 05/14/13 13:07 ** 2013-00010605 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 955 GENESEE ST , PEMBROKE - ** 73 YO FEMALE DIABETIC PROBLEM ** GENESEE HGTS / ETZOLD RD ** 05/07/13 15:21 ** 2013-00000052 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Alarm Fire ** CORFU MEADOWS APARTMENTS** 53 W  MAIN ST , CORFU - ** COMMERCIAL FIRE ALARM ** FIELDCREST DR / PROSPECT ST ** 05/06/13 20:09 ** 2013-00000051 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Alpha ** ** 9 MAPLE AVE , CORFU - SIDE ** ABDOMINAL PAIN ** E MAIN ST / WATER ST ** 05/03/13 05:17 ** 2013-00001812 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 1 CORFU PLZ , CORFU - ** FIRE IN THE DRYER ** E MAIN ST / ALLEGHANY RD ** 05/01/13 08:56 ** 2013-00000049 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Acc PIAA ** ** 328 MAIN RD , PEMBROKE - ** 2 CAR PIAA - POSS A HEAD ON\n ** UNKNOWN / RAMP ** 04/30/13 14:27 ** 2013-00000058 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 352 MAIN RD , PEMBROKE - ** 2 CAR PIAA - POSS A HEAD ON\n ** UNKNOWN / RAMP ** 04/30/13 14:27 ** 2013-00000058 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Alpha ** ** 8894 ALLEGHANY RD , PEMBROKE - ** ELDERLY FEMALE WITH THE ILLNESS ** COHOCTON RD / MAIN RD ** 04/28/13 16:49 ** 2013-00000047 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Investigation ** ** 30 E  MAIN ST , CORFU - ** SMOKE DETECTOR SOUNDING INSIDE ** MAPLE AVE / LAWRENCE AVE ** 04/28/13 08:09 ** 2013-00000046 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:453 Status:Dispatched EMD Delta ** ** 5 E  MAIN ST , CORFU - ** 39 YOF FEELING FAINT ** CORFU PLZ / W MAIN ST, ALLEGHANY RD ** 04/26/13 23:26 ** 2013-00001702 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** 50 YO M WITH A POSSIBLE STROKE  ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** 500 ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 8880 ALLEGHANY RD , PEMBROKE - ** 61 Y/O MALE ABDOMINAL PAINS ** COHOCTON RD / MAIN RD ** 04/21/13 11:09 ** 2013-00000043 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched Alarm EMS ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - APT 111 ** MEDICAL ALARM ACTIVATION, UNABLE TO MAKE CONTACT ** FIELDCREST DR / PROSPECT ST ** 04/19/13 18:59 ** 2013-00000042 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Alpha ** ** 9368 ELLINWOOD RD , PEMBROKE - ** 91 YOF PAIN IN RIGHT FOOT CANT WALK  ** SIMONDS RD, BROWN RD / STONEY LONESOME RD ** 04/19/13 12:40 ** 2013-00000041 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 735 GENESEE ST , PEMBROKE - APT 4 ** BACK OF HOUSE FIRE\n ** FARGO RD / ETZOLD RD ** 04/18/13 23:20 ** 2013-00000040 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 735 GENESEE ST , PEMBROKE - APT 4 ** ** FARGO RD / ETZOLD RD ** 04/18/13 23:20 ** 2013-00000040 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched Fire Auto ** TA TRAVEL CENTER** 8420 ALLEGHANY RD , PEMBROKE - ** ACROSS FROM LOC 06 FORD F150 ON FIRE CAN SEE FLAMES  ** EXIT 48A RAMP / I 90 ** 04/17/13 09:25 ** 2013-00000050 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 955 GENESEE ST , PEMBROKE - ** 73YO FEMALE TROUBLE BREATHING/UNABLE TO AMBULATE ** GENESEE HGTS / ETZOLD RD ** 04/13/13 06:51 ** 2013-00000038 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Wire Down ** ** 9414 SNIPERY RD , PEMBROKE - ** TREE BROUGHT WIRES DOWN - WIRES ARCHING ** UNKNOWN / RICHLEY RD ** 04/11/13 18:26 ** 2013-00000037 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 856 GENESEE ST , PEMBROKE - ** CHIMNEY FIRE ** ETZOLD RD / FARGO RD ** 04/05/13 23:34 ** 2013-00000036 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched Assist Citizen ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - 105 ** ASSIST WITH TURNING ON OXYGEN ** FIELDCREST DR / PROSPECT ST ** 04/03/13 02:05 ** 2013-00000035 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 998 MAIN RD , PEMBROKE - ** CAR INTO POLE ** LOVERS LANE RD / BRICK HOUSE CORNERS DR ** 04/03/13 00:55 ** 2013-00000039 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 42 ALLEGHANY RD , CORFU - Apt 3 ** 18 YO FEMALE BLEEDING FROM FOOT ** W MAIN ST, E MAIN ST / WATER ST ** 03/31/13 20:41 ** 2013-00000033 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Delta ** ** 42 ALLEGHANY RD , CORFU - Apt 3 ** ** W MAIN ST, E MAIN ST / WATER ST ** 03/31/13 20:41 ** 2013-00000033 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Bravo ** ** 2082 GENESEE ST , PEMBROKE - ** 17 MONTH OLD BOY FALLEN ** ANGLING RD / READ RD ** 03/30/13 15:58 ** 2013-00000032 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Omega ** ** 2104 ANGLING RD , PEMBROKE - ** LIFTING ASSISTANCE ** UNKNOWN / NORTH ANGLING RD ** 03/28/13 15:28 ** 2013-00000031 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 8880 ALLEGHANY RD , PEMBROKE - ** 61 YOM ABDOMINAL PAINS  ** COHOCTON RD / MAIN RD ** 03/28/13 13:48 ** 2013-00000030 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 1606 BROADWAY RD , DARIEN - ** COMMERCIAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Fire Structure ** ** 1606 BROADWAY RD , DARIEN - ** COMMERCIAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO42 Status:Dispatched Fire Structure ** ** 1568 BROADWAY RD , DARIEN - ** METAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - APT 205 ** 54 YO MALE WITH ABDOMINAL PAINS ** FIELDCREST DR / PROSPECT ST ** 03/25/13 22:02 ** 2013-00000028 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 8834 ALLEGHANY RD , PEMBROKE - ** 85 YO FEMALE WITH ABDOMINAL PAINS ** MAIN RD / COHOCTON RD ** 03/21/13 15:12 ** 2013-00000027 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Alpha ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - apt 105 ** 52 YO MALE GENERAL ILLNES\n ** FIELDCREST DR / PROSPECT ST ** 03/21/13 14:57 ** 2013-00000026 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 5 THOMPSON DR , CORFU - ** 83 YO FEMALE WITH CHEST PAINS ** LONGS LN / E MAIN ST ** 03/18/13 15:34 ** 2013-00000025 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - 109 ** 55YR OLD FEMALE DOWN ** FIELDCREST DR / PROSPECT ST ** 03/11/13 09:31 ** 2013-00000024 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Bravo ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - 106 ** 92 YOF FELL WITH FACIAL INJURY  ** FIELDCREST DR / PROSPECT ST ** 03/07/13 09:05 ** 2013-00000023 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire CO Detector ** ** 43 LONGS LN , CORFU - ** CO ALARM NO ILL EFFECTS ** DEAD END / THOMPSON DR ** 03/04/13 09:20 ** 2013-00000022 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** Genesee Heights Estates Mobile Home Park** 66 W MAIN ST , CORFU - LOT 13 ** scene is not secure - 47 YO Male intential Overdose ** GENESEE ST / FIELDCREST DR ** 03/01/13 17:09 ** 2013-00004559 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CO43 Status:Dispatched Fire Structure ** ** 1880 SHARRICK RD , DARIEN - ** BARN FIRE ** HARPER RD / COLBY RD ** 02/27/13 15:54 ** 2013-00000027 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:451 Status:Dispatched Fire CO Detector ** ** 2141 ANGLING RD , PEMBROKE - ** CARBON MONOXIDE DECTOR GOING OFF NO ILL EFFECTS ** UNKNOWN / NORTH ANGLING RD ** 02/23/13 14:34 ** 2013-00000019 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: City of Batavia Fire Department
Location: Batavia, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:CB11 Status:Dispatched ** Fire Other ** ** 63 WALNUT ST , BATAVIA ** ** MAN IN THE WATER - STILL MOVING ** WALNUT PL / LAW ST ** 06/15/13 09:00 ** 2013-00007638\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched ** Alarm Fire ** ** 16 BANK ST , BATAVIA ** ** GENERAL FIRE ALARM ** ALVA PL / BATAVIA CITY CTR ** 06/15/13 06:36 ** 2013-00000894\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 254 STATE ST , BATAVIA ** ** 79 yo fm diff breathing ** MACARTHUR DR / DENIO ST ** 06/15/13 00:49 ** 2013-00002487\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 141 STATE ST , BATAVIA ** LOWER ** ** PARK AVE / LEWIS PL ** 06/14/13 23:11 ** 2013-00002483\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 10 CENTRAL AVE , BATAVIA ** ** Trouble Breathing ** JACKSON ST / PRINGLE AVE ** 06/14/13 22:56 ** 2013-00002482\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** Alarm EMS ** Monsignor Kirby Apartments** 203 OAK ST , BATAVIA ** 205 ** unknown problem ** NOONAN DR / EXIT 48 ON RAMP ** 06/14/13 20:22 ** 2013-00002478\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched ** Fire Auto ** ** 3 ELM ST , BATAVIA ** ** Car Fire ** FISHER PK / HARVESTER AVE, E MAIN ST ** 06/14/13 15:26 ** 2013-00000888\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ST JOSEPH PRESCHOOL & KINDERGARTEN** 2 SUMMIT ST , BATAVIA ** ** ** WASHINGTON AVE / LIBERTY ST, E MAIN ST ** 06/14/13 14:26 ** 2013-00002474\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB15 Status:Dispatched ** Fire Service Call ** ** 185 VINE ST , BATAVIA ** ** WATER IN THE CELLAR ** NORTH ST / EVERGREEN DR ** 06/14/13 11:34 ** 2013-00000886\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 16 EDWARD ST , BATAVIA ** ** ** WALLACE ST / CEDAR ST, DEWITT REC AREA SOUTH PARKING LOT ** 06/14/13 08:38 ** 2013-00002471\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched ** Alarm Fire ** ** 222 RICHMOND AVE , BATAVIA ** ** GENERAL FIRE ALARM B6  ** BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR ** 06/14/13 07:54 ** 2013-00000884\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 10 HULL PK , BATAVIA ** ** ** DEAD END / ROSS ST ** 06/14/13 04:08 ** 2013-00002466\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 130 W  MAIN ST , BATAVIA ** ** ** ELLICOTT AVE / THOMAS AVE ** 06/14/13 01:59 ** 2013-00002464\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** Washington Towers** 1 STATE ST , BATAVIA ** APT 621 ** ** WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL ** 06/13/13 23:42 ** 2013-00002463\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Bravo ** ** 35 CENTRAL AVE , BATAVIA ** ** 83 YO MALE FALLEN WITH UNKNOWN INJURY ** PRINGLE AVE / LIBERTY ST ** 06/13/13 20:33 ** 2013-00002461\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB15 Status:Dispatched ** Fire Service Call ** ** 33 CENTRAL AVE , BATAVIA ** ** CELLAR PUMP DETAIL ** PRINGLE AVE / JACKSON ST ** 06/13/13 20:07 ** 2013-00000879\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Alpha ** The Manor House** 427 E  MAIN ST , BATAVIA ** ** 95 YO FEMALE WITH CHOKING PARTIAL OBSTRUCTION ** MASSE PL, VINE ST / HARVESTER AVE, ELM ST ** 06/13/13 18:52 ** 2013-00002458\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 16 WOOD ST , BATAVIA ** LOWER APT ** 37 YO MALE WITH CHEST PAINS ** PRINGLE AVE / JACKSON ST ** 06/13/13 17:55 ** 2013-00002457\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:At Scene Fire Investigation ** ** 16 DENIO ST , BATAVIA - ** ** BANK ST / STATE ST ** 06/11/13 20:11 ** 2013-00000867 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** ** 75 S  MAIN ST , BATAVIA - ** 48 YO FEMALE CHEST PAIN ** BROOKLYN AVE / OAK ST ** 06/11/13 17:20 ** 2013-00002432 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB11 Status:Dispatched Fire Wire Down ** ** 34 PROSPECT AVE , BATAVIA - ** WIRE DOWN ON CAR - POSSIBLY A CABLE OR TELEPHONE  ** RICHMOND AVE / MIX PL ** 06/11/13 14:01 ** 2013-00000865 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 256 EAST AVE , BATAVIA - ** 58 YOM TROUBLE BREATHING ** EUGENE ST / CLINTON ST, TROJAN CIR ** 06/11/13 04:41 ** 2013-00002425 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Delta ** ** 256 EAST AVE , BATAVIA - ** ** EUGENE ST / CLINTON ST, TROJAN CIR ** 06/11/13 04:41 ** 2013-00002425 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Genesee Park Place Apartments** 145 PARK RD , BATAVIA - 224 ** 67 YOM NEEDS HELP\n ** RICHMOND AVE / VETERANS MEMORIAL DR ** 06/11/13 03:18 ** 2013-00002424 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** Genesee Park Place Apartments** 145 PARK RD , BATAVIA - 224 ** ** RICHMOND AVE / VETERANS MEMORIAL DR ** 06/11/13 03:18 ** 2013-00002424 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB16 Status:Dispatched EMD Bravo ** Southside Deli** 300 ELLICOTT ST , BATAVIA - ** ADULT MALE FALLEN WITH A HEAD INUURY ** LIBERTY ST / GOADE PK ** 06/10/13 21:37 ** 2013-00000862 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** Washington Towers** 1 STATE ST , BATAVIA - APT 421 ** ADULT FEMALE WITH DIFFICULTY BREATHING ** WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL ** 06/10/13 21:23 ** 2013-00002420 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Graham Corporation** 20 FLORENCE AVE , BATAVIA - ** HEAD INJ ** WEBSTER AVE, HOWARD ST / CEDAR ST ** 06/10/13 14:50 ** 2013-00002417 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** ** 24 FLORENCE AVE , BATAVIA - ** HEAD INJ ** WEBSTER AVE, HOWARD ST / CEDAR ST ** 06/10/13 14:50 ** 2013-00002417 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:CB17 Status:Dispatched EMD Delta ** Northside Meadows Apartments** 335 BANK ST , BATAVIA - 34B ** DIFF BREATHING ** ROSS ST / CHANDLER AVE ** 06/10/13 12:24 ** 2013-00002415 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: Byron Fire Department
Location: Byron, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) EMD Delta ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M32 ** ADULT FEMALE ABDOMINAL PAIN ** IVISON RD / HESSENTHALER RD ** 06/08/13 16:04 ** 2013-00000080 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Delta ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M32 ** ** IVISON RD / HESSENTHALER RD ** 06/08/13 16:04 ** 2013-00000080 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7516 BYRON HOLLEY RD , BYRON - ** 76 YOF POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 7516 BYRON HOLLEY RD , BYRON - ** POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Alpha ** ** 7516 BYRON HOLLEY RD , BYRON - ** POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched Alarm Fire ** Byron Post Office** 6332 TOWNLINE RD , BYRON - ** GENERAL ALARM \n ** MCELVER ST / BYRON HOLLEY RD ** 06/06/13 14:25 ** 2013-00000078 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 6870 BYRON HOLLEY RD , BYRON - ** 67yo fml tx breathing  ** TOWNLINE RD / TERRY ST ** 06/03/13 14:05 ** 2013-00002317 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Medical ** ** 6870 BYRON HOLLEY RD , BYRON - ** 67yo fml tx breathing  ** TOWNLINE RD / TERRY ST ** 06/03/13 14:05 ** 2013-00002317 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Mental ** ** 5886 BIRD RD , BYRON - ** SUICIDAL FEMALE - SCENE SECURE ** DEAD END / EAST BIRD RD ** 06/01/13 16:43 ** 2013-00000076 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Check Welfare ** ** 7078 BYRON RD , BYRON - ** VOLUNTARY MENTAL HEALTH TRANSPORT  ** COCKRAM RD / BYRON ELBA RD ** 05/30/13 11:36 ** 2013-00000075 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:402 Status:Dispatched Alarm Fire ** Byron Post Office** 6332 TOWNLINE RD , BYRON - ** GENERAL FIRE ALARM  ** MCELVER ST / BYRON HOLLEY RD ** 05/28/13 10:38 ** 2013-00000074 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** ** 6369 TOWNLINE RD , BYRON - ** 11 MONTH OLD HAD A SEIZURE ** MCELVER ST / SWAMP RD ** 05/28/13 04:28 ** 2013-00000073 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 6213 NORTH BYRON RD , BYRON - ** ** BYRON HOLLEY RD / SEARLS RD ** 05/21/13 19:14 ** 2013-00000072 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** Byron Fire Dept.** 6357 TOWNLINE RD , BYRON - ** ADULT MALE WITH A SEIZURE ** MCELVER ST / SWAMP RD ** 05/16/13 19:22 ** 2013-00000071 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - SITE M7 ** 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW  ** IVISON RD / HESSENTHALER RD ** 05/16/13 14:16 ** 2013-00000070 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M7 ** 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW  ** IVISON RD / HESSENTHALER RD ** 05/16/13 14:16 ** 2013-00000070 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Mental ** ** 7655 BYRON HOLLEY RD , BYRON - ** 16 YO FEMALE ATTEMPTED SUICIDE OVER THE WEEKEND ** RT 237 / FREEMAN RD ** 05/13/13 19:08 ** 2013-00010564 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 14 BENNETT AVE , OAKFIELD - ** 88 YO FEAMLE DIEBETIC PROBLEM ** N MAIN ST / N PEARL ST ** 05/12/13 14:46 ** 2013-00000113 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched Alarm Fire ** ** 7529 MECHANIC ST , BYRON - ** ALARM ON HOUSE/SMELLS NATURAL GAS ** E MAIN ST / BYRON HOLLEY RD ** 05/07/13 23:06 ** 2013-00000010 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Alpha ** ** 6678 FREEMAN RD , BYRON - ** 89 YO FEMALE SEVERE BACK PAIN ** IVISON RD / COWARD RD ** 05/07/13 15:37 ** 2013-00000066 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched EMD Alpha ** ** 6945 BYRON RD , BYRON - ** 49 yo fm sever back pain ** TOWER HILL RD / BYRON ELBA RD ** 05/05/13 20:28 ** 2013-00000065 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Alarm EMS ** ** 5575 COCKRAM RD , BYRON - ** 87 YO MALE TX BREATHING ** TRANSIT RD / BANK STREET RD ** 05/05/13 11:16 ** 2013-00000064 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY36 Status:Dispatched Acc PIAA ** ** 6920 TRANSIT RD , ELBA - ** ATV ACCIDENT ** BYRON ELBA RD, FORD RD / BRIDGE RD, CHAPELL RD ** 05/04/13 16:47 ** 2013-00000052 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched Fire Drill ** Elba Central School** 57 S  MAIN ST , ELBA - ** ELBA PROM DRILL ** UNKNOWN / WEST AVE ** 05/01/13 08:22 ** 2013-00001781 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Mental ** ** 6479 NORTH BERGEN RD , BYRON - ** MENTAL HEALTH TX - CANCEL REQ PER DEPUTY ** BIRD RD / BYRON HOLLEY RD ** 04/28/13 21:58 ** 2013-00000061 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched Mental ** ** 6479 NORTH BERGEN RD , BYRON - ** MENTAL HEALTH TX ** BIRD RD / BYRON HOLLEY RD ** 04/28/13 21:58 ** 2013-00000061 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:401 Status:Dispatched Fire Grass ** ** 7257 BEAVER MEADOW RD , BYRON - ** CONTROLLED BURN OUT OF CONTROL ** COCKRAM RD / LYMAN RD ** 04/28/13 11:48 ** 2013-00000009 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Delta ** ** 7588 BYRON RD , BYRON - ** 91 YO FEMALE CHEST PAIN ** WALKERS CORNER RD / GRISWOLD RD ** 04/27/13 20:10 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Delta ** ** 7588 BYRON RD , BYRON - ** ** WALKERS CORNER RD / GRISWOLD RD ** 04/27/13 20:10 ** 2013-00000059 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 121 STATE ST , BATAVIA - SIDE ** 88YO FEMALE CONFUSED/FEVER/VOMITING ** HUTCHINS PL / LEWIS PL ** 04/27/13 15:50 ** 2013-00000613 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

Contact: Active911
Agency name: LeRoy Ambulance Service
Location: Le Roy, NY, United States
Sender: 911center@co.genesee.ny.us

(Dispatch) Unit:LA01 Status:Dispatched ** EMD Charlie ** ** 10 MUNSON ST , LE ROY ** ** ** WOLCOTT ST / GILBERT ST ** 06/15/13 13:46 ** 2013-00000591\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** EMD Delta ** McDonald's LeRoy** 67 MAIN ST , LE ROY ** ** 66 YO FML TX BREATHING ** W MAIN ST, CLAY ST, LAKE ST / BANK ST ** 06/15/13 12:11 ** 2013-00000590\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** EMS Mutual Aid ** ** 2985 MAIN ST , CALEDONIA ** ** SIDE PAIN - VOMITING BLOOD ** LEICESTER ST / CALEDONIA LEROY RD, BORST COTTAGE LN ** 06/15/13 06:54 ** 2013-00000589\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** Check Welfare ** ** 48 W  MAIN ST , LE ROY ** ** MALE DOWN ROADSIDE  ** CRAIGIE ST / GILBERT ST ** 06/15/13 03:13 ** 2013-00001884\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** EMD Bravo ** LeRoy Manor** 8678 LAKE STREET RD , LE ROY ** ** 57 YO FM head injury from fall ** RED MILL RD / RANDALL RD, NORTH STREET RD ** 06/13/13 21:23 ** 2013-00000587\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** EMD Alpha ** Royal Apartments** 103 W MAIN ST , LE ROY ** BLDG 6 APT 2 ** LIFT ASSIST ONLY ** ROYAL DR / WEST AVE ** 06/13/13 19:07 ** 2013-00000586\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched ** EMD Delta ** ** 37 LATHROP AVE , LE ROY ** ** bleeding from noise ** GENESEE PK / E MAIN ST ** 06/13/13 11:35 ** 2013-00000585\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Alpha ** ** 93 LAKE ST , LE ROY - LOWER ** 63 YO FEMALE LEG PAIN ** WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD ** 06/11/13 21:52 ** 2013-00000581 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** ** 93 LAKE ST , LE ROY - LOWER ** 63 YO FEMALE LEF PAIN ** WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD ** 06/11/13 21:52 ** 2013-00000581 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Mental ** ** 72 W  MAIN ST , LE ROY - ** MENTAL HEALTH STAND BY ** LENT AVE / ROYAL DR ** 06/11/13 20:14 ** 2013-00000580 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched Mental ** ** 72 W  MAIN ST , LE ROY - ** MENTAL HEALTH STAND BY ** LENT AVE / ROYAL DR ** 06/11/13 20:14 ** 2013-00000580 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA02 Status:Dispatched EMD Charlie ** ** 10 MUNSON ST , LE ROY - UNK ** 70YO MALE ALTERED MENTAL STATUS ** WOLCOTT ST / GILBERT ST ** 06/11/13 09:36 ** 2013-00000579 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** Royal Apartments** 103 W MAIN ST , LE ROY - BLDG 6 APT 2 ** 87 YOF REQ LIFT ASSISTANCE ** ROYAL DR / WEST AVE ** 06/11/13 07:13 ** 2013-00000578 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Echo ** ** 124 E  MAIN ST , LE ROY - ** 85 YOF NOT BREATHING ** EAST AVE / E MAIN RD ** 06/11/13 06:38 ** 2013-00000577 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Echo ** ** 124 E  MAIN ST , LE ROY - ** ** EAST AVE / E MAIN RD ** 06/11/13 06:38 ** 2013-00000577 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** LeRoy Manor** 8678 LAKE STREET RD , LE ROY - ** 53 YO MALE WITH ILLNESS ** RED MILL RD / RANDALL RD, NORTH STREET RD ** 06/10/13 19:52 ** 2013-00000018 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA47 Status:Dispatched EMD Alpha ** ** 8003 E MAIN RD , LE ROY - RIGHT SIDE ** 73 YO FEMALE WITH HIP INJURY ** CIRCULAR HILL RD / LINWOOD RD ** 06/10/13 19:32 ** 2013-00000575 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched Mental ** ** BANK ST , MAIN ST LE ROY - ** MENTAL HEALTH TX ** ** 06/09/13 21:56 ** 2013-00000574 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 3 TOUNTAS AVE , LE ROY - ** MALE SUBJECT - CHEST PAIN ** DEAD END / GILBERT ST ** 06/09/13 18:34 ** 2013-00000573 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) EMD Charlie ** ** 3 TOUNTAS AVE , LE ROY - ** MALE SUBJECT - CHEST PAIN ** DEAD END / GILBERT ST ** 06/09/13 18:34 ** 2013-00000573 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Charlie ** ** <UNKNOWN> , - ** MALE SUBJECT - CHEST PAIN ** ** 06/09/13 18:34 ** 2013-00000573 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMS Mutual Aid ** ** 1276 QUARRY RD , CALEDONIA - ** 83 yo male - multiple bee stings - trouble breathing ** AVERILL RD / TELEPHONE RD ** 06/09/13 18:00 ** 2013-00000572 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA02 Status:Dispatched EMD Echo ** ** 21 CRAIGIE ST , LE ROY - ** 86 yo MALE - FAINTLY BREATHING ** MYRTLE ST / W MAIN ST ** 06/09/13 11:19 ** 2013-00000571 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Delta ** ** 28 LINCOLN AVE , LE ROY - ** 26 YO FEMALE WITH SYNCOPAL EPISODE ** SOUTH ST / WOLCOTT ST ** 06/07/13 21:14 ** 2013-00000570 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  
(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** ** 7285 GRISWOLD RD , LE ROY - PH ** 14 YO SUBJECT WITH CHEST PAINS ** WEST BERGEN RD / HEWES RD ** 06/07/13 20:26 ** 2013-00000569 **\n\n\nCONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  

*/

public class NYGeneseeCountyParserTest extends BaseParserTest {
  
  public NYGeneseeCountyParserTest() {
    setParser(new NYGeneseeCountyParser(), "GENESEE COUNTY", "NY");
  }
  
  @Test
  public void testSteveSharpe() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH Unit:GS94 Status:Dispatched ** Test Call ** GCSO** 165 PARK RD , BATAVIA ** back room ** INITIAL DISPATCH ** VETERANS MEMORIAL DR / RICHMOND AVE ** 06/13/13 11:18 ** 2013-00013125 TXT STOP to opt-out\r",
        "UNIT:GS94",
        "CALL:Test Call - INITIAL DISPATCH",
        "PLACE:GCSO",
        "ADDR:165 PARK RD",
        "CITY:BATAVIA",
        "APT:back room",
        "X:VETERANS MEMORIAL DR / RICHMOND AVE",
        "DATE:06/13/13",
        "TIME:11:18",
        "ID:2013-00013125");

  }
  
  @Test
  public void testRyan() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH Unit:AX10 Status:Dispatched ** Acc PIAA ** ** BROADWAY RD , MAIN ST ALEXANDER ** ** CAR DEER M INJ E OF 98 ON RT 20 ** ** 06/16/13 14:",
        "UNIT:AX10",
        "CALL:Acc PIAA - CAR DEER M INJ E OF 98 ON RT 20",
        "ADDR:BROADWAY RD & MAIN ST",
        "CITY:ALEXANDER",
        "DATE:06/16/13",
        "TIME:14:");

  }
  
  @Test
  public void testStevenSmelski() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH ** Fire Auto ** 401.3 RT 90 E** , CORFU ** ** TIRE FIRE ON TRAILER ** I 90, ALLEGHANY RD / EXIT 48A RAMP, ALLEGHANY RD ** 07/11/13 16:29 ** 2013-00000104 TXT STOP to opt-out  4 min??",
        "CALL:Fire Auto - TIRE FIRE ON TRAILER",
        "PLACE:401.3 RT 90 E",
        "CITY:CORFU",
        "X:I 90, ALLEGHANY RD / EXIT 48A RAMP, ALLEGHANY RD",
        "DATE:07/11/13",
        "TIME:16:29",
        "ID:2013-00000104");

    doTest("T2",
        "GENESEE COUNTY DISPATCH ** EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA ** LOT 27 ** UNC MALE SICK ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 07/11/13 14:22 ** 2013-00000152 TXT STOP to opt-out",
        "CALL:EMD Delta - UNC MALE SICK",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 27",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:07/11/13",
        "TIME:14:22",
        "ID:2013-00000152");

    doTest("T3",
        "GENESEE COUNTY DISPATCH Unit:EP57 Status:Dispatched ** Alarm EMS ** ** 1838 MAIN RD , PEMBROKE ** ** EMS ALARM UNK ** CLEVELAND RD / BOYCE RD ** 07/09/13 12:30 * 2013-00000150 TXT STOP to opt-out",
        "UNIT:EP57",
        "CALL:Alarm EMS - EMS ALARM UNK",
        "ADDR:1838 MAIN RD",
        "CITY:PEMBROKE",
        "X:CLEVELAND RD / BOYCE RD",
        "DATE:07/09/13",
        "TIME:12:30 * 2013-00000150");

  }
  
  @Test
  public void testGeneralAlert() {

    doTest("T1",
        "(Dispatch) RAILROAD CROSSINGS CLOSED FROM WORTENDYKE WEST BY CSX - WONT BE IN SERVICE TILL SOMETIME TOMORROW AT EARLIEST\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:GENERAL ALERT",
        "PLACE:RAILROAD CROSSINGS CLOSED FROM WORTENDYKE WEST BY CSX - WONT BE IN SERVICE TILL SOMETIME TOMORROW AT EARLIEST");

    doTest("T2",
        "(Dispatch) All CSX RR crossings are now open.\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:GENERAL ALERT",
        "PLACE:All CSX RR crossings are now open.");

    doTest("T3",
        "(Dispatch) Railroad Crossing update - Per CSX  Colby Rd and Fargo Rd are OPEN - Estimating other 3 will be open by this afternoon - No work scheduled for Upton and Donahue that they are aware of\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:GENERAL ALERT",
        "PLACE:Railroad Crossing update - Per CSX  Colby Rd and Fargo Rd are OPEN - Estimating other 3 will be open by this afternoon - No work scheduled for Upton and Donahue that they are aware of");

  }
  
  @Test
  public void testEastPembrokeVolunteerFireDept() {

    doTest("T1",
        "(Dispatch) ** EMD Charlie ** ** 2637 BROWN RD , BATAVIA ** ** 73 YOF CHEST PAINS ** HALSTEAD RD, WILKINSON RD / RIDGE RD ** 06/14/13 06:34 ** 2013-00000126\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 73 YOF CHEST PAINS",
        "ADDR:2637 BROWN RD",
        "CITY:BATAVIA",
        "X:HALSTEAD RD, WILKINSON RD / RIDGE RD",
        "DATE:06/14/13",
        "TIME:06:34",
        "ID:2013-00000126");

    doTest("T2",
        "(Dispatch) Unit:EP57 Status:Dispatched ** EMD Charlie ** ** 2637 BROWN RD , BATAVIA ** ** ** HALSTEAD RD, WILKINSON RD / RIDGE RD ** 06/14/13 06:34 ** 2013-00000126\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie",
        "ADDR:2637 BROWN RD",
        "CITY:BATAVIA",
        "X:HALSTEAD RD, WILKINSON RD / RIDGE RD",
        "DATE:06/14/13",
        "TIME:06:34",
        "ID:2013-00000126");

    doTest("T3",
        "(Dispatch) Unit:EP57 Status:Dispatched ** EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA ** LOT 29A ** 76YOF - CONFUSION / FEVER  ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 06/13/13 11:17 ** 2013-00000125\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - 76YOF - CONFUSION / FEVER",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 29A",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:06/13/13",
        "TIME:11:17",
        "ID:2013-00000125");

    doTest("T4",
        "(Dispatch) EMD Alpha ** ** 8495 LOVERS LANE RD , BATAVIA - ** BACK PAIN ** SOUTH MAIN STREET RD / PEARL STREET RD ** 06/10/13 07:01 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Alpha - BACK PAIN",
        "ADDR:8495 LOVERS LANE RD",
        "CITY:BATAVIA",
        "X:SOUTH MAIN STREET RD / PEARL STREET RD",
        "DATE:06/10/13",
        "TIME:07:01",
        "ID:2013-00000123");

    doTest("T5",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Alpha ** ** 8495 LOVERS LANE RD , BATAVIA - ** BACK PAIN ** SOUTH MAIN STREET RD / PEARL STREET RD ** 06/10/13 07:01 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Alpha - BACK PAIN",
        "ADDR:8495 LOVERS LANE RD",
        "CITY:BATAVIA",
        "X:SOUTH MAIN STREET RD / PEARL STREET RD",
        "DATE:06/10/13",
        "TIME:07:01",
        "ID:2013-00000123");

    doTest("T6",
        "(Dispatch) EMD Charlie ** ** 2799 STEGMAN RD , BATAVIA - ** 54 YO FEMALE DIABETIC PROBLEM ** POWERS RD / MILLER RD ** 06/08/13 21:40 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 54 YO FEMALE DIABETIC PROBLEM",
        "ADDR:2799 STEGMAN RD",
        "CITY:BATAVIA",
        "X:POWERS RD / MILLER RD",
        "DATE:06/08/13",
        "TIME:21:40",
        "ID:2013-00000122");

    doTest("T7",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 2799 STEGMAN RD , BATAVIA - ** ** POWERS RD / MILLER RD ** 06/08/13 21:40 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie",
        "ADDR:2799 STEGMAN RD",
        "CITY:BATAVIA",
        "X:POWERS RD / MILLER RD",
        "DATE:06/08/13",
        "TIME:21:40",
        "ID:2013-00000122");

    doTest("T8",
        "(Dispatch) Unit:EP60 Status:Dispatched Fire Service Call ** ** 2785 PRATT RD , BATAVIA - ** WATER IN BASEMENT ** POWERS RD / APPLE GROVE MOBILE HOME PK ** 06/08/13 15:23 ** 2013-00000121 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP60",
        "CALL:Fire Service Call - WATER IN BASEMENT",
        "ADDR:2785 PRATT RD",
        "CITY:BATAVIA",
        "X:POWERS RD / APPLE GROVE MOBILE HOME PK",
        "DATE:06/08/13",
        "TIME:15:23",
        "ID:2013-00000121");

    doTest("T9",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** ** 8190 NORTH PEMBROKE RD , PEMBROKE - ** 29 YO FEMALE WITH DIFFICULTY BREATHING ** INDIAN FALLS RD / BECKWITH RD ** 06/07/13 19:15 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Delta - 29 YO FEMALE WITH DIFFICULTY BREATHING",
        "ADDR:8190 NORTH PEMBROKE RD",
        "CITY:PEMBROKE",
        "X:INDIAN FALLS RD / BECKWITH RD",
        "DATE:06/07/13",
        "TIME:19:15",
        "ID:2013-00000120");

    doTest("T10",
        "(Dispatch) Unit:EP56 Status:Dispatched Fire HazMat ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** DIESEL FUEL LEAK FROM TRACTOR TRAILER ** CLEVELAND RD / PRATT RD ** 06/07/13 15:31 ** 2013-00000119 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Fire HazMat - DIESEL FUEL LEAK FROM TRACTOR TRAILER",
        "PLACE:PEMBROKE SERVICE CENTER",
        "ADDR:8319 INDIAN FALLS RD",
        "CITY:PEMBROKE",
        "X:CLEVELAND RD / PRATT RD",
        "DATE:06/07/13",
        "TIME:15:31",
        "ID:2013-00000119");

    doTest("T11",
        "(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** ** 3276 PEARL STREET RD , BATAVIA - ** MINI VAN VS SEMI UNK INJURIES BLOCKING TRAFFIC ** WORTENDYKE RD / UPTON RD ** 06/07/13 12:54 ** 2013-00000118 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Acc PIAA - MINI VAN VS SEMI UNK INJURIES BLOCKING TRAFFIC",
        "ADDR:3276 PEARL STREET RD",
        "CITY:BATAVIA",
        "X:WORTENDYKE RD / UPTON RD",
        "DATE:06/07/13",
        "TIME:12:54",
        "ID:2013-00000118");

    doTest("T12",
        "(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** AREA 51 MOTOCROSS** 3500 HARLOFF RD , BATAVIA - ** 21 YO MALE DIRT BIKE ACCIDENT ** No Cross Streets Found ** 06/04/13 18:43 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Acc PIAA - 21 YO MALE DIRT BIKE ACCIDENT",
        "PLACE:AREA 51 MOTOCROSS",
        "ADDR:3500 HARLOFF RD",
        "CITY:BATAVIA",
        "DATE:06/04/13",
        "TIME:18:43",
        "ID:2013-00000117");

    doTest("T13",
        "(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** National Fuel Gas** 3593 W  MAIN STREET RD , BATAVIA - ** ONE CAR OFF THE RD UNK INJURIES  ** KELSEY RD / COUNTY BLDG ** 06/04/13 16:21 ** 2013-00000116 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Acc PIAA - ONE CAR OFF THE RD UNK INJURIES",
        "PLACE:National Fuel Gas",
        "ADDR:3593 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:KELSEY RD / COUNTY BLDG",
        "DATE:06/04/13",
        "TIME:16:21",
        "ID:2013-00000116");

    doTest("T14",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 2846 STEGMAN RD , BATAVIA - ** 68 YO MALE TROUBLE BREATHING ** POWERS RD / MILLER RD ** 06/01/13 15:06 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - 68 YO MALE TROUBLE BREATHING",
        "ADDR:2846 STEGMAN RD",
        "CITY:BATAVIA",
        "X:POWERS RD / MILLER RD",
        "DATE:06/01/13",
        "TIME:15:06",
        "ID:2013-00000115");

    doTest("T15",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 8662 HARTSHORN RD , BATAVIA - ** 65YO MALE DIZZYNESS ** W MAIN STREET RD / PEARL STREET RD, WILKINSON RD ** 06/01/13 14:55 ** 2013-00000114 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - 65YO MALE DIZZYNESS",
        "ADDR:8662 HARTSHORN RD",
        "CITY:BATAVIA",
        "X:W MAIN STREET RD / PEARL STREET RD, WILKINSON RD",
        "DATE:06/01/13",
        "TIME:14:55",
        "ID:2013-00000114");

    doTest("T16",
        "(Dispatch) Unit:EP56 Status:Dispatched Alarm Fire ** ** 2614 W  MAIN STREET RD , BATAVIA - ** 2ND FLOOR SMOKE - ZONE 14 ** READ RD, MAIN RD / EAST AVE ** 06/01/13 10:18 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Alarm Fire - 2ND FLOOR SMOKE - ZONE 14",
        "ADDR:2614 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:READ RD, MAIN RD / EAST AVE",
        "DATE:06/01/13",
        "TIME:10:18",
        "ID:2013-00000113");

    doTest("T17",
        "(Dispatch) EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** 52 YO FEMALE - CHEST PAIN ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 52 YO FEMALE - CHEST PAIN",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 44",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:05/29/13",
        "TIME:14:01",
        "ID:2013-00002226");

    doTest("T18",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Delta",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 44",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:05/29/13",
        "TIME:14:01",
        "ID:2013-00002226");

    doTest("T19",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Bravo ** ** 3314 W MAIN STREET RD , BATAVIA - ** 78 YO FEMALE - UNKNOWN  ** BATAVIA MOBILE HOME PK / HOPKINS RD ** 05/29/13 13:38 ** 2013-00000111 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Bravo - 78 YO FEMALE - UNKNOWN",
        "ADDR:3314 W MAIN STREET RD",
        "CITY:BATAVIA",
        "X:BATAVIA MOBILE HOME PK / HOPKINS RD",
        "DATE:05/29/13",
        "TIME:13:38",
        "ID:2013-00000111");

    doTest("T20",
        "(Dispatch) Unit:EP57 Status:Dispatched Alarm EMS ** ** 1838 MAIN RD , PEMBROKE - ** Fall Pevis injury ** CLEVELAND RD / BOYCE RD ** 05/24/13 22:09 ** 2013-00000110 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:Alarm EMS - Fall Pevis injury",
        "ADDR:1838 MAIN RD",
        "CITY:PEMBROKE",
        "X:CLEVELAND RD / BOYCE RD",
        "DATE:05/24/13",
        "TIME:22:09",
        "ID:2013-00000110");

    doTest("T21",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** FALL INJ TO HEAD ** CLEVELAND RD / PRATT RD ** 05/23/13 10:48 ** 2013-00000108 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - FALL INJ TO HEAD",
        "PLACE:PEMBROKE SERVICE CENTER",
        "ADDR:8319 INDIAN FALLS RD",
        "CITY:PEMBROKE",
        "X:CLEVELAND RD / PRATT RD",
        "DATE:05/23/13",
        "TIME:10:48",
        "ID:2013-00000108");

    doTest("T22",
        "(Dispatch) Unit:EP58 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP58",
        "CALL:Fire Structure - SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM",
        "ADDR:7574 S PEARL STREET RD",
        "CITY:OAKFIELD",
        "DATE:05/21/13",
        "TIME:18:02",
        "ID:2013-00000120");

    doTest("T23",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 4 ** 90 YO M WITH GENERALIZED WEAKNESS  ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/21/13 12:59 ** 2013-00000106 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - 90 YO M WITH GENERALIZED WEAKNESS",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 4",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:05/21/13",
        "TIME:12:59",
        "ID:2013-00000106");

    doTest("T24",
        "(Dispatch) Unit:EP56 Status:Dispatched Fire Structure ** ** 3827 W  MAIN STREET RD , BATAVIA - ** HOUSE FIRE ** UNKNOWN / COUNTY BLDG ** 05/18/13 20:19 ** 2013-00000105 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Fire Structure - HOUSE FIRE",
        "ADDR:3827 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:UNKNOWN / COUNTY BLDG",
        "DATE:05/18/13",
        "TIME:20:19",
        "ID:2013-00000105");

    doTest("T25",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Delta ** ** 3522 W MAIN STREET RD , BATAVIA - LOT 23 ** SEIZURE ** UNKNOWN / KELSEY RD ** 05/17/13 22:08 ** 2013-00002051 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Delta - SEIZURE",
        "ADDR:3522 W MAIN STREET RD",
        "CITY:BATAVIA",
        "APT:LOT 23",
        "X:UNKNOWN / KELSEY RD",
        "DATE:05/17/13",
        "TIME:22:08",
        "ID:2013-00002051");

    doTest("T26",
        "(Dispatch) Unit:EP56 Status:Dispatched Acc PIAA ** ** 2679 GALLOWAY RD , BATAVIA - ** CAR PED ** SLUSSER RD, MACOMBER RD / DOWNEY RD ** 05/17/13 16:10 ** 2013-00010895 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Acc PIAA - CAR PED",
        "ADDR:2679 GALLOWAY RD",
        "CITY:BATAVIA",
        "X:SLUSSER RD, MACOMBER RD / DOWNEY RD",
        "DATE:05/17/13",
        "TIME:16:10",
        "ID:2013-00010895");

    doTest("T27",
        "(Dispatch) Unit:EP57 Status:Dispatched EMD Charlie ** ** 3540 W MAIN STREET RD , BATAVIA - LOT 24 ** 18 MONTH OLD FEMALE SEIZURE ** UNKNOWN / KELSEY RD ** 05/17/13 16:07 ** 2013-00000101 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:EMD Charlie - 18 MONTH OLD FEMALE SEIZURE",
        "ADDR:3540 W MAIN STREET RD",
        "CITY:BATAVIA",
        "APT:LOT 24",
        "X:UNKNOWN / KELSEY RD",
        "DATE:05/17/13",
        "TIME:16:07",
        "ID:2013-00000101");

    doTest("T28",
        "(Dispatch) Unit:EP56 Status:Dispatched Alarm Fire ** Pembroke Primary School** 2486 MAIN RD , PEMBROKE - ** GENERAL FIRE ALARM ** WEST AVE / INDIAN FALLS RD ** 05/17/13 14:38 ** 2013-00000100 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP56",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:Pembroke Primary School",
        "ADDR:2486 MAIN RD",
        "CITY:PEMBROKE",
        "X:WEST AVE / INDIAN FALLS RD",
        "DATE:05/17/13",
        "TIME:14:38",
        "ID:2013-00000100");

    doTest("T29",
        "(Dispatch) Unit:EP57 Status:Dispatched Alarm EMS ** Ridgewood Village Mobile Home Park** 3233 PRATT RD , BATAVIA - LOT 14A ** EMS ALARM ACTIVATION, 90 YO FEMALE FALLEN WITH HEAD INJURY ** RIDGEWOOD VILLAGE PK / RIDGEWOOD VILLAGE PK ** 05/16/13 21:33 ** 2013-00000099 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:EP57",
        "CALL:Alarm EMS - EMS ALARM ACTIVATION, 90 YO FEMALE FALLEN WITH HEAD INJURY",
        "PLACE:Ridgewood Village Mobile Home Park",
        "ADDR:3233 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 14A",
        "X:RIDGEWOOD VILLAGE PK / RIDGEWOOD VILLAGE PK",
        "DATE:05/16/13",
        "TIME:21:33",
        "ID:2013-00000099");

    doTest("T30",
        "(Dispatch) EMD Charlie ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - 33 ** 73 YOM POSSIBLE STROKE \n" +
        " ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/16/13 07:36 ** 2013-00000098 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 73 YOM POSSIBLE STROKE",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:33");
   
  }
  
  @Test
  public void testTownOfBataviaFD() {

    doTest("T1",
        "(Dispatch) Unit:251 Status:Dispatched ** Alarm Fire ** ** 29 EDGEWOOD DR , BATAVIA ** ** GENERAL FIRE ALARM HOMEOWNER IS ON LOC  ** UNKNOWN / WOODLAND DR ** 06/13/13 11:13 ** 2013-00000128\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - GENERAL FIRE ALARM HOMEOWNER IS ON LOC",
        "ADDR:29 EDGEWOOD DR",
        "CITY:BATAVIA",
        "X:UNKNOWN / WOODLAND DR",
        "DATE:06/13/13",
        "TIME:11:13",
        "ID:2013-00000128");

    doTest("T2",
        "(Dispatch) Unit:251 Status:Dispatched Fire Service Call ** TOWN OF BATAVIA FD STA 1** 8382 LEWISTON RD , BATAVIA - ** TOWN OF BATAVIA FIRE TO STAND BY IN QUARTERS ** PARK RD / W MAIN STREET RD, W MAIN ST ** 06/10/13 17:08 ** 2013-00000127 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Service Call - TOWN OF BATAVIA FIRE TO STAND BY IN QUARTERS",
        "PLACE:TOWN OF BATAVIA FD STA 1",
        "ADDR:8382 LEWISTON RD",
        "CITY:BATAVIA",
        "X:PARK RD / W MAIN STREET RD, W MAIN ST",
        "DATE:06/10/13",
        "TIME:17:08",
        "ID:2013-00000127");

    doTest("T3",
        "(Dispatch) Fire Mutual Aid ** EAST PEMBROKE FIRE DEPT.** 2623 W  MAIN STREET RD , BATAVIA - ** ONE ENGINE FILL IN ** EAST AVE / READ RD, MAIN RD ** 06/07/13 16:27 ** 2013-00000126 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Mutual Aid - ONE ENGINE FILL IN",
        "PLACE:EAST PEMBROKE FIRE DEPT.",
        "ADDR:2623 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:EAST AVE / READ RD, MAIN RD",
        "DATE:06/07/13",
        "TIME:16:27",
        "ID:2013-00000126");

    doTest("T4",
        "(Dispatch) Unit:TB24 Status:Dispatched Fire Nat Propane Gas ** EAST PEMBROKE FIRE DEPT.** 2623 W  MAIN STREET RD , BATAVIA - ** ONE ENGINE FILL IN ** EAST AVE / READ RD, MAIN RD ** 06/07/13 16:27 ** 2013-00000126 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:TB24",
        "CALL:Fire Nat Propane Gas - ONE ENGINE FILL IN",
        "PLACE:EAST PEMBROKE FIRE DEPT.",
        "ADDR:2623 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:EAST AVE / READ RD, MAIN RD",
        "DATE:06/07/13",
        "TIME:16:27",
        "ID:2013-00000126");

    doTest("T5",
        "(Dispatch) Unit:251 Status:Dispatched Fire CO Detector ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - BDLG D 302 ** MALE W/ HEADACHE ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/06/13 07:10 ** 2013-00000125 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire CO Detector - MALE W/ HEADACHE",
        "PLACE:College Village",
        "ADDR:8170 BATAVIA STAFFORD TOWNLINE RD",
        "CITY:BATAVIA",
        "APT:BDLG D 302",
        "X:BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR",
        "DATE:06/06/13",
        "TIME:07:10",
        "ID:2013-00000125");

    doTest("T6",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** Hodgins Engraving** 3817 W  MAIN STREET RD , BATAVIA - ** office and print shop fire  ** UNKNOWN / COUNTY BLDG ** 06/06/13 06:55 ** 2013-00000124 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - office and print shop fire",
        "PLACE:Hodgins Engraving",
        "ADDR:3817 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:UNKNOWN / COUNTY BLDG",
        "DATE:06/06/13",
        "TIME:06:55",
        "ID:2013-00000124");

    doTest("T7",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** ** 4 TREADEASY AVE , BATAVIA - E ** GENERAL FIRE ALARM ** PEARL STREET RD / INDUSTRIAL BLVD ** 06/05/13 19:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "ADDR:4 TREADEASY AVE",
        "CITY:BATAVIA",
        "APT:E",
        "X:PEARL STREET RD / INDUSTRIAL BLVD",
        "DATE:06/05/13",
        "TIME:19:51",
        "ID:2013-00000123");

    doTest("T8",
        "(Dispatch) Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - PINE ** GENERAL FIRE ALARM \n\n" +
        " ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/04/13 20:28 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:College Village",
        "ADDR:8170 BATAVIA STAFFORD TOWNLINE RD",
        "CITY:BATAVIA",
        "APT:PINE");

    doTest("T9",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - PINE ** GENERAL FIRE ALARM \n" +
        " ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 06/04/13 20:28 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:College Village",
        "ADDR:8170 BATAVIA STAFFORD TOWNLINE RD",
        "CITY:BATAVIA",
        "APT:PINE");

    doTest("T10",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** TRAVELODGE** 8204 PARK RD , BATAVIA - ** SOUTH HALL 1 ST FLOOR  ** OAK ST, EXIT 48 ON RAMP, EXIT 48 OFF RAMP / VETERANS MEMORIAL DR ** 06/03/13 10:58 ** 2013-00000121 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - SOUTH HALL 1 ST FLOOR",
        "PLACE:TRAVELODGE",
        "ADDR:8204 PARK RD",
        "CITY:BATAVIA",
        "X:OAK ST, EXIT 48 ON RAMP, EXIT 48 OFF RAMP / VETERANS MEMORIAL DR",
        "DATE:06/03/13",
        "TIME:10:58",
        "ID:2013-00000121");

    doTest("T11",
        "(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - TRACTOR TRAILER FIRE NEXT TO BARN",
        "PLACE:Baskin Livestock",
        "ADDR:9778 CREEK RD",
        "CITY:BETHANY",
        "X:PUTNAM RD / COOK RD",
        "DATE:06/03/13",
        "TIME:08:56",
        "ID:2013-00000059");

    doTest("T12",
        "(Dispatch) Unit:251 Status:Dispatched Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side - TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Structure - out side - TRACTOR TRAILER FIRE NEXT TO BARN",
        "PLACE:Baskin Livestock",
        "ADDR:9778 CREEK RD",
        "CITY:BETHANY",
        "X:PUTNAM RD / COOK RD",
        "DATE:06/03/13",
        "TIME:08:56",
        "ID:2013-00000059");

    doTest("T13",
        "(Dispatch) Unit:251 Status:Dispatched Fire Investigation ** ** 8173 STATE STREET RD , BATAVIA - ** TREE ON FIRE - NEAR THE ROAD ** DEAD END / I 90 ** 06/02/13 14:46 ** 2013-00000119 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Investigation - TREE ON FIRE - NEAR THE ROAD",
        "ADDR:8173 STATE STREET RD",
        "CITY:BATAVIA",
        "X:DEAD END / I 90",
        "DATE:06/02/13",
        "TIME:14:46",
        "ID:2013-00000119");

    doTest("T14",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** ** 8423 STRINGHAM DR , BATAVIA - ** GENERAL ALARM ** DEAD END / DANA WAY ** 06/02/13 14:32 ** 2013-00000118 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - GENERAL ALARM",
        "ADDR:8423 STRINGHAM DR",
        "CITY:BATAVIA",
        "X:DEAD END / DANA WAY",
        "DATE:06/02/13",
        "TIME:14:32",
        "ID:2013-00000118");

    doTest("T15",
        "(Dispatch) Unit:251 Status:Dispatched Fire Investigation ** ** 3730 ROSE RD , BATAVIA - ** TRANSFORMER SMOKING ** DONAHUE RD / WORTENDYKE RD ** 06/01/13 18:13 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Investigation - TRANSFORMER SMOKING",
        "ADDR:3730 ROSE RD",
        "CITY:BATAVIA",
        "X:DONAHUE RD / WORTENDYKE RD",
        "DATE:06/01/13",
        "TIME:18:13",
        "ID:2013-00000117");

    doTest("T16",
        "(Dispatch) Unit:251 Status:Dispatched EMD Charlie ** Batavia Downs Western Regional Off Track Betting** 8315 PARK RD , BATAVIA - ** 72 YO MALE WITH POSSIBLE STROKE ** RICHMOND AVE / VETERANS MEMORIAL DR ** 05/30/13 21:27 ** 2013-00002257 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:EMD Charlie - 72 YO MALE WITH POSSIBLE STROKE",
        "PLACE:Batavia Downs Western Regional Off Track Betting",
        "ADDR:8315 PARK RD",
        "CITY:BATAVIA",
        "X:RICHMOND AVE / VETERANS MEMORIAL DR",
        "DATE:05/30/13",
        "TIME:21:27",
        "ID:2013-00002257");

    doTest("T17",
        "(Dispatch) Unit:251 Status:Dispatched Acc PIAA ** ** 9084 CREEK RD , BATAVIA - ** ONE VEHICLE ROLL OVER ** DORMAN RD / LEHIGH AVE ** 05/29/13 18:49 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Acc PIAA - ONE VEHICLE ROLL OVER",
        "ADDR:9084 CREEK RD",
        "CITY:BATAVIA",
        "X:DORMAN RD / LEHIGH AVE",
        "DATE:05/29/13",
        "TIME:18:49",
        "ID:2013-00000115");

    doTest("T18",
        "(Dispatch) Fire Wire Down ** ** 7778 OAK ORCHARD RD , BATAVIA - ** UNK TYPE OF WIRE DOWN \n" +
        " ** BATAVIA ELBA TOWNLINE RD / W SAILE DR ** 05/29/13 12:25 ** 2013-00001270 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - UNK TYPE OF WIRE DOWN",
        "ADDR:7778 OAK ORCHARD RD",
        "CITY:BATAVIA");

    doTest("T19",
        "(Dispatch) Unit:252 Status:Dispatched Fire Wire Down ** ** OAK ORCHARD RD , W  SAILE DR BATAVIA - ** UNK TYPE OF WIRE DOWN \n" +
        " ** ** 05/29/13 12:25 ** 2013-00001270 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:252",
        "CALL:Fire Wire Down - UNK TYPE OF WIRE DOWN",
        "ADDR:OAK ORCHARD RD & W SAILE DR",
        "CITY:BATAVIA");

    doTest("T20",
        "(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** BARN FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - BARN FIRE",
        "ADDR:8244 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T21",
        "(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - COMMERCIAL BUILDING FIRE",
        "ADDR:8244 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T22",
        "(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 8224 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Structure - COMMERCIAL BUILDING FIRE",
        "ADDR:8224 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T23",
        "(Dispatch) Unit:251 Status:Dispatched Acc PIAA ** ** LEWISTON RD , VETERANS MEMORIAL DR BATAVIA - ** 2 CAR PIAA ** ** 05/23/13 15:15 ** 2013-00011407 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Acc PIAA - 2 CAR PIAA",
        "ADDR:LEWISTON RD & VETERANS MEMORIAL DR",
        "CITY:BATAVIA",
        "DATE:05/23/13",
        "TIME:15:15",
        "ID:2013-00011407");

    doTest("T24",
        "(Dispatch) Unit:TB25 Status:Dispatched EMD Delta ** Buffalo Federal Detention Center** 4250 FEDERAL DR , BATAVIA - ** MALE UNC ON ROOF ** DEAD END / COMMERCE DR ** 05/23/13 14:32 ** 2013-00002141 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:TB25",
        "CALL:EMD Delta - MALE UNC ON ROOF",
        "PLACE:Buffalo Federal Detention Center",
        "ADDR:4250 FEDERAL DR",
        "CITY:BATAVIA",
        "X:DEAD END / COMMERCE DR",
        "DATE:05/23/13",
        "TIME:14:32",
        "ID:2013-00002141");

    doTest("T25",
        "(Dispatch) Unit:TB18 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:TB18",
        "CALL:Fire Structure - SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM",
        "ADDR:7574 S PEARL STREET RD",
        "CITY:OAKFIELD",
        "DATE:05/21/13",
        "TIME:18:02",
        "ID:2013-00000120");

    doTest("T26",
        "(Dispatch) Unit:251 Status:Dispatched Alarm Fire ** College Village** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - SPRUCE ** GENERAL FIRE ALARM ** BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR ** 05/20/13 15:35 ** 2013-00000109 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:College Village",
        "ADDR:8170 BATAVIA STAFFORD TOWNLINE RD",
        "CITY:BATAVIA",
        "APT:SPRUCE",
        "X:BYRON RD / ASSEMBLYMAN R. STEPHEN HAWLEY DR",
        "DATE:05/20/13",
        "TIME:15:35",
        "ID:2013-00000109");

    doTest("T27",
        "(Dispatch) Unit:252 Status:Dispatched Fire Grass ** ** I 90 , STATE STREET RD BATAVIA - ** GRASS FIRE  ** ** 05/20/13 11:36 ** 2013-00000108 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:252",
        "CALL:Fire Grass - GRASS FIRE",
        "ADDR:I 90 & STATE STREET RD",
        "CITY:BATAVIA",
        "DATE:05/20/13",
        "TIME:11:36",
        "ID:2013-00000108");

    doTest("T28",
        "(Dispatch) Acc PIAA ** 386.4 RT 90 W** , STAFFORD - ** 1 CAR ROLL OVER ** CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR ** 05/20/13 11:00 ** 2013-00000107 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Acc PIAA - 1 CAR ROLL OVER",
        "PLACE:386.4 RT 90 W",
        "CITY:STAFFORD",
        "X:CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR",
        "DATE:05/20/13",
        "TIME:11:00",
        "ID:2013-00000107");

    doTest("T29",
        "(Dispatch) Acc PIAA ** 386.4 RT 90 W** , STAFFORD - ** 1 CAR ** CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR ** 05/20/13 11:00 ** 2013-00000107 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Acc PIAA - 1 CAR",
        "PLACE:386.4 RT 90 W",
        "CITY:STAFFORD",
        "X:CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR",
        "DATE:05/20/13",
        "TIME:11:00",
        "ID:2013-00000107");

    doTest("T30",
        "(Dispatch) Unit:251 Status:Dispatched Acc PIAA ** 386.4 RT 90 W** , STAFFORD - ** ** CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR ** 05/20/13 11:00 ** 2013-00000107 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Acc PIAA",
        "PLACE:386.4 RT 90 W",
        "CITY:STAFFORD",
        "X:CLINTON STREET RD, I 90 / I 90, I-90 CONNECTOR",
        "DATE:05/20/13",
        "TIME:11:00",
        "ID:2013-00000107");

  }
  
  @Test
  public void testDarienVolunteerFireDept() {

    doTest("T1",
        "(Dispatch) Fire Structure ** ** 3105 COUNTY LINE RD , DARIEN - ** DIESEL TANK NEXT TO BARN ** SUMNER RD / SUMNER RD ** 10/03/12 01:53 ** 2012-00000226 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - DIESEL TANK NEXT TO BARN",
        "ADDR:3105 COUNTY LINE RD",
        "CITY:DARIEN",
        "X:SUMNER RD / SUMNER RD",
        "DATE:10/03/12",
        "TIME:01:53",
        "ID:2012-00000226");

    doTest("T2",
        "(Dispatch) Unit:501 Status:Dispatched Fire Structure ** ** 3105 COUNTY LINE RD , DARIEN - ** DEISEL TANK NEXT TO BARN ** SUMNER RD / SUMNER RD ** 10/03/12 01:53 ** 2012-00000226 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:Fire Structure - DEISEL TANK NEXT TO BARN",
        "ADDR:3105 COUNTY LINE RD",
        "CITY:DARIEN",
        "X:SUMNER RD / SUMNER RD",
        "DATE:10/03/12",
        "TIME:01:53",
        "ID:2012-00000226");

    doTest("T3",
        "(Dispatch) Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** DARIEN 1 TANKER TO WARSAW FIRE HALL ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Mutual Aid - DARIEN 1 TANKER TO WARSAW FIRE HALL",
        "ADDR:40 E BUFFALO ST",
        "CITY:WARSAW",
        "DATE:10/02/12",
        "TIME:06:02",
        "ID:2012-00000225");

    doTest("T4",
        "(Dispatch) Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** DARIEN 1 TANKER TO WARSAW FIRE HALL ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Mutual Aid - DARIEN 1 TANKER TO WARSAW FIRE HALL",
        "ADDR:40 E BUFFALO ST",
        "CITY:WARSAW",
        "DATE:10/02/12",
        "TIME:06:02",
        "ID:2012-00000225");

    doTest("T5",
        "(Dispatch) Unit:501 Status:Dispatched Fire Mutual Aid ** ** 40 E BUFFALO ST , WARSAW - ** ** ** 10/02/12 06:02 ** 2012-00000225 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:Fire Mutual Aid",
        "ADDR:40 E BUFFALO ST",
        "CITY:WARSAW",
        "DATE:10/02/12",
        "TIME:06:02",
        "ID:2012-00000225");

    doTest("T6",
        "(Dispatch) Unit:501 Status:Dispatched EMD Bravo ** ** 1649 SUMNER RD , DARIEN - ** 68 YO FEMALE WITH OVERDOSE ** COLBY RD / ALLEGHANY RD ** 10/01/12 18:54 ** 2012-00000224 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:EMD Bravo - 68 YO FEMALE WITH OVERDOSE",
        "ADDR:1649 SUMNER RD",
        "CITY:DARIEN",
        "X:COLBY RD / ALLEGHANY RD",
        "DATE:10/01/12",
        "TIME:18:54",
        "ID:2012-00000224");

    doTest("T7",
        "(Dispatch) Unit:501 Status:Dispatched Acc PIAA ** ** 9768 COLBY RD , DARIEN - ** CAR/POLE UNKNOWN INJURIES ** RICHLEY RD / SUMNER RD ** 09/29/12 22:30 ** 2012-00002280 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:Acc PIAA - CAR/POLE UNKNOWN INJURIES",
        "ADDR:9768 COLBY RD",
        "CITY:DARIEN",
        "X:RICHLEY RD / SUMNER RD",
        "DATE:09/29/12",
        "TIME:22:30",
        "ID:2012-00002280");

    doTest("T8",
        "(Dispatch) Unit:501 Status:Dispatched EMD Bravo ** DARIEN TOWN HALL** 10569 ALLEGHANY RD , DARIEN - ** HEAD LACERATION ** BROADWAY RD / SUMNER RD ** 09/29/12 19:38 ** 2012-00000222 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:EMD Bravo - HEAD LACERATION",
        "PLACE:DARIEN TOWN HALL",
        "ADDR:10569 ALLEGHANY RD",
        "CITY:DARIEN",
        "X:BROADWAY RD / SUMNER RD",
        "DATE:09/29/12",
        "TIME:19:38",
        "ID:2012-00000222");

    doTest("T9",
        "(Dispatch) Unit:501 Status:Dispatched EMD Delta ** ** 2064 RICHLEY RD , DARIEN - ** 67 YO MALE DIABETIC PROBLEM SEMI CONSCIOUS ** SIMONDS RD / HARPER RD ** 09/26/12 15:44 ** 2012-00000221 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:501",
        "CALL:EMD Delta - 67 YO MALE DIABETIC PROBLEM SEMI CONSCIOUS",
        "ADDR:2064 RICHLEY RD",
        "CITY:DARIEN",
        "X:SIMONDS RD / HARPER RD",
        "DATE:09/26/12",
        "TIME:15:44",
        "ID:2012-00000221");

  }
  
  @Test
  public void testLeRoyFireDepartment() {

    doTest("T1",
        "(Dispatch) Unit:LE65 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LE65",
        "CALL:Fire Structure - Barn Fire",
        "ADDR:6638 ELLICOTT STREET RD",
        "CITY:PAVILION",
        "X:SPARKS RD / STARR RD, COOK RD",
        "DATE:06/15/13",
        "TIME:01:48",
        "ID:2013-00000107");

    doTest("T2",
        "(Dispatch) Unit:701 Status:Dispatched ** Fire Service Call ** ** 27 W MAIN ST , LE ROY ** ** 1-1/2 feet of water in basemenr ** CRAIGIE ST / CLAY ST, LAKE ST, MAIN ST ** 06/13/13 19:35 ** 2013-00000125\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Service Call - 1-1/2 feet of water in basemenr",
        "ADDR:27 W MAIN ST",
        "CITY:LE ROY",
        "X:CRAIGIE ST / CLAY ST, LAKE ST, MAIN ST",
        "DATE:06/13/13",
        "TIME:19:35",
        "ID:2013-00000125");

    doTest("T3",
        "(Dispatch) Unit:701 Status:Dispatched Fire Service Call ** ** MAIN ST , BANK ST LE ROY - ** WASH DOWN REQUESTED BY LEROY EMS\n" +
        " ** ** 06/09/13 22:10 ** 2013-00000124 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Service Call - WASH DOWN REQUESTED BY LEROY EMS",
        "ADDR:MAIN ST & BANK ST",
        "CITY:LE ROY");

    doTest("T4",
        "(Dispatch) Fire Mutual Aid ** ** 2667 YORK RD W , YORK - ** STAND-BY IN YORK FIRE DEPT. ** MAIN ST, YORK RD E / LIMERICK RD ** 06/07/13 17:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Mutual Aid - STAND-BY IN YORK FIRE DEPT.",
        "ADDR:2667 YORK RD W",
        "CITY:YORK",
        "X:MAIN ST, YORK RD E / LIMERICK RD",
        "DATE:06/07/13",
        "TIME:17:51",
        "ID:2013-00000123");

    doTest("T5",
        "(Dispatch) Unit:701 Status:Dispatched Fire Mutual Aid ** ** <UNKNOWN> , - ** STAND-BY IN YORK FIRE DEPT. ** ** 06/07/13 17:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Mutual Aid - STAND-BY IN YORK FIRE DEPT.",
        "ADDR:<UNKNOWN>",
        "DATE:06/07/13",
        "TIME:17:51",
        "ID:2013-00000123");

    doTest("T6",
        "(Dispatch) Unit:LE63 Status:Dispatched Alarm Fire ** Pavilion Central School** 7014 BIG TREE RD , PAVILION - ** GEN FIRE ALARM ** YORK RD / EAST PARK ST ** 06/07/13 06:08 ** 2013-00000102 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LE63",
        "CALL:Alarm Fire - GEN FIRE ALARM",
        "PLACE:Pavilion Central School",
        "ADDR:7014 BIG TREE RD",
        "CITY:PAVILION",
        "X:YORK RD / EAST PARK ST",
        "DATE:06/07/13",
        "TIME:06:08",
        "ID:2013-00000102");

    doTest("T7",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** 0.6 RT 490 W** , LE ROY - ** car deer ** I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490 ** 06/06/13 07:03 ** 2013-00000142 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - car deer",
        "PLACE:0.6 RT 490 W",
        "CITY:LE ROY",
        "X:I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490",
        "DATE:06/06/13",
        "TIME:07:03",
        "ID:2013-00000142");

    doTest("T8",
        "(Dispatch) Fire Auto ** 381.0 RT 90 W** , LE ROY - ** SMOKE COMING FROM TT ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Auto - SMOKE COMING FROM TT",
        "PLACE:381.0 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD",
        "DATE:06/05/13",
        "TIME:16:55",
        "ID:2013-00000120");

    doTest("T9",
        "(Dispatch) Unit:701 Status:Dispatched Fire Auto ** 381.0 RT 90 W** , LE ROY - ** ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Auto",
        "PLACE:381.0 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD",
        "DATE:06/05/13",
        "TIME:16:55",
        "ID:2013-00000120");

    doTest("T10",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** ** W  MAIN ST , CLAY ST LE ROY - ** CAR VS SEMI NO INJ BLOCKING  ** ** 06/04/13 14:47 ** 2013-00001755 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - CAR VS SEMI NO INJ BLOCKING",
        "ADDR:W  MAIN ST & CLAY ST",
        "CITY:LE ROY",
        "DATE:06/04/13",
        "TIME:14:47",
        "ID:2013-00001755");

    doTest("T11",
        "(Dispatch) Fire Auto ** 378.2 RT 90 W** , LE ROY - ** TT Fire ** I 90, I-90 CONNECTOR / I 90 ** 05/31/13 19:50 ** 2013-00000538 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Auto - TT Fire",
        "PLACE:378.2 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90",
        "DATE:05/31/13",
        "TIME:19:50",
        "ID:2013-00000538");

    doTest("T12",
        "(Dispatch) Unit:701 Status:Dispatched Fire Auto ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** TT Fire ** UNKNOWN / UNKNOWN ** 05/31/13 19:50 ** 2013-00000538 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Auto - TT Fire",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:19:50",
        "ID:2013-00000538");

    doTest("T13",
        "(Dispatch) Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire HazMat - DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:08:45",
        "ID:2013-00000117");

    doTest("T14",
        "(Dispatch) Unit:701 Status:Dispatched Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire HazMat - GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:08:45",
        "ID:2013-00000117");

    doTest("T15",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** Oatka Creek Public Fishing Stream NYS DEC** 8116 OATKA TRL , LE ROY - ** MOTORCYCLE VS TREE ** GULLY RD / CIRCULAR HILL RD ** 05/30/13 17:37 ** 2013-00000531 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - MOTORCYCLE VS TREE",
        "PLACE:Oatka Creek Public Fishing Stream NYS DEC",
        "ADDR:8116 OATKA TRL",
        "CITY:LE ROY",
        "X:GULLY RD / CIRCULAR HILL RD",
        "DATE:05/30/13",
        "TIME:17:37",
        "ID:2013-00000531");

    doTest("T16",
        "(Dispatch) Fire Wire Down ** ** 6488 RANDALL RD , STAFFORD - ** UNKOWN TYPE WIRES DOWN  ** BUCKLEY RD / RICHMOND RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - UNKOWN TYPE WIRES DOWN",
        "ADDR:6488 RANDALL RD",
        "CITY:STAFFORD",
        "X:BUCKLEY RD / RICHMOND RD",
        "DATE:05/29/13",
        "TIME:12:56",
        "ID:2013-00000115");

    doTest("T17",
        "(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7488 RANDALL RD , LE ROY - ** UNKOWN TYPE WIRES DOWN  ** LAKE STREET RD, NORTH STREET RD / WEST BERGEN RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Wire Down - UNKOWN TYPE WIRES DOWN",
        "ADDR:7488 RANDALL RD",
        "CITY:LE ROY",
        "X:LAKE STREET RD, NORTH STREET RD / WEST BERGEN RD",
        "DATE:05/29/13",
        "TIME:12:56",
        "ID:2013-00000115");

    doTest("T18",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 23 E  MAIN ST , LE ROY - ** SMOKE ALARM ** TRIGON PK / TRIGON PK ** 05/29/13 11:54 ** 2013-00000114 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - SMOKE ALARM",
        "ADDR:23 E  MAIN ST",
        "CITY:LE ROY",
        "X:TRIGON PK / TRIGON PK",
        "DATE:05/29/13",
        "TIME:11:54",
        "ID:2013-00000114");

    doTest("T19",
        "(Dispatch) Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7158 W  MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T20",
        "(Dispatch) Fire Wire Down ** ** 7152 W MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7152 W MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T21",
        "(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7158 W  MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T22",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** LeRoy Meadows Apartments** 18 GENESEE ST , LE ROY - BLDG 7 ** FIRE ALARM ACTIVATION  ** LATHROP AVE / NORTH ST ** 05/27/13 06:26 ** 2013-00000112 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - FIRE ALARM ACTIVATION",
        "PLACE:LeRoy Meadows Apartments",
        "ADDR:18 GENESEE ST",
        "CITY:LE ROY",
        "APT:BLDG 7",
        "X:LATHROP AVE / NORTH ST",
        "DATE:05/27/13",
        "TIME:06:26",
        "ID:2013-00000112");

    doTest("T23",
        "(Dispatch) EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** UNRESPONSIVE MALE  ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - UNRESPONSIVE MALE",
        "ADDR:8408 CIRCULAR HILL RD",
        "CITY:LE ROY",
        "X:UNKNOWN / WILCOX RD",
        "DATE:05/27/13",
        "TIME:04:37",
        "ID:2013-00000519");

    doTest("T24",
        "(Dispatch) Unit:701 Status:Dispatched EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:EMD Delta",
        "ADDR:8408 CIRCULAR HILL RD",
        "CITY:LE ROY",
        "X:UNKNOWN / WILCOX RD",
        "DATE:05/27/13",
        "TIME:04:37",
        "ID:2013-00000519");

    doTest("T25",
        "(Dispatch) Unit:701 Status:Dispatched Fire Investigation ** ** 94 MYRTLE ST , LE ROY - ** BURNED FOOD ON STOVE/SMOKE IN RESIDENCE ** CRAIGIE ST / GILBERT ST, ROYAL DR ** 05/24/13 02:23 ** 2013-00000110 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Investigation - BURNED FOOD ON STOVE/SMOKE IN RESIDENCE",
        "ADDR:94 MYRTLE ST",
        "CITY:LE ROY",
        "X:CRAIGIE ST / GILBERT ST, ROYAL DR",
        "DATE:05/24/13",
        "TIME:02:23",
        "ID:2013-00000110");

    doTest("T26",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T27",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T28",
        "(Dispatch) Unit:702 Status:Dispatched Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:702",
        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:11124 SAINT MARYS ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WOODROW DR / DEAD END",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T29",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 9200 ASBURY RD , LE ROY - ** FIRE ALARM ** E MAIN RD / HARRIS RD ** 05/20/13 14:47 ** 2013-00000107 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - FIRE ALARM",
        "ADDR:9200 ASBURY RD",
        "CITY:LE ROY",
        "X:E MAIN RD / HARRIS RD",
        "DATE:05/20/13",
        "TIME:14:47",
        "ID:2013-00000107");

    doTest("T30",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** ** 94 W MAIN ST , LE ROY - ** 2 CAR PIAA ** ROYAL DR / WEST AVE ** 05/16/13 17:10 ** 2013-00000106 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - 2 CAR PIAA",
        "ADDR:94 W MAIN ST",
        "CITY:LE ROY",
        "X:ROYAL DR / WEST AVE",
        "DATE:05/16/13",
        "TIME:17:10",
        "ID:2013-00000106");

  }
  
  @Test
  public void testBergenFireDepartment() {

    doTest("T1",
        "(Dispatch) Unit:LE65 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LE65",
        "CALL:Fire Structure - Barn Fire",
        "ADDR:6638 ELLICOTT STREET RD",
        "CITY:PAVILION",
        "X:SPARKS RD / STARR RD, COOK RD",
        "DATE:06/15/13",
        "TIME:01:48",
        "ID:2013-00000107");

    doTest("T2",
        "(Dispatch) Unit:701 Status:Dispatched ** Fire Service Call ** ** 27 W MAIN ST , LE ROY ** ** 1-1/2 feet of water in basemenr ** CRAIGIE ST / CLAY ST, LAKE ST, MAIN ST ** 06/13/13 19:35 ** 2013-00000125\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Service Call - 1-1/2 feet of water in basemenr",
        "ADDR:27 W MAIN ST",
        "CITY:LE ROY",
        "X:CRAIGIE ST / CLAY ST, LAKE ST, MAIN ST",
        "DATE:06/13/13",
        "TIME:19:35",
        "ID:2013-00000125");

    doTest("T3",
        "(Dispatch) Unit:701 Status:Dispatched Fire Service Call ** ** MAIN ST , BANK ST LE ROY - ** WASH DOWN REQUESTED BY LEROY EMS\n" +
        " ** ** 06/09/13 22:10 ** 2013-00000124 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Service Call - WASH DOWN REQUESTED BY LEROY EMS",
        "ADDR:MAIN ST & BANK ST",
        "CITY:LE ROY");

    doTest("T4",
        "(Dispatch) Fire Mutual Aid ** ** 2667 YORK RD W , YORK - ** STAND-BY IN YORK FIRE DEPT. ** MAIN ST, YORK RD E / LIMERICK RD ** 06/07/13 17:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Mutual Aid - STAND-BY IN YORK FIRE DEPT.",
        "ADDR:2667 YORK RD W",
        "CITY:YORK",
        "X:MAIN ST, YORK RD E / LIMERICK RD",
        "DATE:06/07/13",
        "TIME:17:51",
        "ID:2013-00000123");

    doTest("T5",
        "(Dispatch) Unit:701 Status:Dispatched Fire Mutual Aid ** ** <UNKNOWN> , - ** STAND-BY IN YORK FIRE DEPT. ** ** 06/07/13 17:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Mutual Aid - STAND-BY IN YORK FIRE DEPT.",
        "ADDR:<UNKNOWN>",
        "DATE:06/07/13",
        "TIME:17:51",
        "ID:2013-00000123");

    doTest("T6",
        "(Dispatch) Unit:LE63 Status:Dispatched Alarm Fire ** Pavilion Central School** 7014 BIG TREE RD , PAVILION - ** GEN FIRE ALARM ** YORK RD / EAST PARK ST ** 06/07/13 06:08 ** 2013-00000102 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LE63",
        "CALL:Alarm Fire - GEN FIRE ALARM",
        "PLACE:Pavilion Central School",
        "ADDR:7014 BIG TREE RD",
        "CITY:PAVILION",
        "X:YORK RD / EAST PARK ST",
        "DATE:06/07/13",
        "TIME:06:08",
        "ID:2013-00000102");

    doTest("T7",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** 0.6 RT 490 W** , LE ROY - ** car deer ** I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490 ** 06/06/13 07:03 ** 2013-00000142 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - car deer",
        "PLACE:0.6 RT 490 W",
        "CITY:LE ROY",
        "X:I 490, I-490 WESTBOUND OFF RAMP EXIT 1 / I-490 CONNECTOR, I 490",
        "DATE:06/06/13",
        "TIME:07:03",
        "ID:2013-00000142");

    doTest("T8",
        "(Dispatch) Fire Auto ** 381.0 RT 90 W** , LE ROY - ** SMOKE COMING FROM TT ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Auto - SMOKE COMING FROM TT",
        "PLACE:381.0 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD",
        "DATE:06/05/13",
        "TIME:16:55",
        "ID:2013-00000120");

    doTest("T9",
        "(Dispatch) Unit:701 Status:Dispatched Fire Auto ** 381.0 RT 90 W** , LE ROY - ** ** I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD ** 06/05/13 16:55 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Auto",
        "PLACE:381.0 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90, WEST BERGEN RD",
        "DATE:06/05/13",
        "TIME:16:55",
        "ID:2013-00000120");

    doTest("T10",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** ** W  MAIN ST , CLAY ST LE ROY - ** CAR VS SEMI NO INJ BLOCKING  ** ** 06/04/13 14:47 ** 2013-00001755 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - CAR VS SEMI NO INJ BLOCKING",
        "ADDR:W  MAIN ST & CLAY ST",
        "CITY:LE ROY",
        "DATE:06/04/13",
        "TIME:14:47",
        "ID:2013-00001755");

    doTest("T11",
        "(Dispatch) Fire Auto ** 378.2 RT 90 W** , LE ROY - ** TT Fire ** I 90, I-90 CONNECTOR / I 90 ** 05/31/13 19:50 ** 2013-00000538 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Auto - TT Fire",
        "PLACE:378.2 RT 90 W",
        "CITY:LE ROY",
        "X:I 90, I-90 CONNECTOR / I 90",
        "DATE:05/31/13",
        "TIME:19:50",
        "ID:2013-00000538");

    doTest("T12",
        "(Dispatch) Unit:701 Status:Dispatched Fire Auto ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** TT Fire ** UNKNOWN / UNKNOWN ** 05/31/13 19:50 ** 2013-00000538 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Auto - TT Fire",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:19:50",
        "ID:2013-00000538");

    doTest("T13",
        "(Dispatch) Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire HazMat - DIESEL FUEL LEAK OFF A TRACTOR FUEL TANK",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:08:45",
        "ID:2013-00000117");

    doTest("T14",
        "(Dispatch) Unit:701 Status:Dispatched Fire HazMat ** ONTARIO SERVICE CENTER** 8700 VALLANCE RD , LE ROY - ** GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK  ** UNKNOWN / UNKNOWN ** 05/31/13 08:45 ** 2013-00000117 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire HazMat - GDIESEL FUEL LEAK OFF A TRACTOR FUEL TANK",
        "PLACE:ONTARIO SERVICE CENTER",
        "ADDR:8700 VALLANCE RD",
        "CITY:LE ROY",
        "X:UNKNOWN / UNKNOWN",
        "DATE:05/31/13",
        "TIME:08:45",
        "ID:2013-00000117");

    doTest("T15",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** Oatka Creek Public Fishing Stream NYS DEC** 8116 OATKA TRL , LE ROY - ** MOTORCYCLE VS TREE ** GULLY RD / CIRCULAR HILL RD ** 05/30/13 17:37 ** 2013-00000531 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - MOTORCYCLE VS TREE",
        "PLACE:Oatka Creek Public Fishing Stream NYS DEC",
        "ADDR:8116 OATKA TRL",
        "CITY:LE ROY",
        "X:GULLY RD / CIRCULAR HILL RD",
        "DATE:05/30/13",
        "TIME:17:37",
        "ID:2013-00000531");

    doTest("T16",
        "(Dispatch) Fire Wire Down ** ** 6488 RANDALL RD , STAFFORD - ** UNKOWN TYPE WIRES DOWN  ** BUCKLEY RD / RICHMOND RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - UNKOWN TYPE WIRES DOWN",
        "ADDR:6488 RANDALL RD",
        "CITY:STAFFORD",
        "X:BUCKLEY RD / RICHMOND RD",
        "DATE:05/29/13",
        "TIME:12:56",
        "ID:2013-00000115");

    doTest("T17",
        "(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7488 RANDALL RD , LE ROY - ** UNKOWN TYPE WIRES DOWN  ** LAKE STREET RD, NORTH STREET RD / WEST BERGEN RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Wire Down - UNKOWN TYPE WIRES DOWN",
        "ADDR:7488 RANDALL RD",
        "CITY:LE ROY",
        "X:LAKE STREET RD, NORTH STREET RD / WEST BERGEN RD",
        "DATE:05/29/13",
        "TIME:12:56",
        "ID:2013-00000115");

    doTest("T18",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 23 E  MAIN ST , LE ROY - ** SMOKE ALARM ** TRIGON PK / TRIGON PK ** 05/29/13 11:54 ** 2013-00000114 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - SMOKE ALARM",
        "ADDR:23 E  MAIN ST",
        "CITY:LE ROY",
        "X:TRIGON PK / TRIGON PK",
        "DATE:05/29/13",
        "TIME:11:54",
        "ID:2013-00000114");

    doTest("T19",
        "(Dispatch) Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7158 W  MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T20",
        "(Dispatch) Fire Wire Down ** ** 7152 W MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7152 W MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T21",
        "(Dispatch) Unit:701 Status:Dispatched Fire Wire Down ** ** 7158 W  MAIN RD , LE ROY - ** ELECTRIC POLE ON FIRE - NOW SMOKING ** EAST BETHANY LE ROY RD / KEENEY RD ** 05/28/13 10:57 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Wire Down - ELECTRIC POLE ON FIRE - NOW SMOKING",
        "ADDR:7158 W  MAIN RD",
        "CITY:LE ROY",
        "X:EAST BETHANY LE ROY RD / KEENEY RD",
        "DATE:05/28/13",
        "TIME:10:57",
        "ID:2013-00000113");

    doTest("T22",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** LeRoy Meadows Apartments** 18 GENESEE ST , LE ROY - BLDG 7 ** FIRE ALARM ACTIVATION  ** LATHROP AVE / NORTH ST ** 05/27/13 06:26 ** 2013-00000112 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - FIRE ALARM ACTIVATION",
        "PLACE:LeRoy Meadows Apartments",
        "ADDR:18 GENESEE ST",
        "CITY:LE ROY",
        "APT:BLDG 7",
        "X:LATHROP AVE / NORTH ST",
        "DATE:05/27/13",
        "TIME:06:26",
        "ID:2013-00000112");

    doTest("T23",
        "(Dispatch) EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** UNRESPONSIVE MALE  ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - UNRESPONSIVE MALE",
        "ADDR:8408 CIRCULAR HILL RD",
        "CITY:LE ROY",
        "X:UNKNOWN / WILCOX RD",
        "DATE:05/27/13",
        "TIME:04:37",
        "ID:2013-00000519");

    doTest("T24",
        "(Dispatch) Unit:701 Status:Dispatched EMD Delta ** ** 8408 CIRCULAR HILL RD , LE ROY - ** ** UNKNOWN / WILCOX RD ** 05/27/13 04:37 ** 2013-00000519 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:EMD Delta",
        "ADDR:8408 CIRCULAR HILL RD",
        "CITY:LE ROY",
        "X:UNKNOWN / WILCOX RD",
        "DATE:05/27/13",
        "TIME:04:37",
        "ID:2013-00000519");

    doTest("T25",
        "(Dispatch) Unit:701 Status:Dispatched Fire Investigation ** ** 94 MYRTLE ST , LE ROY - ** BURNED FOOD ON STOVE/SMOKE IN RESIDENCE ** CRAIGIE ST / GILBERT ST, ROYAL DR ** 05/24/13 02:23 ** 2013-00000110 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Fire Investigation - BURNED FOOD ON STOVE/SMOKE IN RESIDENCE",
        "ADDR:94 MYRTLE ST",
        "CITY:LE ROY",
        "X:CRAIGIE ST / GILBERT ST, ROYAL DR",
        "DATE:05/24/13",
        "TIME:02:23",
        "ID:2013-00000110");

    doTest("T26",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T27",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T28",
        "(Dispatch) Unit:702 Status:Dispatched Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:702",
        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:11124 SAINT MARYS ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WOODROW DR / DEAD END",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T29",
        "(Dispatch) Unit:701 Status:Dispatched Alarm Fire ** ** 9200 ASBURY RD , LE ROY - ** FIRE ALARM ** E MAIN RD / HARRIS RD ** 05/20/13 14:47 ** 2013-00000107 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Alarm Fire - FIRE ALARM",
        "ADDR:9200 ASBURY RD",
        "CITY:LE ROY",
        "X:E MAIN RD / HARRIS RD",
        "DATE:05/20/13",
        "TIME:14:47",
        "ID:2013-00000107");

    doTest("T30",
        "(Dispatch) Unit:701 Status:Dispatched Acc PIAA ** ** 94 W MAIN ST , LE ROY - ** 2 CAR PIAA ** ROYAL DR / WEST AVE ** 05/16/13 17:10 ** 2013-00000106 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:701",
        "CALL:Acc PIAA - 2 CAR PIAA",
        "ADDR:94 W MAIN ST",
        "CITY:LE ROY",
        "X:ROYAL DR / WEST AVE",
        "DATE:05/16/13",
        "TIME:17:10",
        "ID:2013-00000106");
 
  }
  
  @Test
  public void testTownOfAlabamaFire() {

    doTest("T1",
        "(Dispatch) Unit:AL19 Status:Dispatched ** EMD Echo ** ** 1750 ROBERTS RD , ALABAMA ** ** ** SOUR SPRINGS RD / KNOWLESVILLE RD ** 06/14/13 19:13 ** 2013-00000140\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Echo",
        "ADDR:1750 ROBERTS RD",
        "CITY:ALABAMA",
        "X:SOUR SPRINGS RD / KNOWLESVILLE RD",
        "DATE:06/14/13",
        "TIME:19:13",
        "ID:2013-00000140");

    doTest("T2",
        "(Dispatch) Unit:151 Status:Dispatched ** EMD Charlie ** ** 385 BLOOMINGDALE RD , TONAWANDA IR ** ** 26 YO MALE WITH DIFFICULTY BREATHING ** SHANKS RD / MARTIN RD ** 06/13/13 19:44 ** 2013-00000126\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - 26 YO MALE WITH DIFFICULTY BREATHING",
        "ADDR:385 BLOOMINGDALE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:SHANKS RD / MARTIN RD",
        "DATE:06/13/13",
        "TIME:19:44",
        "ID:2013-00000126");

    doTest("T3",
        "(Dispatch) EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53YOF ABD PAIN  ** LONE RD / SKYE RD ** 06/11/13 11:48 ** 2013-00000138 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 53YOF ABD PAIN",
        "ADDR:6925 COUNCIL HOUSE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:LONE RD / SKYE RD",
        "DATE:06/11/13",
        "TIME:11:48",
        "ID:2013-00000138");

    doTest("T4",
        "(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** ** LONE RD / SKYE RD ** 06/11/13 11:48 ** 2013-00000138 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Charlie",
        "ADDR:6925 COUNCIL HOUSE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:LONE RD / SKYE RD",
        "DATE:06/11/13",
        "TIME:11:48",
        "ID:2013-00000138");

    doTest("T5",
        "(Dispatch) EMD Charlie ** ** 734 BLOOMINGDALE RD , TONAWANDA IR - ** 37 YO FEMALE WITH SEVERE HEADACHE ** POODRY RD / REUBEN RD ** 06/10/13 17:12 ** 2013-00000137 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 37 YO FEMALE WITH SEVERE HEADACHE",
        "ADDR:734 BLOOMINGDALE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:POODRY RD / REUBEN RD",
        "DATE:06/10/13",
        "TIME:17:12",
        "ID:2013-00000137");

    doTest("T6",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 734 BLOOMINGDALE RD , TONAWANDA IR - ** ** POODRY RD / REUBEN RD ** 06/10/13 17:12 ** 2013-00000137 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie",
        "ADDR:734 BLOOMINGDALE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:POODRY RD / REUBEN RD",
        "DATE:06/10/13",
        "TIME:17:12",
        "ID:2013-00000137");

    doTest("T7",
        "(Dispatch) Unit:AL19 Status:Dispatched Alarm EMS ** Leisure Timers Apartments** 364 BLOOMINGDALE RD , ALABAMA - 105 ** UNRESPONSIVE  ** SHANKS RD / TESNOW RD ** 06/10/13 08:42 ** 2013-00000136 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:Alarm EMS - UNRESPONSIVE",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "APT:105",
        "X:SHANKS RD / TESNOW RD",
        "DATE:06/10/13",
        "TIME:08:42",
        "ID:2013-00000136");

    doTest("T8",
        "(Dispatch) EMD Delta ** ** 890 JUDGE RD , TONAWANDA IR - ** 50 YO MALE NOT ALERT IS BREATHING ** GRIFFEN RD / POODRY RD ** 06/09/13 20:22 ** 2013-00002406 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 50 YO MALE NOT ALERT IS BREATHING",
        "ADDR:890 JUDGE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:GRIFFEN RD / POODRY RD",
        "DATE:06/09/13",
        "TIME:20:22",
        "ID:2013-00002406");

    doTest("T9",
        "(Dispatch) Unit:151 Status:Dispatched EMD Delta ** ** 890 JUDGE RD , TONAWANDA IR - ** ** GRIFFEN RD / POODRY RD ** 06/09/13 20:22 ** 2013-00002406 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Delta",
        "ADDR:890 JUDGE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:GRIFFEN RD / POODRY RD",
        "DATE:06/09/13",
        "TIME:20:22",
        "ID:2013-00002406");

    doTest("T10",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53 YO FEMALE ABDOMINAL PAIN ** LONE RD / SKYE RD ** 06/09/13 07:58 ** 2013-00000134 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - 53 YO FEMALE ABDOMINAL PAIN",
        "ADDR:6925 COUNCIL HOUSE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:LONE RD / SKYE RD",
        "DATE:06/09/13",
        "TIME:07:58",
        "ID:2013-00000134");

    doTest("T11",
        "(Dispatch) Unit:AL19 Status:Dispatched Acc PIAA ** Doc's Smoke Shop** 672 BLOOMINGDALE RD , TONAWANDA IR - ** 2 CARS ** POODRY RD / SANDHILL RD, MEADVILLE RD ** 06/08/13 15:29 ** 2013-00001356 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:Acc PIAA - 2 CARS",
        "PLACE:Doc's Smoke Shop",
        "ADDR:672 BLOOMINGDALE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:POODRY RD / SANDHILL RD, MEADVILLE RD",
        "DATE:06/08/13",
        "TIME:15:29",
        "ID:2013-00001356");

    doTest("T12",
        "(Dispatch) EMD Charlie ** ** 895 LEWISTON RD , ALABAMA - ** 19 YO FEMALE WITH A SEIZURE ** CASEY RD / FEEDER RD ** 06/07/13 23:43 ** 2013-00000132 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 19 YO FEMALE WITH A SEIZURE",
        "ADDR:895 LEWISTON RD",
        "CITY:ALABAMA",
        "X:CASEY RD / FEEDER RD",
        "DATE:06/07/13",
        "TIME:23:43",
        "ID:2013-00000132");

    doTest("T13",
        "(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 895 LEWISTON RD , ALABAMA - ** ** CASEY RD / FEEDER RD ** 06/07/13 23:43 ** 2013-00000132 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Charlie",
        "ADDR:895 LEWISTON RD",
        "CITY:ALABAMA",
        "X:CASEY RD / FEEDER RD",
        "DATE:06/07/13",
        "TIME:23:43",
        "ID:2013-00000132");

    doTest("T14",
        "(Dispatch) EMD Charlie ** ** 2251 JUDGE RD , ALABAMA - ** 40 YO FEMALE W/ ABDOMINAL PAIN ** MAPLE RD, KNOWLESVILLE RD / MORGAN RD ** 06/07/13 04:55 ** 2013-00000131 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 40 YO FEMALE W/ ABDOMINAL PAIN",
        "ADDR:2251 JUDGE RD",
        "CITY:ALABAMA",
        "X:MAPLE RD, KNOWLESVILLE RD / MORGAN RD",
        "DATE:06/07/13",
        "TIME:04:55",
        "ID:2013-00000131");

    doTest("T15",
        "(Dispatch) Unit:AL19 Status:Dispatched EMD Charlie ** ** 2251 JUDGE RD , ALABAMA - ** ** MAPLE RD, KNOWLESVILLE RD / MORGAN RD ** 06/07/13 04:55 ** 2013-00000131 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Charlie",
        "ADDR:2251 JUDGE RD",
        "CITY:ALABAMA",
        "X:MAPLE RD, KNOWLESVILLE RD / MORGAN RD",
        "DATE:06/07/13",
        "TIME:04:55",
        "ID:2013-00000131");

    doTest("T17",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 6925 COUNCIL HOUSE RD , TONAWANDA IR - ** 53 YO FEMALE ABDOMINAL PAIN ** LONE RD / SKYE RD ** 06/01/13 21:00 ** 2013-00000129 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - 53 YO FEMALE ABDOMINAL PAIN",
        "ADDR:6925 COUNCIL HOUSE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:LONE RD / SKYE RD",
        "DATE:06/01/13",
        "TIME:21:00",
        "ID:2013-00000129");

    doTest("T18",
        "(Dispatch) EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** 51 yo male semi cons ** No Cross Streets Found ** 06/01/13 19:40 ** 2013-00000128 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 51 yo male semi cons",
        "ADDR:7536 SAND HILL RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "DATE:06/01/13",
        "TIME:19:40",
        "ID:2013-00000128");

    doTest("T19",
        "(Dispatch) Unit:AL19 Status:Dispatched EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** ** No Cross Streets Found ** 06/01/13 19:40 ** 2013-00000128 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Delta",
        "ADDR:7536 SAND HILL RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "DATE:06/01/13",
        "TIME:19:40",
        "ID:2013-00000128");

    doTest("T20",
        "(Dispatch) Fire Grass ** ** 890 JUDGE RD , TONAWANDA IR - ** FIELD FIRE - UNKNOWN ADDRESS ** GRIFFEN RD / POODRY RD ** 06/01/13 15:12 ** 2013-00000127 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Grass - FIELD FIRE - UNKNOWN ADDRESS",
        "ADDR:890 JUDGE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:GRIFFEN RD / POODRY RD",
        "DATE:06/01/13",
        "TIME:15:12",
        "ID:2013-00000127");

    doTest("T21",
        "(Dispatch) Unit:151 Status:Dispatched Fire Grass ** ** JUDGE RD , ALLEGHANY RD ALABAMA - ** FIELD FIRE - UNKNOWN ADDRESS ** ** 06/01/13 15:12 ** 2013-00000127 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:Fire Grass - FIELD FIRE - UNKNOWN ADDRESS",
        "ADDR:JUDGE RD & ALLEGHANY RD",
        "CITY:ALABAMA",
        "DATE:06/01/13",
        "TIME:15:12",
        "ID:2013-00000127");

    doTest("T22",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** Leisure Timers Apartments** 364 BLOOMINGDALE RD , ALABAMA - Apt 206 ** 52 YO FEMALE WITH DIFFICULTY BREATHING ** SHANKS RD / TESNOW RD ** 05/30/13 13:36 ** 2013-00000126 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - 52 YO FEMALE WITH DIFFICULTY BREATHING",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "APT:Apt 206",
        "X:SHANKS RD / TESNOW RD",
        "DATE:05/30/13",
        "TIME:13:36",
        "ID:2013-00000126");

    doTest("T23",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 1323 SUMNER RD , ALABAMA - ** 86 YO FEMALE WITH DIFFICULTY BREATHING ** DEAD END / ALLEGHANY RD ** 05/29/13 16:54 ** 2013-00000125 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - 86 YO FEMALE WITH DIFFICULTY BREATHING",
        "ADDR:1323 SUMNER RD",
        "CITY:ALABAMA",
        "X:DEAD END / ALLEGHANY RD",
        "DATE:05/29/13",
        "TIME:16:54",
        "ID:2013-00000125");

    doTest("T24",
        "(Dispatch) Unit:151 Status:Dispatched Fire Grass ** ** 649 BLOOMINGDALE RD , TONAWANDA IR - ** FIELD ON FIRE ** SANDHILL RD, MEADVILLE RD / POODRY RD ** 05/26/13 10:47 ** 2013-00000124 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:Fire Grass - FIELD ON FIRE",
        "ADDR:649 BLOOMINGDALE RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "X:SANDHILL RD, MEADVILLE RD / POODRY RD",
        "DATE:05/26/13",
        "TIME:10:47",
        "ID:2013-00000124");

    doTest("T25",
        "(Dispatch) Unit:151 Status:Dispatched EMD Delta ** ** 7536 SAND HILL RD , TONAWANDA IR - ** 51 YO Male - semi alert ** No Cross Streets Found ** 05/24/13 15:51 ** 2013-00000123 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Delta - 51 YO Male - semi alert",
        "ADDR:7536 SAND HILL RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "DATE:05/24/13",
        "TIME:15:51",
        "ID:2013-00000123");

    doTest("T26",
        "(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - 206 ** DIFF BREATHING ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - DIFF BREATHING",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "APT:206",
        "X:SHANKS RD / TESNOW RD",
        "DATE:05/23/13",
        "TIME:10:00",
        "ID:2013-00000122");

    doTest("T27",
        "(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** DIFF BREATHING ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - DIFF BREATHING",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "X:SHANKS RD / TESNOW RD",
        "DATE:05/23/13",
        "TIME:10:00",
        "ID:2013-00000122");

    doTest("T28",
        "(Dispatch) EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "X:SHANKS RD / TESNOW RD",
        "DATE:05/23/13",
        "TIME:10:00",
        "ID:2013-00000122");

    doTest("T29",
        "(Dispatch) Unit:AL19 Status:Dispatched EMD Delta ** Leisure Timers Apartments ** 364 BLOOMINGDALE RD , ALABAMA - ** ** SHANKS RD / TESNOW RD ** 05/23/13 10:00 ** 2013-00000122 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:AL19",
        "CALL:EMD Delta",
        "PLACE:Leisure Timers Apartments",
        "ADDR:364 BLOOMINGDALE RD",
        "CITY:ALABAMA",
        "X:SHANKS RD / TESNOW RD",
        "DATE:05/23/13",
        "TIME:10:00",
        "ID:2013-00000122");

    doTest("T31",
        "(Dispatch) Unit:151 Status:Dispatched EMD Charlie ** ** 7712 SAND HILL RD , TONAWANDA IR - ** MALE WITH ABDOMINAL PAINS ** No Cross Streets Found ** 05/21/13 19:43 ** 2013-00000121 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:151",
        "CALL:EMD Charlie - MALE WITH ABDOMINAL PAINS",
        "ADDR:7712 SAND HILL RD",
        "CITY:TONAWANDA INDIAN RESERVATION",
        "DATE:05/21/13",
        "TIME:19:43",
        "ID:2013-00000121");

  }
  
  @Test
  public void testStaffordFireDepartment() {

    doTest("T1",
        "(Dispatch) Unit:ST91 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST91",
        "CALL:Fire Structure - Barn Fire",
        "ADDR:6638 ELLICOTT STREET RD",
        "CITY:PAVILION",
        "X:SPARKS RD / STARR RD, COOK RD",
        "DATE:06/15/13",
        "TIME:01:48",
        "ID:2013-00000107");

    doTest("T2",
        "(Dispatch) Unit:951 Status:Dispatched ** EMD Charlie ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD ** ** ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 06/15/13 00:25 ** 2013-00000107\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:EMD Charlie",
        "PLACE:STAFFORD FIRE DEPT.",
        "ADDR:6153 MAIN RD",
        "CITY:STAFFORD",
        "X:TRANSIT RD, RT 237 / CLIPNOCK RD",
        "DATE:06/15/13",
        "TIME:00:25",
        "ID:2013-00000107");

    doTest("T3",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 5511 SCHOOL RD , STAFFORD - ** 55YOM TROUBLE BREATHING  ** UNKNOWN / BYRON RD ** 06/11/13 23:31 ** 2013-00000106 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Charlie - 55YOM TROUBLE BREATHING",
        "ADDR:5511 SCHOOL RD",
        "CITY:STAFFORD",
        "X:UNKNOWN / BYRON RD",
        "DATE:06/11/13",
        "TIME:23:31",
        "ID:2013-00000106");

    doTest("T4",
        "(Dispatch) Unit:951 Status:Dispatched EMD Delta ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD - ** 54 YOF PSYNCOPE NOT ALERT TROUBLE BREATHING ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 06/11/13 14:46 ** 2013-00000105 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:EMD Delta - 54 YOF PSYNCOPE NOT ALERT TROUBLE BREATHING",
        "PLACE:STAFFORD FIRE DEPT.",
        "ADDR:6153 MAIN RD",
        "CITY:STAFFORD",
        "X:TRANSIT RD, RT 237 / CLIPNOCK RD",
        "DATE:06/11/13",
        "TIME:14:46",
        "ID:2013-00000105");

    doTest("T5",
        "(Dispatch) Unit:951 Status:Dispatched Fire CO Detector ** ** 8597 PROLE RD , STAFFORD - ** CO DETECTOR  ** UNKNOWN / HORSESHOE LAKE RD ** 06/09/13 11:50 ** 2013-00000104 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire CO Detector - CO DETECTOR",
        "ADDR:8597 PROLE RD",
        "CITY:STAFFORD",
        "X:UNKNOWN / HORSESHOE LAKE RD",
        "DATE:06/09/13",
        "TIME:11:50",
        "ID:2013-00000104");

    doTest("T6",
        "(Dispatch) Fire Auto ** ** 5729 MAIN RD , STAFFORD - ** CAR FIRE ** FARGO RD, PROLE RD / SANDERS RD ** 06/06/13 23:22 ** 2013-00012599 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Auto - CAR FIRE",
        "ADDR:5729 MAIN RD",
        "CITY:STAFFORD",
        "X:FARGO RD, PROLE RD / SANDERS RD",
        "DATE:06/06/13",
        "TIME:23:22",
        "ID:2013-00012599");

    doTest("T7",
        "(Dispatch) Unit:951 Status:Dispatched Fire Auto ** HANSON AGGREGATES PLANT 464 STAFFORD** 5870 MAIN RD , STAFFORD - ** CAR FIRE ** UNKNOWN / SANDERS RD ** 06/06/13 23:22 ** 2013-00012599 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Auto - CAR FIRE",
        "PLACE:HANSON AGGREGATES PLANT 464 STAFFORD",
        "ADDR:5870 MAIN RD",
        "CITY:STAFFORD",
        "X:UNKNOWN / SANDERS RD",
        "DATE:06/06/13",
        "TIME:23:22",
        "ID:2013-00012599");

    doTest("T8",
        "(Dispatch) Unit:ST95 Status:Dispatched Fire Structure ** ** 5942 GRISWOLD RD , STAFFORD - ** SMOKE IN THE RESIDENCE ** CASWELL RD / GODFREYS POND ** 06/05/13 17:29 ** 2013-00000102 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:Fire Structure - SMOKE IN THE RESIDENCE",
        "ADDR:5942 GRISWOLD RD",
        "CITY:STAFFORD",
        "X:CASWELL RD / GODFREYS POND",
        "DATE:06/05/13",
        "TIME:17:29",
        "ID:2013-00000102");

    doTest("T9",
        "(Dispatch) Unit:951 Status:Dispatched Fire Nat Propane Gas ** ** 7763 BYRON RD , STAFFORD - ** SMELL OF PROPANE GAS INSIDE RESIDENCE ** GRISWOLD RD / WALKERS CORNER RD ** 06/04/13 17:37 ** 2013-00000101 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Nat Propane Gas - SMELL OF PROPANE GAS INSIDE RESIDENCE",
        "ADDR:7763 BYRON RD",
        "CITY:STAFFORD",
        "X:GRISWOLD RD / WALKERS CORNER RD",
        "DATE:06/04/13",
        "TIME:17:37",
        "ID:2013-00000101");

    doTest("T10",
        "(Dispatch) Unit:ST94 Status:Dispatched Fire Wire Down ** ** 6488 RANDALL RD , STAFFORD - ** UNKOWN TYPE WIRES DOWN  ** BUCKLEY RD / RICHMOND RD ** 05/29/13 12:56 ** 2013-00000115 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST94",
        "CALL:Fire Wire Down - UNKOWN TYPE WIRES DOWN",
        "ADDR:6488 RANDALL RD",
        "CITY:STAFFORD",
        "X:BUCKLEY RD / RICHMOND RD",
        "DATE:05/29/13",
        "TIME:12:56",
        "ID:2013-00000115");

    doTest("T11",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Alpha ** ** 8122 BYRON RD , STAFFORD - ** ** BATAVIA STAFFORD TOWNLINE RD / PROLE ROAD EXT ** 05/28/13 08:21 ** 2013-00000099 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Alpha",
        "ADDR:8122 BYRON RD",
        "CITY:STAFFORD",
        "X:BATAVIA STAFFORD TOWNLINE RD / PROLE ROAD EXT",
        "DATE:05/28/13",
        "TIME:08:21",
        "ID:2013-00000099");

    doTest("T12",
        "(Dispatch) EMD Echo ** Golden Mobile Home Park** 5610 MAIN RD , STAFFORD - LOT 15 ** TROUBLE BREATHING ** UNKNOWN / FARGO RD, PROLE RD ** 05/28/13 01:28 ** 2013-00000098 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Echo - TROUBLE BREATHING",
        "PLACE:Golden Mobile Home Park",
        "ADDR:5610 MAIN RD",
        "CITY:STAFFORD",
        "APT:LOT 15",
        "X:UNKNOWN / FARGO RD, PROLE RD",
        "DATE:05/28/13",
        "TIME:01:28",
        "ID:2013-00000098");

    doTest("T13",
        "(Dispatch) Unit:ST95 Status:Dispatched Medical ** Golden Mobile Home Park** 5610 MAIN RD , STAFFORD - LOT 15 ** TROUBLE BREATHING ** UNKNOWN / FARGO RD, PROLE RD ** 05/28/13 01:28 ** 2013-00000098 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:Medical - TROUBLE BREATHING",
        "PLACE:Golden Mobile Home Park",
        "ADDR:5610 MAIN RD",
        "CITY:STAFFORD",
        "APT:LOT 15",
        "X:UNKNOWN / FARGO RD, PROLE RD",
        "DATE:05/28/13",
        "TIME:01:28",
        "ID:2013-00000098");

    doTest("T14",
        "(Dispatch) Unit:951 Status:Dispatched Acc PIAA ** ** 6742 EAST BETHANY LE ROY RD , STAFFORD - ** MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN ** COVELL RD / WESTCOTT RD ** 05/27/13 16:15 ** 2013-00000097 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Acc PIAA - MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN",
        "ADDR:6742 EAST BETHANY LE ROY RD",
        "CITY:STAFFORD",
        "X:COVELL RD / WESTCOTT RD",
        "DATE:05/27/13",
        "TIME:16:15",
        "ID:2013-00000097");

    doTest("T15",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 9134 BATER RD , STAFFORD - PH ** SICK FEMALE ** SWEETLAND RD, COLE RD / MAIN RD, NILESVILLE RD, W MAIN RD ** 05/27/13 09:35 ** 2013-00000096 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Charlie - SICK FEMALE",
        "ADDR:9134 BATER RD",
        "CITY:STAFFORD",
        "APT:PH",
        "X:SWEETLAND RD, COLE RD / MAIN RD, NILESVILLE RD, W MAIN RD",
        "DATE:05/27/13",
        "TIME:09:35",
        "ID:2013-00000096");

    doTest("T16",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Charlie ** ** 6303 MAIN RD , STAFFORD - APT 8 ** 50YOF CHEST PAIN  ** UNKNOWN / TRANSIT RD, RT 237 ** 05/21/13 13:09 ** 2013-00000095 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Charlie - 50YOF CHEST PAIN",
        "ADDR:6303 MAIN RD",
        "CITY:STAFFORD",
        "APT:8",
        "X:UNKNOWN / TRANSIT RD, RT 237",
        "DATE:05/21/13",
        "TIME:13:09",
        "ID:2013-00000095");

    doTest("T17",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T18",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T19",
        "(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:11124 SAINT MARYS ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WOODROW DR / DEAD END",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T20",
        "(Dispatch) Unit:951 Status:Dispatched EMD Charlie ** ** 5387 MAIN RD , STAFFORD - ** 61 YOM DIABETIC PROBLEM ** BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD ** 05/20/13 23:15 ** 2013-00000093 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:EMD Charlie - 61 YOM DIABETIC PROBLEM",
        "ADDR:5387 MAIN RD",
        "CITY:STAFFORD",
        "X:BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD",
        "DATE:05/20/13",
        "TIME:23:15",
        "ID:2013-00000093");

    doTest("T21",
        "(Dispatch) Unit:951 Status:Dispatched Domestic ** ** 5374 MAIN RD , STAFFORD - ** 18YR OLD FEMALE HITING CALLER ** BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD ** 05/19/13 11:02 ** 2013-00001186 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Domestic - 18YR OLD FEMALE HITING CALLER",
        "ADDR:5374 MAIN RD",
        "CITY:STAFFORD",
        "X:BATAVIA STAFFORD TOWNLINE RD / FARGO RD, PROLE RD",
        "DATE:05/19/13",
        "TIME:11:02",
        "ID:2013-00001186");

    doTest("T22",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Delta ** Red Osier** 6492 MAIN RD , STAFFORD - ** TROUBLE BREATHING ** UNKNOWN / ROANOKE RD ** 05/18/13 19:42 ** 2013-00002068 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Delta - TROUBLE BREATHING",
        "PLACE:Red Osier",
        "ADDR:6492 MAIN RD",
        "CITY:STAFFORD",
        "X:UNKNOWN / ROANOKE RD",
        "DATE:05/18/13",
        "TIME:19:42",
        "ID:2013-00002068");

    doTest("T23",
        "(Dispatch) Unit:ST95 Status:Dispatched Animal Complaint ** ** 6284 MAIN RD , STAFFORD - ** dog bite  ** UNKNOWN / TRANSIT RD, RT 237 ** 05/17/13 11:08 ** 2013-00010862 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:Animal Complaint - dog bite",
        "ADDR:6284 MAIN RD",
        "CITY:STAFFORD",
        "X:UNKNOWN / TRANSIT RD, RT 237",
        "DATE:05/17/13",
        "TIME:11:08",
        "ID:2013-00010862");

    doTest("T24",
        "(Dispatch) Unit:951 Status:Dispatched EMD Bravo ** ** 8771 RT 237 , STAFFORD - ** 86 YO MALE WITH HEAD INJURY ** TRANSIT RD, MAIN RD / PRENTICE RD ** 05/14/13 15:03 ** 2013-00000089 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:EMD Bravo - 86 YO MALE WITH HEAD INJURY",
        "ADDR:8771 RT 237",
        "CITY:STAFFORD",
        "X:TRANSIT RD, MAIN RD / PRENTICE RD",
        "DATE:05/14/13",
        "TIME:15:03",
        "ID:2013-00000089");

    doTest("T25",
        "(Dispatch) Unit:ST95 Status:Dispatched EMD Alpha ** ** 6180 EAST MORGANVILLE RD , STAFFORD - ** AB PAIN 32YRO MALE ** MORGANVILLE RD / RT 237, RANDALL RD ** 05/14/13 14:11 ** 2013-00000088 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:EMD Alpha - AB PAIN 32YRO MALE",
        "ADDR:6180 EAST MORGANVILLE RD",
        "CITY:STAFFORD",
        "X:MORGANVILLE RD / RT 237, RANDALL RD",
        "DATE:05/14/13",
        "TIME:14:11",
        "ID:2013-00000088");

    doTest("T26",
        "(Dispatch) Unit:951 Status:Dispatched Fire Mutual Aid ** STAFFORD FIRE DEPT.** 6153 MAIN RD , STAFFORD - ** STAND BY IN QUARTERS ** TRANSIT RD, RT 237 / CLIPNOCK RD ** 05/12/13 15:17 ** 2013-00000087 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Mutual Aid - STAND BY IN QUARTERS",
        "PLACE:STAFFORD FIRE DEPT.",
        "ADDR:6153 MAIN RD",
        "CITY:STAFFORD",
        "X:TRANSIT RD, RT 237 / CLIPNOCK RD",
        "DATE:05/12/13",
        "TIME:15:17",
        "ID:2013-00000087");

    doTest("T27",
        "(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 5693 GRISWOLD RD , STAFFORD - ** possible electrical fire in wall ** GODFREYS POND / BYRON RD ** 05/11/13 23:19 ** 2013-00000086 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Structure - possible electrical fire in wall",
        "ADDR:5693 GRISWOLD RD",
        "CITY:STAFFORD",
        "X:GODFREYS POND / BYRON RD",
        "DATE:05/11/13",
        "TIME:23:19",
        "ID:2013-00000086");

    doTest("T28",
        "(Dispatch) Fire Structure ** ** 5691 ELLICOTT STREET RD , BETHANY - ** SHED FIRE ** PAUL RD / FARGO RD ** 05/11/13 19:00 ** 2013-00000048 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - SHED FIRE",
        "ADDR:5691 ELLICOTT STREET RD",
        "CITY:BETHANY",
        "X:PAUL RD / FARGO RD",
        "DATE:05/11/13",
        "TIME:19:00",
        "ID:2013-00000048");

    doTest("T29",
        "(Dispatch) Unit:ST92 Status:Dispatched Fire Structure ** ** ELLICOTT STREET RD , PAUL RD BETHANY - ** SHED FIRE ** ** 05/11/13 19:00 ** 2013-00000048 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST92",
        "CALL:Fire Structure - SHED FIRE",
        "ADDR:ELLICOTT STREET RD & PAUL RD",
        "CITY:BETHANY",
        "DATE:05/11/13",
        "TIME:19:00",
        "ID:2013-00000048");

    doTest("T30",
        "(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 9615 TRANSIT RD , STAFFORD - ** BARN STRUCK BY LIGHTNING ** WESTACOTT RD / EAST BETHANY LE ROY RD ** 05/10/13 17:40 ** 2013-00000084 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Structure - BARN STRUCK BY LIGHTNING",
        "ADDR:9615 TRANSIT RD",
        "CITY:STAFFORD",
        "X:WESTACOTT RD / EAST BETHANY LE ROY RD",
        "DATE:05/10/13",
        "TIME:17:40",
        "ID:2013-00000084");
    
  }
  
  @Test
  public void testGeneseeCountyEmergencyServices() {

    doTest("T1",
        "(Dispatch) Unit:801 Status:Dispatched ** Fire Structure ** ** 6638 ELLICOTT STREET RD , PAVILION ** ** Barn Fire ** SPARKS RD / STARR RD, COOK RD ** 06/15/13 01:48 ** 2013-00000107\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:801",
        "CALL:Fire Structure - Barn Fire",
        "ADDR:6638 ELLICOTT STREET RD",
        "CITY:PAVILION",
        "X:SPARKS RD / STARR RD, COOK RD",
        "DATE:06/15/13",
        "TIME:01:48",
        "ID:2013-00000107");

    doTest("T2",
        "(Dispatch) Unit:GM2 Status:Dispatched Fire HazMat ** PEMBROKE SERVICE CENTER** 8319 INDIAN FALLS RD , PEMBROKE - ** DIESEL FUEL LEAK FROM TRACTOR TRAILER ** CLEVELAND RD / PRATT RD ** 06/07/13 15:31 ** 2013-00000119 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:GM2",
        "CALL:Fire HazMat - DIESEL FUEL LEAK FROM TRACTOR TRAILER",
        "PLACE:PEMBROKE SERVICE CENTER",
        "ADDR:8319 INDIAN FALLS RD",
        "CITY:PEMBROKE",
        "X:CLEVELAND RD / PRATT RD",
        "DATE:06/07/13",
        "TIME:15:31",
        "ID:2013-00000119");

    doTest("T3",
        "(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 30 THOMAS AVE , BATAVIA - ** PORCH FIRE ** WASHINGTON AVE, LINCOLN AVE / W MAIN ST ** 06/06/13 22:37 ** 2013-00000840 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CB11",
        "CALL:Fire Structure - PORCH FIRE",
        "ADDR:30 THOMAS AVE",
        "CITY:BATAVIA",
        "X:WASHINGTON AVE, LINCOLN AVE / W MAIN ST",
        "DATE:06/06/13",
        "TIME:22:37",
        "ID:2013-00000840");

    doTest("T4",
        "(Dispatch) Unit:ST95 Status:Dispatched Fire Structure ** ** 5942 GRISWOLD RD , STAFFORD - ** SMOKE IN THE RESIDENCE ** CASWELL RD / GODFREYS POND ** 06/05/13 17:29 ** 2013-00000102 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:ST95",
        "CALL:Fire Structure - SMOKE IN THE RESIDENCE",
        "ADDR:5942 GRISWOLD RD",
        "CITY:STAFFORD",
        "X:CASWELL RD / GODFREYS POND",
        "DATE:06/05/13",
        "TIME:17:29",
        "ID:2013-00000102");

    doTest("T5",
        "(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - TRACTOR TRAILER FIRE NEXT TO BARN",
        "PLACE:Baskin Livestock",
        "ADDR:9778 CREEK RD",
        "CITY:BETHANY",
        "X:PUTNAM RD / COOK RD",
        "DATE:06/03/13",
        "TIME:08:56",
        "ID:2013-00000059");

    doTest("T6",
        "(Dispatch) Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side - TRACTOR TRAILER FIRE NEXT TO BARN  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - out side - TRACTOR TRAILER FIRE NEXT TO BARN",
        "PLACE:Baskin Livestock",
        "ADDR:9778 CREEK RD",
        "CITY:BETHANY",
        "X:PUTNAM RD / COOK RD",
        "DATE:06/03/13",
        "TIME:08:56",
        "ID:2013-00000059");

    doTest("T7",
        "(Dispatch) Unit:351 Status:Dispatched Fire Structure ** Baskin Livestock** 9778 CREEK RD , BETHANY - ** out side  ** PUTNAM RD / COOK RD ** 06/03/13 08:56 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:351",
        "CALL:Fire Structure - out side",
        "PLACE:Baskin Livestock",
        "ADDR:9778 CREEK RD",
        "CITY:BETHANY",
        "X:PUTNAM RD / COOK RD",
        "DATE:06/03/13",
        "TIME:08:56",
        "ID:2013-00000059");

    doTest("T8",
        "(Dispatch) Unit:GM1 Status:At Scene Traffic Stop ** ** CRAIGIE ST , W  MAIN ST LE ROY - ** SCENE MAY BE UNSECURE ** ** 06/03/13 04:50 ** 2013-00000033 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:GM1",
        "CALL:Traffic Stop - SCENE MAY BE UNSECURE",
        "ADDR:CRAIGIE ST & W MAIN ST",
        "CITY:LE ROY",
        "DATE:06/03/13",
        "TIME:04:50",
        "ID:2013-00000033");

    doTest("T9",
        "(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** Oatka Creek Public Fishing Stream NYS DEC** 8116 OATKA TRL , LE ROY - ** MOTORCYCLE VS TREE ** GULLY RD / CIRCULAR HILL RD ** 05/30/13 17:37 ** 2013-00000531 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:Acc PIAA - MOTORCYCLE VS TREE",
        "PLACE:Oatka Creek Public Fishing Stream NYS DEC",
        "ADDR:8116 OATKA TRL",
        "CITY:LE ROY",
        "X:GULLY RD / CIRCULAR HILL RD",
        "DATE:05/30/13",
        "TIME:17:37",
        "ID:2013-00000531");

    doTest("T10",
        "(Dispatch) Unit:MFW Status:Dispatched EMD Delta ** Applegrove Mobile Home Park** 3207 PRATT RD , BATAVIA - LOT 44 ** 52 YO FEMALE - CHEST PAIN ** APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK ** 05/29/13 14:01 ** 2013-00002226 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:EMD Delta - 52 YO FEMALE - CHEST PAIN",
        "PLACE:Applegrove Mobile Home Park",
        "ADDR:3207 PRATT RD",
        "CITY:BATAVIA",
        "APT:LOT 44",
        "X:APPLE GROVE MOBILE HOME PK / APPLE GROVE MOBILE HOME PK",
        "DATE:05/29/13",
        "TIME:14:01",
        "ID:2013-00002226");

    doTest("T11",
        "(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** BARN FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - BARN FIRE",
        "ADDR:8244 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T12",
        "(Dispatch) Fire Structure ** ** 8244 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - COMMERCIAL BUILDING FIRE",
        "ADDR:8244 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T13",
        "(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 8224 STATE STREET RD , BATAVIA - ** COMMERCIAL BUILDING FIRE ** STATE ST / I 90 ** 05/27/13 19:30 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Structure - COMMERCIAL BUILDING FIRE",
        "ADDR:8224 STATE STREET RD",
        "CITY:BATAVIA",
        "X:STATE ST / I 90",
        "DATE:05/27/13",
        "TIME:19:30",
        "ID:2013-00000113");

    doTest("T14",
        "(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** ** 6742 EAST BETHANY LE ROY RD , STAFFORD - ** MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN ** COVELL RD / WESTCOTT RD ** 05/27/13 16:15 ** 2013-00000097 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:Acc PIAA - MOTORCYCLE ACCIDENT MALE COMPLAINING OF SHOULDER PAIN",
        "ADDR:6742 EAST BETHANY LE ROY RD",
        "CITY:STAFFORD",
        "X:COVELL RD / WESTCOTT RD",
        "DATE:05/27/13",
        "TIME:16:15",
        "ID:2013-00000097");

    doTest("T15",
        "(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 222 RICHMOND AVE , BATAVIA - ** POSSIBLE ELECTRICAL FIRE OAK LODGE ** BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR ** 05/27/13 01:01 ** 2013-00000778 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CB11",
        "CALL:Fire Structure - POSSIBLE ELECTRICAL FIRE OAK LODGE",
        "ADDR:222 RICHMOND AVE",
        "CITY:BATAVIA",
        "X:BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR",
        "DATE:05/27/13",
        "TIME:01:01",
        "ID:2013-00000778");

    doTest("T16",
        "(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 34 WOODROW RD , BATAVIA - ** SMOKE COMING FROM UPSTAIRS WINDOWS ** SOCCIO ST / WEST AVE ** 05/22/13 08:42 ** 2013-00000753 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CB11",
        "CALL:Fire Structure - SMOKE COMING FROM UPSTAIRS WINDOWS",
        "ADDR:34 WOODROW RD",
        "CITY:BATAVIA",
        "X:SOCCIO ST / WEST AVE",
        "DATE:05/22/13",
        "TIME:08:42",
        "ID:2013-00000753");

    doTest("T17",
        "(Dispatch) Unit:751 Status:Dispatched Fire Structure ** ** 7574 S PEARL STREET RD , OAKFIELD - ** SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM ** No Cross Streets Found ** 05/21/13 18:02 ** 2013-00000120 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:751",
        "CALL:Fire Structure - SMOKE IN THE BASEMENT - ELECTRICAL PROBLEM",
        "ADDR:7574 S PEARL STREET RD",
        "CITY:OAKFIELD",
        "DATE:05/21/13",
        "TIME:18:02",
        "ID:2013-00000120");

    doTest("T18",
        "(Dispatch) Unit:MFW Status:Dispatched EMD Bravo ** ** 349 WRIGHT RD , ALABAMA - ** 61YO MALE FALLEN FROM LADDER - ANKLE INJURY ** TESNOW RD / DEAD END ** 05/21/13 11:21 ** 2013-00002106 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:EMD Bravo - 61YO MALE FALLEN FROM LADDER - ANKLE INJURY",
        "ADDR:349 WRIGHT RD",
        "CITY:ALABAMA",
        "X:TESNOW RD / DEAD END",
        "DATE:05/21/13",
        "TIME:11:21",
        "ID:2013-00002106");

    doTest("T19",
        "(Dispatch) Unit:MFW Status:Dispatched EMD Delta ** ** 1376 MAIN RD , PEMBROKE - ** 57 YO MALE POSS HEART ATTACK ** BOYCE RD / ALLEGHANY RD ** 05/21/13 07:48 ** 2013-00000071 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:EMD Delta - 57 YO MALE POSS HEART ATTACK",
        "ADDR:1376 MAIN RD",
        "CITY:PEMBROKE",
        "X:BOYCE RD / ALLEGHANY RD",
        "DATE:05/21/13",
        "TIME:07:48",
        "ID:2013-00000071");

    doTest("T20",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T21",
        "(Dispatch) Fire Structure ** ** 6918 HUTCHINSON ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WEST PARK ST / SAINT MARYS ST ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:6918 HUTCHINSON ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WEST PARK ST / SAINT MARYS ST",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T22",
        "(Dispatch) Fire Structure ** ** 11124 SAINT MARYS ST , PAVILION - FLR 2 ** REPORT FLAMES IN AREA ** WOODROW DR / DEAD END ** 05/20/13 23:36 ** 2013-00000094 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - REPORT FLAMES IN AREA",
        "ADDR:11124 SAINT MARYS ST",
        "CITY:PAVILION",
        "APT:FLR 2",
        "X:WOODROW DR / DEAD END",
        "DATE:05/20/13",
        "TIME:23:36",
        "ID:2013-00000094");

    doTest("T23",
        "(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 160 BANK ST , BATAVIA - ** ELECTRICAL FIRE IN BASEMENT ** NORTH ST / WASHINGTON AVE ** 05/20/13 22:40 ** 2013-00000743 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CB11",
        "CALL:Fire Structure - ELECTRICAL FIRE IN BASEMENT",
        "ADDR:160 BANK ST",
        "CITY:BATAVIA",
        "X:NORTH ST / WASHINGTON AVE",
        "DATE:05/20/13",
        "TIME:22:40",
        "ID:2013-00000743");

    doTest("T24",
        "(Dispatch) Unit:251 Status:Dispatched Fire Structure ** ** 3827 W  MAIN STREET RD , BATAVIA - ** HOUSE FIRE ** UNKNOWN / COUNTY BLDG ** 05/18/13 20:19 ** 2013-00000105 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:251",
        "CALL:Fire Structure - HOUSE FIRE",
        "ADDR:3827 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "X:UNKNOWN / COUNTY BLDG",
        "DATE:05/18/13",
        "TIME:20:19",
        "ID:2013-00000105");

    doTest("T25",
        "(Dispatch) Unit:MFW Status:Dispatched EMD Charlie ** Darien Lake State Park** 10475 HARLOW RD , DARIEN - SITE 34 ** 72 YO FEMALE POSS STROKE ** BROADWAY RD / SUMNER RD, FARGO RD ** 05/18/13 17:34 ** 2013-00000080 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:EMD Charlie - 72 YO FEMALE POSS STROKE",
        "PLACE:Darien Lake State Park",
        "ADDR:10475 HARLOW RD",
        "CITY:DARIEN",
        "APT:SITE 34",
        "X:BROADWAY RD / SUMNER RD, FARGO RD",
        "DATE:05/18/13",
        "TIME:17:34",
        "ID:2013-00000080");

    doTest("T26",
        "(Dispatch) Unit:MFW Status:Dispatched Acc PIAA ** ** 10 HUTCHINS PL , BATAVIA - ** 12YO FEMALE - FOOT RUN OVER BY FATHER IN DRIVEWAY ** STATE ST / LEWIS PL ** 05/18/13 17:47 ** 2013-00006314 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:Acc PIAA - 12YO FEMALE - FOOT RUN OVER BY FATHER IN DRIVEWAY",
        "ADDR:10 HUTCHINS PL",
        "CITY:BATAVIA",
        "X:STATE ST / LEWIS PL",
        "DATE:05/18/13",
        "TIME:17:47",
        "ID:2013-00006314");

    doTest("T27",
        "(Dispatch) Unit:CB11 Status:Dispatched Fire Structure ** ** 109 OAK ST , BATAVIA - ** SMOKE COMING FROM POWER OUTLET ** PICKTHORN DR / CECERE DR ** 05/15/13 15:46 ** 2013-00000713 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CB11",
        "CALL:Fire Structure - SMOKE COMING FROM POWER OUTLET",
        "ADDR:109 OAK ST",
        "CITY:BATAVIA",
        "X:PICKTHORN DR / CECERE DR",
        "DATE:05/15/13",
        "TIME:15:46",
        "ID:2013-00000713");

    doTest("T28",
        "(Dispatch) EMD Charlie ** ** 331 MAPLE RD , PEMBROKE - ** MF5 LANDING ZONE AT PEMBROKE FIRE HALL ** S LAKE RD / SIEHL RD, COUNTY LINE RD ** 05/15/13 08:46 ** 2013-00001998 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - MF5 LANDING ZONE AT PEMBROKE FIRE HALL",
        "ADDR:331 MAPLE RD",
        "CITY:PEMBROKE",
        "X:S LAKE RD / SIEHL RD, COUNTY LINE RD",
        "DATE:05/15/13",
        "TIME:08:46",
        "ID:2013-00001998");

    doTest("T29",
        "(Dispatch) Unit:MFW Status:Dispatched EMD Charlie ** ** 331 MAPLE RD , PEMBROKE - ** 81YO MALE POSS STROKE ** S LAKE RD / SIEHL RD, COUNTY LINE RD ** 05/15/13 08:46 ** 2013-00001998 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:MFW",
        "CALL:EMD Charlie - 81YO MALE POSS STROKE",
        "ADDR:331 MAPLE RD",
        "CITY:PEMBROKE",
        "X:S LAKE RD / SIEHL RD, COUNTY LINE RD",
        "DATE:05/15/13",
        "TIME:08:46",
        "ID:2013-00001998");

    doTest("T30",
        "(Dispatch) Unit:951 Status:Dispatched Fire Structure ** ** 5693 GRISWOLD RD , STAFFORD - ** possible electrical fire in wall ** GODFREYS POND / BYRON RD ** 05/11/13 23:19 ** 2013-00000086 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:951",
        "CALL:Fire Structure - possible electrical fire in wall",
        "ADDR:5693 GRISWOLD RD",
        "CITY:STAFFORD",
        "X:GODFREYS POND / BYRON RD",
        "DATE:05/11/13",
        "TIME:23:19",
        "ID:2013-00000086");

  }
  
  @Test
  public void testCorfuFireDepartment() {

    doTest("T1",
        "(Dispatch) Unit:CO41 Status:Dispatched ** EMD Alpha ** Pembroke Town Park** 8813 ALLEGHANY RD , PEMBROKE ** ** 12YO MALE WITH FACIAL LAC ** MAIN RD / COHOCTON RD ** 06/15/13 12:25 ** 2013-00000067\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Alpha - 12YO MALE WITH FACIAL LAC",
        "PLACE:Pembroke Town Park",
        "ADDR:8813 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:MAIN RD / COHOCTON RD",
        "DATE:06/15/13",
        "TIME:12:25",
        "ID:2013-00000067");

    doTest("T2",
        "(Dispatch) Unit:451 Status:Dispatched ** Missing Person ** ** 17 W  MAIN ST , CORFU ** ** chidren were picked up from school w/o permission ** PROSPECT ST / E MAIN ST, ALLEGHANY RD ** 06/14/13 17:40 ** 2013-00000534\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Missing Person - chidren were picked up from school w/o permission",
        "ADDR:17 W  MAIN ST",
        "CITY:CORFU",
        "X:PROSPECT ST / E MAIN ST, ALLEGHANY RD",
        "DATE:06/14/13",
        "TIME:17:40",
        "ID:2013-00000534");

    doTest("T3",
        "(Dispatch) EMD Delta ** ** 42 ALLEGHANY RD , CORFU - APT 1 ** 54 YOF - CHEST PAINS\n" +
        " ** W MAIN ST, E MAIN ST / WATER ST ** 06/11/13 01:29 ** 2013-00000065 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 54 YOF - CHEST PAINS",
        "ADDR:42 ALLEGHANY RD",
        "CITY:CORFU",
        "APT:1");

    doTest("T4",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 42 ALLEGHANY RD , CORFU - APT 1 ** ** W MAIN ST, E MAIN ST / WATER ST ** 06/11/13 01:29 ** 2013-00000065 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Delta",
        "ADDR:42 ALLEGHANY RD",
        "CITY:CORFU",
        "APT:1",
        "X:W MAIN ST, E MAIN ST / WATER ST",
        "DATE:06/11/13",
        "TIME:01:29",
        "ID:2013-00000065");

    doTest("T5",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 49 ALLEGHANY RD , CORFU - ** GREEN NEON IN LOT 26 YO MALE FEELS LIKE HE IS GOING TO PASS OUT ** W MAIN ST, E MAIN ST / WATER ST ** 06/09/13 20:43 ** 2013-00000064 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - GREEN NEON IN LOT 26 YO MALE FEELS LIKE HE IS GOING TO PASS OUT",
        "ADDR:49 ALLEGHANY RD",
        "CITY:CORFU",
        "X:W MAIN ST, E MAIN ST / WATER ST",
        "DATE:06/09/13",
        "TIME:20:43",
        "ID:2013-00000064");

    doTest("T6",
        "(Dispatch) Unit:451 Status:Dispatched Fire Mutual Aid ** CORFU FIRE DEPT.** 116 E  MAIN ST , CORFU - ** TO STANDBY IN QUARTERS ** GENESEE ST / THOMPSON DR ** 06/07/13 16:48 ** 2013-00000063 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Mutual Aid - TO STANDBY IN QUARTERS",
        "PLACE:CORFU FIRE DEPT.",
        "ADDR:116 E  MAIN ST",
        "CITY:CORFU",
        "X:GENESEE ST / THOMPSON DR",
        "DATE:06/07/13",
        "TIME:16:48",
        "ID:2013-00000063");

    doTest("T7",
        "(Dispatch) EMD Delta ** ** 31 E  MAIN ST , CORFU - ** 31yo fml chest pain  ** MAPLE AVE / LAWRENCE AVE ** 06/06/13 07:22 ** 2013-00000062 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 31yo fml chest pain",
        "ADDR:31 E  MAIN ST",
        "CITY:CORFU",
        "X:MAPLE AVE / LAWRENCE AVE",
        "DATE:06/06/13",
        "TIME:07:22",
        "ID:2013-00000062");

    doTest("T8",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 31 E  MAIN ST , CORFU - ** ** MAPLE AVE / LAWRENCE AVE ** 06/06/13 07:22 ** 2013-00000062 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Delta",
        "ADDR:31 E  MAIN ST",
        "CITY:CORFU",
        "X:MAPLE AVE / LAWRENCE AVE",
        "DATE:06/06/13",
        "TIME:07:22",
        "ID:2013-00000062");

    doTest("T9",
        "(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - ** SEMI VS CAR UNK INJ  ** FIELDCREST DR / PROSPECT ST ** 06/04/13 16:57 ** 2013-00000061 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Acc PIAA - SEMI VS CAR UNK INJ",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W  MAIN ST",
        "CITY:CORFU",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:06/04/13",
        "TIME:16:57",
        "ID:2013-00000061");

    doTest("T10",
        "(Dispatch) Unit:451 Status:Dispatched EMD Delta ** Genesee Heights Estates Mobile Home Park** 66 W MAIN ST , CORFU - LOT 9 ** 38WEEK PREGNANT FML - 6th CHILD - 2 MINS APART  ** GENESEE ST / FIELDCREST DR ** 05/30/13 14:00 ** 2013-00000060 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Delta - 38WEEK PREGNANT FML - 6th CHILD - 2 MINS APART",
        "PLACE:Genesee Heights Estates Mobile Home Park",
        "ADDR:66 W MAIN ST",
        "CITY:CORFU",
        "APT:LOT 9",
        "X:GENESEE ST / FIELDCREST DR",
        "DATE:05/30/13",
        "TIME:14:00",
        "ID:2013-00000060");

    doTest("T11",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** ** 955 GENESEE ST , PEMBROKE - ** ** GENESEE HGTS / ETZOLD RD ** 05/28/13 10:13 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Delta",
        "ADDR:955 GENESEE ST",
        "CITY:PEMBROKE",
        "X:GENESEE HGTS / ETZOLD RD",
        "DATE:05/28/13",
        "TIME:10:13",
        "ID:2013-00000059");

    doTest("T12",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Bravo ** ** 735 GENESEE ST , PEMBROKE - APT 2 ** MENTAL HEALTH EVALUATION ** FARGO RD / ETZOLD RD ** 05/22/13 01:58 ** 2013-00000058 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Bravo - MENTAL HEALTH EVALUATION",
        "ADDR:735 GENESEE ST",
        "CITY:PEMBROKE",
        "APT:2",
        "X:FARGO RD / ETZOLD RD",
        "DATE:05/22/13",
        "TIME:01:58",
        "ID:2013-00000058");

    doTest("T13",
        "(Dispatch) EMD Delta ** ** 31 E MAIN ST , CORFU - LOWER ** 30 YO FEMALE HIGH HEART RATE - AND CHEST PAIN ** MAPLE AVE / LAWRENCE AVE ** 05/18/13 16:35 ** 2013-00000057 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 30 YO FEMALE HIGH HEART RATE - AND CHEST PAIN",
        "ADDR:31 E MAIN ST",
        "CITY:CORFU",
        "APT:LOWER",
        "X:MAPLE AVE / LAWRENCE AVE",
        "DATE:05/18/13",
        "TIME:16:35",
        "ID:2013-00000057");

    doTest("T14",
        "(Dispatch) Unit:451 Status:Dispatched EMD Delta ** ** 31 E MAIN ST , CORFU - LOWER ** ** MAPLE AVE / LAWRENCE AVE ** 05/18/13 16:35 ** 2013-00000057 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Delta",
        "ADDR:31 E MAIN ST",
        "CITY:CORFU",
        "APT:LOWER",
        "X:MAPLE AVE / LAWRENCE AVE",
        "DATE:05/18/13",
        "TIME:16:35",
        "ID:2013-00000057");

    doTest("T15",
        "(Dispatch) Unit:453 Status:Dispatched EMD Bravo ** PEMBROKE TOWN PARK** 8813 ALLEGHANY RD , PEMBROKE - ** arm laceration  ** MAIN RD / COHOCTON RD ** 05/18/13 15:35 ** 2013-00002061 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:453",
        "CALL:EMD Bravo - arm laceration",
        "PLACE:PEMBROKE TOWN PARK",
        "ADDR:8813 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:MAIN RD / COHOCTON RD",
        "DATE:05/18/13",
        "TIME:15:35",
        "ID:2013-00002061");

    doTest("T16",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** CORFU FIRE DEPT.** 116 E  MAIN ST , CORFU - ** 51YO MALE FEELS FAINT/TROUBLE BREATHING ** GENESEE ST / THOMPSON DR ** 05/18/13 15:31 ** 2013-00000055 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - 51YO MALE FEELS FAINT/TROUBLE BREATHING",
        "PLACE:CORFU FIRE DEPT.",
        "ADDR:116 E  MAIN ST",
        "CITY:CORFU",
        "X:GENESEE ST / THOMPSON DR",
        "DATE:05/18/13",
        "TIME:15:31",
        "ID:2013-00000055");

    doTest("T17",
        "(Dispatch) Unit:CO43 Status:Dispatched Alarm Fire ** Pembroke Primary School** 2486 MAIN RD , PEMBROKE - ** GENERAL FIRE ALARM ** WEST AVE / INDIAN FALLS RD ** 05/17/13 14:38 ** 2013-00000100 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO43",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:Pembroke Primary School",
        "ADDR:2486 MAIN RD",
        "CITY:PEMBROKE",
        "X:WEST AVE / INDIAN FALLS RD",
        "DATE:05/17/13",
        "TIME:14:38",
        "ID:2013-00000100");

    doTest("T18",
        "(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 10271 ALLEGHANY RD , DARIEN - ** 2 CAR  W AIR BAG DEPLOYMENT  ** SUMNER RD / BROADWAY RD ** 05/14/13 13:07 ** 2013-00010605 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Acc PIAA - 2 CAR  W AIR BAG DEPLOYMENT",
        "ADDR:10271 ALLEGHANY RD",
        "CITY:DARIEN",
        "X:SUMNER RD / BROADWAY RD",
        "DATE:05/14/13",
        "TIME:13:07",
        "ID:2013-00010605");

    doTest("T19",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 955 GENESEE ST , PEMBROKE - ** 73 YO FEMALE DIABETIC PROBLEM ** GENESEE HGTS / ETZOLD RD ** 05/07/13 15:21 ** 2013-00000052 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Charlie - 73 YO FEMALE DIABETIC PROBLEM",
        "ADDR:955 GENESEE ST",
        "CITY:PEMBROKE",
        "X:GENESEE HGTS / ETZOLD RD",
        "DATE:05/07/13",
        "TIME:15:21",
        "ID:2013-00000052");

    doTest("T20",
        "(Dispatch) Unit:451 Status:Dispatched Alarm Fire ** CORFU MEADOWS APARTMENTS** 53 W  MAIN ST , CORFU - ** COMMERCIAL FIRE ALARM ** FIELDCREST DR / PROSPECT ST ** 05/06/13 20:09 ** 2013-00000051 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Alarm Fire - COMMERCIAL FIRE ALARM",
        "PLACE:CORFU MEADOWS APARTMENTS",
        "ADDR:53 W  MAIN ST",
        "CITY:CORFU",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:05/06/13",
        "TIME:20:09",
        "ID:2013-00000051");

    doTest("T21",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Alpha ** ** 9 MAPLE AVE , CORFU - SIDE ** ABDOMINAL PAIN ** E MAIN ST / WATER ST ** 05/03/13 05:17 ** 2013-00001812 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Alpha - ABDOMINAL PAIN",
        "ADDR:9 MAPLE AVE",
        "CITY:CORFU",
        "APT:SIDE",
        "X:E MAIN ST / WATER ST",
        "DATE:05/03/13",
        "TIME:05:17",
        "ID:2013-00001812");

    doTest("T22",
        "(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 1 CORFU PLZ , CORFU - ** FIRE IN THE DRYER ** E MAIN ST / ALLEGHANY RD ** 05/01/13 08:56 ** 2013-00000049 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Structure - FIRE IN THE DRYER",
        "ADDR:1 CORFU PLZ",
        "CITY:CORFU",
        "X:E MAIN ST / ALLEGHANY RD",
        "DATE:05/01/13",
        "TIME:08:56",
        "ID:2013-00000049");

    doTest("T23",
        "(Dispatch) Acc PIAA ** ** 328 MAIN RD , PEMBROKE - ** 2 CAR PIAA - POSS A HEAD ON\n" +
        " ** UNKNOWN / RAMP ** 04/30/13 14:27 ** 2013-00000058 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Acc PIAA - 2 CAR PIAA - POSS A HEAD ON",
        "ADDR:328 MAIN RD",
        "CITY:PEMBROKE");

    doTest("T24",
        "(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 352 MAIN RD , PEMBROKE - ** 2 CAR PIAA - POSS A HEAD ON\n" +
        " ** UNKNOWN / RAMP ** 04/30/13 14:27 ** 2013-00000058 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Acc PIAA - 2 CAR PIAA - POSS A HEAD ON",
        "ADDR:352 MAIN RD",
        "CITY:PEMBROKE");

    doTest("T25",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Alpha ** ** 8894 ALLEGHANY RD , PEMBROKE - ** ELDERLY FEMALE WITH THE ILLNESS ** COHOCTON RD / MAIN RD ** 04/28/13 16:49 ** 2013-00000047 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Alpha - ELDERLY FEMALE WITH THE ILLNESS",
        "ADDR:8894 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:COHOCTON RD / MAIN RD",
        "DATE:04/28/13",
        "TIME:16:49",
        "ID:2013-00000047");

    doTest("T26",
        "(Dispatch) Unit:451 Status:Dispatched Fire Investigation ** ** 30 E  MAIN ST , CORFU - ** SMOKE DETECTOR SOUNDING INSIDE ** MAPLE AVE / LAWRENCE AVE ** 04/28/13 08:09 ** 2013-00000046 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Investigation - SMOKE DETECTOR SOUNDING INSIDE",
        "ADDR:30 E  MAIN ST",
        "CITY:CORFU",
        "X:MAPLE AVE / LAWRENCE AVE",
        "DATE:04/28/13",
        "TIME:08:09",
        "ID:2013-00000046");

    doTest("T27",
        "(Dispatch) Unit:453 Status:Dispatched EMD Delta ** ** 5 E  MAIN ST , CORFU - ** 39 YOF FEELING FAINT ** CORFU PLZ / W MAIN ST, ALLEGHANY RD ** 04/26/13 23:26 ** 2013-00001702 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:453",
        "CALL:EMD Delta - 39 YOF FEELING FAINT",
        "ADDR:5 E  MAIN ST",
        "CITY:CORFU",
        "X:CORFU PLZ / W MAIN ST, ALLEGHANY RD",
        "DATE:04/26/13",
        "TIME:23:26",
        "ID:2013-00001702");

    doTest("T28",
        "(Dispatch) EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** 50 YO M WITH A POSSIBLE STROKE  ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 50 YO M WITH A POSSIBLE STROKE",
        "PLACE:Corfu Machine",
        "ADDR:1977 GENESEE ST",
        "CITY:PEMBROKE",
        "X:ANGLING RD / ELLINWOOD RD",
        "DATE:04/25/13",
        "TIME:12:23",
        "ID:2013-00000044");

    doTest("T29",
        "(Dispatch) EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** 500 ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 500",
        "PLACE:Corfu Machine",
        "ADDR:1977 GENESEE ST",
        "CITY:PEMBROKE",
        "X:ANGLING RD / ELLINWOOD RD",
        "DATE:04/25/13",
        "TIME:12:23",
        "ID:2013-00000044");

    doTest("T30",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** Corfu Machine** 1977 GENESEE ST , PEMBROKE - ** ** ANGLING RD / ELLINWOOD RD ** 04/25/13 12:23 ** 2013-00000044 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Charlie",
        "PLACE:Corfu Machine",
        "ADDR:1977 GENESEE ST",
        "CITY:PEMBROKE",
        "X:ANGLING RD / ELLINWOOD RD",
        "DATE:04/25/13",
        "TIME:12:23",
        "ID:2013-00000044");

    doTest("T32",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 8880 ALLEGHANY RD , PEMBROKE - ** 61 Y/O MALE ABDOMINAL PAINS ** COHOCTON RD / MAIN RD ** 04/21/13 11:09 ** 2013-00000043 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Charlie - 61 Y/O MALE ABDOMINAL PAINS",
        "ADDR:8880 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:COHOCTON RD / MAIN RD",
        "DATE:04/21/13",
        "TIME:11:09",
        "ID:2013-00000043");

    doTest("T33",
        "(Dispatch) Unit:CO41 Status:Dispatched Alarm EMS ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - APT 111 ** MEDICAL ALARM ACTIVATION, UNABLE TO MAKE CONTACT ** FIELDCREST DR / PROSPECT ST ** 04/19/13 18:59 ** 2013-00000042 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:Alarm EMS - MEDICAL ALARM ACTIVATION, UNABLE TO MAKE CONTACT",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W MAIN ST",
        "CITY:CORFU",
        "APT:111",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:04/19/13",
        "TIME:18:59",
        "ID:2013-00000042");

    doTest("T34",
        "(Dispatch) Unit:451 Status:Dispatched EMD Alpha ** ** 9368 ELLINWOOD RD , PEMBROKE - ** 91 YOF PAIN IN RIGHT FOOT CANT WALK  ** SIMONDS RD, BROWN RD / STONEY LONESOME RD ** 04/19/13 12:40 ** 2013-00000041 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Alpha - 91 YOF PAIN IN RIGHT FOOT CANT WALK",
        "ADDR:9368 ELLINWOOD RD",
        "CITY:PEMBROKE",
        "X:SIMONDS RD, BROWN RD / STONEY LONESOME RD",
        "DATE:04/19/13",
        "TIME:12:40",
        "ID:2013-00000041");

    doTest("T35",
        "(Dispatch) Fire Structure ** ** 735 GENESEE ST , PEMBROKE - APT 4 ** BACK OF HOUSE FIRE\n" +
        " ** FARGO RD / ETZOLD RD ** 04/18/13 23:20 ** 2013-00000040 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - BACK OF HOUSE FIRE",
        "ADDR:735 GENESEE ST",
        "CITY:PEMBROKE",
        "APT:4");

    doTest("T36",
        "(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 735 GENESEE ST , PEMBROKE - APT 4 ** ** FARGO RD / ETZOLD RD ** 04/18/13 23:20 ** 2013-00000040 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Structure",
        "ADDR:735 GENESEE ST",
        "CITY:PEMBROKE",
        "APT:4",
        "X:FARGO RD / ETZOLD RD",
        "DATE:04/18/13",
        "TIME:23:20",
        "ID:2013-00000040");

    doTest("T37",
        "(Dispatch) Unit:CO41 Status:Dispatched Fire Auto ** TA TRAVEL CENTER** 8420 ALLEGHANY RD , PEMBROKE - ** ACROSS FROM LOC 06 FORD F150 ON FIRE CAN SEE FLAMES  ** EXIT 48A RAMP / I 90 ** 04/17/13 09:25 ** 2013-00000050 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:Fire Auto - ACROSS FROM LOC 06 FORD F150 ON FIRE CAN SEE FLAMES",
        "PLACE:TA TRAVEL CENTER",
        "ADDR:8420 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:EXIT 48A RAMP / I 90",
        "DATE:04/17/13",
        "TIME:09:25",
        "ID:2013-00000050");

    doTest("T38",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 955 GENESEE ST , PEMBROKE - ** 73YO FEMALE TROUBLE BREATHING/UNABLE TO AMBULATE ** GENESEE HGTS / ETZOLD RD ** 04/13/13 06:51 ** 2013-00000038 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - 73YO FEMALE TROUBLE BREATHING/UNABLE TO AMBULATE",
        "ADDR:955 GENESEE ST",
        "CITY:PEMBROKE",
        "X:GENESEE HGTS / ETZOLD RD",
        "DATE:04/13/13",
        "TIME:06:51",
        "ID:2013-00000038");

    doTest("T39",
        "(Dispatch) Unit:451 Status:Dispatched Fire Wire Down ** ** 9414 SNIPERY RD , PEMBROKE - ** TREE BROUGHT WIRES DOWN - WIRES ARCHING ** UNKNOWN / RICHLEY RD ** 04/11/13 18:26 ** 2013-00000037 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Wire Down - TREE BROUGHT WIRES DOWN - WIRES ARCHING",
        "ADDR:9414 SNIPERY RD",
        "CITY:PEMBROKE",
        "X:UNKNOWN / RICHLEY RD",
        "DATE:04/11/13",
        "TIME:18:26",
        "ID:2013-00000037");

    doTest("T40",
        "(Dispatch) Unit:451 Status:Dispatched Fire Structure ** ** 856 GENESEE ST , PEMBROKE - ** CHIMNEY FIRE ** ETZOLD RD / FARGO RD ** 04/05/13 23:34 ** 2013-00000036 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire Structure - CHIMNEY FIRE",
        "ADDR:856 GENESEE ST",
        "CITY:PEMBROKE",
        "X:ETZOLD RD / FARGO RD",
        "DATE:04/05/13",
        "TIME:23:34",
        "ID:2013-00000036");

    doTest("T41",
        "(Dispatch) Unit:CO41 Status:Dispatched Assist Citizen ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - 105 ** ASSIST WITH TURNING ON OXYGEN ** FIELDCREST DR / PROSPECT ST ** 04/03/13 02:05 ** 2013-00000035 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:Assist Citizen - ASSIST WITH TURNING ON OXYGEN",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W MAIN ST",
        "CITY:CORFU",
        "APT:105",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:04/03/13",
        "TIME:02:05",
        "ID:2013-00000035");

    doTest("T42",
        "(Dispatch) Unit:451 Status:Dispatched Acc PIAA ** ** 998 MAIN RD , PEMBROKE - ** CAR INTO POLE ** LOVERS LANE RD / BRICK HOUSE CORNERS DR ** 04/03/13 00:55 ** 2013-00000039 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Acc PIAA - CAR INTO POLE",
        "ADDR:998 MAIN RD",
        "CITY:PEMBROKE",
        "X:LOVERS LANE RD / BRICK HOUSE CORNERS DR",
        "DATE:04/03/13",
        "TIME:00:55",
        "ID:2013-00000039");

    doTest("T43",
        "(Dispatch) EMD Delta ** ** 42 ALLEGHANY RD , CORFU - Apt 3 ** 18 YO FEMALE BLEEDING FROM FOOT ** W MAIN ST, E MAIN ST / WATER ST ** 03/31/13 20:41 ** 2013-00000033 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 18 YO FEMALE BLEEDING FROM FOOT",
        "ADDR:42 ALLEGHANY RD",
        "CITY:CORFU",
        "APT:Apt 3",
        "X:W MAIN ST, E MAIN ST / WATER ST",
        "DATE:03/31/13",
        "TIME:20:41",
        "ID:2013-00000033");

    doTest("T44",
        "(Dispatch) Unit:451 Status:Dispatched EMD Delta ** ** 42 ALLEGHANY RD , CORFU - Apt 3 ** ** W MAIN ST, E MAIN ST / WATER ST ** 03/31/13 20:41 ** 2013-00000033 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Delta",
        "ADDR:42 ALLEGHANY RD",
        "CITY:CORFU",
        "APT:Apt 3",
        "X:W MAIN ST, E MAIN ST / WATER ST",
        "DATE:03/31/13",
        "TIME:20:41",
        "ID:2013-00000033");

    doTest("T45",
        "(Dispatch) Unit:451 Status:Dispatched EMD Bravo ** ** 2082 GENESEE ST , PEMBROKE - ** 17 MONTH OLD BOY FALLEN ** ANGLING RD / READ RD ** 03/30/13 15:58 ** 2013-00000032 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Bravo - 17 MONTH OLD BOY FALLEN",
        "ADDR:2082 GENESEE ST",
        "CITY:PEMBROKE",
        "X:ANGLING RD / READ RD",
        "DATE:03/30/13",
        "TIME:15:58",
        "ID:2013-00000032");

    doTest("T46",
        "(Dispatch) Unit:451 Status:Dispatched EMD Omega ** ** 2104 ANGLING RD , PEMBROKE - ** LIFTING ASSISTANCE ** UNKNOWN / NORTH ANGLING RD ** 03/28/13 15:28 ** 2013-00000031 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Omega - LIFTING ASSISTANCE",
        "ADDR:2104 ANGLING RD",
        "CITY:PEMBROKE",
        "X:UNKNOWN / NORTH ANGLING RD",
        "DATE:03/28/13",
        "TIME:15:28",
        "ID:2013-00000031");

    doTest("T47",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Charlie ** ** 8880 ALLEGHANY RD , PEMBROKE - ** 61 YOM ABDOMINAL PAINS  ** COHOCTON RD / MAIN RD ** 03/28/13 13:48 ** 2013-00000030 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Charlie - 61 YOM ABDOMINAL PAINS",
        "ADDR:8880 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:COHOCTON RD / MAIN RD",
        "DATE:03/28/13",
        "TIME:13:48",
        "ID:2013-00000030");

    doTest("T48",
        "(Dispatch) Fire Structure ** ** 1606 BROADWAY RD , DARIEN - ** COMMERCIAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - COMMERCIAL BUILDING ON FIRE",
        "ADDR:1606 BROADWAY RD",
        "CITY:DARIEN",
        "X:TINKHAM RD, COLBY RD / BONNIE BRAE DR",
        "DATE:03/26/13",
        "TIME:14:40",
        "ID:2013-00000047");

    doTest("T49",
        "(Dispatch) Fire Structure ** ** 1606 BROADWAY RD , DARIEN - ** COMMERCIAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Fire Structure - COMMERCIAL BUILDING ON FIRE",
        "ADDR:1606 BROADWAY RD",
        "CITY:DARIEN",
        "X:TINKHAM RD, COLBY RD / BONNIE BRAE DR",
        "DATE:03/26/13",
        "TIME:14:40",
        "ID:2013-00000047");

    doTest("T50",
        "(Dispatch) Unit:CO42 Status:Dispatched Fire Structure ** ** 1568 BROADWAY RD , DARIEN - ** METAL BUILDING ON FIRE ** TINKHAM RD, COLBY RD / BONNIE BRAE DR ** 03/26/13 14:40 ** 2013-00000047 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO42",
        "CALL:Fire Structure - METAL BUILDING ON FIRE",
        "ADDR:1568 BROADWAY RD",
        "CITY:DARIEN",
        "X:TINKHAM RD, COLBY RD / BONNIE BRAE DR",
        "DATE:03/26/13",
        "TIME:14:40",
        "ID:2013-00000047");

    doTest("T51",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** Corfu Meadows Apartments** 53 W MAIN ST , CORFU - APT 205 ** 54 YO MALE WITH ABDOMINAL PAINS ** FIELDCREST DR / PROSPECT ST ** 03/25/13 22:02 ** 2013-00000028 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - 54 YO MALE WITH ABDOMINAL PAINS",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W MAIN ST",
        "CITY:CORFU",
        "APT:205",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:03/25/13",
        "TIME:22:02",
        "ID:2013-00000028");

    doTest("T52",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 8834 ALLEGHANY RD , PEMBROKE - ** 85 YO FEMALE WITH ABDOMINAL PAINS ** MAIN RD / COHOCTON RD ** 03/21/13 15:12 ** 2013-00000027 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - 85 YO FEMALE WITH ABDOMINAL PAINS",
        "ADDR:8834 ALLEGHANY RD",
        "CITY:PEMBROKE",
        "X:MAIN RD / COHOCTON RD",
        "DATE:03/21/13",
        "TIME:15:12",
        "ID:2013-00000027");

    doTest("T53",
        "(Dispatch) Unit:451 Status:Dispatched EMD Alpha ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - apt 105 ** 52 YO MALE GENERAL ILLNES\n" +
        " ** FIELDCREST DR / PROSPECT ST ** 03/21/13 14:57 ** 2013-00000026 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Alpha - 52 YO MALE GENERAL ILLNES",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W  MAIN ST",
        "CITY:CORFU",
        "APT:apt 105");

    doTest("T54",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** ** 5 THOMPSON DR , CORFU - ** 83 YO FEMALE WITH CHEST PAINS ** LONGS LN / E MAIN ST ** 03/18/13 15:34 ** 2013-00000025 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - 83 YO FEMALE WITH CHEST PAINS",
        "ADDR:5 THOMPSON DR",
        "CITY:CORFU",
        "X:LONGS LN / E MAIN ST",
        "DATE:03/18/13",
        "TIME:15:34",
        "ID:2013-00000025");

    doTest("T55",
        "(Dispatch) Unit:CO41 Status:Dispatched EMD Delta ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - 109 ** 55YR OLD FEMALE DOWN ** FIELDCREST DR / PROSPECT ST ** 03/11/13 09:31 ** 2013-00000024 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO41",
        "CALL:EMD Delta - 55YR OLD FEMALE DOWN",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W  MAIN ST",
        "CITY:CORFU",
        "APT:109",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:03/11/13",
        "TIME:09:31",
        "ID:2013-00000024");

    doTest("T56",
        "(Dispatch) Unit:451 Status:Dispatched EMD Bravo ** Corfu Meadows Apartments** 53 W  MAIN ST , CORFU - 106 ** 92 YOF FELL WITH FACIAL INJURY  ** FIELDCREST DR / PROSPECT ST ** 03/07/13 09:05 ** 2013-00000023 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Bravo - 92 YOF FELL WITH FACIAL INJURY",
        "PLACE:Corfu Meadows Apartments",
        "ADDR:53 W  MAIN ST",
        "CITY:CORFU",
        "APT:106",
        "X:FIELDCREST DR / PROSPECT ST",
        "DATE:03/07/13",
        "TIME:09:05",
        "ID:2013-00000023");

    doTest("T57",
        "(Dispatch) Unit:451 Status:Dispatched Fire CO Detector ** ** 43 LONGS LN , CORFU - ** CO ALARM NO ILL EFFECTS ** DEAD END / THOMPSON DR ** 03/04/13 09:20 ** 2013-00000022 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire CO Detector - CO ALARM NO ILL EFFECTS",
        "ADDR:43 LONGS LN",
        "CITY:CORFU",
        "X:DEAD END / THOMPSON DR",
        "DATE:03/04/13",
        "TIME:09:20",
        "ID:2013-00000022");

    doTest("T58",
        "(Dispatch) Unit:451 Status:Dispatched EMD Charlie ** Genesee Heights Estates Mobile Home Park** 66 W MAIN ST , CORFU - LOT 13 ** scene is not secure - 47 YO Male intential Overdose ** GENESEE ST / FIELDCREST DR ** 03/01/13 17:09 ** 2013-00004559 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:EMD Charlie - scene is not secure - 47 YO Male intential Overdose",
        "PLACE:Genesee Heights Estates Mobile Home Park",
        "ADDR:66 W MAIN ST",
        "CITY:CORFU",
        "APT:LOT 13",
        "X:GENESEE ST / FIELDCREST DR",
        "DATE:03/01/13",
        "TIME:17:09",
        "ID:2013-00004559");

    doTest("T59",
        "(Dispatch) Unit:CO43 Status:Dispatched Fire Structure ** ** 1880 SHARRICK RD , DARIEN - ** BARN FIRE ** HARPER RD / COLBY RD ** 02/27/13 15:54 ** 2013-00000027 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:CO43",
        "CALL:Fire Structure - BARN FIRE",
        "ADDR:1880 SHARRICK RD",
        "CITY:DARIEN",
        "X:HARPER RD / COLBY RD",
        "DATE:02/27/13",
        "TIME:15:54",
        "ID:2013-00000027");

    doTest("T60",
        "(Dispatch) Unit:451 Status:Dispatched Fire CO Detector ** ** 2141 ANGLING RD , PEMBROKE - ** CARBON MONOXIDE DECTOR GOING OFF NO ILL EFFECTS ** UNKNOWN / NORTH ANGLING RD ** 02/23/13 14:34 ** 2013-00000019 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:451",
        "CALL:Fire CO Detector - CARBON MONOXIDE DECTOR GOING OFF NO ILL EFFECTS",
        "ADDR:2141 ANGLING RD",
        "CITY:PEMBROKE",
        "X:UNKNOWN / NORTH ANGLING RD",
        "DATE:02/23/13",
        "TIME:14:34",
        "ID:2013-00000019");

  }
  
  @Test
  public void testCityOfBataviaFireDepartment() {

    doTest("T1",
        "(Dispatch) Unit:CB11 Status:Dispatched ** Fire Other ** ** 63 WALNUT ST , BATAVIA ** ** MAN IN THE WATER - STILL MOVING ** WALNUT PL / LAW ST ** 06/15/13 09:00 ** 2013-00007638\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�",

        "UNIT:CB11",
        "CALL:Fire Other - MAN IN THE WATER - STILL MOVING",
        "ADDR:63 WALNUT ST",
        "CITY:BATAVIA",
        "X:WALNUT PL / LAW ST",
        "DATE:06/15/13",
        "TIME:09:00",
        "ID:2013-00007638");

     doTest("T2",
         "(Dispatch) Unit:CB11 Status:Dispatched ** Alarm Fire ** ** 16 BANK ST , BATAVIA ** ** GENERAL FIRE ALARM ** ALVA PL / BATAVIA CITY CTR ** 06/15/13 06:36 ** 2013-00000894\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB11",
         "CALL:Alarm Fire - GENERAL FIRE ALARM",
         "ADDR:16 BANK ST",
         "CITY:BATAVIA",
         "X:ALVA PL / BATAVIA CITY CTR",
         "DATE:06/15/13",
         "TIME:06:36",
         "ID:2013-00000894");

     doTest("T3",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 254 STATE ST , BATAVIA ** ** 79 yo fm diff breathing ** MACARTHUR DR / DENIO ST ** 06/15/13 00:49 ** 2013-00002487\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta - 79 yo fm diff breathing",
         "ADDR:254 STATE ST",
         "CITY:BATAVIA",
         "X:MACARTHUR DR / DENIO ST",
         "DATE:06/15/13",
         "TIME:00:49",
         "ID:2013-00002487");

     doTest("T4",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 141 STATE ST , BATAVIA ** LOWER ** ** PARK AVE / LEWIS PL ** 06/14/13 23:11 ** 2013-00002483\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "ADDR:141 STATE ST",
         "CITY:BATAVIA",
         "APT:LOWER",
         "X:PARK AVE / LEWIS PL",
         "DATE:06/14/13",
         "TIME:23:11",
         "ID:2013-00002483");

     doTest("T5",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 10 CENTRAL AVE , BATAVIA ** ** Trouble Breathing ** JACKSON ST / PRINGLE AVE ** 06/14/13 22:56 ** 2013-00002482\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie - Trouble Breathing",
         "ADDR:10 CENTRAL AVE",
         "CITY:BATAVIA",
         "X:JACKSON ST / PRINGLE AVE",
         "DATE:06/14/13",
         "TIME:22:56",
         "ID:2013-00002482");

     doTest("T6",
         "(Dispatch) Unit:CB17 Status:Dispatched ** Alarm EMS ** Monsignor Kirby Apartments** 203 OAK ST , BATAVIA ** 205 ** unknown problem ** NOONAN DR / EXIT 48 ON RAMP ** 06/14/13 20:22 ** 2013-00002478\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:Alarm EMS - unknown problem",
         "PLACE:Monsignor Kirby Apartments",
         "ADDR:203 OAK ST",
         "CITY:BATAVIA",
         "APT:205",
         "X:NOONAN DR / EXIT 48 ON RAMP",
         "DATE:06/14/13",
         "TIME:20:22",
         "ID:2013-00002478");

     doTest("T7",
         "(Dispatch) Unit:CB11 Status:Dispatched ** Fire Auto ** ** 3 ELM ST , BATAVIA ** ** Car Fire ** FISHER PK / HARVESTER AVE, E MAIN ST ** 06/14/13 15:26 ** 2013-00000888\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB11",
         "CALL:Fire Auto - Car Fire",
         "ADDR:3 ELM ST",
         "CITY:BATAVIA",
         "X:FISHER PK / HARVESTER AVE, E MAIN ST",
         "DATE:06/14/13",
         "TIME:15:26",
         "ID:2013-00000888");

     doTest("T8",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ST JOSEPH PRESCHOOL & KINDERGARTEN** 2 SUMMIT ST , BATAVIA ** ** ** WASHINGTON AVE / LIBERTY ST, E MAIN ST ** 06/14/13 14:26 ** 2013-00002474\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "PLACE:ST JOSEPH PRESCHOOL & KINDERGARTEN",
         "ADDR:2 SUMMIT ST",
         "CITY:BATAVIA",
         "X:WASHINGTON AVE / LIBERTY ST, E MAIN ST",
         "DATE:06/14/13",
         "TIME:14:26",
         "ID:2013-00002474");

     doTest("T9",
         "(Dispatch) Unit:CB15 Status:Dispatched ** Fire Service Call ** ** 185 VINE ST , BATAVIA ** ** WATER IN THE CELLAR ** NORTH ST / EVERGREEN DR ** 06/14/13 11:34 ** 2013-00000886\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB15",
         "CALL:Fire Service Call - WATER IN THE CELLAR",
         "ADDR:185 VINE ST",
         "CITY:BATAVIA",
         "X:NORTH ST / EVERGREEN DR",
         "DATE:06/14/13",
         "TIME:11:34",
         "ID:2013-00000886");

     doTest("T10",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 16 EDWARD ST , BATAVIA ** ** ** WALLACE ST / CEDAR ST, DEWITT REC AREA SOUTH PARKING LOT ** 06/14/13 08:38 ** 2013-00002471\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "ADDR:16 EDWARD ST",
         "CITY:BATAVIA",
         "X:WALLACE ST / CEDAR ST, DEWITT REC AREA SOUTH PARKING LOT",
         "DATE:06/14/13",
         "TIME:08:38",
         "ID:2013-00002471");

     doTest("T11",
         "(Dispatch) Unit:CB11 Status:Dispatched ** Alarm Fire ** ** 222 RICHMOND AVE , BATAVIA ** ** GENERAL FIRE ALARM B6  ** BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR ** 06/14/13 07:54 ** 2013-00000884\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB11",
         "CALL:Alarm Fire - GENERAL FIRE ALARM B6",
         "ADDR:222 RICHMOND AVE",
         "CITY:BATAVIA",
         "X:BATAVIA DOWNS RACE TRACK / VA HOSPITAL DR",
         "DATE:06/14/13",
         "TIME:07:54",
         "ID:2013-00000884");

     doTest("T12",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** ** 10 HULL PK , BATAVIA ** ** ** DEAD END / ROSS ST ** 06/14/13 04:08 ** 2013-00002466\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "ADDR:10 HULL PK",
         "MADDR:10 HULL PIKE",
         "CITY:BATAVIA",
         "X:DEAD END / ROSS ST",
         "DATE:06/14/13",
         "TIME:04:08",
         "ID:2013-00002466");

     doTest("T13",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 130 W  MAIN ST , BATAVIA ** ** ** ELLICOTT AVE / THOMAS AVE ** 06/14/13 01:59 ** 2013-00002464\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie",
         "ADDR:130 W  MAIN ST",
         "CITY:BATAVIA",
         "X:ELLICOTT AVE / THOMAS AVE",
         "DATE:06/14/13",
         "TIME:01:59",
         "ID:2013-00002464");

     doTest("T14",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Delta ** Washington Towers** 1 STATE ST , BATAVIA ** APT 621 ** ** WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL ** 06/13/13 23:42 ** 2013-00002463\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "PLACE:Washington Towers",
         "ADDR:1 STATE ST",
         "CITY:BATAVIA",
         "APT:APT 621",
         "X:WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL",
         "DATE:06/13/13",
         "TIME:23:42",
         "ID:2013-00002463");

     doTest("T15",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Bravo ** ** 35 CENTRAL AVE , BATAVIA ** ** 83 YO MALE FALLEN WITH UNKNOWN INJURY ** PRINGLE AVE / LIBERTY ST ** 06/13/13 20:33 ** 2013-00002461\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Bravo - 83 YO MALE FALLEN WITH UNKNOWN INJURY",
         "ADDR:35 CENTRAL AVE",
         "CITY:BATAVIA",
         "X:PRINGLE AVE / LIBERTY ST",
         "DATE:06/13/13",
         "TIME:20:33",
         "ID:2013-00002461");

     doTest("T16",
         "(Dispatch) Unit:CB15 Status:Dispatched ** Fire Service Call ** ** 33 CENTRAL AVE , BATAVIA ** ** CELLAR PUMP DETAIL ** PRINGLE AVE / JACKSON ST ** 06/13/13 20:07 ** 2013-00000879\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB15",
         "CALL:Fire Service Call - CELLAR PUMP DETAIL",
         "ADDR:33 CENTRAL AVE",
         "CITY:BATAVIA",
         "X:PRINGLE AVE / JACKSON ST",
         "DATE:06/13/13",
         "TIME:20:07",
         "ID:2013-00000879");

     doTest("T17",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Alpha ** The Manor House** 427 E  MAIN ST , BATAVIA ** ** 95 YO FEMALE WITH CHOKING PARTIAL OBSTRUCTION ** MASSE PL, VINE ST / HARVESTER AVE, ELM ST ** 06/13/13 18:52 ** 2013-00002458\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Alpha - 95 YO FEMALE WITH CHOKING PARTIAL OBSTRUCTION",
         "PLACE:The Manor House",
         "ADDR:427 E  MAIN ST",
         "CITY:BATAVIA",
         "X:MASSE PL, VINE ST / HARVESTER AVE, ELM ST",
         "DATE:06/13/13",
         "TIME:18:52",
         "ID:2013-00002458");

     doTest("T18",
         "(Dispatch) Unit:CB17 Status:Dispatched ** EMD Charlie ** ** 16 WOOD ST , BATAVIA ** LOWER APT ** 37 YO MALE WITH CHEST PAINS ** PRINGLE AVE / JACKSON ST ** 06/13/13 17:55 ** 2013-00002457\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie - 37 YO MALE WITH CHEST PAINS",
         "ADDR:16 WOOD ST",
         "CITY:BATAVIA",
         "APT:LOWER APT",
         "X:PRINGLE AVE / JACKSON ST",
         "DATE:06/13/13",
         "TIME:17:55",
         "ID:2013-00002457");

     doTest("T19",
         "(Dispatch) Unit:CB11 Status:At Scene Fire Investigation ** ** 16 DENIO ST , BATAVIA - ** ** BANK ST / STATE ST ** 06/11/13 20:11 ** 2013-00000867 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB11",
         "CALL:Fire Investigation",
         "ADDR:16 DENIO ST",
         "CITY:BATAVIA",
         "X:BANK ST / STATE ST",
         "DATE:06/11/13",
         "TIME:20:11",
         "ID:2013-00000867");

     doTest("T20",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** ** 75 S  MAIN ST , BATAVIA - ** 48 YO FEMALE CHEST PAIN ** BROOKLYN AVE / OAK ST ** 06/11/13 17:20 ** 2013-00002432 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie - 48 YO FEMALE CHEST PAIN",
         "ADDR:75 S  MAIN ST",
         "CITY:BATAVIA",
         "X:BROOKLYN AVE / OAK ST",
         "DATE:06/11/13",
         "TIME:17:20",
         "ID:2013-00002432");

     doTest("T21",
         "(Dispatch) Unit:CB11 Status:Dispatched Fire Wire Down ** ** 34 PROSPECT AVE , BATAVIA - ** WIRE DOWN ON CAR - POSSIBLY A CABLE OR TELEPHONE  ** RICHMOND AVE / MIX PL ** 06/11/13 14:01 ** 2013-00000865 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB11",
         "CALL:Fire Wire Down - WIRE DOWN ON CAR - POSSIBLY A CABLE OR TELEPHONE",
         "ADDR:34 PROSPECT AVE",
         "CITY:BATAVIA",
         "X:RICHMOND AVE / MIX PL",
         "DATE:06/11/13",
         "TIME:14:01",
         "ID:2013-00000865");

     doTest("T22",
         "(Dispatch) EMD Delta ** ** 256 EAST AVE , BATAVIA - ** 58 YOM TROUBLE BREATHING ** EUGENE ST / CLINTON ST, TROJAN CIR ** 06/11/13 04:41 ** 2013-00002425 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "CALL:EMD Delta - 58 YOM TROUBLE BREATHING",
         "ADDR:256 EAST AVE",
         "CITY:BATAVIA",
         "X:EUGENE ST / CLINTON ST, TROJAN CIR",
         "DATE:06/11/13",
         "TIME:04:41",
         "ID:2013-00002425");

     doTest("T23",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Delta ** ** 256 EAST AVE , BATAVIA - ** ** EUGENE ST / CLINTON ST, TROJAN CIR ** 06/11/13 04:41 ** 2013-00002425 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta",
         "ADDR:256 EAST AVE",
         "CITY:BATAVIA",
         "X:EUGENE ST / CLINTON ST, TROJAN CIR",
         "DATE:06/11/13",
         "TIME:04:41",
         "ID:2013-00002425");

     doTest("T24",
         "(Dispatch) EMD Charlie ** Genesee Park Place Apartments** 145 PARK RD , BATAVIA - 224 ** 67 YOM NEEDS HELP\n" +
         " ** RICHMOND AVE / VETERANS MEMORIAL DR ** 06/11/13 03:18 ** 2013-00002424 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "CALL:EMD Charlie - 67 YOM NEEDS HELP",
         "PLACE:Genesee Park Place Apartments",
         "ADDR:145 PARK RD",
         "CITY:BATAVIA",
         "APT:224");

     doTest("T25",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** Genesee Park Place Apartments** 145 PARK RD , BATAVIA - 224 ** ** RICHMOND AVE / VETERANS MEMORIAL DR ** 06/11/13 03:18 ** 2013-00002424 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie",
         "PLACE:Genesee Park Place Apartments",
         "ADDR:145 PARK RD",
         "CITY:BATAVIA",
         "APT:224",
         "X:RICHMOND AVE / VETERANS MEMORIAL DR",
         "DATE:06/11/13",
         "TIME:03:18",
         "ID:2013-00002424");

     doTest("T26",
         "(Dispatch) Unit:CB16 Status:Dispatched EMD Bravo ** Southside Deli** 300 ELLICOTT ST , BATAVIA - ** ADULT MALE FALLEN WITH A HEAD INUURY ** LIBERTY ST / GOADE PK ** 06/10/13 21:37 ** 2013-00000862 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB16",
         "CALL:EMD Bravo - ADULT MALE FALLEN WITH A HEAD INUURY",
         "PLACE:Southside Deli",
         "ADDR:300 ELLICOTT ST",
         "CITY:BATAVIA",
         "X:LIBERTY ST / GOADE PK",
         "DATE:06/10/13",
         "TIME:21:37",
         "ID:2013-00000862");

     doTest("T27",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** Washington Towers** 1 STATE ST , BATAVIA - APT 421 ** ADULT FEMALE WITH DIFFICULTY BREATHING ** WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL ** 06/10/13 21:23 ** 2013-00002420 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie - ADULT FEMALE WITH DIFFICULTY BREATHING",
         "PLACE:Washington Towers",
         "ADDR:1 STATE ST",
         "CITY:BATAVIA",
         "APT:421",
         "X:WASHINGTON AVE / GENESEE COUNTRY MALL, ALVA PL",
         "DATE:06/10/13",
         "TIME:21:23",
         "ID:2013-00002420");

     doTest("T28",
         "(Dispatch) EMD Charlie ** Graham Corporation** 20 FLORENCE AVE , BATAVIA - ** HEAD INJ ** WEBSTER AVE, HOWARD ST / CEDAR ST ** 06/10/13 14:50 ** 2013-00002417 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "CALL:EMD Charlie - HEAD INJ",
         "PLACE:Graham Corporation",
         "ADDR:20 FLORENCE AVE",
         "CITY:BATAVIA",
         "X:WEBSTER AVE, HOWARD ST / CEDAR ST",
         "DATE:06/10/13",
         "TIME:14:50",
         "ID:2013-00002417");

     doTest("T29",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Charlie ** ** 24 FLORENCE AVE , BATAVIA - ** HEAD INJ ** WEBSTER AVE, HOWARD ST / CEDAR ST ** 06/10/13 14:50 ** 2013-00002417 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Charlie - HEAD INJ",
         "ADDR:24 FLORENCE AVE",
         "CITY:BATAVIA",
         "X:WEBSTER AVE, HOWARD ST / CEDAR ST",
         "DATE:06/10/13",
         "TIME:14:50",
         "ID:2013-00002417");

     doTest("T30",
         "(Dispatch) Unit:CB17 Status:Dispatched EMD Delta ** Northside Meadows Apartments** 335 BANK ST , BATAVIA - 34B ** DIFF BREATHING ** ROSS ST / CHANDLER AVE ** 06/10/13 12:24 ** 2013-00002415 **\n\n\n" +
         "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

         "UNIT:CB17",
         "CALL:EMD Delta - DIFF BREATHING",
         "PLACE:Northside Meadows Apartments",
         "ADDR:335 BANK ST",
         "CITY:BATAVIA",
         "APT:34B",
         "X:ROSS ST / CHANDLER AVE",
         "DATE:06/10/13",
         "TIME:12:24",
         "ID:2013-00002415");

  }
  
  @Test
  public void testByronFireDepartment() {

    doTest("T1",
        "(Dispatch) EMD Delta ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M32 ** ADULT FEMALE ABDOMINAL PAIN ** IVISON RD / HESSENTHALER RD ** 06/08/13 16:04 ** 2013-00000080 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - ADULT FEMALE ABDOMINAL PAIN",
        "PLACE:Southwoods RV Resort",
        "ADDR:6749 TOWNLINE RD",
        "CITY:BYRON",
        "APT:M32",
        "X:IVISON RD / HESSENTHALER RD",
        "DATE:06/08/13",
        "TIME:16:04",
        "ID:2013-00000080");

    doTest("T2",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Delta ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M32 ** ** IVISON RD / HESSENTHALER RD ** 06/08/13 16:04 ** 2013-00000080 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Delta",
        "PLACE:Southwoods RV Resort",
        "ADDR:6749 TOWNLINE RD",
        "CITY:BYRON",
        "APT:M32",
        "X:IVISON RD / HESSENTHALER RD",
        "DATE:06/08/13",
        "TIME:16:04",
        "ID:2013-00000080");

    doTest("T3",
        "(Dispatch) EMD Charlie ** ** 7516 BYRON HOLLEY RD , BYRON - ** 76 YOF POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 76 YOF POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT",
        "ADDR:7516 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:E MAIN ST, WALKERS CORNER RD / MECHANIC ST",
        "DATE:06/07/13",
        "TIME:12:38",
        "ID:2013-00000079");

    doTest("T4",
        "(Dispatch) EMD Charlie ** ** 7516 BYRON HOLLEY RD , BYRON - ** POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT",
        "ADDR:7516 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:E MAIN ST, WALKERS CORNER RD / MECHANIC ST",
        "DATE:06/07/13",
        "TIME:12:38",
        "ID:2013-00000079");

    doTest("T5",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Alpha ** ** 7516 BYRON HOLLEY RD , BYRON - ** POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT  ** E MAIN ST, WALKERS CORNER RD / MECHANIC ST ** 06/07/13 12:38 ** 2013-00000079 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Alpha - POST SURGICAL PAIN TO KNEE POSS BLOOD CLOT",
        "ADDR:7516 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:E MAIN ST, WALKERS CORNER RD / MECHANIC ST",
        "DATE:06/07/13",
        "TIME:12:38",
        "ID:2013-00000079");

    doTest("T6",
        "(Dispatch) Unit:401 Status:Dispatched Alarm Fire ** Byron Post Office** 6332 TOWNLINE RD , BYRON - ** GENERAL ALARM \n" +
        " ** MCELVER ST / BYRON HOLLEY RD ** 06/06/13 14:25 ** 2013-00000078 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:Alarm Fire - GENERAL ALARM",
        "PLACE:Byron Post Office",
        "ADDR:6332 TOWNLINE RD",
        "CITY:BYRON");

    doTest("T7",
        "(Dispatch) EMD Delta ** ** 6870 BYRON HOLLEY RD , BYRON - ** 67yo fml tx breathing  ** TOWNLINE RD / TERRY ST ** 06/03/13 14:05 ** 2013-00002317 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 67yo fml tx breathing",
        "ADDR:6870 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:TOWNLINE RD / TERRY ST",
        "DATE:06/03/13",
        "TIME:14:05",
        "ID:2013-00002317");

    doTest("T8",
        "(Dispatch) Unit:BY40 Status:Dispatched Medical ** ** 6870 BYRON HOLLEY RD , BYRON - ** 67yo fml tx breathing  ** TOWNLINE RD / TERRY ST ** 06/03/13 14:05 ** 2013-00002317 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Medical - 67yo fml tx breathing",
        "ADDR:6870 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:TOWNLINE RD / TERRY ST",
        "DATE:06/03/13",
        "TIME:14:05",
        "ID:2013-00002317");

    doTest("T9",
        "(Dispatch) Unit:BY40 Status:Dispatched Mental ** ** 5886 BIRD RD , BYRON - ** SUICIDAL FEMALE - SCENE SECURE ** DEAD END / EAST BIRD RD ** 06/01/13 16:43 ** 2013-00000076 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Mental - SUICIDAL FEMALE - SCENE SECURE",
        "ADDR:5886 BIRD RD",
        "CITY:BYRON",
        "X:DEAD END / EAST BIRD RD",
        "DATE:06/01/13",
        "TIME:16:43",
        "ID:2013-00000076");

    doTest("T10",
        "(Dispatch) Unit:BY40 Status:Dispatched Check Welfare ** ** 7078 BYRON RD , BYRON - ** VOLUNTARY MENTAL HEALTH TRANSPORT  ** COCKRAM RD / BYRON ELBA RD ** 05/30/13 11:36 ** 2013-00000075 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Check Welfare - VOLUNTARY MENTAL HEALTH TRANSPORT",
        "ADDR:7078 BYRON RD",
        "CITY:BYRON",
        "X:COCKRAM RD / BYRON ELBA RD",
        "DATE:05/30/13",
        "TIME:11:36",
        "ID:2013-00000075");

    doTest("T11",
        "(Dispatch) Unit:402 Status:Dispatched Alarm Fire ** Byron Post Office** 6332 TOWNLINE RD , BYRON - ** GENERAL FIRE ALARM  ** MCELVER ST / BYRON HOLLEY RD ** 05/28/13 10:38 ** 2013-00000074 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:402",
        "CALL:Alarm Fire - GENERAL FIRE ALARM",
        "PLACE:Byron Post Office",
        "ADDR:6332 TOWNLINE RD",
        "CITY:BYRON",
        "X:MCELVER ST / BYRON HOLLEY RD",
        "DATE:05/28/13",
        "TIME:10:38",
        "ID:2013-00000074");

    doTest("T12",
        "(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** ** 6369 TOWNLINE RD , BYRON - ** 11 MONTH OLD HAD A SEIZURE ** MCELVER ST / SWAMP RD ** 05/28/13 04:28 ** 2013-00000073 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:EMD Charlie - 11 MONTH OLD HAD A SEIZURE",
        "ADDR:6369 TOWNLINE RD",
        "CITY:BYRON",
        "X:MCELVER ST / SWAMP RD",
        "DATE:05/28/13",
        "TIME:04:28",
        "ID:2013-00000073");

    doTest("T13",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 6213 NORTH BYRON RD , BYRON - ** ** BYRON HOLLEY RD / SEARLS RD ** 05/21/13 19:14 ** 2013-00000072 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Charlie",
        "ADDR:6213 NORTH BYRON RD",
        "CITY:BYRON",
        "X:BYRON HOLLEY RD / SEARLS RD",
        "DATE:05/21/13",
        "TIME:19:14",
        "ID:2013-00000072");

    doTest("T14",
        "(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** Byron Fire Dept.** 6357 TOWNLINE RD , BYRON - ** ADULT MALE WITH A SEIZURE ** MCELVER ST / SWAMP RD ** 05/16/13 19:22 ** 2013-00000071 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:EMD Charlie - ADULT MALE WITH A SEIZURE",
        "PLACE:Byron Fire Dept.",
        "ADDR:6357 TOWNLINE RD",
        "CITY:BYRON",
        "X:MCELVER ST / SWAMP RD",
        "DATE:05/16/13",
        "TIME:19:22",
        "ID:2013-00000071");

    doTest("T15",
        "(Dispatch) EMD Charlie ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - SITE M7 ** 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW  ** IVISON RD / HESSENTHALER RD ** 05/16/13 14:16 ** 2013-00000070 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW",
        "PLACE:Southwoods RV Resort",
        "ADDR:6749 TOWNLINE RD",
        "CITY:BYRON",
        "APT:SITE M7",
        "X:IVISON RD / HESSENTHALER RD",
        "DATE:05/16/13",
        "TIME:14:16",
        "ID:2013-00000070");

    doTest("T16",
        "(Dispatch) Unit:401 Status:Dispatched EMD Charlie ** Southwoods RV Resort** 6749 TOWNLINE RD , BYRON - M7 ** 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW  ** IVISON RD / HESSENTHALER RD ** 05/16/13 14:16 ** 2013-00000070 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:EMD Charlie - 70 YOM SYNCOPE CONSCIOUS AND ALERT NOW",
        "PLACE:Southwoods RV Resort",
        "ADDR:6749 TOWNLINE RD",
        "CITY:BYRON",
        "APT:M7",
        "X:IVISON RD / HESSENTHALER RD",
        "DATE:05/16/13",
        "TIME:14:16",
        "ID:2013-00000070");

    doTest("T17",
        "(Dispatch) Unit:BY40 Status:Dispatched Mental ** ** 7655 BYRON HOLLEY RD , BYRON - ** 16 YO FEMALE ATTEMPTED SUICIDE OVER THE WEEKEND ** RT 237 / FREEMAN RD ** 05/13/13 19:08 ** 2013-00010564 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Mental - 16 YO FEMALE ATTEMPTED SUICIDE OVER THE WEEKEND",
        "ADDR:7655 BYRON HOLLEY RD",
        "CITY:BYRON",
        "X:RT 237 / FREEMAN RD",
        "DATE:05/13/13",
        "TIME:19:08",
        "ID:2013-00010564");

    doTest("T18",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 14 BENNETT AVE , OAKFIELD - ** 88 YO FEAMLE DIEBETIC PROBLEM ** N MAIN ST / N PEARL ST ** 05/12/13 14:46 ** 2013-00000113 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Charlie - 88 YO FEAMLE DIEBETIC PROBLEM",
        "ADDR:14 BENNETT AVE",
        "CITY:OAKFIELD",
        "X:N MAIN ST / N PEARL ST",
        "DATE:05/12/13",
        "TIME:14:46",
        "ID:2013-00000113");

    doTest("T19",
        "(Dispatch) Unit:401 Status:Dispatched Alarm Fire ** ** 7529 MECHANIC ST , BYRON - ** ALARM ON HOUSE/SMELLS NATURAL GAS ** E MAIN ST / BYRON HOLLEY RD ** 05/07/13 23:06 ** 2013-00000010 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:Alarm Fire - ALARM ON HOUSE/SMELLS NATURAL GAS",
        "ADDR:7529 MECHANIC ST",
        "CITY:BYRON",
        "X:E MAIN ST / BYRON HOLLEY RD",
        "DATE:05/07/13",
        "TIME:23:06",
        "ID:2013-00000010");

    doTest("T20",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Alpha ** ** 6678 FREEMAN RD , BYRON - ** 89 YO FEMALE SEVERE BACK PAIN ** IVISON RD / COWARD RD ** 05/07/13 15:37 ** 2013-00000066 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Alpha - 89 YO FEMALE SEVERE BACK PAIN",
        "ADDR:6678 FREEMAN RD",
        "CITY:BYRON",
        "X:IVISON RD / COWARD RD",
        "DATE:05/07/13",
        "TIME:15:37",
        "ID:2013-00000066");

    doTest("T21",
        "(Dispatch) Unit:401 Status:Dispatched EMD Alpha ** ** 6945 BYRON RD , BYRON - ** 49 yo fm sever back pain ** TOWER HILL RD / BYRON ELBA RD ** 05/05/13 20:28 ** 2013-00000065 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:EMD Alpha - 49 yo fm sever back pain",
        "ADDR:6945 BYRON RD",
        "CITY:BYRON",
        "X:TOWER HILL RD / BYRON ELBA RD",
        "DATE:05/05/13",
        "TIME:20:28",
        "ID:2013-00000065");

    doTest("T22",
        "(Dispatch) Unit:BY40 Status:Dispatched Alarm EMS ** ** 5575 COCKRAM RD , BYRON - ** 87 YO MALE TX BREATHING ** TRANSIT RD / BANK STREET RD ** 05/05/13 11:16 ** 2013-00000064 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Alarm EMS - 87 YO MALE TX BREATHING",
        "ADDR:5575 COCKRAM RD",
        "CITY:BYRON",
        "X:TRANSIT RD / BANK STREET RD",
        "DATE:05/05/13",
        "TIME:11:16",
        "ID:2013-00000064");

    doTest("T23",
        "(Dispatch) Unit:BY36 Status:Dispatched Acc PIAA ** ** 6920 TRANSIT RD , ELBA - ** ATV ACCIDENT ** BYRON ELBA RD, FORD RD / BRIDGE RD, CHAPELL RD ** 05/04/13 16:47 ** 2013-00000052 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY36",
        "CALL:Acc PIAA - ATV ACCIDENT",
        "ADDR:6920 TRANSIT RD",
        "CITY:ELBA",
        "X:BYRON ELBA RD, FORD RD / BRIDGE RD, CHAPELL RD",
        "DATE:05/04/13",
        "TIME:16:47",
        "ID:2013-00000052");

    doTest("T24",
        "(Dispatch) Unit:BY40 Status:Dispatched Fire Drill ** Elba Central School** 57 S  MAIN ST , ELBA - ** ELBA PROM DRILL ** UNKNOWN / WEST AVE ** 05/01/13 08:22 ** 2013-00001781 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:Fire Drill - ELBA PROM DRILL",
        "PLACE:Elba Central School",
        "ADDR:57 S  MAIN ST",
        "CITY:ELBA",
        "X:UNKNOWN / WEST AVE",
        "DATE:05/01/13",
        "TIME:08:22",
        "ID:2013-00001781");

    doTest("T25",
        "(Dispatch) Mental ** ** 6479 NORTH BERGEN RD , BYRON - ** MENTAL HEALTH TX - CANCEL REQ PER DEPUTY ** BIRD RD / BYRON HOLLEY RD ** 04/28/13 21:58 ** 2013-00000061 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Mental - MENTAL HEALTH TX - CANCEL REQ PER DEPUTY",
        "ADDR:6479 NORTH BERGEN RD",
        "CITY:BYRON",
        "X:BIRD RD / BYRON HOLLEY RD",
        "DATE:04/28/13",
        "TIME:21:58",
        "ID:2013-00000061");

    doTest("T26",
        "(Dispatch) Unit:401 Status:Dispatched Mental ** ** 6479 NORTH BERGEN RD , BYRON - ** MENTAL HEALTH TX ** BIRD RD / BYRON HOLLEY RD ** 04/28/13 21:58 ** 2013-00000061 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:Mental - MENTAL HEALTH TX",
        "ADDR:6479 NORTH BERGEN RD",
        "CITY:BYRON",
        "X:BIRD RD / BYRON HOLLEY RD",
        "DATE:04/28/13",
        "TIME:21:58",
        "ID:2013-00000061");

    doTest("T27",
        "(Dispatch) Unit:401 Status:Dispatched Fire Grass ** ** 7257 BEAVER MEADOW RD , BYRON - ** CONTROLLED BURN OUT OF CONTROL ** COCKRAM RD / LYMAN RD ** 04/28/13 11:48 ** 2013-00000009 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:401",
        "CALL:Fire Grass - CONTROLLED BURN OUT OF CONTROL",
        "ADDR:7257 BEAVER MEADOW RD",
        "CITY:BYRON",
        "X:COCKRAM RD / LYMAN RD",
        "DATE:04/28/13",
        "TIME:11:48",
        "ID:2013-00000009");

    doTest("T28",
        "(Dispatch) EMD Delta ** ** 7588 BYRON RD , BYRON - ** 91 YO FEMALE CHEST PAIN ** WALKERS CORNER RD / GRISWOLD RD ** 04/27/13 20:10 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Delta - 91 YO FEMALE CHEST PAIN",
        "ADDR:7588 BYRON RD",
        "CITY:BYRON",
        "X:WALKERS CORNER RD / GRISWOLD RD",
        "DATE:04/27/13",
        "TIME:20:10",
        "ID:2013-00000059");

    doTest("T29",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Delta ** ** 7588 BYRON RD , BYRON - ** ** WALKERS CORNER RD / GRISWOLD RD ** 04/27/13 20:10 ** 2013-00000059 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Delta",
        "ADDR:7588 BYRON RD",
        "CITY:BYRON",
        "X:WALKERS CORNER RD / GRISWOLD RD",
        "DATE:04/27/13",
        "TIME:20:10",
        "ID:2013-00000059");

    doTest("T30",
        "(Dispatch) Unit:BY40 Status:Dispatched EMD Charlie ** ** 121 STATE ST , BATAVIA - SIDE ** 88YO FEMALE CONFUSED/FEVER/VOMITING ** HUTCHINS PL / LEWIS PL ** 04/27/13 15:50 ** 2013-00000613 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:BY40",
        "CALL:EMD Charlie - 88YO FEMALE CONFUSED/FEVER/VOMITING",
        "ADDR:121 STATE ST",
        "CITY:BATAVIA",
        "APT:SIDE",
        "X:HUTCHINS PL / LEWIS PL",
        "DATE:04/27/13",
        "TIME:15:50",
        "ID:2013-00000613");

  }
  
  @Test
  public void testLeroyAmbulanceService() {

    doTest("T2",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMD Charlie ** ** 10 MUNSON ST , LE ROY ** ** ** WOLCOTT ST / GILBERT ST ** 06/15/13 13:46 ** 2013-00000591\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Charlie",
        "ADDR:10 MUNSON ST",
        "CITY:LE ROY",
        "X:WOLCOTT ST / GILBERT ST",
        "DATE:06/15/13",
        "TIME:13:46",
        "ID:2013-00000591");

    doTest("T3",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMD Delta ** McDonald's LeRoy** 67 MAIN ST , LE ROY ** ** 66 YO FML TX BREATHING ** W MAIN ST, CLAY ST, LAKE ST / BANK ST ** 06/15/13 12:11 ** 2013-00000590\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Delta - 66 YO FML TX BREATHING",
        "PLACE:McDonald's LeRoy",
        "ADDR:67 MAIN ST",
        "CITY:LE ROY",
        "X:W MAIN ST, CLAY ST, LAKE ST / BANK ST",
        "DATE:06/15/13",
        "TIME:12:11",
        "ID:2013-00000590");

    doTest("T4",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMS Mutual Aid ** ** 2985 MAIN ST , CALEDONIA ** ** SIDE PAIN - VOMITING BLOOD ** LEICESTER ST / CALEDONIA LEROY RD, BORST COTTAGE LN ** 06/15/13 06:54 ** 2013-00000589\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMS Mutual Aid - SIDE PAIN - VOMITING BLOOD",
        "ADDR:2985 MAIN ST",
        "CITY:CALEDONIA",
        "X:LEICESTER ST / CALEDONIA LEROY RD, BORST COTTAGE LN",
        "DATE:06/15/13",
        "TIME:06:54",
        "ID:2013-00000589");

    doTest("T5",
        "(Dispatch) Unit:LA01 Status:Dispatched ** Check Welfare ** ** 48 W  MAIN ST , LE ROY ** ** MALE DOWN ROADSIDE  ** CRAIGIE ST / GILBERT ST ** 06/15/13 03:13 ** 2013-00001884\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:Check Welfare - MALE DOWN ROADSIDE",
        "ADDR:48 W  MAIN ST",
        "CITY:LE ROY",
        "X:CRAIGIE ST / GILBERT ST",
        "DATE:06/15/13",
        "TIME:03:13",
        "ID:2013-00001884");

    doTest("T6",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMD Bravo ** LeRoy Manor** 8678 LAKE STREET RD , LE ROY ** ** 57 YO FM head injury from fall ** RED MILL RD / RANDALL RD, NORTH STREET RD ** 06/13/13 21:23 ** 2013-00000587\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Bravo - 57 YO FM head injury from fall",
        "PLACE:LeRoy Manor",
        "ADDR:8678 LAKE STREET RD",
        "CITY:LE ROY",
        "X:RED MILL RD / RANDALL RD, NORTH STREET RD",
        "DATE:06/13/13",
        "TIME:21:23",
        "ID:2013-00000587");

    doTest("T7",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMD Alpha ** Royal Apartments** 103 W MAIN ST , LE ROY ** BLDG 6 APT 2 ** LIFT ASSIST ONLY ** ROYAL DR / WEST AVE ** 06/13/13 19:07 ** 2013-00000586\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Alpha - LIFT ASSIST ONLY",
        "PLACE:Royal Apartments",
        "ADDR:103 W MAIN ST",
        "CITY:LE ROY",
        "APT:BLDG 6 APT 2",
        "X:ROYAL DR / WEST AVE",
        "DATE:06/13/13",
        "TIME:19:07",
        "ID:2013-00000586");

    doTest("T8",
        "(Dispatch) Unit:LA01 Status:Dispatched ** EMD Delta ** ** 37 LATHROP AVE , LE ROY ** ** bleeding from noise ** GENESEE PK / E MAIN ST ** 06/13/13 11:35 ** 2013-00000585\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Delta - bleeding from noise",
        "ADDR:37 LATHROP AVE",
        "CITY:LE ROY",
        "X:GENESEE PK / E MAIN ST",
        "DATE:06/13/13",
        "TIME:11:35",
        "ID:2013-00000585");

    doTest("T13",
        "(Dispatch) EMD Alpha ** ** 93 LAKE ST , LE ROY - LOWER ** 63 YO FEMALE LEG PAIN ** WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD ** 06/11/13 21:52 ** 2013-00000581 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Alpha - 63 YO FEMALE LEG PAIN",
        "ADDR:93 LAKE ST",
        "CITY:LE ROY",
        "APT:LOWER",
        "X:WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD",
        "DATE:06/11/13",
        "TIME:21:52",
        "ID:2013-00000581");

    doTest("T14",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** ** 93 LAKE ST , LE ROY - LOWER ** 63 YO FEMALE LEF PAIN ** WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD ** 06/11/13 21:52 ** 2013-00000581 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Alpha - 63 YO FEMALE LEF PAIN",
        "ADDR:93 LAKE ST",
        "CITY:LE ROY",
        "APT:LOWER",
        "X:WRIGHT AVE, MILL ST / WEST BERGEN RD, LAKE STREET RD",
        "DATE:06/11/13",
        "TIME:21:52",
        "ID:2013-00000581");

    doTest("T15",
        "(Dispatch) Mental ** ** 72 W  MAIN ST , LE ROY - ** MENTAL HEALTH STAND BY ** LENT AVE / ROYAL DR ** 06/11/13 20:14 ** 2013-00000580 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:Mental - MENTAL HEALTH STAND BY",
        "ADDR:72 W  MAIN ST",
        "CITY:LE ROY",
        "X:LENT AVE / ROYAL DR",
        "DATE:06/11/13",
        "TIME:20:14",
        "ID:2013-00000580");

    doTest("T16",
        "(Dispatch) Unit:LA01 Status:Dispatched Mental ** ** 72 W  MAIN ST , LE ROY - ** MENTAL HEALTH STAND BY ** LENT AVE / ROYAL DR ** 06/11/13 20:14 ** 2013-00000580 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:Mental - MENTAL HEALTH STAND BY",
        "ADDR:72 W  MAIN ST",
        "CITY:LE ROY",
        "X:LENT AVE / ROYAL DR",
        "DATE:06/11/13",
        "TIME:20:14",
        "ID:2013-00000580");

    doTest("T17",
        "(Dispatch) Unit:LA02 Status:Dispatched EMD Charlie ** ** 10 MUNSON ST , LE ROY - UNK ** 70YO MALE ALTERED MENTAL STATUS ** WOLCOTT ST / GILBERT ST ** 06/11/13 09:36 ** 2013-00000579 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA02",
        "CALL:EMD Charlie - 70YO MALE ALTERED MENTAL STATUS",
        "ADDR:10 MUNSON ST",
        "CITY:LE ROY",
        "APT:UNK",
        "X:WOLCOTT ST / GILBERT ST",
        "DATE:06/11/13",
        "TIME:09:36",
        "ID:2013-00000579");

    doTest("T18",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** Royal Apartments** 103 W MAIN ST , LE ROY - BLDG 6 APT 2 ** 87 YOF REQ LIFT ASSISTANCE ** ROYAL DR / WEST AVE ** 06/11/13 07:13 ** 2013-00000578 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Alpha - 87 YOF REQ LIFT ASSISTANCE",
        "PLACE:Royal Apartments",
        "ADDR:103 W MAIN ST",
        "CITY:LE ROY",
        "APT:BLDG 6 APT 2",
        "X:ROYAL DR / WEST AVE",
        "DATE:06/11/13",
        "TIME:07:13",
        "ID:2013-00000578");

    doTest("T19",
        "(Dispatch) EMD Echo ** ** 124 E  MAIN ST , LE ROY - ** 85 YOF NOT BREATHING ** EAST AVE / E MAIN RD ** 06/11/13 06:38 ** 2013-00000577 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Echo - 85 YOF NOT BREATHING",
        "ADDR:124 E  MAIN ST",
        "CITY:LE ROY",
        "X:EAST AVE / E MAIN RD",
        "DATE:06/11/13",
        "TIME:06:38",
        "ID:2013-00000577");

    doTest("T20",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Echo ** ** 124 E  MAIN ST , LE ROY - ** ** EAST AVE / E MAIN RD ** 06/11/13 06:38 ** 2013-00000577 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Echo",
        "ADDR:124 E  MAIN ST",
        "CITY:LE ROY",
        "X:EAST AVE / E MAIN RD",
        "DATE:06/11/13",
        "TIME:06:38",
        "ID:2013-00000577");

    doTest("T21",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** LeRoy Manor** 8678 LAKE STREET RD , LE ROY - ** 53 YO MALE WITH ILLNESS ** RED MILL RD / RANDALL RD, NORTH STREET RD ** 06/10/13 19:52 ** 2013-00000018 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Alpha - 53 YO MALE WITH ILLNESS",
        "PLACE:LeRoy Manor",
        "ADDR:8678 LAKE STREET RD",
        "CITY:LE ROY",
        "X:RED MILL RD / RANDALL RD, NORTH STREET RD",
        "DATE:06/10/13",
        "TIME:19:52",
        "ID:2013-00000018");

    doTest("T22",
        "(Dispatch) Unit:LA47 Status:Dispatched EMD Alpha ** ** 8003 E MAIN RD , LE ROY - RIGHT SIDE ** 73 YO FEMALE WITH HIP INJURY ** CIRCULAR HILL RD / LINWOOD RD ** 06/10/13 19:32 ** 2013-00000575 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA47",
        "CALL:EMD Alpha - 73 YO FEMALE WITH HIP INJURY",
        "ADDR:8003 E MAIN RD",
        "CITY:LE ROY",
        "APT:RIGHT SIDE",
        "X:CIRCULAR HILL RD / LINWOOD RD",
        "DATE:06/10/13",
        "TIME:19:32",
        "ID:2013-00000575");

    doTest("T23",
        "(Dispatch) Unit:LA01 Status:Dispatched Mental ** ** BANK ST , MAIN ST LE ROY - ** MENTAL HEALTH TX ** ** 06/09/13 21:56 ** 2013-00000574 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:Mental - MENTAL HEALTH TX",
        "ADDR:BANK ST & MAIN ST",
        "CITY:LE ROY",
        "DATE:06/09/13",
        "TIME:21:56",
        "ID:2013-00000574");

    doTest("T24",
        "(Dispatch) EMD Charlie ** ** 3 TOUNTAS AVE , LE ROY - ** MALE SUBJECT - CHEST PAIN ** DEAD END / GILBERT ST ** 06/09/13 18:34 ** 2013-00000573 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - MALE SUBJECT - CHEST PAIN",
        "ADDR:3 TOUNTAS AVE",
        "CITY:LE ROY",
        "X:DEAD END / GILBERT ST",
        "DATE:06/09/13",
        "TIME:18:34",
        "ID:2013-00000573");

    doTest("T25",
        "(Dispatch) EMD Charlie ** ** 3 TOUNTAS AVE , LE ROY - ** MALE SUBJECT - CHEST PAIN ** DEAD END / GILBERT ST ** 06/09/13 18:34 ** 2013-00000573 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "CALL:EMD Charlie - MALE SUBJECT - CHEST PAIN",
        "ADDR:3 TOUNTAS AVE",
        "CITY:LE ROY",
        "X:DEAD END / GILBERT ST",
        "DATE:06/09/13",
        "TIME:18:34",
        "ID:2013-00000573");

    doTest("T26",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Charlie ** ** <UNKNOWN> , - ** MALE SUBJECT - CHEST PAIN ** ** 06/09/13 18:34 ** 2013-00000573 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Charlie - MALE SUBJECT - CHEST PAIN",
        "ADDR:<UNKNOWN>",
        "DATE:06/09/13",
        "TIME:18:34",
        "ID:2013-00000573");

    doTest("T27",
        "(Dispatch) Unit:LA01 Status:Dispatched EMS Mutual Aid ** ** 1276 QUARRY RD , CALEDONIA - ** 83 yo male - multiple bee stings - trouble breathing ** AVERILL RD / TELEPHONE RD ** 06/09/13 18:00 ** 2013-00000572 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMS Mutual Aid - 83 yo male - multiple bee stings - trouble breathing",
        "ADDR:1276 QUARRY RD",
        "CITY:CALEDONIA",
        "X:AVERILL RD / TELEPHONE RD",
        "DATE:06/09/13",
        "TIME:18:00",
        "ID:2013-00000572");

    doTest("T28",
        "(Dispatch) Unit:LA02 Status:Dispatched EMD Echo ** ** 21 CRAIGIE ST , LE ROY - ** 86 yo MALE - FAINTLY BREATHING ** MYRTLE ST / W MAIN ST ** 06/09/13 11:19 ** 2013-00000571 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA02",
        "CALL:EMD Echo - 86 yo MALE - FAINTLY BREATHING",
        "ADDR:21 CRAIGIE ST",
        "CITY:LE ROY",
        "X:MYRTLE ST / W MAIN ST",
        "DATE:06/09/13",
        "TIME:11:19",
        "ID:2013-00000571");

    doTest("T29",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Delta ** ** 28 LINCOLN AVE , LE ROY - ** 26 YO FEMALE WITH SYNCOPAL EPISODE ** SOUTH ST / WOLCOTT ST ** 06/07/13 21:14 ** 2013-00000570 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Delta - 26 YO FEMALE WITH SYNCOPAL EPISODE",
        "ADDR:28 LINCOLN AVE",
        "CITY:LE ROY",
        "X:SOUTH ST / WOLCOTT ST",
        "DATE:06/07/13",
        "TIME:21:14",
        "ID:2013-00000570");

    doTest("T30",
        "(Dispatch) Unit:LA01 Status:Dispatched EMD Alpha ** ** 7285 GRISWOLD RD , LE ROY - PH ** 14 YO SUBJECT WITH CHEST PAINS ** WEST BERGEN RD / HEWES RD ** 06/07/13 20:26 ** 2013-00000569 **\n\n\n" +
        "CONFIDENTIALITY NOTICE:  The information contained in this message and any documents, files, previous messages or other information attached to it, may be privileged, confidential and protected from disclosure. If the reader of this message is not the intended recipient(s), you are hereby notified that any dissemination, distribution, or copying of this communication is strictly prohibited. If you have received this communication in error, please notify us immediately by replying to the message and deleting it from your computer.�  ",

        "UNIT:LA01",
        "CALL:EMD Alpha - 14 YO SUBJECT WITH CHEST PAINS",
        "ADDR:7285 GRISWOLD RD",
        "CITY:LE ROY",
        "APT:PH",
        "X:WEST BERGEN RD / HEWES RD",
        "DATE:06/07/13",
        "TIME:20:26",
        "ID:2013-00000569");
 
  }
  
  public static void main(String[] args) {
    new NYGeneseeCountyParserTest().generateTests("T1");
  }
}