package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
McHenry County, IL
Contact: Active911
Agency name: Huntley Fire Department
Location: Huntley, IL, United States
Sender: DoNotReply@mcetsb.org 

(HUFD Dispatch) #\nType: AMB\nOCA : 1301427\nDate: 5/8/2013 21:03:24\nLoca: 270 WEDGEWOOD CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301426\nDate: 5/8/2013 19:02:44\nLoca: 5353 LANSBURY CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301425\nDate: 5/8/2013 18:15:19\nLoca: 7 SAVOY CT\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301424\nDate: 5/8/2013 18:05:30\nLoca: 5 NEWBURY CT\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301422\nDate: 5/8/2013 15:14:22\nLoca: 4870 HIGHWOOD LN\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301421\nDate: 5/8/2013 15:05:33\nLoca: 12723 HARMONY RD\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301419\nDate: 5/8/2013 11:56:01\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301418\nDate: 5/8/2013 11:41:43\nLoca: 13574 LEHIGH ST\nCity: HUNTLEY
(HUFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301417\nDate: 5/8/2013 11:00:59\nLoca: 1 FEATHERSTONE CT\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301416\nDate: 5/8/2013 10:17:03\nLoca: 14088 SUNDANCE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301415\nDate: 5/7/2013 23:49:48\nLoca: 260 BRIDLEWOOD CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301414\nDate: 5/7/2013 23:41:41\nLoca: 13544 BONAIRE RD\nCity: HUNTLEY
(HUFD Dispatch) #\nType: LOCKOUT\nOCA : 1301413\nDate: 5/7/2013 18:46:36\nLoca: 10738 SHENANDOAH DR\nCity: HUNTLEY
(HUFD Dispatch) #\nType: TA\nOCA : 1301412\nDate: 5/7/2013 17:43:11\nLoca: 12300 S ROUTE 47 HY\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301411\nDate: 5/7/2013 17:37:11\nLoca: 9431 WELSH LN\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AOA\nOCA : 1301410\nDate: 5/7/2013 15:49:29\nLoca: =8  ASTEC CT\nCity: SELECT
(HUFD Dispatch) #\nType: ACCI\nOCA : 1301409\nDate: 5/7/2013 14:45:10\nLoca: MAIN ST // ROUTE 47 HY\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301408\nDate: 5/7/2013 14:18:52\nLoca: 10065 CUMMINGS ST\nCity: HUNTLEY
(HUFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301407\nDate: 5/7/2013 13:30:25\nLoca: 11272 KINGSBURY CT\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301406\nDate: 5/7/2013 10:27:18\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301405\nDate: 5/7/2013 09:56:54\nLoca: 13380 MOCKINGBIRD CT\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301404\nDate: 5/7/2013 07:02:41\nLoca: 2206 PEMBRIDGE DR\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301403\nDate: 5/7/2013 03:36:50\nLoca: 12642 ROCK ISLAND TR\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301402\nDate: 5/7/2013 00:16:04\nLoca: 2361 STANTON CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nType: AMB\nOCA : 1301401\nDate: 5/6/2013 21:38:14\nLoca: 11171 DEVON LN\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301400\nDate: 5/6/2013 18:04:33\nLoca: 10350 HALIGUS RD\nCity: HUNTLEY
(HUFD Dispatch) #\nType: AMB\nOCA : 1301398\nDate: 5/6/2013 14:44:39\nLoca: 11262 EDINBURGH LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301397\nType: FIRE\nDate: 5/6/2013 12:05:06\nLoca: 2800 CADBURY CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301396\nType: AMB\nDate: 5/6/2013 10:51:49\nLoca: 10350 HALIGUS RD\nApt : 200\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301395\nType: AMB\nDate: 5/6/2013 10:14:49\nLoca: 12502 WEDGEMERE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301393\nType: AMB\nDate: 5/6/2013 08:51:00\nLoca: 12557 W PHEASANT RIDGE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301392\nType: AMB\nDate: 5/6/2013 06:59:18\nLoca: 13120 COLD SPRINGS DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301391\nType: ALARMF\nDate: 5/6/2013 03:37:56\nLoca: 11321 SMITH DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301390\nType: AMB\nDate: 5/6/2013 01:53:04\nLoca: 5390 AVALON LN\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301389\nType: AMB\nDate: 5/5/2013 23:26:48\nLoca: 12452 ROLLING MEADOWS LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301388\nType: SMOKE\nDate: 5/5/2013 22:34:54\nLoca: 460 TENBY WY\nCity: ALGONQUIN\nCros: WHITEHALL LN
(HUFD Dispatch) #\nOCA : 1301387\nType: AMB\nDate: 5/5/2013 22:16:03\nLoca: 12642 ROCK ISLAND TR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301386\nType: AMB\nDate: 5/5/2013 17:56:45\nLoca: 11775 MESSINER DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301385\nType: AMB\nDate: 5/5/2013 16:58:32\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301384\nType: AMB\nDate: 5/5/2013 14:51:27\nLoca: 14162 VIOLA PL\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301383\nType: SMOKE\nDate: 5/5/2013 14:27:44\nLoca: 12183 SPRING CREEK DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301382\nType: AMB\nDate: 5/5/2013 08:50:27\nLoca: 10805 E MAIN ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301381\nType: AMB\nDate: 5/5/2013 07:58:29\nLoca: 13654 PENEFIELD LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301380\nType: AMB\nDate: 5/5/2013 06:07:10\nLoca: 12293 DAFFODIL DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301379\nType: AMB\nDate: 5/5/2013 00:05:05\nLoca: 2510 FAIRFAX LN\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301378\nType: AMB\nDate: 5/4/2013 23:27:12\nLoca: 3961 GEORGETOWN CI\nCity: ALGONQUIN\nCros: BUNKER HILL DR
(HUFD Dispatch) #\nOCA : 1301377\nType: ALARMF\nDate: 5/4/2013 20:35:35\nLoca: 11321 SMITH DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301376\nType: ACCI\nDate: 5/4/2013 17:10:22\nLoca: 12819 W HIGHLAND LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301375\nType: LOCKOUT\nDate: 5/4/2013 15:49:06\nLoca: 13551 WINDY PRAIRIE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301374\nType: AMB\nDate: 5/4/2013 14:39:31\nLoca: 12015 MILL ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301373\nType: AMB\nDate: 5/4/2013 12:23:26\nLoca: 11713 E MAIN ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301372\nType: AMB\nDate: 5/4/2013 10:28:47\nLoca: 11797 BORHART DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301371\nType: ASSISTFIRE\nDate: 5/4/2013 09:46:56\nLoca: 12220 PRINCETON DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301370\nType: AMB\nDate: 5/3/2013 21:40:56\nLoca: 14259 NEWPORT CI\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301369\nType: AMB\nDate: 5/3/2013 20:40:58\nLoca: 10711 N ROUTE 47 HY\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301368\nType: WIRE\nDate: 5/3/2013 19:53:04\nLoca: POWERS RD // FREEMAN RD\nCity: GILBERTS
(HUFD Dispatch) #\nOCA : 1301367\nType: AMB\nDate: 5/3/2013 19:46:11\nLoca: 11325 HEATHERDALE LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301366\nType: AMB\nDate: 5/3/2013 19:39:58\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301365\nType: AMB\nDate: 5/3/2013 19:21:08\nLoca: 13624 WHITTINGHAM LN\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301364\nType: AMB\nDate: 5/3/2013 16:00:38\nLoca: 8 LARKSPUR CT\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301363\nType: ACCI\nDate: 5/3/2013 15:20:41\nLoca: I90 HY // 51.00 MARKER\nCity: ELGIN
(HUFD Dispatch) #\nOCA : 1301362\nType: AMB\nDate: 5/3/2013 13:59:43\nLoca: 11811 OAK CREEK PW\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301361\nType: AMB\nDate: 5/3/2013 10:40:41\nLoca: 13591 WINDY PRAIRIE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301360\nType: AMB\nDate: 5/3/2013 09:27:21\nLoca: 11 WEDGEWOOD CI\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301359\nType: AMB\nDate: 5/3/2013 08:33:51\nLoca: 13049 REDSTONE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301358\nType: AMB\nDate: 5/3/2013 06:56:45\nLoca: 11775 MESSINER DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301357\nType: AMB\nDate: 5/3/2013 06:04:49\nLoca: 12471 WEDGEMERE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301356\nType: AOA\nDate: 5/3/2013 04:48:01\nLoca: 2510 ROUTE 176 HY\nApt : D\nCity: PRAIRIE GROVE\nDist: 4
(HUFD Dispatch) #\nOCA : 1301355\nType: AMB\nDate: 5/2/2013 22:41:20\nLoca: 11721 E MAIN ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301354\nType: AOA\nDate: 5/2/2013 21:09:34\nLoca: ROUTE 72 // NEW LEBANON\nCity: HAMPSHIRE
(HUFD Dispatch) #\nOCA : 1301353\nType: AMB\nDate: 5/2/2013 11:12:02\nLoca: 830 DOGWOOD LN\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301350\nType: ALARMF\nDate: 5/2/2013 05:43:53\nLoca: 13320 S ROUTE 47 HY\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301349\nType: AMB\nDate: 5/2/2013 05:42:36\nLoca: 9793 COMPTON DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301348\nType: AMB\nDate: 5/2/2013 03:59:38\nLoca: 9934 BEDFORD DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301347\nType: AMB\nDate: 5/2/2013 03:57:01\nLoca: 985 ASTER CT\nCity: LAKE IN THE HILLS
(HUFD Dispatch) #\nOCA : 1301346\nType: AMB\nDate: 5/1/2013 19:23:46\nLoca: 14037 VERBEND PATH\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301345\nType: AMB\nDate: 5/1/2013 18:44:46\nLoca: 12715 HORSESHOE TR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301344\nType: AMB\nDate: 5/1/2013 16:48:35\nLoca: 12860 DEL WEBB BL\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301343\nType: FIRE\nDate: 5/1/2013 15:29:10\nLoca: 3217 CARRINGTON DR\nCity: CRYSTAL LAKE\nCros: REMINGTON DR\nDist: 13
(HUFD Dispatch) #\nOCA : 1301342\nType: MISC\nDate: 5/1/2013 14:25:28\nLoca: 10350 HALIGUS RD\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301341\nType: ALARMF\nDate: 5/1/2013 12:35:31\nLoca: 10289 N VINE ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301340\nType: AMB\nDate: 5/1/2013 12:01:13\nLoca: 14102 VIOLA PL\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301339\nType: AMB\nDate: 5/1/2013 10:52:44\nLoca: 12993 BROOKWOOD DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301338\nType: AMB\nDate: 5/1/2013 09:30:07\nLoca: 12450 REGENCY PK\nApt : 272\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301337\nType: ALARMF\nDate: 5/1/2013 04:03:55\nLoca: 13320 S ROUTE 47 HY\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301336\nType: AMB\nDate: 5/1/2013 03:54:13\nLoca: 11473 WILDROSE DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301334\nType: ALARMF\nDate: 5/1/2013 00:50:36\nLoca: 13320 VILLAGE GREEN DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301333\nType: ALARMF\nDate: 4/30/2013 16:32:50\nLoca: 11707 DEAN ST\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301332\nType: ACCI\nDate: 4/30/2013 15:34:03\nLoca: I90 HY // 44.75 MARKER\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301331\nType: ALARMF\nDate: 4/30/2013 14:59:25\nLoca: 11800 FACTORY SHOPS BL\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301330\nType: ACCI\nDate: 4/30/2013 12:18:38\nLoca: COLD SPRINGS DR // FARM HILL DR\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301329\nType: FIREBRUSH\nDate: 4/30/2013 11:30:03\nLoca: 11002 BONNIE BRAE RD\nCity: HUNTLEY
(HUFD Dispatch) #\nOCA : 1301328\nType: AMB\nDate: 4/30/2013 10:44:31\nLoca: 725 ACADEMIC DR\nCity: ALGONQUIN\nCros: SQUARE BARN RD
(HUFD Dispatch) #\nOCA : 1301327\nType: AMB\nDate: 4/30/2013 01:42:34\nLoca: 11 LARKSPUR CT\nCity: LAKE IN THE HILLS

Contact: Active911
Agency name: McHenry County Sheriffs Office
Location: Woodstock, IL, United States
Sender: DoNotReply@mcetsb.org

(WLFD Dispatch) #\nOCA : 1300283\nType: AMB\nDate: 4/23/2013 14:52:21\nLoca: 5212 BONG ST\nCity: WONDER LAKE\nDist: 121
(RMFD Dispatch) #\nOCA : 1300166\nType: AMB\nDate: 4/23/2013 14:28:14\nLoca: 10011 CHARLES ST\nCity: RICHMOND\nCros: SOUTH ST\nDist: 311
(HAFD Dispatch) #\nOCA : 1300288\nType: AMB\nDate: 4/23/2013 13:06:49\nLoca: 54 AUTUMN GLEN DR\nApt : 201\nCity: HARVARD\nDist: 784
(WLFD Dispatch) #\nOCA : 1300282\nType: AMB\nDate: 4/23/2013 11:24:02\nLoca: 3145 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 125
(RMFD Dispatch) #\nOCA : 1300165\nType: ALARMF\nDate: 4/23/2013 11:19:34\nLoca: 5205 ROUTE 12 HY\nCity: RICHMOND\nCros: KUNH RD\nDist: 813
(RMFD Dispatch) #\nOCA : 1300164\nType: FIRE\nDate: 4/23/2013 11:18:48\nLoca: 8109 ROUTE 31 HY\nCity: RICHMOND\nCros: JAMES R RAKOW RD\nDist: 701
(RMFD Dispatch) #\nOCA : 1300163\nType: AMB\nDate: 4/22/2013 09:59:55\nLoca: 5412 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411
(HAFD Dispatch) #\nOCA : 1300287\nType: AMB\nDate: 4/22/2013 08:22:08\nLoca: 1409 WILLOW LN\nCity: HARVARD\nDist: 784
(WLFD Dispatch) #\nOCA : 1300281\nType: AMB\nDate: 4/21/2013 22:33:41\nLoca: 5408 SUMMERVILLE DR\nCity: WONDER LAKE\nDist: 121
(RMFD Dispatch) #\nOCA : 1300162\nType: AMB\nDate: 4/21/2013 20:58:17\nLoca: 5600 HUNTER DR\nCity: RICHMOND\nCros: PRAIRIE RIDGE\nDist: 410
(WLFD Dispatch) #\nOCA : 1300280\nType: AMB\nDate: 4/21/2013 16:03:03\nLoca: 4300 E WONDER LAKE RD\nCity: WONDER LAKE\nCros: CENTER\nDist: 122
(ALFD Dispatch) #\nOCA : 1301202\nType: RESCUEWATER\nDate: 4/21/2013 14:53:45\nLoca: RIVER RD // ALGONQUIN RD\nCity: ALGONQUIN\nCros: CRABAPPLE DR\nDist: 31
(HAFD Dispatch) #\nOCA : 1300286\nType: AMB\nDate: 4/21/2013 14:41:47\nLoca: 10901 ALDEN RD\nCity: HARVARD\nCros: HEBRON RD\nDist: 781
(WLFD Dispatch) #\nOCA : 1300279\nType: AMB\nDate: 4/21/2013 11:08:53\nLoca: 8808 BURTON RD\nCity: WONDER LAKE\nDist: 217
(RMFD Dispatch) #\nOCA : 1300161\nType: AOA\nDate: 4/21/2013 10:27:45\nLoca: N1159 COUNTY HY H\nCity: GENOA CITY\nCros: HIGH RD
(RMFD Dispatch) #\nOCA : 1300160\nType: AOA\nDate: 4/21/2013 02:11:49\nLoca: 600 N LAKE AVE\nCity: TWIN LAKES
(HAFD Dispatch) #\nOCA : 1300285\nType: AMB\nDate: 4/20/2013 23:59:25\nLoca: ROUTE 14 HY // OAK GROVE RD\nCity: HARVARD\nCros: SPRING ST\nDist: 781
(WLFD Dispatch) #\nOCA : 1300278\nType: AMB\nDate: 4/20/2013 21:25:21\nLoca: 5614 SYLVAN DR\nCity: WONDER LAKE\nDist: 121
(RMFD Dispatch) #\nOCA : 1300159\nType: AMB\nDate: 4/20/2013 20:04:18\nLoca: 5509 SOUTH ST\nCity: RICHMOND\nCros: EAST ST\nDist: 311
(WLFD Dispatch) #\nOCA : 1300277\nType: AMB\nDate: 4/20/2013 19:28:54\nLoca: 7222 N OAK ST\nCity: WONDER LAKE\nDist: 122
(WLFD Dispatch) #\nOCA : 1300276\nType: AOA\nDate: 4/20/2013 19:09:16\nLoca: 502 MCHENRY AV\nApt : 300\nCity: WOODSTOCK\nDist: 132
(HAFD Dispatch) #\nOCA : 1300284\nType: AMB\nDate: 4/20/2013 16:03:05\nLoca: 301 S DIVISION ST\nCity: HARVARD\nDist: 783
(SGFD Dispatch) #\nOCA : 1300191\nType: AMB\nDate: 4/20/2013 15:29:53\nLoca: 1419 MAIN ST\nCity: SPRING GROVE
(SGFD Dispatch) #\nOCA : 1300190\nType: ASSISTFIRE\nDate: 4/20/2013 11:46:48\nLoca: 39717 N WHITENBERG\nCity: ANTIOCH
(HAFD Dispatch) #\nOCA : 1300283\nType: AMB\nDate: 4/20/2013 09:59:24\nLoca: 341 MARENGO RD\nCity: HARVARD\nDist: 783
(HAFD Dispatch) #\nOCA : 1300282\nType: AMB\nDate: 4/20/2013 04:07:15\nLoca: 17605 MCGUIRE RD\nCity: HARVARD\nDist: 782
(HAFD Dispatch) #\nOCA : 1300281\nType: AMB\nDate: 4/20/2013 03:47:50\nLoca: 715 NORTHFIELD AV\nApt : 6\nCity: HARVARD\nDist: 784
(RMFD Dispatch) #\nOCA : 1300158\nType: AMB\nDate: 4/20/2013 03:11:11\nLoca: 5508 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411
(HAFD Dispatch) #\nOCA : 1300280\nType: AMB\nDate: 4/20/2013 01:29:12\nLoca: 15 N AYER ST\nCity: HARVARD\nDist: 784
(HAFD Dispatch) #\nOCA : 1300279\nType: AMB\nDate: 4/20/2013 01:12:08\nLoca: 201 W FRONT ST\nCity: HARVARD\nDist: 784
(SGFD Dispatch) #\nOCA : 1300189\nType: AMB\nDate: 4/20/2013 00:05:20\nLoca: 6720 JOHNSBURG RD\nCity: SPRING GROVE
(WLFD Dispatch) #\nOCA : 1300275\nType: AMB\nDate: 4/20/2013 00:02:48\nLoca: 3412 FAWN LN\nCity: WONDER LAKE\nDist: 123
(HAFD Dispatch) #\nOCA : 1300278\nType: AMB\nDate: 4/19/2013 22:41:25\nLoca: 20607 DUNHAM RD\nCity: MARENGO\nDist: 782
(HAFD Dispatch) #\nOCA : 1300277\nType: AMB\nDate: 4/19/2013 17:27:24\nLoca: 701 N HART ST\nCity: HARVARD\nDist: 781
(HAFD Dispatch) #\nOCA : 1300276\nType: AMB\nDate: 4/19/2013 16:59:34\nLoca: 17817 ROUTE 14 HY\nCity: HARVARD\nDist: 782
(WDFD Dispatch) #\nOCA : 1301217\nType: FIRE\nDate: 4/19/2013 15:54:40\nLoca: 1067 GREENWOOD CIR\nCity: WOODSTOCK\nCros: CARY RD
(WLFD Dispatch) #\nOCA : 1300273\nType: AMB\nDate: 4/19/2013 15:03:57\nLoca: 7609 LUCY DR\nCity: WONDER LAKE\nDist: 125
(HAFD Dispatch) #\nOCA : 1300275\nType: SMOKE\nDate: 4/19/2013 07:33:33\nLoca: 6915 OAK GROVE RD\nCity: HARVARD\nDist: 784
(MCFD Dispatch) #\nOCA : 1301318\nType: FIRE\nDate: 4/19/2013 07:12:23\nLoca: 905 HAYDEN DR\nCity: MCHENRY
(WLFD Dispatch) #\nOCA : 1300272\nType: AMB\nDate: 4/18/2013 19:32:51\nLoca: 9003 W SUNSET DR\nCity: WONDER LAKE\nDist: 217
(HAFD Dispatch) #\nOCA : 1300274\nType: ASSISTFIRE\nDate: 4/18/2013 18:01:59\nLoca: 11605 MAPLE AV\nCity: HEBRON\nCros: WOODLAND DR\nDist: 85
(SGFD Dispatch) #\nOCA : 1300188\nType: AMB\nDate: 4/18/2013 16:12:07\nLoca: 10810 RED HAWK LN\nCity: SPRING GROVE
(HAFD Dispatch) #\nOCA : 1300273\nType: AMB\nDate: 4/18/2013 15:49:36\nLoca: 714 W PARK ST\nCity: HARVARD\nDist: 784
(RMFD Dispatch) #\nOCA : 1300156\nType: ALARMF\nDate: 4/18/2013 15:37:51\nLoca: 8311 ROUTE 31 HY\nCity: RICHMOND\nCros: TRYON GROVE RD
(SGFD Dispatch) #\nOCA : 1300187\nType: AMB\nDate: 4/18/2013 14:32:45\nLoca: 7116 WILMOT RD\nCity: SPRING GROVE
(HAFD Dispatch) #\nOCA : 1300272\nType: AMB\nDate: 4/18/2013 08:58:34\nLoca: 1103 N JEFFERSON ST\nCity: HARVARD\nDist: 781
(HUFD Dispatch) #\nOCA : 1301208\nType: FIRE\nDate: 4/18/2013 07:41:17\nLoca: 9798 JAMESTOWN RD\nCity: HUNTLEY
(WLFD Dispatch) #\nOCA : 1300271\nType: HAZARD COND\nDate: 4/18/2013 06:44:12\nLoca: 2606 MICHAEL ST\nCity: WONDER LAKE\nCros: SAWMILL LN\nDist: 125
(WLFD Dispatch) #\nOCA : 1300270\nType: SMOKE\nDate: 4/18/2013 04:56:41\nLoca: 5626 WONDER WOODS DR\nCity: WONDER LAKE\nDist: 219
(HAFD Dispatch) #\nOCA : 1300271\nType: AOA\nDate: 4/18/2013 01:53:00\nLoca: N4285 HY M\nCity: DELAVAN
(HAFD Dispatch) #\nOCA : 1300270\nType: AMB\nDate: 4/17/2013 23:21:09\nLoca: 1103 9TH ST\nApt : 2\nCity: HARVARD\nDist: 784
(RMFD Dispatch) #\nOCA : 1300154\nType: AMB\nDate: 4/17/2013 15:34:29\nLoca: 10012 CIRCLE DR\nCity: RICHMOND\nCros: MAY AV\nDist: 411
(HBFD Dispatch) #\nOCA : 1300114\nType: FIRE\nDate: 4/17/2013 15:02:06\nLoca: 8508 NOLAN ST\nCity: HARVARD\nCros: CHARLOTTE CT\nDist: HB81
(WLFD Dispatch) #\nOCA : 1300269\nType: FIRE\nDate: 4/17/2013 14:26:28\nLoca: 8012 LORRAINE ST\nCity: SPRING GROVE
(SGFD Dispatch) #\nOCA : 1300185\nType: FIRE\nDate: 4/17/2013 14:26:28\nLoca: OAK ST // LORRAINE ST\nCity: SPRING GROVE\nCros: BARINA RD
(ALFD Dispatch) #\nOCA : 1301157\nType: FIRE\nDate: 4/17/2013 14:17:35\nLoca: 6 BLACK DIAMOND CT\nCity: LAKE IN THE HILLS
(SGFD Dispatch) #\nOCA : 1300184\nType: FIRE\nDate: 4/17/2013 13:51:46\nLoca: 9206 DEBORAH LN\nCity: SPRING GROVE
(MCSO Dispatch) #\nOCA : MCSO-13-011904\nType: FIRE\nDate: 4/17/2013 13:33:07\nLoca: 8511 MAXON RD\nCity: HARVARD\nDist: 784
(HAFD Dispatch) #\nOCA : 1300269\nType: FIRE\nDate: 4/17/2013 13:33:35\nLoca: 8511 MAXON RD\nCity: HARVARD\nDist: 784
(ALFD Dispatch) #\nOCA : 1301156\nType: FIRE\nDate: 4/17/2013 12:38:54\nLoca: THREE OAKS RD // SANDS RD\nCity: CRYSTAL LAKE\nDist: 31
(SGFD Dispatch) #\nOCA : 1300183\nType: AMB\nDate: 4/16/2013 20:03:47\nLoca: 3407 CORNFLOWER WY\nCity: SPRING GROVE
(SGFD Dispatch) #\nOCA : 1300182\nType: SMOKE\nDate: 4/16/2013 18:30:53\nLoca: 3813 REDWOOD CT\nCity: SPRING GROVE
(HAFD Dispatch) #\nOCA : 1300268\nType: AMB\nDate: 4/16/2013 18:23:57\nLoca: 120 W BRINK ST\nApt : 3\nCity: HARVARD\nDist: 783
(HAFD Dispatch) #\nOCA : 1300267\nType: AMB\nDate: 4/16/2013 17:40:51\nLoca: 816 ROUTE 23 HY\nCity: HARVARD\nDist: 782
(SGFD Dispatch) #\nOCA : 1300181\nType: AMB\nDate: 4/16/2013 17:21:03\nLoca: ROUTE 12 HY // GRAY ST\nCity: SPRING GROVE\nCros: SCOTT LN
(WLFD Dispatch) #\nOCA : 1300267\nType: WIRE\nDate: 4/16/2013 16:35:51\nLoca: 8202 ROUTE 120 HY\nCity: WONDER LAKE\nDist: 125
(HAFD Dispatch) #\nOCA : 1300266\nType: FIREBRUSH\nDate: 4/16/2013 16:32:15\nLoca: 8607 FERRIS RD\nCity: HARVARD\nDist: 781
(WLFD Dispatch) #\nOCA : 1300266\nType: ACCI\nDate: 4/16/2013 16:08:20\nLoca: THOMPSON RD // PINE AV\nCity: WONDER LAKE\nDist: 217
(RMFD Dispatch) #\nOCA : 1300150\nType: FIREBRUSH\nDate: 4/16/2013 15:05:00\nLoca: 4200 HAWKS POINT TR\nCity: RICHMOND\nCros: E PADDOCK ST\nDist: 210
(HAFD Dispatch) #\nOCA : 1300265\nType: AMB\nDate: 4/16/2013 14:43:54\nLoca: 908 FOREST DOWNS\nCity: HARVARD\nDist: 784
(RMFD Dispatch) #\nOCA : 1300149\nType: AMB\nDate: 4/16/2013 13:53:19\nLoca: 11302 ROUTE 12 HY\nCity: RICHMOND\nCros: BURLINGTON RD\nDist: 213
(HAFD Dispatch) #\nOCA : 1300264\nType: AMB\nDate: 4/16/2013 11:08:52\nLoca: JEFFERSON ST // HARRISON ST\nCity: HARVARD\nDist: 781
(RMFD Dispatch) #\nOCA : 1300148\nType: FIREBRUSH\nDate: 4/16/2013 02:05:57\nLoca: 5717 SOUTH ST\nCity: RICHMOND\nCros: WEST ST\nDist: 311
(WLFD Dispatch) #\nOCA : 1300265\nType: AMB\nDate: 4/15/2013 21:55:16\nLoca: 5201 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 121
(WLFD Dispatch) #\nOCA : 1300264\nType: AMB\nDate: 4/15/2013 21:10:36\nLoca: 3125 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 125
(SGFD Dispatch) #\nOCA : 1300180\nType: AMB\nDate: 4/15/2013 18:24:26\nLoca: 1709 HUNTERS LN\nCity: SPRING GROVE
(RMFD Dispatch) #\nOCA : 1300147\nType: AMB\nDate: 4/15/2013 17:12:25\nLoca: 6919 ROUTE 173 HY\nCity: RICHMOND\nCros: BROADWAY ST\nDist: 301
(MCSO Dispatch) #\nOCA : MCSO-13-011685\nType: SEXOTHER\nDate: 4/15/2013 16:56:37\nLoca: 7407 BARRY AV\nCity: SPRING GROVE
(WLFD Dispatch) #\nOCA : 1300263\nType: AMB\nDate: 4/15/2013 13:59:31\nLoca: 7140 BARNARD MILL RD\nCity: WONDER LAKE\nDist: 121
(HBFD Dispatch) #\nOCA : 1300110\nType: FIRE\nDate: 4/6/2013 07:05:42\nLoca: 6615 STATE PARK RD\nCity: SPRING GROVE
(HAFD Dispatch) #\nOCA : 1300263\nType: AMB\nDate: 4/14/2013 22:12:57\nLoca: 520 COUNTRY BROOK LN\nCity: HARVARD\nDist: 783
(SGFD Dispatch) #\nOCA : 1300179\nType: AMB\nDate: 4/14/2013 18:01:54\nLoca: 2219 HUNTERS CT\nCity: SPRING GROVE
(RMFD Dispatch) #\nOCA : 1300146\nType: AMB\nDate: 4/14/2013 14:12:11\nLoca: 5414 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411
(HAFD Dispatch) #\nOCA : 1300262\nType: AMB\nDate: 4/14/2013 10:46:06\nLoca: 395 S DIVISION ST\nCity: HARVARD\nDist: 783
(CLFD Dispatch) #\nOCA : 1301472\nType: FIRE\nDate: 4/14/2013 07:47:28\nLoca: 1709 MOORLAND LN\nCity: CRYSTAL LAKE\nCros: WILLIAMSBURG LN\nDist: 43
(WLFD Dispatch) #\nOCA : 1300262\nType: AMB\nDate: 4/14/2013 03:24:54\nLoca: 7605 BEAVER RD\nCity: WONDER LAKE\nDist: 123

Contact: Active911
Agency name: Woodstock FireRescue
Location: Woodstock, IL, United States
Sender: DoNotReply@mcetsb.org

(WDFD Dispatch) #\nType: AMB\nOCA : 1301446\nDate: 5/9/2013 04:18:22\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314
(WDFD Dispatch) #\nType: AMB\nOCA : 1301445\nDate: 5/9/2013 01:48:33\nLoca: 1007 ALPINE LN\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: AMB\nOCA : 1301444\nDate: 5/8/2013 23:09:13\nLoca: 208 GRIFFING AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301443\nDate: 5/8/2013 20:56:51\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216
(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301442\nDate: 5/8/2013 17:39:08\nLoca: 1430 COMMONS DR\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: ASSISTFIRE\nOCA : 1301441\nDate: 5/8/2013 15:39:23\nLoca: 207 N MENGE RD\nCity: MARENGO\nDist: 1182
(WDFD Dispatch) #\nType: AMB\nOCA : 1301440\nDate: 5/8/2013 15:30:13\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301439\nDate: 5/8/2013 15:30:01\nLoca: 250 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 131
(WDFD Dispatch) #\nType: AMB\nOCA : 1301438\nDate: 5/8/2013 13:58:48\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nType: AMB\nOCA : 1301437\nDate: 5/8/2013 13:51:20\nLoca: 614 RIDGELAND AV\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: AMB\nOCA : 1301436\nDate: 5/8/2013 11:41:20\nLoca: 1534 N SEMINARY AV\nApt : H\nCity: WOODSTOCK\nDist: 313
(WDFD Dispatch) #\nType: AMB\nOCA : 1301435\nDate: 5/8/2013 11:17:19\nLoca: 617 AMSTERDAM ST\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301434\nDate: 5/8/2013 10:19:03\nLoca: 217 RAFFEL RD\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301433\nDate: 5/8/2013 09:48:31\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: ACCI\nOCA : 1301432\nDate: 5/8/2013 06:37:27\nLoca: ROUTE 47 // RED BARN\nCity: WOODSTOCK
(WDFD Dispatch) #\nType: AMB\nOCA : 1301431\nDate: 5/8/2013 06:03:04\nLoca: 656 LAKE AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301430\nDate: 5/8/2013 02:13:02\nLoca: 710 ST JOHN`S RD\nApt : 16\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nType: AMB\nOCA : 1301429\nDate: 5/8/2013 02:13:17\nLoca: 930 LAKE AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: ODOR\nOCA : 1301428\nDate: 5/7/2013 21:37:07\nLoca: 902 RHODES ST\nCity: WOODSTOCK\nDist: 133
(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301427\nDate: 5/7/2013 16:33:17\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314
(WDFD Dispatch) #\nType: AMB\nOCA : 1301426\nDate: 5/7/2013 15:34:47\nLoca: 656 LAKE AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301425\nDate: 5/7/2013 15:16:09\nLoca: 428 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nType: AMB\nOCA : 1301424\nDate: 5/7/2013 13:13:37\nLoca: 1155 WALDEN OAKS DR\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301423\nDate: 5/7/2013 11:35:50\nLoca: 527 W SOUTH ST\nApt : 361\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: AMB\nOCA : 1301422\nDate: 5/7/2013 08:26:28\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: AMB\nOCA : 1301421\nDate: 5/7/2013 07:31:13\nLoca: 667 WARE RD\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301420\nDate: 5/7/2013 03:27:52\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nType: SMOKE\nOCA : 1301419\nDate: 5/6/2013 22:39:26\nLoca: 412 VINE ST\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301418\nDate: 5/6/2013 18:46:48\nLoca: 209 FIELDSTONE DR\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AOA\nOCA : 1301417\nDate: 5/6/2013 18:27:42\nLoca: 2200 N SEMINARY AV\nCity: WOODSTOCK\nDist: 313
(WDFD Dispatch) #\nType: AMB\nOCA : 1301416\nDate: 5/6/2013 17:50:31\nLoca: 600 DEAN ST\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nType: AMB\nOCA : 1301414\nDate: 5/6/2013 16:18:10\nLoca: RTE 47 // MCCONNELL RD\nCity: WOODSTOCK
(WDFD Dispatch) #\nType: AMB\nOCA : 1301413\nDate: 5/6/2013 13:54:30\nLoca: 726 S JEFFERSON ST\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301412\nType: AMB\nDate: 5/6/2013 13:42:07\nLoca: 117 VAN BUREN ST\nCity: WOODSTOCK\nDist: 128
(WDFD Dispatch) #\nOCA : 1301411\nType: AMB\nDate: 5/6/2013 13:36:33\nLoca: 460 W JACKSON ST\nApt : 1\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301410\nType: AMB\nDate: 5/6/2013 12:50:54\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nOCA : 1301409\nType: AOA\nDate: 5/6/2013 12:09:07\nLoca: 2800 CADBURY CI\nCity: LAKE IN THE HILLS
(WDFD Dispatch) #\nOCA : 1301408\nType: ACCI\nDate: 5/6/2013 11:48:45\nLoca: 1128 WATERFORD CUT ST\nCity: CRYSTAL LAKE\nCros: SANDALWOOD LN\nDist: 43
(WDFD Dispatch) #\nOCA : 1301407\nType: AMB\nDate: 5/6/2013 10:23:20\nLoca: 317 LAKE AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301406\nType: AMB\nDate: 5/6/2013 05:07:05\nLoca: 805 PLEASANT ST\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301405\nType: AMB\nDate: 5/6/2013 01:19:22\nLoca: 329 LAKE AV\nApt : 4\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301404\nType: FIREBRUSH\nDate: 5/5/2013 21:26:03\nLoca: CONCORD // N VALLEY HILL\nCity: WOODSTOCK
(WDFD Dispatch) #\nOCA : 1301403\nType: LOCKOUT\nDate: 5/5/2013 20:13:57\nLoca: 121 N HAYWARD ST\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301402\nType: AMB\nDate: 5/5/2013 12:46:46\nLoca: 820 LAKE AV\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301401\nType: AMB\nDate: 5/5/2013 12:03:27\nLoca: 1155 WALDEN OAKS DR\nApt : 209E\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301400\nType: AMB\nDate: 5/5/2013 11:59:53\nLoca: 502 MCHENRY AV\nApt : 310\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nOCA : 1301398\nType: TA\nDate: 5/5/2013 09:32:24\nLoca: 1200-1216 DAVIS RD\nCity: WOODSTOCK\nCros: NIGHTHAWK WY\nDist: 216
(WDFD Dispatch) #\nOCA : 1301397\nType: AMB\nDate: 5/5/2013 04:20:10\nLoca: 2428 ASPEN DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301396\nType: AMB\nDate: 5/5/2013 02:00:30\nLoca: 2609 N QUEEN ANNE RD\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nOCA : 1301395\nType: AMB\nDate: 5/4/2013 23:54:30\nLoca: 1007 GREENWOOD CI\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nOCA : 1301394\nType: AMB\nDate: 5/4/2013 21:12:26\nLoca: 3916 S COUNTRY CLUB RD\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301393\nType: ODOR\nDate: 5/4/2013 21:53:52\nLoca: 388 LINCOLN AV\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301392\nType: AMB\nDate: 5/4/2013 21:19:22\nLoca: 8620 CASTLEBERRY DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301391\nType: TA\nDate: 5/4/2013 20:44:54\nLoca: 1257 COBBLESTONE WY\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301390\nType: AMB\nDate: 5/4/2013 15:40:40\nLoca: 840 N SEMINARY AV\nApt : 105\nCity: WOODSTOCK\nDist: 133
(WDFD Dispatch) #\nOCA : 1301389\nType: TA\nDate: 5/4/2013 15:21:51\nLoca: 1150 N ROSE FARM RD\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301388\nType: AMB\nDate: 5/4/2013 14:49:30\nLoca: 13519 W SOUTH ST\nCity: WOODSTOCK\nCros: W HILLSIDE RD\nDist: 131
(WDFD Dispatch) #\nOCA : 1301387\nType: ALARMF\nDate: 5/4/2013 13:11:01\nLoca: 10920 LUCAS RD\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301386\nType: ALARMR\nDate: 5/4/2013 12:41:08\nLoca: 1415 FOX SEDGE TR\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301384\nType: AMB\nDate: 5/4/2013 09:22:51\nLoca: 2609 N QUEEN ANNE RD\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nOCA : 1301383\nType: ACCI\nDate: 5/4/2013 07:06:53\nLoca: ROUTE 14 HY // DOTY RD\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301382\nType: AMB\nDate: 5/4/2013 00:42:44\nLoca: 436 WASHINGTON ST\nApt : 1\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301381\nType: AMB\nDate: 5/3/2013 18:58:47\nLoca: 215 MAPLE ST\nCity: WOODSTOCK\nDist: 313
(WDFD Dispatch) #\nOCA : 1301380\nType: AMB\nDate: 5/3/2013 15:22:20\nLoca: 3909 RAYCRAFT RD\nCity: WOODSTOCK\nDist: 313
(WDFD Dispatch) #\nOCA : 1301379\nType: AMB\nDate: 5/3/2013 12:37:32\nLoca: 145 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 131
(WDFD Dispatch) #\nOCA : 1301378\nType: AMB\nDate: 5/3/2013 11:56:57\nLoca: 388 LINCOLN AV\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301377\nType: AMB\nDate: 5/3/2013 10:35:55\nLoca: 402 E JACKSON ST\nApt : 1/2\nCity: WOODSTOCK\nDist: 131
(WDFD Dispatch) #\nOCA : 1301376\nType: AMB\nDate: 5/3/2013 10:17:53\nLoca: 121 E BEECH AV\nCity: WOODSTOCK\nDist: 133
(WDFD Dispatch) #\nOCA : 1301375\nType: AOA\nDate: 5/3/2013 04:47:36\nLoca: 2510 ROUTE 176 HY\nCity: PRAIRIE GROVE\nDist: 4
(WDFD Dispatch) #\nOCA : 1301374\nType: AMB\nDate: 5/3/2013 02:56:54\nLoca: 480 W JACKSON ST\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301373\nType: AMB\nDate: 5/3/2013 01:18:00\nLoca: 1543 N SEMINARY AV\nApt : H\nCity: WOODSTOCK\nDist: 131
(WDFD Dispatch) #\nOCA : 1301372\nType: AMB\nDate: 5/2/2013 16:04:27\nLoca: 1155 WALDEN OAKS DR\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301371\nType: CO NOSYMPTOM\nDate: 5/2/2013 13:42:01\nLoca: 1018 GREENWOOD CI\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nOCA : 1301370\nType: AMB\nDate: 5/2/2013 13:42:01\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216
(WDFD Dispatch) #\nOCA : 1301369\nType: FIREBRUSH\nDate: 5/2/2013 13:06:40\nLoca: 1818 S ROSEFARM RD\nCity: WOODSTOCK
(WDFD Dispatch) #\nOCA : 1301368\nType: AMB\nDate: 5/2/2013 06:32:12\nLoca: 430 TANAGER DR\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nOCA : 1301367\nType: SMOKE\nDate: 5/2/2013 04:53:47\nLoca: 2035 ASPEN DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301366\nType: ALARMF\nDate: 5/2/2013 00:49:36\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314
(WDFD Dispatch) #\nOCA : 1301365\nType: AMB\nDate: 5/1/2013 22:19:49\nLoca: 831 CLAY ST\nCity: WOODSTOCK\nDist: 133
(WDFD Dispatch) #\nOCA : 1301364\nType: ACCI\nDate: 5/1/2013 20:44:56\nLoca: RTE 14 1/4 EAST OF DEAN ST\nCity: WOODSTOCK\nCros: N CAROLINE 
(WDFD Dispatch) #\nOCA : 1301363\nType: AMB\nDate: 5/1/2013 21:24:03\nLoca: 720 ST JOHN`S RD\nApt : 109\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nOCA : 1301362\nType: ACCI\nDate: 5/1/2013 20:42:18\nLoca: 400 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301361\nType: AMB\nDate: 5/1/2013 18:58:25\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216
(WDFD Dispatch) #\nOCA : 1301360\nType: AMB\nDate: 5/1/2013 18:44:37\nLoca: 1400 COMMONS DR\nApt : 1D\nCity: WOODSTOCK\nDist: 216
(WDFD Dispatch) #\nOCA : 1301359\nType: AMB\nDate: 5/1/2013 16:55:32\nLoca: 527 W SOUTH ST\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301358\nType: AMB\nDate: 5/1/2013 13:30:07\nLoca: 3306 ELAINE DR\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301357\nType: SMOKE\nDate: 5/1/2013 16:15:44\nLoca: 1115 DONEGAL CT\nCity: WOODSTOCK\nDist: 215
(WDFD Dispatch) #\nOCA : 1301356\nType: AOA\nDate: 5/1/2013 15:35:15\nLoca: 3217 CARRINGTON DR\nCity: CRYSTAL LAKE\nCros: REMINGTON DR\nDist: 13
(WDFD Dispatch) #\nOCA : 1301355\nType: LOCKOUT\nDate: 5/1/2013 13:35:37\nLoca: 644 MARGARET ST\nCity: WOODSTOCK\nDist: 124
(WDFD Dispatch) #\nOCA : 1301354\nType: AMB\nDate: 5/1/2013 11:48:16\nLoca: 8205 BRECKENRIDGE C T\nCity: BULL VALLEY
(WDFD Dispatch) #\nOCA : 1301353\nType: AMB\nDate: 5/1/2013 09:48:29\nLoca: FLEMING RD // BULL VALLEY RD\nCity: BULL VALLEY\nDist: 131
(WDFD Dispatch) #\nOCA : 1301352\nType: AMB\nDate: 5/1/2013 04:43:00\nLoca: 1512 GOLDEN OAK DR\nCity: WOODSTOCK\nDist: 127
(WDFD Dispatch) #\nOCA : 1301351\nType: AMB\nDate: 4/30/2013 20:28:36\nLoca: 616 ST JOHN`S RD\nCity: WOODSTOCK\nDist: 312
(WDFD Dispatch) #\nOCA : 1301350\nType: AMB\nDate: 4/30/2013 16:35:14\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132
(WDFD Dispatch) #\nOCA : 1301348\nType: AMB\nDate: 4/30/2013 13:30:54\nLoca: 2626 COBBLESTONE DR\nApt : 36\nCity: PRAIRIE GROVE\nDist: 13
(WDFD Dispatch) #\nOCA : 1301347\nType: AOA\nDate: 4/30/2013 13:26:37\nLoca: 100 W WOODSTOCK ST\nCity: CRYSTAL LAKE\nCros: N CAROLINE \nDist: 14

 */

public class ILMcHenryCountyParserTest extends BaseParserTest {
  
  public ILMcHenryCountyParserTest() {
    setParser(new ILMcHenryCountyParser(), "MCHENRY COUNTY", "IL");
  }
  
  @Test
  public void HuntleyFireDepartment() {

    doTest("T1",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301427\nDate: 5/8/2013 21:03:24\nLoca: 270 WEDGEWOOD CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301427",
        "DATE:5/8/2013",
        "TIME:21:03:24",
        "ADDR:270 WEDGEWOOD CI",
        "MADDR:270 WEDGEWOOD CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T2",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301426\nDate: 5/8/2013 19:02:44\nLoca: 5353 LANSBURY CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301426",
        "DATE:5/8/2013",
        "TIME:19:02:44",
        "ADDR:5353 LANSBURY CI",
        "MADDR:5353 LANSBURY CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T3",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301425\nDate: 5/8/2013 18:15:19\nLoca: 7 SAVOY CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301425",
        "DATE:5/8/2013",
        "TIME:18:15:19",
        "ADDR:7 SAVOY CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T4",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301424\nDate: 5/8/2013 18:05:30\nLoca: 5 NEWBURY CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301424",
        "DATE:5/8/2013",
        "TIME:18:05:30",
        "ADDR:5 NEWBURY CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T5",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301422\nDate: 5/8/2013 15:14:22\nLoca: 4870 HIGHWOOD LN\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301422",
        "DATE:5/8/2013",
        "TIME:15:14:22",
        "ADDR:4870 HIGHWOOD LN",
        "CITY:LAKE IN THE HILLS");

    doTest("T6",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301421\nDate: 5/8/2013 15:05:33\nLoca: 12723 HARMONY RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301421",
        "DATE:5/8/2013",
        "TIME:15:05:33",
        "ADDR:12723 HARMONY RD",
        "CITY:HUNTLEY");

    doTest("T7",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301419\nDate: 5/8/2013 11:56:01\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301419",
        "DATE:5/8/2013",
        "TIME:11:56:01",
        "ADDR:10350 HALIGUS RD",
        "APT:100A",
        "CITY:HUNTLEY");

    doTest("T8",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301418\nDate: 5/8/2013 11:41:43\nLoca: 13574 LEHIGH ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301418",
        "DATE:5/8/2013",
        "TIME:11:41:43",
        "ADDR:13574 LEHIGH ST",
        "CITY:HUNTLEY");

    doTest("T9",
        "(HUFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301417\nDate: 5/8/2013 11:00:59\nLoca: 1 FEATHERSTONE CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:CO NOSYMPTOM",
        "ID:1301417",
        "DATE:5/8/2013",
        "TIME:11:00:59",
        "ADDR:1 FEATHERSTONE CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T10",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301416\nDate: 5/8/2013 10:17:03\nLoca: 14088 SUNDANCE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301416",
        "DATE:5/8/2013",
        "TIME:10:17:03",
        "ADDR:14088 SUNDANCE DR",
        "CITY:HUNTLEY");

    doTest("T11",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301415\nDate: 5/7/2013 23:49:48\nLoca: 260 BRIDLEWOOD CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301415",
        "DATE:5/7/2013",
        "TIME:23:49:48",
        "ADDR:260 BRIDLEWOOD CI",
        "MADDR:260 BRIDLEWOOD CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T12",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301414\nDate: 5/7/2013 23:41:41\nLoca: 13544 BONAIRE RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301414",
        "DATE:5/7/2013",
        "TIME:23:41:41",
        "ADDR:13544 BONAIRE RD",
        "CITY:HUNTLEY");

    doTest("T13",
        "(HUFD Dispatch) #\nType: LOCKOUT\nOCA : 1301413\nDate: 5/7/2013 18:46:36\nLoca: 10738 SHENANDOAH DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:LOCKOUT",
        "ID:1301413",
        "DATE:5/7/2013",
        "TIME:18:46:36",
        "ADDR:10738 SHENANDOAH DR",
        "CITY:HUNTLEY");

    doTest("T14",
        "(HUFD Dispatch) #\nType: TA\nOCA : 1301412\nDate: 5/7/2013 17:43:11\nLoca: 12300 S ROUTE 47 HY\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:TA",
        "ID:1301412",
        "DATE:5/7/2013",
        "TIME:17:43:11",
        "ADDR:12300 S ROUTE 47 HY",
        "MADDR:12300 S ROUTE 47",
        "CITY:HUNTLEY");

    doTest("T15",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301411\nDate: 5/7/2013 17:37:11\nLoca: 9431 WELSH LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301411",
        "DATE:5/7/2013",
        "TIME:17:37:11",
        "ADDR:9431 WELSH LN",
        "CITY:HUNTLEY");

    doTest("T16",
        "(HUFD Dispatch) #\nType: AOA\nOCA : 1301410\nDate: 5/7/2013 15:49:29\nLoca: =8  ASTEC CT\nCity: SELECT",
        "SRC:HUFD",
        "CALL:AOA",
        "ID:1301410",
        "DATE:5/7/2013",
        "TIME:15:49:29",
        "ADDR:=8  ASTEC CT",  // Dispatch mistype
        "CITY:SELECT");

    doTest("T17",
        "(HUFD Dispatch) #\nType: ACCI\nOCA : 1301409\nDate: 5/7/2013 14:45:10\nLoca: MAIN ST // ROUTE 47 HY\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:ACCI",
        "ID:1301409",
        "DATE:5/7/2013",
        "TIME:14:45:10",
        "ADDR:MAIN ST & ROUTE 47 HY",
        "MADDR:MAIN ST & ROUTE 47",
        "CITY:HUNTLEY");

    doTest("T18",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301408\nDate: 5/7/2013 14:18:52\nLoca: 10065 CUMMINGS ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301408",
        "DATE:5/7/2013",
        "TIME:14:18:52",
        "ADDR:10065 CUMMINGS ST",
        "CITY:HUNTLEY");

    doTest("T19",
        "(HUFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301407\nDate: 5/7/2013 13:30:25\nLoca: 11272 KINGSBURY CT\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:CO NOSYMPTOM",
        "ID:1301407",
        "DATE:5/7/2013",
        "TIME:13:30:25",
        "ADDR:11272 KINGSBURY CT",
        "CITY:HUNTLEY");

    doTest("T20",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301406\nDate: 5/7/2013 10:27:18\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301406",
        "DATE:5/7/2013",
        "TIME:10:27:18",
        "ADDR:10350 HALIGUS RD",
        "APT:100A",
        "CITY:HUNTLEY");

    doTest("T21",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301405\nDate: 5/7/2013 09:56:54\nLoca: 13380 MOCKINGBIRD CT\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301405",
        "DATE:5/7/2013",
        "TIME:09:56:54",
        "ADDR:13380 MOCKINGBIRD CT",
        "CITY:HUNTLEY");

    doTest("T22",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301404\nDate: 5/7/2013 07:02:41\nLoca: 2206 PEMBRIDGE DR\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301404",
        "DATE:5/7/2013",
        "TIME:07:02:41",
        "ADDR:2206 PEMBRIDGE DR",
        "CITY:LAKE IN THE HILLS");

    doTest("T23",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301403\nDate: 5/7/2013 03:36:50\nLoca: 12642 ROCK ISLAND TR\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301403",
        "DATE:5/7/2013",
        "TIME:03:36:50",
        "ADDR:12642 ROCK ISLAND TR",
        "CITY:HUNTLEY");

    doTest("T24",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301402\nDate: 5/7/2013 00:16:04\nLoca: 2361 STANTON CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301402",
        "DATE:5/7/2013",
        "TIME:00:16:04",
        "ADDR:2361 STANTON CI",
        "MADDR:2361 STANTON CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T25",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301401\nDate: 5/6/2013 21:38:14\nLoca: 11171 DEVON LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301401",
        "DATE:5/6/2013",
        "TIME:21:38:14",
        "ADDR:11171 DEVON LN",
        "CITY:HUNTLEY");

    doTest("T26",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301400\nDate: 5/6/2013 18:04:33\nLoca: 10350 HALIGUS RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301400",
        "DATE:5/6/2013",
        "TIME:18:04:33",
        "ADDR:10350 HALIGUS RD",
        "CITY:HUNTLEY");

    doTest("T27",
        "(HUFD Dispatch) #\nType: AMB\nOCA : 1301398\nDate: 5/6/2013 14:44:39\nLoca: 11262 EDINBURGH LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "CALL:AMB",
        "ID:1301398",
        "DATE:5/6/2013",
        "TIME:14:44:39",
        "ADDR:11262 EDINBURGH LN",
        "CITY:HUNTLEY");

    doTest("T28",
        "(HUFD Dispatch) #\nOCA : 1301397\nType: FIRE\nDate: 5/6/2013 12:05:06\nLoca: 2800 CADBURY CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301397",
        "CALL:FIRE",
        "DATE:5/6/2013",
        "TIME:12:05:06",
        "ADDR:2800 CADBURY CI",
        "MADDR:2800 CADBURY CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T29",
        "(HUFD Dispatch) #\nOCA : 1301396\nType: AMB\nDate: 5/6/2013 10:51:49\nLoca: 10350 HALIGUS RD\nApt : 200\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301396",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:10:51:49",
        "ADDR:10350 HALIGUS RD",
        "APT:200",
        "CITY:HUNTLEY");

    doTest("T30",
        "(HUFD Dispatch) #\nOCA : 1301395\nType: AMB\nDate: 5/6/2013 10:14:49\nLoca: 12502 WEDGEMERE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301395",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:10:14:49",
        "ADDR:12502 WEDGEMERE DR",
        "CITY:HUNTLEY");

    doTest("T31",
        "(HUFD Dispatch) #\nOCA : 1301393\nType: AMB\nDate: 5/6/2013 08:51:00\nLoca: 12557 W PHEASANT RIDGE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301393",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:08:51:00",
        "ADDR:12557 W PHEASANT RIDGE DR",
        "CITY:HUNTLEY");

    doTest("T32",
        "(HUFD Dispatch) #\nOCA : 1301392\nType: AMB\nDate: 5/6/2013 06:59:18\nLoca: 13120 COLD SPRINGS DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301392",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:06:59:18",
        "ADDR:13120 COLD SPRINGS DR",
        "CITY:HUNTLEY");

    doTest("T33",
        "(HUFD Dispatch) #\nOCA : 1301391\nType: ALARMF\nDate: 5/6/2013 03:37:56\nLoca: 11321 SMITH DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301391",
        "CALL:ALARMF",
        "DATE:5/6/2013",
        "TIME:03:37:56",
        "ADDR:11321 SMITH DR",
        "CITY:HUNTLEY");

    doTest("T34",
        "(HUFD Dispatch) #\nOCA : 1301390\nType: AMB\nDate: 5/6/2013 01:53:04\nLoca: 5390 AVALON LN\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301390",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:01:53:04",
        "ADDR:5390 AVALON LN",
        "CITY:LAKE IN THE HILLS");

    doTest("T35",
        "(HUFD Dispatch) #\nOCA : 1301389\nType: AMB\nDate: 5/5/2013 23:26:48\nLoca: 12452 ROLLING MEADOWS LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301389",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:23:26:48",
        "ADDR:12452 ROLLING MEADOWS LN",
        "CITY:HUNTLEY");

    doTest("T36",
        "(HUFD Dispatch) #\nOCA : 1301388\nType: SMOKE\nDate: 5/5/2013 22:34:54\nLoca: 460 TENBY WY\nCity: ALGONQUIN\nCros: WHITEHALL LN",
        "SRC:HUFD",
        "ID:1301388",
        "CALL:SMOKE",
        "DATE:5/5/2013",
        "TIME:22:34:54",
        "ADDR:460 TENBY WY",
        "CITY:ALGONQUIN",
        "X:WHITEHALL LN");

    doTest("T37",
        "(HUFD Dispatch) #\nOCA : 1301387\nType: AMB\nDate: 5/5/2013 22:16:03\nLoca: 12642 ROCK ISLAND TR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301387",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:22:16:03",
        "ADDR:12642 ROCK ISLAND TR",
        "CITY:HUNTLEY");

    doTest("T38",
        "(HUFD Dispatch) #\nOCA : 1301386\nType: AMB\nDate: 5/5/2013 17:56:45\nLoca: 11775 MESSINER DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301386",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:17:56:45",
        "ADDR:11775 MESSINER DR",
        "CITY:HUNTLEY");

    doTest("T39",
        "(HUFD Dispatch) #\nOCA : 1301385\nType: AMB\nDate: 5/5/2013 16:58:32\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301385",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:16:58:32",
        "ADDR:10350 HALIGUS RD",
        "APT:100A",
        "CITY:HUNTLEY");

    doTest("T40",
        "(HUFD Dispatch) #\nOCA : 1301384\nType: AMB\nDate: 5/5/2013 14:51:27\nLoca: 14162 VIOLA PL\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301384",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:14:51:27",
        "ADDR:14162 VIOLA PL",
        "CITY:HUNTLEY");

    doTest("T41",
        "(HUFD Dispatch) #\nOCA : 1301383\nType: SMOKE\nDate: 5/5/2013 14:27:44\nLoca: 12183 SPRING CREEK DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301383",
        "CALL:SMOKE",
        "DATE:5/5/2013",
        "TIME:14:27:44",
        "ADDR:12183 SPRING CREEK DR",
        "CITY:HUNTLEY");

    doTest("T42",
        "(HUFD Dispatch) #\nOCA : 1301382\nType: AMB\nDate: 5/5/2013 08:50:27\nLoca: 10805 E MAIN ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301382",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:08:50:27",
        "ADDR:10805 E MAIN ST",
        "CITY:HUNTLEY");

    doTest("T43",
        "(HUFD Dispatch) #\nOCA : 1301381\nType: AMB\nDate: 5/5/2013 07:58:29\nLoca: 13654 PENEFIELD LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301381",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:07:58:29",
        "ADDR:13654 PENEFIELD LN",
        "CITY:HUNTLEY");

    doTest("T44",
        "(HUFD Dispatch) #\nOCA : 1301380\nType: AMB\nDate: 5/5/2013 06:07:10\nLoca: 12293 DAFFODIL DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301380",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:06:07:10",
        "ADDR:12293 DAFFODIL DR",
        "CITY:HUNTLEY");

    doTest("T45",
        "(HUFD Dispatch) #\nOCA : 1301379\nType: AMB\nDate: 5/5/2013 00:05:05\nLoca: 2510 FAIRFAX LN\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301379",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:00:05:05",
        "ADDR:2510 FAIRFAX LN",
        "CITY:LAKE IN THE HILLS");

    doTest("T46",
        "(HUFD Dispatch) #\nOCA : 1301378\nType: AMB\nDate: 5/4/2013 23:27:12\nLoca: 3961 GEORGETOWN CI\nCity: ALGONQUIN\nCros: BUNKER HILL DR",
        "SRC:HUFD",
        "ID:1301378",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:23:27:12",
        "ADDR:3961 GEORGETOWN CI",
        "MADDR:3961 GEORGETOWN CIR",
        "CITY:ALGONQUIN",
        "X:BUNKER HILL DR");

    doTest("T47",
        "(HUFD Dispatch) #\nOCA : 1301377\nType: ALARMF\nDate: 5/4/2013 20:35:35\nLoca: 11321 SMITH DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301377",
        "CALL:ALARMF",
        "DATE:5/4/2013",
        "TIME:20:35:35",
        "ADDR:11321 SMITH DR",
        "CITY:HUNTLEY");

    doTest("T48",
        "(HUFD Dispatch) #\nOCA : 1301376\nType: ACCI\nDate: 5/4/2013 17:10:22\nLoca: 12819 W HIGHLAND LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301376",
        "CALL:ACCI",
        "DATE:5/4/2013",
        "TIME:17:10:22",
        "ADDR:12819 W HIGHLAND LN",
        "CITY:HUNTLEY");

    doTest("T49",
        "(HUFD Dispatch) #\nOCA : 1301375\nType: LOCKOUT\nDate: 5/4/2013 15:49:06\nLoca: 13551 WINDY PRAIRIE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301375",
        "CALL:LOCKOUT",
        "DATE:5/4/2013",
        "TIME:15:49:06",
        "ADDR:13551 WINDY PRAIRIE DR",
        "CITY:HUNTLEY");

    doTest("T50",
        "(HUFD Dispatch) #\nOCA : 1301374\nType: AMB\nDate: 5/4/2013 14:39:31\nLoca: 12015 MILL ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301374",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:14:39:31",
        "ADDR:12015 MILL ST",
        "CITY:HUNTLEY");

    doTest("T51",
        "(HUFD Dispatch) #\nOCA : 1301373\nType: AMB\nDate: 5/4/2013 12:23:26\nLoca: 11713 E MAIN ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301373",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:12:23:26",
        "ADDR:11713 E MAIN ST",
        "CITY:HUNTLEY");

    doTest("T52",
        "(HUFD Dispatch) #\nOCA : 1301372\nType: AMB\nDate: 5/4/2013 10:28:47\nLoca: 11797 BORHART DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301372",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:10:28:47",
        "ADDR:11797 BORHART DR",
        "CITY:HUNTLEY");

    doTest("T53",
        "(HUFD Dispatch) #\nOCA : 1301371\nType: ASSISTFIRE\nDate: 5/4/2013 09:46:56\nLoca: 12220 PRINCETON DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301371",
        "CALL:ASSISTFIRE",
        "DATE:5/4/2013",
        "TIME:09:46:56",
        "ADDR:12220 PRINCETON DR",
        "CITY:HUNTLEY");

    doTest("T54",
        "(HUFD Dispatch) #\nOCA : 1301370\nType: AMB\nDate: 5/3/2013 21:40:56\nLoca: 14259 NEWPORT CI\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301370",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:21:40:56",
        "ADDR:14259 NEWPORT CI",
        "MADDR:14259 NEWPORT CIR",
        "CITY:HUNTLEY");

    doTest("T55",
        "(HUFD Dispatch) #\nOCA : 1301369\nType: AMB\nDate: 5/3/2013 20:40:58\nLoca: 10711 N ROUTE 47 HY\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301369",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:20:40:58",
        "ADDR:10711 N ROUTE 47 HY",
        "MADDR:10711 N ROUTE 47",
        "CITY:HUNTLEY");

    doTest("T56",
        "(HUFD Dispatch) #\nOCA : 1301368\nType: WIRE\nDate: 5/3/2013 19:53:04\nLoca: POWERS RD // FREEMAN RD\nCity: GILBERTS",
        "SRC:HUFD",
        "ID:1301368",
        "CALL:WIRE",
        "DATE:5/3/2013",
        "TIME:19:53:04",
        "ADDR:POWERS RD & FREEMAN RD",
        "CITY:GILBERTS");

    doTest("T57",
        "(HUFD Dispatch) #\nOCA : 1301367\nType: AMB\nDate: 5/3/2013 19:46:11\nLoca: 11325 HEATHERDALE LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301367",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:19:46:11",
        "ADDR:11325 HEATHERDALE LN",
        "CITY:HUNTLEY");

    doTest("T58",
        "(HUFD Dispatch) #\nOCA : 1301366\nType: AMB\nDate: 5/3/2013 19:39:58\nLoca: 10350 HALIGUS RD\nApt : 100A\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301366",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:19:39:58",
        "ADDR:10350 HALIGUS RD",
        "APT:100A",
        "CITY:HUNTLEY");

    doTest("T59",
        "(HUFD Dispatch) #\nOCA : 1301365\nType: AMB\nDate: 5/3/2013 19:21:08\nLoca: 13624 WHITTINGHAM LN\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301365",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:19:21:08",
        "ADDR:13624 WHITTINGHAM LN",
        "CITY:HUNTLEY");

    doTest("T60",
        "(HUFD Dispatch) #\nOCA : 1301364\nType: AMB\nDate: 5/3/2013 16:00:38\nLoca: 8 LARKSPUR CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301364",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:16:00:38",
        "ADDR:8 LARKSPUR CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T61",
        "(HUFD Dispatch) #\nOCA : 1301363\nType: ACCI\nDate: 5/3/2013 15:20:41\nLoca: I90 HY // 51.00 MARKER\nCity: ELGIN",
        "SRC:HUFD",
        "ID:1301363",
        "CALL:ACCI",
        "DATE:5/3/2013",
        "TIME:15:20:41",
        "ADDR:I90 HY & 51.00 MARKER",
        "MADDR:I 90 & 51.00 MARKER",
        "CITY:ELGIN");

    doTest("T62",
        "(HUFD Dispatch) #\nOCA : 1301362\nType: AMB\nDate: 5/3/2013 13:59:43\nLoca: 11811 OAK CREEK PW\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301362",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:13:59:43",
        "ADDR:11811 OAK CREEK PW",
        "MADDR:11811 OAK CREEK PKWY",
        "CITY:HUNTLEY");

    doTest("T63",
        "(HUFD Dispatch) #\nOCA : 1301361\nType: AMB\nDate: 5/3/2013 10:40:41\nLoca: 13591 WINDY PRAIRIE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301361",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:10:40:41",
        "ADDR:13591 WINDY PRAIRIE DR",
        "CITY:HUNTLEY");

    doTest("T64",
        "(HUFD Dispatch) #\nOCA : 1301360\nType: AMB\nDate: 5/3/2013 09:27:21\nLoca: 11 WEDGEWOOD CI\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301360",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:09:27:21",
        "ADDR:11 WEDGEWOOD CI",
        "MADDR:11 WEDGEWOOD CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T65",
        "(HUFD Dispatch) #\nOCA : 1301359\nType: AMB\nDate: 5/3/2013 08:33:51\nLoca: 13049 REDSTONE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301359",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:08:33:51",
        "ADDR:13049 REDSTONE DR",
        "CITY:HUNTLEY");

    doTest("T66",
        "(HUFD Dispatch) #\nOCA : 1301358\nType: AMB\nDate: 5/3/2013 06:56:45\nLoca: 11775 MESSINER DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301358",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:06:56:45",
        "ADDR:11775 MESSINER DR",
        "CITY:HUNTLEY");

    doTest("T67",
        "(HUFD Dispatch) #\nOCA : 1301357\nType: AMB\nDate: 5/3/2013 06:04:49\nLoca: 12471 WEDGEMERE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301357",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:06:04:49",
        "ADDR:12471 WEDGEMERE DR",
        "CITY:HUNTLEY");

    doTest("T68",
        "(HUFD Dispatch) #\nOCA : 1301356\nType: AOA\nDate: 5/3/2013 04:48:01\nLoca: 2510 ROUTE 176 HY\nApt : D\nCity: PRAIRIE GROVE\nDist: 4",
        "SRC:HUFD",
        "ID:1301356",
        "CALL:AOA",
        "DATE:5/3/2013",
        "TIME:04:48:01",
        "ADDR:2510 ROUTE 176 HY",
        "MADDR:2510 ROUTE 176",
        "APT:D",
        "CITY:PRAIRIE GROVE");

    doTest("T69",
        "(HUFD Dispatch) #\nOCA : 1301355\nType: AMB\nDate: 5/2/2013 22:41:20\nLoca: 11721 E MAIN ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301355",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:22:41:20",
        "ADDR:11721 E MAIN ST",
        "CITY:HUNTLEY");

    doTest("T70",
        "(HUFD Dispatch) #\nOCA : 1301354\nType: AOA\nDate: 5/2/2013 21:09:34\nLoca: ROUTE 72 // NEW LEBANON\nCity: HAMPSHIRE",
        "SRC:HUFD",
        "ID:1301354",
        "CALL:AOA",
        "DATE:5/2/2013",
        "TIME:21:09:34",
        "ADDR:ROUTE 72 & NEW LEBANON",
        "CITY:HAMPSHIRE");    // Google places this in Genoa

    doTest("T71",
        "(HUFD Dispatch) #\nOCA : 1301353\nType: AMB\nDate: 5/2/2013 11:12:02\nLoca: 830 DOGWOOD LN\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301353",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:11:12:02",
        "ADDR:830 DOGWOOD LN",
        "CITY:LAKE IN THE HILLS");

    doTest("T72",
        "(HUFD Dispatch) #\nOCA : 1301350\nType: ALARMF\nDate: 5/2/2013 05:43:53\nLoca: 13320 S ROUTE 47 HY\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301350",
        "CALL:ALARMF",
        "DATE:5/2/2013",
        "TIME:05:43:53",
        "ADDR:13320 S ROUTE 47 HY",
        "MADDR:13320 S ROUTE 47",
        "CITY:HUNTLEY");

    doTest("T73",
        "(HUFD Dispatch) #\nOCA : 1301349\nType: AMB\nDate: 5/2/2013 05:42:36\nLoca: 9793 COMPTON DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301349",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:05:42:36",
        "ADDR:9793 COMPTON DR",
        "CITY:HUNTLEY");

    doTest("T74",
        "(HUFD Dispatch) #\nOCA : 1301348\nType: AMB\nDate: 5/2/2013 03:59:38\nLoca: 9934 BEDFORD DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301348",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:03:59:38",
        "ADDR:9934 BEDFORD DR",
        "CITY:HUNTLEY");

    doTest("T75",
        "(HUFD Dispatch) #\nOCA : 1301347\nType: AMB\nDate: 5/2/2013 03:57:01\nLoca: 985 ASTER CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301347",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:03:57:01",
        "ADDR:985 ASTER CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T76",
        "(HUFD Dispatch) #\nOCA : 1301346\nType: AMB\nDate: 5/1/2013 19:23:46\nLoca: 14037 VERBEND PATH\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301346",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:19:23:46",
        "ADDR:14037 VERBEND PATH",
        "CITY:HUNTLEY");

    doTest("T77",
        "(HUFD Dispatch) #\nOCA : 1301345\nType: AMB\nDate: 5/1/2013 18:44:46\nLoca: 12715 HORSESHOE TR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301345",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:18:44:46",
        "ADDR:12715 HORSESHOE TR",
        "CITY:HUNTLEY");

    doTest("T78",
        "(HUFD Dispatch) #\nOCA : 1301344\nType: AMB\nDate: 5/1/2013 16:48:35\nLoca: 12860 DEL WEBB BL\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301344",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:16:48:35",
        "ADDR:12860 DEL WEBB BL",
        "CITY:HUNTLEY");

    doTest("T79",
        "(HUFD Dispatch) #\n" +
        "OCA : 1301343\n" +
        "Type: FIRE\n" +
        "Date: 5/1/2013 15:29:10\n" +
        "Loca: 3217 CARRINGTON DR\n" +
        "City: CRYSTAL LAKE\n" +
        "Cros: REMINGTON DR\n" +
        "Dist: 13",

        "SRC:HUFD",
        "ID:1301343",
        "CALL:FIRE",
        "DATE:5/1/2013",
        "TIME:15:29:10",
        "ADDR:3217 CARRINGTON DR",
        "CITY:CRYSTAL LAKE",
        "X:REMINGTON DR",
        "INFO:Dist: 13");

    doTest("T80",
        "(HUFD Dispatch) #\nOCA : 1301342\nType: MISC\nDate: 5/1/2013 14:25:28\nLoca: 10350 HALIGUS RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301342",
        "CALL:MISC",
        "DATE:5/1/2013",
        "TIME:14:25:28",
        "ADDR:10350 HALIGUS RD",
        "CITY:HUNTLEY");

    doTest("T81",
        "(HUFD Dispatch) #\nOCA : 1301341\nType: ALARMF\nDate: 5/1/2013 12:35:31\nLoca: 10289 N VINE ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301341",
        "CALL:ALARMF",
        "DATE:5/1/2013",
        "TIME:12:35:31",
        "ADDR:10289 N VINE ST",
        "CITY:HUNTLEY");

    doTest("T82",
        "(HUFD Dispatch) #\nOCA : 1301340\nType: AMB\nDate: 5/1/2013 12:01:13\nLoca: 14102 VIOLA PL\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301340",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:12:01:13",
        "ADDR:14102 VIOLA PL",
        "CITY:HUNTLEY");

    doTest("T83",
        "(HUFD Dispatch) #\nOCA : 1301339\nType: AMB\nDate: 5/1/2013 10:52:44\nLoca: 12993 BROOKWOOD DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301339",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:10:52:44",
        "ADDR:12993 BROOKWOOD DR",
        "CITY:HUNTLEY");

    doTest("T84",
        "(HUFD Dispatch) #\nOCA : 1301338\nType: AMB\nDate: 5/1/2013 09:30:07\nLoca: 12450 REGENCY PK\nApt : 272\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301338",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:09:30:07",
        "ADDR:12450 REGENCY PK",
        "MADDR:12450 REGENCY PIKE",
        "APT:272",
        "CITY:HUNTLEY");

    doTest("T85",
        "(HUFD Dispatch) #\nOCA : 1301337\nType: ALARMF\nDate: 5/1/2013 04:03:55\nLoca: 13320 S ROUTE 47 HY\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301337",
        "CALL:ALARMF",
        "DATE:5/1/2013",
        "TIME:04:03:55",
        "ADDR:13320 S ROUTE 47 HY",
        "MADDR:13320 S ROUTE 47",
        "CITY:HUNTLEY");

    doTest("T86",
        "(HUFD Dispatch) #\nOCA : 1301336\nType: AMB\nDate: 5/1/2013 03:54:13\nLoca: 11473 WILDROSE DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301336",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:03:54:13",
        "ADDR:11473 WILDROSE DR",
        "CITY:HUNTLEY");

    doTest("T87",
        "(HUFD Dispatch) #\nOCA : 1301334\nType: ALARMF\nDate: 5/1/2013 00:50:36\nLoca: 13320 VILLAGE GREEN DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301334",
        "CALL:ALARMF",
        "DATE:5/1/2013",
        "TIME:00:50:36",
        "ADDR:13320 VILLAGE GREEN DR",
        "CITY:HUNTLEY");

    doTest("T88",
        "(HUFD Dispatch) #\nOCA : 1301333\nType: ALARMF\nDate: 4/30/2013 16:32:50\nLoca: 11707 DEAN ST\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301333",
        "CALL:ALARMF",
        "DATE:4/30/2013",
        "TIME:16:32:50",
        "ADDR:11707 DEAN ST",
        "CITY:HUNTLEY");

    doTest("T89",
        "(HUFD Dispatch) #\nOCA : 1301332\nType: ACCI\nDate: 4/30/2013 15:34:03\nLoca: I90 HY // 44.75 MARKER\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301332",
        "CALL:ACCI",
        "DATE:4/30/2013",
        "TIME:15:34:03",
        "ADDR:I90 HY & 44.75 MARKER",
        "MADDR:I 90 & 44.75 MARKER",
        "CITY:HUNTLEY");

    doTest("T90",
        "(HUFD Dispatch) #\nOCA : 1301331\nType: ALARMF\nDate: 4/30/2013 14:59:25\nLoca: 11800 FACTORY SHOPS BL\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301331",
        "CALL:ALARMF",
        "DATE:4/30/2013",
        "TIME:14:59:25",
        "ADDR:11800 FACTORY SHOPS BL",
        "CITY:HUNTLEY");

    doTest("T91",
        "(HUFD Dispatch) #\nOCA : 1301330\nType: ACCI\nDate: 4/30/2013 12:18:38\nLoca: COLD SPRINGS DR // FARM HILL DR\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301330",
        "CALL:ACCI",
        "DATE:4/30/2013",
        "TIME:12:18:38",
        "ADDR:COLD SPRINGS DR & FARM HILL DR",
        "CITY:HUNTLEY");

    doTest("T92",
        "(HUFD Dispatch) #\nOCA : 1301329\nType: FIREBRUSH\nDate: 4/30/2013 11:30:03\nLoca: 11002 BONNIE BRAE RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301329",
        "CALL:FIREBRUSH",
        "DATE:4/30/2013",
        "TIME:11:30:03",
        "ADDR:11002 BONNIE BRAE RD",
        "CITY:HUNTLEY");

    doTest("T93",
        "(HUFD Dispatch) #\nOCA : 1301328\nType: AMB\nDate: 4/30/2013 10:44:31\nLoca: 725 ACADEMIC DR\nCity: ALGONQUIN\nCros: SQUARE BARN RD",
        "SRC:HUFD",
        "ID:1301328",
        "CALL:AMB",
        "DATE:4/30/2013",
        "TIME:10:44:31",
        "ADDR:725 ACADEMIC DR",
        "CITY:ALGONQUIN",
        "X:SQUARE BARN RD");

    doTest("T94",
        "(HUFD Dispatch) #\nOCA : 1301327\nType: AMB\nDate: 4/30/2013 01:42:34\nLoca: 11 LARKSPUR CT\nCity: LAKE IN THE HILLS",
        "SRC:HUFD",
        "ID:1301327",
        "CALL:AMB",
        "DATE:4/30/2013",
        "TIME:01:42:34",
        "ADDR:11 LARKSPUR CT",
        "CITY:LAKE IN THE HILLS");

  }
  
  @Test
  public void testMcHenryCountySheriffsOffice() {

    doTest("T1",
        "(WLFD Dispatch) #\nOCA : 1300283\nType: AMB\nDate: 4/23/2013 14:52:21\nLoca: 5212 BONG ST\nCity: WONDER LAKE\nDist: 121",
        "SRC:WLFD",
        "ID:1300283",
        "CALL:AMB",
        "DATE:4/23/2013",
        "TIME:14:52:21",
        "ADDR:5212 BONG ST",
        "CITY:WONDER LAKE");

    doTest("T2",
        "(RMFD Dispatch) #\nOCA : 1300166\nType: AMB\nDate: 4/23/2013 14:28:14\nLoca: 10011 CHARLES ST\nCity: RICHMOND\nCros: SOUTH ST\nDist: 311",
        "SRC:RMFD",
        "ID:1300166",
        "CALL:AMB",
        "DATE:4/23/2013",
        "TIME:14:28:14",
        "ADDR:10011 CHARLES ST",
        "CITY:RICHMOND",
        "X:SOUTH ST",
        "INFO:Dist: 311");

    doTest("T3",
        "(HAFD Dispatch) #\nOCA : 1300288\nType: AMB\nDate: 4/23/2013 13:06:49\nLoca: 54 AUTUMN GLEN DR\nApt : 201\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300288",
        "CALL:AMB",
        "DATE:4/23/2013",
        "TIME:13:06:49",
        "ADDR:54 AUTUMN GLEN DR",
        "APT:201",
        "CITY:HARVARD");

    doTest("T4",
        "(WLFD Dispatch) #\nOCA : 1300282\nType: AMB\nDate: 4/23/2013 11:24:02\nLoca: 3145 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 125",
        "SRC:WLFD",
        "ID:1300282",
        "CALL:AMB",
        "DATE:4/23/2013",
        "TIME:11:24:02",
        "ADDR:3145 E LAKE SHORE DR",
        "CITY:WONDER LAKE");

    doTest("T5",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300165\n" +
        "Type: ALARMF\n" +
        "Date: 4/23/2013 11:19:34\n" +
        "Loca: 5205 ROUTE 12 HY\n" +
        "City: RICHMOND\n" +
        "Cros: KUNH RD\n" +
        "Dist: 813",

        "SRC:RMFD",
        "ID:1300165",
        "CALL:ALARMF",
        "DATE:4/23/2013",
        "TIME:11:19:34",
        "ADDR:5205 ROUTE 12 HY",
        "MADDR:5205 ROUTE 12",
        "CITY:RICHMOND",
        "X:KUNH RD",
        "INFO:Dist: 813");

    doTest("T6",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300164\n" +
        "Type: FIRE\n" +
        "Date: 4/23/2013 11:18:48\n" +
        "Loca: 8109 ROUTE 31 HY\n" +
        "City: RICHMOND\n" +
        "Cros: JAMES R RAKOW RD\n" +
        "Dist: 701",

        "SRC:RMFD",
        "ID:1300164",
        "CALL:FIRE",
        "DATE:4/23/2013",
        "TIME:11:18:48",
        "ADDR:8109 ROUTE 31 HY",
        "MADDR:8109 ROUTE 31",
        "CITY:RICHMOND",
        "X:JAMES R RAKOW RD",
        "INFO:Dist: 701");

    doTest("T7",
        "(RMFD Dispatch) #\nOCA : 1300163\nType: AMB\nDate: 4/22/2013 09:59:55\nLoca: 5412 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411",
        "SRC:RMFD",
        "ID:1300163",
        "CALL:AMB",
        "DATE:4/22/2013",
        "TIME:09:59:55",
        "ADDR:5412 MAY AV",
        "MADDR:5412 MAY AVE",
        "CITY:RICHMOND",
        "X:GOLF AV",
        "INFO:Dist: 411");

    doTest("T8",
        "(HAFD Dispatch) #\nOCA : 1300287\nType: AMB\nDate: 4/22/2013 08:22:08\nLoca: 1409 WILLOW LN\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300287",
        "CALL:AMB",
        "DATE:4/22/2013",
        "TIME:08:22:08",
        "ADDR:1409 WILLOW LN",
        "CITY:HARVARD");

    doTest("T9",
        "(WLFD Dispatch) #\nOCA : 1300281\nType: AMB\nDate: 4/21/2013 22:33:41\nLoca: 5408 SUMMERVILLE DR\nCity: WONDER LAKE\nDist: 121",
        "SRC:WLFD",
        "ID:1300281",
        "CALL:AMB",
        "DATE:4/21/2013",
        "TIME:22:33:41",
        "ADDR:5408 SUMMERVILLE DR",
        "CITY:WONDER LAKE");

    doTest("T10",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300162\n" +
        "Type: AMB\n" +
        "Date: 4/21/2013 20:58:17\n" +
        "Loca: 5600 HUNTER DR\n" +
        "City: RICHMOND\n" +
        "Cros: PRAIRIE RIDGE\n" +
        "Dist: 410",

        "SRC:RMFD",
        "ID:1300162",
        "CALL:AMB",
        "DATE:4/21/2013",
        "TIME:20:58:17",
        "ADDR:5600 HUNTER DR",
        "CITY:RICHMOND",
        "X:PRAIRIE RIDGE",
        "INFO:Dist: 410");

    doTest("T11",
        "(WLFD Dispatch) #\n" +
        "OCA : 1300280\n" +
        "Type: AMB\n" +
        "Date: 4/21/2013 16:03:03\n" +
        "Loca: 4300 E WONDER LAKE RD\n" +
        "City: WONDER LAKE\n" +
        "Cros: CENTER\n" +
        "Dist: 122",

        "SRC:WLFD",
        "ID:1300280",
        "CALL:AMB",
        "DATE:4/21/2013",
        "TIME:16:03:03",
        "ADDR:4300 E WONDER LAKE RD",
        "CITY:WONDER LAKE",
        "X:CENTER",
        "INFO:Dist: 122");

    doTest("T12",
        "(ALFD Dispatch) #\n" +
        "OCA : 1301202\n" +
        "Type: RESCUEWATER\n" +
        "Date: 4/21/2013 14:53:45\n" +
        "Loca: RIVER RD // ALGONQUIN RD\n" +
        "City: ALGONQUIN\n" +
        "Cros: CRABAPPLE DR\n" +
        "Dist: 31",

        "SRC:ALFD",
        "ID:1301202",
        "CALL:RESCUEWATER",
        "DATE:4/21/2013",
        "TIME:14:53:45",
        "ADDR:RIVER RD & ALGONQUIN RD",
        "CITY:ALGONQUIN",
        "X:CRABAPPLE DR",
        "INFO:Dist: 31");

    doTest("T13",
        "(HAFD Dispatch) #\nOCA : 1300286\nType: AMB\nDate: 4/21/2013 14:41:47\nLoca: 10901 ALDEN RD\nCity: HARVARD\nCros: HEBRON RD\nDist: 781",
        "SRC:HAFD",
        "ID:1300286",
        "CALL:AMB",
        "DATE:4/21/2013",
        "TIME:14:41:47",
        "ADDR:10901 ALDEN RD",
        "CITY:HARVARD",
        "X:HEBRON RD",
        "INFO:Dist: 781");

    doTest("T14",
        "(WLFD Dispatch) #\nOCA : 1300279\nType: AMB\nDate: 4/21/2013 11:08:53\nLoca: 8808 BURTON RD\nCity: WONDER LAKE\nDist: 217",
        "SRC:WLFD",
        "ID:1300279",
        "CALL:AMB",
        "DATE:4/21/2013",
        "TIME:11:08:53",
        "ADDR:8808 BURTON RD",
        "CITY:WONDER LAKE");

    doTest("T15",
        "(RMFD Dispatch) #\nOCA : 1300161\nType: AOA\nDate: 4/21/2013 10:27:45\nLoca: N1159 COUNTY HY H\nCity: GENOA CITY\nCros: HIGH RD",
        "SRC:RMFD",
        "ID:1300161",
        "CALL:AOA",
        "DATE:4/21/2013",
        "TIME:10:27:45",
        "ADDR:N1159 COUNTY HY H",
        "MADDR:N1159 COUNTY H & HIGH RD", // Not mapping
        "CITY:GENOA CITY",
        "X:HIGH RD");

    doTest("T16",
        "(RMFD Dispatch) #\nOCA : 1300160\nType: AOA\nDate: 4/21/2013 02:11:49\nLoca: 600 N LAKE AVE\nCity: TWIN LAKES",
        "SRC:RMFD",
        "ID:1300160",
        "CALL:AOA",
        "DATE:4/21/2013",
        "TIME:02:11:49",
        "ADDR:600 N LAKE AVE",
        "CITY:TWIN LAKES");

    doTest("T17",
        "(HAFD Dispatch) #\n" +
        "OCA : 1300285\n" +
        "Type: AMB\n" +
        "Date: 4/20/2013 23:59:25\n" +
        "Loca: ROUTE 14 HY // OAK GROVE RD\n" +
        "City: HARVARD\n" +
        "Cros: SPRING ST\n" +
        "Dist: 781",

        "SRC:HAFD",
        "ID:1300285",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:23:59:25",
        "ADDR:ROUTE 14 HY & OAK GROVE RD",
        "MADDR:ROUTE 14 & OAK GROVE RD",
        "CITY:HARVARD",
        "X:SPRING ST",
        "INFO:Dist: 781");

    doTest("T18",
        "(WLFD Dispatch) #\nOCA : 1300278\nType: AMB\nDate: 4/20/2013 21:25:21\nLoca: 5614 SYLVAN DR\nCity: WONDER LAKE\nDist: 121",
        "SRC:WLFD",
        "ID:1300278",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:21:25:21",
        "ADDR:5614 SYLVAN DR",
        "CITY:WONDER LAKE");

    doTest("T19",
        "(RMFD Dispatch) #\nOCA : 1300159\nType: AMB\nDate: 4/20/2013 20:04:18\nLoca: 5509 SOUTH ST\nCity: RICHMOND\nCros: EAST ST\nDist: 311",
        "SRC:RMFD",
        "ID:1300159",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:20:04:18",
        "ADDR:5509 SOUTH ST",
        "CITY:RICHMOND",
        "X:EAST ST",
        "INFO:Dist: 311");

    doTest("T20",
        "(WLFD Dispatch) #\nOCA : 1300277\nType: AMB\nDate: 4/20/2013 19:28:54\nLoca: 7222 N OAK ST\nCity: WONDER LAKE\nDist: 122",
        "SRC:WLFD",
        "ID:1300277",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:19:28:54",
        "ADDR:7222 N OAK ST",
        "CITY:WONDER LAKE");

    doTest("T21",
        "(WLFD Dispatch) #\nOCA : 1300276\nType: AOA\nDate: 4/20/2013 19:09:16\nLoca: 502 MCHENRY AV\nApt : 300\nCity: WOODSTOCK\nDist: 132",
        "SRC:WLFD",
        "ID:1300276",
        "CALL:AOA",
        "DATE:4/20/2013",
        "TIME:19:09:16",
        "ADDR:502 MCHENRY AV",
        "MADDR:502 MCHENRY AVE",
        "APT:300",
        "CITY:WOODSTOCK");

    doTest("T22",
        "(HAFD Dispatch) #\nOCA : 1300284\nType: AMB\nDate: 4/20/2013 16:03:05\nLoca: 301 S DIVISION ST\nCity: HARVARD\nDist: 783",
        "SRC:HAFD",
        "ID:1300284",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:16:03:05",
        "ADDR:301 S DIVISION ST",
        "CITY:HARVARD");

    doTest("T23",
        "(SGFD Dispatch) #\nOCA : 1300191\nType: AMB\nDate: 4/20/2013 15:29:53\nLoca: 1419 MAIN ST\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300191",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:15:29:53",
        "ADDR:1419 MAIN ST",
        "CITY:SPRING GROVE");

    doTest("T24",
        "(SGFD Dispatch) #\nOCA : 1300190\nType: ASSISTFIRE\nDate: 4/20/2013 11:46:48\nLoca: 39717 N WHITENBERG\nCity: ANTIOCH",
        "SRC:SGFD",
        "ID:1300190",
        "CALL:ASSISTFIRE",
        "DATE:4/20/2013",
        "TIME:11:46:48",
        "ADDR:39717 N WHITENBERG",  // Not mapping
        "CITY:ANTIOCH");

    doTest("T25",
        "(HAFD Dispatch) #\nOCA : 1300283\nType: AMB\nDate: 4/20/2013 09:59:24\nLoca: 341 MARENGO RD\nCity: HARVARD\nDist: 783",
        "SRC:HAFD",
        "ID:1300283",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:09:59:24",
        "ADDR:341 MARENGO RD",
        "CITY:HARVARD");

    doTest("T26",
        "(HAFD Dispatch) #\nOCA : 1300282\nType: AMB\nDate: 4/20/2013 04:07:15\nLoca: 17605 MCGUIRE RD\nCity: HARVARD\nDist: 782",
        "SRC:HAFD",
        "ID:1300282",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:04:07:15",
        "ADDR:17605 MCGUIRE RD",
        "CITY:HARVARD");

    doTest("T27",
        "(HAFD Dispatch) #\nOCA : 1300281\nType: AMB\nDate: 4/20/2013 03:47:50\nLoca: 715 NORTHFIELD AV\nApt : 6\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300281",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:03:47:50",
        "ADDR:715 NORTHFIELD AV",
        "MADDR:715 NORTHFIELD AVE",
        "APT:6",
        "CITY:HARVARD");

    doTest("T28",
        "(RMFD Dispatch) #\nOCA : 1300158\nType: AMB\nDate: 4/20/2013 03:11:11\nLoca: 5508 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411",
        "SRC:RMFD",
        "ID:1300158",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:03:11:11",
        "ADDR:5508 MAY AV",
        "MADDR:5508 MAY AVE",
        "CITY:RICHMOND",
        "X:GOLF AV",
        "INFO:Dist: 411");

    doTest("T29",
        "(HAFD Dispatch) #\nOCA : 1300280\nType: AMB\nDate: 4/20/2013 01:29:12\nLoca: 15 N AYER ST\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300280",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:01:29:12",
        "ADDR:15 N AYER ST",
        "CITY:HARVARD");

    doTest("T30",
        "(HAFD Dispatch) #\nOCA : 1300279\nType: AMB\nDate: 4/20/2013 01:12:08\nLoca: 201 W FRONT ST\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300279",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:01:12:08",
        "ADDR:201 W FRONT ST",
        "CITY:HARVARD");

    doTest("T31",
        "(SGFD Dispatch) #\nOCA : 1300189\nType: AMB\nDate: 4/20/2013 00:05:20\nLoca: 6720 JOHNSBURG RD\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300189",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:00:05:20",
        "ADDR:6720 JOHNSBURG RD",
        "CITY:SPRING GROVE");

    doTest("T32",
        "(WLFD Dispatch) #\nOCA : 1300275\nType: AMB\nDate: 4/20/2013 00:02:48\nLoca: 3412 FAWN LN\nCity: WONDER LAKE\nDist: 123",
        "SRC:WLFD",
        "ID:1300275",
        "CALL:AMB",
        "DATE:4/20/2013",
        "TIME:00:02:48",
        "ADDR:3412 FAWN LN",
        "CITY:WONDER LAKE");

    doTest("T33",
        "(HAFD Dispatch) #\nOCA : 1300278\nType: AMB\nDate: 4/19/2013 22:41:25\nLoca: 20607 DUNHAM RD\nCity: MARENGO\nDist: 782",
        "SRC:HAFD",
        "ID:1300278",
        "CALL:AMB",
        "DATE:4/19/2013",
        "TIME:22:41:25",
        "ADDR:20607 DUNHAM RD",
        "CITY:MARENGO");

    doTest("T34",
        "(HAFD Dispatch) #\nOCA : 1300277\nType: AMB\nDate: 4/19/2013 17:27:24\nLoca: 701 N HART ST\nCity: HARVARD\nDist: 781",
        "SRC:HAFD",
        "ID:1300277",
        "CALL:AMB",
        "DATE:4/19/2013",
        "TIME:17:27:24",
        "ADDR:701 N HART ST",
        "CITY:HARVARD");

    doTest("T35",
        "(HAFD Dispatch) #\nOCA : 1300276\nType: AMB\nDate: 4/19/2013 16:59:34\nLoca: 17817 ROUTE 14 HY\nCity: HARVARD\nDist: 782",
        "SRC:HAFD",
        "ID:1300276",
        "CALL:AMB",
        "DATE:4/19/2013",
        "TIME:16:59:34",
        "ADDR:17817 ROUTE 14 HY",
        "MADDR:17817 ROUTE 14",
        "CITY:HARVARD");

    doTest("T36",
        "(WDFD Dispatch) #\nOCA : 1301217\nType: FIRE\nDate: 4/19/2013 15:54:40\nLoca: 1067 GREENWOOD CIR\nCity: WOODSTOCK\nCros: CARY RD",
        "SRC:WDFD",
        "ID:1301217",
        "CALL:FIRE",
        "DATE:4/19/2013",
        "TIME:15:54:40",
        "ADDR:1067 GREENWOOD CIR",
        "CITY:WOODSTOCK",
        "X:CARY RD");

    doTest("T37",
        "(WLFD Dispatch) #\nOCA : 1300273\nType: AMB\nDate: 4/19/2013 15:03:57\nLoca: 7609 LUCY DR\nCity: WONDER LAKE\nDist: 125",
        "SRC:WLFD",
        "ID:1300273",
        "CALL:AMB",
        "DATE:4/19/2013",
        "TIME:15:03:57",
        "ADDR:7609 LUCY DR",
        "CITY:WONDER LAKE");

    doTest("T38",
        "(HAFD Dispatch) #\nOCA : 1300275\nType: SMOKE\nDate: 4/19/2013 07:33:33\nLoca: 6915 OAK GROVE RD\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300275",
        "CALL:SMOKE",
        "DATE:4/19/2013",
        "TIME:07:33:33",
        "ADDR:6915 OAK GROVE RD",
        "CITY:HARVARD");

    doTest("T39",
        "(MCFD Dispatch) #\nOCA : 1301318\nType: FIRE\nDate: 4/19/2013 07:12:23\nLoca: 905 HAYDEN DR\nCity: MCHENRY",
        "SRC:MCFD",
        "ID:1301318",
        "CALL:FIRE",
        "DATE:4/19/2013",
        "TIME:07:12:23",
        "ADDR:905 HAYDEN DR",
        "CITY:MCHENRY");

    doTest("T40",
        "(WLFD Dispatch) #\nOCA : 1300272\nType: AMB\nDate: 4/18/2013 19:32:51\nLoca: 9003 W SUNSET DR\nCity: WONDER LAKE\nDist: 217",
        "SRC:WLFD",
        "ID:1300272",
        "CALL:AMB",
        "DATE:4/18/2013",
        "TIME:19:32:51",
        "ADDR:9003 W SUNSET DR",
        "CITY:WONDER LAKE");

    doTest("T41",
        "(HAFD Dispatch) #\n" +
        "OCA : 1300274\n" +
        "Type: ASSISTFIRE\n" +
        "Date: 4/18/2013 18:01:59\n" +
        "Loca: 11605 MAPLE AV\n" +
        "City: HEBRON\n" +
        "Cros: WOODLAND DR\n" +
        "Dist: 85",

        "SRC:HAFD",
        "ID:1300274",
        "CALL:ASSISTFIRE",
        "DATE:4/18/2013",
        "TIME:18:01:59",
        "ADDR:11605 MAPLE AV",
        "MADDR:11605 MAPLE AVE",
        "CITY:HEBRON",
        "X:WOODLAND DR",
        "INFO:Dist: 85");

    doTest("T42",
        "(SGFD Dispatch) #\nOCA : 1300188\nType: AMB\nDate: 4/18/2013 16:12:07\nLoca: 10810 RED HAWK LN\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300188",
        "CALL:AMB",
        "DATE:4/18/2013",
        "TIME:16:12:07",
        "ADDR:10810 RED HAWK LN",
        "CITY:SPRING GROVE");

    doTest("T43",
        "(HAFD Dispatch) #\nOCA : 1300273\nType: AMB\nDate: 4/18/2013 15:49:36\nLoca: 714 W PARK ST\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300273",
        "CALL:AMB",
        "DATE:4/18/2013",
        "TIME:15:49:36",
        "ADDR:714 W PARK ST",
        "CITY:HARVARD");

    doTest("T44",
        "(RMFD Dispatch) #\nOCA : 1300156\nType: ALARMF\nDate: 4/18/2013 15:37:51\nLoca: 8311 ROUTE 31 HY\nCity: RICHMOND\nCros: TRYON GROVE RD",
        "SRC:RMFD",
        "ID:1300156",
        "CALL:ALARMF",
        "DATE:4/18/2013",
        "TIME:15:37:51",
        "ADDR:8311 ROUTE 31 HY",
        "MADDR:8311 ROUTE 31",
        "CITY:RICHMOND",
        "X:TRYON GROVE RD");

    doTest("T45",
        "(SGFD Dispatch) #\nOCA : 1300187\nType: AMB\nDate: 4/18/2013 14:32:45\nLoca: 7116 WILMOT RD\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300187",
        "CALL:AMB",
        "DATE:4/18/2013",
        "TIME:14:32:45",
        "ADDR:7116 WILMOT RD",
        "CITY:SPRING GROVE");

    doTest("T46",
        "(HAFD Dispatch) #\nOCA : 1300272\nType: AMB\nDate: 4/18/2013 08:58:34\nLoca: 1103 N JEFFERSON ST\nCity: HARVARD\nDist: 781",
        "SRC:HAFD",
        "ID:1300272",
        "CALL:AMB",
        "DATE:4/18/2013",
        "TIME:08:58:34",
        "ADDR:1103 N JEFFERSON ST",
        "CITY:HARVARD");

    doTest("T47",
        "(HUFD Dispatch) #\nOCA : 1301208\nType: FIRE\nDate: 4/18/2013 07:41:17\nLoca: 9798 JAMESTOWN RD\nCity: HUNTLEY",
        "SRC:HUFD",
        "ID:1301208",
        "CALL:FIRE",
        "DATE:4/18/2013",
        "TIME:07:41:17",
        "ADDR:9798 JAMESTOWN RD",
        "CITY:HUNTLEY");

    doTest("T48",
        "(WLFD Dispatch) #\n" +
        "OCA : 1300271\n" +
        "Type: HAZARD COND\n" +
        "Date: 4/18/2013 06:44:12\n" +
        "Loca: 2606 MICHAEL ST\n" +
        "City: WONDER LAKE\n" +
        "Cros: SAWMILL LN\n" +
        "Dist: 125",

        "SRC:WLFD",
        "ID:1300271",
        "CALL:HAZARD COND",
        "DATE:4/18/2013",
        "TIME:06:44:12",
        "ADDR:2606 MICHAEL ST",
        "CITY:WONDER LAKE",
        "X:SAWMILL LN",
        "INFO:Dist: 125");

    doTest("T49",
        "(WLFD Dispatch) #\nOCA : 1300270\nType: SMOKE\nDate: 4/18/2013 04:56:41\nLoca: 5626 WONDER WOODS DR\nCity: WONDER LAKE\nDist: 219",
        "SRC:WLFD",
        "ID:1300270",
        "CALL:SMOKE",
        "DATE:4/18/2013",
        "TIME:04:56:41",
        "ADDR:5626 WONDER WOODS DR",
        "CITY:WONDER LAKE");

    doTest("T50",
        "(HAFD Dispatch) #\nOCA : 1300271\nType: AOA\nDate: 4/18/2013 01:53:00\nLoca: N4285 HY M\nCity: DELAVAN",
        "SRC:HAFD",
        "ID:1300271",
        "CALL:AOA",
        "DATE:4/18/2013",
        "TIME:01:53:00",
        "ADDR:N4285 HY M",
        "MADDR:N4285 HWY M",
        "CITY:DELAVAN");

    doTest("T51",
        "(HAFD Dispatch) #\nOCA : 1300270\nType: AMB\nDate: 4/17/2013 23:21:09\nLoca: 1103 9TH ST\nApt : 2\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300270",
        "CALL:AMB",
        "DATE:4/17/2013",
        "TIME:23:21:09",
        "ADDR:1103 9TH ST",
        "APT:2",
        "CITY:HARVARD");

    doTest("T52",
        "(RMFD Dispatch) #\nOCA : 1300154\nType: AMB\nDate: 4/17/2013 15:34:29\nLoca: 10012 CIRCLE DR\nCity: RICHMOND\nCros: MAY AV\nDist: 411",
        "SRC:RMFD",
        "ID:1300154",
        "CALL:AMB",
        "DATE:4/17/2013",
        "TIME:15:34:29",
        "ADDR:10012 CIRCLE DR",
        "CITY:RICHMOND",
        "X:MAY AV",
        "INFO:Dist: 411");

    doTest("T53",
        "(HBFD Dispatch) #\n" +
        "OCA : 1300114\n" +
        "Type: FIRE\n" +
        "Date: 4/17/2013 15:02:06\n" +
        "Loca: 8508 NOLAN ST\n" +
        "City: HARVARD\n" +
        "Cros: CHARLOTTE CT\n" +
        "Dist: HB81",

        "SRC:HBFD",
        "ID:1300114",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:15:02:06",
        "ADDR:8508 NOLAN ST",
        "CITY:HARVARD",
        "X:CHARLOTTE CT",
        "INFO:Dist: HB81");

    doTest("T54",
        "(WLFD Dispatch) #\nOCA : 1300269\nType: FIRE\nDate: 4/17/2013 14:26:28\nLoca: 8012 LORRAINE ST\nCity: SPRING GROVE",
        "SRC:WLFD",
        "ID:1300269",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:14:26:28",
        "ADDR:8012 LORRAINE ST",
        "CITY:SPRING GROVE");

    doTest("T55",
        "(SGFD Dispatch) #\n" +
        "OCA : 1300185\n" +
        "Type: FIRE\n" +
        "Date: 4/17/2013 14:26:28\n" +
        "Loca: OAK ST // LORRAINE ST\n" +
        "City: SPRING GROVE\n" +
        "Cros: BARINA RD",

        "SRC:SGFD",
        "ID:1300185",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:14:26:28",
        "ADDR:OAK ST & LORRAINE ST",
        "CITY:SPRING GROVE",
        "X:BARINA RD");

    doTest("T56",
        "(ALFD Dispatch) #\nOCA : 1301157\nType: FIRE\nDate: 4/17/2013 14:17:35\nLoca: 6 BLACK DIAMOND CT\nCity: LAKE IN THE HILLS",
        "SRC:ALFD",
        "ID:1301157",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:14:17:35",
        "ADDR:6 BLACK DIAMOND CT",
        "CITY:LAKE IN THE HILLS");

    doTest("T57",
        "(SGFD Dispatch) #\nOCA : 1300184\nType: FIRE\nDate: 4/17/2013 13:51:46\nLoca: 9206 DEBORAH LN\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300184",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:13:51:46",
        "ADDR:9206 DEBORAH LN",
        "CITY:SPRING GROVE");

    doTest("T58",
        "(MCSO Dispatch) #\nOCA : MCSO-13-011904\nType: FIRE\nDate: 4/17/2013 13:33:07\nLoca: 8511 MAXON RD\nCity: HARVARD\nDist: 784",
        "SRC:MCSO",
        "ID:MCSO-13-011904",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:13:33:07",
        "ADDR:8511 MAXON RD",
        "CITY:HARVARD");

    doTest("T59",
        "(HAFD Dispatch) #\nOCA : 1300269\nType: FIRE\nDate: 4/17/2013 13:33:35\nLoca: 8511 MAXON RD\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300269",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:13:33:35",
        "ADDR:8511 MAXON RD",
        "CITY:HARVARD");

    doTest("T60",
        "(ALFD Dispatch) #\nOCA : 1301156\nType: FIRE\nDate: 4/17/2013 12:38:54\nLoca: THREE OAKS RD // SANDS RD\nCity: CRYSTAL LAKE\nDist: 31",
        "SRC:ALFD",
        "ID:1301156",
        "CALL:FIRE",
        "DATE:4/17/2013",
        "TIME:12:38:54",
        "ADDR:THREE OAKS RD & SANDS RD",
        "CITY:CRYSTAL LAKE");

    doTest("T61",
        "(SGFD Dispatch) #\nOCA : 1300183\nType: AMB\nDate: 4/16/2013 20:03:47\nLoca: 3407 CORNFLOWER WY\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300183",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:20:03:47",
        "ADDR:3407 CORNFLOWER WY",
        "CITY:SPRING GROVE");

    doTest("T62",
        "(SGFD Dispatch) #\nOCA : 1300182\nType: SMOKE\nDate: 4/16/2013 18:30:53\nLoca: 3813 REDWOOD CT\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300182",
        "CALL:SMOKE",
        "DATE:4/16/2013",
        "TIME:18:30:53",
        "ADDR:3813 REDWOOD CT",
        "CITY:SPRING GROVE");

    doTest("T63",
        "(HAFD Dispatch) #\nOCA : 1300268\nType: AMB\nDate: 4/16/2013 18:23:57\nLoca: 120 W BRINK ST\nApt : 3\nCity: HARVARD\nDist: 783",
        "SRC:HAFD",
        "ID:1300268",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:18:23:57",
        "ADDR:120 W BRINK ST",
        "APT:3",
        "CITY:HARVARD");

    doTest("T64",
        "(HAFD Dispatch) #\nOCA : 1300267\nType: AMB\nDate: 4/16/2013 17:40:51\nLoca: 816 ROUTE 23 HY\nCity: HARVARD\nDist: 782",
        "SRC:HAFD",
        "ID:1300267",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:17:40:51",
        "ADDR:816 ROUTE 23 HY",
        "MADDR:816 ROUTE 23",
        "CITY:HARVARD");

    doTest("T65",
        "(SGFD Dispatch) #\nOCA : 1300181\nType: AMB\nDate: 4/16/2013 17:21:03\nLoca: ROUTE 12 HY // GRAY ST\nCity: SPRING GROVE\nCros: SCOTT LN",
        "SRC:SGFD",
        "ID:1300181",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:17:21:03",
        "ADDR:ROUTE 12 HY & GRAY ST",
        "MADDR:ROUTE 12 & GRAY ST",
        "CITY:SPRING GROVE",
        "X:SCOTT LN");

    doTest("T66",
        "(WLFD Dispatch) #\nOCA : 1300267\nType: WIRE\nDate: 4/16/2013 16:35:51\nLoca: 8202 ROUTE 120 HY\nCity: WONDER LAKE\nDist: 125",
        "SRC:WLFD",
        "ID:1300267",
        "CALL:WIRE",
        "DATE:4/16/2013",
        "TIME:16:35:51",
        "ADDR:8202 ROUTE 120 HY",
        "MADDR:8202 ROUTE 120",
        "CITY:WONDER LAKE");

    doTest("T67",
        "(HAFD Dispatch) #\nOCA : 1300266\nType: FIREBRUSH\nDate: 4/16/2013 16:32:15\nLoca: 8607 FERRIS RD\nCity: HARVARD\nDist: 781",
        "SRC:HAFD",
        "ID:1300266",
        "CALL:FIREBRUSH",
        "DATE:4/16/2013",
        "TIME:16:32:15",
        "ADDR:8607 FERRIS RD",
        "CITY:HARVARD");

    doTest("T68",
        "(WLFD Dispatch) #\nOCA : 1300266\nType: ACCI\nDate: 4/16/2013 16:08:20\nLoca: THOMPSON RD // PINE AV\nCity: WONDER LAKE\nDist: 217",
        "SRC:WLFD",
        "ID:1300266",
        "CALL:ACCI",
        "DATE:4/16/2013",
        "TIME:16:08:20",
        "ADDR:THOMPSON RD & PINE AV",
        "MADDR:THOMPSON RD & PINE AVE",
        "CITY:WONDER LAKE");

    doTest("T69",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300150\n" +
        "Type: FIREBRUSH\n" +
        "Date: 4/16/2013 15:05:00\n" +
        "Loca: 4200 HAWKS POINT TR\n" +
        "City: RICHMOND\n" +
        "Cros: E PADDOCK ST\n" +
        "Dist: 210",

        "SRC:RMFD",
        "ID:1300150",
        "CALL:FIREBRUSH",
        "DATE:4/16/2013",
        "TIME:15:05:00",
        "ADDR:4200 HAWKS POINT TR",
        "CITY:RICHMOND",
        "X:E PADDOCK ST",
        "INFO:Dist: 210");

    doTest("T70",
        "(HAFD Dispatch) #\nOCA : 1300265\nType: AMB\nDate: 4/16/2013 14:43:54\nLoca: 908 FOREST DOWNS\nCity: HARVARD\nDist: 784",
        "SRC:HAFD",
        "ID:1300265",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:14:43:54",
        "ADDR:908 FOREST DOWNS",
        "CITY:HARVARD");

    doTest("T71",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300149\n" +
        "Type: AMB\n" +
        "Date: 4/16/2013 13:53:19\n" +
        "Loca: 11302 ROUTE 12 HY\n" +
        "City: RICHMOND\n" +
        "Cros: BURLINGTON RD\n" +
        "Dist: 213",

        "SRC:RMFD",
        "ID:1300149",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:13:53:19",
        "ADDR:11302 ROUTE 12 HY",
        "MADDR:11302 ROUTE 12",
        "CITY:RICHMOND",
        "X:BURLINGTON RD",
        "INFO:Dist: 213");

    doTest("T72",
        "(HAFD Dispatch) #\nOCA : 1300264\nType: AMB\nDate: 4/16/2013 11:08:52\nLoca: JEFFERSON ST // HARRISON ST\nCity: HARVARD\nDist: 781",
        "SRC:HAFD",
        "ID:1300264",
        "CALL:AMB",
        "DATE:4/16/2013",
        "TIME:11:08:52",
        "ADDR:JEFFERSON ST & HARRISON ST",
        "CITY:HARVARD");

    doTest("T73",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300148\n" +
        "Type: FIREBRUSH\n" +
        "Date: 4/16/2013 02:05:57\n" +
        "Loca: 5717 SOUTH ST\n" +
        "City: RICHMOND\n" +
        "Cros: WEST ST\n" +
        "Dist: 311",

        "SRC:RMFD",
        "ID:1300148",
        "CALL:FIREBRUSH",
        "DATE:4/16/2013",
        "TIME:02:05:57",
        "ADDR:5717 SOUTH ST",
        "CITY:RICHMOND",
        "X:WEST ST",
        "INFO:Dist: 311");

    doTest("T74",
        "(WLFD Dispatch) #\nOCA : 1300265\nType: AMB\nDate: 4/15/2013 21:55:16\nLoca: 5201 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 121",
        "SRC:WLFD",
        "ID:1300265",
        "CALL:AMB",
        "DATE:4/15/2013",
        "TIME:21:55:16",
        "ADDR:5201 E LAKE SHORE DR",
        "CITY:WONDER LAKE");

    doTest("T75",
        "(WLFD Dispatch) #\nOCA : 1300264\nType: AMB\nDate: 4/15/2013 21:10:36\nLoca: 3125 E LAKE SHORE DR\nCity: WONDER LAKE\nDist: 125",
        "SRC:WLFD",
        "ID:1300264",
        "CALL:AMB",
        "DATE:4/15/2013",
        "TIME:21:10:36",
        "ADDR:3125 E LAKE SHORE DR",
        "CITY:WONDER LAKE");

    doTest("T76",
        "(SGFD Dispatch) #\nOCA : 1300180\nType: AMB\nDate: 4/15/2013 18:24:26\nLoca: 1709 HUNTERS LN\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300180",
        "CALL:AMB",
        "DATE:4/15/2013",
        "TIME:18:24:26",
        "ADDR:1709 HUNTERS LN",
        "CITY:SPRING GROVE");

    doTest("T77",
        "(RMFD Dispatch) #\n" +
        "OCA : 1300147\n" +
        "Type: AMB\n" +
        "Date: 4/15/2013 17:12:25\n" +
        "Loca: 6919 ROUTE 173 HY\n" +
        "City: RICHMOND\n" +
        "Cros: BROADWAY ST\n" +
        "Dist: 301",

        "SRC:RMFD",
        "ID:1300147",
        "CALL:AMB",
        "DATE:4/15/2013",
        "TIME:17:12:25",
        "ADDR:6919 ROUTE 173 HY",
        "MADDR:6919 ROUTE 173",
        "CITY:RICHMOND",
        "X:BROADWAY ST",
        "INFO:Dist: 301");

    doTest("T78",
        "(MCSO Dispatch) #\nOCA : MCSO-13-011685\nType: SEXOTHER\nDate: 4/15/2013 16:56:37\nLoca: 7407 BARRY AV\nCity: SPRING GROVE",
        "SRC:MCSO",
        "ID:MCSO-13-011685",
        "CALL:SEXOTHER",
        "DATE:4/15/2013",
        "TIME:16:56:37",
        "ADDR:7407 BARRY AV",
        "MADDR:7407 BARRY AVE",
        "CITY:SPRING GROVE");

    doTest("T79",
        "(WLFD Dispatch) #\nOCA : 1300263\nType: AMB\nDate: 4/15/2013 13:59:31\nLoca: 7140 BARNARD MILL RD\nCity: WONDER LAKE\nDist: 121",
        "SRC:WLFD",
        "ID:1300263",
        "CALL:AMB",
        "DATE:4/15/2013",
        "TIME:13:59:31",
        "ADDR:7140 BARNARD MILL RD",
        "CITY:WONDER LAKE");

    doTest("T80",
        "(HBFD Dispatch) #\nOCA : 1300110\nType: FIRE\nDate: 4/6/2013 07:05:42\nLoca: 6615 STATE PARK RD\nCity: SPRING GROVE",
        "SRC:HBFD",
        "ID:1300110",
        "CALL:FIRE",
        "DATE:4/6/2013",
        "TIME:07:05:42",
        "ADDR:6615 STATE PARK RD",
        "CITY:SPRING GROVE");

    doTest("T81",
        "(HAFD Dispatch) #\nOCA : 1300263\nType: AMB\nDate: 4/14/2013 22:12:57\nLoca: 520 COUNTRY BROOK LN\nCity: HARVARD\nDist: 783",
        "SRC:HAFD",
        "ID:1300263",
        "CALL:AMB",
        "DATE:4/14/2013",
        "TIME:22:12:57",
        "ADDR:520 COUNTRY BROOK LN",
        "CITY:HARVARD");

    doTest("T82",
        "(SGFD Dispatch) #\nOCA : 1300179\nType: AMB\nDate: 4/14/2013 18:01:54\nLoca: 2219 HUNTERS CT\nCity: SPRING GROVE",
        "SRC:SGFD",
        "ID:1300179",
        "CALL:AMB",
        "DATE:4/14/2013",
        "TIME:18:01:54",
        "ADDR:2219 HUNTERS CT",
        "CITY:SPRING GROVE");

    doTest("T83",
        "(RMFD Dispatch) #\nOCA : 1300146\nType: AMB\nDate: 4/14/2013 14:12:11\nLoca: 5414 MAY AV\nCity: RICHMOND\nCros: GOLF AV\nDist: 411",
        "SRC:RMFD",
        "ID:1300146",
        "CALL:AMB",
        "DATE:4/14/2013",
        "TIME:14:12:11",
        "ADDR:5414 MAY AV",
        "MADDR:5414 MAY AVE",
        "CITY:RICHMOND",
        "X:GOLF AV",
        "INFO:Dist: 411");

    doTest("T84",
        "(HAFD Dispatch) #\nOCA : 1300262\nType: AMB\nDate: 4/14/2013 10:46:06\nLoca: 395 S DIVISION ST\nCity: HARVARD\nDist: 783",
        "SRC:HAFD",
        "ID:1300262",
        "CALL:AMB",
        "DATE:4/14/2013",
        "TIME:10:46:06",
        "ADDR:395 S DIVISION ST",
        "CITY:HARVARD");

    doTest("T85",
        "(CLFD Dispatch) #\n" +
        "OCA : 1301472\n" +
        "Type: FIRE\n" +
        "Date: 4/14/2013 07:47:28\n" +
        "Loca: 1709 MOORLAND LN\n" +
        "City: CRYSTAL LAKE\n" +
        "Cros: WILLIAMSBURG LN\n" +
        "Dist: 43",

        "SRC:CLFD",
        "ID:1301472",
        "CALL:FIRE",
        "DATE:4/14/2013",
        "TIME:07:47:28",
        "ADDR:1709 MOORLAND LN",
        "CITY:CRYSTAL LAKE",
        "X:WILLIAMSBURG LN",
        "INFO:Dist: 43");

    doTest("T86",
        "(WLFD Dispatch) #\nOCA : 1300262\nType: AMB\nDate: 4/14/2013 03:24:54\nLoca: 7605 BEAVER RD\nCity: WONDER LAKE\nDist: 123",
        "SRC:WLFD",
        "ID:1300262",
        "CALL:AMB",
        "DATE:4/14/2013",
        "TIME:03:24:54",
        "ADDR:7605 BEAVER RD",
        "CITY:WONDER LAKE");

  }
  
  @Test
  public void testWoodstockFireRescue() {

    doTest("T1",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301446\nDate: 5/9/2013 04:18:22\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301446",
        "DATE:5/9/2013",
        "TIME:04:18:22",
        "ADDR:2406 HARTLAND RD",
        "CITY:WOODSTOCK");

    doTest("T2",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301445\nDate: 5/9/2013 01:48:33\nLoca: 1007 ALPINE LN\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301445",
        "DATE:5/9/2013",
        "TIME:01:48:33",
        "ADDR:1007 ALPINE LN",
        "CITY:WOODSTOCK");

    doTest("T3",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301444\nDate: 5/8/2013 23:09:13\nLoca: 208 GRIFFING AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301444",
        "DATE:5/8/2013",
        "TIME:23:09:13",
        "ADDR:208 GRIFFING AV",
        "MADDR:208 GRIFFING AVE",
        "CITY:WOODSTOCK");

    doTest("T4",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301443\nDate: 5/8/2013 20:56:51\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301443",
        "DATE:5/8/2013",
        "TIME:20:56:51",
        "ADDR:1275 LAKE AV",
        "MADDR:1275 LAKE AVE",
        "CITY:WOODSTOCK",
        "X:WILTSHIRE LN",
        "INFO:Dist: 216");

    doTest("T5",
        "(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301442\nDate: 5/8/2013 17:39:08\nLoca: 1430 COMMONS DR\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:ALARMF",
        "ID:1301442",
        "DATE:5/8/2013",
        "TIME:17:39:08",
        "ADDR:1430 COMMONS DR",
        "CITY:WOODSTOCK");

    doTest("T6",
        "(WDFD Dispatch) #\nType: ASSISTFIRE\nOCA : 1301441\nDate: 5/8/2013 15:39:23\nLoca: 207 N MENGE RD\nCity: MARENGO\nDist: 1182",
        "SRC:WDFD",
        "CALL:ASSISTFIRE",
        "ID:1301441",
        "DATE:5/8/2013",
        "TIME:15:39:23",
        "ADDR:207 N MENGE RD",
        "CITY:MARENGO");

    doTest("T7",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301440\nDate: 5/8/2013 15:30:13\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301440",
        "DATE:5/8/2013",
        "TIME:15:30:13",
        "ADDR:1275 LAKE AV",
        "MADDR:1275 LAKE AVE",
        "CITY:WOODSTOCK",
        "X:WILTSHIRE LN",
        "INFO:Dist: 216");

    doTest("T8",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301439\nDate: 5/8/2013 15:30:01\nLoca: 250 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 131",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301439",
        "DATE:5/8/2013",
        "TIME:15:30:01",
        "ADDR:250 S EASTWOOD DR",
        "CITY:WOODSTOCK");

    doTest("T9",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301438\nDate: 5/8/2013 13:58:48\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301438",
        "DATE:5/8/2013",
        "TIME:13:58:48",
        "ADDR:309 MCHENRY AV",
        "MADDR:309 MCHENRY AVE",
        "CITY:WOODSTOCK");

    doTest("T10",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301437\nDate: 5/8/2013 13:51:20\nLoca: 614 RIDGELAND AV\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301437",
        "DATE:5/8/2013",
        "TIME:13:51:20",
        "ADDR:614 RIDGELAND AV",
        "MADDR:614 RIDGELAND AVE",
        "CITY:WOODSTOCK");

    doTest("T11",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301436\nDate: 5/8/2013 11:41:20\nLoca: 1534 N SEMINARY AV\nApt : H\nCity: WOODSTOCK\nDist: 313",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301436",
        "DATE:5/8/2013",
        "TIME:11:41:20",
        "ADDR:1534 N SEMINARY AV",
        "MADDR:1534 N SEMINARY AVE",
        "APT:H",
        "CITY:WOODSTOCK");

    doTest("T12",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301435\nDate: 5/8/2013 11:17:19\nLoca: 617 AMSTERDAM ST\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301435",
        "DATE:5/8/2013",
        "TIME:11:17:19",
        "ADDR:617 AMSTERDAM ST",
        "CITY:WOODSTOCK");

    doTest("T13",
        "(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301434\nDate: 5/8/2013 10:19:03\nLoca: 217 RAFFEL RD\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "CALL:ALARMF",
        "ID:1301434",
        "DATE:5/8/2013",
        "TIME:10:19:03",
        "ADDR:217 RAFFEL RD",
        "CITY:WOODSTOCK");

    doTest("T14",
        "(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301433\nDate: 5/8/2013 09:48:31\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:ALARMF",
        "ID:1301433",
        "DATE:5/8/2013",
        "TIME:09:48:31",
        "ADDR:14411 KISHWAUKEE VALLEY RD",
        "CITY:WOODSTOCK");

    doTest("T15",
        "(WDFD Dispatch) #\nType: ACCI\nOCA : 1301432\nDate: 5/8/2013 06:37:27\nLoca: ROUTE 47 // RED BARN\nCity: WOODSTOCK",
        "SRC:WDFD",
        "CALL:ACCI",
        "ID:1301432",
        "DATE:5/8/2013",
        "TIME:06:37:27",
        "ADDR:ROUTE 47 & RED BARN",
        "CITY:WOODSTOCK");

    doTest("T16",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301431\nDate: 5/8/2013 06:03:04\nLoca: 656 LAKE AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301431",
        "DATE:5/8/2013",
        "TIME:06:03:04",
        "ADDR:656 LAKE AV",
        "MADDR:656 LAKE AVE",
        "CITY:WOODSTOCK");

    doTest("T17",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301430\nDate: 5/8/2013 02:13:02\nLoca: 710 ST JOHN`S RD\nApt : 16\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301430",
        "DATE:5/8/2013",
        "TIME:02:13:02",
        "ADDR:710 ST JOHN`S RD",
        "APT:16",
        "CITY:WOODSTOCK");

    doTest("T18",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301429\nDate: 5/8/2013 02:13:17\nLoca: 930 LAKE AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301429",
        "DATE:5/8/2013",
        "TIME:02:13:17",
        "ADDR:930 LAKE AV",
        "MADDR:930 LAKE AVE",
        "CITY:WOODSTOCK");

    doTest("T19",
        "(WDFD Dispatch) #\nType: ODOR\nOCA : 1301428\nDate: 5/7/2013 21:37:07\nLoca: 902 RHODES ST\nCity: WOODSTOCK\nDist: 133",
        "SRC:WDFD",
        "CALL:ODOR",
        "ID:1301428",
        "DATE:5/7/2013",
        "TIME:21:37:07",
        "ADDR:902 RHODES ST",
        "CITY:WOODSTOCK");

    doTest("T20",
        "(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301427\nDate: 5/7/2013 16:33:17\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314",
        "SRC:WDFD",
        "CALL:ALARMF",
        "ID:1301427",
        "DATE:5/7/2013",
        "TIME:16:33:17",
        "ADDR:2406 HARTLAND RD",
        "CITY:WOODSTOCK");

    doTest("T21",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301426\nDate: 5/7/2013 15:34:47\nLoca: 656 LAKE AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301426",
        "DATE:5/7/2013",
        "TIME:15:34:47",
        "ADDR:656 LAKE AV",
        "MADDR:656 LAKE AVE",
        "CITY:WOODSTOCK");

    doTest("T22",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301425\nDate: 5/7/2013 15:16:09\nLoca: 428 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301425",
        "DATE:5/7/2013",
        "TIME:15:16:09",
        "ADDR:428 S EASTWOOD DR",
        "CITY:WOODSTOCK");

    doTest("T23",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301424\nDate: 5/7/2013 13:13:37\nLoca: 1155 WALDEN OAKS DR\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301424",
        "DATE:5/7/2013",
        "TIME:13:13:37",
        "ADDR:1155 WALDEN OAKS DR",
        "CITY:WOODSTOCK");

    doTest("T24",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301423\nDate: 5/7/2013 11:35:50\nLoca: 527 W SOUTH ST\nApt : 361\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301423",
        "DATE:5/7/2013",
        "TIME:11:35:50",
        "ADDR:527 W SOUTH ST",
        "APT:361",
        "CITY:WOODSTOCK");

    doTest("T25",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301422\nDate: 5/7/2013 08:26:28\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301422",
        "DATE:5/7/2013",
        "TIME:08:26:28",
        "ADDR:14411 KISHWAUKEE VALLEY RD",
        "CITY:WOODSTOCK");

    doTest("T26",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301421\nDate: 5/7/2013 07:31:13\nLoca: 667 WARE RD\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301421",
        "DATE:5/7/2013",
        "TIME:07:31:13",
        "ADDR:667 WARE RD",
        "CITY:WOODSTOCK");

    doTest("T27",
        "(WDFD Dispatch) #\nType: ALARMF\nOCA : 1301420\nDate: 5/7/2013 03:27:52\nLoca: 14411 KISHWAUKEE VALLEY RD\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "CALL:ALARMF",
        "ID:1301420",
        "DATE:5/7/2013",
        "TIME:03:27:52",
        "ADDR:14411 KISHWAUKEE VALLEY RD",
        "CITY:WOODSTOCK");

    doTest("T28",
        "(WDFD Dispatch) #\nType: SMOKE\nOCA : 1301419\nDate: 5/6/2013 22:39:26\nLoca: 412 VINE ST\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:SMOKE",
        "ID:1301419",
        "DATE:5/6/2013",
        "TIME:22:39:26",
        "ADDR:412 VINE ST",
        "CITY:WOODSTOCK");

    doTest("T29",
        "(WDFD Dispatch) #\nType: CO NOSYMPTOM\nOCA : 1301418\nDate: 5/6/2013 18:46:48\nLoca: 209 FIELDSTONE DR\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:CO NOSYMPTOM",
        "ID:1301418",
        "DATE:5/6/2013",
        "TIME:18:46:48",
        "ADDR:209 FIELDSTONE DR",
        "CITY:WOODSTOCK");

    doTest("T30",
        "(WDFD Dispatch) #\nType: AOA\nOCA : 1301417\nDate: 5/6/2013 18:27:42\nLoca: 2200 N SEMINARY AV\nCity: WOODSTOCK\nDist: 313",
        "SRC:WDFD",
        "CALL:AOA",
        "ID:1301417",
        "DATE:5/6/2013",
        "TIME:18:27:42",
        "ADDR:2200 N SEMINARY AV",
        "MADDR:2200 N SEMINARY AVE",
        "CITY:WOODSTOCK");

    doTest("T31",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301416\nDate: 5/6/2013 17:50:31\nLoca: 600 DEAN ST\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301416",
        "DATE:5/6/2013",
        "TIME:17:50:31",
        "ADDR:600 DEAN ST",
        "CITY:WOODSTOCK");

    doTest("T32",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301414\nDate: 5/6/2013 16:18:10\nLoca: RTE 47 // MCCONNELL RD\nCity: WOODSTOCK",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301414",
        "DATE:5/6/2013",
        "TIME:16:18:10",
        "ADDR:RTE 47 & MCCONNELL RD",
        "CITY:WOODSTOCK");

    doTest("T33",
        "(WDFD Dispatch) #\nType: AMB\nOCA : 1301413\nDate: 5/6/2013 13:54:30\nLoca: 726 S JEFFERSON ST\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "CALL:AMB",
        "ID:1301413",
        "DATE:5/6/2013",
        "TIME:13:54:30",
        "ADDR:726 S JEFFERSON ST",
        "CITY:WOODSTOCK");

    doTest("T34",
        "(WDFD Dispatch) #\nOCA : 1301412\nType: AMB\nDate: 5/6/2013 13:42:07\nLoca: 117 VAN BUREN ST\nCity: WOODSTOCK\nDist: 128",
        "SRC:WDFD",
        "ID:1301412",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:13:42:07",
        "ADDR:117 VAN BUREN ST",
        "CITY:WOODSTOCK");

    doTest("T35",
        "(WDFD Dispatch) #\nOCA : 1301411\nType: AMB\nDate: 5/6/2013 13:36:33\nLoca: 460 W JACKSON ST\nApt : 1\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301411",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:13:36:33",
        "ADDR:460 W JACKSON ST",
        "APT:1",
        "CITY:WOODSTOCK");

    doTest("T36",
        "(WDFD Dispatch) #\nOCA : 1301410\nType: AMB\nDate: 5/6/2013 12:50:54\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "ID:1301410",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:12:50:54",
        "ADDR:309 MCHENRY AV",
        "MADDR:309 MCHENRY AVE",
        "CITY:WOODSTOCK");

    doTest("T37",
        "(WDFD Dispatch) #\nOCA : 1301409\nType: AOA\nDate: 5/6/2013 12:09:07\nLoca: 2800 CADBURY CI\nCity: LAKE IN THE HILLS",
        "SRC:WDFD",
        "ID:1301409",
        "CALL:AOA",
        "DATE:5/6/2013",
        "TIME:12:09:07",
        "ADDR:2800 CADBURY CI",
        "MADDR:2800 CADBURY CIR",
        "CITY:LAKE IN THE HILLS");

    doTest("T38",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301408\n" +
        "Type: ACCI\n" +
        "Date: 5/6/2013 11:48:45\n" +
        "Loca: 1128 WATERFORD CUT ST\n" +
        "City: CRYSTAL LAKE\n" +
        "Cros: SANDALWOOD LN\n" +
        "Dist: 43",

        "SRC:WDFD",
        "ID:1301408",
        "CALL:ACCI",
        "DATE:5/6/2013",
        "TIME:11:48:45",
        "ADDR:1128 WATERFORD CUT ST",
        "CITY:CRYSTAL LAKE",
        "X:SANDALWOOD LN",
        "INFO:Dist: 43");

    doTest("T39",
        "(WDFD Dispatch) #\nOCA : 1301407\nType: AMB\nDate: 5/6/2013 10:23:20\nLoca: 317 LAKE AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301407",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:10:23:20",
        "ADDR:317 LAKE AV",
        "MADDR:317 LAKE AVE",
        "CITY:WOODSTOCK");

    doTest("T40",
        "(WDFD Dispatch) #\nOCA : 1301406\nType: AMB\nDate: 5/6/2013 05:07:05\nLoca: 805 PLEASANT ST\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301406",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:05:07:05",
        "ADDR:805 PLEASANT ST",
        "CITY:WOODSTOCK");

    doTest("T41",
        "(WDFD Dispatch) #\nOCA : 1301405\nType: AMB\nDate: 5/6/2013 01:19:22\nLoca: 329 LAKE AV\nApt : 4\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301405",
        "CALL:AMB",
        "DATE:5/6/2013",
        "TIME:01:19:22",
        "ADDR:329 LAKE AV",
        "MADDR:329 LAKE AVE",
        "APT:4",
        "CITY:WOODSTOCK");

    doTest("T42",
        "(WDFD Dispatch) #\nOCA : 1301404\nType: FIREBRUSH\nDate: 5/5/2013 21:26:03\nLoca: CONCORD // N VALLEY HILL\nCity: WOODSTOCK",
        "SRC:WDFD",
        "ID:1301404",
        "CALL:FIREBRUSH",
        "DATE:5/5/2013",
        "TIME:21:26:03",
        "ADDR:CONCORD & N VALLEY HILL",
        "CITY:WOODSTOCK");

    doTest("T43",
        "(WDFD Dispatch) #\nOCA : 1301403\nType: LOCKOUT\nDate: 5/5/2013 20:13:57\nLoca: 121 N HAYWARD ST\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301403",
        "CALL:LOCKOUT",
        "DATE:5/5/2013",
        "TIME:20:13:57",
        "ADDR:121 N HAYWARD ST",
        "CITY:WOODSTOCK");

    doTest("T44",
        "(WDFD Dispatch) #\nOCA : 1301402\nType: AMB\nDate: 5/5/2013 12:46:46\nLoca: 820 LAKE AV\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301402",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:12:46:46",
        "ADDR:820 LAKE AV",
        "MADDR:820 LAKE AVE",
        "CITY:WOODSTOCK");

    doTest("T45",
        "(WDFD Dispatch) #\nOCA : 1301401\nType: AMB\nDate: 5/5/2013 12:03:27\nLoca: 1155 WALDEN OAKS DR\nApt : 209E\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301401",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:12:03:27",
        "ADDR:1155 WALDEN OAKS DR",
        "APT:209E",
        "CITY:WOODSTOCK");

    doTest("T46",
        "(WDFD Dispatch) #\nOCA : 1301400\nType: AMB\nDate: 5/5/2013 11:59:53\nLoca: 502 MCHENRY AV\nApt : 310\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "ID:1301400",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:11:59:53",
        "ADDR:502 MCHENRY AV",
        "MADDR:502 MCHENRY AVE",
        "APT:310",
        "CITY:WOODSTOCK");

    doTest("T47",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301398\n" +
        "Type: TA\n" +
        "Date: 5/5/2013 09:32:24\n" +
        "Loca: 1200-1216 DAVIS RD\n" +
        "City: WOODSTOCK\n" +
        "Cros: NIGHTHAWK WY\n" +
        "Dist: 216",

        "SRC:WDFD",
        "ID:1301398",
        "CALL:TA",
        "DATE:5/5/2013",
        "TIME:09:32:24",
        "ADDR:1200-1216 DAVIS RD",
        "MADDR:1200 DAVIS RD",
        "CITY:WOODSTOCK",
        "X:NIGHTHAWK WY",
        "INFO:Dist: 216");

    doTest("T48",
        "(WDFD Dispatch) #\nOCA : 1301397\nType: AMB\nDate: 5/5/2013 04:20:10\nLoca: 2428 ASPEN DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301397",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:04:20:10",
        "ADDR:2428 ASPEN DR",
        "CITY:WOODSTOCK");

    doTest("T49",
        "(WDFD Dispatch) #\nOCA : 1301396\nType: AMB\nDate: 5/5/2013 02:00:30\nLoca: 2609 N QUEEN ANNE RD\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "ID:1301396",
        "CALL:AMB",
        "DATE:5/5/2013",
        "TIME:02:00:30",
        "ADDR:2609 N QUEEN ANNE RD",
        "CITY:WOODSTOCK");

    doTest("T50",
        "(WDFD Dispatch) #\nOCA : 1301395\nType: AMB\nDate: 5/4/2013 23:54:30\nLoca: 1007 GREENWOOD CI\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "ID:1301395",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:23:54:30",
        "ADDR:1007 GREENWOOD CI",
        "MADDR:1007 GREENWOOD CIR",
        "CITY:WOODSTOCK");

    doTest("T51",
        "(WDFD Dispatch) #\nOCA : 1301394\nType: AMB\nDate: 5/4/2013 21:12:26\nLoca: 3916 S COUNTRY CLUB RD\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301394",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:21:12:26",
        "ADDR:3916 S COUNTRY CLUB RD",
        "CITY:WOODSTOCK");

    doTest("T52",
        "(WDFD Dispatch) #\nOCA : 1301393\nType: ODOR\nDate: 5/4/2013 21:53:52\nLoca: 388 LINCOLN AV\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301393",
        "CALL:ODOR",
        "DATE:5/4/2013",
        "TIME:21:53:52",
        "ADDR:388 LINCOLN AV",
        "MADDR:388 LINCOLN AVE",
        "CITY:WOODSTOCK");

    doTest("T53",
        "(WDFD Dispatch) #\nOCA : 1301392\nType: AMB\nDate: 5/4/2013 21:19:22\nLoca: 8620 CASTLEBERRY DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301392",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:21:19:22",
        "ADDR:8620 CASTLEBERRY DR",
        "CITY:WOODSTOCK");

    doTest("T54",
        "(WDFD Dispatch) #\nOCA : 1301391\nType: TA\nDate: 5/4/2013 20:44:54\nLoca: 1257 COBBLESTONE WY\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301391",
        "CALL:TA",
        "DATE:5/4/2013",
        "TIME:20:44:54",
        "ADDR:1257 COBBLESTONE WY",
        "CITY:WOODSTOCK");

    doTest("T55",
        "(WDFD Dispatch) #\nOCA : 1301390\nType: AMB\nDate: 5/4/2013 15:40:40\nLoca: 840 N SEMINARY AV\nApt : 105\nCity: WOODSTOCK\nDist: 133",
        "SRC:WDFD",
        "ID:1301390",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:15:40:40",
        "ADDR:840 N SEMINARY AV",
        "MADDR:840 N SEMINARY AVE",
        "APT:105",
        "CITY:WOODSTOCK");

    doTest("T56",
        "(WDFD Dispatch) #\nOCA : 1301389\nType: TA\nDate: 5/4/2013 15:21:51\nLoca: 1150 N ROSE FARM RD\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301389",
        "CALL:TA",
        "DATE:5/4/2013",
        "TIME:15:21:51",
        "ADDR:1150 N ROSE FARM RD",
        "CITY:WOODSTOCK");

    doTest("T57",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301388\n" +
        "Type: AMB\n" +
        "Date: 5/4/2013 14:49:30\n" +
        "Loca: 13519 W SOUTH ST\n" +
        "City: WOODSTOCK\n" +
        "Cros: W HILLSIDE RD\n" +
        "Dist: 131",

        "SRC:WDFD",
        "ID:1301388",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:14:49:30",
        "ADDR:13519 W SOUTH ST",
        "CITY:WOODSTOCK",
        "X:W HILLSIDE RD",
        "INFO:Dist: 131");

    doTest("T58",
        "(WDFD Dispatch) #\nOCA : 1301387\nType: ALARMF\nDate: 5/4/2013 13:11:01\nLoca: 10920 LUCAS RD\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301387",
        "CALL:ALARMF",
        "DATE:5/4/2013",
        "TIME:13:11:01",
        "ADDR:10920 LUCAS RD",
        "CITY:WOODSTOCK");

    doTest("T59",
        "(WDFD Dispatch) #\nOCA : 1301386\nType: ALARMR\nDate: 5/4/2013 12:41:08\nLoca: 1415 FOX SEDGE TR\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301386",
        "CALL:ALARMR",
        "DATE:5/4/2013",
        "TIME:12:41:08",
        "ADDR:1415 FOX SEDGE TR",
        "CITY:WOODSTOCK");

    doTest("T60",
        "(WDFD Dispatch) #\nOCA : 1301384\nType: AMB\nDate: 5/4/2013 09:22:51\nLoca: 2609 N QUEEN ANNE RD\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "ID:1301384",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:09:22:51",
        "ADDR:2609 N QUEEN ANNE RD",
        "CITY:WOODSTOCK");

    doTest("T61",
        "(WDFD Dispatch) #\nOCA : 1301383\nType: ACCI\nDate: 5/4/2013 07:06:53\nLoca: ROUTE 14 HY // DOTY RD\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301383",
        "CALL:ACCI",
        "DATE:5/4/2013",
        "TIME:07:06:53",
        "ADDR:ROUTE 14 HY & DOTY RD",
        "MADDR:ROUTE 14 & DOTY RD",
        "CITY:WOODSTOCK");

    doTest("T62",
        "(WDFD Dispatch) #\nOCA : 1301382\nType: AMB\nDate: 5/4/2013 00:42:44\nLoca: 436 WASHINGTON ST\nApt : 1\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301382",
        "CALL:AMB",
        "DATE:5/4/2013",
        "TIME:00:42:44",
        "ADDR:436 WASHINGTON ST",
        "APT:1",
        "CITY:WOODSTOCK");

    doTest("T63",
        "(WDFD Dispatch) #\nOCA : 1301381\nType: AMB\nDate: 5/3/2013 18:58:47\nLoca: 215 MAPLE ST\nCity: WOODSTOCK\nDist: 313",
        "SRC:WDFD",
        "ID:1301381",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:18:58:47",
        "ADDR:215 MAPLE ST",
        "CITY:WOODSTOCK");

    doTest("T64",
        "(WDFD Dispatch) #\nOCA : 1301380\nType: AMB\nDate: 5/3/2013 15:22:20\nLoca: 3909 RAYCRAFT RD\nCity: WOODSTOCK\nDist: 313",
        "SRC:WDFD",
        "ID:1301380",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:15:22:20",
        "ADDR:3909 RAYCRAFT RD",
        "CITY:WOODSTOCK");

    doTest("T65",
        "(WDFD Dispatch) #\nOCA : 1301379\nType: AMB\nDate: 5/3/2013 12:37:32\nLoca: 145 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 131",
        "SRC:WDFD",
        "ID:1301379",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:12:37:32",
        "ADDR:145 S EASTWOOD DR",
        "CITY:WOODSTOCK");

    doTest("T66",
        "(WDFD Dispatch) #\nOCA : 1301378\nType: AMB\nDate: 5/3/2013 11:56:57\nLoca: 388 LINCOLN AV\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301378",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:11:56:57",
        "ADDR:388 LINCOLN AV",
        "MADDR:388 LINCOLN AVE",
        "CITY:WOODSTOCK");

    doTest("T67",
        "(WDFD Dispatch) #\nOCA : 1301377\nType: AMB\nDate: 5/3/2013 10:35:55\nLoca: 402 E JACKSON ST\nApt : 1/2\nCity: WOODSTOCK\nDist: 131",
        "SRC:WDFD",
        "ID:1301377",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:10:35:55",
        "ADDR:402 E JACKSON ST",
        "APT:1/2",
        "CITY:WOODSTOCK");

    doTest("T68",
        "(WDFD Dispatch) #\nOCA : 1301376\nType: AMB\nDate: 5/3/2013 10:17:53\nLoca: 121 E BEECH AV\nCity: WOODSTOCK\nDist: 133",
        "SRC:WDFD",
        "ID:1301376",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:10:17:53",
        "ADDR:121 E BEECH AV",
        "MADDR:121 E BEECH AVE",
        "CITY:WOODSTOCK");

    doTest("T69",
        "(WDFD Dispatch) #\nOCA : 1301375\nType: AOA\nDate: 5/3/2013 04:47:36\nLoca: 2510 ROUTE 176 HY\nCity: PRAIRIE GROVE\nDist: 4",
        "SRC:WDFD",
        "ID:1301375",
        "CALL:AOA",
        "DATE:5/3/2013",
        "TIME:04:47:36",
        "ADDR:2510 ROUTE 176 HY",
        "MADDR:2510 ROUTE 176",
        "CITY:PRAIRIE GROVE");

    doTest("T70",
        "(WDFD Dispatch) #\nOCA : 1301374\nType: AMB\nDate: 5/3/2013 02:56:54\nLoca: 480 W JACKSON ST\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301374",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:02:56:54",
        "ADDR:480 W JACKSON ST",
        "CITY:WOODSTOCK");

    doTest("T71",
        "(WDFD Dispatch) #\nOCA : 1301373\nType: AMB\nDate: 5/3/2013 01:18:00\nLoca: 1543 N SEMINARY AV\nApt : H\nCity: WOODSTOCK\nDist: 131",
        "SRC:WDFD",
        "ID:1301373",
        "CALL:AMB",
        "DATE:5/3/2013",
        "TIME:01:18:00",
        "ADDR:1543 N SEMINARY AV",
        "MADDR:1543 N SEMINARY AVE",
        "APT:H",
        "CITY:WOODSTOCK");

    doTest("T72",
        "(WDFD Dispatch) #\nOCA : 1301372\nType: AMB\nDate: 5/2/2013 16:04:27\nLoca: 1155 WALDEN OAKS DR\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301372",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:16:04:27",
        "ADDR:1155 WALDEN OAKS DR",
        "CITY:WOODSTOCK");

    doTest("T73",
        "(WDFD Dispatch) #\nOCA : 1301371\nType: CO NOSYMPTOM\nDate: 5/2/2013 13:42:01\nLoca: 1018 GREENWOOD CI\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "ID:1301371",
        "CALL:CO NOSYMPTOM",
        "DATE:5/2/2013",
        "TIME:13:42:01",
        "ADDR:1018 GREENWOOD CI",
        "MADDR:1018 GREENWOOD CIR",
        "CITY:WOODSTOCK");

    doTest("T74",
        "(WDFD Dispatch) #\nOCA : 1301370\nType: AMB\nDate: 5/2/2013 13:42:01\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216",
        "SRC:WDFD",
        "ID:1301370",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:13:42:01",
        "ADDR:1275 LAKE AV",
        "MADDR:1275 LAKE AVE",
        "CITY:WOODSTOCK",
        "X:WILTSHIRE LN",
        "INFO:Dist: 216");

    doTest("T75",
        "(WDFD Dispatch) #\nOCA : 1301369\nType: FIREBRUSH\nDate: 5/2/2013 13:06:40\nLoca: 1818 S ROSEFARM RD\nCity: WOODSTOCK",
        "SRC:WDFD",
        "ID:1301369",
        "CALL:FIREBRUSH",
        "DATE:5/2/2013",
        "TIME:13:06:40",
        "ADDR:1818 S ROSEFARM RD",
        "CITY:WOODSTOCK");

    doTest("T76",
        "(WDFD Dispatch) #\nOCA : 1301368\nType: AMB\nDate: 5/2/2013 06:32:12\nLoca: 430 TANAGER DR\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "ID:1301368",
        "CALL:AMB",
        "DATE:5/2/2013",
        "TIME:06:32:12",
        "ADDR:430 TANAGER DR",
        "CITY:WOODSTOCK");

    doTest("T77",
        "(WDFD Dispatch) #\nOCA : 1301367\nType: SMOKE\nDate: 5/2/2013 04:53:47\nLoca: 2035 ASPEN DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301367",
        "CALL:SMOKE",
        "DATE:5/2/2013",
        "TIME:04:53:47",
        "ADDR:2035 ASPEN DR",
        "CITY:WOODSTOCK");

    doTest("T78",
        "(WDFD Dispatch) #\nOCA : 1301366\nType: ALARMF\nDate: 5/2/2013 00:49:36\nLoca: 2406 HARTLAND RD\nCity: WOODSTOCK\nDist: 314",
        "SRC:WDFD",
        "ID:1301366",
        "CALL:ALARMF",
        "DATE:5/2/2013",
        "TIME:00:49:36",
        "ADDR:2406 HARTLAND RD",
        "CITY:WOODSTOCK");

    doTest("T79",
        "(WDFD Dispatch) #\nOCA : 1301365\nType: AMB\nDate: 5/1/2013 22:19:49\nLoca: 831 CLAY ST\nCity: WOODSTOCK\nDist: 133",
        "SRC:WDFD",
        "ID:1301365",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:22:19:49",
        "ADDR:831 CLAY ST",
        "CITY:WOODSTOCK");

    doTest("T80",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301364\n" +
        "Type: ACCI\n" +
        "Date: 5/1/2013 20:44:56\n" +
        "Loca: RTE 14 1/4 EAST OF DEAN ST\n" +
        "City: WOODSTOCK\n" +
        "Cros: N CAROLINE ",

        "SRC:WDFD",
        "ID:1301364",
        "CALL:ACCI",
        "DATE:5/1/2013",
        "TIME:20:44:56",
        "ADDR:RTE 14 1 & 4 EAST OF DEAN ST",
        "MADDR:RTE 14 1 & 4 & DEAN ST",
        "CITY:WOODSTOCK",
        "X:N CAROLINE");

    doTest("T81",
        "(WDFD Dispatch) #\nOCA : 1301363\nType: AMB\nDate: 5/1/2013 21:24:03\nLoca: 720 ST JOHN`S RD\nApt : 109\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "ID:1301363",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:21:24:03",
        "ADDR:720 ST JOHN`S RD",
        "APT:109",
        "CITY:WOODSTOCK");

    doTest("T82",
        "(WDFD Dispatch) #\nOCA : 1301362\nType: ACCI\nDate: 5/1/2013 20:42:18\nLoca: 400 S EASTWOOD DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301362",
        "CALL:ACCI",
        "DATE:5/1/2013",
        "TIME:20:42:18",
        "ADDR:400 S EASTWOOD DR",
        "CITY:WOODSTOCK");

    doTest("T83",
        "(WDFD Dispatch) #\nOCA : 1301361\nType: AMB\nDate: 5/1/2013 18:58:25\nLoca: 1275 LAKE AV\nCity: WOODSTOCK\nCros: WILTSHIRE LN\nDist: 216",
        "SRC:WDFD",
        "ID:1301361",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:18:58:25",
        "ADDR:1275 LAKE AV",
        "MADDR:1275 LAKE AVE",
        "CITY:WOODSTOCK",
        "X:WILTSHIRE LN",
        "INFO:Dist: 216");

    doTest("T84",
        "(WDFD Dispatch) #\nOCA : 1301360\nType: AMB\nDate: 5/1/2013 18:44:37\nLoca: 1400 COMMONS DR\nApt : 1D\nCity: WOODSTOCK\nDist: 216",
        "SRC:WDFD",
        "ID:1301360",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:18:44:37",
        "ADDR:1400 COMMONS DR",
        "APT:1D",
        "CITY:WOODSTOCK");

    doTest("T85",
        "(WDFD Dispatch) #\nOCA : 1301359\nType: AMB\nDate: 5/1/2013 16:55:32\nLoca: 527 W SOUTH ST\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301359",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:16:55:32",
        "ADDR:527 W SOUTH ST",
        "CITY:WOODSTOCK");

    doTest("T86",
        "(WDFD Dispatch) #\nOCA : 1301358\nType: AMB\nDate: 5/1/2013 13:30:07\nLoca: 3306 ELAINE DR\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301358",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:13:30:07",
        "ADDR:3306 ELAINE DR",
        "CITY:WOODSTOCK");

    doTest("T87",
        "(WDFD Dispatch) #\nOCA : 1301357\nType: SMOKE\nDate: 5/1/2013 16:15:44\nLoca: 1115 DONEGAL CT\nCity: WOODSTOCK\nDist: 215",
        "SRC:WDFD",
        "ID:1301357",
        "CALL:SMOKE",
        "DATE:5/1/2013",
        "TIME:16:15:44",
        "ADDR:1115 DONEGAL CT",
        "CITY:WOODSTOCK");

    doTest("T88",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301356\n" +
        "Type: AOA\n" +
        "Date: 5/1/2013 15:35:15\n" +
        "Loca: 3217 CARRINGTON DR\n" +
        "City: CRYSTAL LAKE\n" +
        "Cros: REMINGTON DR\n" +
        "Dist: 13",

        "SRC:WDFD",
        "ID:1301356",
        "CALL:AOA",
        "DATE:5/1/2013",
        "TIME:15:35:15",
        "ADDR:3217 CARRINGTON DR",
        "CITY:CRYSTAL LAKE",
        "X:REMINGTON DR",
        "INFO:Dist: 13");

    doTest("T89",
        "(WDFD Dispatch) #\nOCA : 1301355\nType: LOCKOUT\nDate: 5/1/2013 13:35:37\nLoca: 644 MARGARET ST\nCity: WOODSTOCK\nDist: 124",
        "SRC:WDFD",
        "ID:1301355",
        "CALL:LOCKOUT",
        "DATE:5/1/2013",
        "TIME:13:35:37",
        "ADDR:644 MARGARET ST",
        "CITY:WOODSTOCK");

    doTest("T90",
        "(WDFD Dispatch) #\nOCA : 1301354\nType: AMB\nDate: 5/1/2013 11:48:16\nLoca: 8205 BRECKENRIDGE C T\nCity: BULL VALLEY",
        "SRC:WDFD",
        "ID:1301354",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:11:48:16",
        "ADDR:8205 BRECKENRIDGE C T",
        "CITY:BULL VALLEY");

    doTest("T91",
        "(WDFD Dispatch) #\nOCA : 1301353\nType: AMB\nDate: 5/1/2013 09:48:29\nLoca: FLEMING RD // BULL VALLEY RD\nCity: BULL VALLEY\nDist: 131",
        "SRC:WDFD",
        "ID:1301353",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:09:48:29",
        "ADDR:FLEMING RD & BULL VALLEY RD",
        "CITY:BULL VALLEY");

    doTest("T92",
        "(WDFD Dispatch) #\nOCA : 1301352\nType: AMB\nDate: 5/1/2013 04:43:00\nLoca: 1512 GOLDEN OAK DR\nCity: WOODSTOCK\nDist: 127",
        "SRC:WDFD",
        "ID:1301352",
        "CALL:AMB",
        "DATE:5/1/2013",
        "TIME:04:43:00",
        "ADDR:1512 GOLDEN OAK DR",
        "CITY:WOODSTOCK");

    doTest("T93",
        "(WDFD Dispatch) #\nOCA : 1301351\nType: AMB\nDate: 4/30/2013 20:28:36\nLoca: 616 ST JOHN`S RD\nCity: WOODSTOCK\nDist: 312",
        "SRC:WDFD",
        "ID:1301351",
        "CALL:AMB",
        "DATE:4/30/2013",
        "TIME:20:28:36",
        "ADDR:616 ST JOHN`S RD",
        "CITY:WOODSTOCK");

    doTest("T94",
        "(WDFD Dispatch) #\nOCA : 1301350\nType: AMB\nDate: 4/30/2013 16:35:14\nLoca: 309 MCHENRY AV\nCity: WOODSTOCK\nDist: 132",
        "SRC:WDFD",
        "ID:1301350",
        "CALL:AMB",
        "DATE:4/30/2013",
        "TIME:16:35:14",
        "ADDR:309 MCHENRY AV",
        "MADDR:309 MCHENRY AVE",
        "CITY:WOODSTOCK");

    doTest("T95",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301348\n" +
        "Type: AMB\n" +
        "Date: 4/30/2013 13:30:54\n" +
        "Loca: 2626 COBBLESTONE DR\n" +
        "Apt : 36\n" +
        "City: PRAIRIE GROVE\n" +
        "Dist: 13",

        "SRC:WDFD",
        "ID:1301348",
        "CALL:AMB",
        "DATE:4/30/2013",
        "TIME:13:30:54",
        "ADDR:2626 COBBLESTONE DR",
        "APT:36",
        "CITY:PRAIRIE GROVE");

    doTest("T96",
        "(WDFD Dispatch) #\n" +
        "OCA : 1301347\n" +
        "Type: AOA\n" +
        "Date: 4/30/2013 13:26:37\n" +
        "Loca: 100 W WOODSTOCK ST\n" +
        "City: CRYSTAL LAKE\n" +
        "Cros: N CAROLINE \n" +
        "Dist: 14",

        "SRC:WDFD",
        "ID:1301347",
        "CALL:AOA",
        "DATE:4/30/2013",
        "TIME:13:26:37",
        "ADDR:100 W WOODSTOCK ST",
        "CITY:CRYSTAL LAKE",
        "X:N CAROLINE",
        "INFO:Dist: 14");

  }
  
  public static void main(String[] args) {
    new ILMcHenryCountyParserTest().generateTests("T1");
  }
}