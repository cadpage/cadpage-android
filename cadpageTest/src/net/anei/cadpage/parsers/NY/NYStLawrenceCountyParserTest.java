package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
St Lawrence County, NY
Contact: Active911
Agency name: Heuvelton Volunteer Fire Department
Location: Heuvelton, NY, United States
Sender: dispatch@stlawco.org

(911 DISPATCH) HEU CFR:2012:258\nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON
(911 DISPATCH) HEU FD:2012:149\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37
(911 DISPATCH) HEU CFR:2012:257\nDispatched\nEMS\n5771 CO RT 10
(911 DISPATCH) HEU CFR:2012:256\nDispatched\nEMS
(911 DISPATCH) HEU FD:2012:146\nDispatched\nFire\n736 FULTON RD , LISBON ( ROUTE 27 / DANDY RD)
(911 DISPATCH) HEU FD:2012:145\nDispatched\nFire\nPOLE IN FRONT OF HAMILTON GARDENS
(911 DISPATCH) \nDispatched\nEMS\n47 RENSELLEAR ST HEUVELTON
(911 DISPATCH) HEU FD:2012:143\nDispatched\nEMS\n1456 W LAKE RD #NYPH, DEPEYSTER
(911 DISPATCH) HEU CFR:2012:254\nDispatched\nEMS\n16 RENSELLAER STREET, HEUVELTON
(911 DISPATCH) HEU CFR:2012:253\nDispatched\nEMS\n7 JUSTINA #NY, HEUVELTON VILLAGE
(911 DISPATCH) HEU FD:2012:142\nDispatched\nEMS\n3561 COUNTY ROUTE 10, DEPEYSTER
(911 DISPATCH) HEU FD:2012:141\nDispatched\nFire\n900 BLOCK OF MAIN ST, MORRISTOWN

Contact: Active911
Agency name: Lisbon Fire and Rescue
Location: Lisbon, NY, United States
Sender: dispatch@stlawco.org

(911 DISPATCH) \nDispatched\nEMS\nSUNY POTSDAM, POTSDAM LEAMAN SOUTH
(911 DISPATCH) LIS RES:2012:290\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37
(911 DISPATCH) LIS FD:2012:153\nDispatched\nEMS\n4701 ST HWY 68
(911 DISPATCH) LIS FD:2012:152\nDispatched\nFire\nCHAPLE ROAD, LISBON
(911 DISPATCH) LIS RES:2012:288\nDispatched\nEMS\n5771 CO RT 10
(911 DISPATCH) LIS RES:2012:287\nDispatched\nResponse Type 29B01\nPRAY ROAD,  X TUCK ROAD
(911 DISPATCH) LIS RES:2012:286\nDispatched\nFire\nFULTON ROAD LISBON
(911 DISPATCH) LIS RES:2012:285\nDispatched\nEMS\n60 MURPHY RD #NY, LISBON
(911 DISPATCH) LIS RES:2012:284\nDispatched\nEMS\n21 JENNER RD, LISBON
(911 DISPATCH) LIS RES:2012:283\nDispatched\nEMS\n1183 ROUTE 28 #NY, LISBON-CR 28
(911 DISPATCH) LIS FD:2012:145\nDispatched\nFire\n211 ROSS RD, LISBON
(911 DISPATCH) LIS RES:2012:282\nDispatched\nEMS\n21 JENNER RD, LISBON
(911 DISPATCH) LIS RES:2012:281\nDispatched\nEMS\n10964 ROUTE 37 #NY, LISBON-SH 37
(911 DISPATCH) LIS RES:2012:280\nDispatched\nResponse Type 30B01\n3992 STATE HWY 68 - W SECTOR #NY, LISBON

Agency name: Potsdam Fire Department
Location: Potsdam, NY, United States
Contact: Active911
Sender: dispatch@stlawco.org

(911 DISPATCH) POT FD:2012:501\nDispatched\nFire
(911 DISPATCH) POT FD:2012:500\nDispatched\nFire\nWOOD STOCK VILLAGE
(911 DISPATCH) POT FD:2012:498\nDispatched\nFire\n30 MARKET ST, POTSDAM
(911 DISPATCH) POT FD:2012:497\nDispatched\nFire\n6994 US HWY 11 - N SECTOR #NY, POTSDAM
(911 DISPATCH) POT FD:2012:496\nDispatched\nFire\n109 MAPLE STREET POTSDAM
(911 DISPATCH) POT FD:2012:495\nDispatched\nFire\nWOODSTOCK, BUILDING 9
(911 DISPATCH) POT FD:2012:494\nDispatched\nFire\nWOOD STOCK BUILDING 6
(911 DISPATCH) POT FD:2012:493\nDispatched\nFire\nROSS BROOKS DORM, CLARKSON UNIVERSITY
(911 DISPATCH) POT FD:2012:492\nDispatched\nFire
(911 DISPATCH) POT FD:2012:491\nDispatched\nFire\n415 BACK HANNAWA RD, POTSDAM
(911 DISPATCH) POT FD:2012:490\nDispatched\nFire\n4 CANAL ST POTSDAM
(911 DISPATCH) POT FD:2012:489\nDispatched\nFire\n29 ELM ST POTSDAM TEST

Agency name: St. Lawrence County Emergency Services
Location: Canton, NY, United States
Contact: Active911
Sender: dispatch@stlawco.org

(911 DISPATCH) 911C:2012:0000008182\nDispatched\nEMS
(911 DISPATCH) 911C:2012:0000008180\nDispatched\n911 Center\nBRAY ROAD - W SECTOR #NY, NORWOOD
(911 DISPATCH) \nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON
(911 DISPATCH) 911C:2012:0000008054\nDispatched\nEMS\nDOAN RD, GOUVERNEUR
(911 DISPATCH) 911C:2012:0000008051\nDispatched\nEMS\nOFF RT 812 NEAR STEVENSON
(911 DISPATCH) 911C:2012:0000008048\nDispatched\nEMS\n66 CNTY RTE 31 (OUTER ELM ST) - NW SECTOR #NY, MADRID
(911 DISPATCH) 911C:2012:0000008047\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37
(911 DISPATCH) 911C:2012:0000008045\nDispatched\nEMS\n5771 CO RT 10
(911 DISPATCH) 911C:2012:0000008028\nDispatched\nEMS\nVACINITY 931 PICKLE STREET STOCKHOLM
(911 DISPATCH) 911C:2012:0000008023\nDispatched\nFire\n9 HASKELL STREET, MASSENA
(911 DISPATCH) 911C:2012:0000008001\nDispatched\nFire\n34 CORNELL DR, RUSHTON DORM
(911 DISPATCH) 911C:2012:0000007998\nDispatched\nEMS\n915, CR 12
(911 DISPATCH) 911C:2012:0000007997\nDispatched\nFire\n5-7 CLINTON ST, NORFOLK
(911 DISPATCH) 911C:2012:0000007970\nDispatched\nFire\n46 COOK STREET MASSENA
(911 DISPATCH) 911C:2012:0000007950\nDispatched\nFire\n736 FULTON ROAD LISBON
(911 DISPATCH) 911C:2012:0000007945\nDispatched\nEMS\n1456 W LAKE RD #NYPH, DEPEYSTER
(911 DISPATCH) 911C:2012:0000007915\nDispatched\nFire-Chimney\n7 GRANT ST, EDWARDS
(911 DISPATCH) 911C:2012:0000007889\nDispatched\nFire\n415 BACK HANNAWA RD, POTSDAM
(911 DISPATCH) 911C:2012:0000007887\nDispatched\nFire\n34 COLTON RD #NY, RUSSELL
(911 DISPATCH) 911C:2012:0000007881\nDispatched\nFire\n2207 ROUTE 3 #NY, FINE-SH 3
(911 DISPATCH) 911C:2012:0000007878\nDispatched\nFire\n2111 ROUTE 310 , MADRID
(911 DISPATCH) 911C:2012:0000007865\nDispatched\nFire\n1325 LITTLE BOW RD #NY, GOUVERNEUR
(911 DISPATCH) 911C:2012:0000007862\nDispatched\nEMS\n428 ELIZABETH #NY, OGDENSBURG CITY
(911 DISPATCH) 911C:2012:0000007788\nDispatched\nFire\n1057 CR44, WADDINGTON
(911 DISPATCH) 911C:2012:0000007785\nDispatched\nFire\n1215 CR 20
(911 DISPATCH) 911C:2012:0000007786\nDispatched\nFire\n49 BURKE DELOSH RD #NY, BRASHER
(911 DISPATCH) 911C:2012:0000007780\nDispatched\nFire-Grass\nBROUSE RD, 1/4 MI OFF RT 420
(911 DISPATCH) 911C:2012:0000007776\nDispatched\nFire\n11 HOPSON RD, BRASHER
(911 DISPATCH) 911C:2012:0000007730\nDispatched\nFire\n570 COUNTRY CLUB RD, GOUVERNEUR
(911 DISPATCH) 911C:2012:0000007723\nDispatched\nFire-Chimney\n9043, SH 58
(911 DISPATCH) 911C:2012:0000007721\nDispatched\nFire\n900 BLOCK OF MAIN ST, MORRISTOWN
(911 DISPATCH) 911C:2012:0000007714\nDispatched\nEMS\n636 ROUTE 310 #NY, CANTON-SH 310
(911 DISPATCH) 911C:2012:0000007712\nDispatched\nFire\n201 MARSH RD, NORFOLK
(911 DISPATCH) 911C:2012:0000007706\nDispatched\nFire\nEAST ORVIS ST  #NY, MASSENA VILLAGE
(911 DISPATCH) 911C:2012:0000007701\nDispatched\nEMS\n1 CHIMNEY POINT DR #NYBLDG 201, OGDENSBURG CITY

Contact: Active911
Agency name: Ogdensburg Rescue
Location: Ogdensburg, NY, United States
Sender: dispatch@stlawco.org

