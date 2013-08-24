package net.anei.cadpage.parsers.OK;

import org.junit.Test;

import net.anei.cadpage.parsers.BaseParserTest;

/*
Garfield County, OK
Contact: Active911
Agency name: Drummond Fire Department
Location: Drummond, OK, United States
Sender: 911firedispatch@enid.org

(Call) Incident No.: 201300047247 Category: FIRE-SMOKE / INVESTIGATION2\nAddress: 8500 W HWY 412 GARFIELD COUNTY\nPrecinct: 1 ESZ: 5E\nOpen DateTime / DSN: 07/14/2013 11:33:03 / 187\nDispatch DateTime: 07/14/2013 11:35:03\nEnroute DateTime: 07/14/2013 12:25:19\nArrival DateTime: 07/14/2013 12:25:19\nDeparture DateTime: 07/14/2013 12:25:19\nClose DateTime / DSN: 07/14/2013 12:25:24 / 187\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: LAHOMA FD RURAL Source: E911\nCaller: (580) 977-9882\nCaller Address: 8500 W HWY 412\nBusiness Name: AT&T MOBILITY\nDisposition: C\n\nIncident Notes: At the fire works stand SW corner of IMO and 412 there is smoke coming from the area\nstand down page was sent\nDisposition: C\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/14/2013 11:34:40 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n07/14/2013 11:35:03 / LAHMFD /  / 187 / 21 / Dispatched on Incident\n07/14/2013 11:35:05 /  /  / 187 / PAGER / Sent Pager report to: \nmail.page-plus.net/5802130051@mail.page-plus.net\n07/14/2013 11:40:19 /  /  / 187 / INCCHNG / Notes Added: \nstand down page was sent\n07/14/2013 12:25:19 / LAHMFD /  / 187 / 8 / Clear From Incident
(Call) Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 10900 N BOOMER RD GARFIELD COUNTY\nPrecinct: 1\nOpen DateTime / DSN: 07/13/2013 17:40:53 / 3768\nDispatch DateTime: 07/13/2013 17:42:18\nEnroute DateTime: 07/13/2013 17:42:22\nArrival DateTime: 07/13/2013 17:50:14\nDeparture DateTime: 07/13/2013 23:16:47\nClose DateTime / DSN: 07/13/2013 23:16:49 / 3768\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: DRUMMOND FD RURAL Source: 3849\nCaller: HOELTZEL, MARK (580) 747-5087\nDisposition: N\n\nIncident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n2nd caller, brian whitson 7475923 stating the fire has sparked back up\n22 enroute with tanker\n705- tanker 71 enroute\ndrumm 22 on scene.\nunit 85 and 82 returning to station.\n22 and 20 released and returning to station.\n71 back at station\nevon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\nDisposition: N\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130090@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130093@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:52 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130089@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:56:29 / KREMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:56:40 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 18:03:39 / LAHMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 18:03:39 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130051@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 18:03:41 / LAHMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 18:12:23 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:15:53 / LAHMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:15:56 / KREMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:31:05 /  /  / 2902 / INCCHNG / Notes Added: \n 22 enroute with tanker\n07/13/2013 18:35:18 /  /  / 2902 / INCCHNG / Notes Added: \n 705- tanker 71 enroute\n07/13/2013 18:43:15 /  /  / 2902 / INCCHNG / Notes Added: \n drumm 22 on scene. \n07/13/2013 19:08:30 /  /  / 2902 / INCCHNG / Notes Added: \n unit 85 and 82 returning to station. \n07/13/2013 19:27:27 /  /  / 2902 / INCCHNG / Notes Added: \n 22 and 20 released and returning to station. \n07/13/2013 19:47:12 /  /  / 2902 / INCCHNG / Notes Added: \n 71 back at station\n07/13/2013 20:21:26 /  /  / 3888 / INCCHNG / Notes Added: \n evon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\n07/13/2013 20:22:49 / DRUMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 20:22:53 / LAHMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 20:22:58 / KREMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 23:16:47 / HILLFD /  / 3768 / 8 / Clear From Incident
(Call) Incident No.: 201300047068 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 6900 W LUCIEN RD GARFIELD COUNTY\nPrecinct: 1\nOpen DateTime / DSN: 07/13/2013 16:25:51 / 3849\nDispatch DateTime: 07/13/2013 16:29:31\nEnroute DateTime: 07/13/2013 16:32:41\nArrival DateTime: 07/13/2013 16:46:12\nDeparture DateTime: 07/13/2013 17:39:07\nClose DateTime / DSN: 07/13/2013 17:39:09 / 3849\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: DRUMMOND FD RURAL Source: 3849\nCaller: ECHARDT, CHRIS (580) 478-7579\nDisposition: N\n\nIncident Notes: 911,waukomis fd, grass fire 1/2 mile from a house pasture on fire. confirm to 911 on tri-county a\n2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\npage sent rfn\nDisposition: N\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 16:27:31 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 16:29:31 / WAUKFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 16:29:32 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130056@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 16:29:35 /  /  / 772 / INCCHNG / Notes Added: \n2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\n07/13/2013 16:29:40 /  /  / 3849 / INCCHNG / Notes Added: \npage sent rfn\n07/13/2013 16:32:41 / WAUKFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:37:20 / PIONFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:37:20 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130094@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 16:39:25 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:39:25 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130089@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 16:46:12 / WAUKFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 16:46:15 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 16:55:48 / PIONFD /  / 772 / 6 / Arrived on Scene\n07/13/2013 17:04:52 / PIONFD /  / 3849 / 8 / Clear From Incident\n07/13/2013 17:04:56 / DRUMFD /  / 3849 / 8 / Clear From Incident\n07/13/2013 17:39:07 / WAUKFD /  / 3849 / 8 / Clear From Incident
(Call) Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 10900 N BOOMER RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/13/2013 17:40:53 / \nDispatch DateTime: 07/13/2013 17:42:18\nEnroute DateTime: 07/13/2013 17:42:22\nArrival DateTime: 07/13/2013 17:50:14\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n2nd caller, brian whitson 7475923 stating the fire has sparked back up\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130090@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130093@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident

(Call) Incident No.: 201300046752 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 505 LISA LN WAUKOMIS\nOpen DateTime / DSN: 07/12/2013 14:13:47 / \nDispatch DateTime: 07/12/2013 14:15:09\nPolice: WAUKOMIS POLICE DEPARTMENT Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: Call Received on 07/12/2013 @ 14:13\n\nwife is poss having a stroke\nALERT!!! THIS STREET IS IN GARFIELD COUNTY, WAUKOMIS, OKLAHOMA!!!\ntone done\npage done\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/12/2013 14:13:56 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n07/12/2013 14:14:59 /  /  / 3849 / INCCHNG / Notes Added: \n tone done\n07/12/2013 14:15:02 /  /  / 3849 / INCCHNG / Notes Added: \n page done\n07/12/2013 14:15:09 / LIFE1 /  / 3849 / 21 / Dispatched on Incident\n07/12/2013 14:15:12 / WAUKFD /  / 3849 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300046626 Category: FIRE-GRASS / WILDFIRE\nAddress: 2400 N STABE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/12/2013 00:19:42 / \nDispatch DateTime: 07/12/2013 00:25:12\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: fire north of lahoma on stabe road near the cemetary  on the west side of the road. rp will be waiting in a red truck with white camper shell and will have flashers on.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/12/2013 00:23:20 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n07/12/2013 00:23:21 /  /  / 2902 / PAGER / Sent Pager report to: \nmail.page-plus.net/5805401954@mail.page-plus.net\n07/12/2013 00:25:13 / LAHMFD /  / 3888 / 21 / Dispatched on Incident
(Call) Incident No.: 201300046572 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 10800 W HWY 412 GARFIELD COUNTY\nOpen DateTime / DSN: 07/11/2013 18:39:25 / \nDispatch DateTime: 07/11/2013 18:41:35\nEnroute DateTime: 07/11/2013 18:41:38\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: PIONEER\n\nIncident Notes: Call Received on 07/11/2013 @ 18:37\nLocation: 1202 S WHEATRIDGE RD\ngoing down 132 to 412 white minivan pontiac difficulty breathing\nGCSO ADVISED\nrp called back and stated they will be at 132 n and 412.\nlife advised\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/11/2013 18:40:43 /  /  / 3888 / SENDINC / Incident Open by sending Work Area\n07/11/2013 18:41:18 /  /  / 3768 / INCCHNG / Notes Added: \n GCSO ADVISED\n07/11/2013 18:41:35 / E5 /  / 3888 / 21 / Dispatched on Incident\n07/11/2013 18:41:35 / LIFE2 /  / 3888 / 21 / Extra Unit on Incident\n07/11/2013 18:41:38 / E5 /  / 3888 / 23 / Enroute on Incident\n07/11/2013 18:42:11 /  /  / 2902 / INCCHNG / Notes Added: \n rp called back and stated they will be at 132 n and 412. \n07/11/2013 18:43:24 /  /  / 4005 / INCCHNG / Notes Added: \n life advised\n07/11/2013 18:43:41 / LAHMFD /  / 3888 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300046522 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 13200 W KEOWEE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/11/2013 14:53:47 / \nDispatch DateTime: 07/11/2013 15:00:44\nEnroute DateTime: 07/11/2013 15:09:02\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: voc lander is what rp called it- 2 miles west of hwy 132 on Keowee\npage sent\n2nd page sent\nCARRIER ENRT\nwill be a corral and the fence line. no structures around.\nrequested to send rfn\nRFN sent\n91,92,93 enrt\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/11/2013 14:56:13 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n07/11/2013 15:00:44 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n07/11/2013 15:00:45 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130090@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/11/2013 15:04:05 /  /  / 3849 / INCCHNG / Notes Added: \npage sent\n07/11/2013 15:08:25 /  /  / 3849 / INCCHNG / Notes Added: \n2nd page sent\n07/11/2013 15:09:02 / HILLFD /  / 2902 / 23 / Enroute on Incident\n07/11/2013 15:09:03 / HILLFD /  / 772 / 23 / Enroute on Incident\n07/11/2013 15:09:50 /  /  / 772 / INCCHNG / Notes Added: \nCARRIER ENRT\n07/11/2013 15:11:34 / CARRFD /  / 2902 / 23 / Enroute on Incident\n07/11/2013 15:11:38 / CARRFD /  / 3849 / 21 / Extra Unit on Incident\n07/11/2013 15:11:43 / CARRFD /  / 3849 / 23 / Enroute on Incident\n07/11/2013 15:13:57 /  /  / 3849 / INCCHNG / Notes Added: \nwill be a corral and the fence line. no structures around.\n07/11/2013 15:14:06 /  /  / 3849 / INCCHNG / Notes Added: \nrequested to send rfn\n07/11/2013 15:15:58 /  /  / 3849 / INCCHNG / Notes Added: \nRFN sent \n07/11/2013 15:18:08 /  /  / 3849 / INCCHNG / Notes Added: \n91,92,93 enrt \n07/11/2013 15:18:48 / LAHMFD /  / 3849 / 23 / Enroute on Incident
(Call) Incident No.: 201300046468 Category: RURAL-FIRE-STRUCTURE** / STRUCTURE FIRE\nAddress: 119 WESTWIND DR DRUMMOND\nOpen DateTime / DSN: 07/11/2013 11:40:50 / \nDispatch DateTime: 07/11/2013 11:42:15\nPolice: GARFIELDCOUNTY SHERIFFS OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: PIONEER\n\nIncident Notes: house on fire. kept saying 19 westwind village\n\nCall Received on 07/11/2013 @ 11:39\nLocation: 14723 W HWY 412\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/11/2013 11:41:40 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/11/2013 11:41:41 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130101@mail.page-plus.net\n250 Pager ID Accepted\n\n07/11/2013 11:42:15 / DRUMFD /  / 3849 / 21 / Dispatched on Incident
(Call) Incident No.: 201300046288 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 3000 N STABE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/10/2013 16:33:06 / \nDispatch DateTime: 07/10/2013 16:34:57\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: 911, Lahoma FD, Control Burn out of control. Confirm to 911 on Tri-County A.\npage sent\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/10/2013 16:34:47 /  /  / 3929 / SENDINC / Incident Open by sending Work Area\n07/10/2013 16:34:51 /  /  / 3929 / INCCHNG / Notes Added: \npage sent\n07/10/2013 16:34:57 / LAHMFD /  / 3849 / 21 / Dispatched on Incident
(Call) Incident No.: 201300046071 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 13000 S HWY 132 GARFIELD COUNTY\nOpen DateTime / DSN: 07/09/2013 18:28:11 / \nDispatch DateTime: 07/09/2013 18:31:30\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: PIONEER\n\nIncident Notes: Aimes blacktop on 132 S, 4-5 miles S of Drummond, grass fire\n\n\nCall Received on 07/09/2013 @ 18:27\nLocation: 12016 CAMP RD\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/09/2013 18:31:22 /  /  / 3522 / SENDINC / Incident Open by sending Work Area\n07/09/2013 18:31:30 / DRUMFD /  / 3522 / 21 / Dispatched on Incident
(Call) Incident No.: 201300046014 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 12600 W LUCIEN RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/09/2013 14:14:34 / \nDispatch DateTime: 07/09/2013 14:15:52\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: grass fire\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/09/2013 14:15:39 /  /  / 2967 / SENDINC / Incident Open by sending Work Area\n07/09/2013 14:15:52 / DRUMFD /  / 2967 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045970 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 8400 W LUCIEN RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/09/2013 11:05:14 / \nDispatch DateTime: 07/09/2013 11:13:14\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: grass fire in ditch 3 s, 5 west, and 1/4 back s from waukomis\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/09/2013 11:09:27 /  /  / 2967 / SENDINC / Incident Open by sending Work Area\n07/09/2013 11:13:14 / WAUKFD /  / 3938 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045896 Category: FIRE-GRASS / WILDFIRE\nAddress: 16219 W HWY 412 GARFIELD COUNTY\nOpen DateTime / DSN: 07/09/2013 00:01:15 / \nDispatch DateTime: 07/09/2013 00:05:01\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: 1/8 mile north of hwy 412 on gerald breckenridges fields\nrp states it looks like the fire is right in a group of trees\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/09/2013 00:04:15 /  /  / 4023 / SENDINC / Incident Open by sending Work Area\n07/09/2013 00:04:15 /  /  / 4023 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5805401954@mail.page-plus.net\n250 Page Sent Successfully\n\n07/09/2013 00:04:46 /  /  / 4023 / INCCHNG / Notes Added: \n rp states it looks like the fire is right in a group of trees\n07/09/2013 00:05:01 / LAHMFD /  / 3522 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045894 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 2700 W LONGHORN TRL GARFIELD COUNTY\nOpen DateTime / DSN: 07/08/2013 23:44:00 / \nDispatch DateTime: 07/08/2013 23:45:48\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: Possible grass fire, rp is VAFB, on Longhorn S of the base\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/08/2013 23:45:33 /  /  / 3522 / SENDINC / Incident Open by sending Work Area\n07/08/2013 23:45:49 / WAUKFD /  / 3522 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045892 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 131 ANTHONY DR LAHOMA\nOpen DateTime / DSN: 07/08/2013 23:30:24 / \nDispatch DateTime: 07/08/2013 23:32:20\nPolice: LAHOMA POLICE DEPARTMENT Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: possible stroke\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/08/2013 23:31:06 /  /  / 4023 / SENDINC / Incident Open by sending Work Area\n07/08/2013 23:32:20 / LAHMFD /  / 3522 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045725 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\nAddress: 16125 S GARLAND RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/08/2013 10:44:53 / \nDispatch DateTime: 07/08/2013 10:46:18\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: burning trash can fell over burning the grass near the house\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/08/2013 10:46:05 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n07/08/2013 10:46:07 /  /  / 187 / PAGER / Sent Pager report to: \nmail.page-plus.net/5802130101@mail.page-plus.net\n07/08/2013 10:46:19 / WAUKFD /  / 187 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045346 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 605 E EUCLID AVE WAUKOMIS\nOpen DateTime / DSN: 07/06/2013 15:04:12 / \nDispatch DateTime: 07/06/2013 15:05:21\nPolice: WAUKOMIS POLICE DEPARTMENT Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: AT&T MOBILITY\n\nIncident Notes: woman in labor\n\nCall Received on 07/06/2013 @ 15:03\nLocation: 220 W WOOD  RD - W SECTOR\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 15:04:37 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n07/06/2013 15:05:22 / WAUKFD /  / 3809 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045338 Complaint No.: 13-0002515F Category: FIRE-GRASS / WILDFIRE\nAddress: 3900 W FOX DR GARFIELD COUNTY\nOpen DateTime / DSN: 07/06/2013 13:59:47 / \nDispatch DateTime: 07/06/2013 14:03:41\nEnroute DateTime: 07/06/2013 14:04:21\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: report of grass fire at nw corner Fox and Oakwood.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 14:01:31 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n07/06/2013 14:01:32 /  /  / 772 / PAGER / Sent Pager report to: \nmail.page-plus.net/5805401954@mail.page-plus.net\n07/06/2013 14:03:41 / EM5 /  / 3809 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/06/2013 14:03:42 / EM5 /  / 3809 / 21 / Dispatched on Incident\n07/06/2013 14:03:42 /  /  / 3809 / PRINT / Sent print report to: \n\\epd01\RNR_S5\n07/06/2013 14:03:42 / EM4 /  / 3809 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/06/2013 14:03:42 / EM4 /  / 3809 / 21 / Extra Unit on Incident\n07/06/2013 14:03:42 /  /  / 3809 / PRINT / Sent print report to: \n\\epd01\RNR_S4\n07/06/2013 14:03:42 / GR5 /  / 3809 / 21 / Extra Unit on Incident\n07/06/2013 14:03:42 / E5 /  / 3809 / 21 / Extra Unit on Incident\n07/06/2013 14:03:47 / EM4 /  / 3849 / 8 / Clear From Incident\n07/06/2013 14:04:16 / GR4 /  / 3809 / 21 / Extra Unit on Incident\n07/06/2013 14:04:22 / GR4 /  / 3809 / 23 / Enroute on Incident\n07/06/2013 14:05:04 / E5 /  / 3809 / COMPLNUMB / Complaint Number 13-0002515F Assigned\n07/06/2013 14:06:23 / GR5 /  / 3809 / 23 / Enroute on Incident\n07/06/2013 14:06:25 / EM5 /  / 3809 / 23 / Enroute on Incident\n07/06/2013 14:06:25 / WAUKFD /  / 772 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300045333 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 10800 E SKELETON RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/06/2013 13:39:11 / \nDispatch DateTime: 07/06/2013 13:45:44\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: FAIRMONT FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: 911, Drummond FD half a mile east of drummond on skeleton rd. grass fire. confirm to 911 on Tri-County A\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 13:45:00 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n07/06/2013 13:45:44 / DRUMFD /  / 3809 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045317 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 8904 S 66TH ST GARFIELD COUNTY\nOpen DateTime / DSN: 07/06/2013 12:47:16 / \nDispatch DateTime: 07/06/2013 12:49:23\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: 911,PIONERR-SKELETON, POSSIBLE OD LIFE AND GCSO ENRT. CONFIRM WITH 911 ON TRI-COUNTY A.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 12:48:31 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n07/06/2013 12:49:23 / PIONFD /  / 3809 / 21 / Dispatched on Incident\n07/06/2013 12:49:24 /  /  / 3809 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130094@mail.page-plus.net\n250 Pager ID Accepted\n\n07/06/2013 12:51:13 / WAUKFD /  / 772 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300045259 Category: 76 / NON-INJURY ACCIDENT\nAddress: 5501 S WHEATRIDGE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/06/2013 07:13:48 / \nDispatch DateTime: 07/06/2013 07:15:21\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: GREEN DODGE PU HIT POLE, REQ FIRE RESPONSE.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 07:14:40 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n07/06/2013 07:15:21 / WAUKFD /  / 3809 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045231 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 9000 E PHILLIPS AVE GARFIELD COUNTY\nOpen DateTime / DSN: 07/06/2013 01:42:01 / \nDispatch DateTime: 07/06/2013 01:46:15\nEnroute DateTime: 07/06/2013 01:46:43\nPolice: GARFIELD COUNTY SHERIFFS DEPARTMENT Fire: BRECKENRIDGE FIRE DEPARTMENT EMS: GARBER EMS \nBusiness Name: T-MOBILE USA INC.\n\nIncident Notes: Call Received on 07/06/2013 @ 01:40\nLocation: 920 S 13TH ST E911 - SECTOR E\nrp states that north of breckingridge unknown exact location for a fire.\n1 MILE NORTH OF BRECKINRIDGE NO STRUCTURES,\nWILL BE ON BRECKINRIDGE RD\npage sent and received.\nSTATES THAT IF YOU GO DOWN BRECKINRIDGE RD YOU CAN SEE IT RIGHT OUTIDE TOWEN\n1101 enroute to station.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/06/2013 01:43:13 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n07/06/2013 01:43:58 /  /  / 3888 / INCCHNG / Notes Added: \n 1 MILE NORTH OF BRECKINRIDGE NO STRUCTURES, \n07/06/2013 01:44:09 /  /  / 3888 / INCCHNG / Notes Added: \n WILL BE ON BRECKINRIDGE RD\n07/06/2013 01:44:45 /  /  / 2902 / INCCHNG / Notes Added: \n page sent and received. \n07/06/2013 01:46:15 / EM3 /  / 2902 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/06/2013 01:46:16 / EM3 /  / 2902 / 21 / Dispatched on Incident\n07/06/2013 01:46:17 /  /  / 2902 / PRINT / Sent print report to: \n\\epd01\RNR_S3\n07/06/2013 01:46:17 / GR3 /  / 2902 / 21 / Extra Unit on Incident\n07/06/2013 01:46:44 / E3 /  / 2902 / 23 / Enroute on Incident\n07/06/2013 01:46:58 / BREKFD /  / 2902 / 21 / Extra Unit on Incident\n07/06/2013 01:46:59 /  /  / 2902 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130077@mail.page-plus.net\n250 Pager ID Accepted\n\n07/06/2013 01:47:04 / E3 /  / 2902 / 21 / Extra Unit on Incident\n07/06/2013 01:47:04 /  /  / 3888 / INCCHNG / Notes Added: \n STATES THAT IF YOU GO DOWN BRECKINRIDGE RD YOU CAN SEE IT RIGHT OUTIDE TOWEN\n07/06/2013 01:48:25 / BREKFD /  / 2902 / 23 / Enroute on Incident\n07/06/2013 01:49:18 / E3 /  / 2902 / 23 / Enroute on Incident\n07/06/2013 01:49:20 / EM3 /  / 2902 / 23 / Enroute on Incident\n07/06/2013 01:49:23 / GR3 /  / 2902 / 23 / Enroute on Incident\n07/06/2013 01:49:31 /  /  / 2902 / INCCHNG / Notes Added: \n 1101 enroute to station. \n07/06/2013 01:50:25 / LAHMFD /  / 2902 / 23 / Enroute on Incident
(Call) Incident No.: 201300045150 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 1813 S LOGAN RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/05/2013 20:58:06 / \nDispatch DateTime: 07/05/2013 21:00:29\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: PIONEER\n\nIncident Notes: Call Received on 07/05/2013 @ 20:57\nLocation: 14723 W HWY 412\nfield on fire lahoma\nPAGE SENT\nrp states no structures nearby\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/05/2013 20:58:36 /  /  / 3888 / SENDINC / Incident Open by sending Work Area\n07/05/2013 20:59:50 /  /  / 3768 / INCCHNG / Notes Added: \n PAGE SENT\n07/05/2013 21:00:15 /  /  / 3888 / INCCHNG / Notes Added: \n rp states no structures nearby\n07/05/2013 21:00:30 / LAHMFD /  / 3888 / 21 / Dispatched on Incident
(Call) Incident No.: 201300045103 Category: FIRE-GRASS / WILDFIRE\nAddress: 400 E SOUTHGATE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/05/2013 17:15:58 / \nDispatch DateTime: 07/05/2013 17:17:10\nEnroute DateTime: 07/05/2013 17:18:30\nPolice: GARFIELD COUNTY SHERIFFS OFFICE Fire: ENID FIRE DE EMS: LIFE EMS \nBusiness Name: AT&T MOBILITY\n\nIncident Notes: Call Received on 07/05/2013 @ 17:15\nLocation: 3128 S VAN BUREN - SE SECTOR\ngrass fire between leona mitchell and van buren\n\nCity: ENID\nCategory: FIRE-GRASS\nSubCategory: WILDFIRE\nPriority: 1\nLast Name: MARTIN\nFirst Name: KATIE\nPhone: (580) 747-6864\nBusiness Name: AT&T MOBILITY\nLatitude: 97.8922820\nLongitude: 36.3623964\nPrecinct: 1\nSource: E911\nPolice: <UNDEFINED>\nOpenDateTime: 07/05/2013 17:15:47\nNotes: small grass fire \nnorth side of sidegate\n.Call Received on 07/05/2013 @ 17:15\nLocation: 3128 S VAN BUREN - SE SECTOR\n\nStreet Number: 329\nDirection: W\nStreet: SOUTHGATE RD\nCity: GARFIELD COUNTY\nCategory: FIRE-GRASS\nSubCategory: WILDFIRE\nPriority: 1\nPhone: (580) 234-3827\nBusiness Name: JACK; WARNER FIREWORKS\nCaller Street Number: 329\nCaller Direction: W\nCaller Street: SOUTHGATE RD\nPrecinct: 1\nSector: Z5\nGEO: F9\nSource: E911\nPolice: GAFIELD COUNTY SHERIFFS OFFICE\nFire: ENID FIRE DEPARTMENT\nEMS: LIFE EMS\nOpenDateTime: 07/05/2013 17:17:46\nNotes: Call Received on 07/05/2013 @ 17:16\nLocation: 1-2M E OF VAN BUREN\n\nStreet Number: 400\nDirection: E\nStreet: SOUTHGATE RD\nCity: GARFIELD COUNTY\nFirst Name: RENEE\nPhone: (580) 542-2583\nBusiness Name: PION\nCaller Street Number: 400\nCaller Direction: E\nCaller Street: SOUTHGATE RD\nLatitude: 97.8705883\nLongitude: 36.3617527\nPrecinct: 1\nSector: Z5\nESZ: 1E\nSource: E911\nPolice: GARFIELD COUNTY SHERIFFS OFFICE\nFire: ENID FIRE DE\nEMS: LIFE EMS\nOpenDateTime: 07/05/2013 17:20:30\nNotes: another caller claiming to see the fire\n\nCall Received on 07/05/2013 @ 17:19\nLocation: 3001 S  VAN BUREN ST\npage tone s4ent\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/05/2013 17:16:37 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/05/2013 17:16:41 /  /  / 3849 / PAGER / SendPageData. Process SEND 250.\nSent Pager report to: \nmail.page-plus.net/5805401954@mail.page-plus.net\n550 Invalid Command\n550 Invalid Command\n\n07/05/2013 17:16:45 /  /  / 4022 / ATTWA / Work Area Attached\n07/05/2013 17:17:10 / E3 /  / 3849 / 21 / Dispatched on Incident\n07/05/2013 17:17:10 /  /  / 3849 / PRINT / Sent print report to: \n\\epd01\RNR_S3\n07/05/2013 17:17:46 / EM4 /  / 3849 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/05/2013 17:17:46 / EM4 /  / 3849 / 21 / Extra Unit on Incident\n07/05/2013 17:17:46 /  /  / 3849 / PRINT / Sent print report to: \n\\epd01\RNR_S4\n07/05/2013 17:17:47 / EM1 /  / 3849 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/05/2013 17:17:47 / EM1 /  / 3849 / 21 / Extra Unit on Incident\n07/05/2013 17:17:47 /  /  / 3849 / PRINT / Sent print report to: \n\\epd01\RNR_S1\n07/05/2013 17:17:59 /  /  / 772 / ATTWA / Work Area Attached\n07/05/2013 17:18:05 / E1 /  / 3849 / 21 / Extra Unit on Incident\n07/05/2013 17:18:05 / GR4 /  / 3849 / 21 / Extra Unit on Incident\n07/05/2013 17:18:30 / E1 /  / 3849 / 23 / Enroute on Incident\n07/05/2013 17:18:32 / EM1 /  / 3849 / 23 / Enroute on Incident\n07/05/2013 17:18:34 / E3 /  / 3849 / 8 / Clear From Incident\n07/05/2013 17:19:59 / GR4 /  / 3664 / 23 / Enroute on Incident\n07/05/2013 17:20:54 /  /  / 4022 / ATTWA / Work Area Attached\n07/05/2013 17:21:11 /  /  / 3664 / INCCHNG / Notes Added: \n page tone s4ent\n07/05/2013 17:21:31 / WAUKFD /  / 3664 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300044974 Category: MEDICAL / MEDICAL EMERGENCY\nAddress: 2026 S IMO RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/05/2013 09:10:13 / \nDispatch DateTime: 07/05/2013 09:11:46\nEnroute DateTime: 07/05/2013 09:12:37\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: 911, lahoma fire, medical @ 2026 s imo, rp @ 2345203, confirm on tri county a\n\nCall Received on 07/05/2013 @ 09:09\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/05/2013 09:10:46 /  /  / 3664 / SENDINC / Incident Open by sending Work Area\n07/05/2013 09:11:46 / M5 /  / 3664 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n07/05/2013 09:11:46 / M5 /  / 3664 / 21 / Dispatched on Incident\n07/05/2013 09:11:46 /  /  / 3664 / PRINT / Sent print report to: \n\\epd01\RNR_S5\n07/05/2013 09:11:48 / E5 /  / 3664 / 21 / Extra Unit on Incident\n07/05/2013 09:12:37 / E5 /  / 3664 / 23 / Enroute on Incident\n07/05/2013 09:12:38 / M5 /  / 3664 / 23 / Enroute on Incident\n07/05/2013 09:13:37 / LAHMFD /  / 3664 / 21 / Extra Unit on Incident
(Call) Incident No.: 201300044886 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\nAddress: 16219 W HWY 412 GARFIELD COUNTY\nOpen DateTime / DSN: 07/05/2013 00:01:55 / \nDispatch DateTime: 07/05/2013 00:03:35\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: T-MOBILE USA INC.\n\nIncident Notes: Call Received on 07/05/2013 @ 00:01\nLocation: 14723 W HWY 412 - SECTOR S  in lahoma. \nrp states that there is a grass fire near her house.\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/05/2013 00:02:37 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n07/05/2013 00:02:37 /  /  / 2902 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130101@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/05/2013 00:03:35 / LAHMFD /  / 3768 / 21 / Dispatched on Incident
(Call) Incident No.: 201300044874 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 5800 S IMO RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/04/2013 23:33:46 / \nDispatch DateTime: 07/04/2013 23:35:19\nEnroute DateTime: 07/04/2013 23:35:19\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: US CELLULAR\n\nIncident Notes: Call Received on 07/04/2013 @ 23:32\nLocation: 4002 W WILLOW RD.... IMO AND GARRIOT.. GRASS FIRE 3 OR 4 MILES SOUTH ON IMO FROM GARRIOTT\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/04/2013 23:34:18 /  /  / 3768 / SENDINC / Incident Open by sending Work Area\n07/04/2013 23:35:19 / E5 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:35:29 / E5 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:35:55 / DRUMFD /  / 3768 / 23 / Enroute on Incident
(Call) Incident No.: 201300044871 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 3000 E HAYWARD RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/04/2013 23:27:30 / \nDispatch DateTime: 07/04/2013 23:29:45\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: rp states a field is on fire\nPAGE SENT\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/04/2013 23:28:04 /  /  / 4005 / SENDINC / Incident Open by sending Work Area\n07/04/2013 23:28:34 /  /  / 4005 / INCCHNG / LastName/FirstName/Phone Changed from //(580) ___-____ to WILLIAMS/BILLIE/(580) 541-0908\n07/04/2013 23:29:17 /  /  / 3768 / INCCHNG / Notes Added: \n PAGE SENT\n07/04/2013 23:29:46 / WAUKFD /  / 3768 / 21 / Dispatched on Incident
(Call) Incident No.: 201300044865 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\nAddress: 4318 E SOUTHGATE RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/04/2013 23:11:04 / \nDispatch DateTime: 07/04/2013 23:15:57\nEnroute DateTime: 07/04/2013 23:15:57\nPolice: GARFIED COUNTY SHERIFFS DEPARTMENT Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \nBusiness Name: AT&T MOBILITY\n\nIncident Notes: Call Received on 07/04/2013 @ 23:10\nLocation: 220 W WOOD  RD - N SECTOR\n\nrp states a field is on fire. rp states that its about a quarter of a mile from a house.\nrp states its across the street from this res\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/04/2013 23:11:48 /  /  / 4005 / SENDINC / Incident Open by sending Work Area\n07/04/2013 23:11:48 /  /  / 4005 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130101@mail.page-plus.net\n250 Pager ID Accepted\n\n07/04/2013 23:12:02 /  /  / 4005 / INCCHNG / LastName/FirstName Changed from / to STIERS/SAMI\n07/04/2013 23:12:21 /  /  / 4005 / INCCHNG / Notes Added: \n rp states its across the street from this res\n07/04/2013 23:15:58 / E5 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:16:04 / R1 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:16:04 /  /  / 3888 / PRINT / Sent print report to: \n\\epd01\RNR_S1\n07/04/2013 23:16:09 / GR4 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:16:09 /  /  / 3888 / PRINT / Sent print report to: \n\\epd01\RNR_S4\n07/04/2013 23:16:38 / PIONFD /  / 3768 / 21 / Extra Unit on Incident\n07/04/2013 23:16:39 /  /  / 3768 / PAGER / SendPageData. Process SEND 250.\nSent Pager report to: \nmail.page-plus.net/5802130094@mail.page-plus.net\n550 Invalid Command\n550 Invalid Command\n550 Invalid Command\n550 Invalid Command\n\n07/04/2013 23:17:17 / FAIRFD /  / 3768 / 21 / Extra Unit on Incident\n07/04/2013 23:17:19 /  /  / 3768 / PAGER / SendPageData. Process SEND 250.\nSent Pager report to: \nmail.page-plus.net/5802130092@mail.page-plus.net\n550 Invalid Command\n550 Invalid Command\n550 Invalid Command\n550 Invalid Command\n\n07/04/2013 23:17:24 / PIONFD /  / 3768 / 8 / Clear From Incident\n07/04/2013 23:17:25 / E4 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:17:48 / FAIRFD /  / 3768 / 23 / Enroute on Incident\n07/04/2013 23:18:08 / C4 /  / 3888 / 23 / Enroute on Incident\n07/04/2013 23:18:16 / WAUKFD /  / 3768 / 21 / Extra Unit on Incident

 */

