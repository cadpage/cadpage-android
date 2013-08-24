package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Ocean County, NJ
Contact: Active911
Agency name: Bayville Fire Company Location: Bayville, NJ 
Sender: Fire_Records  

(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~33~WOODLAND~RD~\nCommon Name:~ST BARNABAS CHURCH - BERKELEY @ WOODLAND/CHAIN\nVenue:~Berkeley Township\nCross Streets~\nSYLVAN LAKE BLVD / CHAIN BLVD\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~91096\nCall Type:~ Fire Information\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/12/2012 12:56:40\nDispatch Date/Time:~07/12/2012 12:59:49\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nST17D~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~445~RT~9~\nCommon Name:~SHOPRITE - BERKELEY\nVenue:~Berkeley Township\nCross Streets~\nFREDERICK DR / KORMAN RD\n OCEAN GATE DR\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~91184\nCall Type:~ Landing Zone\nSource:~Telephone\nPriority:~ Low\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/12/2012 14:24:12\nDispatch Date/Time:~07/12/2012 14:24:46\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~07/12/2012 14:34:16\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000186~~Bayville Fire Department\n2012-00008054~~Paid ALS\n~\nUnits Sent:~2\nMONOC1, F1700~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~33~KORMAN~RD~APT A12\nVenue:~Berkeley Township\nCross Streets~\nESPLANADE WAY / RT 9\n OCEAN GATE DR\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~91504\nCall Type:~ CO Alarm\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/12/2012 18:56:54\nDispatch Date/Time:~07/12/2012 18:58:36\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000187~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/12/12 18:58:15~Nature Of Call: NO ONE FEELING ILL WAITING OUTSIDE
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~445~RT~9~\nCommon Name:~SHOPRITE - BERKELEY\nVenue:~Berkeley Township\nCross Streets~\nFREDERICK DR / KORMAN RD\n OCEAN GATE DR\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~92248\nCall Type:~ Vehicle Fire\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/13/2012 14:20:45\nDispatch Date/Time:~07/13/2012 14:21:47\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00001602~~Bayville EMS\n2012-00000188~~Bayville Fire Department\n~\nUnits Sent:~2\nST17, SQ13~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~343~ARLINGTON~AVE~\nVenue:~Berkeley Township\nCross Streets~\nMARYLAND AVE / DEAD END\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~92497\nCall Type:~ Gas Leak\nSource:~Telephone\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/13/2012 17:16:32\nDispatch Date/Time:~07/13/2012 17:17:43\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000189~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~445~RT~9~\nCommon Name:~SHOPRITE - BERKELEY\nVenue:~Berkeley Township\nCross Streets~\nFREDERICK DR / KORMAN RD\n OCEAN GATE DR\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~92561\nCall Type:~ Landing Zone\nSource:~Telephone\nPriority:~ Low\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/13/2012 18:14:03\nDispatch Date/Time:~07/13/2012 18:14:36\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000190~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~316~BAY~BLVD~\nVenue:~Berkeley Township\nCross Streets~\nCROW AVE / ROBIN AVE\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~92833\nCall Type:~ General Weakness\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/13/2012 23:16:54\nDispatch Date/Time:~07/13/2012 23:18:20\nArrive Date/Time:~07/13/2012 23:30:08\nClear Date/Time:~\nEnroute Date/Time:~07/13/2012 23:26:31\nLatest Unit Cleared Date/Time:~07/13/2012 23:26:34\n~\nIncident Number(s)\n2012-00001605~~Bayville EMS\n2012-00000191~~Bayville Fire Department\n~\nUnits Sent:~3\nST17, SQ13, E136~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/13/12 23:17:53~Nature Of Call: 42YOF\n07/13/12 23:18:02~CELULITIS IN BOTH LEGS\n07/13/12 23:24:15~conf crew
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~255~CHELSEA~AVE~\nVenue:~Berkeley Township\nCross Streets~\nCEDARCREST DR / BERKELEY PL\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~93543\nCall Type:~ CO Alarm\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/14/2012 16:55:39\nDispatch Date/Time:~07/14/2012 16:56:19\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000192~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/14/12 16:56:05~Nature Of Call: CO ALM, EVERYONE GETTING OUT
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~492~EASTERN~BLVD~\nVenue:~Berkeley Township\nCross Streets~\nLATIMER AVE / NOLAN AVE\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94287\nCall Type:~ Animal Call\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 11:04:44\nDispatch Date/Time:~07/15/2012 11:09:44\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/15/12 11:08:59~Nature Of Call: KITTEN IN TREE / PD REQ FD RESPONE.\n07/15/12 11:09:13~CALLED IN BY BERK PD
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~136~CEDAR RUN~RD~\nVenue:~Berkeley Township\nCross Streets~\nDEAD END / SAND RD\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94427\nCall Type:~ Fire Alarm\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 13:34:22\nDispatch Date/Time:~07/15/2012 13:35:37\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000193~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/15/12 13:35:22~Nature Of Call: vacant house  third party nothing showing
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~570~EGENOLF~PL~\nVenue:~Berkeley Township\nCross Streets~\nNo Cross Streets Found\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94774\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 19:46:28\nDispatch Date/Time:~07/15/2012 19:47:46\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000194~~Bayville Fire Department\n2012-00001156~~NJ Forest Fire Service\n~\nUnits Sent:~2\nST17, B7~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~50~GOOD LUCK~DR~\nVenue:~Berkeley Township\nCross Streets~\nBEACH AVE / DORRANCE DR\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94807\nCall Type:~ Structure Fire\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 20:26:59\nDispatch Date/Time:~07/15/2012 20:27:43\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00001618~~Bayville EMS\n2012-00000195~~Bayville Fire Department\n~\nUnits Sent:~2\nST17, SQ13~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/15/12 20:27:28~Nature Of Call: SMOKE COMING OUT OF HOUSE UNK IF ANYONE IS HOME
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~395~LAKESIDE~BLVD~\nCommon Name:~Crystal Lake Convalescent Center - Berkeley\nVenue:~Berkeley Township\nCross Streets~\nHAYDEN ST / MONTGOMERY ST\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94871\nCall Type:~ Fire Alarm\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 21:23:09\nDispatch Date/Time:~07/15/2012 21:24:10\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000196~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/15/12 21:23:59~Nature Of Call: OPER 3684\n07/15/12 21:24:05~Nature Of Call: OPER 3684
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~386~VIRGINIA~AVE~\nVenue:~Berkeley Township\nCross Streets~\nHOOVER AVE / WESTERN BLVD\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~94963\nCall Type:~ Pole Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/15/2012 22:57:26\nDispatch Date/Time:~07/15/2012 22:58:35\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000197~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~18~BUTLER~BLVD~\nCommon Name:~Tallwoods Care Center - Berkeley @ Butler Blvd\nVenue:~Berkeley Township\nCross Streets~\nLAUREL LN / RT 9\n CENTRAL PKWY\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~96448\nCall Type:~ Fire Information\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/17/2012 12:22:04\nDispatch Date/Time:~07/17/2012 12:23:19\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nST17C~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/17/12 12:22:32~Nature Of Call: WORKING ON FIRE SYSTEM\n07/17/12 12:23:05~WILL CALL BACK WHEN DONE
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~120~PATTON~AVE~\nVenue:~Berkeley Township\nCross Streets~\nMIDLAND AVE / DEAD END\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~96592\nCall Type:~ CO Alarm\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/17/2012 14:34:14\nDispatch Date/Time:~07/17/2012 14:35:01\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000198~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~11~VINE~ST~\nVenue:~Berkeley Township\nCross Streets~\nMARICIEL AVE / CENTRAL PKWY\nQuadrant:~ST17\nDistrict:~SQ13\n~\nCall Information:\n\nCall Number:~97427\nCall Type:~ Odor Investigation\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~07/18/2012 11:00:14\nDispatch Date/Time:~07/18/2012 11:00:57\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2012-00000199~~Bayville Fire Department\n~\nUnits Sent:~1\nST17~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n07/18/12 11:00:43~Nature Of Call: strong smell of smoke

Contact: Active911
Agency name: South Toms River Volunteer First Aid Rescue Squad Location: South Toms River, NJ 
Sender: messaging@iamresponding.com
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~401~DOVER~RD~\n\nCommon Name:~SQ37\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nTILTON AVE / YANNETTE RD\n\n AMHERST RD\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~129474\n\nCall Type:~ EMS Information\n\nSource:~Telephone\n\nPriority:~ Administrative\n\nStatus:~Not In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 09:10:09\n\nDispatch Date/Time:~08/17/2012 09:11:03\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n~\n\nUnits Sent:~1\n\nSQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n08/17/12 09:10:44~asst capt of squad\n\n08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~401~DOVER~RD~\n\nCommon Name:~SQ37\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nTILTON AVE / YANNETTE RD\n\n AMHERST RD\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~129474\n\nCall Type:~ EMS Information\n\nSource:~Telephone\n\nPriority:~ Administrative\n\nStatus:~Not In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 09:10:09\n\nDispatch Date/Time:~08/17/2012 09:11:03\n\nArrive Date/Time:~\n\nClear Date/Time:~08/17/2012 09:12:35\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~08/17/2012 09:12:35\n\n~\n\nIncident Number(s)\n\n~\n\nUnits Sent:~1\n\nSQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n08/17/12 09:10:44~asst capt of squad\n\n08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~130~2ND~AVE~\n\nVenue:~Berkeley Township\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~129743\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 13:26:56\n\nDispatch Date/Time:~08/17/2012 13:30:11\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00010722~~Paid ALS\n\n2012-00001281~~South Toms River EMS\n\n~\n\nUnits Sent:~2\n\nSQ75, SQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n08/17/12 13:30:25~sarah
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~130~2ND~AVE~\n\nVenue:~Berkeley Township\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~129743\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 13:26:56\n\nDispatch Date/Time:~08/17/2012 13:30:11\n\nArrive Date/Time:~08/17/2012 13:50:57\n\nClear Date/Time:~08/17/2012 14:21:51\n\nEnroute Date/Time:~08/17/2012 13:33:35\n\nLatest Unit Cleared Date/Time:~08/17/2012 14:21:50\n\n~\n\nIncident Number(s)\n\n2012-00010722~~Paid ALS\n\n2012-00001281~~South Toms River EMS\n\n~\n\nUnits Sent:~4\n\nE712, SQ75, E378, SQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n08/17/12 13:30:25~sarah
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~130~2ND~AVE~\n\nVenue:~Berkeley Township\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130085\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 18:32:23\n\nDispatch Date/Time:~08/17/2012 18:33:14\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00010739~~Paid ALS\n\n2012-00001282~~South Toms River EMS\n\n~\n\nUnits Sent:~2\n\nSQ75, SQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 18:32:38~Nature Of Call: 19 MOS YOM
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~130~2ND~AVE~\n\nVenue:~Berkeley Township\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130085\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/17/2012 18:32:23\n\nDispatch Date/Time:~08/17/2012 18:33:14\n\nArrive Date/Time:~08/17/2012 18:44:04\n\nClear Date/Time:~08/17/2012 19:24:43\n\nEnroute Date/Time:~08/17/2012 18:42:02\n\nLatest Unit Cleared Date/Time:~08/17/2012 19:24:37\n\n~\n\nIncident Number(s)\n\n2012-00010739~~Paid ALS\n\n2012-00001282~~South Toms River EMS\n\n~\n\nUnits Sent:~4\n\nE712, SQ75, E378, SQ37~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/17/12 18:32:38~Nature Of Call: 19 MOS YOM\n\n08/17/12 18:34:09~natalie\n\n08/17/12 18:34:57~crosses 5th &amp; 8th st\n\n08/17/12 18:36:34~370 conf crew resp to bldg\n\n08/17/12 18:36:44~CHILD OUT OF THE SEIZURE JUST CAME HOME FROM THE HOSPITAL FOR THE SAME THING\n\n08/17/12 18:36:47~HAS A FEVER\n\n08/17/12 18:48:00~712 on loc per mon control
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~1~DREW~LN~\n\nCommon Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nATTISON AVE / DEAD END\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130645\n\nCall Type:~ Special Response\n\nSource:~Air\n\nPriority:~ Medium\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/18/2012 09:47:53\n\nDispatch Date/Time:~08/18/2012 09:49:23\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00001283~~South Toms River EMS\n\n~\n\nUnits Sent:~1\n\nE370~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/18/12 09:49:12~Nature Of Call: special assignment
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~~FAIRWAY~DR/~DOVER~RD\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130769\n\nCall Type:~ Suicide Attempt\n\nSource:~911\n\nPriority:~ Medium\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/18/2012 12:25:30\n\nDispatch Date/Time:~08/18/2012 12:28:09\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00002735~~South Toms River Police Department\n\n~\n\nUnits Sent:~2\n\nSQ37, 29-06~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n08/18/12 12:27:45~slurring his words\n\n08/18/12 12:28:11~unk how long ago he took them or what they are\n\n08/18/12 12:28:14~third party
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~100~FAIRWAY~DR~\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nDOVER RD / DOUBLE TROUBLE RD\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130769\n\nCall Type:~ Suicide Attempt\n\nSource:~911\n\nPriority:~ Medium\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/18/2012 12:25:30\n\nDispatch Date/Time:~08/18/2012 12:28:09\n\nArrive Date/Time:~08/18/2012 12:28:49\n\nClear Date/Time:~08/18/2012 13:38:50\n\nEnroute Date/Time:~08/18/2012 12:30:21\n\nLatest Unit Cleared Date/Time:~08/18/2012 13:38:50\n\n~\n\nIncident Number(s)\n\n2012-00010795~~Paid ALS\n\n2012-00001284~~South Toms River EMS\n\n2012-00002735~~South Toms River Police Department\n\n~\n\nUnits Sent:~7\n\nE712, SQ75, E378, E370, SQ37, 29-17, 29-06~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n08/18/12 12:27:45~slurring his words\n\n08/18/12 12:28:11~unk how long ago he took them or what they are\n\n08/18/12 12:28:14~third party\n\n08/18/12 12:29:01~she stated he was at his residence\n\n08/18/12 12:29:33~POSS 101\n\n08/18/12 12:30:00~VIC MONOC\n\n08/18/12 12:30:51~DOGS IN RESD UNK IF FRIENDLY OR NOT\n\n08/18/12 12:32:00~subj concious and alert\n\n08/18/12 12:32:21~BRIAN IS A FRIEND WHO LIVES UP THE STREET AND CINDY CALLED HIM AND IS ON HIS WAY TO RESD
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~1~DREW~LN~\n\nCommon Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\nVenue:~South Toms River Boro\n\nCross Streets~\n\nATTISON AVE / DEAD END\n\nQuadrant:~ST18/SQ37\n\nDistrict:~SQ37\n\n~\n\nCall Information:\n\n\n\nCall Number:~130645\n\nCall Type:~ Special Response\n\nSource:~Air\n\nPriority:~ Medium\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/18/2012 09:47:53\n\nDispatch Date/Time:~08/18/2012 09:49:23\n\nArrive Date/Time:~\n\nClear Date/Time:~08/18/2012 16:08:32\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~08/18/2012 16:08:32\n\n~\n\nIncident Number(s)\n\n2012-00001283~~South Toms River EMS\n\n~\n\nUnits Sent:~4\n\nE379, E378, E377, E370~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/18/12 09:49:12~Nature Of Call: special assignment
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~721~MIDLAND~AVE~\n\nCommon Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\nVenue:~Pine Beach Boro\n\nCross Streets~\n\nLINDEN AVE / PENNSYLVANIA AVE\n\nQuadrant:~ST38\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131775\n\nCall Type:~ EMS Call\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 10:28:48\n\nDispatch Date/Time:~08/19/2012 10:30:14\n\nArrive Date/Time:~\n\nClear Date/Time:~\n\nEnroute Date/Time:~\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00001562~~Beachwood EMS\n\n2012-00002188~~Pine Beach Police Department\n\n2012-00001285~~South Toms River EMS\n\n~\n\nUnits Sent:~3\n\nSQ37, SQ15, PNBCPD~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n08/19/12 10:30:46~22-08 NOTFD\n\n08/19/12 10:35:42~2ND REQUEST SQ37 STARTED
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~95~ATLANTIC CITY~BLVD~\n\nCommon Name:~RITE AID - BEACHWOOD\n\nVenue:~Beachwood Boro\n\nCross Streets~\n\nENSIGN AVE / STARBOARD ST\n\nQuadrant:~ST16\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131816\n\nCall Type:~ Pedestrian Struck\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 10:55:20\n\nDispatch Date/Time:~08/19/2012 10:56:58\n\nArrive Date/Time:~08/19/2012 10:59:41\n\nClear Date/Time:~\n\nEnroute Date/Time:~08/19/2012 10:57:36\n\nLatest Unit Cleared Date/Time:~\n\n~\n\nIncident Number(s)\n\n2012-00001563~~Beachwood EMS\n\n2012-00004629~~Beachwood Police Department\n\n2012-00001286~~South Toms River EMS\n\n~\n\nUnits Sent:~4\n\n4-54, SQ37, SQ15, 4-56~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n08/19/12 10:57:38~PKING LOT OF RITE AID NOW
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~95~ATLANTIC CITY~BLVD~\n\nCommon Name:~RITE AID - BEACHWOOD\n\nVenue:~Beachwood Boro\n\nCross Streets~\n\nENSIGN AVE / STARBOARD ST\n\nQuadrant:~ST16\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131816\n\nCall Type:~ Pedestrian Struck\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 10:55:20\n\nDispatch Date/Time:~08/19/2012 10:56:58\n\nArrive Date/Time:~08/19/2012 10:59:41\n\nClear Date/Time:~08/19/2012 11:08:08\n\nEnroute Date/Time:~08/19/2012 10:57:36\n\nLatest Unit Cleared Date/Time:~08/19/2012 11:08:08\n\n~\n\nIncident Number(s)\n\n2012-00001563~~Beachwood EMS\n\n2012-00004629~~Beachwood Police Department\n\n2012-00001286~~South Toms River EMS\n\n~\n\nUnits Sent:~4\n\n4-54, SQ37, SQ15, 4-56~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n08/19/12 10:57:38~PKING LOT OF RITE AID NOW\n\n08/19/12 11:03:18~15 2ND REQUESTING FOR DRIVER AND START MUTUAL AID\n\n08/19/12 11:07:17~NO INJ PER PD CANCLE THE RIG
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~214~BEACHWOOD~BLVD~\n\nVenue:~Beachwood Boro\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST16\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131830\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 11:08:07\n\nDispatch Date/Time:~08/19/2012 11:09:39\n\nArrive Date/Time:~08/19/2012 11:10:56\n\nClear Date/Time:~\n\nEnroute Date/Time:~08/19/2012 11:09:51\n\nLatest Unit Cleared Date/Time:~08/19/2012 11:10:27\n\n~\n\nIncident Number(s)\n\n2012-00001564~~Beachwood EMS\n\n2012-00004631~~Beachwood Police Department\n\n2012-00010861~~Paid ALS\n\n2012-00001287~~South Toms River EMS\n\n~\n\nUnits Sent:~5\n\nE712, SQ75, SQ37, SQ15, 4-56~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n08/19/12 11:09:54~MONOC-JOHN
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~721~MIDLAND~AVE~\n\nCommon Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\nVenue:~Pine Beach Boro\n\nCross Streets~\n\nLINDEN AVE / PENNSYLVANIA AVE\n\nQuadrant:~ST38\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131775\n\nCall Type:~ EMS Call\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 10:28:48\n\nDispatch Date/Time:~08/19/2012 10:30:14\n\nArrive Date/Time:~08/19/2012 10:42:55\n\nClear Date/Time:~08/19/2012 12:00:55\n\nEnroute Date/Time:~08/19/2012 10:38:13\n\nLatest Unit Cleared Date/Time:~08/19/2012 12:00:55\n\n~\n\nIncident Number(s)\n\n2012-00001562~~Beachwood EMS\n\n2012-00001227~~Ocean Gate EMS\n\n2012-00002188~~Pine Beach Police Department\n\n2012-00001285~~South Toms River EMS\n\n~\n\nUnits Sent:~6\n\n22-08, SQ37, SQ31, SQ15, E158, PNBCPD~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n08/19/12 10:30:46~22-08 NOTFD\n\n08/19/12 10:35:42~2ND REQUEST SQ37 STARTED\n\n08/19/12 10:41:24~NO ANSWER FROM 15 OR 37 .37 2ND STARTED 31\n\n08/19/12 10:42:48~SQ15 NEEDS A DRIVER OR EMT NEED\n\n08/19/12 10:44:59~SQ37 DRIVER HEADING TO BUILDING PER 370\n\n08/19/12 10:45:08~SQ31 TOLD TO STAND DOWN
(STRFAS) Rip and Run Report\n\n\n\n~\n\nLocation Information:\n\n\n\nLocation:~214~BEACHWOOD~BLVD~\n\nVenue:~Beachwood Boro\n\nCross Streets~\n\nNo Cross Streets Found\n\nQuadrant:~ST16\n\nDistrict:~SQ15\n\n~\n\nCall Information:\n\n\n\nCall Number:~131830\n\nCall Type:~ Seizures\n\nSource:~911\n\nPriority:~ High\n\nStatus:~In Progress\n\nCaller:~\n\nCall Date/Time:~08/19/2012 11:08:07\n\nDispatch Date/Time:~08/19/2012 11:09:39\n\nArrive Date/Time:~08/19/2012 11:10:56\n\nClear Date/Time:~08/19/2012 12:21:50\n\nEnroute Date/Time:~08/19/2012 11:09:51\n\nLatest Unit Cleared Date/Time:~08/19/2012 12:21:49\n\n~\n\nIncident Number(s)\n\n2012-00001564~~Beachwood EMS\n\n2012-00004631~~Beachwood Police Department\n\n2012-00010861~~Paid ALS\n\n2012-00001287~~South Toms River EMS\n\n~\n\nUnits Sent:~7\n\n4-54, E712, SQ75, E378, SQ37, SQ15, 4-56~\n\n\n\nAlerts:\n\n~\n\nLocation Alerts\n\n\n\nPerson Alerts\n\n\n\nVehicle Alerts\n\n~~\n\nNarrative:\n\n\n\nNarrative Time~Narrative\n\n08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n08/19/12 11:09:54~MONOC-JOHN\n\n08/19/12 11:12:00~2nd req\n\n08/19/12 11:13:14~USE SIDE ENTRANCE

Contact: Active911
Agency name: Lanoka harbor EMS
Location: Lanoka Harbor, NJ, United States

(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~244~N~MAIN~ST~\r\nCommon Name:~HOME DEPOT - LACEY\r\nVenue:~Lacey Township\r\nCross Streets~\r\nSUNRISE BLVD / NAUTILUS DR\r\nQuadrant:~ST60\r\nDistrict:~SQ23\r\n~\r\nCall Information:\r\n\r\nCall Number:~175220\r\nCall Type:~ EMS Call\r\nSource:~Telephone\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 16:48:42\r\nDispatch Date/Time:~10/03/2012 16:49:17\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~10/03/2012 16:51:08\r\n~\r\nIncident Number(s)\r\n2012-00002186~~Lacey Twp EMS\r\n2012-00001479~~Lanoka Harbor EMS\r\n2012-00014110~~Paid ALS\r\n~\r\nUnits Sent:~4\r\nE712, SQ75, SQ26, SQ23~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 16:48:58~Nature Of Call: male passed out on grass\r\n10/03/12 16:50:41~left hand side entrance\r\n10/03/12 16:50:44~on grass\r\n10/03/12 16:49:55~Call #: 175223 - Nature Of Call: male on grount\r\n10/03/12 16:50:39~Call #: 175223 - Nature Of Call: male on ground is breathing pe caller pd on scene\r\n10/03/12 16:55:24~PER SQ23 EMT NEEDED\r\n10/03/12 16:55:53~SQ26 DSIPOATCHED\r\n10/03/12 16:56:29~PER LACY PD SUBJ ALERT AND CONSC\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~25~WARREN~AVE~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nRAILROAD AVE\r\n SOUTH ST\r\n CEDAR AVE / CAROLYN CT\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~175090\r\nCall Type:~ Unconsious\r\nSource:~911\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 14:27:22\r\nDispatch Date/Time:~10/03/2012 14:28:07\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00001478~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~1\r\nSQ26~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 14:27:45~Nature Of Call: 69YOF\r\n10/03/12 14:27:53~Nature Of Call: 69YOF  IS BREATHING\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~408~N~MAIN~ST~\r\nCommon Name:~MCDONALDS - LACEY\r\nVenue:~Lacey Township\r\nCross Streets~\r\nFIRST ST\r\n MUSKET DR / MURRAY GROVE RD\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~174972\r\nCall Type:~ Bee Sting\r\nSource:~Telephone\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 12:02:42\r\nDispatch Date/Time:~10/03/2012 12:04:09\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00001477~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~1\r\nSQ26~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 12:03:18~Nature Of Call: 19 yom\r\n10/03/12 12:03:25~Nature Of Call: 19 yom\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~544~BRENTWOOD~RD~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nVAN DYKE AVE / VAN DYKE AVE\r\nQuadrant:~ST60\r\nDistrict:~SQ23\r\n~\r\nCall Information:\r\n\r\nCall Number:~174921\r\nCall Type:~ Diabetic\r\nSource:~911\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 10:52:52\r\nDispatch Date/Time:~10/03/2012 10:54:35\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00002185~~Lacey Twp EMS\r\n2012-00001476~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~2\r\nSQ26, SQ23~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 10:53:23~Nature Of Call: 74 yof swollen feet\r\n10/03/12 11:01:08~2ND REQ SQ26\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~708~CAMBRIDGE~RD~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nWELLESLEY RD / AMHERST RD\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~174713\r\nCall Type:~ Fall Victim\r\nSource:~Telephone\r\nPriority:~ Medium\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 00:55:19\r\nDispatch Date/Time:~10/03/2012 00:59:46\r\nArrive Date/Time:~10/03/2012 01:10:09\r\nClear Date/Time:~10/03/2012 02:03:09\r\nEnroute Date/Time:~10/03/2012 01:07:18\r\nLatest Unit Cleared Date/Time:~10/03/2012 02:03:03\r\n~\r\nIncident Number(s)\r\n2012-00001475~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~2\r\nSQ26, E267~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 00:56:15~Nature Of Call: neck pain\r\n10/03/12 01:03:15~conf crew\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~708~CAMBRIDGE~RD~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nWELLESLEY RD / AMHERST RD\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~174713\r\nCall Type:~ Fall Victim\r\nSource:~Telephone\r\nPriority:~ Medium\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 00:55:19\r\nDispatch Date/Time:~10/03/2012 00:59:46\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00001475~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~1\r\nSQ26~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/03/12 00:56:15~Nature Of Call: neck pain\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~708~CAMBRIDGE~RD~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nWELLESLEY RD / AMHERST RD\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~174713\r\nCall Type:~ Fall Victim\r\nSource:~Telephone\r\nPriority:~ Medium\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/03/2012 00:55:19\r\nDispatch Date/Time:~10/03/2012 00:55:39\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00001475~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~1\r\nSQ26~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~99~SHEFFIELD~DR~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nNo Cross Streets Found\r\nQuadrant:~ST60\r\nDistrict:~SQ23\r\n~\r\nCall Information:\r\n\r\nCall Number:~174582\r\nCall Type:~ Fall Victim\r\nSource:~Telephone\r\nPriority:~ Medium\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/02/2012 19:48:18\r\nDispatch Date/Time:~10/02/2012 19:55:22\r\nArrive Date/Time:~10/02/2012 20:09:49\r\nClear Date/Time:~10/02/2012 21:36:03\r\nEnroute Date/Time:~10/02/2012 19:58:37\r\nLatest Unit Cleared Date/Time:~10/02/2012 21:36:01\r\n~\r\nIncident Number(s)\r\n2012-00002181~~Lacey Twp EMS\r\n2012-00001474~~Lanoka Harbor EMS\r\n2012-00001366~~Waretown EMS\r\n~\r\nUnits Sent:~5\r\nSQ42, E427, SQ26, E235, SQ23~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/02/12 19:48:34~Nature Of Call: 56 yom leg inj\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~1208~BULLARD~AVE~\r\nVenue:~Lacey Township\r\nCross Streets~\r\nOLDS ST / S LAKESIDE DR\r\nQuadrant:~ST60\r\nDistrict:~SQ23\r\n~\r\nCall Information:\r\n\r\nCall Number:~174558\r\nCall Type:~ Seizures\r\nSource:~911\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/02/2012 19:15:50\r\nDispatch Date/Time:~10/02/2012 19:16:49\r\nArrive Date/Time:~10/02/2012 19:36:45\r\nClear Date/Time:~10/02/2012 20:52:49\r\nEnroute Date/Time:~10/02/2012 19:29:29\r\nLatest Unit Cleared Date/Time:~10/02/2012 20:52:45\r\n~\r\nIncident Number(s)\r\n2012-00001003~~Dover-Brick Beach First Aid\r\n2012-00002180~~Lacey Twp EMS\r\n2012-00001472~~Lanoka Harbor EMS\r\n2012-00014047~~Paid ALS\r\n~\r\nUnits Sent:~7\r\nE172, E712, SQ75, SQ26, E267, E265, SQ23~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/02/12 19:16:19~Nature Of Call: 47 yom\r\n10/02/12 19:26:59~3rd req and sq26\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~305~MANCHESTER~AVE~\r\nCommon Name:~SQ26\r\nVenue:~Lacey Township\r\nCross Streets~\r\nQUAIL HILL DR / LAKE BARNEGAT DR\r\nQuadrant:~ST61\r\nDistrict:~SQ26\r\n~\r\nCall Information:\r\n\r\nCall Number:~174575\r\nCall Type:~ EMS Call\r\nSource:~Telephone\r\nPriority:~ High\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~10/02/2012 19:39:34\r\nDispatch Date/Time:~10/02/2012 19:39:48\r\nArrive Date/Time:~10/02/2012 19:39:57\r\nClear Date/Time:~10/02/2012 20:23:34\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~10/02/2012 20:23:31\r\n~\r\nIncident Number(s)\r\n2012-00001473~~Lanoka Harbor EMS\r\n~\r\nUnits Sent:~1\r\nE269~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n\r\n

Contact: Active911
Agency name: Lacey Twp Underwater Rescue  Recovery Team
Location: Ianoka Harbor, NJ, United States
Sender: EMS_Records

(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~1032~ORLANDO~DR~\nVenue:~Lacey Township\nCross Streets~\nCLUBHOUSE DR / ALBATROSS CT\nQuadrant:~ST60\nDistrict:~SQ23\n~\nCall Information:\n\nCall Number:~25132\nCall Type:~ Animal Call\nSource:~911\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~02/01/2013 13:55:31\nDispatch Date/Time:~02/01/2013 14:01:13\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~3\nST61, SQ47, ST60~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n02/01/13 13:56:53~Nature Of Call: dog in the lagoon, pd already aware and have called aco\n02/01/13 13:59:03~per pd see if fd will assist
(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~2~WARREN~AVE~\nCommon Name:~SQ47\nVenue:~Lacey Township\nCross Streets~\nN MAIN ST / CAROLYN CT\nQuadrant:~ST61\nDistrict:~SQ26\n~\nCall Information:\n\nCall Number:~13778\nCall Type:~ Testing\nSource:~Telephone\nPriority:~ Administrative\nStatus:~Not In Progress\nCaller:~\nCall Date/Time:~01/18/2013 14:47:02\nDispatch Date/Time:~01/18/2013 14:47:26\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nSQ47~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n01/18/13 14:47:14~Nature Of Call: testing text paging

Contact: Active911
Agency name: New Egypt First Aid & Emergency Squad
Location: New Egypt, NJ, United States
Sender: messaging@iamresponding.com

(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~320 STAGE COACH RD~\nVenue:~Millstone Township\nCross Streets~\n~\nCall Information:\n\nCall Number:~107109\nCall Type:~ Unconsious\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 12:54:43\nDispatch Date/Time:~05/15/2013 12:55:55\nArrive Date/Time:~05/15/2013 13:13:20\nClear Date/Time:~05/15/2013 14:16:13\nEnroute Date/Time:~05/15/2013 12:57:56\nLatest Unit Cleared Date/Time:~05/15/2013 14:16:13\n~\nIncident Number(s)\n2013-00000502~~New Egypt EMS\n~\nUnits Sent:~2\nSQ30, E307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 12:55:06~Nature Of Call: 58 yof sycopal\n05/15/13 12:57:22~no cross street
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~<UNKNOWN>~\nCross Streets~\n~\nCall Information:\n\nCall Number:~107109\nCall Type:~ Unconsious\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 12:54:43\nDispatch Date/Time:~05/15/2013 12:55:55\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000502~~New Egypt EMS\n~\nUnits Sent:~1\nSQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 12:55:06~Nature Of Call: 58 yof sycopal
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~8~ROYAL OAK~DR~\nVenue:~Plumsted Township\nCross Streets~\nGREENWAY DR\n EDGEWOOD DR\n TANGLEWOOD DR / TANGLEWOOD DR\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106875\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:43:17\nDispatch Date/Time:~05/15/2013 05:44:34\nArrive Date/Time:~05/15/2013 05:53:05\nClear Date/Time:~05/15/2013 07:10:27\nEnroute Date/Time:~05/15/2013 05:45:01\nLatest Unit Cleared Date/Time:~05/15/2013 07:10:22\n~\nIncident Number(s)\n2013-00000501~~New Egypt EMS\n2013-00009083~~Paid ALS\n2013-00001724~~Plumsted Police Department\n~\nUnits Sent:~5\nE711, SQ75, SQ30, E307, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 05:45:18~NICOLE\n05/15/13 05:53:23~SQ30\n05/15/13 06:08:52~MEETING ALS LINE OF SITE OUT OF BURL/ALREADY SPEAKING W\n05/15/13 06:15:02~307 OUT WITH ALS
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~188~BRYNMORE~RD~\nVenue:~Plumsted Township\nCross Streets~\nCARTER LN / ARCHERTOWN RD\n W COLLIERS MILL RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106868\nCall Type:~ General Weakness\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:00:45\nDispatch Date/Time:~05/15/2013 05:03:35\nArrive Date/Time:~05/15/2013 05:10:10\nClear Date/Time:~05/15/2013 06:21:26\nEnroute Date/Time:~05/15/2013 05:04:08\nLatest Unit Cleared Date/Time:~05/15/2013 06:21:16\n~\nIncident Number(s)\n2013-00000500~~New Egypt EMS\n2013-00001723~~Plumsted Police Department\n~\nUnits Sent:~5\nSQ30, E309, 23-06, 23-04, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 05:01:30~Nature Of Call: 68 YOF\n05/15/13 05:02:12~Nature Of Call: 68 YOF POSS DEH
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~8~ROYAL OAK~DR~\nVenue:~Plumsted Township\nCross Streets~\nGREENWAY DR\n EDGEWOOD DR\n TANGLEWOOD DR / TANGLEWOOD DR\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106875\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:43:17\nDispatch Date/Time:~05/15/2013 05:44:34\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000501~~New Egypt EMS\n2013-00009083~~Paid ALS\n~\nUnits Sent:~2\nSQ75, SQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~188~BRYNMORE~RD~\nVenue:~Plumsted Township\nCross Streets~\nCARTER LN / ARCHERTOWN RD\n W COLLIERS MILL RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106868\nCall Type:~ General Weakness\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:00:45\nDispatch Date/Time:~05/15/2013 05:03:35\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000500~~New Egypt EMS\n~\nUnits Sent:~1\nSQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 05:01:30~Nature Of Call: 68 YOF\n05/15/13 05:02:12~Nature Of Call: 68 YOF POSS DEH
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~~HAWKIN~RD/~KENYON~DR\nVenue:~Plumsted Township\nCross Streets~\nQuadrant:~ST39\nDistrict:~SQ22\n~\nCall Information:\n\nCall Number:~106741\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 20:49:08\nDispatch Date/Time:~05/14/2013 20:51:34\nArrive Date/Time:~05/14/2013 20:56:15\nClear Date/Time:~05/14/2013 21:42:15\nEnroute Date/Time:~05/14/2013 20:52:08\nLatest Unit Cleared Date/Time:~05/14/2013 21:42:13\n~\nIncident Number(s)\n2013-00000654~~Jackson Twp EMS\n2013-00000499~~New Egypt EMS\n2013-00000225~~New Egypt Fire Company\n2013-00000103~~NJ Forest Fire Service\n2013-00001721~~Plumsted Police Department\n~\nUnits Sent:~10\nST39, B17, B9, SQ30, E309, 23-04, 23-01, F3909, F3910, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 20:51:26~POSS CONTROLLED BURN FIRE SIDE CHECKING\n05/14/13 20:51:29~SMOKE IN AREA\n05/14/13 20:56:04~B9 ADVISED\n05/14/13 21:04:28~CP CALLING FROM HOME AT 5 KENYON DR, PLUMSTED\n05/14/13 21:05:35~PER F3900 IS A SLIGHT SMELL OF SMOKE IN THE AREA\n05/14/13 21:09:50~PER F3900 SLIGHT SMELL OF SMOKE STILL IN THE ARE POSSIBLY FROM SOMEONES BACKYARD HOWEVER UNFOUNDED AT THIS TIME\n05/14/13 21:09:58~F3900 RETURNING UNITS
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~~HAWKIN~RD/~KENYON~DR\nVenue:~Plumsted Township\nCross Streets~\nQuadrant:~ST39\nDistrict:~SQ22\n~\nCall Information:\n\nCall Number:~106741\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 20:49:08\nDispatch Date/Time:~05/14/2013 20:51:34\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000499~~New Egypt EMS\n2013-00000225~~New Egypt Fire Company\n2013-00001721~~Plumsted Police Department\n~\nUnits Sent:~3\nST39, SQ30, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 20:51:26~POSS CONTROLLED BURN FIRE SIDE CHECKING\n05/14/13 20:51:29~SMOKE IN AREA
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~QUALITY INN~\nVenue:~New Hanover Twp\nCross Streets~\n~\nCall Information:\n\nCall Number:~106605\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 17:00:20\nDispatch Date/Time:~05/14/2013 17:03:35\nArrive Date/Time:~05/14/2013 17:05:15\nClear Date/Time:~05/14/2013 19:42:29\nEnroute Date/Time:~05/14/2013 17:03:38\nLatest Unit Cleared Date/Time:~05/14/2013 19:42:29\n~\nIncident Number(s)\n2013-00000498~~New Egypt EMS\n2013-00000224~~New Egypt Fire Company\n2013-00001720~~Plumsted Police Department\n~\nUnits Sent:~5\nSQ30, E307, 23-01, F3902, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 17:02:11~Nature Of Call: 3 inj
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~620~OCEAN~RD~\nCommon Name:~QUALITY INN - POINT BORO @ 88/DALLAS\nVenue:~Point Pleasant Boro\nCross Streets~\nMADISON ST / DALLAS ST\n FR RT 88 EB TO RT 35 NB\nQuadrant:~ST75\nDistrict:~SQ35\n~\nCall Information:\n\nCall Number:~106605\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 17:00:20\nDispatch Date/Time:~05/14/2013 17:03:35\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~05/14/2013 17:03:38\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000498~~New Egypt EMS\n2013-00000224~~New Egypt Fire Company\n~\nUnits Sent:~3\nE307, F3902, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 17:02:11~Nature Of Call: 3 inj
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~374~MEANY~RD~\nVenue:~North Hanover\nCross Streets~\nNo Cross Streets Found\n~\nCall Information:\n\nCall Number:~106556\nCall Type:~ Chest Pain\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 15:44:57\nDispatch Date/Time:~05/14/2013 15:45:50\nArrive Date/Time:~05/14/2013 15:49:37\nClear Date/Time:~05/14/2013 16:33:13\nEnroute Date/Time:~05/14/2013 15:45:53\nLatest Unit Cleared Date/Time:~05/14/2013 16:33:11\n~\nIncident Number(s)\n2013-00000497~~New Egypt EMS\n~\nUnits Sent:~1\nE307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 15:46:33~E307 SIGNING ON WITH BURL CO WHILE ON THE PHONE WITH US
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~374 MEANIE RD~\nVenue:~Morris Co. - Non Specifc\nCross Streets~\n~\nCall Information:\n\nCall Number:~106556\nCall Type:~ >New<\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 15:44:57\nDispatch Date/Time:~05/14/2013 15:45:50\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nE307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~RT 537/MEANY RD~\nVenue:~North Hanover\nCross Streets~\n~\nCall Information:\n\nCall Number:~106505\nCall Type:~ MVC W/Injuries\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 14:47:16\nDispatch Date/Time:~05/14/2013 14:48:30\nArrive Date/Time:~05/14/2013 14:51:12\nClear Date/Time:~05/14/2013 15:20:32\nEnroute Date/Time:~05/14/2013 14:48:50\nLatest Unit Cleared Date/Time:~05/14/2013 15:20:32\n~\nIncident Number(s)\n2013-00000496~~New Egypt EMS\n2013-00000223~~New Egypt Fire Company\n~\nUnits Sent:~7\nST39, SQ30, E307, E300, F3902, F3911, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 14:47:21~Nature Of Call: 30 AND 29\n05/14/13 14:53:12~Nature Of Call: 30 AND 39
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~<UNKNOWN>~\nCross Streets~\n~\nCall Information:\n\nCall Number:~106505\nCall Type:~ >New<\nSource:~Telephone\nPriority:~ Administrative\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 14:47:16\nDispatch Date/Time:~05/14/2013 14:48:30\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n~\nUnits Sent:~1\nSQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 14:47:21~Nature Of Call: 30 AND 29
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~194~JACOBSTOWN - NEW EGYPT~RD~lot 74\nCommon Name:~Deep Well Trailer Park - North Hanover\nVenue:~North Hanover\nCross Streets~\nMEANY RD / RT 537\n~\nCall Information:\n\nCall Number:~105833\nCall Type:~ Chest Pain\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/13/2013 16:19:10\nDispatch Date/Time:~05/13/2013 16:19:42\nArrive Date/Time:~05/13/2013 16:24:54\nClear Date/Time:~05/13/2013 17:50:53\nEnroute Date/Time:~05/13/2013 16:21:47\nLatest Unit Cleared Date/Time:~05/13/2013 17:50:46\n~\nIncident Number(s)\n2013-00000495~~New Egypt EMS\n~\nUnits Sent:~2\nSQ30, E306~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/13/13 16:19:37~Nature Of Call: 82yom chest pains
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~194~JACOBSTOWN - NEW EGYPT~RD~lot 74\nCommon Name:~Deep Well Trailer Park - North Hanover\nVenue:~North Hanover\nCross Streets~\nMEANY RD / RT 537\n~\nCall Information:\n\nCall Number:~105833\nCall Type:~ Chest Pain\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/13/2013 16:19:10\nDispatch Date/Time:~05/13/2013 16:19:42\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000495~~New Egypt EMS\n~\nUnits Sent:~1\nSQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/13/13 16:19:37~Nature Of Call: 82yom chest pains
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~131~BRINDLETOWN~RD~\nVenue:~Plumsted Township\nCross Streets~\nOAK LN / BUNTING BRIDGE RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~105372\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 23:56:48\nDispatch Date/Time:~05/12/2013 23:57:23\nArrive Date/Time:~05/13/2013 00:01:13\nClear Date/Time:~05/13/2013 00:50:06\nEnroute Date/Time:~05/12/2013 23:57:41\nLatest Unit Cleared Date/Time:~05/13/2013 00:49:56\n~\nIncident Number(s)\n2013-00000494~~New Egypt EMS\n2013-00008949~~Paid ALS\n2013-00001702~~Plumsted Police Department\n~\nUnits Sent:~6\nE754, E711, SQ75, SQ30, E309, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/12/13 23:57:11~Nature Of Call: 52YOF  BREATHING OK
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~131~BRINDLETOWN~RD~\nVenue:~Plumsted Township\nCross Streets~\nOAK LN / BUNTING BRIDGE RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~105372\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 23:56:48\nDispatch Date/Time:~05/12/2013 23:57:23\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~05/12/2013 23:57:41\nLatest Unit Cleared Date/Time:~05/12/2013 23:59:03\n~\nIncident Number(s)\n2013-00000494~~New Egypt EMS\n2013-00008949~~Paid ALS\n2013-00001702~~Plumsted Police Department\n~\nUnits Sent:~4\nE754, SQ75, SQ30, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/12/13 23:57:11~Nature Of Call: 52YOF  BREATHING OK
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~534~MONMOUTH~RD~\nCommon Name:~Burger King - Millstone\nVenue:~Millstone Township\nCross Streets~\nANDERSON RD / W COMMODORE BLVD\n~\nCall Information:\n\nCall Number:~105300\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 21:19:19\nDispatch Date/Time:~05/12/2013 21:19:47\nArrive Date/Time:~05/12/2013 21:33:29\nClear Date/Time:~05/12/2013 22:31:28\nEnroute Date/Time:~05/12/2013 21:21:04\nLatest Unit Cleared Date/Time:~05/12/2013 22:31:24\n~\nIncident Number(s)\n2013-00000493~~New Egypt EMS\n~\nUnits Sent:~3\nSQ30, E309, E307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/12/13 21:21:44~PER MONMOUTH CO REQ A 2ND RIG\n05/12/13 21:22:01~needs 2 rigs\n05/12/13 21:25:20~PER MONMOUTH CO NO MORE RIGS NEEDED\n05/12/13 21:25:33~307 ADVISWED
(Sq-30) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~534~MONMOUTH~RD~\nCommon Name:~Burger King - Millstone\nVenue:~Millstone Township\nCross Streets~\nANDERSON RD / W COMMODORE BLVD\n~\nCall Information:\n\nCall Number:~105300\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 21:19:19\nDispatch Date/Time:~05/12/2013 21:19:47\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000493~~New Egypt EMS\n~\nUnits Sent:~1\nSQ30~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative

Contact: Active911
Agency name: Barnegat Fire Company #1
Location: Barnegat, NJ, United States
Sender: <Fire_Records>

{Rip and Run Report} Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~39.7818570383177000~-74.2437879777373000~\nCommon Name:~69.5 S GSP\nVenue:~Garden State Parkway\nCross Streets~\nGARDEN STATE PKWY S\n FR CO 532 TO GSP SB / GARDEN STATE PKWY S\n FR GSP SB TO CO 554\nQuadrant:~ST11 Parkway\nDistrict:~SQ42\n~\nCall Information:\n\nCall Number:~131642\nCall Type:~ Overturned Vehicle\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/10/2013 10:11:12\nDispatch Date/Time:~06/10/2013 10:13:33\nArrive Date/Time:~06/10/2013 10:15:36\nClear Date/Time:~06/10/2013 11:03:12\nEnroute Date/Time:~06/10/2013 10:15:48\nLatest Unit Cleared Date/Time:~06/10/2013 11:03:12\n~\nIncident Number(s)\n2013-00000190~~Barnegat Fire Department\n2013-00001025~~Ocean County Prosecutors Office\n2013-00010753~~Paid ALS\n2013-00000281~~Waretown EMS\n~\nUnits Sent:~8\nST11, E716, SQ75, SQ42, 35-104, F1131, F1110, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/10/13 10:12:04~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS\n06/10/13 10:13:05~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ\n06/10/13 10:13:15~PER PD START FIRE/EMS\n06/10/13 10:13:32~OCNT NOTFD\n06/10/13 10:14:35~BNGT NOTFD FOR FIRE\n06/10/13 10:15:12~sarah\n06/10/13 10:16:15~no inj per 35-140\n06/10/13 10:20:35~1st truck on air only, reduced rate
{Rip and Run Report} Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~39.7818570383177000~-74.2437879777373000~\nCommon Name:~69.5 S GSP\nVenue:~Garden State Parkway\nCross Streets~\nGARDEN STATE PKWY S\n FR CO 532 TO GSP SB / GARDEN STATE PKWY S\n FR GSP SB TO CO 554\nQuadrant:~ST11 Parkway\nDistrict:~SQ42\n~\nCall Information:\n\nCall Number:~131642\nCall Type:~ Overturned Vehicle\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/10/2013 10:11:12\nDispatch Date/Time:~06/10/2013 10:13:33\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000190~~Barnegat Fire Department\n~\nUnits Sent:~1\nST11~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/10/13 10:12:04~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS\n06/10/13 10:13:05~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ\n06/10/13 10:13:15~PER PD START FIRE/EMS\n06/10/13 10:13:32~OCNT NOTFD
{Fwd: [OCSD] Rip and Run Report} \n\n\nBegin forwarded message:\n\nFrom: <Fire_Records>\nDate: June 4, 2013, 18:34:03 EDT\nTo: <ocsd@station11.org>\nSubject: [OCSD] Rip and Run Report\nReply-To: frank@station11.org\n\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~7~BALLAST~AVE~\nVenue:~Barnegat Township\nCross Streets~\nWATTS AVE / DEAD END\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~126158\nCall Type:~ Appliance Fire\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/04/2013 18:10:59\nDispatch Date/Time:~06/04/2013 18:12:11\nArrive Date/Time:~06/04/2013 18:19:30\nClear Date/Time:~06/04/2013 18:34:01\nEnroute Date/Time:~06/04/2013 18:14:01\nLatest Unit Cleared Date/Time:~06/04/2013 18:34:01\n~\nIncident Number(s)\n2013-00000188~~Barnegat Fire Department\n~\nUnits Sent:~5\nF1115, ST11, F1141, F1110, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/04/13 18:11:53~Nature Of Call: GRILL FIRE\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org
{Fwd: [OCSD] Rip and Run Report} \n\n\nBegin forwarded message:\n\nFrom: <Fire_Records>\nDate: June 2, 2013, 12:16:23 EDT\nTo: <ocsd@station11.org>\nSubject: [OCSD] Rip and Run Report\nReply-To: frank@station11.org\n\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~973~W~BAY~AVE~\nCommon Name:~Bayside Chapel - Barnegat\nVenue:~Barnegat Township\nCross Streets~\n3RD ST / 4TH ST\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~124582\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/02/2013 12:00:17\nDispatch Date/Time:~06/02/2013 12:00:52\nArrive Date/Time:~06/02/2013 12:08:16\nClear Date/Time:~06/02/2013 12:16:21\nEnroute Date/Time:~06/02/2013 12:04:48\nLatest Unit Cleared Date/Time:~06/02/2013 12:16:19\n~\nIncident Number(s)\n2013-00000185~~Barnegat Fire Department\n2013-00000117~~NJ Forest Fire Service\n~\nUnits Sent:~6\nF1124, F1114, ST11, B5, F1131, F1112~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/02/13 12:00:37~Nature Of Call: MULCH FIRE\n06/02/13 12:05:33~PER B5 ITS B4'S TERRITORY\n06/02/13 12:07:01~PD PUTTING WATER ON IT\n06/02/13 12:07:51~B4 - ASHLEY HOUSE VM LEFT ON HER CELL\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org
{Fwd: [OCSD] Rip and Run Report} \n\n\nBegin forwarded message:\n\nFrom: <Fire_Records>\nDate: May 7, 2013, 15:50:13 EDT\nTo: <ocsd@station11.org>\nSubject: [OCSD] Rip and Run Report\nReply-To: frank@station11.org\n\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~919~W~BAY~AVE~\nCommon Name:~HERITAGE BAY - BARNEGAT\nVenue:~Barnegat Township\nCross Streets~\nFR GSP SB TO CO 554 / LIGHTHOUSE DR\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~100563\nCall Type:~ Special Response\nSource:~Telephone\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/07/2013 12:41:48\nDispatch Date/Time:~05/07/2013 12:42:12\nArrive Date/Time:~05/07/2013 12:42:15\nClear Date/Time:~05/07/2013 15:50:12\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~05/07/2013 15:50:06\n~\nIncident Number(s)\n2013-00000157~~Barnegat Fire Department\n~\nUnits Sent:~1\nF1115~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org
{Fwd: [OCSD] Rip and Run Report} \n\n\nBegin forwarded message:\n\nFrom: <Fire_Records>\nDate: May 11, 2013, 15:14:27 EDT\nTo: <ocsd@station11.org>\nSubject: [OCSD] Rip and Run Report\nReply-To: frank@station11.org\n\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~S~MAIN~ST/~GEORGETOWN~BLVD\nVenue:~Barnegat Township\nCross Streets~\nQuadrant:~ST11\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~104113\nCall Type:~ MVC W/Injuries\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/11/2013 14:17:07\nDispatch Date/Time:~05/11/2013 14:17:51\nArrive Date/Time:~05/11/2013 14:23:13\nClear Date/Time:~05/11/2013 15:14:25\nEnroute Date/Time:~05/11/2013 14:18:54\nLatest Unit Cleared Date/Time:~05/11/2013 15:14:24\n~\nIncident Number(s)\n2013-00000778~~Barnegat EMS\n2013-00000162~~Barnegat Fire Department\n~\nUnits Sent:~6\nST11, E117, SQ11, F1110, F1103, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/11/13 14:17:45~Nature Of Call: WANTS CHILD CHECKED\n05/11/13 14:18:04~Nature Of Call: WANTS CHILD CHECKED OUT\n05/11/13 14:31:46~REQ FIRE FOR CLEAN UP\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org
Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~1~PASSAGE~LN~\nVenue:~Barnegat Township\nCross Streets~\nEDGARTOWN LN / FENWICK LN\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~120518\nCall Type:~ Fire Alarm\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/29/2013 18:03:27\nDispatch Date/Time:~05/29/2013 18:05:04\nArrive Date/Time:~05/29/2013 18:13:36\nClear Date/Time:~05/29/2013 18:31:55\nEnroute Date/Time:~05/29/2013 18:07:31\nLatest Unit Cleared Date/Time:~05/29/2013 18:31:52\n~\nIncident Number(s)\n2013-00000182~~Barnegat Fire Department\n~\nUnits Sent:~4\nF1114, ST11, F1121, F1110~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/29/13 18:04:50~Nature Of Call: also lost power/no smoke or flames\n05/29/13 18:16:28~PER F1110 ONLY THE 41 TRUCK\n05/29/13 18:17:13~ONLY 21 TRUCK

 */

public class NJOceanCountyParserTest extends BaseParserTest {
  
  public NJOceanCountyParserTest() {
    setParser(new NJOceanCountyParser(), "OCEAN COUNTY", "NJ");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~33~WOODLAND~RD~\n" +
        "Common Name:~ST BARNABAS CHURCH - BERKELEY @ WOODLAND/CHAIN\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "SYLVAN LAKE BLVD / CHAIN BLVD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91096\n" +
        "Call Type:~ Fire Information\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 12:56:40\n" +
        "Dispatch Date/Time:~07/12/2012 12:59:49\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17D~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:33 WOODLAND RD",
        "PLACE:ST BARNABAS CHURCH - BERKELEY @ WOODLAND/CHAIN",
        "CITY:Berkeley Township",
        "X:SYLVAN LAKE BLVD / CHAIN BLVD",
        "ID:91096",
        "CALL:Fire Information",
        "PRI:Administrative",
        "DATE:07/12/2012",
        "TIME:12:59:49",
        "UNIT:ST17D");

    doTest("T2",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91184\n" +
        "Call Type:~ Landing Zone\n" +
        "Source:~Telephone\n" +
        "Priority:~ Low\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 14:24:12\n" +
        "Dispatch Date/Time:~07/12/2012 14:24:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~07/12/2012 14:34:16\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000186~~Bayville Fire Department\n" +
        "2012-00008054~~Paid ALS\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "MONOC1, F1700~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:91184",
        "CALL:Landing Zone",
        "PRI:Low",
        "DATE:07/12/2012",
        "TIME:14:24:46",
        "UNIT:MONOC1, F1700");

    doTest("T3",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~33~KORMAN~RD~APT A12\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "ESPLANADE WAY / RT 9\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~91504\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/12/2012 18:56:54\n" +
        "Dispatch Date/Time:~07/12/2012 18:58:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000187~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/12/12 18:58:15~Nature Of Call: NO ONE FEELING ILL WAITING OUTSIDE",

        "SRC:ST17-SQ13",
        "ADDR:33 KORMAN RD",
        "APT:A12",
        "CITY:Berkeley Township",
        "X:ESPLANADE WAY / RT 9",
        "ID:91504",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/12/2012",
        "TIME:18:58:36",
        "UNIT:ST17",
        "INFO:Nature Of Call: NO ONE FEELING ILL WAITING OUTSIDE");

    doTest("T4",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92248\n" +
        "Call Type:~ Vehicle Fire\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 14:20:45\n" +
        "Dispatch Date/Time:~07/13/2012 14:21:47\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001602~~Bayville EMS\n" +
        "2012-00000188~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, SQ13~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:92248",
        "CALL:Vehicle Fire",
        "PRI:High",
        "DATE:07/13/2012",
        "TIME:14:21:47",
        "UNIT:ST17, SQ13");

    doTest("T5",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~343~ARLINGTON~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MARYLAND AVE / DEAD END\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92497\n" +
        "Call Type:~ Gas Leak\n" +
        "Source:~Telephone\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 17:16:32\n" +
        "Dispatch Date/Time:~07/13/2012 17:17:43\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000189~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:343 ARLINGTON AVE",
        "CITY:Berkeley Township",
        "X:MARYLAND AVE / DEAD END",
        "ID:92497",
        "CALL:Gas Leak",
        "PRI:Medium",
        "DATE:07/13/2012",
        "TIME:17:17:43",
        "UNIT:ST17");

    doTest("T6",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~445~RT~9~\n" +
        "Common Name:~SHOPRITE - BERKELEY\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "FREDERICK DR / KORMAN RD\n" +
        " OCEAN GATE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92561\n" +
        "Call Type:~ Landing Zone\n" +
        "Source:~Telephone\n" +
        "Priority:~ Low\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 18:14:03\n" +
        "Dispatch Date/Time:~07/13/2012 18:14:36\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000190~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:445 RT 9",
        "PLACE:SHOPRITE - BERKELEY",
        "CITY:Berkeley Township",
        "X:FREDERICK DR / KORMAN RD",
        "ID:92561",
        "CALL:Landing Zone",
        "PRI:Low",
        "DATE:07/13/2012",
        "TIME:18:14:36",
        "UNIT:ST17");

    doTest("T7",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~316~BAY~BLVD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "CROW AVE / ROBIN AVE\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~92833\n" +
        "Call Type:~ General Weakness\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/13/2012 23:16:54\n" +
        "Dispatch Date/Time:~07/13/2012 23:18:20\n" +
        "Arrive Date/Time:~07/13/2012 23:30:08\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~07/13/2012 23:26:31\n" +
        "Latest Unit Cleared Date/Time:~07/13/2012 23:26:34\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001605~~Bayville EMS\n" +
        "2012-00000191~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "ST17, SQ13, E136~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/13/12 23:17:53~Nature Of Call: 42YOF\n" +
        "07/13/12 23:18:02~CELULITIS IN BOTH LEGS\n" +
        "07/13/12 23:24:15~conf crew",

        "SRC:ST17-SQ13",
        "ADDR:316 BAY BLVD",
        "CITY:Berkeley Township",
        "X:CROW AVE / ROBIN AVE",
        "ID:92833",
        "CALL:General Weakness",
        "PRI:Medium",
        "DATE:07/13/2012",
        "TIME:23:18:20",
        "UNIT:ST17, SQ13, E136",
        "INFO:Nature Of Call: 42YOF / CELULITIS IN BOTH LEGS / conf crew");

    doTest("T8",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~255~CHELSEA~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "CEDARCREST DR / BERKELEY PL\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~93543\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/14/2012 16:55:39\n" +
        "Dispatch Date/Time:~07/14/2012 16:56:19\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000192~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/14/12 16:56:05~Nature Of Call: CO ALM, EVERYONE GETTING OUT",

        "SRC:ST17-SQ13",
        "ADDR:255 CHELSEA AVE",
        "CITY:Berkeley Township",
        "X:CEDARCREST DR / BERKELEY PL",
        "ID:93543",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/14/2012",
        "TIME:16:56:19",
        "UNIT:ST17",
        "INFO:Nature Of Call: CO ALM, EVERYONE GETTING OUT");

    doTest("T9",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~492~EASTERN~BLVD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "LATIMER AVE / NOLAN AVE\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94287\n" +
        "Call Type:~ Animal Call\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 11:04:44\n" +
        "Dispatch Date/Time:~07/15/2012 11:09:44\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 11:08:59~Nature Of Call: KITTEN IN TREE / PD REQ FD RESPONE.\n" +
        "07/15/12 11:09:13~CALLED IN BY BERK PD",

        "SRC:ST17-SQ13",
        "ADDR:492 EASTERN BLVD",
        "CITY:Berkeley Township",
        "X:LATIMER AVE / NOLAN AVE",
        "ID:94287",
        "CALL:Animal Call",
        "PRI:Administrative",
        "DATE:07/15/2012",
        "TIME:11:09:44",
        "UNIT:ST17",
        "INFO:Nature Of Call: KITTEN IN TREE / PD REQ FD RESPONE. / CALLED IN BY BERK PD");

    doTest("T10",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~136~CEDAR RUN~RD~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "DEAD END / SAND RD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94427\n" +
        "Call Type:~ Fire Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 13:34:22\n" +
        "Dispatch Date/Time:~07/15/2012 13:35:37\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000193~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 13:35:22~Nature Of Call: vacant house  third party nothing showing",

        "SRC:ST17-SQ13",
        "ADDR:136 CEDAR RUN RD",
        "CITY:Berkeley Township",
        "X:DEAD END / SAND RD",
        "ID:94427",
        "CALL:Fire Alarm",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:13:35:37",
        "UNIT:ST17",
        "INFO:Nature Of Call: vacant house  third party nothing showing");

    doTest("T11",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~570~EGENOLF~PL~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "No Cross Streets Found\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94774\n" +
        "Call Type:~ Brush Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 19:46:28\n" +
        "Dispatch Date/Time:~07/15/2012 19:47:46\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000194~~Bayville Fire Department\n" +
        "2012-00001156~~NJ Forest Fire Service\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, B7~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:570 EGENOLF PL",
        "CITY:Berkeley Township",
        "ID:94774",
        "CALL:Brush Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:19:47:46",
        "UNIT:ST17, B7");

    doTest("T12",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~50~GOOD LUCK~DR~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "BEACH AVE / DORRANCE DR\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94807\n" +
        "Call Type:~ Structure Fire\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 20:26:59\n" +
        "Dispatch Date/Time:~07/15/2012 20:27:43\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00001618~~Bayville EMS\n" +
        "2012-00000195~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "ST17, SQ13~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 20:27:28~Nature Of Call: SMOKE COMING OUT OF HOUSE UNK IF ANYONE IS HOME",

        "SRC:ST17-SQ13",
        "ADDR:50 GOOD LUCK DR",
        "CITY:Berkeley Township",
        "X:BEACH AVE / DORRANCE DR",
        "ID:94807",
        "CALL:Structure Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:20:27:43",
        "UNIT:ST17, SQ13",
        "INFO:Nature Of Call: SMOKE COMING OUT OF HOUSE UNK IF ANYONE IS HOME");

    doTest("T13",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~395~LAKESIDE~BLVD~\n" +
        "Common Name:~Crystal Lake Convalescent Center - Berkeley\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "HAYDEN ST / MONTGOMERY ST\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94871\n" +
        "Call Type:~ Fire Alarm\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 21:23:09\n" +
        "Dispatch Date/Time:~07/15/2012 21:24:10\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000196~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/15/12 21:23:59~Nature Of Call: OPER 3684\n" +
        "07/15/12 21:24:05~Nature Of Call: OPER 3684",

        "SRC:ST17-SQ13",
        "ADDR:395 LAKESIDE BLVD",
        "PLACE:Crystal Lake Convalescent Center - Berkeley",
        "CITY:Berkeley Township",
        "X:HAYDEN ST / MONTGOMERY ST",
        "ID:94871",
        "CALL:Fire Alarm",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:21:24:10",
        "UNIT:ST17",
        "INFO:Nature Of Call: OPER 3684 / Nature Of Call: OPER 3684");

    doTest("T14",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~386~VIRGINIA~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "HOOVER AVE / WESTERN BLVD\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~94963\n" +
        "Call Type:~ Pole Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/15/2012 22:57:26\n" +
        "Dispatch Date/Time:~07/15/2012 22:58:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000197~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:386 VIRGINIA AVE",
        "CITY:Berkeley Township",
        "X:HOOVER AVE / WESTERN BLVD",
        "ID:94963",
        "CALL:Pole Fire",
        "PRI:High",
        "DATE:07/15/2012",
        "TIME:22:58:35",
        "UNIT:ST17");

    doTest("T15",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~18~BUTLER~BLVD~\n" +
        "Common Name:~Tallwoods Care Center - Berkeley @ Butler Blvd\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "LAUREL LN / RT 9\n" +
        " CENTRAL PKWY\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~96448\n" +
        "Call Type:~ Fire Information\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/17/2012 12:22:04\n" +
        "Dispatch Date/Time:~07/17/2012 12:23:19\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17C~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/17/12 12:22:32~Nature Of Call: WORKING ON FIRE SYSTEM\n" +
        "07/17/12 12:23:05~WILL CALL BACK WHEN DONE",

        "SRC:ST17-SQ13",
        "ADDR:18 BUTLER BLVD",
        "PLACE:Tallwoods Care Center - Berkeley @ Butler Blvd",
        "CITY:Berkeley Township",
        "X:LAUREL LN / RT 9",
        "ID:96448",
        "CALL:Fire Information",
        "PRI:Administrative",
        "DATE:07/17/2012",
        "TIME:12:23:19",
        "UNIT:ST17C",
        "INFO:Nature Of Call: WORKING ON FIRE SYSTEM / WILL CALL BACK WHEN DONE");

    doTest("T16",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~120~PATTON~AVE~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MIDLAND AVE / DEAD END\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~96592\n" +
        "Call Type:~ CO Alarm\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/17/2012 14:34:14\n" +
        "Dispatch Date/Time:~07/17/2012 14:35:01\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000198~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST17-SQ13",
        "ADDR:120 PATTON AVE",
        "CITY:Berkeley Township",
        "X:MIDLAND AVE / DEAD END",
        "ID:96592",
        "CALL:CO Alarm",
        "PRI:High",
        "DATE:07/17/2012",
        "TIME:14:35:01",
        "UNIT:ST17");

    doTest("T17",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~11~VINE~ST~\n" +
        "Venue:~Berkeley Township\n" +
        "Cross Streets~\n" +
        "MARICIEL AVE / CENTRAL PKWY\n" +
        "Quadrant:~ST17\n" +
        "District:~SQ13\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~97427\n" +
        "Call Type:~ Odor Investigation\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~07/18/2012 11:00:14\n" +
        "Dispatch Date/Time:~07/18/2012 11:00:57\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2012-00000199~~Bayville Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST17~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "07/18/12 11:00:43~Nature Of Call: strong smell of smoke",

        "SRC:ST17-SQ13",
        "ADDR:11 VINE ST",
        "CITY:Berkeley Township",
        "X:MARICIEL AVE / CENTRAL PKWY",
        "ID:97427",
        "CALL:Odor Investigation",
        "PRI:Administrative",
        "DATE:07/18/2012",
        "TIME:11:00:57",
        "UNIT:ST17",
        "INFO:Nature Of Call: strong smell of smoke");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~401~DOVER~RD~\n\n" +
        "Common Name:~SQ37\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "TILTON AVE / YANNETTE RD\n\n" +
        " AMHERST RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129474\n\n" +
        "Call Type:~ EMS Information\n\n" +
        "Source:~Telephone\n\n" +
        "Priority:~ Administrative\n\n" +
        "Status:~Not In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 09:10:09\n\n" +
        "Dispatch Date/Time:~08/17/2012 09:11:03\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n" +
        "08/17/12 09:10:44~asst capt of squad\n\n" +
        "08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:401 DOVER RD",
        "PLACE:SQ37",
        "CITY:South Toms River",
        "X:TILTON AVE / YANNETTE RD",
        "ID:129474",
        "CALL:EMS Information",
        "PRI:Administrative",
        "DATE:08/17/2012",
        "TIME:09:11:03",
        "UNIT:SQ37",
        "INFO:Nature Of Call: pager test for both tones / asst capt of squad / just got 2 pagers back, want to make sure they are working");

    doTest("T2",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~401~DOVER~RD~\n\n" +
        "Common Name:~SQ37\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "TILTON AVE / YANNETTE RD\n\n" +
        " AMHERST RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129474\n\n" +
        "Call Type:~ EMS Information\n\n" +
        "Source:~Telephone\n\n" +
        "Priority:~ Administrative\n\n" +
        "Status:~Not In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 09:10:09\n\n" +
        "Dispatch Date/Time:~08/17/2012 09:11:03\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~08/17/2012 09:12:35\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 09:12:35\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 09:10:39~Nature Of Call: pager test for both tones\n\n" +
        "08/17/12 09:10:44~asst capt of squad\n\n" +
        "08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~401~DOVER~RD~\nCommon Name:~SQ37\nVenue:~South Toms River Boro\nCross Streets~\nTILTON AVE / YANNETTE RD\n AMHERST RD\nQuadrant:~ST18/SQ37\nDistrict:~SQ37\n~\nCall Information:\n\nCall Number:~129474\nCall Type:~ EMS Information\nSource:~Telephone\nPriority:~ Administrative\nStatus:~Not In Progress\nCaller:~\nCall Date/Time:~08/17/2012 09:10:09\nDispatch Date/Time:~08/17/2012 09:11:03\nArrive Date/Time:~\nClear Date/Time:~08/17/2012 09:12:35\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~08/17/2012 09:12:35\n~\nIncident Number(s)\n~\nUnits Sent:~1\nSQ37~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/17/12 09:10:39~Nature Of Call: pager test for both tones\n08/17/12 09:10:44~asst capt of squad\n08/17/12 09:10:55~just got 2 pagers back, want to make sure they are working",
        "CALL:RUN REPORT");

    doTest("T3",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129743\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 13:26:56\n\n" +
        "Dispatch Date/Time:~08/17/2012 13:30:11\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010722~~Paid ALS\n\n" +
        "2012-00001281~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ75, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n" +
        "08/17/12 13:30:25~sarah",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:129743",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:13:30:11",
        "UNIT:SQ75, SQ37",
        "INFO:Nature Of Call: 19 MONTHS / sarah");

    doTest("T4",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~129743\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 13:26:56\n\n" +
        "Dispatch Date/Time:~08/17/2012 13:30:11\n\n" +
        "Arrive Date/Time:~08/17/2012 13:50:57\n\n" +
        "Clear Date/Time:~08/17/2012 14:21:51\n\n" +
        "Enroute Date/Time:~08/17/2012 13:33:35\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 14:21:50\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010722~~Paid ALS\n\n" +
        "2012-00001281~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E712, SQ75, E378, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n\n" +
        "08/17/12 13:30:25~sarah",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~130~2ND~AVE~\nVenue:~Berkeley Township\nCross Streets~\nNo Cross Streets Found\nQuadrant:~ST18/SQ37\nDistrict:~SQ37\n~\nCall Information:\n\nCall Number:~129743\nCall Type:~ Seizures\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/17/2012 13:26:56\nDispatch Date/Time:~08/17/2012 13:30:11\nArrive Date/Time:~08/17/2012 13:50:57\nClear Date/Time:~08/17/2012 14:21:51\nEnroute Date/Time:~08/17/2012 13:33:35\nLatest Unit Cleared Date/Time:~08/17/2012 14:21:50\n~\nIncident Number(s)\n2012-00010722~~Paid ALS\n2012-00001281~~South Toms River EMS\n~\nUnits Sent:~4\nE712, SQ75, E378, SQ37~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/17/12 13:27:26~Nature Of Call: 19 MONTHS\n08/17/12 13:30:25~sarah",
        "CALL:RUN REPORT");

    doTest("T5",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130085\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 18:32:23\n\n" +
        "Dispatch Date/Time:~08/17/2012 18:33:14\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010739~~Paid ALS\n\n" +
        "2012-00001282~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ75, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 18:32:38~Nature Of Call: 19 MOS YOM",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:130 2ND AVE",
        "CITY:Berkeley Township",
        "ID:130085",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/17/2012",
        "TIME:18:33:14",
        "UNIT:SQ75, SQ37",
        "INFO:Nature Of Call: 19 MOS YOM");

    doTest("T6",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~130~2ND~AVE~\n\n" +
        "Venue:~Berkeley Township\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130085\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/17/2012 18:32:23\n\n" +
        "Dispatch Date/Time:~08/17/2012 18:33:14\n\n" +
        "Arrive Date/Time:~08/17/2012 18:44:04\n\n" +
        "Clear Date/Time:~08/17/2012 19:24:43\n\n" +
        "Enroute Date/Time:~08/17/2012 18:42:02\n\n" +
        "Latest Unit Cleared Date/Time:~08/17/2012 19:24:37\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010739~~Paid ALS\n\n" +
        "2012-00001282~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E712, SQ75, E378, SQ37~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/17/12 18:32:38~Nature Of Call: 19 MOS YOM\n\n" +
        "08/17/12 18:34:09~natalie\n\n" +
        "08/17/12 18:34:57~crosses 5th &amp; 8th st\n\n" +
        "08/17/12 18:36:34~370 conf crew resp to bldg\n\n" +
        "08/17/12 18:36:44~CHILD OUT OF THE SEIZURE JUST CAME HOME FROM THE HOSPITAL FOR THE SAME THING\n\n" +
        "08/17/12 18:36:47~HAS A FEVER\n\n" +
        "08/17/12 18:48:00~712 on loc per mon control",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~130~2ND~AVE~\nVenue:~Berkeley Township\nCross Streets~\nNo Cross Streets Found\nQuadrant:~ST18/SQ37\nDistrict:~SQ37\n~\nCall Information:\n\nCall Number:~130085\nCall Type:~ Seizures\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/17/2012 18:32:23\nDispatch Date/Time:~08/17/2012 18:33:14\nArrive Date/Time:~08/17/2012 18:44:04\nClear Date/Time:~08/17/2012 19:24:43\nEnroute Date/Time:~08/17/2012 18:42:02\nLatest Unit Cleared Date/Time:~08/17/2012 19:24:37\n~\nIncident Number(s)\n2012-00010739~~Paid ALS\n2012-00001282~~South Toms River EMS\n~\nUnits Sent:~4\nE712, SQ75, E378, SQ37~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/17/12 18:32:38~Nature Of Call: 19 MOS YOM\n08/17/12 18:34:09~natalie\n08/17/12 18:34:57~crosses 5th & 8th st\n08/17/12 18:36:34~370 conf crew resp to bldg\n08/17/12 18:36:44~CHILD OUT OF THE SEIZURE JUST CAME HOME FROM THE HOSPITAL FOR THE SAME THING\n08/17/12 18:36:47~HAS A FEVER\n08/17/12 18:48:00~712 on loc per mon control",
        "CALL:RUN REPORT");

    doTest("T7",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~1~DREW~LN~\n\n" +
        "Common Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "ATTISON AVE / DEAD END\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130645\n\n" +
        "Call Type:~ Special Response\n\n" +
        "Source:~Air\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 09:47:53\n\n" +
        "Dispatch Date/Time:~08/18/2012 09:49:23\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001283~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~1\n\n" +
        "E370~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 09:49:12~Nature Of Call: special assignment",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:1 DREW LN",
        "PLACE:PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN",
        "CITY:South Toms River",
        "X:ATTISON AVE / DEAD END",
        "ID:130645",
        "CALL:Special Response",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:09:49:23",
        "UNIT:E370",
        "INFO:Nature Of Call: special assignment");

    doTest("T8",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~~FAIRWAY~DR/~DOVER~RD\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130769\n\n" +
        "Call Type:~ Suicide Attempt\n\n" +
        "Source:~911\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 12:25:30\n\n" +
        "Dispatch Date/Time:~08/18/2012 12:28:09\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00002735~~South Toms River Police Department\n\n" +
        "~\n\n" +
        "Units Sent:~2\n\n" +
        "SQ37, 29-06~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n" +
        "08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n" +
        "08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n" +
        "08/18/12 12:27:45~slurring his words\n\n" +
        "08/18/12 12:28:11~unk how long ago he took them or what they are\n\n" +
        "08/18/12 12:28:14~third party",

        "SRC:ST18/SQ37-SQ37",
        "ADDR:FAIRWAY DR & DOVER RD",
        "CITY:South Toms River",
        "ID:130769",
        "CALL:Suicide Attempt",
        "PRI:Medium",
        "DATE:08/18/2012",
        "TIME:12:28:09",
        "UNIT:SQ37, 29-06",
        "INFO:Nature Of Call: took 20 pills - unkown type / 34 yom called cp and said he was ending his life / natoli - beige house bilevel next to 7-11 / slurring his words / unk how long ago he took them or what they are / third party");

    doTest("T9",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~100~FAIRWAY~DR~\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "DOVER RD / DOUBLE TROUBLE RD\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130769\n\n" +
        "Call Type:~ Suicide Attempt\n\n" +
        "Source:~911\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 12:25:30\n\n" +
        "Dispatch Date/Time:~08/18/2012 12:28:09\n\n" +
        "Arrive Date/Time:~08/18/2012 12:28:49\n\n" +
        "Clear Date/Time:~08/18/2012 13:38:50\n\n" +
        "Enroute Date/Time:~08/18/2012 12:30:21\n\n" +
        "Latest Unit Cleared Date/Time:~08/18/2012 13:38:50\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00010795~~Paid ALS\n\n" +
        "2012-00001284~~South Toms River EMS\n\n" +
        "2012-00002735~~South Toms River Police Department\n\n" +
        "~\n\n" +
        "Units Sent:~7\n\n" +
        "E712, SQ75, E378, E370, SQ37, 29-17, 29-06~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n\n" +
        "08/18/12 12:26:21~34 yom called cp and said he was ending his life\n\n" +
        "08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n\n" +
        "08/18/12 12:27:45~slurring his words\n\n" +
        "08/18/12 12:28:11~unk how long ago he took them or what they are\n\n" +
        "08/18/12 12:28:14~third party\n\n" +
        "08/18/12 12:29:01~she stated he was at his residence\n\n" +
        "08/18/12 12:29:33~POSS 101\n\n" +
        "08/18/12 12:30:00~VIC MONOC\n\n" +
        "08/18/12 12:30:51~DOGS IN RESD UNK IF FRIENDLY OR NOT\n\n" +
        "08/18/12 12:32:00~subj concious and alert\n\n" +
        "08/18/12 12:32:21~BRIAN IS A FRIEND WHO LIVES UP THE STREET AND CINDY CALLED HIM AND IS ON HIS WAY TO RESD",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~100~FAIRWAY~DR~\nVenue:~South Toms River Boro\nCross Streets~\nDOVER RD / DOUBLE TROUBLE RD\nQuadrant:~ST18/SQ37\nDistrict:~SQ37\n~\nCall Information:\n\nCall Number:~130769\nCall Type:~ Suicide Attempt\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/18/2012 12:25:30\nDispatch Date/Time:~08/18/2012 12:28:09\nArrive Date/Time:~08/18/2012 12:28:49\nClear Date/Time:~08/18/2012 13:38:50\nEnroute Date/Time:~08/18/2012 12:30:21\nLatest Unit Cleared Date/Time:~08/18/2012 13:38:50\n~\nIncident Number(s)\n2012-00010795~~Paid ALS\n2012-00001284~~South Toms River EMS\n2012-00002735~~South Toms River Police Department\n~\nUnits Sent:~7\nE712, SQ75, E378, E370, SQ37, 29-17, 29-06~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/18/12 12:25:53~Nature Of Call: took 20 pills - unkown type\n08/18/12 12:26:21~34 yom called cp and said he was ending his life\n08/18/12 12:27:10~natoli - beige house bilevel next to 7-11\n08/18/12 12:27:45~slurring his words\n08/18/12 12:28:11~unk how long ago he took them or what they are\n08/18/12 12:28:14~third party\n08/18/12 12:29:01~she stated he was at his residence\n08/18/12 12:29:33~POSS 101\n08/18/12 12:30:00~VIC MONOC\n08/18/12 12:30:51~DOGS IN RESD UNK IF FRIENDLY OR NOT\n08/18/12 12:32:00~subj concious and alert\n08/18/12 12:32:21~BRIAN IS A FRIEND WHO LIVES UP THE STREET AND CINDY CALLED HIM AND IS ON HIS WAY TO RESD",
        "CALL:RUN REPORT");

    doTest("T10",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~1~DREW~LN~\n\n" +
        "Common Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\n\n" +
        "Venue:~South Toms River Boro\n\n" +
        "Cross Streets~\n\n" +
        "ATTISON AVE / DEAD END\n\n" +
        "Quadrant:~ST18/SQ37\n\n" +
        "District:~SQ37\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~130645\n\n" +
        "Call Type:~ Special Response\n\n" +
        "Source:~Air\n\n" +
        "Priority:~ Medium\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/18/2012 09:47:53\n\n" +
        "Dispatch Date/Time:~08/18/2012 09:49:23\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~08/18/2012 16:08:32\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~08/18/2012 16:08:32\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001283~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "E379, E378, E377, E370~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/18/12 09:49:12~Nature Of Call: special assignment",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~1~DREW~LN~\nCommon Name:~PUBLIC WORKS - SOUTH TOMS RIVER @ DREW LN\nVenue:~South Toms River Boro\nCross Streets~\nATTISON AVE / DEAD END\nQuadrant:~ST18/SQ37\nDistrict:~SQ37\n~\nCall Information:\n\nCall Number:~130645\nCall Type:~ Special Response\nSource:~Air\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/18/2012 09:47:53\nDispatch Date/Time:~08/18/2012 09:49:23\nArrive Date/Time:~\nClear Date/Time:~08/18/2012 16:08:32\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~08/18/2012 16:08:32\n~\nIncident Number(s)\n2012-00001283~~South Toms River EMS\n~\nUnits Sent:~4\nE379, E378, E377, E370~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/18/12 09:49:12~Nature Of Call: special assignment",
        "CALL:RUN REPORT");

    doTest("T11",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~721~MIDLAND~AVE~\n\n" +
        "Common Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\n" +
        "Venue:~Pine Beach Boro\n\n" +
        "Cross Streets~\n\n" +
        "LINDEN AVE / PENNSYLVANIA AVE\n\n" +
        "Quadrant:~ST38\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131775\n\n" +
        "Call Type:~ EMS Call\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:28:48\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:30:14\n\n" +
        "Arrive Date/Time:~\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001562~~Beachwood EMS\n\n" +
        "2012-00002188~~Pine Beach Police Department\n\n" +
        "2012-00001285~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~3\n\n" +
        "SQ37, SQ15, PNBCPD~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n" +
        "08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n" +
        "08/19/12 10:30:46~22-08 NOTFD\n\n" +
        "08/19/12 10:35:42~2ND REQUEST SQ37 STARTED",

        "SRC:ST38-SQ15",
        "ADDR:721 MIDLAND AVE",
        "PLACE:AMIB Group Home - Pine Beach @ Midland Ave",
        "CITY:Pine Beach",
        "X:LINDEN AVE / PENNSYLVANIA AVE",
        "ID:131775",
        "CALL:EMS Call",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:30:14",
        "UNIT:SQ37, SQ15, PNBCPD",
        "INFO:Nature Of Call: 50 yom swollen hand / Nature Of Call: 50 yom swollen hand unknonw how / 22-08 NOTFD / 2ND REQUEST SQ37 STARTED");

    doTest("T12",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~95~ATLANTIC CITY~BLVD~\n\n" +
        "Common Name:~RITE AID - BEACHWOOD\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "ENSIGN AVE / STARBOARD ST\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131816\n\n" +
        "Call Type:~ Pedestrian Struck\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:55:20\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:56:58\n\n" +
        "Arrive Date/Time:~08/19/2012 10:59:41\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~08/19/2012 10:57:36\n\n" +
        "Latest Unit Cleared Date/Time:~\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001563~~Beachwood EMS\n\n" +
        "2012-00004629~~Beachwood Police Department\n\n" +
        "2012-00001286~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "4-54, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n" +
        "08/19/12 10:57:38~PKING LOT OF RITE AID NOW",

        "SRC:ST16-SQ15",
        "ADDR:95 ATLANTIC CITY BLVD",
        "PLACE:RITE AID - BEACHWOOD",
        "CITY:Beachwood",
        "X:ENSIGN AVE / STARBOARD ST",
        "ID:131816",
        "CALL:Pedestrian Struck",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:10:56:58",
        "UNIT:4-54, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND / PKING LOT OF RITE AID NOW");

    doTest("T13",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~95~ATLANTIC CITY~BLVD~\n\n" +
        "Common Name:~RITE AID - BEACHWOOD\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "ENSIGN AVE / STARBOARD ST\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131816\n\n" +
        "Call Type:~ Pedestrian Struck\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:55:20\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:56:58\n\n" +
        "Arrive Date/Time:~08/19/2012 10:59:41\n\n" +
        "Clear Date/Time:~08/19/2012 11:08:08\n\n" +
        "Enroute Date/Time:~08/19/2012 10:57:36\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 11:08:08\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001563~~Beachwood EMS\n\n" +
        "2012-00004629~~Beachwood Police Department\n\n" +
        "2012-00001286~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~4\n\n" +
        "4-54, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n\n" +
        "08/19/12 10:57:38~PKING LOT OF RITE AID NOW\n\n" +
        "08/19/12 11:03:18~15 2ND REQUESTING FOR DRIVER AND START MUTUAL AID\n\n" +
        "08/19/12 11:07:17~NO INJ PER PD CANCLE THE RIG",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~95~ATLANTIC CITY~BLVD~\nCommon Name:~RITE AID - BEACHWOOD\nVenue:~Beachwood Boro\nCross Streets~\nENSIGN AVE / STARBOARD ST\nQuadrant:~ST16\nDistrict:~SQ15\n~\nCall Information:\n\nCall Number:~131816\nCall Type:~ Pedestrian Struck\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/19/2012 10:55:20\nDispatch Date/Time:~08/19/2012 10:56:58\nArrive Date/Time:~08/19/2012 10:59:41\nClear Date/Time:~08/19/2012 11:08:08\nEnroute Date/Time:~08/19/2012 10:57:36\nLatest Unit Cleared Date/Time:~08/19/2012 11:08:08\n~\nIncident Number(s)\n2012-00001563~~Beachwood EMS\n2012-00004629~~Beachwood Police Department\n2012-00001286~~South Toms River EMS\n~\nUnits Sent:~4\n4-54, SQ37, SQ15, 4-56~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/19/12 10:56:27~Nature Of Call: MALE ON BIKE HIT BY CAR - UP WALKING AROUND\n08/19/12 10:57:38~PKING LOT OF RITE AID NOW\n08/19/12 11:03:18~15 2ND REQUESTING FOR DRIVER AND START MUTUAL AID\n08/19/12 11:07:17~NO INJ PER PD CANCLE THE RIG",
        "CALL:RUN REPORT");

    doTest("T14",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~214~BEACHWOOD~BLVD~\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131830\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 11:08:07\n\n" +
        "Dispatch Date/Time:~08/19/2012 11:09:39\n\n" +
        "Arrive Date/Time:~08/19/2012 11:10:56\n\n" +
        "Clear Date/Time:~\n\n" +
        "Enroute Date/Time:~08/19/2012 11:09:51\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 11:10:27\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001564~~Beachwood EMS\n\n" +
        "2012-00004631~~Beachwood Police Department\n\n" +
        "2012-00010861~~Paid ALS\n\n" +
        "2012-00001287~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~5\n\n" +
        "E712, SQ75, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n" +
        "08/19/12 11:09:54~MONOC-JOHN",

        "SRC:ST16-SQ15",
        "ADDR:214 BEACHWOOD BLVD",
        "CITY:Beachwood",
        "ID:131830",
        "CALL:Seizures",
        "PRI:High",
        "DATE:08/19/2012",
        "TIME:11:09:39",
        "UNIT:E712, SQ75, SQ37, SQ15, 4-56",
        "INFO:Nature Of Call: 38 YOF / MONOC-JOHN");

    doTest("T15",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~721~MIDLAND~AVE~\n\n" +
        "Common Name:~AMIB Group Home - Pine Beach @ Midland Ave\n\n" +
        "Venue:~Pine Beach Boro\n\n" +
        "Cross Streets~\n\n" +
        "LINDEN AVE / PENNSYLVANIA AVE\n\n" +
        "Quadrant:~ST38\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131775\n\n" +
        "Call Type:~ EMS Call\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 10:28:48\n\n" +
        "Dispatch Date/Time:~08/19/2012 10:30:14\n\n" +
        "Arrive Date/Time:~08/19/2012 10:42:55\n\n" +
        "Clear Date/Time:~08/19/2012 12:00:55\n\n" +
        "Enroute Date/Time:~08/19/2012 10:38:13\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 12:00:55\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001562~~Beachwood EMS\n\n" +
        "2012-00001227~~Ocean Gate EMS\n\n" +
        "2012-00002188~~Pine Beach Police Department\n\n" +
        "2012-00001285~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~6\n\n" +
        "22-08, SQ37, SQ31, SQ15, E158, PNBCPD~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n\n" +
        "08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n\n" +
        "08/19/12 10:30:46~22-08 NOTFD\n\n" +
        "08/19/12 10:35:42~2ND REQUEST SQ37 STARTED\n\n" +
        "08/19/12 10:41:24~NO ANSWER FROM 15 OR 37 .37 2ND STARTED 31\n\n" +
        "08/19/12 10:42:48~SQ15 NEEDS A DRIVER OR EMT NEED\n\n" +
        "08/19/12 10:44:59~SQ37 DRIVER HEADING TO BUILDING PER 370\n\n" +
        "08/19/12 10:45:08~SQ31 TOLD TO STAND DOWN",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~721~MIDLAND~AVE~\nCommon Name:~AMIB Group Home - Pine Beach @ Midland Ave\nVenue:~Pine Beach Boro\nCross Streets~\nLINDEN AVE / PENNSYLVANIA AVE\nQuadrant:~ST38\nDistrict:~SQ15\n~\nCall Information:\n\nCall Number:~131775\nCall Type:~ EMS Call\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/19/2012 10:28:48\nDispatch Date/Time:~08/19/2012 10:30:14\nArrive Date/Time:~08/19/2012 10:42:55\nClear Date/Time:~08/19/2012 12:00:55\nEnroute Date/Time:~08/19/2012 10:38:13\nLatest Unit Cleared Date/Time:~08/19/2012 12:00:55\n~\nIncident Number(s)\n2012-00001562~~Beachwood EMS\n2012-00001227~~Ocean Gate EMS\n2012-00002188~~Pine Beach Police Department\n2012-00001285~~South Toms River EMS\n~\nUnits Sent:~6\n22-08, SQ37, SQ31, SQ15, E158, PNBCPD~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/19/12 10:29:31~Nature Of Call: 50 yom swollen hand\n08/19/12 10:29:42~Nature Of Call: 50 yom swollen hand unknonw how\n08/19/12 10:30:46~22-08 NOTFD\n08/19/12 10:35:42~2ND REQUEST SQ37 STARTED\n08/19/12 10:41:24~NO ANSWER FROM 15 OR 37 .37 2ND STARTED 31\n08/19/12 10:42:48~SQ15 NEEDS A DRIVER OR EMT NEED\n08/19/12 10:44:59~SQ37 DRIVER HEADING TO BUILDING PER 370\n08/19/12 10:45:08~SQ31 TOLD TO STAND DOWN",
        "CALL:RUN REPORT");

    doTest("T16",
        "(STRFAS) Rip and Run Report\n\n\n\n" +
        "~\n\n" +
        "Location Information:\n\n\n\n" +
        "Location:~214~BEACHWOOD~BLVD~\n\n" +
        "Venue:~Beachwood Boro\n\n" +
        "Cross Streets~\n\n" +
        "No Cross Streets Found\n\n" +
        "Quadrant:~ST16\n\n" +
        "District:~SQ15\n\n" +
        "~\n\n" +
        "Call Information:\n\n\n\n" +
        "Call Number:~131830\n\n" +
        "Call Type:~ Seizures\n\n" +
        "Source:~911\n\n" +
        "Priority:~ High\n\n" +
        "Status:~In Progress\n\n" +
        "Caller:~\n\n" +
        "Call Date/Time:~08/19/2012 11:08:07\n\n" +
        "Dispatch Date/Time:~08/19/2012 11:09:39\n\n" +
        "Arrive Date/Time:~08/19/2012 11:10:56\n\n" +
        "Clear Date/Time:~08/19/2012 12:21:50\n\n" +
        "Enroute Date/Time:~08/19/2012 11:09:51\n\n" +
        "Latest Unit Cleared Date/Time:~08/19/2012 12:21:49\n\n" +
        "~\n\n" +
        "Incident Number(s)\n\n" +
        "2012-00001564~~Beachwood EMS\n\n" +
        "2012-00004631~~Beachwood Police Department\n\n" +
        "2012-00010861~~Paid ALS\n\n" +
        "2012-00001287~~South Toms River EMS\n\n" +
        "~\n\n" +
        "Units Sent:~7\n\n" +
        "4-54, E712, SQ75, E378, SQ37, SQ15, 4-56~\n\n\n\n" +
        "Alerts:\n\n" +
        "~\n\n" +
        "Location Alerts\n\n\n\n" +
        "Person Alerts\n\n\n\n" +
        "Vehicle Alerts\n\n" +
        "~~\n\n" +
        "Narrative:\n\n\n\n" +
        "Narrative Time~Narrative\n\n" +
        "08/19/12 11:08:51~Nature Of Call: 38 YOF\n\n" +
        "08/19/12 11:09:54~MONOC-JOHN\n\n" +
        "08/19/12 11:12:00~2nd req\n\n" +
        "08/19/12 11:13:14~USE SIDE ENTRANCE",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~214~BEACHWOOD~BLVD~\nVenue:~Beachwood Boro\nCross Streets~\nNo Cross Streets Found\nQuadrant:~ST16\nDistrict:~SQ15\n~\nCall Information:\n\nCall Number:~131830\nCall Type:~ Seizures\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~08/19/2012 11:08:07\nDispatch Date/Time:~08/19/2012 11:09:39\nArrive Date/Time:~08/19/2012 11:10:56\nClear Date/Time:~08/19/2012 12:21:50\nEnroute Date/Time:~08/19/2012 11:09:51\nLatest Unit Cleared Date/Time:~08/19/2012 12:21:49\n~\nIncident Number(s)\n2012-00001564~~Beachwood EMS\n2012-00004631~~Beachwood Police Department\n2012-00010861~~Paid ALS\n2012-00001287~~South Toms River EMS\n~\nUnits Sent:~7\n4-54, E712, SQ75, E378, SQ37, SQ15, 4-56~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n08/19/12 11:08:51~Nature Of Call: 38 YOF\n08/19/12 11:09:54~MONOC-JOHN\n08/19/12 11:12:00~2nd req\n08/19/12 11:13:14~USE SIDE ENTRANCE",
        "CALL:RUN REPORT");

  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~244~N~MAIN~ST~\r\n" +
        "Common Name:~HOME DEPOT - LACEY\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "SUNRISE BLVD / NAUTILUS DR\r\n" +
        "Quadrant:~ST60\r\n" +
        "District:~SQ23\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~175220\r\n" +
        "Call Type:~ EMS Call\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 16:48:42\r\n" +
        "Dispatch Date/Time:~10/03/2012 16:49:17\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~10/03/2012 16:51:08\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00002186~~Lacey Twp EMS\r\n" +
        "2012-00001479~~Lanoka Harbor EMS\r\n" +
        "2012-00014110~~Paid ALS\r\n" +
        "~\r\n" +
        "Units Sent:~4\r\n" +
        "E712, SQ75, SQ26, SQ23~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 16:48:58~Nature Of Call: male passed out on grass\r\n" +
        "10/03/12 16:50:41~left hand side entrance\r\n" +
        "10/03/12 16:50:44~on grass\r\n" +
        "10/03/12 16:49:55~Call #: 175223 - Nature Of Call: male on grount\r\n" +
        "10/03/12 16:50:39~Call #: 175223 - Nature Of Call: male on ground is breathing pe caller pd on scene\r\n" +
        "10/03/12 16:55:24~PER SQ23 EMT NEEDED\r\n" +
        "10/03/12 16:55:53~SQ26 DSIPOATCHED\r\n" +
        "10/03/12 16:56:29~PER LACY PD SUBJ ALERT AND CONSC\r\n" +
        "\r\n",

        "SRC:ST60-SQ23",
        "ADDR:244 N MAIN ST",
        "PLACE:HOME DEPOT - LACEY",
        "CITY:Lacey Township",
        "X:SUNRISE BLVD / NAUTILUS DR",
        "ID:175220",
        "CALL:EMS Call",
        "PRI:High",
        "DATE:10/03/2012",
        "TIME:16:49:17",
        "UNIT:E712, SQ75, SQ26, SQ23",
        "INFO:Nature Of Call: male passed out on grass / left hand side entrance / on grass / Call #: 175223 - Nature Of Call: male on grount / Call #: 175223 - Nature Of Call: male on ground is breathing pe caller pd on scene / PER SQ23 EMT NEEDED / SQ26 DSIPOATCHED / PER LACY PD SUBJ ALERT AND CONSC");

    doTest("T2",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~25~WARREN~AVE~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "RAILROAD AVE\r\n" +
        " SOUTH ST\r\n" +
        " CEDAR AVE / CAROLYN CT\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~175090\r\n" +
        "Call Type:~ Unconsious\r\n" +
        "Source:~911\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 14:27:22\r\n" +
        "Dispatch Date/Time:~10/03/2012 14:28:07\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001478~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~1\r\n" +
        "SQ26~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 14:27:45~Nature Of Call: 69YOF\r\n" +
        "10/03/12 14:27:53~Nature Of Call: 69YOF  IS BREATHING\r\n" +
        "\r\n",

        "SRC:ST61-SQ26",
        "ADDR:25 WARREN AVE",
        "CITY:Lacey Township",
        "X:RAILROAD AVE",
        "ID:175090",
        "CALL:Unconsious",
        "PRI:High",
        "DATE:10/03/2012",
        "TIME:14:28:07",
        "UNIT:SQ26",
        "INFO:Nature Of Call: 69YOF / Nature Of Call: 69YOF  IS BREATHING");

    doTest("T3",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~408~N~MAIN~ST~\r\n" +
        "Common Name:~MCDONALDS - LACEY\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "FIRST ST\r\n" +
        " MUSKET DR / MURRAY GROVE RD\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174972\r\n" +
        "Call Type:~ Bee Sting\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 12:02:42\r\n" +
        "Dispatch Date/Time:~10/03/2012 12:04:09\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001477~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~1\r\n" +
        "SQ26~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 12:03:18~Nature Of Call: 19 yom\r\n" +
        "10/03/12 12:03:25~Nature Of Call: 19 yom\r\n" +
        "\r\n",

        "SRC:ST61-SQ26",
        "ADDR:408 N MAIN ST",
        "PLACE:MCDONALDS - LACEY",
        "CITY:Lacey Township",
        "X:FIRST ST",
        "ID:174972",
        "CALL:Bee Sting",
        "PRI:High",
        "DATE:10/03/2012",
        "TIME:12:04:09",
        "UNIT:SQ26",
        "INFO:Nature Of Call: 19 yom / Nature Of Call: 19 yom");

    doTest("T4",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~544~BRENTWOOD~RD~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "VAN DYKE AVE / VAN DYKE AVE\r\n" +
        "Quadrant:~ST60\r\n" +
        "District:~SQ23\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174921\r\n" +
        "Call Type:~ Diabetic\r\n" +
        "Source:~911\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 10:52:52\r\n" +
        "Dispatch Date/Time:~10/03/2012 10:54:35\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00002185~~Lacey Twp EMS\r\n" +
        "2012-00001476~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~2\r\n" +
        "SQ26, SQ23~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 10:53:23~Nature Of Call: 74 yof swollen feet\r\n" +
        "10/03/12 11:01:08~2ND REQ SQ26\r\n" +
        "\r\n",

        "SRC:ST60-SQ23",
        "ADDR:544 BRENTWOOD RD",
        "CITY:Lacey Township",
        "X:VAN DYKE AVE / VAN DYKE AVE",
        "ID:174921",
        "CALL:Diabetic",
        "PRI:High",
        "DATE:10/03/2012",
        "TIME:10:54:35",
        "UNIT:SQ26, SQ23",
        "INFO:Nature Of Call: 74 yof swollen feet / 2ND REQ SQ26");

    doTest("T5",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~708~CAMBRIDGE~RD~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "WELLESLEY RD / AMHERST RD\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174713\r\n" +
        "Call Type:~ Fall Victim\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ Medium\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 00:55:19\r\n" +
        "Dispatch Date/Time:~10/03/2012 00:59:46\r\n" +
        "Arrive Date/Time:~10/03/2012 01:10:09\r\n" +
        "Clear Date/Time:~10/03/2012 02:03:09\r\n" +
        "Enroute Date/Time:~10/03/2012 01:07:18\r\n" +
        "Latest Unit Cleared Date/Time:~10/03/2012 02:03:03\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001475~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~2\r\n" +
        "SQ26, E267~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 00:56:15~Nature Of Call: neck pain\r\n" +
        "10/03/12 01:03:15~conf crew\r\n" +
        "\r\n",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~708~CAMBRIDGE~RD~\nVenue:~Lacey Township\nCross Streets~\nWELLESLEY RD / AMHERST RD\nQuadrant:~ST61\nDistrict:~SQ26\n~\nCall Information:\n\nCall Number:~174713\nCall Type:~ Fall Victim\nSource:~Telephone\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~10/03/2012 00:55:19\nDispatch Date/Time:~10/03/2012 00:59:46\nArrive Date/Time:~10/03/2012 01:10:09\nClear Date/Time:~10/03/2012 02:03:09\nEnroute Date/Time:~10/03/2012 01:07:18\nLatest Unit Cleared Date/Time:~10/03/2012 02:03:03\n~\nIncident Number(s)\n2012-00001475~~Lanoka Harbor EMS\n~\nUnits Sent:~2\nSQ26, E267~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/03/12 00:56:15~Nature Of Call: neck pain\n10/03/12 01:03:15~conf crew",
        "CALL:RUN REPORT");

    doTest("T6",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~708~CAMBRIDGE~RD~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "WELLESLEY RD / AMHERST RD\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174713\r\n" +
        "Call Type:~ Fall Victim\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ Medium\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 00:55:19\r\n" +
        "Dispatch Date/Time:~10/03/2012 00:59:46\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001475~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~1\r\n" +
        "SQ26~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/03/12 00:56:15~Nature Of Call: neck pain\r\n" +
        "\r\n",

        "SRC:ST61-SQ26",
        "ADDR:708 CAMBRIDGE RD",
        "CITY:Lacey Township",
        "X:WELLESLEY RD / AMHERST RD",
        "ID:174713",
        "CALL:Fall Victim",
        "PRI:Medium",
        "DATE:10/03/2012",
        "TIME:00:59:46",
        "UNIT:SQ26",
        "INFO:Nature Of Call: neck pain");

    doTest("T7",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~708~CAMBRIDGE~RD~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "WELLESLEY RD / AMHERST RD\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174713\r\n" +
        "Call Type:~ Fall Victim\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ Medium\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/03/2012 00:55:19\r\n" +
        "Dispatch Date/Time:~10/03/2012 00:55:39\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001475~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~1\r\n" +
        "SQ26~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "\r\n",

        "SRC:ST61-SQ26",
        "ADDR:708 CAMBRIDGE RD",
        "CITY:Lacey Township",
        "X:WELLESLEY RD / AMHERST RD",
        "ID:174713",
        "CALL:Fall Victim",
        "PRI:Medium",
        "DATE:10/03/2012",
        "TIME:00:55:39",
        "UNIT:SQ26");

    doTest("T8",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~99~SHEFFIELD~DR~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "No Cross Streets Found\r\n" +
        "Quadrant:~ST60\r\n" +
        "District:~SQ23\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174582\r\n" +
        "Call Type:~ Fall Victim\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ Medium\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/02/2012 19:48:18\r\n" +
        "Dispatch Date/Time:~10/02/2012 19:55:22\r\n" +
        "Arrive Date/Time:~10/02/2012 20:09:49\r\n" +
        "Clear Date/Time:~10/02/2012 21:36:03\r\n" +
        "Enroute Date/Time:~10/02/2012 19:58:37\r\n" +
        "Latest Unit Cleared Date/Time:~10/02/2012 21:36:01\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00002181~~Lacey Twp EMS\r\n" +
        "2012-00001474~~Lanoka Harbor EMS\r\n" +
        "2012-00001366~~Waretown EMS\r\n" +
        "~\r\n" +
        "Units Sent:~5\r\n" +
        "SQ42, E427, SQ26, E235, SQ23~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/02/12 19:48:34~Nature Of Call: 56 yom leg inj\r\n" +
        "\r\n",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~99~SHEFFIELD~DR~\nVenue:~Lacey Township\nCross Streets~\nNo Cross Streets Found\nQuadrant:~ST60\nDistrict:~SQ23\n~\nCall Information:\n\nCall Number:~174582\nCall Type:~ Fall Victim\nSource:~Telephone\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~10/02/2012 19:48:18\nDispatch Date/Time:~10/02/2012 19:55:22\nArrive Date/Time:~10/02/2012 20:09:49\nClear Date/Time:~10/02/2012 21:36:03\nEnroute Date/Time:~10/02/2012 19:58:37\nLatest Unit Cleared Date/Time:~10/02/2012 21:36:01\n~\nIncident Number(s)\n2012-00002181~~Lacey Twp EMS\n2012-00001474~~Lanoka Harbor EMS\n2012-00001366~~Waretown EMS\n~\nUnits Sent:~5\nSQ42, E427, SQ26, E235, SQ23~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/02/12 19:48:34~Nature Of Call: 56 yom leg inj",
        "CALL:RUN REPORT");

    doTest("T9",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~1208~BULLARD~AVE~\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "OLDS ST / S LAKESIDE DR\r\n" +
        "Quadrant:~ST60\r\n" +
        "District:~SQ23\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174558\r\n" +
        "Call Type:~ Seizures\r\n" +
        "Source:~911\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/02/2012 19:15:50\r\n" +
        "Dispatch Date/Time:~10/02/2012 19:16:49\r\n" +
        "Arrive Date/Time:~10/02/2012 19:36:45\r\n" +
        "Clear Date/Time:~10/02/2012 20:52:49\r\n" +
        "Enroute Date/Time:~10/02/2012 19:29:29\r\n" +
        "Latest Unit Cleared Date/Time:~10/02/2012 20:52:45\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001003~~Dover-Brick Beach First Aid\r\n" +
        "2012-00002180~~Lacey Twp EMS\r\n" +
        "2012-00001472~~Lanoka Harbor EMS\r\n" +
        "2012-00014047~~Paid ALS\r\n" +
        "~\r\n" +
        "Units Sent:~7\r\n" +
        "E172, E712, SQ75, SQ26, E267, E265, SQ23~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/02/12 19:16:19~Nature Of Call: 47 yom\r\n" +
        "10/02/12 19:26:59~3rd req and sq26\r\n" +
        "\r\n",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~1208~BULLARD~AVE~\nVenue:~Lacey Township\nCross Streets~\nOLDS ST / S LAKESIDE DR\nQuadrant:~ST60\nDistrict:~SQ23\n~\nCall Information:\n\nCall Number:~174558\nCall Type:~ Seizures\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~10/02/2012 19:15:50\nDispatch Date/Time:~10/02/2012 19:16:49\nArrive Date/Time:~10/02/2012 19:36:45\nClear Date/Time:~10/02/2012 20:52:49\nEnroute Date/Time:~10/02/2012 19:29:29\nLatest Unit Cleared Date/Time:~10/02/2012 20:52:45\n~\nIncident Number(s)\n2012-00001003~~Dover-Brick Beach First Aid\n2012-00002180~~Lacey Twp EMS\n2012-00001472~~Lanoka Harbor EMS\n2012-00014047~~Paid ALS\n~\nUnits Sent:~7\nE172, E712, SQ75, SQ26, E267, E265, SQ23~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/02/12 19:16:19~Nature Of Call: 47 yom\n10/02/12 19:26:59~3rd req and sq26",
        "CALL:RUN REPORT");

    doTest("T10",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~305~MANCHESTER~AVE~\r\n" +
        "Common Name:~SQ26\r\n" +
        "Venue:~Lacey Township\r\n" +
        "Cross Streets~\r\n" +
        "QUAIL HILL DR / LAKE BARNEGAT DR\r\n" +
        "Quadrant:~ST61\r\n" +
        "District:~SQ26\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~174575\r\n" +
        "Call Type:~ EMS Call\r\n" +
        "Source:~Telephone\r\n" +
        "Priority:~ High\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~10/02/2012 19:39:34\r\n" +
        "Dispatch Date/Time:~10/02/2012 19:39:48\r\n" +
        "Arrive Date/Time:~10/02/2012 19:39:57\r\n" +
        "Clear Date/Time:~10/02/2012 20:23:34\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~10/02/2012 20:23:31\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00001473~~Lanoka Harbor EMS\r\n" +
        "~\r\n" +
        "Units Sent:~1\r\n" +
        "E269~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "\r\n",

        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~305~MANCHESTER~AVE~\nCommon Name:~SQ26\nVenue:~Lacey Township\nCross Streets~\nQUAIL HILL DR / LAKE BARNEGAT DR\nQuadrant:~ST61\nDistrict:~SQ26\n~\nCall Information:\n\nCall Number:~174575\nCall Type:~ EMS Call\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~10/02/2012 19:39:34\nDispatch Date/Time:~10/02/2012 19:39:48\nArrive Date/Time:~10/02/2012 19:39:57\nClear Date/Time:~10/02/2012 20:23:34\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~10/02/2012 20:23:31\n~\nIncident Number(s)\n2012-00001473~~Lanoka Harbor EMS\n~\nUnits Sent:~1\nE269~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative",
        "CALL:RUN REPORT");

  }
  
  @Test
  public void testLaceyTwpUnderwaterRescueRecoveryTeam() {

    doTest("T1",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1032~ORLANDO~DR~\n" +
        "Venue:~Lacey Township\n" +
        "Cross Streets~\n" +
        "CLUBHOUSE DR / ALBATROSS CT\n" +
        "Quadrant:~ST60\n" +
        "District:~SQ23\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~25132\n" +
        "Call Type:~ Animal Call\n" +
        "Source:~911\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~02/01/2013 13:55:31\n" +
        "Dispatch Date/Time:~02/01/2013 14:01:13\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "ST61, SQ47, ST60~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "02/01/13 13:56:53~Nature Of Call: dog in the lagoon, pd already aware and have called aco\n" +
        "02/01/13 13:59:03~per pd see if fd will assist",

        "SRC:ST60-SQ23",
        "ADDR:1032 ORLANDO DR",
        "CITY:Lacey Township",
        "X:CLUBHOUSE DR / ALBATROSS CT",
        "ID:25132",
        "CALL:Animal Call",
        "PRI:Administrative",
        "DATE:02/01/2013",
        "TIME:14:01:13",
        "UNIT:ST61, SQ47, ST60",
        "INFO:Nature Of Call: dog in the lagoon, pd already aware and have called aco / per pd see if fd will assist");

    doTest("T2",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~2~WARREN~AVE~\n" +
        "Common Name:~SQ47\n" +
        "Venue:~Lacey Township\n" +
        "Cross Streets~\n" +
        "N MAIN ST / CAROLYN CT\n" +
        "Quadrant:~ST61\n" +
        "District:~SQ26\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~13778\n" +
        "Call Type:~ Testing\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~Not In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~01/18/2013 14:47:02\n" +
        "Dispatch Date/Time:~01/18/2013 14:47:26\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ47~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "01/18/13 14:47:14~Nature Of Call: testing text paging",

        "SRC:ST61-SQ26",
        "ADDR:2 WARREN AVE",
        "PLACE:SQ47",
        "CITY:Lacey Township",
        "X:N MAIN ST / CAROLYN CT",
        "ID:13778",
        "CALL:Testing",
        "PRI:Administrative",
        "DATE:01/18/2013",
        "TIME:14:47:26",
        "UNIT:SQ47",
        "INFO:Nature Of Call: testing text paging");

  }
  
  @Test
  public void testNewEgyptEmergencySquad() {

    doTest("T1",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~320 STAGE COACH RD~\n" +
        "Venue:~Millstone Township\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~107109\n" +
        "Call Type:~ Unconsious\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 12:54:43\n" +
        "Dispatch Date/Time:~05/15/2013 12:55:55\n" +
        "Arrive Date/Time:~05/15/2013 13:13:20\n" +
        "Clear Date/Time:~05/15/2013 14:16:13\n" +
        "Enroute Date/Time:~05/15/2013 12:57:56\n" +
        "Latest Unit Cleared Date/Time:~05/15/2013 14:16:13\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000502~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "SQ30, E307~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/15/13 12:55:06~Nature Of Call: 58 yof sycopal\n" +
        "05/15/13 12:57:22~no cross street",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~320 STAGE COACH RD~\nVenue:~Millstone Township\nCross Streets~\n~\nCall Information:\n\nCall Number:~107109\nCall Type:~ Unconsious\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 12:54:43\nDispatch Date/Time:~05/15/2013 12:55:55\nArrive Date/Time:~05/15/2013 13:13:20\nClear Date/Time:~05/15/2013 14:16:13\nEnroute Date/Time:~05/15/2013 12:57:56\nLatest Unit Cleared Date/Time:~05/15/2013 14:16:13\n~\nIncident Number(s)\n2013-00000502~~New Egypt EMS\n~\nUnits Sent:~2\nSQ30, E307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 12:55:06~Nature Of Call: 58 yof sycopal\n05/15/13 12:57:22~no cross street");

    doTest("T2",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~<UNKNOWN>~\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~107109\n" +
        "Call Type:~ Unconsious\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 12:54:43\n" +
        "Dispatch Date/Time:~05/15/2013 12:55:55\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000502~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/15/13 12:55:06~Nature Of Call: 58 yof sycopal",

        "ADDR:<UNKNOWN>",
        "INFO:Nature Of Call: 58 yof sycopal",
        "ID:107109",
        "CALL:Unconsious",
        "PRI:High",
        "DATE:05/15/2013",
        "TIME:12:55:55",
        "UNIT:SQ30");

    doTest("T3",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~8~ROYAL OAK~DR~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "GREENWAY DR\n" +
        " EDGEWOOD DR\n" +
        " TANGLEWOOD DR / TANGLEWOOD DR\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106875\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 05:43:17\n" +
        "Dispatch Date/Time:~05/15/2013 05:44:34\n" +
        "Arrive Date/Time:~05/15/2013 05:53:05\n" +
        "Clear Date/Time:~05/15/2013 07:10:27\n" +
        "Enroute Date/Time:~05/15/2013 05:45:01\n" +
        "Latest Unit Cleared Date/Time:~05/15/2013 07:10:22\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000501~~New Egypt EMS\n" +
        "2013-00009083~~Paid ALS\n" +
        "2013-00001724~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~5\n" +
        "E711, SQ75, SQ30, E307, 23-01~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/15/13 05:45:18~NICOLE\n" +
        "05/15/13 05:53:23~SQ30\n" +
        "05/15/13 06:08:52~MEETING ALS LINE OF SITE OUT OF BURL/ALREADY SPEAKING W\n" +
        "05/15/13 06:15:02~307 OUT WITH ALS",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~8~ROYAL OAK~DR~\nVenue:~Plumsted Township\nCross Streets~\nGREENWAY DR\n EDGEWOOD DR\n TANGLEWOOD DR / TANGLEWOOD DR\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106875\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:43:17\nDispatch Date/Time:~05/15/2013 05:44:34\nArrive Date/Time:~05/15/2013 05:53:05\nClear Date/Time:~05/15/2013 07:10:27\nEnroute Date/Time:~05/15/2013 05:45:01\nLatest Unit Cleared Date/Time:~05/15/2013 07:10:22\n~\nIncident Number(s)\n2013-00000501~~New Egypt EMS\n2013-00009083~~Paid ALS\n2013-00001724~~Plumsted Police Department\n~\nUnits Sent:~5\nE711, SQ75, SQ30, E307, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 05:45:18~NICOLE\n05/15/13 05:53:23~SQ30\n05/15/13 06:08:52~MEETING ALS LINE OF SITE OUT OF BURL/ALREADY SPEAKING W\n05/15/13 06:15:02~307 OUT WITH ALS");

    doTest("T4",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~188~BRYNMORE~RD~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "CARTER LN / ARCHERTOWN RD\n" +
        " W COLLIERS MILL RD\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106868\n" +
        "Call Type:~ General Weakness\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 05:00:45\n" +
        "Dispatch Date/Time:~05/15/2013 05:03:35\n" +
        "Arrive Date/Time:~05/15/2013 05:10:10\n" +
        "Clear Date/Time:~05/15/2013 06:21:26\n" +
        "Enroute Date/Time:~05/15/2013 05:04:08\n" +
        "Latest Unit Cleared Date/Time:~05/15/2013 06:21:16\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000500~~New Egypt EMS\n" +
        "2013-00001723~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~5\n" +
        "SQ30, E309, 23-06, 23-04, 23-01~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/15/13 05:01:30~Nature Of Call: 68 YOF\n" +
        "05/15/13 05:02:12~Nature Of Call: 68 YOF POSS DEH",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~188~BRYNMORE~RD~\nVenue:~Plumsted Township\nCross Streets~\nCARTER LN / ARCHERTOWN RD\n W COLLIERS MILL RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~106868\nCall Type:~ General Weakness\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/15/2013 05:00:45\nDispatch Date/Time:~05/15/2013 05:03:35\nArrive Date/Time:~05/15/2013 05:10:10\nClear Date/Time:~05/15/2013 06:21:26\nEnroute Date/Time:~05/15/2013 05:04:08\nLatest Unit Cleared Date/Time:~05/15/2013 06:21:16\n~\nIncident Number(s)\n2013-00000500~~New Egypt EMS\n2013-00001723~~Plumsted Police Department\n~\nUnits Sent:~5\nSQ30, E309, 23-06, 23-04, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/15/13 05:01:30~Nature Of Call: 68 YOF\n05/15/13 05:02:12~Nature Of Call: 68 YOF POSS DEH");

    doTest("T5",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~8~ROYAL OAK~DR~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "GREENWAY DR\n" +
        " EDGEWOOD DR\n" +
        " TANGLEWOOD DR / TANGLEWOOD DR\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106875\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 05:43:17\n" +
        "Dispatch Date/Time:~05/15/2013 05:44:34\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000501~~New Egypt EMS\n" +
        "2013-00009083~~Paid ALS\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "SQ75, SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "SRC:ST39-SQ30",
        "ADDR:8 ROYAL OAK DR",
        "CITY:Plumsted Township",
        "X:GREENWAY DR",
        "ID:106875",
        "CALL:Chest Pain",
        "PRI:High",
        "DATE:05/15/2013",
        "TIME:05:44:34",
        "UNIT:SQ75, SQ30");

    doTest("T6",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~188~BRYNMORE~RD~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "CARTER LN / ARCHERTOWN RD\n" +
        " W COLLIERS MILL RD\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106868\n" +
        "Call Type:~ General Weakness\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/15/2013 05:00:45\n" +
        "Dispatch Date/Time:~05/15/2013 05:03:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000500~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/15/13 05:01:30~Nature Of Call: 68 YOF\n" +
        "05/15/13 05:02:12~Nature Of Call: 68 YOF POSS DEH",

        "SRC:ST39-SQ30",
        "ADDR:188 BRYNMORE RD",
        "CITY:Plumsted Township",
        "X:CARTER LN / ARCHERTOWN RD",
        "ID:106868",
        "CALL:General Weakness",
        "PRI:Medium",
        "DATE:05/15/2013",
        "TIME:05:03:35",
        "UNIT:SQ30",
        "INFO:Nature Of Call: 68 YOF / Nature Of Call: 68 YOF POSS DEH");

    doTest("T7",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~HAWKIN~RD/~KENYON~DR\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ22\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106741\n" +
        "Call Type:~ Brush Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 20:49:08\n" +
        "Dispatch Date/Time:~05/14/2013 20:51:34\n" +
        "Arrive Date/Time:~05/14/2013 20:56:15\n" +
        "Clear Date/Time:~05/14/2013 21:42:15\n" +
        "Enroute Date/Time:~05/14/2013 20:52:08\n" +
        "Latest Unit Cleared Date/Time:~05/14/2013 21:42:13\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000654~~Jackson Twp EMS\n" +
        "2013-00000499~~New Egypt EMS\n" +
        "2013-00000225~~New Egypt Fire Company\n" +
        "2013-00000103~~NJ Forest Fire Service\n" +
        "2013-00001721~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~10\n" +
        "ST39, B17, B9, SQ30, E309, 23-04, 23-01, F3909, F3910, F3900~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 20:51:26~POSS CONTROLLED BURN FIRE SIDE CHECKING\n" +
        "05/14/13 20:51:29~SMOKE IN AREA\n" +
        "05/14/13 20:56:04~B9 ADVISED\n" +
        "05/14/13 21:04:28~CP CALLING FROM HOME AT 5 KENYON DR, PLUMSTED\n" +
        "05/14/13 21:05:35~PER F3900 IS A SLIGHT SMELL OF SMOKE IN THE AREA\n" +
        "05/14/13 21:09:50~PER F3900 SLIGHT SMELL OF SMOKE STILL IN THE ARE POSSIBLY FROM SOMEONES BACKYARD HOWEVER UNFOUNDED AT THIS TIME\n" +
        "05/14/13 21:09:58~F3900 RETURNING UNITS",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~~HAWKIN~RD/~KENYON~DR\nVenue:~Plumsted Township\nCross Streets~\nQuadrant:~ST39\nDistrict:~SQ22\n~\nCall Information:\n\nCall Number:~106741\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 20:49:08\nDispatch Date/Time:~05/14/2013 20:51:34\nArrive Date/Time:~05/14/2013 20:56:15\nClear Date/Time:~05/14/2013 21:42:15\nEnroute Date/Time:~05/14/2013 20:52:08\nLatest Unit Cleared Date/Time:~05/14/2013 21:42:13\n~\nIncident Number(s)\n2013-00000654~~Jackson Twp EMS\n2013-00000499~~New Egypt EMS\n2013-00000225~~New Egypt Fire Company\n2013-00000103~~NJ Forest Fire Service\n2013-00001721~~Plumsted Police Department\n~\nUnits Sent:~10\nST39, B17, B9, SQ30, E309, 23-04, 23-01, F3909, F3910, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 20:51:26~POSS CONTROLLED BURN FIRE SIDE CHECKING\n05/14/13 20:51:29~SMOKE IN AREA\n05/14/13 20:56:04~B9 ADVISED\n05/14/13 21:04:28~CP CALLING FROM HOME AT 5 KENYON DR, PLUMSTED\n05/14/13 21:05:35~PER F3900 IS A SLIGHT SMELL OF SMOKE IN THE AREA\n05/14/13 21:09:50~PER F3900 SLIGHT SMELL OF SMOKE STILL IN THE ARE POSSIBLY FROM SOMEONES BACKYARD HOWEVER UNFOUNDED AT THIS TIME\n05/14/13 21:09:58~F3900 RETURNING UNITS");

    doTest("T8",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~HAWKIN~RD/~KENYON~DR\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ22\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106741\n" +
        "Call Type:~ Brush Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 20:49:08\n" +
        "Dispatch Date/Time:~05/14/2013 20:51:34\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000499~~New Egypt EMS\n" +
        "2013-00000225~~New Egypt Fire Company\n" +
        "2013-00001721~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "ST39, SQ30, 23-01~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 20:51:26~POSS CONTROLLED BURN FIRE SIDE CHECKING\n" +
        "05/14/13 20:51:29~SMOKE IN AREA",

        "SRC:ST39-SQ22",
        "ADDR:HAWKIN RD & KENYON DR",
        "CITY:Plumsted Township",
        "ID:106741",
        "CALL:Brush Fire",
        "PRI:High",
        "DATE:05/14/2013",
        "TIME:20:51:34",
        "UNIT:ST39, SQ30, 23-01",
        "INFO:POSS CONTROLLED BURN FIRE SIDE CHECKING / SMOKE IN AREA");

    doTest("T9",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~QUALITY INN~\n" +
        "Venue:~New Hanover Twp\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106605\n" +
        "Call Type:~ MVC\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 17:00:20\n" +
        "Dispatch Date/Time:~05/14/2013 17:03:35\n" +
        "Arrive Date/Time:~05/14/2013 17:05:15\n" +
        "Clear Date/Time:~05/14/2013 19:42:29\n" +
        "Enroute Date/Time:~05/14/2013 17:03:38\n" +
        "Latest Unit Cleared Date/Time:~05/14/2013 19:42:29\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000498~~New Egypt EMS\n" +
        "2013-00000224~~New Egypt Fire Company\n" +
        "2013-00001720~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~5\n" +
        "SQ30, E307, 23-01, F3902, F3900~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 17:02:11~Nature Of Call: 3 inj",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~QUALITY INN~\nVenue:~New Hanover Twp\nCross Streets~\n~\nCall Information:\n\nCall Number:~106605\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 17:00:20\nDispatch Date/Time:~05/14/2013 17:03:35\nArrive Date/Time:~05/14/2013 17:05:15\nClear Date/Time:~05/14/2013 19:42:29\nEnroute Date/Time:~05/14/2013 17:03:38\nLatest Unit Cleared Date/Time:~05/14/2013 19:42:29\n~\nIncident Number(s)\n2013-00000498~~New Egypt EMS\n2013-00000224~~New Egypt Fire Company\n2013-00001720~~Plumsted Police Department\n~\nUnits Sent:~5\nSQ30, E307, 23-01, F3902, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 17:02:11~Nature Of Call: 3 inj");

    doTest("T10",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~620~OCEAN~RD~\n" +
        "Common Name:~QUALITY INN - POINT BORO @ 88/DALLAS\n" +
        "Venue:~Point Pleasant Boro\n" +
        "Cross Streets~\n" +
        "MADISON ST / DALLAS ST\n" +
        " FR RT 88 EB TO RT 35 NB\n" +
        "Quadrant:~ST75\n" +
        "District:~SQ35\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106605\n" +
        "Call Type:~ MVC\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 17:00:20\n" +
        "Dispatch Date/Time:~05/14/2013 17:03:35\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~05/14/2013 17:03:38\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000498~~New Egypt EMS\n" +
        "2013-00000224~~New Egypt Fire Company\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "E307, F3902, F3900~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 17:02:11~Nature Of Call: 3 inj",

        "SRC:ST75-SQ35",
        "ADDR:620 OCEAN RD",
        "PLACE:QUALITY INN - POINT BORO @ 88/DALLAS",
        "CITY:Point Pleasant",
        "X:MADISON ST / DALLAS ST",
        "ID:106605",
        "CALL:MVC",
        "PRI:High",
        "DATE:05/14/2013",
        "TIME:17:03:35",
        "UNIT:E307, F3902, F3900",
        "INFO:Nature Of Call: 3 inj");

    doTest("T11",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~374~MEANY~RD~\n" +
        "Venue:~North Hanover\n" +
        "Cross Streets~\n" +
        "No Cross Streets Found\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106556\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 15:44:57\n" +
        "Dispatch Date/Time:~05/14/2013 15:45:50\n" +
        "Arrive Date/Time:~05/14/2013 15:49:37\n" +
        "Clear Date/Time:~05/14/2013 16:33:13\n" +
        "Enroute Date/Time:~05/14/2013 15:45:53\n" +
        "Latest Unit Cleared Date/Time:~05/14/2013 16:33:11\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000497~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "E307~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 15:46:33~E307 SIGNING ON WITH BURL CO WHILE ON THE PHONE WITH US",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~374~MEANY~RD~\nVenue:~North Hanover\nCross Streets~\nNo Cross Streets Found\n~\nCall Information:\n\nCall Number:~106556\nCall Type:~ Chest Pain\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 15:44:57\nDispatch Date/Time:~05/14/2013 15:45:50\nArrive Date/Time:~05/14/2013 15:49:37\nClear Date/Time:~05/14/2013 16:33:13\nEnroute Date/Time:~05/14/2013 15:45:53\nLatest Unit Cleared Date/Time:~05/14/2013 16:33:11\n~\nIncident Number(s)\n2013-00000497~~New Egypt EMS\n~\nUnits Sent:~1\nE307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 15:46:33~E307 SIGNING ON WITH BURL CO WHILE ON THE PHONE WITH US");

    doTest("T12",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~374 MEANIE RD~\n" +
        "Venue:~Morris Co. - Non Specifc\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106556\n" +
        "Call Type:~ >New<\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 15:44:57\n" +
        "Dispatch Date/Time:~05/14/2013 15:45:50\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "E307~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "ADDR:374 MEANIE RD",
        "CITY:Morris Co",
        "ID:106556",
        "CALL:>New<",
        "PRI:Administrative",
        "DATE:05/14/2013",
        "TIME:15:45:50",
        "UNIT:E307");

    doTest("T13",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~RT 537/MEANY RD~\n" +
        "Venue:~North Hanover\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106505\n" +
        "Call Type:~ MVC W/Injuries\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 14:47:16\n" +
        "Dispatch Date/Time:~05/14/2013 14:48:30\n" +
        "Arrive Date/Time:~05/14/2013 14:51:12\n" +
        "Clear Date/Time:~05/14/2013 15:20:32\n" +
        "Enroute Date/Time:~05/14/2013 14:48:50\n" +
        "Latest Unit Cleared Date/Time:~05/14/2013 15:20:32\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000496~~New Egypt EMS\n" +
        "2013-00000223~~New Egypt Fire Company\n" +
        "~\n" +
        "Units Sent:~7\n" +
        "ST39, SQ30, E307, E300, F3902, F3911, F3900~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 14:47:21~Nature Of Call: 30 AND 29\n" +
        "05/14/13 14:53:12~Nature Of Call: 30 AND 39",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~RT 537/MEANY RD~\nVenue:~North Hanover\nCross Streets~\n~\nCall Information:\n\nCall Number:~106505\nCall Type:~ MVC W/Injuries\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/14/2013 14:47:16\nDispatch Date/Time:~05/14/2013 14:48:30\nArrive Date/Time:~05/14/2013 14:51:12\nClear Date/Time:~05/14/2013 15:20:32\nEnroute Date/Time:~05/14/2013 14:48:50\nLatest Unit Cleared Date/Time:~05/14/2013 15:20:32\n~\nIncident Number(s)\n2013-00000496~~New Egypt EMS\n2013-00000223~~New Egypt Fire Company\n~\nUnits Sent:~7\nST39, SQ30, E307, E300, F3902, F3911, F3900~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/14/13 14:47:21~Nature Of Call: 30 AND 29\n05/14/13 14:53:12~Nature Of Call: 30 AND 39");

    doTest("T14",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~<UNKNOWN>~\n" +
        "Cross Streets~\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~106505\n" +
        "Call Type:~ >New<\n" +
        "Source:~Telephone\n" +
        "Priority:~ Administrative\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/14/2013 14:47:16\n" +
        "Dispatch Date/Time:~05/14/2013 14:48:30\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/14/13 14:47:21~Nature Of Call: 30 AND 29",

        "ADDR:<UNKNOWN>",
        "INFO:Nature Of Call: 30 AND 29",
        "ID:106505",
        "CALL:>New<",
        "PRI:Administrative",
        "DATE:05/14/2013",
        "TIME:14:48:30",
        "UNIT:SQ30");

    doTest("T15",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~194~JACOBSTOWN - NEW EGYPT~RD~lot 74\n" +
        "Common Name:~Deep Well Trailer Park - North Hanover\n" +
        "Venue:~North Hanover\n" +
        "Cross Streets~\n" +
        "MEANY RD / RT 537\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105833\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/13/2013 16:19:10\n" +
        "Dispatch Date/Time:~05/13/2013 16:19:42\n" +
        "Arrive Date/Time:~05/13/2013 16:24:54\n" +
        "Clear Date/Time:~05/13/2013 17:50:53\n" +
        "Enroute Date/Time:~05/13/2013 16:21:47\n" +
        "Latest Unit Cleared Date/Time:~05/13/2013 17:50:46\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000495~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "SQ30, E306~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/13/13 16:19:37~Nature Of Call: 82yom chest pains",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~194~JACOBSTOWN - NEW EGYPT~RD~lot 74\nCommon Name:~Deep Well Trailer Park - North Hanover\nVenue:~North Hanover\nCross Streets~\nMEANY RD / RT 537\n~\nCall Information:\n\nCall Number:~105833\nCall Type:~ Chest Pain\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/13/2013 16:19:10\nDispatch Date/Time:~05/13/2013 16:19:42\nArrive Date/Time:~05/13/2013 16:24:54\nClear Date/Time:~05/13/2013 17:50:53\nEnroute Date/Time:~05/13/2013 16:21:47\nLatest Unit Cleared Date/Time:~05/13/2013 17:50:46\n~\nIncident Number(s)\n2013-00000495~~New Egypt EMS\n~\nUnits Sent:~2\nSQ30, E306~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/13/13 16:19:37~Nature Of Call: 82yom chest pains");

    doTest("T16",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~194~JACOBSTOWN - NEW EGYPT~RD~lot 74\n" +
        "Common Name:~Deep Well Trailer Park - North Hanover\n" +
        "Venue:~North Hanover\n" +
        "Cross Streets~\n" +
        "MEANY RD / RT 537\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105833\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/13/2013 16:19:10\n" +
        "Dispatch Date/Time:~05/13/2013 16:19:42\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000495~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/13/13 16:19:37~Nature Of Call: 82yom chest pains",

        "ADDR:194 JACOBSTOWN - NEW EGYPT RD",
        "APT:74",
        "PLACE:Deep Well Trailer Park - North Hanover",
        "CITY:North Hanover",
        "X:MEANY RD / RT 537",
        "ID:105833",
        "CALL:Chest Pain",
        "PRI:High",
        "DATE:05/13/2013",
        "TIME:16:19:42",
        "UNIT:SQ30",
        "INFO:Nature Of Call: 82yom chest pains");

    doTest("T17",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~131~BRINDLETOWN~RD~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "OAK LN / BUNTING BRIDGE RD\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105372\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/12/2013 23:56:48\n" +
        "Dispatch Date/Time:~05/12/2013 23:57:23\n" +
        "Arrive Date/Time:~05/13/2013 00:01:13\n" +
        "Clear Date/Time:~05/13/2013 00:50:06\n" +
        "Enroute Date/Time:~05/12/2013 23:57:41\n" +
        "Latest Unit Cleared Date/Time:~05/13/2013 00:49:56\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000494~~New Egypt EMS\n" +
        "2013-00008949~~Paid ALS\n" +
        "2013-00001702~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "E754, E711, SQ75, SQ30, E309, 23-01~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/12/13 23:57:11~Nature Of Call: 52YOF  BREATHING OK",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~131~BRINDLETOWN~RD~\nVenue:~Plumsted Township\nCross Streets~\nOAK LN / BUNTING BRIDGE RD\nQuadrant:~ST39\nDistrict:~SQ30\n~\nCall Information:\n\nCall Number:~105372\nCall Type:~ Chest Pain\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 23:56:48\nDispatch Date/Time:~05/12/2013 23:57:23\nArrive Date/Time:~05/13/2013 00:01:13\nClear Date/Time:~05/13/2013 00:50:06\nEnroute Date/Time:~05/12/2013 23:57:41\nLatest Unit Cleared Date/Time:~05/13/2013 00:49:56\n~\nIncident Number(s)\n2013-00000494~~New Egypt EMS\n2013-00008949~~Paid ALS\n2013-00001702~~Plumsted Police Department\n~\nUnits Sent:~6\nE754, E711, SQ75, SQ30, E309, 23-01~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/12/13 23:57:11~Nature Of Call: 52YOF  BREATHING OK");

    doTest("T18",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~131~BRINDLETOWN~RD~\n" +
        "Venue:~Plumsted Township\n" +
        "Cross Streets~\n" +
        "OAK LN / BUNTING BRIDGE RD\n" +
        "Quadrant:~ST39\n" +
        "District:~SQ30\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105372\n" +
        "Call Type:~ Chest Pain\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/12/2013 23:56:48\n" +
        "Dispatch Date/Time:~05/12/2013 23:57:23\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~05/12/2013 23:57:41\n" +
        "Latest Unit Cleared Date/Time:~05/12/2013 23:59:03\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000494~~New Egypt EMS\n" +
        "2013-00008949~~Paid ALS\n" +
        "2013-00001702~~Plumsted Police Department\n" +
        "~\n" +
        "Units Sent:~4\n" +
        "E754, SQ75, SQ30, 23-01~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/12/13 23:57:11~Nature Of Call: 52YOF  BREATHING OK",

        "SRC:ST39-SQ30",
        "ADDR:131 BRINDLETOWN RD",
        "CITY:Plumsted Township",
        "X:OAK LN / BUNTING BRIDGE RD",
        "ID:105372",
        "CALL:Chest Pain",
        "PRI:High",
        "DATE:05/12/2013",
        "TIME:23:57:23",
        "UNIT:E754, SQ75, SQ30, 23-01",
        "INFO:Nature Of Call: 52YOF  BREATHING OK");

    doTest("T19",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~534~MONMOUTH~RD~\n" +
        "Common Name:~Burger King - Millstone\n" +
        "Venue:~Millstone Township\n" +
        "Cross Streets~\n" +
        "ANDERSON RD / W COMMODORE BLVD\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105300\n" +
        "Call Type:~ MVC\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/12/2013 21:19:19\n" +
        "Dispatch Date/Time:~05/12/2013 21:19:47\n" +
        "Arrive Date/Time:~05/12/2013 21:33:29\n" +
        "Clear Date/Time:~05/12/2013 22:31:28\n" +
        "Enroute Date/Time:~05/12/2013 21:21:04\n" +
        "Latest Unit Cleared Date/Time:~05/12/2013 22:31:24\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000493~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~3\n" +
        "SQ30, E309, E307~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/12/13 21:21:44~PER MONMOUTH CO REQ A 2ND RIG\n" +
        "05/12/13 21:22:01~needs 2 rigs\n" +
        "05/12/13 21:25:20~PER MONMOUTH CO NO MORE RIGS NEEDED\n" +
        "05/12/13 21:25:33~307 ADVISWED",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~534~MONMOUTH~RD~\nCommon Name:~Burger King - Millstone\nVenue:~Millstone Township\nCross Streets~\nANDERSON RD / W COMMODORE BLVD\n~\nCall Information:\n\nCall Number:~105300\nCall Type:~ MVC\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/12/2013 21:19:19\nDispatch Date/Time:~05/12/2013 21:19:47\nArrive Date/Time:~05/12/2013 21:33:29\nClear Date/Time:~05/12/2013 22:31:28\nEnroute Date/Time:~05/12/2013 21:21:04\nLatest Unit Cleared Date/Time:~05/12/2013 22:31:24\n~\nIncident Number(s)\n2013-00000493~~New Egypt EMS\n~\nUnits Sent:~3\nSQ30, E309, E307~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/12/13 21:21:44~PER MONMOUTH CO REQ A 2ND RIG\n05/12/13 21:22:01~needs 2 rigs\n05/12/13 21:25:20~PER MONMOUTH CO NO MORE RIGS NEEDED\n05/12/13 21:25:33~307 ADVISWED");

    doTest("T20",
        "(Sq-30) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~534~MONMOUTH~RD~\n" +
        "Common Name:~Burger King - Millstone\n" +
        "Venue:~Millstone Township\n" +
        "Cross Streets~\n" +
        "ANDERSON RD / W COMMODORE BLVD\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~105300\n" +
        "Call Type:~ MVC\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/12/2013 21:19:19\n" +
        "Dispatch Date/Time:~05/12/2013 21:19:47\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000493~~New Egypt EMS\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "SQ30~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative",

        "ADDR:534 MONMOUTH RD",
        "PLACE:Burger King - Millstone",
        "CITY:Millstone Township",
        "X:ANDERSON RD / W COMMODORE BLVD",
        "ID:105300",
        "CALL:MVC",
        "PRI:High",
        "DATE:05/12/2013",
        "TIME:21:19:47",
        "UNIT:SQ30");
    
  }
  
  @Test
  public void testBarnegatFireCompany1() {

    doTest("T1",
        "{Rip and Run Report} Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~39.7818570383177000~-74.2437879777373000~\n" +
        "Common Name:~69.5 S GSP\n" +
        "Venue:~Garden State Parkway\n" +
        "Cross Streets~\n" +
        "GARDEN STATE PKWY S\n" +
        " FR CO 532 TO GSP SB / GARDEN STATE PKWY S\n" +
        " FR GSP SB TO CO 554\n" +
        "Quadrant:~ST11 Parkway\n" +
        "District:~SQ42\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~131642\n" +
        "Call Type:~ Overturned Vehicle\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/10/2013 10:11:12\n" +
        "Dispatch Date/Time:~06/10/2013 10:13:33\n" +
        "Arrive Date/Time:~06/10/2013 10:15:36\n" +
        "Clear Date/Time:~06/10/2013 11:03:12\n" +
        "Enroute Date/Time:~06/10/2013 10:15:48\n" +
        "Latest Unit Cleared Date/Time:~06/10/2013 11:03:12\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000190~~Barnegat Fire Department\n" +
        "2013-00001025~~Ocean County Prosecutors Office\n" +
        "2013-00010753~~Paid ALS\n" +
        "2013-00000281~~Waretown EMS\n" +
        "~\n" +
        "Units Sent:~8\n" +
        "ST11, E716, SQ75, SQ42, 35-104, F1131, F1110, F1100~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/10/13 10:12:04~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS\n" +
        "06/10/13 10:13:05~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ\n" +
        "06/10/13 10:13:15~PER PD START FIRE/EMS\n" +
        "06/10/13 10:13:32~OCNT NOTFD\n" +
        "06/10/13 10:14:35~BNGT NOTFD FOR FIRE\n" +
        "06/10/13 10:15:12~sarah\n" +
        "06/10/13 10:16:15~no inj per 35-140\n" +
        "06/10/13 10:20:35~1st truck on air only, reduced rate",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~39.7818570383177000~-74.2437879777373000~\nCommon Name:~69.5 S GSP\nVenue:~Garden State Parkway\nCross Streets~\nGARDEN STATE PKWY S\n FR CO 532 TO GSP SB / GARDEN STATE PKWY S\n FR GSP SB TO CO 554\nQuadrant:~ST11 Parkway\nDistrict:~SQ42\n~\nCall Information:\n\nCall Number:~131642\nCall Type:~ Overturned Vehicle\nSource:~911\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/10/2013 10:11:12\nDispatch Date/Time:~06/10/2013 10:13:33\nArrive Date/Time:~06/10/2013 10:15:36\nClear Date/Time:~06/10/2013 11:03:12\nEnroute Date/Time:~06/10/2013 10:15:48\nLatest Unit Cleared Date/Time:~06/10/2013 11:03:12\n~\nIncident Number(s)\n2013-00000190~~Barnegat Fire Department\n2013-00001025~~Ocean County Prosecutors Office\n2013-00010753~~Paid ALS\n2013-00000281~~Waretown EMS\n~\nUnits Sent:~8\nST11, E716, SQ75, SQ42, 35-104, F1131, F1110, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/10/13 10:12:04~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS\n06/10/13 10:13:05~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ\n06/10/13 10:13:15~PER PD START FIRE/EMS\n06/10/13 10:13:32~OCNT NOTFD\n06/10/13 10:14:35~BNGT NOTFD FOR FIRE\n06/10/13 10:15:12~sarah\n06/10/13 10:16:15~no inj per 35-140\n06/10/13 10:20:35~1st truck on air only, reduced rate");

    doTest("T2",
        "{Rip and Run Report} Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~39.7818570383177000~-74.2437879777373000~\n" +
        "Common Name:~69.5 S GSP\n" +
        "Venue:~Garden State Parkway\n" +
        "Cross Streets~\n" +
        "GARDEN STATE PKWY S\n" +
        " FR CO 532 TO GSP SB / GARDEN STATE PKWY S\n" +
        " FR GSP SB TO CO 554\n" +
        "Quadrant:~ST11 Parkway\n" +
        "District:~SQ42\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~131642\n" +
        "Call Type:~ Overturned Vehicle\n" +
        "Source:~911\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/10/2013 10:11:12\n" +
        "Dispatch Date/Time:~06/10/2013 10:13:33\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000190~~Barnegat Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "ST11~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/10/13 10:12:04~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS\n" +
        "06/10/13 10:13:05~Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ\n" +
        "06/10/13 10:13:15~PER PD START FIRE/EMS\n" +
        "06/10/13 10:13:32~OCNT NOTFD",

        "SRC:ST11 Parkway-SQ42",
        "ADDR:39.7818570383177000 -74.2437879777373000",
        "MADDR:+39.781857,-74.243788",
        "PLACE:69.5 S GSP",
        "CITY:Garden State Parkway",
        "X:GARDEN STATE PKWY S",
        "ID:131642",
        "CALL:Overturned Vehicle",
        "PRI:High",
        "DATE:06/10/2013",
        "TIME:10:13:33",
        "UNIT:ST11",
        "INFO:Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS / Nature Of Call: SILVER 4DR CAR/CAR IN THE WOODS/UNK EXT OF INJ / PER PD START FIRE/EMS / OCNT NOTFD");

    doTest("T3",
        "{Fwd: [OCSD] Rip and Run Report} \n\n\n" +
        "Begin forwarded message:\n\n" +
        "From: <Fire_Records>\n" +
        "Date: June 4, 2013, 18:34:03 EDT\n" +
        "To: <ocsd@station11.org>\n" +
        "Subject: [OCSD] Rip and Run Report\n" +
        "Reply-To: frank@station11.org\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~7~BALLAST~AVE~\n" +
        "Venue:~Barnegat Township\n" +
        "Cross Streets~\n" +
        "WATTS AVE / DEAD END\n" +
        "Quadrant:~ST11/ST12\n" +
        "District:~SQ11\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~126158\n" +
        "Call Type:~ Appliance Fire\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/04/2013 18:10:59\n" +
        "Dispatch Date/Time:~06/04/2013 18:12:11\n" +
        "Arrive Date/Time:~06/04/2013 18:19:30\n" +
        "Clear Date/Time:~06/04/2013 18:34:01\n" +
        "Enroute Date/Time:~06/04/2013 18:14:01\n" +
        "Latest Unit Cleared Date/Time:~06/04/2013 18:34:01\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000188~~Barnegat Fire Department\n" +
        "~\n" +
        "Units Sent:~5\n" +
        "F1115, ST11, F1141, F1110, F1100~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/04/13 18:11:53~Nature Of Call: GRILL FIRE\n\n\n" +
        "_______________________________________________\n" +
        "OCSD mailing list\n" +
        "OCSD@station11.org\n" +
        "http://station11.org/mailman/listinfo/ocsd_station11.org",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~7~BALLAST~AVE~\nVenue:~Barnegat Township\nCross Streets~\nWATTS AVE / DEAD END\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~126158\nCall Type:~ Appliance Fire\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/04/2013 18:10:59\nDispatch Date/Time:~06/04/2013 18:12:11\nArrive Date/Time:~06/04/2013 18:19:30\nClear Date/Time:~06/04/2013 18:34:01\nEnroute Date/Time:~06/04/2013 18:14:01\nLatest Unit Cleared Date/Time:~06/04/2013 18:34:01\n~\nIncident Number(s)\n2013-00000188~~Barnegat Fire Department\n~\nUnits Sent:~5\nF1115, ST11, F1141, F1110, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/04/13 18:11:53~Nature Of Call: GRILL FIRE\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org");

    doTest("T4",
        "{Fwd: [OCSD] Rip and Run Report} \n\n\n" +
        "Begin forwarded message:\n\n" +
        "From: <Fire_Records>\n" +
        "Date: June 2, 2013, 12:16:23 EDT\n" +
        "To: <ocsd@station11.org>\n" +
        "Subject: [OCSD] Rip and Run Report\n" +
        "Reply-To: frank@station11.org\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~973~W~BAY~AVE~\n" +
        "Common Name:~Bayside Chapel - Barnegat\n" +
        "Venue:~Barnegat Township\n" +
        "Cross Streets~\n" +
        "3RD ST / 4TH ST\n" +
        "Quadrant:~ST11/ST12\n" +
        "District:~SQ11\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~124582\n" +
        "Call Type:~ Brush Fire\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~06/02/2013 12:00:17\n" +
        "Dispatch Date/Time:~06/02/2013 12:00:52\n" +
        "Arrive Date/Time:~06/02/2013 12:08:16\n" +
        "Clear Date/Time:~06/02/2013 12:16:21\n" +
        "Enroute Date/Time:~06/02/2013 12:04:48\n" +
        "Latest Unit Cleared Date/Time:~06/02/2013 12:16:19\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000185~~Barnegat Fire Department\n" +
        "2013-00000117~~NJ Forest Fire Service\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "F1124, F1114, ST11, B5, F1131, F1112~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "06/02/13 12:00:37~Nature Of Call: MULCH FIRE\n" +
        "06/02/13 12:05:33~PER B5 ITS B4'S TERRITORY\n" +
        "06/02/13 12:07:01~PD PUTTING WATER ON IT\n" +
        "06/02/13 12:07:51~B4 - ASHLEY HOUSE VM LEFT ON HER CELL\n\n\n" +
        "_______________________________________________\n" +
        "OCSD mailing list\n" +
        "OCSD@station11.org\n" +
        "http://station11.org/mailman/listinfo/ocsd_station11.org",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~973~W~BAY~AVE~\nCommon Name:~Bayside Chapel - Barnegat\nVenue:~Barnegat Township\nCross Streets~\n3RD ST / 4TH ST\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~124582\nCall Type:~ Brush Fire\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~06/02/2013 12:00:17\nDispatch Date/Time:~06/02/2013 12:00:52\nArrive Date/Time:~06/02/2013 12:08:16\nClear Date/Time:~06/02/2013 12:16:21\nEnroute Date/Time:~06/02/2013 12:04:48\nLatest Unit Cleared Date/Time:~06/02/2013 12:16:19\n~\nIncident Number(s)\n2013-00000185~~Barnegat Fire Department\n2013-00000117~~NJ Forest Fire Service\n~\nUnits Sent:~6\nF1124, F1114, ST11, B5, F1131, F1112~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n06/02/13 12:00:37~Nature Of Call: MULCH FIRE\n06/02/13 12:05:33~PER B5 ITS B4'S TERRITORY\n06/02/13 12:07:01~PD PUTTING WATER ON IT\n06/02/13 12:07:51~B4 - ASHLEY HOUSE VM LEFT ON HER CELL\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org");

    doTest("T5",
        "{Fwd: [OCSD] Rip and Run Report} \n\n\n" +
        "Begin forwarded message:\n\n" +
        "From: <Fire_Records>\n" +
        "Date: May 7, 2013, 15:50:13 EDT\n" +
        "To: <ocsd@station11.org>\n" +
        "Subject: [OCSD] Rip and Run Report\n" +
        "Reply-To: frank@station11.org\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~919~W~BAY~AVE~\n" +
        "Common Name:~HERITAGE BAY - BARNEGAT\n" +
        "Venue:~Barnegat Township\n" +
        "Cross Streets~\n" +
        "FR GSP SB TO CO 554 / LIGHTHOUSE DR\n" +
        "Quadrant:~ST11/ST12\n" +
        "District:~SQ11\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~100563\n" +
        "Call Type:~ Special Response\n" +
        "Source:~Telephone\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/07/2013 12:41:48\n" +
        "Dispatch Date/Time:~05/07/2013 12:42:12\n" +
        "Arrive Date/Time:~05/07/2013 12:42:15\n" +
        "Clear Date/Time:~05/07/2013 15:50:12\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~05/07/2013 15:50:06\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000157~~Barnegat Fire Department\n" +
        "~\n" +
        "Units Sent:~1\n" +
        "F1115~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n\n\n" +
        "_______________________________________________\n" +
        "OCSD mailing list\n" +
        "OCSD@station11.org\n" +
        "http://station11.org/mailman/listinfo/ocsd_station11.org",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~919~W~BAY~AVE~\nCommon Name:~HERITAGE BAY - BARNEGAT\nVenue:~Barnegat Township\nCross Streets~\nFR GSP SB TO CO 554 / LIGHTHOUSE DR\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~100563\nCall Type:~ Special Response\nSource:~Telephone\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/07/2013 12:41:48\nDispatch Date/Time:~05/07/2013 12:42:12\nArrive Date/Time:~05/07/2013 12:42:15\nClear Date/Time:~05/07/2013 15:50:12\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~05/07/2013 15:50:06\n~\nIncident Number(s)\n2013-00000157~~Barnegat Fire Department\n~\nUnits Sent:~1\nF1115~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org");

    doTest("T6",
        "{Fwd: [OCSD] Rip and Run Report} \n\n\n" +
        "Begin forwarded message:\n\n" +
        "From: <Fire_Records>\n" +
        "Date: May 11, 2013, 15:14:27 EDT\n" +
        "To: <ocsd@station11.org>\n" +
        "Subject: [OCSD] Rip and Run Report\n" +
        "Reply-To: frank@station11.org\n\n" +
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~S~MAIN~ST/~GEORGETOWN~BLVD\n" +
        "Venue:~Barnegat Township\n" +
        "Cross Streets~\n" +
        "Quadrant:~ST11\n" +
        "District:~SQ11\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~104113\n" +
        "Call Type:~ MVC W/Injuries\n" +
        "Source:~Telephone\n" +
        "Priority:~ High\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/11/2013 14:17:07\n" +
        "Dispatch Date/Time:~05/11/2013 14:17:51\n" +
        "Arrive Date/Time:~05/11/2013 14:23:13\n" +
        "Clear Date/Time:~05/11/2013 15:14:25\n" +
        "Enroute Date/Time:~05/11/2013 14:18:54\n" +
        "Latest Unit Cleared Date/Time:~05/11/2013 15:14:24\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000778~~Barnegat EMS\n" +
        "2013-00000162~~Barnegat Fire Department\n" +
        "~\n" +
        "Units Sent:~6\n" +
        "ST11, E117, SQ11, F1110, F1103, F1100~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/11/13 14:17:45~Nature Of Call: WANTS CHILD CHECKED\n" +
        "05/11/13 14:18:04~Nature Of Call: WANTS CHILD CHECKED OUT\n" +
        "05/11/13 14:31:46~REQ FIRE FOR CLEAN UP\n\n\n" +
        "_______________________________________________\n" +
        "OCSD mailing list\n" +
        "OCSD@station11.org\n" +
        "http://station11.org/mailman/listinfo/ocsd_station11.org",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~S~MAIN~ST/~GEORGETOWN~BLVD\nVenue:~Barnegat Township\nCross Streets~\nQuadrant:~ST11\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~104113\nCall Type:~ MVC W/Injuries\nSource:~Telephone\nPriority:~ High\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/11/2013 14:17:07\nDispatch Date/Time:~05/11/2013 14:17:51\nArrive Date/Time:~05/11/2013 14:23:13\nClear Date/Time:~05/11/2013 15:14:25\nEnroute Date/Time:~05/11/2013 14:18:54\nLatest Unit Cleared Date/Time:~05/11/2013 15:14:24\n~\nIncident Number(s)\n2013-00000778~~Barnegat EMS\n2013-00000162~~Barnegat Fire Department\n~\nUnits Sent:~6\nST11, E117, SQ11, F1110, F1103, F1100~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/11/13 14:17:45~Nature Of Call: WANTS CHILD CHECKED\n05/11/13 14:18:04~Nature Of Call: WANTS CHILD CHECKED OUT\n05/11/13 14:31:46~REQ FIRE FOR CLEAN UP\n\n\n_______________________________________________\nOCSD mailing list\nOCSD@station11.org\nhttp://station11.org/mailman/listinfo/ocsd_station11.org");

    doTest("T7",
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~1~PASSAGE~LN~\n" +
        "Venue:~Barnegat Township\n" +
        "Cross Streets~\n" +
        "EDGARTOWN LN / FENWICK LN\n" +
        "Quadrant:~ST11/ST12\n" +
        "District:~SQ11\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~120518\n" +
        "Call Type:~ Fire Alarm\n" +
        "Source:~911\n" +
        "Priority:~ Medium\n" +
        "Status:~In Progress\n" +
        "Caller:~\n" +
        "Call Date/Time:~05/29/2013 18:03:27\n" +
        "Dispatch Date/Time:~05/29/2013 18:05:04\n" +
        "Arrive Date/Time:~05/29/2013 18:13:36\n" +
        "Clear Date/Time:~05/29/2013 18:31:55\n" +
        "Enroute Date/Time:~05/29/2013 18:07:31\n" +
        "Latest Unit Cleared Date/Time:~05/29/2013 18:31:52\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000182~~Barnegat Fire Department\n" +
        "~\n" +
        "Units Sent:~4\n" +
        "F1114, ST11, F1121, F1110~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "05/29/13 18:04:50~Nature Of Call: also lost power/no smoke or flames\n" +
        "05/29/13 18:16:28~PER F1110 ONLY THE 41 TRUCK\n" +
        "05/29/13 18:17:13~ONLY 21 TRUCK",

        "CALL:RUN REPORT",
        "PLACE:Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~1~PASSAGE~LN~\nVenue:~Barnegat Township\nCross Streets~\nEDGARTOWN LN / FENWICK LN\nQuadrant:~ST11/ST12\nDistrict:~SQ11\n~\nCall Information:\n\nCall Number:~120518\nCall Type:~ Fire Alarm\nSource:~911\nPriority:~ Medium\nStatus:~In Progress\nCaller:~\nCall Date/Time:~05/29/2013 18:03:27\nDispatch Date/Time:~05/29/2013 18:05:04\nArrive Date/Time:~05/29/2013 18:13:36\nClear Date/Time:~05/29/2013 18:31:55\nEnroute Date/Time:~05/29/2013 18:07:31\nLatest Unit Cleared Date/Time:~05/29/2013 18:31:52\n~\nIncident Number(s)\n2013-00000182~~Barnegat Fire Department\n~\nUnits Sent:~4\nF1114, ST11, F1121, F1110~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n05/29/13 18:04:50~Nature Of Call: also lost power/no smoke or flames\n05/29/13 18:16:28~PER F1110 ONLY THE 41 TRUCK\n05/29/13 18:17:13~ONLY 21 TRUCK");

  }
  
  public static void main(String[] args) {
    new NJOceanCountyParserTest().generateTests("T1");
  }
}