(911 DISPATCH) OGD RES:2012:2375\nDispatched\nEMS\nRT 37
(911 DISPATCH) OGD RES:2012:2374\nDispatched\nEMS\n3715 ROUTE 6 #NY, MORRISTOWN-CR 6
(911 DISPATCH) OGD RES:2012:2373\nDispatched\nEMS\n8103 ROUTE 68 #NY, OSWEGATCHIE-SH 68
(911 DISPATCH) OGD RES:2012:2372\nDispatched\nEMS\n2320 FORD STREET, OGDENSBURG
(911 DISPATCH) OGD RES:2012:2371\nDispatched\nEMS\n1302 FORD STREET APT 7, OGDENSBURG
(911 DISPATCH) OGD RES:2012:2370\nDispatched\nEMS\n1111 JAY #NYFLR 3 APT 309, OGDENBURG CITY-PARKVIEW RISE
(911 DISPATCH) OGD RES:2012:2369\nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON
(911 DISPATCH) OGD RES:2012:2368\nDispatched\nEMS\n318 BLEMONT COURTS  OGD
(911 DISPATCH) OGD RES:2012:2367\nDispatched\nEMS\n8103 ROUTE 68 #NY, OSWEGATCHIE-SH 68
(911 DISPATCH) OGD RES:2012:2366\nDispatched\nEMS\n817 FORD ST OGD CROSS PATTERSON/HAMILTON
(911 DISPATCH) OGD RES:2012:2365\nDispatched\nResponse Type 17A01\n712 CONGRESS #NY, OGDENSBURG CITY
(911 DISPATCH) OGD RES:2012:2364\nDispatched\nEMS\n817 FORD ST , OGDENSBURG ( PATTERSON ST / HAMILTON ST)
(911 DISPATCH) OGD RES:2012:2363\nDispatched\nResponse Type 26A01\n1076 WASHINGTON ST #NY, OGD
(911 DISPATCH) OGD RES:2012:2362\nDispatched\nEMS\n312 ALBANY AV #NY, OGDENSBURG CITY
(911 DISPATCH) OGD RES:2012:2361\nDispatched\nEMS\n302 OAK ST , OGDENSBURG ( MANSION AVE / ALBANY AVE)
(911 DISPATCH) OGD RES:2012:2360\nDispatched\nEMS\n813 MECHANIC #NY, OGDENSBURG CITY
(911 DISPATCH) OGD RES:2012:2359\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68
(911 DISPATCH) OGD RES:2012:2358\nDispatched\nEMS\n202 WASHINGTON ST, OGDENSBURG CENTENNIAL TERRACE APT 303
(911 DISPATCH) OGD RES:2012:2357\nDispatched\nEMS\n80 LAGRASSE #NYAPT 113, WADDINGTON VILLAGE-HAMILTON G
(911 DISPATCH) OGD RES:2012:2356\nDispatched\nEMS\n232 WASHINGTON ST APT 703
(911 DISPATCH) OGD RES:2012:2355\nDispatched\nEMS\n721 NEW YORK AVE
(911 DISPATCH) OGD RES:2012:2354\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68
(911 DISPATCH) OGD RES:2012:2353\nDispatched\nEMS\n202 WASHINGTON ST APT 303 CENTENNIAL TERRACE OGD
(911 DISPATCH) OGD RES:2012:2352\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68
(911 DISPATCH) OGD RES:2012:2351\nDispatched\nEMS\n817 FORD ST, OGDENSBURG
(911 DISPATCH) OGD RES:2012:2350\nDispatched\nEMS\n56 LISBON ST, HEUVELTON
(911 DISPATCH) OGD RES:2012:2349\nDispatched\nEMS\nSPRING ST, OGDENSBURG
(911 DISPATCH) OGD RES:2012:2348\nDispatched\nEMS\n3310 ROUTE 56 #NY,  SOUTH COLTON-SH 56
(911 DISPATCH) OGD RES:2012:2347\nDispatched\nEMS\n705 NEW YORK AV #NYAPT DN, OGDENSBURG CITY
(911 DISPATCH) OGD RES:2012:2346\nDispatched\nEMS\n950 LINDEN, 2ND FLOOR #NY, OGDENSBURG CITY

Contact: Active911
Agency name: Madrid Volunteer Fire Department
Location: Madrid, NY, United States

(911 DISPATCH) MAD FD:2012:86\nDispatched\r\nFire\nNY310/RUDDY ROAD MADRID
(911 DISPATCH) MAD FD:2012:85\nDispatched\r\nEMS\n1313  MOCKINGBIRD LANE

Contact: Active911
Agency name: Gouverneur Volunteer Fire Department
Location: Gouverneur, NY, United States

(911 DISPATCH) GOU FD:2013:21\nDispatched\nFire-Chimney\nRT 58 ON RIGHT PAST LIQOUR STORE
(911 DISPATCH) GOU FD:2013:24\nDispatched\nFire\nRT 58 NEAR GRAVEL RD
(911 DISPATCH) GOU FD:2013:32\nDispatched\nFire\nAUSTIN ST GOUVERNEUR VILLAGE
(911 DISPATCH) GOU FD:2013:31\nDispatched\nFire\n18 NORTH GORDON STREET GOUV
(911 DISPATCH) GOU FD:2013:30\nDispatched\nFire\nCALIFRONIA RD, T/MACOMB
(911 DISPATCH) GOU FD:2013:29\nDispatched\nFire\n2244 CALIFORNIA RD #NY, MACOMB
(911 DISPATCH) GOU FD:2013:28\nDispatched\nFire\n12 WASHINGTON #NY, GOUVERNEUR VILLAGE
(911 DISPATCH) GOU FD:2013:27\nDispatched\nFire\n30 COUNTRY CLUB
(911 DISPATCH) GOU FD:2013:25\nDispatched\nFire\n91 EAST MAIN ST.,  GOUVERNEUR
(911 DISPATCH) GOU FD:2013:23\nDispatched\nFire\n5230 RT 58  GOUVERNEUR TOWARDS MACOMB
(911 DISPATCH) GOU FD:2013:22\nDispatched\nFire\n42780 NEW CONNECTICUT RD, ANTWERP
(911 DISPATCH) GOU FD:2013:20\nDispatched\nEMS\nSEAMAN RD
(911 DISPATCH) GOU FD:2013:19\nDispatched\nFire\nRT 11 SOUTH OF GOUV 1 MILE OUT
(911 DISPATCH) GOU FD:2013:18\nDispatched\nFire\n124 W MAIN ST, GOUVERNEUR
(911 DISPATCH) GOU FD:2013:17\nDispatched\nFire\n2023 SH 812 GOLD HOUSE 3RD PLACE PAST BONNIES DINER
(911 DISPATCH) GOU FD:2013:16\nDispatched\nLaw Enforcement\nNEAR 94 DANE ROAD GOUV
(911 DISPATCH) GOU FD:2013:15\nDispatched\nFire\n18 NORTH GORDON STREET, GOUVERNEUR NORTH COUNTRY TRANSITIONAL LIVING
(911 DISPATCH) GOU FD:2013:14\nDispatched\nFire\n3453 CR 6 , MORRISTOWN
(911 DISPATCH) \nDispatched\nFire\n15 VISTA ST
(911 DISPATCH) GOU FD:2013:12\nDispatched\nFire\n29 EMAIN ST , GOUVERNEUR
(911 DISPATCH) GOU FD:2013:11\nDispatched\nFire\n121 ISLAND BRANCH ROAD
(911 DISPATCH) GOU FD:2013:10\nDispatched\nFire\n48 WILLIAMS ST GOUVERNEUR
(911 DISPATCH) GOU FD:2013:9\nDispatched\nFire\n52 CHURCH ST GOUVERNEUR CHRISTI
(911 DISPATCH) GOU FD:2013:8\nDispatched\nFire\n18 ROWLEY ST GOUVERNEUR
(911 DISPATCH) GOU FD:2013:7\nDispatched\nEMS\n1751 U S HWY 11 #NY, GOUVERNEUR
(911 DISPATCH) GOU FD:2013:6\nDispatched\nEMS\nCR 9 GOUVERNEUR NEAR US HWY 11 INTERSECTION - E SECTOR #NY, GOUVERNEUR
(911 DISPATCH) GOU FD:2013:5\nDispatched\nEMS\nGOUVERNEUR WATER TREATMENT PLANT
(911 DISPATCH) GOU FD:2013:5\nDispatched\nEMS\nRIVER RD, EDWARDS
(911 DISPATCH) GOU FD:2013:4\nDispatched\nEMS\nRT 58 NEAR CR 10 AND TUTTLE RD
(911 DISPATCH) GOU FD:2013:3\nDispatched\nFire\n664 SCOTCH SETTLEMENT RD #NY, GOUVERNEUR
(911 DISPATCH) GOU FD:2013:2\nDispatched\nFire\n91  E MAIN #NY, GOUVERNEUR VILLAGE
(911 DISPATCH) GOU FD:2013:1\nDispatched\nFire-Chimney\n37433 CR 25, ANTWERP
(911 DISPATCH) GOU FD:2012:277\nDispatched\nEMS\n1193 COUNTY  RT 12
(911 DISPATCH) GOU FD:2012:276\nDispatched\nEMS\nACROSS FROM REMINGTON FURNITURE  GOUV
(911 DISPATCH) GOU FD:2012:275\nDispatched\nEMS\nRT 11 NEAR TRANSFER STATION, GOUVERNEUR
(911 DISPATCH) GOU FD:2012:274\nDispatched\nFire\n660 CO RT 9, GOUVERNEUR
(911 DISPATCH) GOU FD:2012:273\nDispatched\nFire\n117 GROVE #NY, GOUVERNEUR VILLAGE
(911 DISPATCH) GOU FD:2012:271\nDispatched\nEMS\nCR 9 NEAR RSI BUILDING
(911 DISPATCH) GOU FD:2012:270\nDispatched\nFire\n389 EAST MAIN STREET  PRICE CHOPPER
(911 DISPATCH) GOU FD:2012:269\nDispatched\nEMS\n1313 MOCKING BIRD LANE TEST CARD

