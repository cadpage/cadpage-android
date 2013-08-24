package net.anei.cadpage.parsers.ZCABC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Mid-Island Region, BC, Canada
Contact: Active911
Agency name: Courtenay Fire Department
Location: Courtenay, BC, Canada
Sender: paging@ni911.ca

(Fire Dispatch) MOTOR VEHICLE ACCIDENT Back Rd / Ryan Rd , Courtenay ,BC 04/04/2013 12:39:52
(Fire Dispatch) FIRST ALARM - C 1141 Joshua Pl , Courtenay ,BC 04/04/2013 10:27:02
(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 04/03/2013 10:50:32
(Fire Dispatch) FIRST RESP ASSIST D/E 5900 Pickering Rd , Courtenay ,BC 04/02/2013 21:19:46
(Fire Dispatch) STRUCTURE FIRE 0 Maple Pool Campground , Courtenay ,BC 04/01/2013 19:02:00
(Fire Dispatch) DUTY OFFICER 2601 Cumberland Rd , Courtenay ,BC 04/01/2013 16:24:43\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MOTOR VEHICLE FIRE 0 SuperStore - Courtenay , Courtenay ,BC 04/01/2013 11:09:44
(Fire Dispatch) DUTY OFFICER 10 - 29 Salsbury Rd , Courtenay ,BC 03/31/2013 20:37:16\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 100 - 999 Webb Rd , Courtenay ,BC 03/31/2013 20:31:07\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 56 Salsbury Rd , Courtenay ,BC 03/31/2013 20:07:31\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) CHIMNEY FIRE 2340 Piercy Ave , Courtenay ,BC 03/30/2013 21:15:12
(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1141 Joshua Pl , Courtenay ,BC 03/30/2013 13:59:13
(Fire Dispatch) ALARMS 129 Back Rd , Courtenay ,BC 03/30/2013 13:10:41
(Fire Dispatch) ALARMS 2300 Ryan Rd , Courtenay ,BC 03/29/2013 17:18:14
(Fire Dispatch) DUTY OFFICER 0 Airpark , Courtenay ,BC 03/29/2013 16:02:38\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Crown Isle Blvd / Ryan Rd , Courtenay ,BC 03/29/2013 14:44:43
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 2150 Comox Logging Rd , Courtenay ,BC 03/29/2013 13:30:18
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 197 Headquarters Rd , Courtenay ,BC 03/29/2013 13:05:02
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Hobson Ave / E 10th St , Courtenay ,BC 03/29/2013 12:56:16
(Fire Dispatch) DUTY OFFICER 49 40'49.6"n / 125 00'50.27"w , ,BC 03/28/2013 16:56:29\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) NATURAL GAS LINE BREAK 900 View Ave , Courtenay ,BC 03/28/2013 13:44:20
(Fire Dispatch) DUTY OFFICER 3040 Lake Trail Rd , Courtenay ,BC 03/27/2013 19:10:42\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 2350 Cliffe Ave , Courtenay ,BC 03/26/2013 06:40:21\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Lerwick Rd / Ryan Rd , Courtenay ,BC 03/24/2013 17:11:30
(Fire Dispatch) DUTY OFFICER 1926 Vera Dr , Courtenay ,BC 03/22/2013 19:51:38\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 5620 N ISLAND HWY , Courtenay ,BC 03/22/2013 20:03:27\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1800 - 2199 Hardy Rd , Courtenay ,BC 03/22/2013 20:03:27
(Fire Dispatch) STRUCTURE FIRE 1926 Vera Dr , Courtenay ,BC 03/22/2013 19:51:38
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Back Rd / Tunner Dr , Courtenay ,BC 03/22/2013 15:39:46
(Fire Dispatch) STRUCTURE SMOKE 2010 Piercy Ave , Courtenay ,BC 03/22/2013 11:02:20
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Piercy Ave / Cumberland Rd , Courtenay ,BC 03/20/2013 12:03:43
(Fire Dispatch) ALARMS 280 2nd St , Courtenay ,BC 03/18/2013 10:23:14
(Fire Dispatch) MVI PED STRUCK 581 Ryan Rd , Courtenay ,BC 03/16/2013 15:04:36
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 581 Ryan Rd , Courtenay ,BC 03/16/2013 15:04:36
(Fire Dispatch) DUTY OFFICER 3938 Forde Ave , Courtenay ,BC 03/16/2013 05:59:45\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 420 Cumberland Rd , Courtenay ,BC 03/15/2013 15:19:21\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 3100 Barford Cres , Courtenay ,BC 03/15/2013 13:27:52\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) NATURAL GAS LINE BREAK 1070 Mantle Dr , Courtenay ,BC 03/14/2013 15:55:10
(Fire Dispatch) DUTY OFFICER 650 Cumberland Rd , Courtenay ,BC 03/14/2013 09:49:05\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 1050 BRAIDWOOD RD , Courtenay ,BC 03/12/2013 11:49:34\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1795 Mclauchlin Dr , Courtenay ,BC 03/11/2013 21:24:35
(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 0 5th ST BRIDGE , Courtenay ,BC 03/11/2013 18:16:09
(Fire Dispatch) STRUCTURE FIRE 229 Puntledge Rd , Courtenay ,BC 03/11/2013 18:16:09
(Fire Dispatch) DUTY OFFICER 4640 Headquarters Rd , Courtenay ,BC 03/11/2013 02:06:35\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 0 Merville General Store , Courtenay ,BC 03/10/2013 14:22:03
(Fire Dispatch) ALARMS 2450 Back Rd , Courtenay ,BC 03/09/2013 08:41:39
(Fire Dispatch) Duty Officer Test 1599 Cliffe Ave , Courtenay ,BC
(Fire Dispatch) STRUCTURE SMOKE 4085 Carey Pl , Courtenay ,BC 03/07/2013 11:31:34
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 5th St / Harmston Ave , Courtenay ,BC 03/07/2013 10:19:32
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 4576 Island Hwy S , Royston ,BC 03/07/2013 03:17:51
(Fire Dispatch) ALARMS 1532 Cliffe Ave , Courtenay ,BC 03/06/2013 16:51:27
(Fire Dispatch) ALARMS 3040 Lake Trail Rd , Courtenay ,BC 03/05/2013 17:36:42
(Fire Dispatch) DUTY OFFICER 1895 Avonlee Rd , Courtenay ,BC 03/05/2013 09:19:50\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) CHIMNEY FIRE 1895 Avonlee Rd , Courtenay ,BC 03/05/2013 09:19:50
(Fire Dispatch) DUTY OFFICER 31st St / Cliffe Ave , Courtenay ,BC 03/04/2013 06:20:52\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER 3778 Meredith Dr , Courtenay ,BC 03/03/2013 22:23:58\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) ALARMS 3778 Meredith Dr , Courtenay ,BC 03/03/2013 22:23:58
(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 03/03/2013 08:49:26
(Fire Dispatch) DUTY OFFICER 1600 15th St , Courtenay ,BC 03/03/2013 08:38:42\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 03/02/2013 19:14:32
(Fire Dispatch) DUTY OFFICER Coleman Rd / Island Hwy N , Courtenay ,BC 03/02/2013 09:10:38\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) DUTY OFFICER Piercy Ave / Cumberland Rd , Courtenay ,BC 03/01/2013 14:15:57\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) ALARMS 1355 Fitzgerald Ave , Courtenay ,BC 03/01/2013 13:21:24
(Fire Dispatch) FIRST RESP ASSIST D/E 1599 Hobson Ave , Courtenay ,BC 02/28/2013 20:43:49
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1883 Cliffe Ave , Courtenay ,BC 02/28/2013 16:40:10
(Fire Dispatch) ALARMS 588 Crown Isle Blvd , Courtenay ,BC 02/28/2013 14:13:35
(Fire Dispatch) ALARMS 610 Anderton Ave , Courtenay ,BC 02/26/2013 21:42:52
(Fire Dispatch) CHIMNEY FIRE 784 8th St , Courtenay ,BC 02/26/2013 18:23:28
(Fire Dispatch) ALARMS 1050 Braidwood Rd , Courtenay ,BC 02/26/2013 16:54:59
(Fire Dispatch) RESCUE ROAD 2186 Strathcona Pky , Mt Washington ,BC 02/26/2013 16:22:06
(Fire Dispatch) DUTY OFFICER 1472 Valley View Dr , Courtenay ,BC 02/25/2013 19:19:34\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) Rescue Road Hwy 19 / Comox Logging Road Overpass , Courtenay ,BC\n\nThank you\n\nGreg Lamb\nFire Inspector\nCity of Courtenay\nglamb@courtenay.ca\nOffice Phone 250-334-2513\nOffice Fax 250-897-1361\n\n\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) FIRST RESP DELAY D/E 388 Lerwick Rd , Courtenay ,BC 02/25/2013 12:19:33
(Fire Dispatch) DUTY OFFICER 2900 Comox Rd , Courtenay ,BC 02/23/2013 17:08:44\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) MVI PED STRUCK Hobson Ave / E 10th St , Courtenay ,BC 02/22/2013 23:45:09
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1264 Cumberland Rd , Courtenay ,BC 02/22/2013 17:10:02
(Fire Dispatch) ALARMS 2591 Cliffe Ave , Courtenay ,BC 02/22/2013 14:08:51
(Fire Dispatch) DUTY OFFICER 2871 Kilpatrick Ave , Courtenay ,BC 02/21/2013 16:21:23\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) ALARMS 743 28th St , Courtenay ,BC 02/21/2013 12:09:35
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Island Hwy N / Ryan Rd , Courtenay ,BC 02/21/2013 08:12:47
(Fire Dispatch) FIRST RESP ASSIST D/E 1027 Ryan Rd , Courtenay ,BC 02/21/2013 01:20:45
(Fire Dispatch) ALARMS Cliffe Ave / 8th St , Courtenay ,BC 02/20/2013 21:55:28
(Fire Dispatch) FIRST ALARM - C 3299 Cliffe Ave , Courtenay ,BC 02/20/2013 18:51:23
(Fire Dispatch) DUTY OFFICER 650 Cumberland Rd , Courtenay ,BC 15:59\n\nThank you\n\nGreg Lamb\nFire Inspector\nCity of Courtenay\nglamb@courtenay.ca\nOffice Phone 250-334-2513\nOffice Fax 250-897-1361\n\n\n\nDISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n\r
(Fire Dispatch) ALARMS 489 Old Island Hwy , Courtenay ,BC 02/20/2013 14:46:26

Contact: Active911
Agency name: Campbell River Fire Rescue
Location: Campbell River, BC, Canada
Sender: paging@ni911.ca

