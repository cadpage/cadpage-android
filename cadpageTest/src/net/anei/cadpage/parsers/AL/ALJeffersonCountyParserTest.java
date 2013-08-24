package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Jefferson County, AL
Contact: Active911
Agency name: Rocky Ridge Fire District
Location: Birmingham, Al, United States
Sender:  firedesk@northstar-firedesk.com

RUN # 13-1423\n\nADDRESS -4660 CALDWELL MILL RD\n\nNATURE -FIRE ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -1011\n\nDISPATCHED -1011\n\nEN-ROUTE -1011\n\nON-SCENE -1012\nIN-SERVICE -1033
RUN # 13-1422\n\nNATURE:PUBLIC ASSIST\n\nADDRESS:ACTON RD & CAMP HORNER\n\n\nENGINE:38\n\nTIME OF CALL:0945\n\nDISPATCHED:0945\n\nEN-ROUTE:0945\n\nON-SCENE:0949\nIN-SERVICE:0957
RUN # 13-1421\n\nNATURE: MVA\n\nADDRESS: 459 S BEFORE ACTON RD\n\n\n\nRESCUE:37\n\nTIME OF CALL:0750\n\nDISPATCHED:0750\n\nEN-ROUTE:0750\n\nON-SCENE:0754\n\nAT PATIENT:0755\n\nTRANSPORTING TO:ST VIN E\n\nTRANSPORT TIME:0804\n\nBEGINNING MILEAGE:41946.6\n\nAT DESTINATION:0832\n\nENDING MILEAGE WAS:41968.5\n\nIN-SERVICE:0903\n\n\nRESCUE: 36\n\nTIME OF CALL:0750\n\nDISPATCHED:0751\n\nEN-ROUTE:0751\n\nON-SCENE: 0800\n\nAT PATIENT: 0801\n\nTRANSPORTING TO: BROOKWOOD\n\nTRANSPORT TIME:0810\n\nBEGINNING MILEAGE: 68434.6\n\nAT DESTINATION: 0820\n\nENDING MILEAGE WAS:68441.3\n\nIN-SERVICE:0902\n\n\nENGINE:39\n\nTIME OF CALL:0750\n\nDISPATCHED:0750\n\nEN-ROUTE:0750\n\nON-SCENE:0754\nIN-SERVICE:0824
I-459 S BEFORE I-65...OVERTURNED VEHICLE
RUN # 13-1420\n\nNATURE: SEIZURE\n\nADDRESS:2337 ALTADENA CREST DR\n\n\n\nRESCUE:37\n\nTIME OF CALL:0336\n\nDISPATCHED:0337\n\nEN-ROUTE:0338\n\nON-SCENE: N/A\nIN-SERVICE: 0343\n\n\nENGINE:39\n\nTIME OF CALL:0336\n\nDISPATCHED:0337\n\nEN-ROUTE:0338\n\nON-SCENE:N/A\nIN-SERVICE:0343
(8-13-2013) CORRECTION ADDRESS 2337 ALTADENA CREST DR SEIZURE
(8-13-2013) 2337 ALTADENA RD 29 YOF SEIZURES
RUN # 13-1419\n\nNATURE:INVESTIGATE\n\nADDRESS:3700 COLONNADE PKWY\n\n\n\nENGINE: 38\n\nTIME OF CALL:2220\n\nDISPATCHED:2221\n\nEN-ROUTE:2221\n\nON-SCENE:2225\n\nIN-SERVICE:2230
(8-12-2013) 3700 COLONADE PKWY INVESTIGATE FIRE ALARM WITH BFD
RUN # 13-1418\n\nNATURE:PUBLIC ASSIST\n\nADDRESS:3517 LORNA RD.\n\n\n\nENGINE 39\n\nTIME OF CALL:1302\n\nDISPATCHED:1302\n\nEN-ROUTE:1302\n\nON-SCENE:1302\n\nIN-SERVICE:1408
3517 LORNA ROAD  PUBLIC EVENT
RUN # 13-1417\n\nNATURE:MVA\n\nADDRESS:BLUE LAKE DR AND COLONNADE PKWY\n\n\n\nRESCUE 36\n\nTIME OF CALL:0859\n\nDISPATCHED:0859\n\nEN-ROUTE:0859\n\nON-SCENE:0901\n\nIN-SERVICE:0903
BLUE LAKE DR AND COLONNADE PARKWAY  MVA
RUN # 13-1416\n\nNATURE: BREATHING PROBS\n\nADDRESS:7415 COLONY PARK DR\n\n\n\nRESCUE: 37\n\nTIME OF CALL:0345\n\nDISPATCHED:0346\n\nEN-ROUTE:0346\n\nON-SCENE:0355\n\nAT PATIENT:0355\n\nTRANSPORTING TO:CHILDRENS\n\nTRANSPORT TIME:0408\n\nBEGINNING MILEAGE:41922.6\n\nAT DESTINATION:0424\n\nENDING MILEAGE WAS:41931.9\n\nIN-SERVICE:0440\n\n\nENGINE:38\n\nTIME OF CALL:0345\n\nDISPATCHED:0346\n\nEN-ROUTE:0347\n\nON-SCENE:0352\n\nIN-SERVICE:0409
(8-12-2013) 7415 COLONY PARK DR BREATHING PROBLEMS  10 MO
RUN # 13-1415\n\nNATURE:CHOKING\n\nADDRESS:2837 FIVE OAKS LN\n\n\n\nRESCUE:37\n\nTIME OF CALL:1958\n\nDISPATCHED:1959\n\nEN-ROUTE:1959\n\nON-SCENE:2011\n\nAT PATIENT:2011\n\nTRANSPORTING TO: CHILDRENS\n\nTRANSPORT TIME:2032\n\nBEGINNING MILEAGE:41897.2\n\nAT DESTINATION:2048\n\nENDING MILEAGE WAS:41906.4\n\nIN-SERVICE:2107\n\n\nENGINE: 38\n\nTIME OF CALL:1958\n\nDISPATCHED:1959\n\nEN-ROUTE:1959\n\nON-SCENE:2004\n\nIN-SERVICE:2033
(8-11-2013) 2837 FIVE OAKS LN 8 MO MALE CHOKING
(Re:) DISREGARD\n\nOn Sun, Aug 11, 2013 at 1:28 PM, Fire Desk\n<firedesk@northstar-firedesk.com>wrote:\n\n>\n> RUN # 13- 1021\n>\n> ADDRESS - 1407 HAVEN DR\n>\n> NATURE - STROKE\n>\n>\n>\n> RESCUE - 4\n>\n> TIME OF CALL - 1211\n>\n> DISPATCHED - 1212\n>\n> IN-ROUTE - 1212\n>\n> ON SCENE - 1215\n>\n> TRANSPORTING TO - BROOKWOOD DIV TO UAB\n>\n> IN-ROUTE - 1234\n>\n> BEGINNING MILEAGE - 3709.3\n>\n> AT DESTINATION - 1246\n>\n> ENDING MILEAGE -3718.3\n>\n> IN SERVICE - 1328\n>
RUN # 13-1415\n\nADDRESS -4300 COLONNADE PKWY\n\nNATURE -NAUSEA / VOMITING\n\n\n\nRESCUE -36\n\nTIME OF CALL -1236\n\nDISPATCHED -1236\n\nEN-ROUTE -1236\n\nON-SCENE -1240\n\nIN-SERVICE �1309
RUN # 13- 1021\n\nADDRESS - 1407 HAVEN DR\n\nNATURE - STROKE\n\n\n\nRESCUE - 4\n\nTIME OF CALL - 1211\n\nDISPATCHED - 1212\n\nIN-ROUTE - 1212\n\nON SCENE - 1215\n\nTRANSPORTING TO - BROOKWOOD DIV TO UAB\n\nIN-ROUTE - 1234\n\nBEGINNING MILEAGE - 3709.3\n\nAT DESTINATION - 1246\n\nENDING MILEAGE -3718.3\n\nIN SERVICE - 1328
4300 COLONNADE PKWY... RM 329, NAUSEA/VOMITING
RUN # 13-1414\n\nADDRESS -2408 FALCON PL\n\nNATURE -ALLERGIC REACTION\n\n\n\nRESCUE -37\n\nTIME OF CALL -1742\n\nDISPATCHED -1742\n\nEN-ROUTE -1742\n\nON-SCENE -1745\n\nIN-SERVICE �1802\n\n\n\nENGINE -39\n\nTIME OF CALL -1742\n\nDISPATCHED -1742\n\nEN-ROUTE -1742\n\nON SCENE �1745\n\nIN-SERVICE -1802
2408 FALCON PLACE  WINDOVER CONDOMINIUMS ALLERGIC REACTION
RUN # 13-1413\n\nADDRESS -I 459 S BEFORE ACTON RD\n\nNATURE -MVA\n\n\n\nRESCUE -36\n\nTIME OF CALL -1421\n\nDISPATCHED -1421\n\nEN-ROUTE -1421\n\nON-SCENE -1429\n\nIN-SERVICE �1437\n\n\n\nENGINE -39\n\nTIME OF CALL -1421\n\nDISPATCHED -1421\n\nEN-ROUTE -1421\n\nON SCENE �1429\n\nIN-SERVICE -1503
RUN # 13-1412\n\nADDRESS -3449 BLUEBERRY LN\n\nNATURE -PUBLIC ASSIST\n\n\n\nRESCUE -37\n\nTIME OF CALL -1359\n\nDISPATCHED -1359\n\nEN-ROUTE -1359\n\nON-SCENE -1400\n\nAT PATIENT -1400\n\nTRANSPORTING TO -BROOKSIDE\n\nEN-ROUTE -1411\n\nBEGINNING MILEAGE WAS -41865\n\nAT DESTINATION -1424\n\nENDING MILEAGE WAS -41871.5\n\nIN-SERVICE �1453\n\n\n\nENGINE -39\n\nTIME OF CALL -1358\n\nDISPATCHED -1358\n\nEN-ROUTE -1358\n\nON SCENE �1400\n\nIN-SERVICE -1412
RUN # 13-1015\n\nADDRESS -2935 EARLYTOWN RD.  LOT 99\n\nNATURE -SYNCOPE\n\n\n\nRESCUE -4\n\nTIME OF CALL -1350\n\nDISPATCHED -1350\n\nEN-ROUTE -1350\n\nON-SCENE -1356\n\nAT PATIENT -1356\n\nTRANSPORTING TO -PRINCETON\n\nEN-ROUTE -1409\n\nBEGINNING MILEAGE WAS -5117\n\nAT DESTINATION -1428\n\nENDING MILEAGE WAS -5126\n\nIN-SERVICE �1450
I459 SB BEFORE ACTON ROAD MVA
(CORRECTED ADDRESS) 3449 BLUEBERRY LANE CORRECTED ADDRESS
(Re: ) Corrected address blueberry lane\n\nT.J. Sizemore, Captain\nRocky Ridge Fire District\n2911 Metropolitan Way<x-apple-data-detectors://0/0>\nBirmingham, Al. 35243<x-apple-data-detectors://0/0>\n205-822-0532<tel:205-822-0532> Office\n205-978-9876<tel:205-978-9876> Fax\nTommy.Sizemore@Rockyridgefire.com<mailto:Tommy.Sizemore@Rockyridgefire.com>\n\n“Courage is being scared to death – but saddling up anyway.” - J.W.\n\n\nOn Aug 10, 2013, at 1:57 PM, "Fire Desk" <firedesk@northstar-firedesk.com<mailto:firedesk@northstar-firedesk.com>> wrote:\n\n3449 BLUE BELL CHECK A PERSON
3449 BLUE BELL CHECK A PERSON
(13-1411) RUN # 13-1411\n\nADDRESS -2801 RIVERVIEW ROAD APT 5313\n\nNATURE -INVESTIGATE\n\n\n\nENGINE 38\n\nTIME OF CALL -1155\n\nDISPATCHED -1155\n\nENROUTE -1155\n\nON SCENE -1200\n\nIN SERVICE -1205
2801 RIVERVIEW RD. APT 5313   INVESTIGATE WIRING
RUN # 13-1410\n\nADDRESS -4600 HWY 280\n\nNATURE -FALL\n\n\n\nRESCUE-36\n\nTIME OF CALL -1056\n\nDISPATCHED -1056\n\nEN-ROUTE -1056\n\nON-SCENE -1059\nIN-SERVICE -1111
4600 HIGHWAY 280 AT MED HEALTH 71 Y O FEMALE FALL
RUN # 13-1409\n\nADDRESS -3517 LORNA RD  APT 128\n\nNATURE -LIFT ASSIST\n\n\n\nENGINE -39\n\nTIME OF CALL -0227\n\nDISPATCHED -0228\n\nEN-ROUTE -0229\n\nON-SCENE -0235\nIN-SERVICE -0239
(8-10-2013) 
RUN # 13-1408\n\nADDRESS -4612 HWY 280\n\nNATURE -CHEST PAIN\n\n\n\nRESCUE -36\n\nTIME OF CALL -2034\n\nDISPATCHED -2036\n\nEN-ROUTE -2036\n\nON-SCENE -2041\nIN-SERVICE -2042
RUN # 13-1407\n\nADDRESS -3517 LORNA RD\n\nNATURE -LIFT ASSIST\n\n\n\nENGINE -39\n\nTIME OF CALL -2024\n\nDISPATCHED -2025\n\nEN-ROUTE -2026\n\nON-SCENE -2031\nIN-SERVICE -2038
(8-9-2013) 4612 HWY 280 CHEST PAIN BFD RESPONDING ALSO
(8-9-2013) 3517 LORNA RD ROOM 221 LIFT ASSIST
(RUN #13-1406) RUN # 13-1406\n\nADDRESS -4188 RIVER OAKS DR\n\nNATURE -MEDICAL ALARM - CHEST PAINS\n\n\n\nRESCUE -37\n\nTIME OF CALL -1834\n\nDISPATCHED -1835\n\nEN-ROUTE -1836\n\nON-SCENE -1841\n\nAT PATIENT -1841\n\nTRANSPORTING TO -TRINITY\n\nEN-ROUTE -1915\n\nBEGINNING MILEAGE WAS -41831.3\n\nAT DESTINATION -1936\n\nENDING MILEAGE WAS -41843.8\n\nIN-SERVICE �2011\n\n\n\nENGINE -39\n\nTIME OF CALL -1834\n\nDISPATCHED -1835\n\nEN-ROUTE -1836\n\nON SCENE �1841\nIN-SERVICE - 1915
(8-19-2013) CORRECTION ON ADDRESS 4188 RIVER OAKS DR
(8-9-2013) 4100 RIVER OAKS DR CHEST PAIN
(RUN #13-1405) RUN # 13-1405\n\nADDRESS -RR ST 39\n\nNATURE -STILL ALARM\n\n\nENGINE -39\n\nTIME OF CALL -1811\n\nDISPATCHED -1811\n\nEN-ROUTE -1811\n\nON SCENE �1811\nIN-SERVICE -1830
(8-9-2013) STILL ALARM AT STATION 39
13-1404\n4870 CAHABA RIVER RD\nSTILL ALARM
AT RR ST 38.....STILL ALARM - CHEST PAINS
13-1403\n2432 RIDGEMONT DR\nVOMITING\n\nENGINE 39\n\n\n\n\n\n\nRESCUE 37
2432 RIDGEMONT DR.....36 YOM ABD PAIN
RUN # 13-1402\n\nADDRESS -3427 COLONNADE PKWY\n\nNATURE -FIRE ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -0458\n\nDISPATCHED -0459\n\nEN-ROUTE -0500\n\nON-SCENE -0504\nIN-SERVICE -0507
(8-9-2013) 3427 colonnade pkwy fire alarm with bfd
RUN # 13-1401\n\nADDRESS -2123 EMERALD POINTE DR  APT 2\n\nNATURE -BREATHING PROBLEMS\n\n\n\nRESCUE -37\n\nTIME OF CALL -0136\n\nDISPATCHED -0138\n\nEN-ROUTE -0139\n\nON-SCENE -0144\n\nAT PATIENT -0144\n\nTRANSPORTING TO -BROOKWOOD\n\nEN-ROUTE -0204\n\nBEGINNING MILEAGE WAS -41779.8\n\nAT DESTINATION -0214\n\nENDING MILEAGE WAS -41785.9\n\nIN-SERVICE �0241\n\n\n\nENGINE -39\n\nTIME OF CALL -0136\n\nDISPATCHED -0138\n\nEN-ROUTE -0139\n\nON SCENE �0144\nIN-SERVICE -0205
(8-9-2013) 2123 EMERALD POINTE  DR  APT 2  50 YOM BREATHING PROBLEMS
RUN # 13-1400\n\nADDRESS -315 SPRINGS AVE\n\nNATURE -INVESTIGATE\n\n\n\nENGINE -38\n\nTIME OF CALL -2115\n\nDISPATCHED -2115\n\nEN-ROUTE -2115\n\nON-SCENE -2118\nIN-SERVICE -2141
315 SPRINGS AVE...INVESTIGATE WATER FLOW...BFD ENROUTE
RUN # 13-1399\n\nADDRESS -ST 38\n\nNATURE -STILL ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -1650\n\nDISPATCHED -1650\n\nEN-ROUTE -1650\n\nON-SCENE -1650\nIN-SERVICE -1711
RUN # 13-1398\n\nADDRESS -3196 HWY 280\n\nNATURE -UNK PROB\n\n\n\nRESCUE -36\n\nTIME OF CALL -1238\n\nDISPATCHED -1238\n\nEN-ROUTE -1238\n\nON-SCENE -1240\nIN-SERVICE -1246
3196 HWY 280...UNKNOWN MEDICAL
RUN # 13-1397\n\nADDRESS -4500 OVERTON RD\n\nNATURE -FALL\n\n\n\nRESCUE -36\n\nTIME OF CALL -1115\n\nDISPATCHED -1115\n\nEN-ROUTE -1115\n\nON-SCENE -1123\nIN-SERVICE -1125
4500 OVERTON RD...FALL
RUN # 13-1396\n\nNATURE - GENERAL ILLNESS\n\nADDRESS - 3517 LORNA RD\n\n\n\nENGINE - 39\n\nTIME OF CALL - 08:30\n\nDISPATCHED - 08:31\n\nENROUTE - 08:32\n\nON SCENE - 08:37\nIN SERVICE - 08:53\n\nRESCUE - 37\n\nTIME OF CALL - 08:30\n\nDISPATCHED - 08:31\n\nENROUTE - 08:32\n\nON SCENE - 08:37\n\nAT PATIENT - 08:37\n\nTRANSPORTING TO - TRINITY ER\n\nENROUTE - 08:51\n\nBEGINNING MILEAGE - 41751.0\n\nAT DESTINATION -  09:11\n\nENDING MILEAGE - 41762.0\nIN SERVICE - 09:50
3517 LORNA RD... RM 238... EDEMA TO LEGS
RUN # 13-1395\n\nADDRESS -STATION 38\n\nNATURE -STILL ALARM\n\n\n\nRESCUE -36\n\nTIME OF CALL -2350\n\nDISPATCHED -2350\n\nEN-ROUTE -2350\n\nON-SCENE -2350\n\nAT PATIENT -2350\n\nTRANSPORTING TO -ST VINCENTS\n\nEN-ROUTE -2357\n\nBEGINNING MILEAGE WAS -68360.9\n\nAT DESTINATION -0012\n\nENDING MILEAGE WAS -68368.9\n\nIN-SERVICE �0042
STATION 38...STILL ALARM
RUN # 13-1394\n\nADDRESS -233 SUMMIT BLVD\n\nNATURE -PUB ASSIST\n\n\n\nRESCUE -36\n\nTIME OF CALL -1917\n\nDISPATCHED -1918\n\nEN-ROUTE -1918\n\nON-SCENE -1921\n\nAT PATIENT -1921\n\nIN-SERVICE �1931
\n\nRUN # 13-1393\n\nADDRESS -1740 SAVANNAH PARK\n\nNATURE -PUB ASSIST\n\n\n\nRESCUE -37\n\nTIME OF CALL -1827\n\nDISPATCHED -1829\n\nEN-ROUTE -1829\n\nON-SCENE -1831\n\nAT PATIENT -1831\n\nTRANSPORTING TO -BROOKWOOD\n\nEN-ROUTE -1848\n\nBEGINNING MILEAGE WAS -41729.6\n\nAT DESTINATION -1902\n\nENDING MILEAGE WAS -41738.2\n\nIN-SERVICE �1927\n\n\n\nENGINE -39\n\nTIME OF CALL -1827\n\nDISPATCHED -1829\n\nEN-ROUTE -1829\n\nON SCENE �1831\n\nIN-SERVICE -1850
233 SUMMIT BLVD PF CHANG'S                        2 CHILDREN LOCKED IN\nVEHICLE
RUN # 13-1393\n\nADDRESS -1740 SAVANNAH PARK\n\nNATURE -PUB ASSIST\n\n\n\nRESCUE -37\n\nTIME OF CALL -1827\n\nDISPATCHED -1829\n\nEN-ROUTE -1829\n\nON-SCENE -1831\n\nAT PATIENT -1831\n\nTRANSPORTING TO -BROOKWOOD\n\nEN-ROUTE -1848\n\nBEGINNING MILEAGE WAS -41729.6\n\nAT DESTINATION -1902\n\nENDING MILEAGE WAS -41738.2\n\nIN-SERVICE �1918\n\n\n\nENGINE -39\n\nTIME OF CALL -1827\n\nDISPATCHED -1829\n\nEN-ROUTE -1829\n\nON SCENE �1831\n\nIN-SERVICE -1850
RUN # 13-1388\n\nADDRESS -2145 BONNER WAY\n\nNATURE -TRANSPORT\n\n\n\nRESCUE -35\n\nTIME OF CALL -1715\n\nDISPATCHED -1715\n\nEN-ROUTE -1715\n\nON-SCENE -1717\n\nAT PATIENT -1721\n\nTRANSPORTING TO -UAB\n\nEN-ROUTE -1728\n\nBEGINNING MILEAGE WAS -82524.3\n\nAT DESTINATION -1758\n\nENDING MILEAGE WAS -82536.8\n\nIN-SERVICE �1855
1740 SAVANNAH PARK...89YOM...SYNCOPE
RUN # 13-1392\n\nADDRESS -ROCKY RIDGE RD AND COUNTRY WOOD\n\nNATURE -TREE DOWN\n\n\n\nRESCUE -37\n\nTIME OF CALL -1805\n\nDISPATCHED -1805\n\nEN-ROUTE -1805\n\nON-SCENE -1815\n\nAT PATIENT -1815\nIN-SERVICE �1817
RUN # 13-1391\n\nADDRESS -OLD ROCKY RIDGE RD AT THE HOLIDAY HOUSE\n\nNATURE -TREE DOWN\n\n\n\nRESCUE -37\n\nTIME OF CALL -1757\n\nDISPATCHED -1757\n\nEN-ROUTE -1757\n\nON-SCENE -1759\n\nIN-SERVICE �1805\n\n\n\nENGINE -39\n\nTIME OF CALL -1757\n\nDISPATCHED -1757\n\nEN-ROUTE -1757\n\nON SCENE �1759\n\nIN-SERVICE -1816
ROCKY RIDGE RD AND COUNTRY WOOD                                   WIRES DOWN
OLD ROCKY RIDGE ROAD  JUST BEFORE LIBERTY CHURCH TREE DOWN
RUN # 13-1390\n\nADDRESS -EMERALD POINT APARTMENTS\n\nNATURE -INVESTIGATE FLOODING\n\n\n\nENGINE -39\n\nTIME OF CALL -1725\n\nDISPATCHED -1725\n\nEN-ROUTE -1725\n\nON SCENE �1733\n\nIN-SERVICE -1743
RUN # 13-1390\n\nADDRESS -EMERALD POINT APARTMENTS\n\nNATURE -INVESTIGATE FLOODING\n\n\n\nENGINE -39\n\nTIME OF CALL -1725\n\nDISPATCHED -1725\n\nEN-ROUTE -1725\n\nON SCENE �1733\n\nIN-SERVICE -1743
RUN # 13-1389\n\nADDRESS -3628 DABNEY DR\n\nNATURE -FIRE ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -1719\n\nDISPATCHED -1719\n\nEN-ROUTE -1719\n\nON SCENE �1727\n\nIN-SERVICE -1735
(13-1387) RUN # 13-1387\n\nADDRESS -3200 WESTBROOK DR.\n\nNATURE -INVESTIGATE\n\n\n\nRESCUE -37\n\nTIME OF CALL -1710\n\nDISPATCHED -1710\n\nEN-ROUTE -1710\n\nON-SCENE -1717\n\nIN-SERVICE �1725\n\n\n\nENGINE -39\n\nTIME OF CALL -1710\n\nDISPATCHED -1710\n\nEN-ROUTE -1710\n\nON SCENE �1717\n\nIN-SERVICE -1725
RUN # 13-1386\n\nADDRESS -HWY 280 AT COLONNADE DR\n\nNATURE -MVA\n\n\n\nRESCUE -36\n\nTIME OF CALL -1644\n\nDISPATCHED -1644\n\nEN-ROUTE -1644\n\nON-SCENE -1648\n\nIN-SERVICE �1708
3628 DABNEY DR.   FIRE ALARM
2145 BONNER WAY ( 3RD FLOOR)....TRANSPORT TO UAB ER
5200 WEST BROOK DRIVE HOUSE IS FLOODING
RUN # 13-1385\n\nADDRESS -2145 BONNER WAY\n\nNATURE -BREATHING PROBLEMS\n\n\n\nRESCUE -36\n\nTIME OF CALL -1426\n\nDISPATCHED -1426\n\nEN-ROUTE -1426\n\nON-SCENE -1433\n\nAT PATIENT -1433\n\nTRANSPORTING TO -UAB\n\nEN-ROUTE -1440\n\nBEGINNING MILEAGE WAS -68329.3\n\nAT DESTINATION -1455\n\nENDING MILEAGE WAS -68341.2\n\nIN-SERVICE �1545\n\n\n\nENGINE -39\n\nTIME OF CALL -1426\n\nDISPATCHED -1426\n\nEN-ROUTE -1426\n\nON SCENE �1429\n\nIN-SERVICE -1440
RUN # 13-1384\n\nADDRESS -804 OLD FOREST RD.\n\nNATURE -FRACTURE / DISLOCATION\n\n\n\nRESCUE -37\n\nTIME OF CALL -1351\n\nDISPATCHED -1351\n\nEN-ROUTE -1351\n\nON-SCENE -1355\n\nAT PATIENT -1356\n\nTRANSPORTING TO -BROOKWOOD\n\nEN-ROUTE -1423\n\nBEGINNING MILEAGE WAS -41706.1\n\nAT DESTINATION -1431\n\nENDING MILEAGE WAS -41710.2\n\nIN-SERVICE �1528\n\n\n\nENGINE -39\n\nTIME OF CALL -1350\n\nDISPATCHED -1350\n\nEN-ROUTE -1350\n\nON SCENE �1355\n\nIN-SERVICE -1426
2145 BONNER WAY  62 YO FEMALE DIFF BREATHING PT WILL BE ON THIRD FLOOR
804 OLD FOREST ROAD  ANKLE INJURY
RUN # 13-1383\n\nADDRESS -150 SUMMIT PL\n\nNATURE -FIRE ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -1513\n\nDISPATCHED -1513\n\nEN-ROUTE -1513\n\nON SCENE �1522\n\nIN-SERVICE -1525
150 SUMMIT PLACE FIRE ALARM
RUN # 13-1382\n\nADDRESS -I 459 N AT 65\n\nNATURE -PERSON DOWN\n\n\n\nRESCUE -37\n\nTIME OF CALL -1435\n\nDISPATCHED -1435\n\nEN-ROUTE -1435\n\nON-SCENE -N/A\n\nIN-SERVICE �1438\n\n\n\nENGINE -39\n\nTIME OF CALL -1435\n\nDISPATCHED -1435\n\nEN-ROUTE -1435\n\nON SCENE �1438\n\nIN-SERVICE -1438
459 NB AT 65 PERSON DOWN
RUN # 13-1381\n\nADDRESS -STATION 38\n\nNATURE -STILL ALARM\n\n\n\nENGINE -38\n\nTIME OF CALL -1337\n\nDISPATCHED -1337\n\nEN-ROUTE -1337\n\nON SCENE �1337\n\nIN-SERVICE -1344
STATION 38 STILL ALARM ASSIST OCCUPANT
RUN # 13-1380\n\nADDRESS -459 SB @ ACTON RD.\n\nNATURE -PUBLIC ASSIST\n\n\n\nENGINE -39\n\nTIME OF CALL -1238\n\nDISPATCHED -1238\n\nEN-ROUTE -1238\n\nON SCENE �1240\n\nIN-SERVICE -1242
459 SB ENTRANCE RAMP ASSIST OCCUPANT
(13-1379) RUN # 13-1379\n\nADDRESS -2145 BONNER WAY\n\nNATURE -TRANSPORT TO UAB W\n\n\n\nRESCUE -37\n\nTIME OF CALL -1131\n\nDISPATCHED -1131\n\nENROUTE -1131\n\nON SCENE -1131\n\nAT PATIENT -1134\n\nTRANSPORTING TO -UAB\n\nENROUTE -1141\n\nBEGINNING MILEAGE -41660.6\n\nAT DESTINATION -1156\n\nENDING MILEAGE -41672.4\n\nIN SERVICE -1228\n\n\n\nENGINE  39\n\nTIME OF CALL -1131\n\nDISPATCHED -1131\n\nENROUTE -1131\n\nON SCENE -1132\n\nIN SERVICE -1141
2145 BONNER WAY  3RD FLOOR TRANSPORT TO UAB ER
2145 BONNER WAY   GENERAL ILLNESS
RUN # 13-1378\n\nADDRESS -513 CAHABA PARK CIR\n\nNATURE -MEDICAL\n\n\n\nRESCUE -36\n\nTIME OF CALL -1130\n\nDISPATCHED -1130\n\nEN-ROUTE -1130\n\nON-SCENE -N/A\n\nIN-SERVICE �1132
(13+-1377) RUN # 13-1377\n\nNATURE FIRE ALARM\n\nADDRESS -2149  EMERALD POINT DRIVE\n\n\n\nENGINE -39\n\nTIME OF CALL -0905\n\nDISPATCHED - 0905\n\nENROUTE -0905\n\nON SCENE -0905\n\nIN SERVICE -0906

*/


public class ALJeffersonCountyParserTest extends BaseParserTest {
  
  public ALJeffersonCountyParserTest() {
    setParser(new DummyParser(), "JEFFERSON COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    
  }
  
  public static void main(String[] args) {
    new ALJeffersonCountyParserTest().generateTests("T1");
  }
  
}