Contact: Active911
Agency name: Gouverneur Rescue Squad
Location: Gouverneur, NY, United States
Sender: dispatch@stlawco.org

(911 DISPATCH) GOU RES:2013:225\nDispatched\nEMS\n547 JONESVILLE ROAD, RICHVILLE
(911 DISPATCH) GOU RES:2013:224\nDispatched\nEMS\n732 RIVER RD #NYUNIT B, EDWARDS
(911 DISPATCH) GOU RES:2013:223\nDispatched\nEMS\n732 RIVER RD #NYUNIT B, EDWARDS
(911 DISPATCH) GOU RES:2013:222\nDispatched\nEMS\n1 ACTIVE 911 TEST ONLY
(911 DISPATCH) GOU RES:2013:215\nDispatched\nEMS\n4815 ROUTE 58 #NY, GOUVERNEUR-SH 58
(911 DISPATCH) GOU RES:2013:214\nDispatched\nEMS\n1404 CR 12, APT C, GOUVERNEUR
(911 DISPATCH) GOU RES:2013:213\nDispatched\nResponse Type 23C01\n5998 SH 58 MACOMB
(911 DISPATCH) GOU RES:2013:212\nDispatched\nResponse Type 09E02\n145 ROWLEY STREET GOUV
(911 DISPATCH) GOU RES:2013:211\nDispatched\nEMS\n14 WILSON ST, GOUVERNEUR
(911 DISPATCH) GOU RES:2013:210\nDispatched\nEMS\nTRANSPORT TO CHMC
(911 DISPATCH) GOU RES:2013:209\nDispatched\nEMS
(911 DISPATCH) GOU RES:2013:208\nDispatched\nEMS
(911 DISPATCH) GOU RES:2013:207\nDispatched\nEMS\n1121 US 11 GOUVERNEUR GARDENS LOT32
(911 DISPATCH) GOU RES:2013:206\nDispatched\nEMS\n12 RAPIDS ISLE RD HAILSBORO
(911 DISPATCH) GOU RES:2013:205\nDispatched\nEMS\nCOUNTRY CLUB RD, GOUVERNEUR

Contact: Active911
Agency name: Harrisville Vol Fire Dept. Inc.
Location: Harrisville, NY, United States
Sender: LEWIS911@lewiscountyny.org
Sender: dispatch@stlawco.org

(911 DISPATCH) HAR FD:2013:7\nDispatched\nFire\n495 SH 812 PITCARIN
(911 DISPATCH) HAR RES:2013:11\nDispatched\nEMS\nHARRISVILE TEST MESS
(911 DISPATCH) HAR FD:2013:6\nDispatched\nEMS\nHARRISVILE TEST MESS
(911 DISPATCH) HAR RES:2013:10\nDispatched\nEMS\nHARRISVILE TEST MESS

*/

public class NYStLawrenceCountyParserTest extends BaseParserTest {
  
  public NYStLawrenceCountyParserTest() {
    setParser(new NYStLawrenceCountyParser(), "ST LAWRENCE COUNTY", "NY");
  }
  
  @Test
  public void testHeuveltonFire() {

    doTest("T1",
        "(911 DISPATCH) HEU CFR:2012:258\nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON",
        "SRC:HEU CFR",
        "ID:2012:258",
        "CALL:EMS",
        "ADDR:575 LOST VILLAGE ROAD",
        "CITY:HEUVELTON");  // Really Ogdensburg

    doTest("T2",
        "(911 DISPATCH) HEU FD:2012:149\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37",
        "SRC:HEU FD",
        "ID:2012:149",
        "CALL:Fire",
        "ADDR:9626 SH 37",
        "MADDR:9626 NY 37",
        "CITY:LISBON");

    doTest("T3",
        "(911 DISPATCH) HEU CFR:2012:257\nDispatched\nEMS\n5771 CO RT 10",
        "SRC:HEU CFR",
        "ID:2012:257",
        "CALL:EMS",
        "ADDR:5771 CO RT 10",
        "MADDR:5771 COUNTY ROAD 10");

    doTest("T4",
        "(911 DISPATCH) HEU CFR:2012:256\nDispatched\nEMS",
        "SRC:HEU CFR",
        "ID:2012:256",
        "CALL:EMS");

    doTest("T5",
        "(911 DISPATCH) HEU FD:2012:146\nDispatched\nFire\n736 FULTON RD , LISBON ( ROUTE 27 / DANDY RD)",
        "SRC:HEU FD",
        "ID:2012:146",
        "CALL:Fire",
        "ADDR:736 FULTON RD",
        "CITY:LISBON",
        "X:ROUTE 27/DANDY RD");

    doTest("T6",
        "(911 DISPATCH) HEU FD:2012:145\nDispatched\nFire\nPOLE IN FRONT OF HAMILTON GARDENS",
        "SRC:HEU FD",
        "ID:2012:145",
        "CALL:Fire",
        "ADDR:POLE IN FRONT OF HAMILTON GARDENS");

    doTest("T7",
        "(911 DISPATCH) \nDispatched\nEMS\n47 RENSELLEAR ST HEUVELTON",
        "CALL:EMS",
        "ADDR:47 RENSELLEAR ST",
        "CITY:HEUVELTON");

    doTest("T8",
        "(911 DISPATCH) HEU FD:2012:143\nDispatched\nEMS\n1456 W LAKE RD #NYPH, DEPEYSTER",
        "SRC:HEU FD",
        "ID:2012:143",
        "CALL:EMS",
        "ADDR:1456 W LAKE RD",
        "CITY:DE PEYSTER",
        "APT:PH");

    doTest("T9",
        "(911 DISPATCH) HEU CFR:2012:254\nDispatched\nEMS\n16 RENSELLAER STREET, HEUVELTON",
        "SRC:HEU CFR",
        "ID:2012:254",
        "CALL:EMS",
        "ADDR:16 RENSELLAER STREET",
        "CITY:HEUVELTON");

    doTest("T10",
        "(911 DISPATCH) HEU CFR:2012:253\nDispatched\nEMS\n7 JUSTINA #NY, HEUVELTON VILLAGE",
        "SRC:HEU CFR",
        "ID:2012:253",
        "CALL:EMS",
        "ADDR:7 JUSTINA",
        "CITY:HEUVELTON");

    doTest("T11",
        "(911 DISPATCH) HEU FD:2012:142\nDispatched\nEMS\n3561 COUNTY ROUTE 10, DEPEYSTER",
        "SRC:HEU FD",
        "ID:2012:142",
        "CALL:EMS",
        "ADDR:3561 COUNTY ROUTE 10",
        "MADDR:3561 COUNTY ROAD 10",
        "CITY:DE PEYSTER");

    doTest("T12",
        "(911 DISPATCH) HEU FD:2012:141\nDispatched\nFire\n900 BLOCK OF MAIN ST, MORRISTOWN",
        "SRC:HEU FD",
        "ID:2012:141",
        "CALL:Fire",
        "ADDR:900 BLOCK OF MAIN ST",
        "MADDR:900 MAIN ST",
        "CITY:MORRISTOWN");

  }
  
  @Test
  public void testLisbonFire() {

    doTest("T1",
        "(911 DISPATCH) \nDispatched\nEMS\nSUNY POTSDAM, POTSDAM LEAMAN SOUTH",
        "CALL:EMS",
        "ADDR:SUNY POTSDAM",
        "CITY:POTSDAM",
        "PLACE:LEAMAN SOUTH");

    doTest("T2",
        "(911 DISPATCH) LIS RES:2012:290\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37",
        "SRC:LIS RES",
        "ID:2012:290",
        "CALL:Fire",
        "ADDR:9626 SH 37",
        "MADDR:9626 NY 37",
        "CITY:LISBON");

    doTest("T3",
        "(911 DISPATCH) LIS FD:2012:153\nDispatched\nEMS\n4701 ST HWY 68",
        "SRC:LIS FD",
        "ID:2012:153",
        "CALL:EMS",
        "ADDR:4701 ST HWY 68",
        "MADDR:4701 NY 68");

    doTest("T4",
        "(911 DISPATCH) LIS FD:2012:152\nDispatched\nFire\nCHAPLE ROAD, LISBON",
        "SRC:LIS FD",
        "ID:2012:152",
        "CALL:Fire",
        "ADDR:CHAPLE ROAD",
        "CITY:LISBON");

    doTest("T5",
        "(911 DISPATCH) LIS RES:2012:288\nDispatched\nEMS\n5771 CO RT 10",
        "SRC:LIS RES",
        "ID:2012:288",
        "CALL:EMS",
        "ADDR:5771 CO RT 10",
        "MADDR:5771 COUNTY ROAD 10");

    doTest("T6",
        "(911 DISPATCH) LIS RES:2012:287\nDispatched\nResponse Type 29B01\nPRAY ROAD,  X TUCK ROAD",
        "SRC:LIS RES",
        "ID:2012:287",
        "CODE:29B01",
        "CALL:MVA - Injuries",
        "ADDR:PRAY ROAD",
        "MADDR:PRAY ROAD & TUCK ROAD",
        "X:TUCK ROAD");

    doTest("T7",
        "(911 DISPATCH) LIS RES:2012:286\nDispatched\nFire\nFULTON ROAD LISBON",
        "SRC:LIS RES",
        "ID:2012:286",
        "CALL:Fire",
        "ADDR:FULTON ROAD",
        "CITY:LISBON");

    doTest("T8",
        "(911 DISPATCH) LIS RES:2012:285\nDispatched\nEMS\n60 MURPHY RD #NY, LISBON",
        "SRC:LIS RES",
        "ID:2012:285",
        "CALL:EMS",
        "ADDR:60 MURPHY RD",
        "CITY:LISBON");

    doTest("T9",
        "(911 DISPATCH) LIS RES:2012:284\nDispatched\nEMS\n21 JENNER RD, LISBON",
        "SRC:LIS RES",
        "ID:2012:284",
        "CALL:EMS",
        "ADDR:21 JENNER RD",
        "CITY:LISBON");

    doTest("T10",
        "(911 DISPATCH) LIS RES:2012:283\nDispatched\nEMS\n1183 ROUTE 28 #NY, LISBON-CR 28",
        "SRC:LIS RES",
        "ID:2012:283",
        "CALL:EMS",
        "ADDR:1183 CR 28",
        "MADDR:1183 COUNTY ROAD 28",
        "CITY:LISBON");

    doTest("T11",
        "(911 DISPATCH) LIS FD:2012:145\nDispatched\nFire\n211 ROSS RD, LISBON",
        "SRC:LIS FD",
        "ID:2012:145",
        "CALL:Fire",
        "ADDR:211 ROSS RD",
        "CITY:LISBON");

    doTest("T12",
        "(911 DISPATCH) LIS RES:2012:282\nDispatched\nEMS\n21 JENNER RD, LISBON",
        "SRC:LIS RES",
        "ID:2012:282",
        "CALL:EMS",
        "ADDR:21 JENNER RD",
        "CITY:LISBON");

    doTest("T13",
        "(911 DISPATCH) LIS RES:2012:281\nDispatched\nEMS\n10964 ROUTE 37 #NY, LISBON-SH 37",
        "SRC:LIS RES",
        "ID:2012:281",
        "CALL:EMS",
        "ADDR:10964 SH 37",
        "MADDR:10964 NY 37",
        "CITY:LISBON");  // In Waddington

    doTest("T14",
        "(911 DISPATCH) LIS RES:2012:280\nDispatched\nResponse Type 30B01\n3992 STATE HWY 68 - W SECTOR #NY, LISBON",
        "SRC:LIS RES",
        "ID:2012:280",
        "CODE:30B01",
        "CALL:Trauma - Possibly dangerous body area",
        "ADDR:3992 STATE HWY 68",
        "MADDR:3992 STATE 68",
        "PLACE:W SECTOR",
        "CITY:LISBON");

  }
  