(Fire Dispatch) FIRST RESP D , 2nd Ave / Cedar St , Campbell River , BC 04/04/2013 15:38:40
(Fire Dispatch) FIRST RESP C , 277 Evergreen Rd , Campbell River , BC 04/04/2013 10:27:38
(Fire Dispatch) FIRST ALARM - C , 105 St Ann's Rd , Campbell River , BC 04/04/2013 00:13:13
(Fire Dispatch) ALARMS , 710 Dogwood St , Campbell River , BC 04/03/2013 23:15:13
(Fire Dispatch) TEST , 1334 Island Hwy , Campbell River , BC 04/03/2013 20:04:18
(Fire Dispatch) TEST , 0 Discovery Harbour Marina , Campbell River , BC 04/03/2013 18:56:53
(Fire Dispatch) DUTY OFFICER , 1835 Snowbird Cres , Campbell River , BC 04/03/2013 18:26:52
(Fire Dispatch) DUTY OFFICER , 1352 Shoppers Row , Campbell River , BC 04/03/2013 16:51:35
(Fire Dispatch) MOTOR VEHICLE FIRE , 1835 Snowbird Cres , Campbell River , BC 04/03/2013 15:45:52
(Fire Dispatch) FIRST RESP E , 142 Larwood Rd , Campbell River , BC 04/03/2013 12:30:58
(Fire Dispatch) ALARMS , 623 Nature Pk Dr , Campbell River , BC 04/03/2013 11:15:14
(Fire Dispatch) FIRST RESP D , 506 Quadra Ave , Campbell River , BC 04/02/2013 22:45:57
(Fire Dispatch) FIRST RESP D , Ironwood St / 12th Ave , Campbell River , BC 04/02/2013 12:56:03
(Fire Dispatch) FIRST RESP D , 1078 Springbok Rd , Campbell River , BC 04/02/2013 09:44:08
(Fire Dispatch) DUTY OFFICER , 188 Oregon Rd , Campbell River , BC 04/02/2013 09:09:34
(Fire Dispatch) HYDRO TROUBLE , 869 Alder St , Campbell River , BC 04/02/2013 08:11:58
(Fire Dispatch) DUTY OFFICER , 465 Merecroft Rd , Campbell River , BC 04/01/2013 18:12:13
(Fire Dispatch) FIRST RESP B , 555 2nd Ave , Campbell River , BC 04/01/2013 17:59:15
(Fire Dispatch) ALARMS , 1270 Dogwood St , Campbell River , BC 04/01/2013 15:56:55
(Fire Dispatch) DUTY OFFICER , 704 SHELLBOURNE BLVD , Campbell River , BC 04/01/2013 15:51:34
(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG , 5000 ARGONAUT RD , Campbell River , BC 04/01/2013 14:48:00
(Fire Dispatch) DUTY OFFICER , Jubilee Pky / Island Hwy S , Campbell River , BC 04/01/2013 14:31:03
(Fire Dispatch) FIRST RESP D , 3898 Searidge Pl , Campbell River , BC 04/01/2013 11:57:29
(Fire Dispatch) FIRST RESP D , 4000 - 4049 Middle Point Dr , Campbell River , BC 04/01/2013 04:44:44
(Fire Dispatch) DUTY OFFICER , 300 S Island Hwy , Campbell River , BC 03/31/2013 20:18:38
(Fire Dispatch) DUTY OFFICER , 9 Adams Rd , Campbell River , BC 03/31/2013 14:57:59
(Fire Dispatch) FIRST RESP D , 405 Evergreen Rd , Campbell River , BC 03/31/2013 02:20:53
(Fire Dispatch) FIRST RESP D , 2198 Willis Rd , Campbell River , BC 03/31/2013 00:51:31
(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 2198 Willis Rd , Campbell River , BC 03/31/2013 00:51:31
(Fire Dispatch) ALARMS , 1342 Shoppers Row , Campbell River , BC 03/30/2013 20:09:54
(Fire Dispatch) FIRST RESP D , 1020 Evergreen Rd , Campbell River , BC 03/30/2013 13:31:01
(Fire Dispatch) ALARMS , 2780 Vigar Rd , Campbell River , BC 03/30/2013 12:30:00
(Fire Dispatch) ALARMS , 2006 Sierra Dr , Campbell River , BC 03/30/2013 03:02:26
(Fire Dispatch) FIRST RESP D , 307 Frances Ave , Campbell River , BC 03/29/2013 16:49:52
(Fire Dispatch) DUTY OFFICER , 693 WILLOWCREST RD , Campbell River , BC 03/29/2013 13:35:08
(Fire Dispatch) DUTY OFFICER , 0 Frank James Park , Campbell River , BC 03/29/2013 11:08:52
(Fire Dispatch) STRUCTURE FIRE , 3799 S Island Hwy , Campbell River , BC 03/29/2013 10:43:10
(Fire Dispatch) FIRST RESP B , 1351 Ironwood St , Campbell River , BC 03/29/2013 10:17:12
(Fire Dispatch) FIRST RESP C , 183 Lonsdale Cres , Campbell River , BC 03/29/2013 06:57:55
(Fire Dispatch) DUTY OFFICER , 3912 Island Hwy S , Campbell River , BC 03/28/2013 20:27:26
(Fire Dispatch) FIRST RESP D , 880 Kalmar Rd , Campbell River , BC 03/28/2013 18:42:27
(Fire Dispatch) FIRST RESP D , 1351 Ironwood St , Campbell River , BC 03/28/2013 17:41:11
(Fire Dispatch) FIRST RESP D , 1652 17th Ave , Campbell River , BC 03/28/2013 12:11:16
(Fire Dispatch) FIRST RESP C , 216 Evergreen Rd , Campbell River , BC 03/28/2013 04:09:13
(Fire Dispatch) FIRST RESP D , 1331 Cedar St , Campbell River , BC 03/28/2013 00:40:51
(Fire Dispatch) TEST , 675 13th Ave , Campbell River , BC 03/27/2013 18:20:07
(Fire Dispatch) TEST , 675 13th Ave , Campbell River , BC 03/27/2013 18:10:04
(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36
(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36
(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36
(Fire Dispatch) FIRST RESP C , 960 Westmore Rd , Campbell River , BC 03/27/2013 17:03:38
(Fire Dispatch) FIRST RESP D , 1381 Cedar St , Campbell River , BC 03/27/2013 16:46:02
(Fire Dispatch) FIRST RESP C , 2165 S Island Hwy , Campbell River , BC 03/27/2013 16:29:06
(Fire Dispatch) STRUCTURE SMOKE , 759 Gemsbok Dr , Campbell River , BC 03/27/2013 15:48:25
(Fire Dispatch) FIRST RESP B , 1070 Dogwood St , Campbell River , BC 03/27/2013 15:32:06
(Fire Dispatch) FIRST RESP D , 1381 Cedar St , Campbell River , BC 03/27/2013 02:06:54
(Fire Dispatch) FIRST RESP D , 420 Sonora Cres , Campbell River , BC 03/26/2013 21:36:53
(Fire Dispatch) TEST , 144 S Murphy St , Campbell River , BC 03/26/2013 15:22:36
(Fire Dispatch) FIRST RESP C , 710 Dogwood St , Campbell River , BC 03/26/2013 14:21:09
(Fire Dispatch) FIRST RESP D , 919 Greenwood St , Campbell River , BC 03/26/2013 14:15:37
(Fire Dispatch) FIRST RESP D , 123 Engles Rd , Campbell River , BC 03/26/2013 12:14:32
(Fire Dispatch) FIRST RESP D , 2705 Island Hwy , Campbell River , BC 03/26/2013 03:01:15
(Fire Dispatch) FIRST RESP C , 931 14th Ave , Campbell River , BC 03/25/2013 19:54:28
(Fire Dispatch) FIRST RESP D , 1397 Leed Rd , Campbell River , BC 03/25/2013 18:24:56
(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 9th Ave / Fir St , Campbell River , BC 03/25/2013 10:58:41
(Fire Dispatch) FIRST RESP A , 644 4th Ave , Campbell River , BC 03/25/2013 02:12:52
(Fire Dispatch) FIRST RESP D , 3881 Barclay Rd , Campbell River , BC 03/24/2013 23:03:49
(Fire Dispatch) FIRST RESP D , 1290 Shoppers Row , Campbell River , BC 03/24/2013 15:29:40
(Fire Dispatch) FIRST RESP D , 270 Anne Rd , Campbell River , BC 03/24/2013 09:28:12
(Fire Dispatch) FIRST ALARM - A , 710 Dogwood St , Campbell River , BC 03/23/2013 23:34:30
(Fire Dispatch) HAZMAT , 710 Dogwood St , Campbell River , BC 03/23/2013 23:34:30
(Fire Dispatch) FIRST RESP D , 227 S Alder St , Campbell River , BC 03/23/2013 22:08:34
(Fire Dispatch) FIRST RESP B , 600 S Dogwood St , Campbell River , BC 03/23/2013 18:31:55
(Fire Dispatch) FIRST RESP C , 2006 Sierra Dr , Campbell River , BC 03/23/2013 17:51:13
(Fire Dispatch) DUTY OFFICER , 1500 Evergreen Rd , Campbell River , BC 03/23/2013 16:40:08
(Fire Dispatch) DUTY OFFICER , 4580 Discovery Dr , Campbell River , BC 03/23/2013 16:12:18
(Fire Dispatch) FIRST RESP ASSIST D/E , 1160 Shellbourne Blvd , Campbell River , BC 03/23/2013 15:45:57
(Fire Dispatch) DUTY OFFICER , 251 S Thulin St , Campbell River , BC 03/23/2013 14:32:11
(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 605 Rockland Rd , Campbell River , BC 03/23/2013 13:16:07
(Fire Dispatch) FIRST RESP B , 4453 Barclay Rd , Campbell River , BC 03/23/2013 12:59:47
(Fire Dispatch) FIRST RESP ASSIST , 931 14th Ave , Campbell River , BC 03/23/2013 12:44:16
(Fire Dispatch) FIRST RESP C , 931 14th Ave , Campbell River , BC 03/23/2013 12:21:52
(Fire Dispatch) FIRST RESP D , 2267 Eardley Rd , Campbell River , BC 03/23/2013 07:06:55
(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 396 Harrogate Rd , Campbell River , BC 03/23/2013 01:33:46
(Fire Dispatch) DUTY OFFICER , 1395 Maple St , Campbell River , BC 03/23/2013 00:41:22
(Fire Dispatch) FIRST RESP B , 331 Birch St , Campbell River , BC 03/23/2013 00:37:54
(Fire Dispatch) DUTY OFFICER , 0 Roberts Reach , Campbell River , BC 03/22/2013 22:23:41
(Fire Dispatch) FIRST RESP C , 1477 Island Hwy , Campbell River , BC 03/22/2013 20:16:48
(Fire Dispatch) FIRST RESP D , 84 Dogwood St , Campbell River , BC 03/22/2013 19:23:50
(Fire Dispatch) FIRST RESP D , Quattell Ave / Drake Rd , Campbell River , BC 03/22/2013 14:37:07
(Fire Dispatch) FIRST RESP D , 1371 Cedar St , Campbell River , BC 03/22/2013 14:15:43
(Fire Dispatch) ALARMS , 710 Dogwood St , Campbell River , BC 03/22/2013 13:17:03
(Fire Dispatch) FIRST RESP E , 153 Reef Cres , Campbell River , BC 03/22/2013 10:38:22
(Fire Dispatch) FIRST RESP B , 555 2nd Ave , Campbell River , BC 03/22/2013 02:57:15
(Fire Dispatch) FIRST RESP C , 2356 Coho Rd , Campbell River , BC 03/22/2013 01:44:33
(Fire Dispatch) FIRST RESP B , 1381 Cedar St , Campbell River , BC 03/21/2013 22:16:44
(Fire Dispatch) FIRST RESP B , S Dogwood St / Pinecrest Rd , Campbell River , BC 03/21/2013 22:03:36
(Fire Dispatch) FIRST RESP ASSIST , 365 Niluht Rd , Campbell River , BC 03/21/2013 19:00:32
(Fire Dispatch) FIRST RESP B , Petersen Rd / Island Hwy , Campbell River , BC 03/21/2013 18:46:04
(Fire Dispatch) MOTOR VEHICLE ACCIDENT , Petersen Rd / Island Hwy , Campbell River , BC 03/21/2013 18:46:04

Contact: Active911
Agency name: Comox Fire Rescue
Location: Comox, BritishColumbia, Canada
Sender: paging@ni911.ca

(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1498 Noel Ave , Comox ,BC 04/03/2013 19:42:41
(Fire Dispatch) FIRST RESP D 2158 Downey Ave , Comox ,BC 04/03/2013 06:49:20
(Fire Dispatch) FIRST RESP D 660 PRITCHARD RD , Comox ,BC 04/03/2013 04:13:55
(Fire Dispatch) CHIMNEY FIRE 1517 Kye Bay Rd , Comox ,BC 04/02/2013 20:25:16
(Fire Dispatch) CHIMNEY FIRE 1646 Maquinna Ave , Comox ,BC 04/02/2013 17:39:31
(Fire Dispatch) DUTY OFFICER 0 School - Brooklyn-lazo Campus , Comox ,BC 04/02/2013 11:13:55
(Fire Dispatch) DUTY OFFICER 286 Curtis Rd , Comox ,BC 04/01/2013 20:10:17
(Fire Dispatch) DUTY OFFICER 2275 Comox Ave , Comox ,BC 03/31/2013 22:25:04
(Fire Dispatch) FIRST RESP D 1501 Balmoral Ave , Comox ,BC 03/28/2013 18:14:41
(Fire Dispatch) ALARMS 155 Donovan Dr , Comox ,BC 03/27/2013 04:25:21
(Fire Dispatch) FIRST RESP D 1396 Hudson Rd , Comox ,BC 03/26/2013 16:40:04
(Fire Dispatch) DUTY OFFICER 2047 Beach Dr , Comox ,BC 03/25/2013 18:42:31
(Fire Dispatch) STRUCTURE FIRE Guthrie Rd / Anderton Rd , Comox ,BC 03/25/2013 15:25:14
(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 03/21/2013 20:37:57
(Fire Dispatch) FIRST RESP D 1854 Beaufort Ave , Comox ,BC 03/20/2013 16:56:23
(Fire Dispatch) FIRST RESP D 1822 Comox Ave , Comox ,BC 03/20/2013 13:36:10
(Fire Dispatch) FIRST RESP D 980 Anderton Rd , Comox ,BC 03/19/2013 22:36:04
(Fire Dispatch) FIRST RESP D 1683 Balmoral Ave , Comox ,BC 03/19/2013 02:52:32
(Fire Dispatch) FIRST RESP D 1250 Knight Rd , Comox ,BC 03/18/2013 13:34:58
(Fire Dispatch) FIRST RESP D 1427 Noel Ave , Comox ,BC 03/18/2013 00:35:54
(Fire Dispatch) FIRST RESP D 1729 Comox Ave , Comox ,BC 03/17/2013 11:47:37
(Fire Dispatch) FIRST RESP D 1681 Belair Rd , Comox ,BC 03/16/2013 04:21:25
(Fire Dispatch) ALARMS 121 Port Augusta St , Comox ,BC 03/15/2013 13:46:56
(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 03/13/2013 23:07:28
(Fire Dispatch) FIRST RESP D 417 Heather Crt , Comox ,BC 03/12/2013 13:03:01
(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 03/11/2013 17:04:04
(Fire Dispatch) DUTY OFFICER 1860 Comox Ave , Comox ,BC 03/10/2013 23:09:42
(Fire Dispatch) FIRST RESP D 874 Knight Rd , Comox ,BC 03/10/2013 20:23:19
(Fire Dispatch) FIRST RESP D 3216 Back Rd , Comox ,BC 03/10/2013 15:04:54
(Fire Dispatch) FIRST RESP D 2117 Bambrick Pl , Comox ,BC 03/10/2013 09:35:24
(Fire Dispatch) FIRST RESP D 2275 Guthrie Rd , Comox ,BC 03/09/2013 20:59:02
(Fire Dispatch) FIRST RESP D 800 Highwood Dr , Comox ,BC 03/09/2013 19:29:23
(Fire Dispatch) DUTY OFFICER 464 Lazo Rd , Comox ,BC 03/09/2013 18:37:03
(Fire Dispatch) FIRST RESP D 2151 Bolt Ave , Comox ,BC 03/08/2013 08:36:51
(Fire Dispatch) FIRST RESP E 1680 E Centennial Ave , Comox ,BC 03/06/2013 11:37:39
(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 03/06/2013 09:07:06
(Fire Dispatch) DUTY OFFICER 2059 Beach Dr , Comox ,BC 03/03/2013 18:57:59
(Fire Dispatch) DUTY OFFICER 0 Unsigned , Comox ,BC 03/02/2013 14:10:25
(Fire Dispatch) FIRST RESP D 695 Totem Cres , Comox ,BC 03/02/2013 01:36:06
(Fire Dispatch) FIRST RESP D 1950 Comox Ave , Comox ,BC 03/01/2013 23:09:55
(Fire Dispatch) FIRST RESP D 2300 Murrelet Dr , Comox ,BC 03/01/2013 03:17:31
(Fire Dispatch) FIRST RESP DELAY B/C 610 Bunting Pl , Comox ,BC 02/28/2013 20:45:16
(Fire Dispatch) FIRST RESP ASSIST D/E 677 Bunting Pl , Comox ,BC 02/27/2013 14:57:32
(Fire Dispatch) MOTOR VEHICLE ACCIDENT 301 Curtis Rd , Comox ,BC 02/26/2013 20:14:55
(Fire Dispatch) FIRST RESP D 301 Curtis Rd , Comox ,BC 02/26/2013 20:14:55
(Fire Dispatch) FIRST RESP E 687 Moralee Dr , Comox ,BC 02/25/2013 10:42:41
(Fire Dispatch) DUTY OFFICER 1900 Burdyny Rd , Comox ,BC 02/24/2013 12:01:20
(Fire Dispatch) FIRST RESP D 310 Aitken St , Comox ,BC 02/24/2013 10:00:33
(Fire Dispatch) FIRST RESP D 473 Holly Pl , Comox ,BC 02/23/2013 07:24:07
(Fire Dispatch) FIRST RESP D 315 Denman St , Comox ,BC 02/23/2013 05:45:28
(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 02/22/2013 19:04:08
(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 02/22/2013 18:20:11
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Anderton Rd / Guthrie Rd , Comox ,BC 02/22/2013 16:27:28
(Fire Dispatch) MOTOR VEHICLE ACCIDENT Pritchard Rd / Dogwood Ave , Comox ,BC 02/20/2013 18:53:40
(Fire Dispatch) MOTOR VEHICLE FIRE Pritchard Rd / Dogwood Ave , Comox ,BC 02/20/2013 18:53:40
(Fire Dispatch) FIRST RESP D 1547 Balsam Ave , Comox ,BC 02/20/2013 17:11:55
(Fire Dispatch) FIRST RESP D 1600 Comox Ave , Comox ,BC 02/20/2013 14:44:53
(Fire Dispatch) TEST 0 Fire Station Comox , Comox ,BC 02/20/2013 13:11:44

*/

public class ZCABCMidIslandRegionParserTest extends BaseParserTest {
  
  public ZCABCMidIslandRegionParserTest() {
    setParser(new ZCABCMidIslandRegionParser(), "", "BC");
  }
  
  @Test
  public void testCortenayFireDepartment() {
    
    doTest("T1",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Back Rd / Ryan Rd , Courtenay ,BC 04/04/2013 12:39:52",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Back Rd & Ryan Rd",
        "CITY:Courtenay",
        "DATE:04/04/2013",
        "TIME:12:39:52");
     
    doTest("T2",
        "(Fire Dispatch) FIRST ALARM - C 1141 Joshua Pl , Courtenay ,BC 04/04/2013 10:27:02",
        "CALL:FIRST ALARM - C",
        "ADDR:1141 Joshua Pl",
        "CITY:Courtenay",
        "DATE:04/04/2013",
        "TIME:10:27:02");

    doTest("T3",
        "(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 04/03/2013 10:50:32",
        "CALL:ALARMS",
        "ADDR:4640 Headquarters Rd",
        "CITY:Courtenay",
        "DATE:04/03/2013",
        "TIME:10:50:32");

    doTest("T4",
        "(Fire Dispatch) FIRST RESP ASSIST D/E 5900 Pickering Rd , Courtenay ,BC 04/02/2013 21:19:46",
        "CALL:FIRST RESP ASSIST D/E",
        "ADDR:5900 Pickering Rd",
        "CITY:Courtenay",
        "DATE:04/02/2013",
        "TIME:21:19:46");

    doTest("T5",
        "(Fire Dispatch) STRUCTURE FIRE 0 Maple Pool Campground , Courtenay ,BC 04/01/2013 19:02:00",
        "CALL:STRUCTURE FIRE",
        "ADDR:Maple Pool Campground",
        "CITY:Courtenay",
        "DATE:04/01/2013",
        "TIME:19:02:00");

    doTest("T6",
        "(Fire Dispatch) DUTY OFFICER 2601 Cumberland Rd , Courtenay ,BC 04/01/2013 16:24:43\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:2601 Cumberland Rd",
        "CITY:Courtenay",
        "DATE:04/01/2013",
        "TIME:16:24:43");

    doTest("T7",
        "(Fire Dispatch) MOTOR VEHICLE FIRE 0 SuperStore - Courtenay , Courtenay ,BC 04/01/2013 11:09:44",
        "CALL:MOTOR VEHICLE FIRE",
        "ADDR:SuperStore - Courtenay",
        "CITY:Courtenay",
        "DATE:04/01/2013",
        "TIME:11:09:44");

    doTest("T8",
        "(Fire Dispatch) DUTY OFFICER 10 - 29 Salsbury Rd , Courtenay ,BC 03/31/2013 20:37:16\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:10 - 29 Salsbury Rd",
        "MADDR:10 Salsbury Rd",
        "CITY:Courtenay",
        "DATE:03/31/2013",
        "TIME:20:37:16");

    doTest("T9",
        "(Fire Dispatch) DUTY OFFICER 100 - 999 Webb Rd , Courtenay ,BC 03/31/2013 20:31:07\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:100 - 999 Webb Rd",
        "MADDR:100 Webb Rd",
        "CITY:Courtenay",
        "DATE:03/31/2013",
        "TIME:20:31:07");

    doTest("T10",
        "(Fire Dispatch) DUTY OFFICER 56 Salsbury Rd , Courtenay ,BC 03/31/2013 20:07:31\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:56 Salsbury Rd",
        "CITY:Courtenay",
        "DATE:03/31/2013",
        "TIME:20:07:31");

    doTest("T11",
        "(Fire Dispatch) CHIMNEY FIRE 2340 Piercy Ave , Courtenay ,BC 03/30/2013 21:15:12",
        "CALL:CHIMNEY FIRE",
        "ADDR:2340 Piercy Ave",
        "CITY:Courtenay",
        "DATE:03/30/2013",
        "TIME:21:15:12");

    doTest("T12",
        "(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1141 Joshua Pl , Courtenay ,BC 03/30/2013 13:59:13",
        "CALL:BEACH/BRUSH/MISC OUT EMERG",
        "ADDR:1141 Joshua Pl",
        "CITY:Courtenay",
        "DATE:03/30/2013",
        "TIME:13:59:13");

    doTest("T13",
        "(Fire Dispatch) ALARMS 129 Back Rd , Courtenay ,BC 03/30/2013 13:10:41",
        "CALL:ALARMS",
        "ADDR:129 Back Rd",
        "CITY:Courtenay",
        "DATE:03/30/2013",
        "TIME:13:10:41");

    doTest("T14",
        "(Fire Dispatch) ALARMS 2300 Ryan Rd , Courtenay ,BC 03/29/2013 17:18:14",
        "CALL:ALARMS",
        "ADDR:2300 Ryan Rd",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:17:18:14");

    doTest("T15",
        "(Fire Dispatch) DUTY OFFICER 0 Airpark , Courtenay ,BC 03/29/2013 16:02:38\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:Airpark",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:16:02:38");

    doTest("T16",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Crown Isle Blvd / Ryan Rd , Courtenay ,BC 03/29/2013 14:44:43",
        "CALL:MOTOR VEHICLE ACCIDENT Crown",
        "ADDR:Isle Blvd & Ryan Rd",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:14:44:43");

    doTest("T17",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 2150 Comox Logging Rd , Courtenay ,BC 03/29/2013 13:30:18",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:2150 Comox Logging Rd",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:13:30:18");

    doTest("T18",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 197 Headquarters Rd , Courtenay ,BC 03/29/2013 13:05:02",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:197 Headquarters Rd",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:13:05:02");

    doTest("T19",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Hobson Ave / E 10th St , Courtenay ,BC 03/29/2013 12:56:16",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Hobson Ave & E 10th St",
        "CITY:Courtenay",
        "DATE:03/29/2013",
        "TIME:12:56:16");

    doTest("T20",
        "(Fire Dispatch) DUTY OFFICER 49 40'49.6\"n / 125 00'50.27\"w , ,BC 03/28/2013 16:56:29\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:49 40'49.6\"n / 125 00'50.27\"w",
        "MADDR:+49.680444,-125.013964",
        "DATE:03/28/2013",
        "TIME:16:56:29");

    doTest("T21",
        "(Fire Dispatch) NATURAL GAS LINE BREAK 900 View Ave , Courtenay ,BC 03/28/2013 13:44:20",
        "CALL:NATURAL GAS LINE BREAK",
        "ADDR:900 View Ave",
        "CITY:Courtenay",
        "DATE:03/28/2013",
        "TIME:13:44:20");

    doTest("T22",
        "(Fire Dispatch) DUTY OFFICER 3040 Lake Trail Rd , Courtenay ,BC 03/27/2013 19:10:42\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:3040 Lake Trail Rd",
        "CITY:Courtenay",
        "DATE:03/27/2013",
        "TIME:19:10:42");

    doTest("T23",
        "(Fire Dispatch) DUTY OFFICER 2350 Cliffe Ave , Courtenay ,BC 03/26/2013 06:40:21\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:2350 Cliffe Ave",
        "CITY:Courtenay",
        "DATE:03/26/2013",
        "TIME:06:40:21");

    doTest("T24",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Lerwick Rd / Ryan Rd , Courtenay ,BC 03/24/2013 17:11:30",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Lerwick Rd & Ryan Rd",
        "CITY:Courtenay",
        "DATE:03/24/2013",
        "TIME:17:11:30");

    doTest("T25",
        "(Fire Dispatch) DUTY OFFICER 1926 Vera Dr , Courtenay ,BC 03/22/2013 19:51:38\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:1926 Vera Dr",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:19:51:38");

    doTest("T26",
        "(Fire Dispatch) DUTY OFFICER 5620 N ISLAND HWY , Courtenay ,BC 03/22/2013 20:03:27\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:5620 N ISLAND HWY",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:20:03:27");

    doTest("T27",
        "(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1800 - 2199 Hardy Rd , Courtenay ,BC 03/22/2013 20:03:27",
        "CALL:BEACH/BRUSH/MISC OUT EMERG",
        "ADDR:1800 - 2199 Hardy Rd",
        "MADDR:1800 Hardy Rd",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:20:03:27");

    doTest("T28",
        "(Fire Dispatch) STRUCTURE FIRE 1926 Vera Dr , Courtenay ,BC 03/22/2013 19:51:38",
        "CALL:STRUCTURE FIRE",
        "ADDR:1926 Vera Dr",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:19:51:38");

    doTest("T29",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Back Rd / Tunner Dr , Courtenay ,BC 03/22/2013 15:39:46",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Back Rd & Tunner Dr",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:15:39:46");

    doTest("T30",
        "(Fire Dispatch) STRUCTURE SMOKE 2010 Piercy Ave , Courtenay ,BC 03/22/2013 11:02:20",
        "CALL:STRUCTURE SMOKE",
        "ADDR:2010 Piercy Ave",
        "CITY:Courtenay",
        "DATE:03/22/2013",
        "TIME:11:02:20");

    doTest("T31",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Piercy Ave / Cumberland Rd , Courtenay ,BC 03/20/2013 12:03:43",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Piercy Ave & Cumberland Rd",
        "CITY:Courtenay",
        "DATE:03/20/2013",
        "TIME:12:03:43");

    doTest("T32",
        "(Fire Dispatch) ALARMS 280 2nd St , Courtenay ,BC 03/18/2013 10:23:14",
        "CALL:ALARMS",
        "ADDR:280 2nd St",
        "CITY:Courtenay",
        "DATE:03/18/2013",
        "TIME:10:23:14");

    doTest("T33",
        "(Fire Dispatch) MVI PED STRUCK 581 Ryan Rd , Courtenay ,BC 03/16/2013 15:04:36",
        "CALL:MVI PED STRUCK",
        "ADDR:581 Ryan Rd",
        "CITY:Courtenay",
        "DATE:03/16/2013",
        "TIME:15:04:36");

    doTest("T34",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 581 Ryan Rd , Courtenay ,BC 03/16/2013 15:04:36",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:581 Ryan Rd",
        "CITY:Courtenay",
        "DATE:03/16/2013",
        "TIME:15:04:36");

    doTest("T35",
        "(Fire Dispatch) DUTY OFFICER 3938 Forde Ave , Courtenay ,BC 03/16/2013 05:59:45\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:3938 Forde Ave",
        "CITY:Courtenay",
        "DATE:03/16/2013",
        "TIME:05:59:45");

    doTest("T36",
        "(Fire Dispatch) DUTY OFFICER 420 Cumberland Rd , Courtenay ,BC 03/15/2013 15:19:21\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:420 Cumberland Rd",
        "CITY:Courtenay",
        "DATE:03/15/2013",
        "TIME:15:19:21");

    doTest("T37",
        "(Fire Dispatch) DUTY OFFICER 3100 Barford Cres , Courtenay ,BC 03/15/2013 13:27:52\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:3100 Barford Cres",
        "CITY:Courtenay",
        "DATE:03/15/2013",
        "TIME:13:27:52");

    doTest("T38",
        "(Fire Dispatch) NATURAL GAS LINE BREAK 1070 Mantle Dr , Courtenay ,BC 03/14/2013 15:55:10",
        "CALL:NATURAL GAS LINE BREAK",
        "ADDR:1070 Mantle Dr",
        "CITY:Courtenay",
        "DATE:03/14/2013",
        "TIME:15:55:10");

    doTest("T39",
        "(Fire Dispatch) DUTY OFFICER 650 Cumberland Rd , Courtenay ,BC 03/14/2013 09:49:05\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:650 Cumberland Rd",
        "CITY:Courtenay",
        "DATE:03/14/2013",
        "TIME:09:49:05");

    doTest("T40",
        "(Fire Dispatch) DUTY OFFICER 1050 BRAIDWOOD RD , Courtenay ,BC 03/12/2013 11:49:34\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:1050 BRAIDWOOD RD",
        "CITY:Courtenay",
        "DATE:03/12/2013",
        "TIME:11:49:34");

    doTest("T41",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1795 Mclauchlin Dr , Courtenay ,BC 03/11/2013 21:24:35",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:1795 Mclauchlin Dr",
        "CITY:Courtenay",
        "DATE:03/11/2013",
        "TIME:21:24:35");

    doTest("T42",
        "(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 0 5th ST BRIDGE , Courtenay ,BC 03/11/2013 18:16:09",
        "CALL:BEACH/BRUSH/MISC OUT EMERG",
        "ADDR:5th ST BRIDGE",
        "CITY:Courtenay",
        "DATE:03/11/2013",
        "TIME:18:16:09");

    doTest("T43",
        "(Fire Dispatch) STRUCTURE FIRE 229 Puntledge Rd , Courtenay ,BC 03/11/2013 18:16:09",
        "CALL:STRUCTURE FIRE",
        "ADDR:229 Puntledge Rd",
        "CITY:Courtenay",
        "DATE:03/11/2013",
        "TIME:18:16:09");

    doTest("T44",
        "(Fire Dispatch) DUTY OFFICER 4640 Headquarters Rd , Courtenay ,BC 03/11/2013 02:06:35\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:4640 Headquarters Rd",
        "CITY:Courtenay",
        "DATE:03/11/2013",
        "TIME:02:06:35");

    doTest("T45",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 0 Merville General Store , Courtenay ,BC 03/10/2013 14:22:03",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Merville General Store",
        "CITY:Courtenay",
        "DATE:03/10/2013",
        "TIME:14:22:03");

    doTest("T46",
        "(Fire Dispatch) ALARMS 2450 Back Rd , Courtenay ,BC 03/09/2013 08:41:39",
        "CALL:ALARMS",
        "ADDR:2450 Back Rd",
        "CITY:Courtenay",
        "DATE:03/09/2013",
        "TIME:08:41:39");

    doTest("T47",
        "(Fire Dispatch) Duty Officer Test 1599 Cliffe Ave , Courtenay ,BC",
        "CALL:Duty Officer Test",
        "ADDR:1599 Cliffe Ave",
        "CITY:Courtenay");

    doTest("T48",
        "(Fire Dispatch) STRUCTURE SMOKE 4085 Carey Pl , Courtenay ,BC 03/07/2013 11:31:34",
        "CALL:STRUCTURE SMOKE",
        "ADDR:4085 Carey Pl",
        "CITY:Courtenay",
        "DATE:03/07/2013",
        "TIME:11:31:34");

    doTest("T49",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 5th St / Harmston Ave , Courtenay ,BC 03/07/2013 10:19:32",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:5th St & Harmston Ave",
        "CITY:Courtenay",
        "DATE:03/07/2013",
        "TIME:10:19:32");

    doTest("T50",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 4576 Island Hwy S , Royston ,BC 03/07/2013 03:17:51",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:4576 Island Hwy S",
        "CITY:Royston",
        "DATE:03/07/2013",
        "TIME:03:17:51");

    doTest("T51",
        "(Fire Dispatch) ALARMS 1532 Cliffe Ave , Courtenay ,BC 03/06/2013 16:51:27",
        "CALL:ALARMS",
        "ADDR:1532 Cliffe Ave",
        "CITY:Courtenay",
        "DATE:03/06/2013",
        "TIME:16:51:27");

    doTest("T52",
        "(Fire Dispatch) ALARMS 3040 Lake Trail Rd , Courtenay ,BC 03/05/2013 17:36:42",
        "CALL:ALARMS",
        "ADDR:3040 Lake Trail Rd",
        "CITY:Courtenay",
        "DATE:03/05/2013",
        "TIME:17:36:42");

    doTest("T53",
        "(Fire Dispatch) DUTY OFFICER 1895 Avonlee Rd , Courtenay ,BC 03/05/2013 09:19:50\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:1895 Avonlee Rd",
        "CITY:Courtenay",
        "DATE:03/05/2013",
        "TIME:09:19:50");

    doTest("T54",
        "(Fire Dispatch) CHIMNEY FIRE 1895 Avonlee Rd , Courtenay ,BC 03/05/2013 09:19:50",
        "CALL:CHIMNEY FIRE",
        "ADDR:1895 Avonlee Rd",
        "CITY:Courtenay",
        "DATE:03/05/2013",
        "TIME:09:19:50");

    doTest("T55",
        "(Fire Dispatch) DUTY OFFICER 31st St / Cliffe Ave , Courtenay ,BC 03/04/2013 06:20:52\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:31st St & Cliffe Ave",
        "CITY:Courtenay",
        "DATE:03/04/2013",
        "TIME:06:20:52");

    doTest("T56",
        "(Fire Dispatch) DUTY OFFICER 3778 Meredith Dr , Courtenay ,BC 03/03/2013 22:23:58\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:3778 Meredith Dr",
        "CITY:Courtenay",
        "DATE:03/03/2013",
        "TIME:22:23:58");

    doTest("T57",
        "(Fire Dispatch) ALARMS 3778 Meredith Dr , Courtenay ,BC 03/03/2013 22:23:58",
        "CALL:ALARMS",
        "ADDR:3778 Meredith Dr",
        "CITY:Courtenay",
        "DATE:03/03/2013",
        "TIME:22:23:58");

    doTest("T58",
        "(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 03/03/2013 08:49:26",
        "CALL:ALARMS",
        "ADDR:4640 Headquarters Rd",
        "CITY:Courtenay",
        "DATE:03/03/2013",
        "TIME:08:49:26");

    doTest("T59",
        "(Fire Dispatch) DUTY OFFICER 1600 15th St , Courtenay ,BC 03/03/2013 08:38:42\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:1600 15th St",
        "CITY:Courtenay",
        "DATE:03/03/2013",
        "TIME:08:38:42");

    doTest("T60",
        "(Fire Dispatch) ALARMS 4640 Headquarters Rd , Courtenay ,BC 03/02/2013 19:14:32",
        "CALL:ALARMS",
        "ADDR:4640 Headquarters Rd",
        "CITY:Courtenay",
        "DATE:03/02/2013",
        "TIME:19:14:32");

    doTest("T61",
        "(Fire Dispatch) DUTY OFFICER Coleman Rd / Island Hwy N , Courtenay ,BC 03/02/2013 09:10:38\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:Coleman Rd & Island Hwy N",
        "CITY:Courtenay",
        "DATE:03/02/2013",
        "TIME:09:10:38");

    doTest("T62",
        "(Fire Dispatch) DUTY OFFICER Piercy Ave / Cumberland Rd , Courtenay ,BC 03/01/2013 14:15:57\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:Piercy Ave & Cumberland Rd",
        "CITY:Courtenay",
        "DATE:03/01/2013",
        "TIME:14:15:57");

    doTest("T63",
        "(Fire Dispatch) ALARMS 1355 Fitzgerald Ave , Courtenay ,BC 03/01/2013 13:21:24",
        "CALL:ALARMS",
        "ADDR:1355 Fitzgerald Ave",
        "CITY:Courtenay",
        "DATE:03/01/2013",
        "TIME:13:21:24");

    doTest("T64",
        "(Fire Dispatch) FIRST RESP ASSIST D/E 1599 Hobson Ave , Courtenay ,BC 02/28/2013 20:43:49",
        "CALL:FIRST RESP ASSIST D/E",
        "ADDR:1599 Hobson Ave",
        "CITY:Courtenay",
        "DATE:02/28/2013",
        "TIME:20:43:49");

    doTest("T65",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1883 Cliffe Ave , Courtenay ,BC 02/28/2013 16:40:10",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:1883 Cliffe Ave",
        "CITY:Courtenay",
        "DATE:02/28/2013",
        "TIME:16:40:10");

    doTest("T66",
        "(Fire Dispatch) ALARMS 588 Crown Isle Blvd , Courtenay ,BC 02/28/2013 14:13:35",
        "CALL:ALARMS",
        "ADDR:588 Crown Isle Blvd",
        "CITY:Courtenay",
        "DATE:02/28/2013",
        "TIME:14:13:35");

    doTest("T67",
        "(Fire Dispatch) ALARMS 610 Anderton Ave , Courtenay ,BC 02/26/2013 21:42:52",
        "CALL:ALARMS",
        "ADDR:610 Anderton Ave",
        "CITY:Courtenay",
        "DATE:02/26/2013",
        "TIME:21:42:52");

    doTest("T68",
        "(Fire Dispatch) CHIMNEY FIRE 784 8th St , Courtenay ,BC 02/26/2013 18:23:28",
        "CALL:CHIMNEY FIRE",
        "ADDR:784 8th St",
        "CITY:Courtenay",
        "DATE:02/26/2013",
        "TIME:18:23:28");

    doTest("T69",
        "(Fire Dispatch) ALARMS 1050 Braidwood Rd , Courtenay ,BC 02/26/2013 16:54:59",
        "CALL:ALARMS",
        "ADDR:1050 Braidwood Rd",
        "CITY:Courtenay",
        "DATE:02/26/2013",
        "TIME:16:54:59");

    doTest("T70",
        "(Fire Dispatch) RESCUE ROAD 2186 Strathcona Pky , Mt Washington ,BC 02/26/2013 16:22:06",
        "CALL:RESCUE",
        "ADDR:ROAD 2186 Strathcona Pky",
        "MADDR:ROAD 2186 Strathcona Pkwy",
        "CITY:Mt Washington",
        "DATE:02/26/2013",
        "TIME:16:22:06");

    doTest("T71",
        "(Fire Dispatch) DUTY OFFICER 1472 Valley View Dr , Courtenay ,BC 02/25/2013 19:19:34\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:1472 Valley View Dr",
        "CITY:Courtenay",
        "DATE:02/25/2013",
        "TIME:19:19:34");

    doTest("T72",
        "(Fire Dispatch) Rescue Road Hwy 19 / Comox Logging Road Overpass , Courtenay ,BC\n\n" +
        "Thank you\n\n" +
        "Greg Lamb\n" +
        "Fire Inspector\n" +
        "City of Courtenay\n" +
        "glamb@courtenay.ca\n" +
        "Office Phone 250-334-2513\n" +
        "Office Fax 250-897-1361\n\n\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:Rescue Road",
        "ADDR:Hwy 19 & Comox Logging Road Overpass",
        "CITY:Courtenay");

    doTest("T73",
        "(Fire Dispatch) FIRST RESP DELAY D/E 388 Lerwick Rd , Courtenay ,BC 02/25/2013 12:19:33",
        "CALL:FIRST RESP DELAY D/E",
        "ADDR:388 Lerwick Rd",
        "CITY:Courtenay",
        "DATE:02/25/2013",
        "TIME:12:19:33");

    doTest("T74",
        "(Fire Dispatch) DUTY OFFICER 2900 Comox Rd , Courtenay ,BC 02/23/2013 17:08:44\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:2900 Comox Rd",
        "CITY:Courtenay",
        "DATE:02/23/2013",
        "TIME:17:08:44");

    doTest("T75",
        "(Fire Dispatch) MVI PED STRUCK Hobson Ave / E 10th St , Courtenay ,BC 02/22/2013 23:45:09",
        "CALL:MVI PED STRUCK",
        "ADDR:Hobson Ave & E 10th St",
        "CITY:Courtenay",
        "DATE:02/22/2013",
        "TIME:23:45:09");

    doTest("T76",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 1264 Cumberland Rd , Courtenay ,BC 02/22/2013 17:10:02",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:1264 Cumberland Rd",
        "CITY:Courtenay",
        "DATE:02/22/2013",
        "TIME:17:10:02");

    doTest("T77",
        "(Fire Dispatch) ALARMS 2591 Cliffe Ave , Courtenay ,BC 02/22/2013 14:08:51",
        "CALL:ALARMS",
        "ADDR:2591 Cliffe Ave",
        "CITY:Courtenay",
        "DATE:02/22/2013",
        "TIME:14:08:51");

    doTest("T78",
        "(Fire Dispatch) DUTY OFFICER 2871 Kilpatrick Ave , Courtenay ,BC 02/21/2013 16:21:23\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:2871 Kilpatrick Ave",
        "CITY:Courtenay",
        "DATE:02/21/2013",
        "TIME:16:21:23");

    doTest("T79",
        "(Fire Dispatch) ALARMS 743 28th St , Courtenay ,BC 02/21/2013 12:09:35",
        "CALL:ALARMS",
        "ADDR:743 28th St",
        "CITY:Courtenay",
        "DATE:02/21/2013",
        "TIME:12:09:35");

    doTest("T80",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Island Hwy N / Ryan Rd , Courtenay ,BC 02/21/2013 08:12:47",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Island Hwy N & Ryan Rd",
        "CITY:Courtenay",
        "DATE:02/21/2013",
        "TIME:08:12:47");

    doTest("T81",
        "(Fire Dispatch) FIRST RESP ASSIST D/E 1027 Ryan Rd , Courtenay ,BC 02/21/2013 01:20:45",
        "CALL:FIRST RESP ASSIST D/E",
        "ADDR:1027 Ryan Rd",
        "CITY:Courtenay",
        "DATE:02/21/2013",
        "TIME:01:20:45");

    doTest("T82",
        "(Fire Dispatch) ALARMS Cliffe Ave / 8th St , Courtenay ,BC 02/20/2013 21:55:28",
        "CALL:ALARMS",
        "ADDR:Cliffe Ave & 8th St",
        "CITY:Courtenay",
        "DATE:02/20/2013",
        "TIME:21:55:28");

    doTest("T83",
        "(Fire Dispatch) FIRST ALARM - C 3299 Cliffe Ave , Courtenay ,BC 02/20/2013 18:51:23",
        "CALL:FIRST ALARM - C",
        "ADDR:3299 Cliffe Ave",
        "CITY:Courtenay",
        "DATE:02/20/2013",
        "TIME:18:51:23");

    doTest("T84",
        "(Fire Dispatch) DUTY OFFICER 650 Cumberland Rd , Courtenay ,BC 15:59\n\n" +
        "Thank you\n\n" +
        "Greg Lamb\n" +
        "Fire Inspector\n" +
        "City of Courtenay\n" +
        "glamb@courtenay.ca\n" +
        "Office Phone 250-334-2513\n" +
        "Office Fax 250-897-1361\n\n\n\n" +
        "DISCLAIMER- This e-mail and any attachments may contain confidential and privileged information. Any use, disclosure, copying or dissemination of this information by a person other than an intended recipient is not authorized and may be illegal. If you are not an intended recipient, please notify the sender immediately by return e-mail, delete this e-mail and destroy any copies. Further, opinions expressed are strictly the author's own and are not necessarily those of the City of Courtenay.\r\n" +
        "\r",

        "CALL:DUTY OFFICER",
        "ADDR:650 Cumberland Rd",
        "CITY:Courtenay",
        "TIME:15:59");

    doTest("T85",
        "(Fire Dispatch) ALARMS 489 Old Island Hwy , Courtenay ,BC 02/20/2013 14:46:26",
        "CALL:ALARMS",
        "ADDR:489 Old Island Hwy",
        "CITY:Courtenay",
        "DATE:02/20/2013",
        "TIME:14:46:26");
       }
       
  @Test
  public void testCampbellRiver() {
    
    doTest("T1",
        "(Fire Dispatch) FIRST RESP D , 2nd Ave / Cedar St , Campbell River , BC 04/04/2013 15:38:40",
        "CALL:FIRST RESP D",
        "ADDR:2nd Ave & Cedar St",
        "CITY:Campbell River",
        "DATE:04/04/2013",
        "TIME:15:38:40");

    doTest("T2",
        "(Fire Dispatch) FIRST RESP C , 277 Evergreen Rd , Campbell River , BC 04/04/2013 10:27:38",
        "CALL:FIRST RESP C",
        "ADDR:277 Evergreen Rd",
        "CITY:Campbell River",
        "DATE:04/04/2013",
        "TIME:10:27:38");

    doTest("T3",
        "(Fire Dispatch) FIRST ALARM - C , 105 St Ann's Rd , Campbell River , BC 04/04/2013 00:13:13",
        "CALL:FIRST ALARM - C",
        "ADDR:105 St Ann's Rd",
        "CITY:Campbell River",
        "DATE:04/04/2013",
        "TIME:00:13:13");

    doTest("T4",
        "(Fire Dispatch) ALARMS , 710 Dogwood St , Campbell River , BC 04/03/2013 23:15:13",
        "CALL:ALARMS",
        "ADDR:710 Dogwood St",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:23:15:13");

    doTest("T5",
        "(Fire Dispatch) TEST , 1334 Island Hwy , Campbell River , BC 04/03/2013 20:04:18",
        "CALL:TEST",
        "ADDR:1334 Island Hwy",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:20:04:18");

    doTest("T6",
        "(Fire Dispatch) TEST , 0 Discovery Harbour Marina , Campbell River , BC 04/03/2013 18:56:53",
        "CALL:TEST",
        "ADDR:Discovery Harbour Marina",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:18:56:53");

    doTest("T7",
        "(Fire Dispatch) DUTY OFFICER , 1835 Snowbird Cres , Campbell River , BC 04/03/2013 18:26:52",
        "CALL:DUTY OFFICER",
        "ADDR:1835 Snowbird Cres",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:18:26:52");

    doTest("T8",
        "(Fire Dispatch) DUTY OFFICER , 1352 Shoppers Row , Campbell River , BC 04/03/2013 16:51:35",
        "CALL:DUTY OFFICER",
        "ADDR:1352 Shoppers Row",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:16:51:35");

    doTest("T9",
        "(Fire Dispatch) MOTOR VEHICLE FIRE , 1835 Snowbird Cres , Campbell River , BC 04/03/2013 15:45:52",
        "CALL:MOTOR VEHICLE FIRE",
        "ADDR:1835 Snowbird Cres",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:15:45:52");

    doTest("T10",
        "(Fire Dispatch) FIRST RESP E , 142 Larwood Rd , Campbell River , BC 04/03/2013 12:30:58",
        "CALL:FIRST RESP E",
        "ADDR:142 Larwood Rd",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:12:30:58");

    doTest("T11",
        "(Fire Dispatch) ALARMS , 623 Nature Pk Dr , Campbell River , BC 04/03/2013 11:15:14",
        "CALL:ALARMS",
        "ADDR:623 Nature Pk Dr",
        "MADDR:623 Nature Pike Dr",
        "CITY:Campbell River",
        "DATE:04/03/2013",
        "TIME:11:15:14");

    doTest("T12",
        "(Fire Dispatch) FIRST RESP D , 506 Quadra Ave , Campbell River , BC 04/02/2013 22:45:57",
        "CALL:FIRST RESP D",
        "ADDR:506 Quadra Ave",
        "CITY:Campbell River",
        "DATE:04/02/2013",
        "TIME:22:45:57");

    doTest("T13",
        "(Fire Dispatch) FIRST RESP D , Ironwood St / 12th Ave , Campbell River , BC 04/02/2013 12:56:03",
        "CALL:FIRST RESP D",
        "ADDR:Ironwood St & 12th Ave",
        "CITY:Campbell River",
        "DATE:04/02/2013",
        "TIME:12:56:03");

    doTest("T14",
        "(Fire Dispatch) FIRST RESP D , 1078 Springbok Rd , Campbell River , BC 04/02/2013 09:44:08",
        "CALL:FIRST RESP D",
        "ADDR:1078 Springbok Rd",
        "CITY:Campbell River",
        "DATE:04/02/2013",
        "TIME:09:44:08");

    doTest("T15",
        "(Fire Dispatch) DUTY OFFICER , 188 Oregon Rd , Campbell River , BC 04/02/2013 09:09:34",
        "CALL:DUTY OFFICER",
        "ADDR:188 Oregon Rd",
        "CITY:Campbell River",
        "DATE:04/02/2013",
        "TIME:09:09:34");

    doTest("T16",
        "(Fire Dispatch) HYDRO TROUBLE , 869 Alder St , Campbell River , BC 04/02/2013 08:11:58",
        "CALL:HYDRO TROUBLE",
        "ADDR:869 Alder St",
        "CITY:Campbell River",
        "DATE:04/02/2013",
        "TIME:08:11:58");

    doTest("T17",
        "(Fire Dispatch) DUTY OFFICER , 465 Merecroft Rd , Campbell River , BC 04/01/2013 18:12:13",
        "CALL:DUTY OFFICER",
        "ADDR:465 Merecroft Rd",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:18:12:13");

    doTest("T18",
        "(Fire Dispatch) FIRST RESP B , 555 2nd Ave , Campbell River , BC 04/01/2013 17:59:15",
        "CALL:FIRST RESP B",
        "ADDR:555 2nd Ave",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:17:59:15");

    doTest("T19",
        "(Fire Dispatch) ALARMS , 1270 Dogwood St , Campbell River , BC 04/01/2013 15:56:55",
        "CALL:ALARMS",
        "ADDR:1270 Dogwood St",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:15:56:55");

    doTest("T20",
        "(Fire Dispatch) DUTY OFFICER , 704 SHELLBOURNE BLVD , Campbell River , BC 04/01/2013 15:51:34",
        "CALL:DUTY OFFICER",
        "ADDR:704 SHELLBOURNE BLVD",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:15:51:34");

    doTest("T21",
        "(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG , 5000 ARGONAUT RD , Campbell River , BC 04/01/2013 14:48:00",
        "CALL:BEACH/BRUSH/MISC OUT EMERG",
        "ADDR:5000 ARGONAUT RD",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:14:48:00");

    doTest("T22",
        "(Fire Dispatch) DUTY OFFICER , Jubilee Pky / Island Hwy S , Campbell River , BC 04/01/2013 14:31:03",
        "CALL:DUTY OFFICER",
        "ADDR:Jubilee Pky & Island Hwy S",
        "MADDR:Jubilee Pkwy & Island Hwy S",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:14:31:03");

    doTest("T23",
        "(Fire Dispatch) FIRST RESP D , 3898 Searidge Pl , Campbell River , BC 04/01/2013 11:57:29",
        "CALL:FIRST RESP D",
        "ADDR:3898 Searidge Pl",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:11:57:29");

    doTest("T24",
        "(Fire Dispatch) FIRST RESP D , 4000 - 4049 Middle Point Dr , Campbell River , BC 04/01/2013 04:44:44",
        "CALL:FIRST RESP D",
        "ADDR:4000 - 4049 Middle Point Dr",
        "MADDR:4000 Middle Point Dr",
        "CITY:Campbell River",
        "DATE:04/01/2013",
        "TIME:04:44:44");

    doTest("T25",
        "(Fire Dispatch) DUTY OFFICER , 300 S Island Hwy , Campbell River , BC 03/31/2013 20:18:38",
        "CALL:DUTY OFFICER",
        "ADDR:300 S Island Hwy",
        "CITY:Campbell River",
        "DATE:03/31/2013",
        "TIME:20:18:38");

    doTest("T26",
        "(Fire Dispatch) DUTY OFFICER , 9 Adams Rd , Campbell River , BC 03/31/2013 14:57:59",
        "CALL:DUTY OFFICER",
        "ADDR:9 Adams Rd",
        "CITY:Campbell River",
        "DATE:03/31/2013",
        "TIME:14:57:59");

    doTest("T27",
        "(Fire Dispatch) FIRST RESP D , 405 Evergreen Rd , Campbell River , BC 03/31/2013 02:20:53",
        "CALL:FIRST RESP D",
        "ADDR:405 Evergreen Rd",
        "CITY:Campbell River",
        "DATE:03/31/2013",
        "TIME:02:20:53");

    doTest("T28",
        "(Fire Dispatch) FIRST RESP D , 2198 Willis Rd , Campbell River , BC 03/31/2013 00:51:31",
        "CALL:FIRST RESP D",
        "ADDR:2198 Willis Rd",
        "CITY:Campbell River",
        "DATE:03/31/2013",
        "TIME:00:51:31");

    doTest("T29",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 2198 Willis Rd , Campbell River , BC 03/31/2013 00:51:31",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:2198 Willis Rd",
        "CITY:Campbell River",
        "DATE:03/31/2013",
        "TIME:00:51:31");

    doTest("T30",
        "(Fire Dispatch) ALARMS , 1342 Shoppers Row , Campbell River , BC 03/30/2013 20:09:54",
        "CALL:ALARMS",
        "ADDR:1342 Shoppers Row",
        "CITY:Campbell River",
        "DATE:03/30/2013",
        "TIME:20:09:54");

    doTest("T31",
        "(Fire Dispatch) FIRST RESP D , 1020 Evergreen Rd , Campbell River , BC 03/30/2013 13:31:01",
        "CALL:FIRST RESP D",
        "ADDR:1020 Evergreen Rd",
        "CITY:Campbell River",
        "DATE:03/30/2013",
        "TIME:13:31:01");

    doTest("T32",
        "(Fire Dispatch) ALARMS , 2780 Vigar Rd , Campbell River , BC 03/30/2013 12:30:00",
        "CALL:ALARMS",
        "ADDR:2780 Vigar Rd",
        "CITY:Campbell River",
        "DATE:03/30/2013",
        "TIME:12:30:00");

    doTest("T33",
        "(Fire Dispatch) ALARMS , 2006 Sierra Dr , Campbell River , BC 03/30/2013 03:02:26",
        "CALL:ALARMS",
        "ADDR:2006 Sierra Dr",
        "CITY:Campbell River",
        "DATE:03/30/2013",
        "TIME:03:02:26");

    doTest("T34",
        "(Fire Dispatch) FIRST RESP D , 307 Frances Ave , Campbell River , BC 03/29/2013 16:49:52",
        "CALL:FIRST RESP D",
        "ADDR:307 Frances Ave",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:16:49:52");

    doTest("T35",
        "(Fire Dispatch) DUTY OFFICER , 693 WILLOWCREST RD , Campbell River , BC 03/29/2013 13:35:08",
        "CALL:DUTY OFFICER",
        "ADDR:693 WILLOWCREST RD",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:13:35:08");

    doTest("T36",
        "(Fire Dispatch) DUTY OFFICER , 0 Frank James Park , Campbell River , BC 03/29/2013 11:08:52",
        "CALL:DUTY OFFICER",
        "ADDR:Frank James Park",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:11:08:52");

    doTest("T37",
        "(Fire Dispatch) STRUCTURE FIRE , 3799 S Island Hwy , Campbell River , BC 03/29/2013 10:43:10",
        "CALL:STRUCTURE FIRE",
        "ADDR:3799 S Island Hwy",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:10:43:10");

    doTest("T38",
        "(Fire Dispatch) FIRST RESP B , 1351 Ironwood St , Campbell River , BC 03/29/2013 10:17:12",
        "CALL:FIRST RESP B",
        "ADDR:1351 Ironwood St",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:10:17:12");

    doTest("T39",
        "(Fire Dispatch) FIRST RESP C , 183 Lonsdale Cres , Campbell River , BC 03/29/2013 06:57:55",
        "CALL:FIRST RESP C",
        "ADDR:183 Lonsdale Cres",
        "CITY:Campbell River",
        "DATE:03/29/2013",
        "TIME:06:57:55");

    doTest("T40",
        "(Fire Dispatch) DUTY OFFICER , 3912 Island Hwy S , Campbell River , BC 03/28/2013 20:27:26",
        "CALL:DUTY OFFICER",
        "ADDR:3912 Island Hwy S",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:20:27:26");

    doTest("T41",
        "(Fire Dispatch) FIRST RESP D , 880 Kalmar Rd , Campbell River , BC 03/28/2013 18:42:27",
        "CALL:FIRST RESP D",
        "ADDR:880 Kalmar Rd",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:18:42:27");

    doTest("T42",
        "(Fire Dispatch) FIRST RESP D , 1351 Ironwood St , Campbell River , BC 03/28/2013 17:41:11",
        "CALL:FIRST RESP D",
        "ADDR:1351 Ironwood St",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:17:41:11");

    doTest("T43",
        "(Fire Dispatch) FIRST RESP D , 1652 17th Ave , Campbell River , BC 03/28/2013 12:11:16",
        "CALL:FIRST RESP D",
        "ADDR:1652 17th Ave",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:12:11:16");

    doTest("T44",
        "(Fire Dispatch) FIRST RESP C , 216 Evergreen Rd , Campbell River , BC 03/28/2013 04:09:13",
        "CALL:FIRST RESP C",
        "ADDR:216 Evergreen Rd",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:04:09:13");

    doTest("T45",
        "(Fire Dispatch) FIRST RESP D , 1331 Cedar St , Campbell River , BC 03/28/2013 00:40:51",
        "CALL:FIRST RESP D",
        "ADDR:1331 Cedar St",
        "CITY:Campbell River",
        "DATE:03/28/2013",
        "TIME:00:40:51");

    doTest("T46",
        "(Fire Dispatch) TEST , 675 13th Ave , Campbell River , BC 03/27/2013 18:20:07",
        "CALL:TEST",
        "ADDR:675 13th Ave",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:18:20:07");

    doTest("T47",
        "(Fire Dispatch) TEST , 675 13th Ave , Campbell River , BC 03/27/2013 18:10:04",
        "CALL:TEST",
        "ADDR:675 13th Ave",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:18:10:04");

    doTest("T48",
        "(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36",
        "CALL:FIRST RESP D",
        "ADDR:1255 Bute Cres",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:17:56:36");

    doTest("T49",
        "(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36",
        "CALL:FIRST RESP D",
        "ADDR:1255 Bute Cres",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:17:56:36");

    doTest("T50",
        "(Fire Dispatch) FIRST RESP D , 1255 Bute Cres , Campbell River , BC 03/27/2013 17:56:36",
        "CALL:FIRST RESP D",
        "ADDR:1255 Bute Cres",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:17:56:36");

    doTest("T51",
        "(Fire Dispatch) FIRST RESP C , 960 Westmore Rd , Campbell River , BC 03/27/2013 17:03:38",
        "CALL:FIRST RESP C",
        "ADDR:960 Westmore Rd",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:17:03:38");

    doTest("T52",
        "(Fire Dispatch) FIRST RESP D , 1381 Cedar St , Campbell River , BC 03/27/2013 16:46:02",
        "CALL:FIRST RESP D",
        "ADDR:1381 Cedar St",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:16:46:02");

    doTest("T53",
        "(Fire Dispatch) FIRST RESP C , 2165 S Island Hwy , Campbell River , BC 03/27/2013 16:29:06",
        "CALL:FIRST RESP C",
        "ADDR:2165 S Island Hwy",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:16:29:06");

    doTest("T54",
        "(Fire Dispatch) STRUCTURE SMOKE , 759 Gemsbok Dr , Campbell River , BC 03/27/2013 15:48:25",
        "CALL:STRUCTURE SMOKE",
        "ADDR:759 Gemsbok Dr",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:15:48:25");

    doTest("T55",
        "(Fire Dispatch) FIRST RESP B , 1070 Dogwood St , Campbell River , BC 03/27/2013 15:32:06",
        "CALL:FIRST RESP B",
        "ADDR:1070 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:15:32:06");

    doTest("T56",
        "(Fire Dispatch) FIRST RESP D , 1381 Cedar St , Campbell River , BC 03/27/2013 02:06:54",
        "CALL:FIRST RESP D",
        "ADDR:1381 Cedar St",
        "CITY:Campbell River",
        "DATE:03/27/2013",
        "TIME:02:06:54");

    doTest("T57",
        "(Fire Dispatch) FIRST RESP D , 420 Sonora Cres , Campbell River , BC 03/26/2013 21:36:53",
        "CALL:FIRST RESP D",
        "ADDR:420 Sonora Cres",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:21:36:53");

    doTest("T58",
        "(Fire Dispatch) TEST , 144 S Murphy St , Campbell River , BC 03/26/2013 15:22:36",
        "CALL:TEST",
        "ADDR:144 S Murphy St",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:15:22:36");

    doTest("T59",
        "(Fire Dispatch) FIRST RESP C , 710 Dogwood St , Campbell River , BC 03/26/2013 14:21:09",
        "CALL:FIRST RESP C",
        "ADDR:710 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:14:21:09");

    doTest("T60",
        "(Fire Dispatch) FIRST RESP D , 919 Greenwood St , Campbell River , BC 03/26/2013 14:15:37",
        "CALL:FIRST RESP D",
        "ADDR:919 Greenwood St",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:14:15:37");

    doTest("T61",
        "(Fire Dispatch) FIRST RESP D , 123 Engles Rd , Campbell River , BC 03/26/2013 12:14:32",
        "CALL:FIRST RESP D",
        "ADDR:123 Engles Rd",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:12:14:32");

    doTest("T62",
        "(Fire Dispatch) FIRST RESP D , 2705 Island Hwy , Campbell River , BC 03/26/2013 03:01:15",
        "CALL:FIRST RESP D",
        "ADDR:2705 Island Hwy",
        "CITY:Campbell River",
        "DATE:03/26/2013",
        "TIME:03:01:15");

    doTest("T63",
        "(Fire Dispatch) FIRST RESP C , 931 14th Ave , Campbell River , BC 03/25/2013 19:54:28",
        "CALL:FIRST RESP C",
        "ADDR:931 14th Ave",
        "CITY:Campbell River",
        "DATE:03/25/2013",
        "TIME:19:54:28");

    doTest("T64",
        "(Fire Dispatch) FIRST RESP D , 1397 Leed Rd , Campbell River , BC 03/25/2013 18:24:56",
        "CALL:FIRST RESP D",
        "ADDR:1397 Leed Rd",
        "CITY:Campbell River",
        "DATE:03/25/2013",
        "TIME:18:24:56");

    doTest("T65",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 9th Ave / Fir St , Campbell River , BC 03/25/2013 10:58:41",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:9th Ave & Fir St",
        "CITY:Campbell River",
        "DATE:03/25/2013",
        "TIME:10:58:41");

    doTest("T66",
        "(Fire Dispatch) FIRST RESP A , 644 4th Ave , Campbell River , BC 03/25/2013 02:12:52",
        "CALL:FIRST RESP A",
        "ADDR:644 4th Ave",
        "CITY:Campbell River",
        "DATE:03/25/2013",
        "TIME:02:12:52");

    doTest("T67",
        "(Fire Dispatch) FIRST RESP D , 3881 Barclay Rd , Campbell River , BC 03/24/2013 23:03:49",
        "CALL:FIRST RESP D",
        "ADDR:3881 Barclay Rd",
        "CITY:Campbell River",
        "DATE:03/24/2013",
        "TIME:23:03:49");

    doTest("T68",
        "(Fire Dispatch) FIRST RESP D , 1290 Shoppers Row , Campbell River , BC 03/24/2013 15:29:40",
        "CALL:FIRST RESP D",
        "ADDR:1290 Shoppers Row",
        "CITY:Campbell River",
        "DATE:03/24/2013",
        "TIME:15:29:40");

    doTest("T69",
        "(Fire Dispatch) FIRST RESP D , 270 Anne Rd , Campbell River , BC 03/24/2013 09:28:12",
        "CALL:FIRST RESP D",
        "ADDR:270 Anne Rd",
        "CITY:Campbell River",
        "DATE:03/24/2013",
        "TIME:09:28:12");

    doTest("T70",
        "(Fire Dispatch) FIRST ALARM - A , 710 Dogwood St , Campbell River , BC 03/23/2013 23:34:30",
        "CALL:FIRST ALARM - A",
        "ADDR:710 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:23:34:30");

    doTest("T71",
        "(Fire Dispatch) HAZMAT , 710 Dogwood St , Campbell River , BC 03/23/2013 23:34:30",
        "CALL:HAZMAT",
        "ADDR:710 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:23:34:30");

    doTest("T72",
        "(Fire Dispatch) FIRST RESP D , 227 S Alder St , Campbell River , BC 03/23/2013 22:08:34",
        "CALL:FIRST RESP D",
        "ADDR:227 S Alder St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:22:08:34");

    doTest("T73",
        "(Fire Dispatch) FIRST RESP B , 600 S Dogwood St , Campbell River , BC 03/23/2013 18:31:55",
        "CALL:FIRST RESP B",
        "ADDR:600 S Dogwood St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:18:31:55");

    doTest("T74",
        "(Fire Dispatch) FIRST RESP C , 2006 Sierra Dr , Campbell River , BC 03/23/2013 17:51:13",
        "CALL:FIRST RESP C",
        "ADDR:2006 Sierra Dr",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:17:51:13");

    doTest("T75",
        "(Fire Dispatch) DUTY OFFICER , 1500 Evergreen Rd , Campbell River , BC 03/23/2013 16:40:08",
        "CALL:DUTY OFFICER",
        "ADDR:1500 Evergreen Rd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:16:40:08");

    doTest("T76",
        "(Fire Dispatch) DUTY OFFICER , 4580 Discovery Dr , Campbell River , BC 03/23/2013 16:12:18",
        "CALL:DUTY OFFICER",
        "ADDR:4580 Discovery Dr",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:16:12:18");

    doTest("T77",
        "(Fire Dispatch) FIRST RESP ASSIST D/E , 1160 Shellbourne Blvd , Campbell River , BC 03/23/2013 15:45:57",
        "CALL:FIRST RESP ASSIST D/E",
        "ADDR:1160 Shellbourne Blvd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:15:45:57");

    doTest("T78",
        "(Fire Dispatch) DUTY OFFICER , 251 S Thulin St , Campbell River , BC 03/23/2013 14:32:11",
        "CALL:DUTY OFFICER",
        "ADDR:251 S Thulin St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:14:32:11");

    doTest("T79",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 605 Rockland Rd , Campbell River , BC 03/23/2013 13:16:07",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:605 Rockland Rd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:13:16:07");

    doTest("T80",
        "(Fire Dispatch) FIRST RESP B , 4453 Barclay Rd , Campbell River , BC 03/23/2013 12:59:47",
        "CALL:FIRST RESP B",
        "ADDR:4453 Barclay Rd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:12:59:47");

    doTest("T81",
        "(Fire Dispatch) FIRST RESP ASSIST , 931 14th Ave , Campbell River , BC 03/23/2013 12:44:16",
        "CALL:FIRST RESP ASSIST",
        "ADDR:931 14th Ave",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:12:44:16");

    doTest("T82",
        "(Fire Dispatch) FIRST RESP C , 931 14th Ave , Campbell River , BC 03/23/2013 12:21:52",
        "CALL:FIRST RESP C",
        "ADDR:931 14th Ave",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:12:21:52");

    doTest("T83",
        "(Fire Dispatch) FIRST RESP D , 2267 Eardley Rd , Campbell River , BC 03/23/2013 07:06:55",
        "CALL:FIRST RESP D",
        "ADDR:2267 Eardley Rd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:07:06:55");

    doTest("T84",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT , 396 Harrogate Rd , Campbell River , BC 03/23/2013 01:33:46",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:396 Harrogate Rd",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:01:33:46");

    doTest("T85",
        "(Fire Dispatch) DUTY OFFICER , 1395 Maple St , Campbell River , BC 03/23/2013 00:41:22",
        "CALL:DUTY OFFICER",
        "ADDR:1395 Maple St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:00:41:22");

    doTest("T86",
        "(Fire Dispatch) FIRST RESP B , 331 Birch St , Campbell River , BC 03/23/2013 00:37:54",
        "CALL:FIRST RESP B",
        "ADDR:331 Birch St",
        "CITY:Campbell River",
        "DATE:03/23/2013",
        "TIME:00:37:54");

    doTest("T87",
        "(Fire Dispatch) DUTY OFFICER , 0 Roberts Reach , Campbell River , BC 03/22/2013 22:23:41",
        "CALL:DUTY OFFICER",
        "ADDR:Roberts Reach",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:22:23:41");

    doTest("T88",
        "(Fire Dispatch) FIRST RESP C , 1477 Island Hwy , Campbell River , BC 03/22/2013 20:16:48",
        "CALL:FIRST RESP C",
        "ADDR:1477 Island Hwy",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:20:16:48");

    doTest("T89",
        "(Fire Dispatch) FIRST RESP D , 84 Dogwood St , Campbell River , BC 03/22/2013 19:23:50",
        "CALL:FIRST RESP D",
        "ADDR:84 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:19:23:50");

    doTest("T90",
        "(Fire Dispatch) FIRST RESP D , Quattell Ave / Drake Rd , Campbell River , BC 03/22/2013 14:37:07",
        "CALL:FIRST RESP D",
        "ADDR:Quattell Ave & Drake Rd",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:14:37:07");

    doTest("T91",
        "(Fire Dispatch) FIRST RESP D , 1371 Cedar St , Campbell River , BC 03/22/2013 14:15:43",
        "CALL:FIRST RESP D",
        "ADDR:1371 Cedar St",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:14:15:43");

    doTest("T92",
        "(Fire Dispatch) ALARMS , 710 Dogwood St , Campbell River , BC 03/22/2013 13:17:03",
        "CALL:ALARMS",
        "ADDR:710 Dogwood St",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:13:17:03");

    doTest("T93",
        "(Fire Dispatch) FIRST RESP E , 153 Reef Cres , Campbell River , BC 03/22/2013 10:38:22",
        "CALL:FIRST RESP E",
        "ADDR:153 Reef Cres",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:10:38:22");

    doTest("T94",
        "(Fire Dispatch) FIRST RESP B , 555 2nd Ave , Campbell River , BC 03/22/2013 02:57:15",
        "CALL:FIRST RESP B",
        "ADDR:555 2nd Ave",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:02:57:15");

    doTest("T95",
        "(Fire Dispatch) FIRST RESP C , 2356 Coho Rd , Campbell River , BC 03/22/2013 01:44:33",
        "CALL:FIRST RESP C",
        "ADDR:2356 Coho Rd",
        "CITY:Campbell River",
        "DATE:03/22/2013",
        "TIME:01:44:33");

    doTest("T96",
        "(Fire Dispatch) FIRST RESP B , 1381 Cedar St , Campbell River , BC 03/21/2013 22:16:44",
        "CALL:FIRST RESP B",
        "ADDR:1381 Cedar St",
        "CITY:Campbell River",
        "DATE:03/21/2013",
        "TIME:22:16:44");

    doTest("T97",
        "(Fire Dispatch) FIRST RESP B , S Dogwood St / Pinecrest Rd , Campbell River , BC 03/21/2013 22:03:36",
        "CALL:FIRST RESP B",
        "ADDR:S Dogwood St & Pinecrest Rd",
        "CITY:Campbell River",
        "DATE:03/21/2013",
        "TIME:22:03:36");

    doTest("T98",
        "(Fire Dispatch) FIRST RESP ASSIST , 365 Niluht Rd , Campbell River , BC 03/21/2013 19:00:32",
        "CALL:FIRST RESP ASSIST",
        "ADDR:365 Niluht Rd",
        "CITY:Campbell River",
        "DATE:03/21/2013",
        "TIME:19:00:32");

    doTest("T99",
        "(Fire Dispatch) FIRST RESP B , Petersen Rd / Island Hwy , Campbell River , BC 03/21/2013 18:46:04",
        "CALL:FIRST RESP B",
        "ADDR:Petersen Rd & Island Hwy",
        "CITY:Campbell River",
        "DATE:03/21/2013",
        "TIME:18:46:04");

    doTest("T100",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT , Petersen Rd / Island Hwy , Campbell River , BC 03/21/2013 18:46:04",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Petersen Rd & Island Hwy",
        "CITY:Campbell River",
        "DATE:03/21/2013",
        "TIME:18:46:04");
  }
  
  @Test
  public void testComox() {
    
    doTest("T1",
        "(Fire Dispatch) BEACH/BRUSH/MISC OUT EMERG 1498 Noel Ave , Comox ,BC 04/03/2013 19:42:41",
        "CALL:BEACH/BRUSH/MISC OUT EMERG",
        "ADDR:1498 Noel Ave",
        "CITY:Comox",
        "DATE:04/03/2013",
        "TIME:19:42:41");

    doTest("T2",
        "(Fire Dispatch) FIRST RESP D 2158 Downey Ave , Comox ,BC 04/03/2013 06:49:20",
        "CALL:FIRST RESP D",
        "ADDR:2158 Downey Ave",
        "CITY:Comox",
        "DATE:04/03/2013",
        "TIME:06:49:20");

    doTest("T3",
        "(Fire Dispatch) FIRST RESP D 660 PRITCHARD RD , Comox ,BC 04/03/2013 04:13:55",
        "CALL:FIRST RESP D",
        "ADDR:660 PRITCHARD RD",
        "CITY:Comox",
        "DATE:04/03/2013",
        "TIME:04:13:55");

    doTest("T4",
        "(Fire Dispatch) CHIMNEY FIRE 1517 Kye Bay Rd , Comox ,BC 04/02/2013 20:25:16",
        "CALL:CHIMNEY FIRE",
        "ADDR:1517 Kye Bay Rd",
        "CITY:Comox",
        "DATE:04/02/2013",
        "TIME:20:25:16");

    doTest("T5",
        "(Fire Dispatch) CHIMNEY FIRE 1646 Maquinna Ave , Comox ,BC 04/02/2013 17:39:31",
        "CALL:CHIMNEY FIRE",
        "ADDR:1646 Maquinna Ave",
        "CITY:Comox",
        "DATE:04/02/2013",
        "TIME:17:39:31");

    doTest("T6",
        "(Fire Dispatch) DUTY OFFICER 0 School - Brooklyn-lazo Campus , Comox ,BC 04/02/2013 11:13:55",
        "CALL:DUTY OFFICER",
        "ADDR:School - Brooklyn-lazo Campus",
        "CITY:Comox",
        "DATE:04/02/2013",
        "TIME:11:13:55");

    doTest("T7",
        "(Fire Dispatch) DUTY OFFICER 286 Curtis Rd , Comox ,BC 04/01/2013 20:10:17",
        "CALL:DUTY OFFICER",
        "ADDR:286 Curtis Rd",
        "CITY:Comox",
        "DATE:04/01/2013",
        "TIME:20:10:17");

    doTest("T8",
        "(Fire Dispatch) DUTY OFFICER 2275 Comox Ave , Comox ,BC 03/31/2013 22:25:04",
        "CALL:DUTY OFFICER",
        "ADDR:2275 Comox Ave",
        "CITY:Comox",
        "DATE:03/31/2013",
        "TIME:22:25:04");

    doTest("T9",
        "(Fire Dispatch) FIRST RESP D 1501 Balmoral Ave , Comox ,BC 03/28/2013 18:14:41",
        "CALL:FIRST RESP D",
        "ADDR:1501 Balmoral Ave",
        "CITY:Comox",
        "DATE:03/28/2013",
        "TIME:18:14:41");

    doTest("T10",
        "(Fire Dispatch) ALARMS 155 Donovan Dr , Comox ,BC 03/27/2013 04:25:21",
        "CALL:ALARMS",
        "ADDR:155 Donovan Dr",
        "CITY:Comox",
        "DATE:03/27/2013",
        "TIME:04:25:21");

    doTest("T11",
        "(Fire Dispatch) FIRST RESP D 1396 Hudson Rd , Comox ,BC 03/26/2013 16:40:04",
        "CALL:FIRST RESP D",
        "ADDR:1396 Hudson Rd",
        "CITY:Comox",
        "DATE:03/26/2013",
        "TIME:16:40:04");

    doTest("T12",
        "(Fire Dispatch) DUTY OFFICER 2047 Beach Dr , Comox ,BC 03/25/2013 18:42:31",
        "CALL:DUTY OFFICER",
        "ADDR:2047 Beach Dr",
        "CITY:Comox",
        "DATE:03/25/2013",
        "TIME:18:42:31");

    doTest("T13",
        "(Fire Dispatch) STRUCTURE FIRE Guthrie Rd / Anderton Rd , Comox ,BC 03/25/2013 15:25:14",
        "CALL:STRUCTURE FIRE",
        "ADDR:Guthrie Rd & Anderton Rd",
        "CITY:Comox",
        "DATE:03/25/2013",
        "TIME:15:25:14");

    doTest("T14",
        "(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 03/21/2013 20:37:57",
        "CALL:FIRST RESP D",
        "ADDR:1700 Comox Ave",
        "CITY:Comox",
        "DATE:03/21/2013",
        "TIME:20:37:57");

    doTest("T15",
        "(Fire Dispatch) FIRST RESP D 1854 Beaufort Ave , Comox ,BC 03/20/2013 16:56:23",
        "CALL:FIRST RESP D",
        "ADDR:1854 Beaufort Ave",
        "CITY:Comox",
        "DATE:03/20/2013",
        "TIME:16:56:23");

    doTest("T16",
        "(Fire Dispatch) FIRST RESP D 1822 Comox Ave , Comox ,BC 03/20/2013 13:36:10",
        "CALL:FIRST RESP D",
        "ADDR:1822 Comox Ave",
        "CITY:Comox",
        "DATE:03/20/2013",
        "TIME:13:36:10");

    doTest("T17",
        "(Fire Dispatch) FIRST RESP D 980 Anderton Rd , Comox ,BC 03/19/2013 22:36:04",
        "CALL:FIRST RESP D",
        "ADDR:980 Anderton Rd",
        "CITY:Comox",
        "DATE:03/19/2013",
        "TIME:22:36:04");

    doTest("T18",
        "(Fire Dispatch) FIRST RESP D 1683 Balmoral Ave , Comox ,BC 03/19/2013 02:52:32",
        "CALL:FIRST RESP D",
        "ADDR:1683 Balmoral Ave",
        "CITY:Comox",
        "DATE:03/19/2013",
        "TIME:02:52:32");

    doTest("T19",
        "(Fire Dispatch) FIRST RESP D 1250 Knight Rd , Comox ,BC 03/18/2013 13:34:58",
        "CALL:FIRST RESP D",
        "ADDR:1250 Knight Rd",
        "CITY:Comox",
        "DATE:03/18/2013",
        "TIME:13:34:58");

    doTest("T20",
        "(Fire Dispatch) FIRST RESP D 1427 Noel Ave , Comox ,BC 03/18/2013 00:35:54",
        "CALL:FIRST RESP D",
        "ADDR:1427 Noel Ave",
        "CITY:Comox",
        "DATE:03/18/2013",
        "TIME:00:35:54");

    doTest("T21",
        "(Fire Dispatch) FIRST RESP D 1729 Comox Ave , Comox ,BC 03/17/2013 11:47:37",
        "CALL:FIRST RESP D",
        "ADDR:1729 Comox Ave",
        "CITY:Comox",
        "DATE:03/17/2013",
        "TIME:11:47:37");

    doTest("T22",
        "(Fire Dispatch) FIRST RESP D 1681 Belair Rd , Comox ,BC 03/16/2013 04:21:25",
        "CALL:FIRST RESP D",
        "ADDR:1681 Belair Rd",
        "CITY:Comox",
        "DATE:03/16/2013",
        "TIME:04:21:25");

    doTest("T23",
        "(Fire Dispatch) ALARMS 121 Port Augusta St , Comox ,BC 03/15/2013 13:46:56",
        "CALL:ALARMS",
        "ADDR:121 Port Augusta St",
        "CITY:Comox",
        "DATE:03/15/2013",
        "TIME:13:46:56");

    doTest("T24",
        "(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 03/13/2013 23:07:28",
        "CALL:FIRST RESP D",
        "ADDR:2181 Comox Ave",
        "CITY:Comox",
        "DATE:03/13/2013",
        "TIME:23:07:28");

    doTest("T25",
        "(Fire Dispatch) FIRST RESP D 417 Heather Crt , Comox ,BC 03/12/2013 13:03:01",
        "CALL:FIRST RESP D",
        "ADDR:417 Heather Crt",
        "CITY:Comox",
        "DATE:03/12/2013",
        "TIME:13:03:01");

    doTest("T26",
        "(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 03/11/2013 17:04:04",
        "CALL:FIRST RESP D",
        "ADDR:1700 Comox Ave",
        "CITY:Comox",
        "DATE:03/11/2013",
        "TIME:17:04:04");

    doTest("T27",
        "(Fire Dispatch) DUTY OFFICER 1860 Comox Ave , Comox ,BC 03/10/2013 23:09:42",
        "CALL:DUTY OFFICER",
        "ADDR:1860 Comox Ave",
        "CITY:Comox",
        "DATE:03/10/2013",
        "TIME:23:09:42");

    doTest("T28",
        "(Fire Dispatch) FIRST RESP D 874 Knight Rd , Comox ,BC 03/10/2013 20:23:19",
        "CALL:FIRST RESP D",
        "ADDR:874 Knight Rd",
        "CITY:Comox",
        "DATE:03/10/2013",
        "TIME:20:23:19");

    doTest("T29",
        "(Fire Dispatch) FIRST RESP D 3216 Back Rd , Comox ,BC 03/10/2013 15:04:54",
        "CALL:FIRST RESP D",
        "ADDR:3216 Back Rd",
        "CITY:Comox",
        "DATE:03/10/2013",
        "TIME:15:04:54");

    doTest("T30",
        "(Fire Dispatch) FIRST RESP D 2117 Bambrick Pl , Comox ,BC 03/10/2013 09:35:24",
        "CALL:FIRST RESP D",
        "ADDR:2117 Bambrick Pl",
        "CITY:Comox",
        "DATE:03/10/2013",
        "TIME:09:35:24");

    doTest("T31",
        "(Fire Dispatch) FIRST RESP D 2275 Guthrie Rd , Comox ,BC 03/09/2013 20:59:02",
        "CALL:FIRST RESP D",
        "ADDR:2275 Guthrie Rd",
        "CITY:Comox",
        "DATE:03/09/2013",
        "TIME:20:59:02");

    doTest("T32",
        "(Fire Dispatch) FIRST RESP D 800 Highwood Dr , Comox ,BC 03/09/2013 19:29:23",
        "CALL:FIRST RESP D",
        "ADDR:800 Highwood Dr",
        "CITY:Comox",
        "DATE:03/09/2013",
        "TIME:19:29:23");

    doTest("T33",
        "(Fire Dispatch) DUTY OFFICER 464 Lazo Rd , Comox ,BC 03/09/2013 18:37:03",
        "CALL:DUTY OFFICER",
        "ADDR:464 Lazo Rd",
        "CITY:Comox",
        "DATE:03/09/2013",
        "TIME:18:37:03");

    doTest("T34",
        "(Fire Dispatch) FIRST RESP D 2151 Bolt Ave , Comox ,BC 03/08/2013 08:36:51",
        "CALL:FIRST RESP D",
        "ADDR:2151 Bolt Ave",
        "CITY:Comox",
        "DATE:03/08/2013",
        "TIME:08:36:51");

    doTest("T35",
        "(Fire Dispatch) FIRST RESP E 1680 E Centennial Ave , Comox ,BC 03/06/2013 11:37:39",
        "CALL:FIRST RESP E",
        "ADDR:1680 E Centennial Ave",
        "CITY:Comox",
        "DATE:03/06/2013",
        "TIME:11:37:39");

    doTest("T36",
        "(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 03/06/2013 09:07:06",
        "CALL:FIRST RESP D",
        "ADDR:2181 Comox Ave",
        "CITY:Comox",
        "DATE:03/06/2013",
        "TIME:09:07:06");

    doTest("T37",
        "(Fire Dispatch) DUTY OFFICER 2059 Beach Dr , Comox ,BC 03/03/2013 18:57:59",
        "CALL:DUTY OFFICER",
        "ADDR:2059 Beach Dr",
        "CITY:Comox",
        "DATE:03/03/2013",
        "TIME:18:57:59");

    doTest("T38",
        "(Fire Dispatch) DUTY OFFICER 0 Unsigned , Comox ,BC 03/02/2013 14:10:25",
        "CALL:DUTY OFFICER",
        "ADDR:Unsigned",
        "CITY:Comox",
        "DATE:03/02/2013",
        "TIME:14:10:25");

    doTest("T39",
        "(Fire Dispatch) FIRST RESP D 695 Totem Cres , Comox ,BC 03/02/2013 01:36:06",
        "CALL:FIRST RESP D",
        "ADDR:695 Totem Cres",
        "CITY:Comox",
        "DATE:03/02/2013",
        "TIME:01:36:06");

    doTest("T40",
        "(Fire Dispatch) FIRST RESP D 1950 Comox Ave , Comox ,BC 03/01/2013 23:09:55",
        "CALL:FIRST RESP D",
        "ADDR:1950 Comox Ave",
        "CITY:Comox",
        "DATE:03/01/2013",
        "TIME:23:09:55");

    doTest("T41",
        "(Fire Dispatch) FIRST RESP D 2300 Murrelet Dr , Comox ,BC 03/01/2013 03:17:31",
        "CALL:FIRST RESP D",
        "ADDR:2300 Murrelet Dr",
        "CITY:Comox",
        "DATE:03/01/2013",
        "TIME:03:17:31");

    doTest("T42",
        "(Fire Dispatch) FIRST RESP DELAY B/C 610 Bunting Pl , Comox ,BC 02/28/2013 20:45:16",
        "CALL:FIRST RESP DELAY B/C",
        "ADDR:610 Bunting Pl",
        "CITY:Comox",
        "DATE:02/28/2013",
        "TIME:20:45:16");

    doTest("T43",
        "(Fire Dispatch) FIRST RESP ASSIST D/E 677 Bunting Pl , Comox ,BC 02/27/2013 14:57:32",
        "CALL:FIRST RESP ASSIST D/E",
        "ADDR:677 Bunting Pl",
        "CITY:Comox",
        "DATE:02/27/2013",
        "TIME:14:57:32");

    doTest("T44",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT 301 Curtis Rd , Comox ,BC 02/26/2013 20:14:55",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:301 Curtis Rd",
        "CITY:Comox",
        "DATE:02/26/2013",
        "TIME:20:14:55");

    doTest("T45",
        "(Fire Dispatch) FIRST RESP D 301 Curtis Rd , Comox ,BC 02/26/2013 20:14:55",
        "CALL:FIRST RESP D",
        "ADDR:301 Curtis Rd",
        "CITY:Comox",
        "DATE:02/26/2013",
        "TIME:20:14:55");

    doTest("T46",
        "(Fire Dispatch) FIRST RESP E 687 Moralee Dr , Comox ,BC 02/25/2013 10:42:41",
        "CALL:FIRST RESP E",
        "ADDR:687 Moralee Dr",
        "CITY:Comox",
        "DATE:02/25/2013",
        "TIME:10:42:41");

    doTest("T47",
        "(Fire Dispatch) DUTY OFFICER 1900 Burdyny Rd , Comox ,BC 02/24/2013 12:01:20",
        "CALL:DUTY OFFICER",
        "ADDR:1900 Burdyny Rd",
        "CITY:Comox",
        "DATE:02/24/2013",
        "TIME:12:01:20");

    doTest("T48",
        "(Fire Dispatch) FIRST RESP D 310 Aitken St , Comox ,BC 02/24/2013 10:00:33",
        "CALL:FIRST RESP D",
        "ADDR:310 Aitken St",
        "CITY:Comox",
        "DATE:02/24/2013",
        "TIME:10:00:33");

    doTest("T49",
        "(Fire Dispatch) FIRST RESP D 473 Holly Pl , Comox ,BC 02/23/2013 07:24:07",
        "CALL:FIRST RESP D",
        "ADDR:473 Holly Pl",
        "CITY:Comox",
        "DATE:02/23/2013",
        "TIME:07:24:07");

    doTest("T50",
        "(Fire Dispatch) FIRST RESP D 315 Denman St , Comox ,BC 02/23/2013 05:45:28",
        "CALL:FIRST RESP D",
        "ADDR:315 Denman St",
        "CITY:Comox",
        "DATE:02/23/2013",
        "TIME:05:45:28");

    doTest("T51",
        "(Fire Dispatch) FIRST RESP D 2181 Comox Ave , Comox ,BC 02/22/2013 19:04:08",
        "CALL:FIRST RESP D",
        "ADDR:2181 Comox Ave",
        "CITY:Comox",
        "DATE:02/22/2013",
        "TIME:19:04:08");

    doTest("T52",
        "(Fire Dispatch) FIRST RESP D 1700 Comox Ave , Comox ,BC 02/22/2013 18:20:11",
        "CALL:FIRST RESP D",
        "ADDR:1700 Comox Ave",
        "CITY:Comox",
        "DATE:02/22/2013",
        "TIME:18:20:11");

    doTest("T53",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Anderton Rd / Guthrie Rd , Comox ,BC 02/22/2013 16:27:28",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Anderton Rd & Guthrie Rd",
        "CITY:Comox",
        "DATE:02/22/2013",
        "TIME:16:27:28");

    doTest("T54",
        "(Fire Dispatch) MOTOR VEHICLE ACCIDENT Pritchard Rd / Dogwood Ave , Comox ,BC 02/20/2013 18:53:40",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:Pritchard Rd & Dogwood Ave",
        "CITY:Comox",
        "DATE:02/20/2013",
        "TIME:18:53:40");

    doTest("T55",
        "(Fire Dispatch) MOTOR VEHICLE FIRE Pritchard Rd / Dogwood Ave , Comox ,BC 02/20/2013 18:53:40",
        "CALL:MOTOR VEHICLE FIRE",
        "ADDR:Pritchard Rd & Dogwood Ave",
        "CITY:Comox",
        "DATE:02/20/2013",
        "TIME:18:53:40");

    doTest("T56",
        "(Fire Dispatch) FIRST RESP D 1547 Balsam Ave , Comox ,BC 02/20/2013 17:11:55",
        "CALL:FIRST RESP D",
        "ADDR:1547 Balsam Ave",
        "CITY:Comox",
        "DATE:02/20/2013",
        "TIME:17:11:55");

    doTest("T57",
        "(Fire Dispatch) FIRST RESP D 1600 Comox Ave , Comox ,BC 02/20/2013 14:44:53",
        "CALL:FIRST RESP D",
        "ADDR:1600 Comox Ave",
        "CITY:Comox",
        "DATE:02/20/2013",
        "TIME:14:44:53");

    doTest("T58",
        "(Fire Dispatch) TEST 0 Fire Station Comox , Comox ,BC 02/20/2013 13:11:44",
        "CALL:TEST",
        "ADDR:Fire Station Comox",
        "CITY:Comox",
        "DATE:02/20/2013",
        "TIME:13:11:44");
  }
  
  public static void main(String[] args) {
    new ZCABCMidIslandRegionParserTest().generateTests("T1");
  }
}