public class OKGarfieldCountyParserTest extends BaseParserTest {
  
  public OKGarfieldCountyParserTest() {
    setParser(new OKGarfieldCountyParser(), "GARFIELD COUNTY", "OK");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "(Call) Incident No.: 201300047247 Category: FIRE-SMOKE / INVESTIGATION2\n" +
        "Address: 8500 W HWY 412 GARFIELD COUNTY\n" +
        "Precinct: 1 ESZ: 5E\n" +
        "Open DateTime / DSN: 07/14/2013 11:33:03 / 187\n" +
        "Dispatch DateTime: 07/14/2013 11:35:03\n" +
        "Enroute DateTime: 07/14/2013 12:25:19\n" +
        "Arrival DateTime: 07/14/2013 12:25:19\n" +
        "Departure DateTime: 07/14/2013 12:25:19\n" +
        "Close DateTime / DSN: 07/14/2013 12:25:24 / 187\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Responsible Agency: LAHOMA FD RURAL Source: E911\n" +
        "Caller: (580) 977-9882\n" +
        "Caller Address: 8500 W HWY 412\n" +
        "Business Name: AT&T MOBILITY\n" +
        "Disposition: C\n\n" +
        "Incident Notes: At the fire works stand SW corner of IMO and 412 there is smoke coming from the area\n" +
        "stand down page was sent\n" +
        "Disposition: C\n\n\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/14/2013 11:34:40 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n" +
        "07/14/2013 11:35:03 / LAHMFD /  / 187 / 21 / Dispatched on Incident\n" +
        "07/14/2013 11:35:05 /  /  / 187 / PAGER / Sent Pager report to: \n" +
        "mail.page-plus.net/5802130051@mail.page-plus.net\n" +
        "07/14/2013 11:40:19 /  /  / 187 / INCCHNG / Notes Added: \n" +
        "stand down page was sent\n" +
        "07/14/2013 12:25:19 / LAHMFD /  / 187 / 8 / Clear From Incident",

        "CALL:RUN REPORT",
        "PLACE:Incident No.: 201300047247 Category: FIRE-SMOKE / INVESTIGATION2\nAddress: 8500 W HWY 412 GARFIELD COUNTY\nPrecinct: 1 ESZ: 5E\nOpen DateTime / DSN: 07/14/2013 11:33:03 / 187\nDispatch DateTime: 07/14/2013 11:35:03\nEnroute DateTime: 07/14/2013 12:25:19\nArrival DateTime: 07/14/2013 12:25:19\nDeparture DateTime: 07/14/2013 12:25:19\nClose DateTime / DSN: 07/14/2013 12:25:24 / 187\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: LAHOMA FD RURAL Source: E911\nCaller: (580) 977-9882\nCaller Address: 8500 W HWY 412\nBusiness Name: AT&T MOBILITY\nDisposition: C\n\nIncident Notes: At the fire works stand SW corner of IMO and 412 there is smoke coming from the area\nstand down page was sent\nDisposition: C\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/14/2013 11:34:40 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n07/14/2013 11:35:03 / LAHMFD /  / 187 / 21 / Dispatched on Incident\n07/14/2013 11:35:05 /  /  / 187 / PAGER / Sent Pager report to: \nmail.page-plus.net/5802130051@mail.page-plus.net\n07/14/2013 11:40:19 /  /  / 187 / INCCHNG / Notes Added: \nstand down page was sent\n07/14/2013 12:25:19 / LAHMFD /  / 187 / 8 / Clear From Incident");