  @Test
  public void testPotsdamFire() {

    doTest("T1",
        "(911 DISPATCH) POT FD:2012:501\nDispatched\nFire",
        "SRC:POT FD",
        "ID:2012:501",
        "CALL:Fire");

    doTest("T2",
        "(911 DISPATCH) POT FD:2012:500\nDispatched\nFire\nWOOD STOCK VILLAGE",
        "SRC:POT FD",
        "ID:2012:500",
        "CALL:Fire",
        "ADDR:WOOD STOCK VILLAGE");

    doTest("T3",
        "(911 DISPATCH) POT FD:2012:498\nDispatched\nFire\n30 MARKET ST, POTSDAM",
        "SRC:POT FD",
        "ID:2012:498",
        "CALL:Fire",
        "ADDR:30 MARKET ST",
        "CITY:POTSDAM");

    doTest("T4",
        "(911 DISPATCH) POT FD:2012:497\nDispatched\nFire\n6994 US HWY 11 - N SECTOR #NY, POTSDAM",
        "SRC:POT FD",
        "ID:2012:497",
        "CALL:Fire",
        "PLACE:N SECTOR",
        "ADDR:6994 US HWY 11",
        "MADDR:6994 US 11",
        "CITY:POTSDAM");

    doTest("T5",
        "(911 DISPATCH) POT FD:2012:496\nDispatched\nFire\n109 MAPLE STREET POTSDAM",
        "SRC:POT FD",
        "ID:2012:496",
        "CALL:Fire",
        "ADDR:109 MAPLE STREET",
        "CITY:POTSDAM");

    doTest("T6",
        "(911 DISPATCH) POT FD:2012:495\nDispatched\nFire\nWOODSTOCK, BUILDING 9",
        "SRC:POT FD",
        "ID:2012:495",
        "CALL:Fire",
        "ADDR:WOODSTOCK",
        "PLACE:BUILDING 9");

    doTest("T7",
        "(911 DISPATCH) POT FD:2012:494\nDispatched\nFire\nWOOD STOCK BUILDING 6",
        "SRC:POT FD",
        "ID:2012:494",
        "CALL:Fire",
        "ADDR:WOOD STOCK BUILDING 6");

    doTest("T8",
        "(911 DISPATCH) POT FD:2012:493\nDispatched\nFire\nROSS BROOKS DORM, CLARKSON UNIVERSITY",
        "SRC:POT FD",
        "ID:2012:493",
        "CALL:Fire",
        "PLACE:ROSS BROOKS DORM",
        "ADDR:CLARKSON UNIVERSITY",
        "CITY:POTSDAM");

    doTest("T9",
        "(911 DISPATCH) POT FD:2012:492\nDispatched\nFire",
        "SRC:POT FD",
        "ID:2012:492",
        "CALL:Fire");

    doTest("T10",
        "(911 DISPATCH) POT FD:2012:491\nDispatched\nFire\n415 BACK HANNAWA RD, POTSDAM",
        "SRC:POT FD",
        "ID:2012:491",
        "CALL:Fire",
        "ADDR:415 BACK HANNAWA RD",
        "CITY:POTSDAM");

    doTest("T11",
        "(911 DISPATCH) POT FD:2012:490\nDispatched\nFire\n4 CANAL ST POTSDAM",
        "SRC:POT FD",
        "ID:2012:490",
        "CALL:Fire",
        "ADDR:4 CANAL ST",
        "CITY:POTSDAM");

    doTest("T12",
        "(911 DISPATCH) POT FD:2012:489\nDispatched\nFire\n29 ELM ST POTSDAM",
        "SRC:POT FD",
        "ID:2012:489",
        "CALL:Fire",
        "ADDR:29 ELM ST",
        "CITY:POTSDAM");

  }
  
  @Test public void testStLawrenceCounty() {

    doTest("T1",
        "(911 DISPATCH) 911C:2012:0000008182\nDispatched\nEMS",
        "SRC:911C",
        "ID:2012:0000008182",
        "CALL:EMS");

    doTest("T2",
        "(911 DISPATCH) 911C:2012:0000008180\nDispatched\n911 Center\nBRAY ROAD - W SECTOR #NY, NORWOOD",
        "SRC:911C",
        "ID:2012:0000008180",
        "CALL:911 Center",
        "PLACE:W SECTOR",
        "ADDR:BRAY ROAD",
        "CITY:NORWOOD");

    doTest("T3",
        "(911 DISPATCH) \nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON",
        "CALL:EMS",
        "ADDR:575 LOST VILLAGE ROAD",
        "CITY:HEUVELTON");  // really in Ogdensburg

    doTest("T4",
        "(911 DISPATCH) 911C:2012:0000008054\nDispatched\nEMS\nDOAN RD, GOUVERNEUR",
        "SRC:911C",
        "ID:2012:0000008054",
        "CALL:EMS",
        "ADDR:DOAN RD",  // Not mapping
        "CITY:GOUVERNEUR");

    doTest("T5",
        "(911 DISPATCH) 911C:2012:0000008051\nDispatched\nEMS\nOFF RT 812 NEAR STEVENSON",
        "SRC:911C",
        "ID:2012:0000008051",
        "CALL:EMS",
        "ADDR:OFF RT 812",
        "PLACE:NEAR STEVENSON",
        "MADDR:& RT 812");

    doTest("T6",
        "(911 DISPATCH) 911C:2012:0000008048\nDispatched\nEMS\n66 CNTY RTE 31 (OUTER ELM ST) - NW SECTOR #NY, MADRID",
        "SRC:911C",
        "ID:2012:0000008048",
        "CALL:EMS",
        "PLACE:NW SECTOR",
        "ADDR:66 CNTY RTE 31",
        "MADDR:66 COUNTY ROAD 31",
        "CITY:MADRID",
        "X:OUTER ELM ST");

    doTest("T7",
        "(911 DISPATCH) 911C:2012:0000008047\nDispatched\nFire\n9626 ROUTE 37 #NY, LISBON-SH 37",
        "SRC:911C",
        "ID:2012:0000008047",
        "CALL:Fire",
        "ADDR:9626 SH 37",
        "MADDR:9626 NY 37",
        "CITY:LISBON");

    doTest("T8",
        "(911 DISPATCH) 911C:2012:0000008045\nDispatched\nEMS\n5771 CO RT 10",
        "SRC:911C",
        "ID:2012:0000008045",
        "CALL:EMS",
        "ADDR:5771 CO RT 10",
        "MADDR:5771 COUNTY ROAD 10");

    doTest("T9",
        "(911 DISPATCH) 911C:2012:0000008028\nDispatched\nEMS\nVACINITY 931 PICKLE STREET STOCKHOLM",
        "SRC:911C",
        "ID:2012:0000008028",
        "CALL:EMS",
        "ADDR:VACINITY 931 PICKLE STREET",
        "MADDR:931 PICKLE STREET",
        "CITY:STOCKHOLM");

    doTest("T10",
        "(911 DISPATCH) 911C:2012:0000008023\nDispatched\nFire\n9 HASKELL STREET, MASSENA",
        "SRC:911C",
        "ID:2012:0000008023",
        "CALL:Fire",
        "ADDR:9 HASKELL STREET",
        "CITY:MASSENA");

    doTest("T11",
        "(911 DISPATCH) 911C:2012:0000008001\nDispatched\nFire\n34 CORNELL DR, RUSHTON DORM",
        "SRC:911C",
        "ID:2012:0000008001",
        "CALL:Fire",
        "ADDR:34 CORNELL DR",
        "PLACE:RUSHTON DORM");

    doTest("T12",
        "(911 DISPATCH) 911C:2012:0000007998\nDispatched\nEMS\n915, CR 12",
        "SRC:911C",
        "ID:2012:0000007998",
        "CALL:EMS",
        "ADDR:915 CR 12",
        "MADDR:915 COUNTY ROAD 12");

    doTest("T13",
        "(911 DISPATCH) 911C:2012:0000007997\nDispatched\nFire\n5-7 CLINTON ST, NORFOLK",
        "SRC:911C",
        "ID:2012:0000007997",
        "CALL:Fire",
        "ADDR:5-7 CLINTON ST",
        "MADDR:5 CLINTON ST",
        "CITY:NORFOLK");

    doTest("T14",
        "(911 DISPATCH) 911C:2012:0000007970\nDispatched\nFire\n46 COOK STREET MASSENA",
        "SRC:911C",
        "ID:2012:0000007970",
        "CALL:Fire",
        "ADDR:46 COOK STREET",
        "CITY:MASSENA");

    doTest("T15",
        "(911 DISPATCH) 911C:2012:0000007950\nDispatched\nFire\n736 FULTON ROAD LISBON",
        "SRC:911C",
        "ID:2012:0000007950",
        "CALL:Fire",
        "ADDR:736 FULTON ROAD",
        "CITY:LISBON");

    doTest("T16",
        "(911 DISPATCH) 911C:2012:0000007945\nDispatched\nEMS\n1456 W LAKE RD #NYPH, DEPEYSTER",
        "SRC:911C",
        "ID:2012:0000007945",
        "CALL:EMS",
        "ADDR:1456 W LAKE RD",
        "CITY:DE PEYSTER",
        "APT:PH");

    doTest("T17",
        "(911 DISPATCH) 911C:2012:0000007915\nDispatched\nFire-Chimney\n7 GRANT ST, EDWARDS",
        "SRC:911C",
        "ID:2012:0000007915",
        "CALL:Fire-Chimney",
        "ADDR:7 GRANT ST",
        "CITY:EDWARDS");

    doTest("T18",
        "(911 DISPATCH) 911C:2012:0000007889\nDispatched\nFire\n415 BACK HANNAWA RD, POTSDAM",
        "SRC:911C",
        "ID:2012:0000007889",
        "CALL:Fire",
        "ADDR:415 BACK HANNAWA RD",
        "CITY:POTSDAM");

    doTest("T19",
        "(911 DISPATCH) 911C:2012:0000007887\nDispatched\nFire\n34 COLTON RD #NY, RUSSELL",
        "SRC:911C",
        "ID:2012:0000007887",
        "CALL:Fire",
        "ADDR:34 COLTON RD",
        "CITY:RUSSELL");

    doTest("T20",
        "(911 DISPATCH) 911C:2012:0000007881\nDispatched\nFire\n2207 ROUTE 3 #NY, FINE-SH 3",
        "SRC:911C",
        "ID:2012:0000007881",
        "CALL:Fire",
        "ADDR:2207 SH 3",
        "MADDR:2207 NY 3",  // Not mapping
        "CITY:FINE");

    doTest("T21",
        "(911 DISPATCH) 911C:2012:0000007878\nDispatched\nFire\n2111 ROUTE 310 , MADRID",
        "SRC:911C",
        "ID:2012:0000007878",
        "CALL:Fire",
        "ADDR:2111 ROUTE 310",
        "CITY:MADRID");

    doTest("T22",
        "(911 DISPATCH) 911C:2012:0000007865\nDispatched\nFire\n1325 LITTLE BOW RD #NY, GOUVERNEUR",
        "SRC:911C",
        "ID:2012:0000007865",
        "CALL:Fire",
        "ADDR:1325 LITTLE BOW RD",
        "CITY:GOUVERNEUR");

    doTest("T23",
        "(911 DISPATCH) 911C:2012:0000007862\nDispatched\nEMS\n428 ELIZABETH #NY, OGDENSBURG CITY",
        "SRC:911C",
        "ID:2012:0000007862",
        "CALL:EMS",
        "ADDR:428 ELIZABETH",
        "CITY:OGDENSBURG");

    doTest("T24",
        "(911 DISPATCH) 911C:2012:0000007788\nDispatched\nFire\n1057 CR44, WADDINGTON",
        "SRC:911C",
        "ID:2012:0000007788",
        "CALL:Fire",
        "ADDR:1057 CR-44",
        "MADDR:1057 COUNTY ROAD 44",
        "CITY:WADDINGTON");

    doTest("T25",
        "(911 DISPATCH) 911C:2012:0000007785\nDispatched\nFire\n1215 CR 20",
        "SRC:911C",
        "ID:2012:0000007785",
        "CALL:Fire",
        "ADDR:1215 CR 20",
        "MADDR:1215 COUNTY ROAD 20");

    doTest("T26",
        "(911 DISPATCH) 911C:2012:0000007786\nDispatched\nFire\n49 BURKE DELOSH RD #NY, BRASHER",
        "SRC:911C",
        "ID:2012:0000007786",
        "CALL:Fire",
        "ADDR:49 BURKE DELOSH RD",
        "CITY:BRASHER");

    doTest("T27",
        "(911 DISPATCH) 911C:2012:0000007780\nDispatched\nFire-Grass\nBROUSE RD, 1/4 MI OFF RT 420",
        "SRC:911C",
        "ID:2012:0000007780",
        "CALL:Fire-Grass",
        "ADDR:BROUSE RD",
        "MADDR:BROUSE RD & 1/4 MI & RT 420",
        "X:1/4 MI OFF RT 420");

    doTest("T28",
        "(911 DISPATCH) 911C:2012:0000007776\nDispatched\nFire\n11 HOPSON RD, BRASHER",
        "SRC:911C",
        "ID:2012:0000007776",
        "CALL:Fire",
        "ADDR:11 HOPSON RD",
        "CITY:BRASHER");

    doTest("T29",
        "(911 DISPATCH) 911C:2012:0000007730\nDispatched\nFire\n570 COUNTRY CLUB RD, GOUVERNEUR",
        "SRC:911C",
        "ID:2012:0000007730",
        "CALL:Fire",
        "ADDR:570 COUNTRY CLUB RD",
        "CITY:GOUVERNEUR");

    doTest("T30",
        "(911 DISPATCH) 911C:2012:0000007723\nDispatched\nFire-Chimney\n9043, SH 58",
        "SRC:911C",
        "ID:2012:0000007723",
        "CALL:Fire-Chimney",
        "ADDR:9043 SH 58",
        "MADDR:9043 NY 58");

    doTest("T31",
        "(911 DISPATCH) 911C:2012:0000007721\nDispatched\nFire\n900 BLOCK OF MAIN ST, MORRISTOWN",
        "SRC:911C",
        "ID:2012:0000007721",
        "CALL:Fire",
        "ADDR:900 BLOCK OF MAIN ST",
        "MADDR:900 MAIN ST",
        "CITY:MORRISTOWN");

    doTest("T32",
        "(911 DISPATCH) 911C:2012:0000007714\nDispatched\nEMS\n636 ROUTE 310 #NY, CANTON-SH 310",
        "SRC:911C",
        "ID:2012:0000007714",
        "CALL:EMS",
        "ADDR:636 SH 310",
        "MADDR:636 NY 310",
        "CITY:CANTON");

    doTest("T33",
        "(911 DISPATCH) 911C:2012:0000007712\nDispatched\nFire\n201 MARSH RD, NORFOLK",
        "SRC:911C",
        "ID:2012:0000007712",
        "CALL:Fire",
        "ADDR:201 MARSH RD",
        "CITY:NORFOLK");

    doTest("T34",
        "(911 DISPATCH) 911C:2012:0000007706\nDispatched\nFire\nEAST ORVIS ST  #NY, MASSENA VILLAGE",
        "SRC:911C",
        "ID:2012:0000007706",
        "CALL:Fire",
        "ADDR:EAST ORVIS ST",
        "CITY:MASSENA");

    doTest("T35",
        "(911 DISPATCH) 911C:2012:0000007701\nDispatched\nEMS\n1 CHIMNEY POINT DR #NYBLDG 201, OGDENSBURG CITY",
        "SRC:911C",
        "ID:2012:0000007701",
        "CALL:EMS",
        "ADDR:1 CHIMNEY POINT DR",
        "CITY:OGDENSBURG",
        "APT:BLDG 201");
   
  }
  