    doTest("T2",
        "(Call) Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 10900 N BOOMER RD GARFIELD COUNTY\n" +
        "Precinct: 1\n" +
        "Open DateTime / DSN: 07/13/2013 17:40:53 / 3768\n" +
        "Dispatch DateTime: 07/13/2013 17:42:18\n" +
        "Enroute DateTime: 07/13/2013 17:42:22\n" +
        "Arrival DateTime: 07/13/2013 17:50:14\n" +
        "Departure DateTime: 07/13/2013 23:16:47\n" +
        "Close DateTime / DSN: 07/13/2013 23:16:49 / 3768\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Responsible Agency: DRUMMOND FD RURAL Source: 3849\n" +
        "Caller: HOELTZEL, MARK (580) 747-5087\n" +
        "Disposition: N\n\n" +
        "Incident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n" +
        "2nd caller, brian whitson 7475923 stating the fire has sparked back up\n" +
        "22 enroute with tanker\n" +
        "705- tanker 71 enroute\n" +
        "drumm 22 on scene.\n" +
        "unit 85 and 82 returning to station.\n" +
        "22 and 20 released and returning to station.\n" +
        "71 back at station\n" +
        "evon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\n" +
        "Disposition: N\n\n\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130090@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n" +
        " 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n" +
        "07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130093@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/13/2013 17:55:52 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130089@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/13/2013 17:56:29 / KREMFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 17:56:40 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 18:03:39 / LAHMFD /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/13/2013 18:03:39 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130051@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/13/2013 18:03:41 / LAHMFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 18:12:23 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 18:15:53 / LAHMFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 18:15:56 / KREMFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 18:31:05 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " 22 enroute with tanker\n" +
        "07/13/2013 18:35:18 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " 705- tanker 71 enroute\n" +
        "07/13/2013 18:43:15 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " drumm 22 on scene. \n" +
        "07/13/2013 19:08:30 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " unit 85 and 82 returning to station. \n" +
        "07/13/2013 19:27:27 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " 22 and 20 released and returning to station. \n" +
        "07/13/2013 19:47:12 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " 71 back at station\n" +
        "07/13/2013 20:21:26 /  /  / 3888 / INCCHNG / Notes Added: \n" +
        " evon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\n" +
        "07/13/2013 20:22:49 / DRUMFD /  / 2902 / 8 / Clear From Incident\n" +
        "07/13/2013 20:22:53 / LAHMFD /  / 2902 / 8 / Clear From Incident\n" +
        "07/13/2013 20:22:58 / KREMFD /  / 2902 / 8 / Clear From Incident\n" +
        "07/13/2013 23:16:47 / HILLFD /  / 3768 / 8 / Clear From Incident",

        "CALL:RUN REPORT",
        "PLACE:Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 10900 N BOOMER RD GARFIELD COUNTY\nPrecinct: 1\nOpen DateTime / DSN: 07/13/2013 17:40:53 / 3768\nDispatch DateTime: 07/13/2013 17:42:18\nEnroute DateTime: 07/13/2013 17:42:22\nArrival DateTime: 07/13/2013 17:50:14\nDeparture DateTime: 07/13/2013 23:16:47\nClose DateTime / DSN: 07/13/2013 23:16:49 / 3768\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: DRUMMOND FD RURAL Source: 3849\nCaller: HOELTZEL, MARK (580) 747-5087\nDisposition: N\n\nIncident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n2nd caller, brian whitson 7475923 stating the fire has sparked back up\n22 enroute with tanker\n705- tanker 71 enroute\ndrumm 22 on scene.\nunit 85 and 82 returning to station.\n22 and 20 released and returning to station.\n71 back at station\nevon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\nDisposition: N\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130090@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130093@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:52 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130089@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:56:29 / KREMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:56:40 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 18:03:39 / LAHMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 18:03:39 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130051@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 18:03:41 / LAHMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 18:12:23 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:15:53 / LAHMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:15:56 / KREMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 18:31:05 /  /  / 2902 / INCCHNG / Notes Added: \n 22 enroute with tanker\n07/13/2013 18:35:18 /  /  / 2902 / INCCHNG / Notes Added: \n 705- tanker 71 enroute\n07/13/2013 18:43:15 /  /  / 2902 / INCCHNG / Notes Added: \n drumm 22 on scene. \n07/13/2013 19:08:30 /  /  / 2902 / INCCHNG / Notes Added: \n unit 85 and 82 returning to station. \n07/13/2013 19:27:27 /  /  / 2902 / INCCHNG / Notes Added: \n 22 and 20 released and returning to station. \n07/13/2013 19:47:12 /  /  / 2902 / INCCHNG / Notes Added: \n 71 back at station\n07/13/2013 20:21:26 /  /  / 3888 / INCCHNG / Notes Added: \n evon 6032692 called stating the fire was sparking again but that she saw firetrucks coming by line disconnected on call back wouldnt answer the phone\n07/13/2013 20:22:49 / DRUMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 20:22:53 / LAHMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 20:22:58 / KREMFD /  / 2902 / 8 / Clear From Incident\n07/13/2013 23:16:47 / HILLFD /  / 3768 / 8 / Clear From Incident");