  @Test
  public void testOgdenRescue() {

    doTest("T1",
        "(911 DISPATCH) OGD RES:2012:2375\nDispatched\nEMS\nRT 37",
        "SRC:OGD RES",
        "ID:2012:2375",
        "CALL:EMS",
        "ADDR:RT 37");

    doTest("T2",
        "(911 DISPATCH) OGD RES:2012:2374\nDispatched\nEMS\n3715 ROUTE 6 #NY, MORRISTOWN-CR 6",
        "SRC:OGD RES",
        "ID:2012:2374",
        "CALL:EMS",
        "ADDR:3715 CR 6",
        "MADDR:3715 COUNTY ROAD 6",
        "CITY:MORRISTOWN");

    doTest("T3",
        "(911 DISPATCH) OGD RES:2012:2373\nDispatched\nEMS\n8103 ROUTE 68 #NY, OSWEGATCHIE-SH 68",
        "SRC:OGD RES",
        "ID:2012:2373",
        "CALL:EMS",
        "ADDR:8103 SH 68",
        "MADDR:8103 NY 68",
        "CITY:OSWEGATCHIE");

    doTest("T4",
        "(911 DISPATCH) OGD RES:2012:2372\nDispatched\nEMS\n2320 FORD STREET, OGDENSBURG",
        "SRC:OGD RES",
        "ID:2012:2372",
        "CALL:EMS",
        "ADDR:2320 FORD STREET",
        "CITY:OGDENSBURG");

    doTest("T5",
        "(911 DISPATCH) OGD RES:2012:2371\nDispatched\nEMS\n1302 FORD STREET APT 7, OGDENSBURG",
        "SRC:OGD RES",
        "ID:2012:2371",
        "CALL:EMS",
        "ADDR:1302 FORD STREET",
        "CITY:OGDENSBURG",
        "APT:7");

    doTest("T6",
        "(911 DISPATCH) OGD RES:2012:2370\nDispatched\nEMS\n1111 JAY #NYFLR 3 APT 309, OGDENBURG CITY-PARKVIEW RISE",
        "SRC:OGD RES",
        "ID:2012:2370",
        "CALL:EMS",
        "PLACE:PARKVIEW RISE",
        "ADDR:1111 JAY",
        "CITY:OGDENSBURG",
        "APT:FLR 3 APT 309");

    doTest("T7",
        "(911 DISPATCH) OGD RES:2012:2369\nDispatched\nEMS\n575 LOST VILLAGE ROAD,HEUVELTON",
        "SRC:OGD RES",
        "ID:2012:2369",
        "CALL:EMS",
        "ADDR:575 LOST VILLAGE ROAD",
        "CITY:HEUVELTON");

    doTest("T8",
        "(911 DISPATCH) OGD RES:2012:2368\nDispatched\nEMS\n318 BLEMONT COURTS  OGD",
        "SRC:OGD RES",
        "ID:2012:2368",
        "CALL:EMS",
        "ADDR:318 BLEMONT COURTS",
        "CITY:OGDENSBURG");

    doTest("T9",
        "(911 DISPATCH) OGD RES:2012:2367\nDispatched\nEMS\n8103 ROUTE 68 #NY, OSWEGATCHIE-SH 68",
        "SRC:OGD RES",
        "ID:2012:2367",
        "CALL:EMS",
        "ADDR:8103 SH 68",
        "MADDR:8103 NY 68",
        "CITY:OSWEGATCHIE");

    doTest("T10",
        "(911 DISPATCH) OGD RES:2012:2366\nDispatched\nEMS\n817 FORD ST OGD CROSS PATTERSON/HAMILTON",
        "SRC:OGD RES",
        "ID:2012:2366",
        "CALL:EMS",
        "ADDR:817 FORD ST",
        "CITY:OGDENSBURG",
        "X:PATTERSON & HAMILTON");

    doTest("T11",
        "(911 DISPATCH) OGD RES:2012:2365\nDispatched\nResponse Type 17A01\n712 CONGRESS #NY, OGDENSBURG CITY",
        "SRC:OGD RES",
        "ID:2012:2365",
        "CODE:17A01",
        "CALL:Fall - Not dangerous body area",
        "ADDR:712 CONGRESS",
        "CITY:OGDENSBURG");

    doTest("T12",
        "(911 DISPATCH) OGD RES:2012:2364\nDispatched\nEMS\n817 FORD ST , OGDENSBURG ( PATTERSON ST / HAMILTON ST)",
        "SRC:OGD RES",
        "ID:2012:2364",
        "CALL:EMS",
        "ADDR:817 FORD ST",
        "CITY:OGDENSBURG",
        "X:PATTERSON ST/HAMILTON ST");

    doTest("T13",
        "(911 DISPATCH) OGD RES:2012:2363\nDispatched\nResponse Type 26A01\n1076 WASHINGTON ST #NY, OGD",
        "SRC:OGD RES",
        "ID:2012:2363",
        "CODE:26A01",
        "CALL:Sick - No priority symptoms",
        "ADDR:1076 WASHINGTON ST",
        "CITY:OGDENSBURG");

    doTest("T14",
        "(911 DISPATCH) OGD RES:2012:2362\nDispatched\nEMS\n312 ALBANY AV #NY, OGDENSBURG CITY",
        "SRC:OGD RES",
        "ID:2012:2362",
        "CALL:EMS",
        "ADDR:312 ALBANY AV",
        "MADDR:312 ALBANY AVE",
        "CITY:OGDENSBURG");

    doTest("T15",
        "(911 DISPATCH) OGD RES:2012:2361\nDispatched\nEMS\n302 OAK ST , OGDENSBURG ( MANSION AVE / ALBANY AVE)",
        "SRC:OGD RES",
        "ID:2012:2361",
        "CALL:EMS",
        "ADDR:302 OAK ST",
        "CITY:OGDENSBURG",
        "X:MANSION AVE/ALBANY AVE");

    doTest("T16",
        "(911 DISPATCH) OGD RES:2012:2360\nDispatched\nEMS\n813 MECHANIC #NY, OGDENSBURG CITY",
        "SRC:OGD RES",
        "ID:2012:2360",
        "CALL:EMS",
        "ADDR:813 MECHANIC",
        "CITY:OGDENSBURG");

    doTest("T17",
        "(911 DISPATCH) OGD RES:2012:2359\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68",
        "SRC:OGD RES",
        "ID:2012:2359",
        "CALL:EMS",
        "ADDR:8101 SH 68",
        "MADDR:8101 NY 68",
        "CITY:OSWEGATCHIE");

    doTest("T18",
        "(911 DISPATCH) OGD RES:2012:2358\nDispatched\nEMS\n202 WASHINGTON ST, OGDENSBURG CENTENNIAL TERRACE APT 303",
        "SRC:OGD RES",
        "ID:2012:2358",
        "CALL:EMS",
        "ADDR:202 WASHINGTON ST",
        "PLACE:OGDENSBURG CENTENNIAL TERRACE APT 303"); 

    doTest("T19",
        "(911 DISPATCH) OGD RES:2012:2357\nDispatched\nEMS\n80 LAGRASSE #NYAPT 113, WADDINGTON VILLAGE-HAMILTON G",
        "SRC:OGD RES",
        "ID:2012:2357",
        "CALL:EMS",
        "PLACE:HAMILTON G",
        "ADDR:80 LAGRASSE",
        "CITY:WADDINGTON",
        "APT:APT 113");

    doTest("T20",
        "(911 DISPATCH) OGD RES:2012:2356\nDispatched\nEMS\n232 WASHINGTON ST APT 703",
        "SRC:OGD RES",
        "ID:2012:2356",
        "CALL:EMS",
        "ADDR:232 WASHINGTON ST",
        "APT:703");

    doTest("T21",
        "(911 DISPATCH) OGD RES:2012:2355\nDispatched\nEMS\n721 NEW YORK AVE",
        "SRC:OGD RES",
        "ID:2012:2355",
        "CALL:EMS",
        "ADDR:721 NEW YORK AVE");

    doTest("T22",
        "(911 DISPATCH) OGD RES:2012:2354\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68",
        "SRC:OGD RES",
        "ID:2012:2354",
        "CALL:EMS",
        "ADDR:8101 SH 68",
        "MADDR:8101 NY 68",
        "CITY:OSWEGATCHIE");

    doTest("T23",
        "(911 DISPATCH) OGD RES:2012:2353\nDispatched\nEMS\n202 WASHINGTON ST APT 303 CENTENNIAL TERRACE OGD",
        "SRC:OGD RES",
        "ID:2012:2353",
        "CALL:EMS",
        "ADDR:202 WASHINGTON ST",
        "APT:303 CENTENNIAL TERRACE",
        "CITY:OGDENSBURG"); 

    doTest("T24",
        "(911 DISPATCH) OGD RES:2012:2352\nDispatched\nEMS\n8101 ROUTE 68 #NY, OSWEGATCHIE-SH 68",
        "SRC:OGD RES",
        "ID:2012:2352",
        "CALL:EMS",
        "ADDR:8101 SH 68",
        "MADDR:8101 NY 68",
        "CITY:OSWEGATCHIE");

    doTest("T25",
        "(911 DISPATCH) OGD RES:2012:2351\nDispatched\nEMS\n817 FORD ST, OGDENSBURG",
        "SRC:OGD RES",
        "ID:2012:2351",
        "CALL:EMS",
        "ADDR:817 FORD ST",
        "CITY:OGDENSBURG");

    doTest("T26",
        "(911 DISPATCH) OGD RES:2012:2350\nDispatched\nEMS\n56 LISBON ST, HEUVELTON",
        "SRC:OGD RES",
        "ID:2012:2350",
        "CALL:EMS",
        "ADDR:56 LISBON ST",
        "CITY:HEUVELTON");

    doTest("T27",
        "(911 DISPATCH) OGD RES:2012:2349\nDispatched\nEMS\nSPRING ST, OGDENSBURG",
        "SRC:OGD RES",
        "ID:2012:2349",
        "CALL:EMS",
        "ADDR:SPRING ST",
        "CITY:OGDENSBURG");

    doTest("T28",
        "(911 DISPATCH) OGD RES:2012:2348\nDispatched\nEMS\n3310 ROUTE 56 #NY,  SOUTH COLTON-SH 56",
        "SRC:OGD RES",
        "ID:2012:2348",
        "CALL:EMS",
        "ADDR:3310 SH 56",
        "MADDR:3310 NY 56",
        "CITY:SOUTH COLTON");

    doTest("T29",
        "(911 DISPATCH) OGD RES:2012:2347\nDispatched\nEMS\n705 NEW YORK AV #NYAPT DN, OGDENSBURG CITY",
        "SRC:OGD RES",
        "ID:2012:2347",
        "CALL:EMS",
        "ADDR:705 NEW YORK AV",
        "MADDR:705 NEW YORK AVE",
        "CITY:OGDENSBURG",
        "APT:APT DN");

    doTest("T30",
        "(911 DISPATCH) OGD RES:2012:2346\nDispatched\nEMS\n950 LINDEN, 2ND FLOOR #NY, OGDENSBURG CITY",
        "SRC:OGD RES",
        "ID:2012:2346",
        "CALL:EMS",
        "ADDR:950 LINDEN",
        "CITY:OGDENSBURG",
        "X:2ND FLOOR #NY");

  }
  
  @Test
  public void testMadridFire() {

    doTest("T1",
        "(911 DISPATCH) GOU FD:2013:21\nDispatched\nFire-Chimney\nRT 58 ON RIGHT PAST LIQOUR STORE",
        "SRC:GOU FD",
        "ID:2013:21",
        "CALL:Fire-Chimney",
        "ADDR:RT 58",
        "INFO:ON RIGHT PAST LIQOUR STORE");

    doTest("T2",
        "(911 DISPATCH) GOU FD:2013:24\nDispatched\nFire\nRT 58 NEAR GRAVEL RD",
        "SRC:GOU FD",
        "ID:2013:24",
        "CALL:Fire",
        "ADDR:RT 58",
        "MADDR:RT 58 & GRAVEL RD",
        "X:GRAVEL RD");

    doTest("T3",
        "(911 DISPATCH) GOU FD:2013:32\nDispatched\nFire\nAUSTIN ST GOUVERNEUR VILLAGE",
        "SRC:GOU FD",
        "ID:2013:32",
        "CALL:Fire",
        "ADDR:AUSTIN ST",
        "CITY:GOUVERNEUR");

    doTest("T4",
        "(911 DISPATCH) GOU FD:2013:31\nDispatched\nFire\n18 NORTH GORDON STREET GOUV",
        "SRC:GOU FD",
        "ID:2013:31",
        "CALL:Fire",
        "ADDR:18 NORTH GORDON STREET",
        "CITY:GOUVERNEUR");

    doTest("T5",
        "(911 DISPATCH) GOU FD:2013:30\nDispatched\nFire\nCALIFRONIA RD, T/MACOMB",
        "SRC:GOU FD",
        "ID:2013:30",
        "CALL:Fire",
        "ADDR:CALIFRONIA RD",
        "MADDR:CALIFRONIA RD & T",
        "CITY:MACOMB",
        "X:T");

    doTest("T6",
        "(911 DISPATCH) GOU FD:2013:29\nDispatched\nFire\n2244 CALIFORNIA RD #NY, MACOMB",
        "SRC:GOU FD",
        "ID:2013:29",
        "CALL:Fire",
        "ADDR:2244 CALIFORNIA RD",
        "CITY:MACOMB");

    doTest("T7",
        "(911 DISPATCH) GOU FD:2013:28\nDispatched\nFire\n12 WASHINGTON #NY, GOUVERNEUR VILLAGE",
        "SRC:GOU FD",
        "ID:2013:28",
        "CALL:Fire",
        "ADDR:12 WASHINGTON",
        "CITY:GOUVERNEUR");

    doTest("T8",
        "(911 DISPATCH) GOU FD:2013:27\nDispatched\nFire\n30 COUNTRY CLUB",
        "SRC:GOU FD",
        "ID:2013:27",
        "CALL:Fire",
        "ADDR:30 COUNTRY CLUB");

    doTest("T9",
        "(911 DISPATCH) GOU FD:2013:25\nDispatched\nFire\n91 EAST MAIN ST.,  GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:25",
        "CALL:Fire",
        "ADDR:91 EAST MAIN ST",
        "CITY:GOUVERNEUR");

    doTest("T10",
        "(911 DISPATCH) GOU FD:2013:23\nDispatched\nFire\n5230 RT 58  GOUVERNEUR TOWARDS MACOMB",
        "SRC:GOU FD",
        "ID:2013:23",
        "CALL:Fire",
        "ADDR:5230 RT 58",
        "CITY:GOUVERNEUR",
        "INFO:TOWARDS MACOMB");

    doTest("T11",
        "(911 DISPATCH) GOU FD:2013:22\nDispatched\nFire\n42780 NEW CONNECTICUT RD, ANTWERP",
        "SRC:GOU FD",
        "ID:2013:22",
        "CALL:Fire",
        "ADDR:42780 NEW CONNECTICUT RD",
        "CITY:ANTWERP");

    doTest("T12",
        "(911 DISPATCH) GOU FD:2013:20\nDispatched\nEMS\nSEAMAN RD",
        "SRC:GOU FD",
        "ID:2013:20",
        "CALL:EMS",
        "ADDR:SEAMAN RD");

    doTest("T13",
        "(911 DISPATCH) GOU FD:2013:19\nDispatched\nFire\nRT 11 SOUTH OF GOUV 1 MILE OUT",
        "SRC:GOU FD",
        "ID:2013:19",
        "CALL:Fire",
        "ADDR:RT 11 SOUTH OF",
        "CITY:GOUVERNEUR",
        "INFO:1 MILE OUT");

    doTest("T14",
        "(911 DISPATCH) GOU FD:2013:18\nDispatched\nFire\n124 W MAIN ST, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:18",
        "CALL:Fire",
        "ADDR:124 W MAIN ST",
        "CITY:GOUVERNEUR");

    doTest("T15",
        "(911 DISPATCH) GOU FD:2013:17\nDispatched\nFire\n2023 SH 812 GOLD HOUSE 3RD PLACE PAST BONNIES DINER",
        "SRC:GOU FD",
        "ID:2013:17",
        "CALL:Fire",
        "ADDR:2023 SH 812",
        "MADDR:2023 NY 812",
        "INFO:GOLD HOUSE 3RD PLACE PAST BONNIES DINER");

    doTest("T16",
        "(911 DISPATCH) GOU FD:2013:16\nDispatched\nLaw Enforcement\nNEAR 94 DANE ROAD GOUV",
        "SRC:GOU FD",
        "ID:2013:16",
        "CALL:Law Enforcement",
        "ADDR:NEAR 94 DANE ROAD",
        "MADDR:& 94 DANE ROAD",
        "CITY:GOUVERNEUR");

    doTest("T17",
        "(911 DISPATCH) GOU FD:2013:15\nDispatched\nFire\n18 NORTH GORDON STREET, GOUVERNEUR NORTH COUNTRY TRANSITIONAL LIVING",
        "SRC:GOU FD",
        "ID:2013:15",
        "CALL:Fire",
        "PLACE:NORTH COUNTRY TRANSITIONAL LIVING",
        "ADDR:18 NORTH GORDON STREET",
        "CITY:GOUVERNEUR");

    doTest("T18",
        "(911 DISPATCH) GOU FD:2013:14\nDispatched\nFire\n3453 CR 6 , MORRISTOWN",
        "SRC:GOU FD",
        "ID:2013:14",
        "CALL:Fire",
        "ADDR:3453 CR 6",
        "MADDR:3453 COUNTY ROAD 6",
        "CITY:MORRISTOWN");

    doTest("T19",
        "(911 DISPATCH) \nDispatched\nFire\n15 VISTA ST",
        "CALL:Fire",
        "ADDR:15 VISTA ST");

    doTest("T20",
        "(911 DISPATCH) GOU FD:2013:12\nDispatched\nFire\n29 EMAIN ST , GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:12",
        "CALL:Fire",
        "ADDR:29 EMAIN ST",
        "CITY:GOUVERNEUR");

    doTest("T21",
        "(911 DISPATCH) GOU FD:2013:11\nDispatched\nFire\n121 ISLAND BRANCH ROAD",
        "SRC:GOU FD",
        "ID:2013:11",
        "CALL:Fire",
        "ADDR:121 ISLAND BRANCH ROAD");

    doTest("T22",
        "(911 DISPATCH) GOU FD:2013:10\nDispatched\nFire\n48 WILLIAMS ST GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:10",
        "CALL:Fire",
        "ADDR:48 WILLIAMS ST",
        "CITY:GOUVERNEUR");

    doTest("T23",
        "(911 DISPATCH) GOU FD:2013:9\nDispatched\nFire\n52 CHURCH ST GOUVERNEUR CHRISTI",
        "SRC:GOU FD",
        "ID:2013:9",
        "CALL:Fire",
        "ADDR:52 CHURCH ST",
        "CITY:GOUVERNEUR",
        "INFO:CHRISTI");

    doTest("T24",
        "(911 DISPATCH) GOU FD:2013:8\nDispatched\nFire\n18 ROWLEY ST GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:8",
        "CALL:Fire",
        "ADDR:18 ROWLEY ST",
        "CITY:GOUVERNEUR");

    doTest("T25",
        "(911 DISPATCH) GOU FD:2013:7\nDispatched\nEMS\n1751 U S HWY 11 #NY, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:7",
        "CALL:EMS",
        "ADDR:1751 US HWY 11",
        "MADDR:1751 US 11",
        "CITY:GOUVERNEUR");

    doTest("T26",
        "(911 DISPATCH) GOU FD:2013:6\nDispatched\nEMS\nCR 9 GOUVERNEUR NEAR US HWY 11 INTERSECTION - E SECTOR #NY, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:6",
        "CALL:EMS",
        "PLACE:E SECTOR",
        "ADDR:CR 9",
        "MADDR:COUNTY ROAD 9",
        "CITY:GOUVERNEUR",
        "INFO:GOUVERNEUR NEAR US HWY 11 INTERSECTION");

    doTest("T27",
        "(911 DISPATCH) GOU FD:2013:5\nDispatched\nEMS\nGOUVERNEUR WATER TREATMENT PLANT",
        "SRC:GOU FD",
        "ID:2013:5",
        "CALL:EMS",
        "ADDR:GOUVERNEUR WATER TREATMENT PLANT");

    doTest("T28",
        "(911 DISPATCH) GOU FD:2013:5\nDispatched\nEMS\nRIVER RD, EDWARDS",
        "SRC:GOU FD",
        "ID:2013:5",
        "CALL:EMS",
        "ADDR:RIVER RD",
        "CITY:EDWARDS");

    doTest("T29",
        "(911 DISPATCH) GOU FD:2013:4\nDispatched\nEMS\nRT 58 NEAR CR 10 AND TUTTLE RD",
        "SRC:GOU FD",
        "ID:2013:4",
        "CALL:EMS",
        "ADDR:RT 58",
        "MADDR:RT 58 & COUNTY ROAD 10",
        "X:CR 10 AND TUTTLE RD");

    doTest("T30",
        "(911 DISPATCH) GOU FD:2013:3\nDispatched\nFire\n664 SCOTCH SETTLEMENT RD #NY, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2013:3",
        "CALL:Fire",
        "ADDR:664 SCOTCH SETTLEMENT RD",
        "CITY:GOUVERNEUR");

    doTest("T31",
        "(911 DISPATCH) GOU FD:2013:2\nDispatched\nFire\n91  E MAIN #NY, GOUVERNEUR VILLAGE",
        "SRC:GOU FD",
        "ID:2013:2",
        "CALL:Fire",
        "ADDR:91 E MAIN",
        "CITY:GOUVERNEUR");

    doTest("T32",
        "(911 DISPATCH) GOU FD:2013:1\nDispatched\nFire-Chimney\n37433 CR 25, ANTWERP",
        "SRC:GOU FD",
        "ID:2013:1",
        "CALL:Fire-Chimney",
        "ADDR:37433 CR 25",
        "MADDR:37433 COUNTY ROAD 25",
        "CITY:ANTWERP");

    doTest("T33",
        "(911 DISPATCH) GOU FD:2012:277\nDispatched\nEMS\n1193 COUNTY  RT 12",
        "SRC:GOU FD",
        "ID:2012:277",
        "CALL:EMS",
        "ADDR:1193 COUNTY RT 12",
        "MADDR:1193 COUNTY ROAD 12");

    doTest("T34",
        "(911 DISPATCH) GOU FD:2012:276\nDispatched\nEMS\nACROSS FROM REMINGTON FURNITURE  GOUV",
        "SRC:GOU FD",
        "ID:2012:276",
        "CALL:EMS",
        "ADDR:ACROSS FROM REMINGTON FURNITURE",
        "CITY:GOUVERNEUR");

    doTest("T35",
        "(911 DISPATCH) GOU FD:2012:275\nDispatched\nEMS\nRT 11 NEAR TRANSFER STATION, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2012:275",
        "CALL:EMS",
        "ADDR:RT 11",
        "CITY:GOUVERNEUR",
        "INFO:NEAR TRANSFER STATION");

    doTest("T36",
        "(911 DISPATCH) GOU FD:2012:274\nDispatched\nFire\n660 CO RT 9, GOUVERNEUR",
        "SRC:GOU FD",
        "ID:2012:274",
        "CALL:Fire",
        "ADDR:660 CO RT 9",
        "MADDR:660 COUNTY ROAD 9",
        "CITY:GOUVERNEUR");

    doTest("T37",
        "(911 DISPATCH) GOU FD:2012:273\nDispatched\nFire\n117 GROVE #NY, GOUVERNEUR VILLAGE",
        "SRC:GOU FD",
        "ID:2012:273",
        "CALL:Fire",
        "ADDR:117 GROVE",
        "CITY:GOUVERNEUR");

    doTest("T38",
        "(911 DISPATCH) GOU FD:2012:271\nDispatched\nEMS\nCR 9 NEAR RSI BUILDING",
        "SRC:GOU FD",
        "ID:2012:271",
        "CALL:EMS",
        "ADDR:CR 9",
        "MADDR:COUNTY ROAD 9",
        "PLACE:NEAR RSI BUILDING");

    doTest("T39",
        "(911 DISPATCH) GOU FD:2012:270\nDispatched\nFire\n389 EAST MAIN STREET  PRICE CHOPPER",
        "SRC:GOU FD",
        "ID:2012:270",
        "CALL:Fire",
        "ADDR:389 EAST MAIN STREET",
        "INFO:PRICE CHOPPER");

    doTest("T40",
        "(911 DISPATCH) GOU FD:2012:269\nDispatched\nEMS\n1313 MOCKING BIRD LANE TEST CARD",
        "SRC:GOU FD",
        "ID:2012:269",
        "CALL:EMS",
        "ADDR:1313 MOCKING BIRD LANE",
        "INFO:TEST CARD");

  }
  