    doTest("T3",
        "(Call) Incident No.: 201300047068 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 6900 W LUCIEN RD GARFIELD COUNTY\n" +
        "Precinct: 1\n" +
        "Open DateTime / DSN: 07/13/2013 16:25:51 / 3849\n" +
        "Dispatch DateTime: 07/13/2013 16:29:31\n" +
        "Enroute DateTime: 07/13/2013 16:32:41\n" +
        "Arrival DateTime: 07/13/2013 16:46:12\n" +
        "Departure DateTime: 07/13/2013 17:39:07\n" +
        "Close DateTime / DSN: 07/13/2013 17:39:09 / 3849\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Responsible Agency: DRUMMOND FD RURAL Source: 3849\n" +
        "Caller: ECHARDT, CHRIS (580) 478-7579\n" +
        "Disposition: N\n\n" +
        "Incident Notes: 911,waukomis fd, grass fire 1/2 mile from a house pasture on fire. confirm to 911 on tri-county a\n" +
        "2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\n" +
        "page sent rfn\n" +
        "Disposition: N\n\n\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/13/2013 16:27:31 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/13/2013 16:29:31 / WAUKFD /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/13/2013 16:29:32 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130056@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/13/2013 16:29:35 /  /  / 772 / INCCHNG / Notes Added: \n" +
        "2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\n" +
        "07/13/2013 16:29:40 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "page sent rfn\n" +
        "07/13/2013 16:32:41 / WAUKFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 16:37:20 / PIONFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 16:37:20 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130094@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/13/2013 16:39:25 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 16:39:25 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130089@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/13/2013 16:46:12 / WAUKFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 16:46:15 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 16:55:48 / PIONFD /  / 772 / 6 / Arrived on Scene\n" +
        "07/13/2013 17:04:52 / PIONFD /  / 3849 / 8 / Clear From Incident\n" +
        "07/13/2013 17:04:56 / DRUMFD /  / 3849 / 8 / Clear From Incident\n" +
        "07/13/2013 17:39:07 / WAUKFD /  / 3849 / 8 / Clear From Incident",

        "CALL:RUN REPORT",
        "PLACE:Incident No.: 201300047068 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 6900 W LUCIEN RD GARFIELD COUNTY\nPrecinct: 1\nOpen DateTime / DSN: 07/13/2013 16:25:51 / 3849\nDispatch DateTime: 07/13/2013 16:29:31\nEnroute DateTime: 07/13/2013 16:32:41\nArrival DateTime: 07/13/2013 16:46:12\nDeparture DateTime: 07/13/2013 17:39:07\nClose DateTime / DSN: 07/13/2013 17:39:09 / 3849\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \nResponsible Agency: DRUMMOND FD RURAL Source: 3849\nCaller: ECHARDT, CHRIS (580) 478-7579\nDisposition: N\n\nIncident Notes: 911,waukomis fd, grass fire 1/2 mile from a house pasture on fire. confirm to 911 on tri-county a\n2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\npage sent rfn\nDisposition: N\n\n\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 16:27:31 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 16:29:31 / WAUKFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 16:29:32 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130056@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 16:29:35 /  /  / 772 / INCCHNG / Notes Added: \n2nd rp, 554-7111, 4 w on wood and 2 1/2 s, pasture\n07/13/2013 16:29:40 /  /  / 3849 / INCCHNG / Notes Added: \npage sent rfn\n07/13/2013 16:32:41 / WAUKFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:37:20 / PIONFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:37:20 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130094@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 16:39:25 / DRUMFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 16:39:25 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130089@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 16:46:12 / WAUKFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 16:46:15 / DRUMFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 16:55:48 / PIONFD /  / 772 / 6 / Arrived on Scene\n07/13/2013 17:04:52 / PIONFD /  / 3849 / 8 / Clear From Incident\n07/13/2013 17:04:56 / DRUMFD /  / 3849 / 8 / Clear From Incident\n07/13/2013 17:39:07 / WAUKFD /  / 3849 / 8 / Clear From Incident");