  @Test
  public void testGouverneurRescueSquad() {

    doTest("T1",
        "(911 DISPATCH) GOU RES:2013:225\nDispatched\nEMS\n547 JONESVILLE ROAD, RICHVILLE",
        "SRC:GOU RES",
        "ID:2013:225",
        "CALL:EMS",
        "ADDR:547 JONESVILLE ROAD",
        "CITY:RICHVILLE");

    doTest("T2",
        "(911 DISPATCH) GOU RES:2013:224\nDispatched\nEMS\n732 RIVER RD #NYUNIT B, EDWARDS",
        "SRC:GOU RES",
        "ID:2013:224",
        "CALL:EMS",
        "ADDR:732 RIVER RD",
        "CITY:EDWARDS",
        "APT:UNIT B");

    doTest("T3",
        "(911 DISPATCH) GOU RES:2013:223\nDispatched\nEMS\n732 RIVER RD #NYUNIT B, EDWARDS",
        "SRC:GOU RES",
        "ID:2013:223",
        "CALL:EMS",
        "ADDR:732 RIVER RD",
        "CITY:EDWARDS",
        "APT:UNIT B");

    doTest("T4",
        "(911 DISPATCH) GOU RES:2013:222\nDispatched\nEMS\n1 ACTIVE 911 TEST ONLY",
        "SRC:GOU RES",
        "ID:2013:222",
        "CALL:EMS",
        "ADDR:1 ACTIVE 911 TEST ONLY");

    doTest("T5",
        "(911 DISPATCH) GOU RES:2013:215\nDispatched\nEMS\n4815 ROUTE 58 #NY, GOUVERNEUR-SH 58",
        "SRC:GOU RES",
        "ID:2013:215",
        "CALL:EMS",
        "ADDR:4815 SH 58",
        "MADDR:4815 NY 58",
        "CITY:GOUVERNEUR");

    doTest("T6",
        "(911 DISPATCH) GOU RES:2013:214\nDispatched\nEMS\n1404 CR 12, APT C, GOUVERNEUR",
        "SRC:GOU RES",
        "ID:2013:214",
        "CALL:EMS",
        "ADDR:1404 CR 12",
        "MADDR:1404 COUNTY ROAD 12",
        "CITY:GOUVERNEUR",
        "X:APT C");

    doTest("T7",
        "(911 DISPATCH) GOU RES:2013:213\nDispatched\nResponse Type 23C01\n5998 SH 58 MACOMB",
        "SRC:GOU RES",
        "ID:2013:213",
        "CODE:23C01",
        "CALL:Overdose - Not alert",
        "ADDR:5998 SH 58",
        "MADDR:5998 NY 58",
        "CITY:MACOMB");

    doTest("T8",
        "(911 DISPATCH) GOU RES:2013:212\nDispatched\nResponse Type 09E02\n145 ROWLEY STREET GOUV",
        "SRC:GOU RES",
        "ID:2013:212",
        "CODE:09E02",
        "CALL:Suspected workable arrest – breathing uncertain (agonal)",
        "ADDR:145 ROWLEY STREET",
        "CITY:GOUVERNEUR");

    doTest("T9",
        "(911 DISPATCH) GOU RES:2013:211\nDispatched\nEMS\n14 WILSON ST, GOUVERNEUR",
        "SRC:GOU RES",
        "ID:2013:211",
        "CALL:EMS",
        "ADDR:14 WILSON ST",
        "CITY:GOUVERNEUR");

    doTest("T10",
        "(911 DISPATCH) GOU RES:2013:210\nDispatched\nEMS\nTRANSPORT TO CHMC",
        "SRC:GOU RES",
        "ID:2013:210",
        "CALL:EMS",
        "ADDR:TRANSPORT TO CHMC");

    doTest("T11",
        "(911 DISPATCH) GOU RES:2013:209\nDispatched\nEMS",
        "SRC:GOU RES",
        "ID:2013:209",
        "CALL:EMS");

    doTest("T12",
        "(911 DISPATCH) GOU RES:2013:208\nDispatched\nEMS",
        "SRC:GOU RES",
        "ID:2013:208",
        "CALL:EMS");

    doTest("T13",
        "(911 DISPATCH) GOU RES:2013:207\nDispatched\nEMS\n1121 US 11 GOUVERNEUR GARDENS LOT32",
        "SRC:GOU RES",
        "ID:2013:207",
        "CALL:EMS",
        "ADDR:1121 US 11",
        "CITY:GOUVERNEUR",
        "APT:32",
        "INFO:GARDENS");

    doTest("T14",
        "(911 DISPATCH) GOU RES:2013:206\nDispatched\nEMS\n12 RAPIDS ISLE RD HAILSBORO",
        "SRC:GOU RES",
        "ID:2013:206",
        "CALL:EMS",
        "ADDR:12 RAPIDS ISLE RD",  // Google can't find this one
        "INFO:HAILSBORO");

    doTest("T15",
        "(911 DISPATCH) GOU RES:2013:205\nDispatched\nEMS\nCOUNTRY CLUB RD, GOUVERNEUR",
        "SRC:GOU RES",
        "ID:2013:205",
        "CALL:EMS",
        "ADDR:COUNTRY CLUB RD",
        "CITY:GOUVERNEUR");
  
  }
  
  @Test
  public void testHarrisvilleFire() {

    doTest("T1",
        "(911 DISPATCH) HAR FD:2013:7\nDispatched\nFire\n495 SH 812 PITCARIN",
        "SRC:HAR FD",
        "ID:2013:7",
        "CALL:Fire",
        "ADDR:495 SH 812",
        "MADDR:495 NY 812",
        "INFO:PITCARIN");

    doTest("T2",
        "(911 DISPATCH) HAR RES:2013:11\nDispatched\nEMS\nHARRISVILE TEST MESS",
        "SRC:HAR RES",
        "ID:2013:11",
        "CALL:EMS",
        "ADDR:HARRISVILE TEST MESS");

    doTest("T3",
        "(911 DISPATCH) HAR FD:2013:6\nDispatched\nEMS\nHARRISVILE TEST MESS",
        "SRC:HAR FD",
        "ID:2013:6",
        "CALL:EMS",
        "ADDR:HARRISVILE TEST MESS");

    doTest("T4",
        "(911 DISPATCH) HAR RES:2013:10\nDispatched\nEMS\nHARRISVILE TEST MESS",
        "SRC:HAR RES",
        "ID:2013:10",
        "CALL:EMS",
        "ADDR:HARRISVILE TEST MESS");

  }
  
  public static void main(String[] args) {
    new NYStLawrenceCountyParserTest().generateTests("T1");
  }
}