    doTest("T4",
        "(Call) Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 10900 N BOOMER RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/13/2013 17:40:53 / \n" +
        "Dispatch DateTime: 07/13/2013 17:42:18\n" +
        "Enroute DateTime: 07/13/2013 17:42:22\n" +
        "Arrival DateTime: 07/13/2013 17:50:14\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n" +
        "2nd caller, brian whitson 7475923 stating the fire has sparked back up\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130090@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n" +
        " 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n" +
        "07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n" +
        "07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130093@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident",

        "CALL:RUN REPORT",
        "PLACE:Incident No.: 201300047081 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\nAddress: 10900 N BOOMER RD GARFIELD COUNTY\nOpen DateTime / DSN: 07/13/2013 17:40:53 / \nDispatch DateTime: 07/13/2013 17:42:18\nEnroute DateTime: 07/13/2013 17:42:22\nArrival DateTime: 07/13/2013 17:50:14\nPolice: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n\nIncident Notes: fire sparked back up and there is not enough to keep it from spreading to his field. will be on the north west corner on the east side.\n2nd caller, brian whitson 7475923 stating the fire has sparked back up\n\n\nLog Date Time / Unit / DSN / Status / Log Notes \n07/13/2013 17:42:18 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n07/13/2013 17:42:18 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n07/13/2013 17:42:18 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\nSent Pager report to: \nmail.page-plus.net/5802130090@mail.page-plus.net\n220 SNPP Gateway Ready\n\n07/13/2013 17:42:22 / HILLFD /  / 3849 / 23 / Enroute on Incident\n07/13/2013 17:48:05 /  /  / 4022 / INCCHNG / Notes Added: \n 2nd caller, brian whitson 7475923 stating the fire has sparked back up\n07/13/2013 17:50:14 / HILLFD /  / 3849 / 6 / Arrived on Scene\n07/13/2013 17:55:46 / KREMFD /  / 3849 / 21 / Extra Unit on Incident\n07/13/2013 17:55:46 /  /  / 3849 / PAGER / StartSession. Welcome 220.\nSent Pager report to: \nmail.page-plus.net/5802130093@mail.page-plus.net\n250 Pager ID Accepted\n\n07/13/2013 17:55:52 / DRUMFD /  / 3849 / 21 / Extra Unit on Incident");
 
  }
 
  
  @Test
  public void testDrummondFireDepartment() {

    doTest("T1",
        "(Call) Incident No.: 201300047247 Category: FIRE-SMOKE / INVESTIGATION2\n" +
        "Address: 8500 W HWY 412 GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/14/2013 11:33:03 / \n" +
        "Dispatch DateTime: 07/14/2013 11:35:03\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: AT&T MOBILITY\n\n" +
        "Incident Notes: At the fire works stand SW corner of IMO and 412 there is smoke coming from the area\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/14/2013 11:34:40 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n" +
        "07/14/2013 11:35:03 / LAHMFD /  / 187 / 21 / Dispatched on Incident",

        "ID:201300047247",
        "CALL:FIRE-SMOKE / INVESTIGATION2",
        "ADDR:8500 W HWY 412",
        "MADDR:8500 W US 412",
        "CITY:GARFIELD COUNTY",
        "DATE:07/14/2013",
        "TIME:11:35:03",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:At the fire works stand SW corner of IMO and 412 there is smoke coming from the area");

    doTest("T2",
        "(Call) Incident No.: 201300046980 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\n" +
        "Address: 10900 N BOOMER RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/13/2013 10:11:43 / \n" +
        "Dispatch DateTime: 07/13/2013 10:13:58\n" +
        "Enroute DateTime: 07/13/2013 10:19:04\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: AT&T MOBILITY\n\n" +
        "Incident Notes: Call Received on 07/13/2013 @ 10:09\n" +
        "Location: 3110 PURDUE AVE - N SECTORenterance to residenceis on cintennial. was a control burn, burning north towards building\n" +
        "on corner of Sentinial and Boomer, Hillsdale is aware that they were doing a control burn\n" +
        "page sent\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/13/2013 10:12:30 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n" +
        "07/13/2013 10:12:31 /  /  / 4022 / PAGER / SendPageData. Process SEND 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130101@mail.page-plus.net\n" +
        "550 Invalid Command\n\n" +
        "07/13/2013 10:13:58 / HILLFD /  / 772 / 21 / Dispatched on Incident\n" +
        "07/13/2013 10:14:00 /  /  / 772 / PAGER / SendPageData. Process SEND 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130090@mail.page-plus.net\n" +
        "550 Invalid Command\n\n" +
        "07/13/2013 10:15:18 /  /  / 4022 / INCCHNG / Notes Added: \n" +
        " on corner of Sentinial and Boomer, Hillsdale is aware that they were doing a control burn\n" +
        "07/13/2013 10:16:14 /  /  / 772 / INCCHNG / Notes Added: \n" +
        "page sent\n" +
        "07/13/2013 10:19:04 / HILLFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/13/2013 10:21:30 / LAHMFD /  / 772 / 21 / Extra Unit on Incident",

        "ID:201300046980",
        "CALL:RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES",
        "ADDR:10900 N BOOMER RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/13/2013",
        "TIME:10:13:58",
        "SRC:HILLSDALE FIRE DEPARTMENT",
        "INFO:Location: 3110 PURDUE AVE - N SECTORenterance to residenceis on cintennial. was a control burn, burning north towards building\non corner of Sentinial and Boomer, Hillsdale is aware that they were doing a control burn\npage sent");

    doTest("T3",
        "(Call) Incident No.: 201300046817 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 221 N THIRD ST 7 WAUKOMIS\n" +
        "Open DateTime / DSN: 07/12/2013 17:34:35 / \n" +
        "Dispatch DateTime: 07/12/2013 17:36:13\n" +
        "Police: WAUKOMIS POLICE DEPARTMENT Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: Call Received on 07/12/2013 @ 17:34\n" +
        "10 month old super glue in his mouth\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/12/2013 17:35:21 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/12/2013 17:36:14 / WAUKFD /  / 3849 / 21 / Dispatched on Incident",

        "ID:201300046817",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:221 N THIRD ST",
        "APT:7",
        "CITY:WAUKOMIS",
        "DATE:07/12/2013",
        "TIME:17:36:13",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:10 month old super glue in his mouth");

    doTest("T4",
        "(Call) Incident No.: 201300046752 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 505 LISA LN WAUKOMIS\n" +
        "Open DateTime / DSN: 07/12/2013 14:13:47 / \n" +
        "Dispatch DateTime: 07/12/2013 14:15:09\n" +
        "Police: WAUKOMIS POLICE DEPARTMENT Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: Call Received on 07/12/2013 @ 14:13\n\n" +
        "wife is poss having a stroke\n" +
        "ALERT!!! THIS STREET IS IN GARFIELD COUNTY, WAUKOMIS, OKLAHOMA!!!\n" +
        "tone done\n" +
        "page done\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/12/2013 14:13:56 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n" +
        "07/12/2013 14:14:59 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        " tone done\n" +
        "07/12/2013 14:15:02 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        " page done\n" +
        "07/12/2013 14:15:09 / LIFE1 /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/12/2013 14:15:12 / WAUKFD /  / 3849 / 21 / Extra Unit on Incident",

        "ID:201300046752",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:505 LISA LN",
        "CITY:WAUKOMIS",
        "DATE:07/12/2013",
        "TIME:14:15:09",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:wife is poss having a stroke\nALERT!!! THIS STREET IS IN GARFIELD COUNTY, WAUKOMIS, OKLAHOMA!!!\ntone done\npage done");

    doTest("T5",
        "(Call) Incident No.: 201300046626 Category: FIRE-GRASS / WILDFIRE\n" +
        "Address: 2400 N STABE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/12/2013 00:19:42 / \n" +
        "Dispatch DateTime: 07/12/2013 00:25:12\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: fire north of lahoma on stabe road near the cemetary  on the west side of the road. rp will be waiting in a red truck with white camper shell and will have flashers on.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/12/2013 00:23:20 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n" +
        "07/12/2013 00:23:21 /  /  / 2902 / PAGER / Sent Pager report to: \n" +
        "mail.page-plus.net/5805401954@mail.page-plus.net\n" +
        "07/12/2013 00:25:13 / LAHMFD /  / 3888 / 21 / Dispatched on Incident",

        "ID:201300046626",
        "CALL:FIRE-GRASS / WILDFIRE",
        "ADDR:2400 N STABE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/12/2013",
        "TIME:00:25:12",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:fire north of lahoma on stabe road near the cemetary  on the west side of the road. rp will be waiting in a red truck with white camper shell and will have flashers on.");

    doTest("T6",
        "(Call) Incident No.: 201300046572 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 10800 W HWY 412 GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/11/2013 18:39:25 / \n" +
        "Dispatch DateTime: 07/11/2013 18:41:35\n" +
        "Enroute DateTime: 07/11/2013 18:41:38\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: PIONEER\n\n" +
        "Incident Notes: Call Received on 07/11/2013 @ 18:37\n" +
        "Location: 1202 S WHEATRIDGE RD\n" +
        "going down 132 to 412 white minivan pontiac difficulty breathing\n" +
        "GCSO ADVISED\n" +
        "rp called back and stated they will be at 132 n and 412.\n" +
        "life advised\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/11/2013 18:40:43 /  /  / 3888 / SENDINC / Incident Open by sending Work Area\n" +
        "07/11/2013 18:41:18 /  /  / 3768 / INCCHNG / Notes Added: \n" +
        " GCSO ADVISED\n" +
        "07/11/2013 18:41:35 / E5 /  / 3888 / 21 / Dispatched on Incident\n" +
        "07/11/2013 18:41:35 / LIFE2 /  / 3888 / 21 / Extra Unit on Incident\n" +
        "07/11/2013 18:41:38 / E5 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/11/2013 18:42:11 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " rp called back and stated they will be at 132 n and 412. \n" +
        "07/11/2013 18:43:24 /  /  / 4005 / INCCHNG / Notes Added: \n" +
        " life advised\n" +
        "07/11/2013 18:43:41 / LAHMFD /  / 3888 / 21 / Extra Unit on Incident",

        "ID:201300046572",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:10800 W HWY 412",
        "MADDR:10800 W US 412",
        "CITY:GARFIELD COUNTY",
        "DATE:07/11/2013",
        "TIME:18:41:35",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "PLACE:PIONEER",
        "INFO:Location: 1202 S WHEATRIDGE RD\ngoing down 132 to 412 white minivan pontiac difficulty breathing\nGCSO ADVISED\nrp called back and stated they will be at 132 n and 412.\nlife advised");

    doTest("T7",
        "(Call) Incident No.: 201300046522 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 13200 W KEOWEE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/11/2013 14:53:47 / \n" +
        "Dispatch DateTime: 07/11/2013 15:00:44\n" +
        "Enroute DateTime: 07/11/2013 15:09:02\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: HILLSDALE FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: voc lander is what rp called it- 2 miles west of hwy 132 on Keowee\n" +
        "page sent\n" +
        "2nd page sent\n" +
        "CARRIER ENRT\n" +
        "will be a corral and the fence line. no structures around.\n" +
        "requested to send rfn\n" +
        "RFN sent\n" +
        "91,92,93 enrt\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/11/2013 14:56:13 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n" +
        "07/11/2013 15:00:44 / HILLFD /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/11/2013 15:00:45 /  /  / 3849 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130090@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/11/2013 15:04:05 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "page sent\n" +
        "07/11/2013 15:08:25 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "2nd page sent\n" +
        "07/11/2013 15:09:02 / HILLFD /  / 2902 / 23 / Enroute on Incident\n" +
        "07/11/2013 15:09:03 / HILLFD /  / 772 / 23 / Enroute on Incident\n" +
        "07/11/2013 15:09:50 /  /  / 772 / INCCHNG / Notes Added: \n" +
        "CARRIER ENRT\n" +
        "07/11/2013 15:11:34 / CARRFD /  / 2902 / 23 / Enroute on Incident\n" +
        "07/11/2013 15:11:38 / CARRFD /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/11/2013 15:11:43 / CARRFD /  / 3849 / 23 / Enroute on Incident\n" +
        "07/11/2013 15:13:57 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "will be a corral and the fence line. no structures around.\n" +
        "07/11/2013 15:14:06 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "requested to send rfn\n" +
        "07/11/2013 15:15:58 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "RFN sent \n" +
        "07/11/2013 15:18:08 /  /  / 3849 / INCCHNG / Notes Added: \n" +
        "91,92,93 enrt \n" +
        "07/11/2013 15:18:48 / LAHMFD /  / 3849 / 23 / Enroute on Incident",

        "ID:201300046522",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:13200 W KEOWEE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/11/2013",
        "TIME:15:00:44",
        "SRC:HILLSDALE FIRE DEPARTMENT",
        "INFO:voc lander is what rp called it- 2 miles west of hwy 132 on Keowee\npage sent\n2nd page sent\nCARRIER ENRT\nwill be a corral and the fence line. no structures around.\nrequested to send rfn\nRFN sent\n91,92,93 enrt");

    doTest("T8",
        "(Call) Incident No.: 201300046468 Category: RURAL-FIRE-STRUCTURE** / STRUCTURE FIRE\n" +
        "Address: 119 WESTWIND DR DRUMMOND\n" +
        "Open DateTime / DSN: 07/11/2013 11:40:50 / \n" +
        "Dispatch DateTime: 07/11/2013 11:42:15\n" +
        "Police: GARFIELDCOUNTY SHERIFFS OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: PIONEER\n\n" +
        "Incident Notes: house on fire. kept saying 19 westwind village\n\n" +
        "Call Received on 07/11/2013 @ 11:39\n" +
        "Location: 14723 W HWY 412\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/11/2013 11:41:40 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/11/2013 11:41:41 /  /  / 3849 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130101@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/11/2013 11:42:15 / DRUMFD /  / 3849 / 21 / Dispatched on Incident",

        "ID:201300046468",
        "CALL:RURAL-FIRE-STRUCTURE** / STRUCTURE FIRE",
        "ADDR:119 WESTWIND DR",
        "CITY:DRUMMOND",
        "DATE:07/11/2013",
        "TIME:11:42:15",
        "SRC:DRUMMOND FIRE DEPARTMENT",
        "PLACE:PIONEER",
        "INFO:house on fire. kept saying 19 westwind village\nLocation: 14723 W HWY 412");

    doTest("T9",
        "(Call) Incident No.: 201300046288 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 3000 N STABE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/10/2013 16:33:06 / \n" +
        "Dispatch DateTime: 07/10/2013 16:34:57\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: 911, Lahoma FD, Control Burn out of control. Confirm to 911 on Tri-County A.\n" +
        "page sent\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/10/2013 16:34:47 /  /  / 3929 / SENDINC / Incident Open by sending Work Area\n" +
        "07/10/2013 16:34:51 /  /  / 3929 / INCCHNG / Notes Added: \n" +
        "page sent\n" +
        "07/10/2013 16:34:57 / LAHMFD /  / 3849 / 21 / Dispatched on Incident",

        "ID:201300046288",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:3000 N STABE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/10/2013",
        "TIME:16:34:57",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:911, Lahoma FD, Control Burn out of control. Confirm to 911 on Tri-County A.\npage sent");

    doTest("T10",
        "(Call) Incident No.: 201300046071 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 13000 S HWY 132 GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/09/2013 18:28:11 / \n" +
        "Dispatch DateTime: 07/09/2013 18:31:30\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: PIONEER\n\n" +
        "Incident Notes: Aimes blacktop on 132 S, 4-5 miles S of Drummond, grass fire\n\n\n" +
        "Call Received on 07/09/2013 @ 18:27\n" +
        "Location: 12016 CAMP RD\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/09/2013 18:31:22 /  /  / 3522 / SENDINC / Incident Open by sending Work Area\n" +
        "07/09/2013 18:31:30 / DRUMFD /  / 3522 / 21 / Dispatched on Incident",

        "ID:201300046071",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:13000 S HWY 132",
        "CITY:GARFIELD COUNTY",
        "DATE:07/09/2013",
        "TIME:18:31:30",
        "SRC:DRUMMOND FIRE DEPARTMENT",
        "PLACE:PIONEER",
        "INFO:Aimes blacktop on 132 S, 4-5 miles S of Drummond, grass fire\nLocation: 12016 CAMP RD");

    doTest("T11",
        "(Call) Incident No.: 201300046014 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 12600 W LUCIEN RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/09/2013 14:14:34 / \n" +
        "Dispatch DateTime: 07/09/2013 14:15:52\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: grass fire\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/09/2013 14:15:39 /  /  / 2967 / SENDINC / Incident Open by sending Work Area\n" +
        "07/09/2013 14:15:52 / DRUMFD /  / 2967 / 21 / Dispatched on Incident",

        "ID:201300046014",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:12600 W LUCIEN RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/09/2013",
        "TIME:14:15:52",
        "SRC:DRUMMOND FIRE DEPARTMENT",
        "INFO:grass fire");

    doTest("T12",
        "(Call) Incident No.: 201300045970 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 8400 W LUCIEN RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/09/2013 11:05:14 / \n" +
        "Dispatch DateTime: 07/09/2013 11:13:14\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: grass fire in ditch 3 s, 5 west, and 1/4 back s from waukomis\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/09/2013 11:09:27 /  /  / 2967 / SENDINC / Incident Open by sending Work Area\n" +
        "07/09/2013 11:13:14 / WAUKFD /  / 3938 / 21 / Dispatched on Incident",

        "ID:201300045970",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:8400 W LUCIEN RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/09/2013",
        "TIME:11:13:14",
        "SRC:DRUMMOND FIRE DEPARTMENT",
        "INFO:grass fire in ditch 3 s, 5 west, and 1/4 back s from waukomis");

    doTest("T13",
        "(Call) Incident No.: 201300045896 Category: FIRE-GRASS / WILDFIRE\n" +
        "Address: 16219 W HWY 412 GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/09/2013 00:01:15 / \n" +
        "Dispatch DateTime: 07/09/2013 00:05:01\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: 1/8 mile north of hwy 412 on gerald breckenridges fields\n" +
        "rp states it looks like the fire is right in a group of trees\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/09/2013 00:04:15 /  /  / 4023 / SENDINC / Incident Open by sending Work Area\n" +
        "07/09/2013 00:04:15 /  /  / 4023 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5805401954@mail.page-plus.net\n" +
        "250 Page Sent Successfully\n\n" +
        "07/09/2013 00:04:46 /  /  / 4023 / INCCHNG / Notes Added: \n" +
        " rp states it looks like the fire is right in a group of trees\n" +
        "07/09/2013 00:05:01 / LAHMFD /  / 3522 / 21 / Dispatched on Incident",

        "ID:201300045896",
        "CALL:FIRE-GRASS / WILDFIRE",
        "ADDR:16219 W HWY 412",
        "MADDR:16219 W US 412",
        "CITY:GARFIELD COUNTY",
        "DATE:07/09/2013",
        "TIME:00:05:01",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:1/8 mile north of hwy 412 on gerald breckenridges fields\nrp states it looks like the fire is right in a group of trees");

    doTest("T14",
        "(Call) Incident No.: 201300045894 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 2700 W LONGHORN TRL GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/08/2013 23:44:00 / \n" +
        "Dispatch DateTime: 07/08/2013 23:45:48\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: Possible grass fire, rp is VAFB, on Longhorn S of the base\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/08/2013 23:45:33 /  /  / 3522 / SENDINC / Incident Open by sending Work Area\n" +
        "07/08/2013 23:45:49 / WAUKFD /  / 3522 / 21 / Dispatched on Incident",

        "ID:201300045894",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:2700 W LONGHORN TRL",
        "CITY:GARFIELD COUNTY",
        "DATE:07/08/2013",
        "TIME:23:45:48",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:Possible grass fire, rp is VAFB, on Longhorn S of the base");

    doTest("T15",
        "(Call) Incident No.: 201300045892 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 131 ANTHONY DR LAHOMA\n" +
        "Open DateTime / DSN: 07/08/2013 23:30:24 / \n" +
        "Dispatch DateTime: 07/08/2013 23:32:20\n" +
        "Police: LAHOMA POLICE DEPARTMENT Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: possible stroke\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/08/2013 23:31:06 /  /  / 4023 / SENDINC / Incident Open by sending Work Area\n" +
        "07/08/2013 23:32:20 / LAHMFD /  / 3522 / 21 / Dispatched on Incident",

        "ID:201300045892",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:131 ANTHONY DR",
        "CITY:LAHOMA",
        "DATE:07/08/2013",
        "TIME:23:32:20",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:possible stroke");

    doTest("T16",
        "(Call) Incident No.: 201300045725 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\n" +
        "Address: 16125 S GARLAND RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/08/2013 10:44:53 / \n" +
        "Dispatch DateTime: 07/08/2013 10:46:18\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: burning trash can fell over burning the grass near the house\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/08/2013 10:46:05 /  /  / 187 / SENDINC / Incident Open by sending Work Area\n" +
        "07/08/2013 10:46:07 /  /  / 187 / PAGER / Sent Pager report to: \n" +
        "mail.page-plus.net/5802130101@mail.page-plus.net\n" +
        "07/08/2013 10:46:19 / WAUKFD /  / 187 / 21 / Dispatched on Incident",

        "ID:201300045725",
        "CALL:RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES",
        "ADDR:16125 S GARLAND RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/08/2013",
        "TIME:10:46:18",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:burning trash can fell over burning the grass near the house");

    doTest("T17",
        "(Call) Incident No.: 201300045346 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 605 E EUCLID AVE WAUKOMIS\n" +
        "Open DateTime / DSN: 07/06/2013 15:04:12 / \n" +
        "Dispatch DateTime: 07/06/2013 15:05:21\n" +
        "Police: WAUKOMIS POLICE DEPARTMENT Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: AT&T MOBILITY\n\n" +
        "Incident Notes: woman in labor\n\n" +
        "Call Received on 07/06/2013 @ 15:03\n" +
        "Location: 220 W WOOD  RD - W SECTOR\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 15:04:37 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 15:05:22 / WAUKFD /  / 3809 / 21 / Dispatched on Incident",

        "ID:201300045346",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:605 E EUCLID AVE",
        "CITY:WAUKOMIS",
        "DATE:07/06/2013",
        "TIME:15:05:21",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:woman in labor\nLocation: 220 W WOOD  RD - W SECTOR");

    doTest("T18",
        "(Call) Incident No.: 201300045338 Complaint No.: 13-0002515F Category: FIRE-GRASS / WILDFIRE\n" +
        "Address: 3900 W FOX DR GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/06/2013 13:59:47 / \n" +
        "Dispatch DateTime: 07/06/2013 14:03:41\n" +
        "Enroute DateTime: 07/06/2013 14:04:21\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: report of grass fire at nw corner Fox and Oakwood.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 14:01:31 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 14:01:32 /  /  / 772 / PAGER / Sent Pager report to: \n" +
        "mail.page-plus.net/5805401954@mail.page-plus.net\n" +
        "07/06/2013 14:03:41 / EM5 /  / 3809 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/06/2013 14:03:42 / EM5 /  / 3809 / 21 / Dispatched on Incident\n" +
        "07/06/2013 14:03:42 /  /  / 3809 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S5\n" +
        "07/06/2013 14:03:42 / EM4 /  / 3809 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/06/2013 14:03:42 / EM4 /  / 3809 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 14:03:42 /  /  / 3809 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S4\n" +
        "07/06/2013 14:03:42 / GR5 /  / 3809 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 14:03:42 / E5 /  / 3809 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 14:03:47 / EM4 /  / 3849 / 8 / Clear From Incident\n" +
        "07/06/2013 14:04:16 / GR4 /  / 3809 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 14:04:22 / GR4 /  / 3809 / 23 / Enroute on Incident\n" +
        "07/06/2013 14:05:04 / E5 /  / 3809 / COMPLNUMB / Complaint Number 13-0002515F Assigned\n" +
        "07/06/2013 14:06:23 / GR5 /  / 3809 / 23 / Enroute on Incident\n" +
        "07/06/2013 14:06:25 / EM5 /  / 3809 / 23 / Enroute on Incident\n" +
        "07/06/2013 14:06:25 / WAUKFD /  / 772 / 21 / Extra Unit on Incident",

        "ID:201300045338",
        "CALL:FIRE-GRASS / WILDFIRE",
        "ADDR:3900 W FOX DR",
        "CITY:GARFIELD COUNTY",
        "DATE:07/06/2013",
        "TIME:14:03:41",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:report of grass fire at nw corner Fox and Oakwood.");

    doTest("T19",
        "(Call) Incident No.: 201300045333 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 10800 E SKELETON RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/06/2013 13:39:11 / \n" +
        "Dispatch DateTime: 07/06/2013 13:45:44\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: FAIRMONT FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: 911, Drummond FD half a mile east of drummond on skeleton rd. grass fire. confirm to 911 on Tri-County A\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 13:45:00 /  /  / 4022 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 13:45:44 / DRUMFD /  / 3809 / 21 / Dispatched on Incident",

        "ID:201300045333",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:10800 E SKELETON RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/06/2013",
        "TIME:13:45:44",
        "SRC:FAIRMONT FIRE DEPARTMENT",
        "INFO:911, Drummond FD half a mile east of drummond on skeleton rd. grass fire. confirm to 911 on Tri-County A");

    doTest("T20",
        "(Call) Incident No.: 201300045317 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 8904 S 66TH ST GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/06/2013 12:47:16 / \n" +
        "Dispatch DateTime: 07/06/2013 12:49:23\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: 911,PIONERR-SKELETON, POSSIBLE OD LIFE AND GCSO ENRT. CONFIRM WITH 911 ON TRI-COUNTY A.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 12:48:31 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 12:49:23 / PIONFD /  / 3809 / 21 / Dispatched on Incident\n" +
        "07/06/2013 12:49:24 /  /  / 3809 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130094@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/06/2013 12:51:13 / WAUKFD /  / 772 / 21 / Extra Unit on Incident",

        "ID:201300045317",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:8904 S 66TH ST",
        "CITY:GARFIELD COUNTY",
        "DATE:07/06/2013",
        "TIME:12:49:23",
        "SRC:PIONEER FIRE DEPARTMENT",
        "INFO:911,PIONERR-SKELETON, POSSIBLE OD LIFE AND GCSO ENRT. CONFIRM WITH 911 ON TRI-COUNTY A.");

    doTest("T21",
        "(Call) Incident No.: 201300045259 Category: 76 / NON-INJURY ACCIDENT\n" +
        "Address: 5501 S WHEATRIDGE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/06/2013 07:13:48 / \n" +
        "Dispatch DateTime: 07/06/2013 07:15:21\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: WAUKOMIS FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: GREEN DODGE PU HIT POLE, REQ FIRE RESPONSE.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 07:14:40 /  /  / 772 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 07:15:21 / WAUKFD /  / 3809 / 21 / Dispatched on Incident",

        "ID:201300045259",
        "CALL:76 / NON-INJURY ACCIDENT",
        "ADDR:5501 S WHEATRIDGE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/06/2013",
        "TIME:07:15:21",
        "SRC:WAUKOMIS FIRE DEPARTMENT",
        "INFO:GREEN DODGE PU HIT POLE, REQ FIRE RESPONSE.");

    doTest("T22",
        "(Call) Incident No.: 201300045231 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 9000 E PHILLIPS AVE GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/06/2013 01:42:01 / \n" +
        "Dispatch DateTime: 07/06/2013 01:46:15\n" +
        "Enroute DateTime: 07/06/2013 01:46:43\n" +
        "Police: GARFIELD COUNTY SHERIFFS DEPARTMENT Fire: BRECKENRIDGE FIRE DEPARTMENT EMS: GARBER EMS \n" +
        "Business Name: T-MOBILE USA INC.\n\n" +
        "Incident Notes: Call Received on 07/06/2013 @ 01:40\n" +
        "Location: 920 S 13TH ST E911 - SECTOR E\n" +
        "rp states that north of breckingridge unknown exact location for a fire.\n" +
        "1 MILE NORTH OF BRECKINRIDGE NO STRUCTURES,\n" +
        "WILL BE ON BRECKINRIDGE RD\n" +
        "page sent and received.\n" +
        "STATES THAT IF YOU GO DOWN BRECKINRIDGE RD YOU CAN SEE IT RIGHT OUTIDE TOWEN\n" +
        "1101 enroute to station.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/06/2013 01:43:13 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n" +
        "07/06/2013 01:43:58 /  /  / 3888 / INCCHNG / Notes Added: \n" +
        " 1 MILE NORTH OF BRECKINRIDGE NO STRUCTURES, \n" +
        "07/06/2013 01:44:09 /  /  / 3888 / INCCHNG / Notes Added: \n" +
        " WILL BE ON BRECKINRIDGE RD\n" +
        "07/06/2013 01:44:45 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " page sent and received. \n" +
        "07/06/2013 01:46:15 / EM3 /  / 2902 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/06/2013 01:46:16 / EM3 /  / 2902 / 21 / Dispatched on Incident\n" +
        "07/06/2013 01:46:17 /  /  / 2902 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S3\n" +
        "07/06/2013 01:46:17 / GR3 /  / 2902 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 01:46:44 / E3 /  / 2902 / 23 / Enroute on Incident\n" +
        "07/06/2013 01:46:58 / BREKFD /  / 2902 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 01:46:59 /  /  / 2902 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130077@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/06/2013 01:47:04 / E3 /  / 2902 / 21 / Extra Unit on Incident\n" +
        "07/06/2013 01:47:04 /  /  / 3888 / INCCHNG / Notes Added: \n" +
        " STATES THAT IF YOU GO DOWN BRECKINRIDGE RD YOU CAN SEE IT RIGHT OUTIDE TOWEN\n" +
        "07/06/2013 01:48:25 / BREKFD /  / 2902 / 23 / Enroute on Incident\n" +
        "07/06/2013 01:49:18 / E3 /  / 2902 / 23 / Enroute on Incident\n" +
        "07/06/2013 01:49:20 / EM3 /  / 2902 / 23 / Enroute on Incident\n" +
        "07/06/2013 01:49:23 / GR3 /  / 2902 / 23 / Enroute on Incident\n" +
        "07/06/2013 01:49:31 /  /  / 2902 / INCCHNG / Notes Added: \n" +
        " 1101 enroute to station. \n" +
        "07/06/2013 01:50:25 / LAHMFD /  / 2902 / 23 / Enroute on Incident",

        "ID:201300045231",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:9000 E PHILLIPS AVE",
        "CITY:GARFIELD COUNTY",
        "DATE:07/06/2013",
        "TIME:01:46:15",
        "SRC:BRECKENRIDGE FIRE DEPARTMENT",
        "INFO:Location: 920 S 13TH ST E911 - SECTOR E\nrp states that north of breckingridge unknown exact location for a fire.\n1 MILE NORTH OF BRECKINRIDGE NO STRUCTURES,\nWILL BE ON BRECKINRIDGE RD\npage sent and received.\nSTATES THAT IF YOU GO DOWN BRECKINRIDGE RD YOU CAN SEE IT RIGHT OUTIDE TOWEN\n1101 enroute to station.");

    doTest("T23",
        "(Call) Incident No.: 201300045150 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 1813 S LOGAN RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/05/2013 20:58:06 / \n" +
        "Dispatch DateTime: 07/05/2013 21:00:29\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: PIONEER\n\n" +
        "Incident Notes: Call Received on 07/05/2013 @ 20:57\n" +
        "Location: 14723 W HWY 412\n" +
        "field on fire lahoma\n" +
        "PAGE SENT\n" +
        "rp states no structures nearby\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/05/2013 20:58:36 /  /  / 3888 / SENDINC / Incident Open by sending Work Area\n" +
        "07/05/2013 20:59:50 /  /  / 3768 / INCCHNG / Notes Added: \n" +
        " PAGE SENT\n" +
        "07/05/2013 21:00:15 /  /  / 3888 / INCCHNG / Notes Added: \n" +
        " rp states no structures nearby\n" +
        "07/05/2013 21:00:30 / LAHMFD /  / 3888 / 21 / Dispatched on Incident",

        "ID:201300045150",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:1813 S LOGAN RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/05/2013",
        "TIME:21:00:29",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "PLACE:PIONEER",
        "INFO:Location: 14723 W HWY 412\nfield on fire lahoma\nPAGE SENT\nrp states no structures nearby");

    doTest("T24",
        "(Call) Incident No.: 201300045103 Category: FIRE-GRASS / WILDFIRE\n" +
        "Address: 400 E SOUTHGATE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/05/2013 17:15:58 / \n" +
        "Dispatch DateTime: 07/05/2013 17:17:10\n" +
        "Enroute DateTime: 07/05/2013 17:18:30\n" +
        "Police: GARFIELD COUNTY SHERIFFS OFFICE Fire: ENID FIRE DE EMS: LIFE EMS \n" +
        "Business Name: AT&T MOBILITY\n\n" +
        "Incident Notes: Call Received on 07/05/2013 @ 17:15\n" +
        "Location: 3128 S VAN BUREN - SE SECTOR\n" +
        "grass fire between leona mitchell and van buren\n\n" +
        "City: ENID\n" +
        "Category: FIRE-GRASS\n" +
        "SubCategory: WILDFIRE\n" +
        "Priority: 1\n" +
        "Last Name: MARTIN\n" +
        "First Name: KATIE\n" +
        "Phone: (580) 747-6864\n" +
        "Business Name: AT&T MOBILITY\n" +
        "Latitude: 97.8922820\n" +
        "Longitude: 36.3623964\n" +
        "Precinct: 1\n" +
        "Source: E911\n" +
        "Police: <UNDEFINED>\n" +
        "OpenDateTime: 07/05/2013 17:15:47\n" +
        "Notes: small grass fire \n" +
        "north side of sidegate\n" +
        ".Call Received on 07/05/2013 @ 17:15\n" +
        "Location: 3128 S VAN BUREN - SE SECTOR\n\n" +
        "Street Number: 329\n" +
        "Direction: W\n" +
        "Street: SOUTHGATE RD\n" +
        "City: GARFIELD COUNTY\n" +
        "Category: FIRE-GRASS\n" +
        "SubCategory: WILDFIRE\n" +
        "Priority: 1\n" +
        "Phone: (580) 234-3827\n" +
        "Business Name: JACK; WARNER FIREWORKS\n" +
        "Caller Street Number: 329\n" +
        "Caller Direction: W\n" +
        "Caller Street: SOUTHGATE RD\n" +
        "Precinct: 1\n" +
        "Sector: Z5\n" +
        "GEO: F9\n" +
        "Source: E911\n" +
        "Police: GAFIELD COUNTY SHERIFFS OFFICE\n" +
        "Fire: ENID FIRE DEPARTMENT\n" +
        "EMS: LIFE EMS\n" +
        "OpenDateTime: 07/05/2013 17:17:46\n" +
        "Notes: Call Received on 07/05/2013 @ 17:16\n" +
        "Location: 1-2M E OF VAN BUREN\n\n" +
        "Street Number: 400\n" +
        "Direction: E\n" +
        "Street: SOUTHGATE RD\n" +
        "City: GARFIELD COUNTY\n" +
        "First Name: RENEE\n" +
        "Phone: (580) 542-2583\n" +
        "Business Name: PION\n" +
        "Caller Street Number: 400\n" +
        "Caller Direction: E\n" +
        "Caller Street: SOUTHGATE RD\n" +
        "Latitude: 97.8705883\n" +
        "Longitude: 36.3617527\n" +
        "Precinct: 1\n" +
        "Sector: Z5\n" +
        "ESZ: 1E\n" +
        "Source: E911\n" +
        "Police: GARFIELD COUNTY SHERIFFS OFFICE\n" +
        "Fire: ENID FIRE DE\n" +
        "EMS: LIFE EMS\n" +
        "OpenDateTime: 07/05/2013 17:20:30\n" +
        "Notes: another caller claiming to see the fire\n\n" +
        "Call Received on 07/05/2013 @ 17:19\n" +
        "Location: 3001 S  VAN BUREN ST\n" +
        "page tone s4ent\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/05/2013 17:16:37 /  /  / 3849 / SENDINC / Incident Open by sending Work Area\n" +
        "07/05/2013 17:16:41 /  /  / 3849 / PAGER / SendPageData. Process SEND 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5805401954@mail.page-plus.net\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n\n" +
        "07/05/2013 17:16:45 /  /  / 4022 / ATTWA / Work Area Attached\n" +
        "07/05/2013 17:17:10 / E3 /  / 3849 / 21 / Dispatched on Incident\n" +
        "07/05/2013 17:17:10 /  /  / 3849 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S3\n" +
        "07/05/2013 17:17:46 / EM4 /  / 3849 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/05/2013 17:17:46 / EM4 /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/05/2013 17:17:46 /  /  / 3849 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S4\n" +
        "07/05/2013 17:17:47 / EM1 /  / 3849 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/05/2013 17:17:47 / EM1 /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/05/2013 17:17:47 /  /  / 3849 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S1\n" +
        "07/05/2013 17:17:59 /  /  / 772 / ATTWA / Work Area Attached\n" +
        "07/05/2013 17:18:05 / E1 /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/05/2013 17:18:05 / GR4 /  / 3849 / 21 / Extra Unit on Incident\n" +
        "07/05/2013 17:18:30 / E1 /  / 3849 / 23 / Enroute on Incident\n" +
        "07/05/2013 17:18:32 / EM1 /  / 3849 / 23 / Enroute on Incident\n" +
        "07/05/2013 17:18:34 / E3 /  / 3849 / 8 / Clear From Incident\n" +
        "07/05/2013 17:19:59 / GR4 /  / 3664 / 23 / Enroute on Incident\n" +
        "07/05/2013 17:20:54 /  /  / 4022 / ATTWA / Work Area Attached\n" +
        "07/05/2013 17:21:11 /  /  / 3664 / INCCHNG / Notes Added: \n" +
        " page tone s4ent\n" +
        "07/05/2013 17:21:31 / WAUKFD /  / 3664 / 21 / Extra Unit on Incident",

        "ID:201300045103",
        "CALL:FIRE-GRASS / WILDFIRE",
        "ADDR:400 E SOUTHGATE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/05/2013",
        "TIME:17:17:10",
        "SRC:ENID FIRE DE",
        "INFO:Location: 3128 S VAN BUREN - SE SECTOR\ngrass fire between leona mitchell and van buren");

    doTest("T25",
        "(Call) Incident No.: 201300044974 Category: MEDICAL / MEDICAL EMERGENCY\n" +
        "Address: 2026 S IMO RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/05/2013 09:10:13 / \n" +
        "Dispatch DateTime: 07/05/2013 09:11:46\n" +
        "Enroute DateTime: 07/05/2013 09:12:37\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: 911, lahoma fire, medical @ 2026 s imo, rp @ 2345203, confirm on tri county a\n\n" +
        "Call Received on 07/05/2013 @ 09:09\n\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/05/2013 09:10:46 /  /  / 3664 / SENDINC / Incident Open by sending Work Area\n" +
        "07/05/2013 09:11:46 / M5 /  / 3664 / SENDZETR / ZETRON Command 'Unit State Control' / State Code 'Alert On' was sent.\n" +
        "07/05/2013 09:11:46 / M5 /  / 3664 / 21 / Dispatched on Incident\n" +
        "07/05/2013 09:11:46 /  /  / 3664 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S5\n" +
        "07/05/2013 09:11:48 / E5 /  / 3664 / 21 / Extra Unit on Incident\n" +
        "07/05/2013 09:12:37 / E5 /  / 3664 / 23 / Enroute on Incident\n" +
        "07/05/2013 09:12:38 / M5 /  / 3664 / 23 / Enroute on Incident\n" +
        "07/05/2013 09:13:37 / LAHMFD /  / 3664 / 21 / Extra Unit on Incident",

        "ID:201300044974",
        "CALL:MEDICAL / MEDICAL EMERGENCY",
        "ADDR:2026 S IMO RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/05/2013",
        "TIME:09:11:46",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:911, lahoma fire, medical @ 2026 s imo, rp @ 2345203, confirm on tri county a");

    doTest("T26",
        "(Call) Incident No.: 201300044886 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\n" +
        "Address: 16219 W HWY 412 GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/05/2013 00:01:55 / \n" +
        "Dispatch DateTime: 07/05/2013 00:03:35\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: LAHOMA FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: T-MOBILE USA INC.\n\n" +
        "Incident Notes: Call Received on 07/05/2013 @ 00:01\n" +
        "Location: 14723 W HWY 412 - SECTOR S  in lahoma. \n" +
        "rp states that there is a grass fire near her house.\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/05/2013 00:02:37 /  /  / 2902 / SENDINC / Incident Open by sending Work Area\n" +
        "07/05/2013 00:02:37 /  /  / 2902 / PAGER / StartSession. Process PAGE 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130101@mail.page-plus.net\n" +
        "220 SNPP Gateway Ready\n\n" +
        "07/05/2013 00:03:35 / LAHMFD /  / 3768 / 21 / Dispatched on Incident",

        "ID:201300044886",
        "CALL:RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES",
        "ADDR:16219 W HWY 412",
        "MADDR:16219 W US 412",
        "CITY:GARFIELD COUNTY",
        "DATE:07/05/2013",
        "TIME:00:03:35",
        "SRC:LAHOMA FIRE DEPARTMENT",
        "INFO:Location: 14723 W HWY 412 - SECTOR S  in lahoma.\nrp states that there is a grass fire near her house.");

    doTest("T27",
        "(Call) Incident No.: 201300044874 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 5800 S IMO RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/04/2013 23:33:46 / \n" +
        "Dispatch DateTime: 07/04/2013 23:35:19\n" +
        "Enroute DateTime: 07/04/2013 23:35:19\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: DRUMMOND FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: US CELLULAR\n\n" +
        "Incident Notes: Call Received on 07/04/2013 @ 23:32\n" +
        "Location: 4002 W WILLOW RD.... IMO AND GARRIOT.. GRASS FIRE 3 OR 4 MILES SOUTH ON IMO FROM GARRIOTT\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/04/2013 23:34:18 /  /  / 3768 / SENDINC / Incident Open by sending Work Area\n" +
        "07/04/2013 23:35:19 / E5 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:35:29 / E5 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:35:55 / DRUMFD /  / 3768 / 23 / Enroute on Incident",

        "ID:201300044874",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:5800 S IMO RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/04/2013",
        "TIME:23:35:19",
        "SRC:DRUMMOND FIRE DEPARTMENT",
        "INFO:Location: 4002 W WILLOW RD.... IMO AND GARRIOT.. GRASS FIRE 3 OR 4 MILES SOUTH ON IMO FROM GARRIOTT");

    doTest("T28",
        "(Call) Incident No.: 201300044871 Category: RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY\n" +
        "Address: 3000 E HAYWARD RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/04/2013 23:27:30 / \n" +
        "Dispatch DateTime: 07/04/2013 23:29:45\n" +
        "Police: GARFIELD COUNTY SHERIFF OFFICE Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \n\n" +
        "Incident Notes: rp states a field is on fire\n" +
        "PAGE SENT\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/04/2013 23:28:04 /  /  / 4005 / SENDINC / Incident Open by sending Work Area\n" +
        "07/04/2013 23:28:34 /  /  / 4005 / INCCHNG / LastName/FirstName/Phone Changed from //(580) ___-____ to WILLIAMS/BILLIE/(580) 541-0908\n" +
        "07/04/2013 23:29:17 /  /  / 3768 / INCCHNG / Notes Added: \n" +
        " PAGE SENT\n" +
        "07/04/2013 23:29:46 / WAUKFD /  / 3768 / 21 / Dispatched on Incident",

        "ID:201300044871",
        "CALL:RURAL-FIRE-WILDLAND / WILDLAND FIRE IN COUNTY",
        "ADDR:3000 E HAYWARD RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/04/2013",
        "TIME:23:29:45",
        "SRC:PIONEER FIRE DEPARTMENT",
        "INFO:rp states a field is on fire\nPAGE SENT");

    doTest("T29",
        "(Call) Incident No.: 201300044865 Category: RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES\n" +
        "Address: 4318 E SOUTHGATE RD GARFIELD COUNTY\n" +
        "Open DateTime / DSN: 07/04/2013 23:11:04 / \n" +
        "Dispatch DateTime: 07/04/2013 23:15:57\n" +
        "Enroute DateTime: 07/04/2013 23:15:57\n" +
        "Police: GARFIED COUNTY SHERIFFS DEPARTMENT Fire: PIONEER FIRE DEPARTMENT EMS: LIFE EMS \n" +
        "Business Name: AT&T MOBILITY\n\n" +
        "Incident Notes: Call Received on 07/04/2013 @ 23:10\n" +
        "Location: 220 W WOOD  RD - N SECTOR\n\n" +
        "rp states a field is on fire. rp states that its about a quarter of a mile from a house.\n" +
        "rp states its across the street from this res\n\n\n" +
        "Log Date Time / Unit / DSN / Status / Log Notes \n" +
        "07/04/2013 23:11:48 /  /  / 4005 / SENDINC / Incident Open by sending Work Area\n" +
        "07/04/2013 23:11:48 /  /  / 4005 / PAGER / StartSession. Welcome 220.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130101@mail.page-plus.net\n" +
        "250 Pager ID Accepted\n\n" +
        "07/04/2013 23:12:02 /  /  / 4005 / INCCHNG / LastName/FirstName Changed from / to STIERS/SAMI\n" +
        "07/04/2013 23:12:21 /  /  / 4005 / INCCHNG / Notes Added: \n" +
        " rp states its across the street from this res\n" +
        "07/04/2013 23:15:58 / E5 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:16:04 / R1 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:16:04 /  /  / 3888 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S1\n" +
        "07/04/2013 23:16:09 / GR4 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:16:09 /  /  / 3888 / PRINT / Sent print report to: \n" +
        "\\\\epd01\\RNR_S4\n" +
        "07/04/2013 23:16:38 / PIONFD /  / 3768 / 21 / Extra Unit on Incident\n" +
        "07/04/2013 23:16:39 /  /  / 3768 / PAGER / SendPageData. Process SEND 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130094@mail.page-plus.net\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n\n" +
        "07/04/2013 23:17:17 / FAIRFD /  / 3768 / 21 / Extra Unit on Incident\n" +
        "07/04/2013 23:17:19 /  /  / 3768 / PAGER / SendPageData. Process SEND 250.\n" +
        "Sent Pager report to: \n" +
        "mail.page-plus.net/5802130092@mail.page-plus.net\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n" +
        "550 Invalid Command\n\n" +
        "07/04/2013 23:17:24 / PIONFD /  / 3768 / 8 / Clear From Incident\n" +
        "07/04/2013 23:17:25 / E4 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:17:48 / FAIRFD /  / 3768 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:18:08 / C4 /  / 3888 / 23 / Enroute on Incident\n" +
        "07/04/2013 23:18:16 / WAUKFD /  / 3768 / 21 / Extra Unit on Incident",

        "ID:201300044865",
        "CALL:RURAL-FIRE-NEAR STRUCT** / WILDFIRE NEAR STRUCTURES",
        "ADDR:4318 E SOUTHGATE RD",
        "CITY:GARFIELD COUNTY",
        "DATE:07/04/2013",
        "TIME:23:15:57",
        "SRC:PIONEER FIRE DEPARTMENT",
        "INFO:Location: 220 W WOOD  RD - N SECTOR\nrp states a field is on fire. rp states that its about a quarter of a mile from a house.\nrp states its across the street from this res");
 
  }


  public static void main(String[] args) {
    new OKGarfieldCountyParserTest().generateTests("T1");
  }
}