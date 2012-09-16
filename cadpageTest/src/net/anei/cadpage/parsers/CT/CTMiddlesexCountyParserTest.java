package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Middlesex County, CT
Contact: Active911
Agency name: Durham Vol Fire Department Location: Durham, CT 
Contact: LogiSYS@smtp109.sbc.mail.gq1.yahoo.com,CAD@smtp109.sbc.mail.gq1.yahoo.com

(DURHAM FIRE CALL CAD Page for CFS 061312-31) \nhttp://maps.google.com/maps?q=+41.48618%20-72.65719\nFire Alarm\n18 WEATHERVANE HILL\nApt: \nDH       \nCross Streets : MAIDEN LANE \nCaller: ADT OP YSG\nDisp Time: 06/13/12 11:36:52
(DURHAM FIRE CALL CAD Page for CFS 061312-47) \nhttp://maps.google.com/maps?q=+41.44852%20-72.70119\nFire Alarm\n471 NEW HAVEN RD\nApt: \nDH       \nCross Streets : SAW MILL RD * CANTERBURY DR \nCaller: \nDisp Time: 06/13/12 18:03:43
(DURHAM FIRE CALL CAD Page for CFS 061412-5) \nhttp://maps.google.com/maps?q=+41.48025%20-72.66325\nUnconcious/Unresponsive ALS\nMAIDEN LANE and BEAR ROCK RD\nApt: \nDH       \nCross Streets : SYCAMORE DR * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/14/12 04:22:21
(CAD Page for CFS 061512-51) \nhttp://maps.google.com/maps?q=+41.43734%20-72.71928\nFire Alarm\n809 NEW HAVEN RD\nApt: -R\nDH       \nCross Streets : COE RD * FORLINE RD \nCaller: \nWater\Info: SEND EMS NON-EMERGENCY ON FIRE ALARMS AT THIS LOCATION\n\nDisp Time: 06/15/12 15:35:55
(CAD Page for CFS 062012-32) \nhttp://maps.google.com/maps?q=+41.48282%20-72.68172\nMinor MVA -No Medic\n310 MAIN ST\nApt: \nDH       \nCross Streets : MAIDEN LANE * TALCOTT LANE \nCaller: VERIZON WIRELESS\nDisp Time: 06/20/12 12:24:24
(CAD Page for CFS 062112-63) \nhttp://maps.google.com/maps?q=+41.47446%20-72.68228\nMVA Medic ALS\n68 MAPLE AVE\nApt: \nDH       \nCross Streets : JOHNS WAY * OLD CEMETERY RD \nCaller: SPRINTPCS\nDisp Time: 06/21/12 17:22:22
(CAD Page for CFS 062212-43) \nhttp://maps.google.com/maps?q=+41.47400%20-72.68024\nMinor MVA -No Medic\n154 MAIN ST\nApt: \nDH       \nCross Streets : FOWLER AVE * OLD CEMETERY RD \nCaller: \nDisp Time: 06/22/12 15:48:27
(CAD Page for CFS 062312-10) \nhttp://maps.google.com/maps?q=+41.47818%20-72.68108\nMinor MVA -No Medic\nMAIN ST and WALLINGFORD RD\nApt: \nDH       \nCross Streets : WALLINGFORD RD * MAIDEN LANE \nCaller: \nDisp Time: 06/23/12 07:42:19
(CAD Page for CFS 062312-66) \nhttp://maps.google.com/maps?q=+41.47828%20-72.67083\nWires Down -Call NU\n135 PICKETT LANE\nApt: \nDH\nCross Streets : MAIN ST * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/23/12 21:06:27
(CAD Page for CFS 062412-49) \nhttp://maps.google.com/maps?q=+41.47896%20-72.68120\nMinor MVA -No Medic\n238 MAIN ST\nApt: \nDH       \nCross Streets : WALLINGFORD RD * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/24/12 14:21:09
(CAD Page for CFS 062512-13) \nhttp://maps.google.com/maps?q=+41.33698%20-72.58493\nStructure Fire\n24 COW PEN HILL RD\nApt: \nKW\nCross Streets : GREEN HILL RD * COOKS LANE \nCaller: BROWN,ROBERT F\nDisp Time: 06/25/12 08:30:13
(CAD Page for CFS 062512-65) \nhttp://maps.google.com/maps?q=+41.48772%20-72.64230\nFire Alarm\n255 JOHNSON LANE\nApt: \nDH       \nCross Streets : MAIDEN LANE * HADDAM QUARTER RD \nCaller: adt\nDisp Time: 06/25/12 16:21:16
(CAD Page for CFS 062512-87) \nhttp://maps.google.com/maps?q=+41.49094%20-72.65092\nElectrical Fire Pole/Wire\nHADDAM QUARTER RD and ARBUTUS ST\nApt: \nDH       \nCross Streets : WINTERBERRY LANE * HADDAM QUARTER RD \nCaller: VERIZON WIRELESS\nDisp Time: 06/25/12 20:31:21
(CAD Page for CFS 062612-1) \nhttp://maps.google.com/maps?q=+41.46590%20-72.67495\nBrush Fire\nHIGGANUM RD and CHERRY LANE\nApt: \nDH       \nCross Streets : MADISON RD * CHERRY LANE \nCaller: \nDisp Time: 06/26/12 00:16:19
(CAD Page for CFS 063012-41) \nhttp://maps.google.com/maps?q=+41.46674%20-72.65959\nElectrical Fire Pole/Wire\n291 HIGGANUM RD\nApt: \nDH       \nCross Streets : TRINITY HILL DR * BEAR ROCK RD \nCaller: VERIZON WIRELESS\nDisp Time: 06/30/12 11:30:15
(CAD Page for CFS 070512-9) \nhttp://maps.google.com/maps?q=+41.49594%20-72.64658\nFire Alarm\n23 CHEYENNE TR\nApt: \nDH       \nCross Streets : ARBUTUS ST \nCaller: early detection\nDisp Time: 07/05/12 07:03:07
(CAD Page for CFS 070712-30) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nPublic Service\nU:OLD JOHNSON LANE AND MILBROOK\nApt: \nMD\nCaller: MD\nDisp Time: 07/07/12 13:36:50
(CAD Page for CFS 070712-87) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nStructure Fire\nU:U:ROUTE 149 AND ROUTE 16\nApt: \n\nCaller: \nDisp Time: 07/08/12 01:23:01

Contact: Active911
Agency name: Old Lyme Ambulance Location: Old Lyme, CT 
Sender: @smtp115.sbc.mail.gq1.yahoo.com

(CAD Page for CFS 062212-75) \nhttp://maps.google.com/maps?q=+41.28611%20-72.27805\nPsychiatric BLS\n63 HARTFORD AVE\nApt: \nOL       \nCross Streets : BOCCE LANE * MARTINO RD \nCaller: \nWater\Info: HLHY 23 HARTFORD AV\n\nDisp Time: 06/22/12 23:37:06
(CAD Page for CFS 062612-31) \nhttp://maps.google.com/maps?q=+41.28835%20-72.27751\nBasic Life Support \n25 SWAN AVE\nApt: \nOL       \nCross Streets : SHORE RD * BOCCE LANE \nCaller: \nWater\Info: HLHY 36 SWAN AV\n\nDisp Time: 06/26/12 12:58:25
(CAD Page for CFS 062612-38) \nhttp://maps.google.com/maps?q=+41.30446%20-72.25576\nBEE STING REACTION\n3 FOX CHASE LANE\nApt: \nOL       \nCross Streets : OAKRIDGE DR \nCaller: \nWater\Info: TSFW56 21 OAKRIDGE @ BOAT LAUNCH\n\nDisp Time: 06/26/12 14:38:18
(CAD Page for CFS 062712-10) \nhttp://maps.google.com/maps?q=+41.34336%20-72.30941\nGENERAL WEAKNESS\n115 SILL LANE\nApt: \nOL\nCross Streets : WILLS RIDGE RD * BOSTON POST RD \nCaller: BISHOP,CRAIG\nDisp Time: 06/27/12 08:14:33
(CAD Page for CFS 062812-39) \nhttp://maps.google.com/maps?q=+41.35931%20-72.29515\nSeizures ALS\n76 GRASSY HILL RD\nApt: \nOL       \nCross Streets : BOSTON POST RD * COACH DR \nCaller: VERIZON WIRELESS\nWater\Info: HLFW38 94 GRASSY HILL @ BOAT LAUNCH\n\nDisp Time: 06/28/12 18:01:46
(CAD Page for CFS 062912-14) \nhttp://maps.google.com/maps?q=+41.30351%20-72.27782\nBasic Life Support \n30 WYCHWOOD RD\nApt: \nOL       \nCross Streets : NOTTINGHAM DR * BROWNS LANE \nCaller: HEAP,JOSEPH C\nWater\Info: TSFW49 20 THOMAS WAITE DR\n\nDisp Time: 06/29/12 10:33:12
(CAD Page for CFS 062912-30) \nhttp://maps.google.com/maps?q=+41.30316%20-72.26485\nALTERED MENTAL STATUS\n285 MILE CREEK RD\nApt: \nOL       \nCross Streets : WOOD RIDGE HILLS RD * CHESTNUT HILL RD \nCaller: \nWater\Info: HLFW53 304 MILE CREEK RD\n\nWater\Info: HLFW75 302 MILE CREEK RD\n\nDisp Time: 06/29/12 12:57:32
(CAD Page for CFS 063012-53) \nhttp://maps.google.com/maps?q=+41.28296%20-72.28382\nSYNCOPE\n5 WEST END DR\nApt: \nOL       \nCross Streets : CENTER BEACH AVE * SIDEWALK LANE \nCaller: GARVIN'S RENTALS\nWater\Info: HLFW63 CISTERN\n\nDisp Time: 06/30/12 12:49:28
(CAD Page for CFS 063012-65) \nhttp://maps.google.com/maps?q=+41.31915%20-72.34690\nMVA Medic ALS\n2 N6970\nApt: \nOL       \nCross Streets : RT9S TO I95N * EXIT 70 NB \nCaller: AT&T MOBILITY\nWater\Info: HLHY BRIDGE * OSFD @ FILL POINT\n\nDisp Time: 06/30/12 14:33:23
(CAD Page for CFS 063012-90) \nhttp://maps.google.com/maps?q=+41.35479%20-72.30378\nBasic Life Support \n54 ROGERS LAKE TR\nApt: \nOL       \nCross Streets : AVON ST * TAMIAMI TR \nCaller: BAKOLEDIS,A\nWater\Info: HLFW40 5 DEVITT LOOP\n\nWater\Info: HLFW74 22 TOWN WOODS RD\n\nDisp Time: 06/30/12 17:36:37
(CAD Page for CFS 063012-103) \nhttp://maps.google.com/maps?q=+41.36244%20-72.29684\nGENERAL WEAKNESS\n55 HICKORY ST\nApt: \nOL\nCross Streets : AVENUE F * AVENUE G \nCaller: WANAT,GEORGE\nDisp Time: 06/30/12 21:09:24
(CAD Page for CFS 070112-44) \nhttp://maps.google.com/maps?q=+41.30718%20-72.29227\nSeizures ALS\n5 FLAT ROCK HILL RD\nApt: \nOL\nCross Streets : MILE CREEK RD * BROWNS LANE \nCaller: PEARSON,MARK & BRENDA\nDisp Time: 07/01/12 15:55:41
(CAD Page for CFS 070112-75) \nhttp://maps.google.com/maps?q=+41.28461%20-72.27786\nUnconcious/Unresponsive ALS\n88 HARTFORD AVE\nApt: \nOL       \nCross Streets : POND RD \nCaller: \nWater\Info: HLHY 23 HARTFORD AV\n\nDisp Time: 07/01/12 17:44:58
(CAD Page for CFS 070212-31) \nhttp://maps.google.com/maps?q=+41.30627%20-72.25845\nInjured Person  BLS\n436 SHORE RD\nApt: 108\nOL       \nCross Streets : MILE CREEK RD * RIVERDALE LANDING \nCaller: VERIZON WIRELESS\nWater\Info: HLFW55 8 BANK RD MARINA\n\nWater\Info: HLFW53 304 MILE CREEK RD\n\nWater\Info: BAYBERRY MOTEL * KNOX BOX * R OF OFFICE DOOR * MASTER KEY FOR ALL ROOMS\n\nDisp Time: 07/02/12 11:33:49
(CAD Page for CFS 070212-32) \nhttp://maps.google.com/maps?q=+41.30123%20-72.27529\nInjured Person  BLS\n3 CHANTICLEER LANE\nApt: \nOL\nCross Streets : WYCHWOOD RD \nCaller: POLLACK,LITA\nDisp Time: 07/02/12 12:16:00
(CAD Page for CFS 070212-37) \nhttp://maps.google.com/maps?q=+41.33535%20-72.31360\nRespiratory Distress ALS\n48 BOSTON POST RD\nApt: \nOL       \nCross Streets : BOGGY HOLE RD * BLACKWELL LANE \nCaller: BARBATO,CHRISTINE\nWater\Info: HLFW30 40 BOSTON POST RD\n\nDisp Time: 07/02/12 13:25:45
(CAD Page for CFS 070412-42) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nBasic Life Support \nhartford av\nApt: \nol\nCaller: \nDisp Time: 07/04/12 14:58:30
(CAD Page for CFS 070412-57) \nhttp://maps.google.com/maps?q=+41.28034%20-72.28979\nInjured Person  BLS\n100 WEST END DR\nApt: \nOL       \nCross Streets : SIDEWALK LANE \nCaller: KAYLIN,WALTER\nWater\Info: HLFW63 CISTERN\n\nDisp Time: 07/04/12 18:20:14
(CAD Page for CFS 070512-31) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nPsychiatric BLS\nOLD SHORE RD\nApt: \nOL\nCaller: CSP\nDisp Time: 07/05/12 11:40:22
(CAD Page for CFS 070512-54) \nhttp://maps.google.com/maps?q=+41.30798%20-72.30020\nPsychiatric BLS\n25 ROWLAND RD\nApt: -1\nOL       \nCross Streets : MILE CREEK RD \nCaller: COOK,RICHARD J\nWater\Info: HLFW32 70 ROWLAND RD\n\nDisp Time: 07/05/12 15:58:07
(CAD Page for CFS 070512-66) \nhttp://maps.google.com/maps?q=+41.34836%20-72.29934\nInjured Person  BLS\n166 BOSTON POST RD\nApt: \nOL\nCross Streets : TOWN WOODS RD * BOUGHTON RD \nCaller: AT&T MOBILITY\nWater\Info: HLFW84 9 BOUGHTON RD\n\nWater\Info: HLFW34 172 BOSTON POST RD\n\nDisp Time: 07/05/12 20:10:31
(CAD Page for CFS 070512-68) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nRespiratory Distress ALS\nHAWKS nest beach rd\nApt: e5\nol\nCaller: \nDisp Time: 07/05/12 20:38:57
(CAD Page for CFS 070512-75) \nhttp://maps.google.com/maps?q=+41.28771%20-72.27810\nChest Pain ALS\n36 HARTFORD AVE\nApt: \nOL       \nCross Streets : SHORE RD * BOCCE LANE \nCaller: PAPPACENO,J\nWater\Info: HLHY 23 HARTFORD AV\n\nDisp Time: 07/05/12 23:32:28
(CAD Page for CFS 070612-8) \nhttp://maps.google.com/maps?q=+41.32356%20-72.32825\nMVA Medic ALS\n1 S7070\nApt: \nOL       \nCross Streets : LYME ST * NECK RD \nCaller: VERIZON WIRELESS\nWater\Info: TSFW50 1 ENTERPRISE DR\n\nDisp Time: 07/06/12 08:12:48
(CAD Page for CFS 070612-12) \nhttp://maps.google.com/maps?q=+41.28749%20-72.27522\nInjured Person  BLS\n33 GORTON AVE\nApt: \nOL       \nCross Streets : BROUGHEL AVE * MAPLE AVE \nCaller: EPSTEIN, ELAINE\nWater\Info: HLHY 34 GORTON AV\n\nDisp Time: 07/06/12 08:34:11
(CAD Page for CFS 070612-22) \nhttp://maps.google.com/maps?q=+41.34414%20-72.30615\nRespiratory Distress ALS\n124 BOSTON POST RD\nApt: \nOL       \nCross Streets : SUNSET DR * APPLE TREE DR \nCaller: EBBETS, MARGARET\nWater\Info: HLFW21 97 SILL LA\n\nDisp Time: 07/06/12 10:20:39
(CAD Page for CFS 070612-32) \nhttp://maps.google.com/maps?q=+41.28270%20-72.30608\nTraumatic Injury ALS\n9 SPRINGFIELD RD\nApt: \nOL       \nCross Streets : HOWARD RD * SEASIDE LANE \nCaller: BRADLEY W PATRICK\nWater\Info: HLFW48 4 GRISWOLD PT\n\nDisp Time: 07/06/12 13:43:39
(CAD Page for CFS 070612-44) \nhttp://maps.google.com/maps?q=+41.30684%20-72.26255\nRespiratory Distress ALS\n2 ASCOT LANE\nApt: \nOL\nCross Streets : CHESTNUT HILL RD \nCaller: KATZ,BARBARA\nDisp Time: 07/06/12 15:06:14
(CAD Page for CFS 070612-90) \nhttp://maps.google.com/maps?q=+41.28541%20-72.28234\nTraumatic Injury ALS\n54 COLUMBUS AVE\nApt: \nOL       \nCross Streets : LIBERTY ST * AVENUE A \nCaller: YOUNG,PAUL\nWater\Info: HLHY 244 SHORE RD\n\nDisp Time: 07/06/12 23:13:15
(CAD Page for CFS 070712-31) \nhttp://maps.google.com/maps?q=+41.28541%20-72.28234\nALTERED MENTAL STATUS\n54 COLUMBUS AVE\nApt: \nOL       \nCross Streets : LIBERTY ST * AVENUE A \nCaller: YOUNG,PAUL\nWater\Info: HLHY 244 SHORE RD\n\nDisp Time: 07/07/12 13:38:33
(CAD Page for CFS 070712-47) \nhttp://maps.google.com/maps?q=+41.32367%20-72.32745\nRespiratory Distress ALS\n85 LYME ST\nApt: \nOL\nCross Streets : HALLS RD * EXIT 70 SB \nCaller: LLC,OPEN OPPORTUNITY\nWater\Info: HLFW10 11 HALLS RD\n\nDisp Time: 07/07/12 15:53:40
(CAD Page for CFS 070912-46) \nhttp://maps.google.com/maps?q=+41.30123%20-72.27529\nLift Assist BLS\n3 CHANTICLEER LANE\nApt: \nOL\nCross Streets : WYCHWOOD RD \nCaller: POLLACK,LITA\nDisp Time: 07/09/12 13:53:24
(CAD Page for CFS 071012-36) \nhttp://maps.google.com/maps?q=+41.32120%20-72.33965\nPsychiatric BLS\n21 NECK RD\nApt: \nOL\nCross Streets : ENTR 70 SB * OLD BRIDGE RD \nCaller: AT&T MOBILITY\nWater\Info: HLFW24 OL MARINA\n\nDisp Time: 07/10/12 13:51:15
(CAD Page for CFS 071012-61) \nhttp://maps.google.com/maps?q=+41.28525%20-72.28076\nHazmat\n60 CORSINO AVE\nApt: \nOL       \nCross Streets : LIBERTY ST * BISCAYNE BLVD \nCaller: TROOP-F\nWater\Info: HLHY S6S SHORE RD\n\nDisp Time: 07/10/12 22:53:16
(CAD Page for CFS 071112-37) \nhttp://maps.google.com/maps?q=+41.28551%20-72.27319\nInjured Person  BLS\n59 SALTAIRE DR\nApt: \nOL       \nCross Streets : BELLAIRE RD * SEA LANE \nCaller: MARSHALL,JAMES R\nWater\Info: HLHY 70 SEASPRAY RD\n\nDisp Time: 07/11/12 12:58:30
(CAD Page for CFS 071112-39) \nhttp://maps.google.com/maps?q=+41.30741%20-72.25650\nAdvanced Life Support\n445 SHORE RD\nApt: \nOL       \nCross Streets : RIVERDALE LANDING * RIVER RD \nCaller: csp\nWater\Info: HLFW55 8 BANK RD MARINA\n\nWater\Info: HLFW53 304 MILE CREEK RD\n\nDisp Time: 07/11/12 13:37:00
(CAD Page for CFS 071112-60) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nMarine Rescue\nCT RIVER MARKER 7\nApt: \nOL\nCaller: OLD SAYBROOK\nDisp Time: 07/11/12 20:48:21
(CAD Page for CFS 071112-66) \nhttp://maps.google.com/maps?q=+41.29445%20-72.25405\nAdvanced Life Support\n53 HILLCREST RD\nApt: \nOL       \nCross Streets : SARGENT RD * CARRINGTON RD \nCaller: VERIZON WIRELESS\nWater\Info: TSFW57 BOAT BASIN\n\nDisp Time: 07/11/12 23:53:52
(CAD Page for CFS 071212-17) \nhttp://maps.google.com/maps?q=+41.28875%20-72.27919\nFall 10  -ALS\n18 PORTLAND AVE\nApt: \nOL       \nCross Streets : SHORE RD * BOCCE LANE \nCaller: \nWater\Info: HLHY 51 PORTLAND AV\n\nDisp Time: 07/12/12 09:57:25
(CAD Page for CFS 071212-35) \nhttp://maps.google.com/maps?q=+41.33588%20-72.31274\nAdvanced Life Support\n58 BOSTON POST RD\nApt: \nOL       \nCross Streets : BOGGY HOLE RD * BLACKWELL LANE \nCaller: VERIZON WIRELESS\nWater\Info: HLFW30 40 BOSTON POST RD\n\nDisp Time: 07/12/12 13:22:33
(CAD Page for CFS 071312-12) \nhttp://maps.google.com/maps?q=+41.34942%20-72.28587\nAdvanced Life Support\n249 BOSTON POST RD\nApt: 1\nOL       \nCross Streets : LORDS MEADOW LANE * LYMEWOOD HOUSING \nCaller: CANCRO,CARMINE\nWater\Info: HLFW35 245 BOSTON POST RD\n\nWater\Info: LYMEWOOD HOUSING * 1ST BLDG ON LEFT * KNOX BOX TO RIGHT OF FRONT DOOR\n\nDisp Time: 07/13/12 07:34:26
(CAD Page for CFS 071312-32) \nhttp://maps.google.com/maps?q=+41.31145%20-72.40325\nStructure Fire\n1 PHEASANT HILL LANE\nApt: \nOS       \nCross Streets : INGHAM HILL RD * WILD APPLE LANE \nCaller: VERIZON WIRELESS\nDisp Time: 07/13/12 11:53:06
(CAD Page for CFS 071312-40) \nhttp://maps.google.com/maps?q=+41.34791%20-72.34145\nSeizures ALS\n17 COULT LANE\nApt: \nOL       \nCross Streets : NECK RD * TANTUMMAHEAG RD \nCaller: GEIST,MICHELE\nWater\Info: TSFW72 10 TANTUMMAHEAG RD\n\nDisp Time: 07/13/12 13:02:27
(CAD Page for CFS 071312-65) \nhttp://maps.google.com/maps?q=+41.29526%20-72.25557\nSeizures ALS\n33 HILLCREST RD\nApt: \nOL       \nCross Streets : CONNECTICUT RD * OAK RD \nCaller: BERG,IRENE W\nWater\Info: TSFW57 BOAT BASIN\n\nDisp Time: 07/13/12 19:33:06
(CAD Page for CFS 071312-68) \nhttp://maps.google.com/maps?q=+41.28572%20-72.28076\nChest Pain ALS\n54 CORSINO AVE\nApt: \nOL\nCross Streets : LIBERTY ST * BISCAYNE BLVD \nCaller: SCHMIDT,EDWARD L\nDisp Time: 07/13/12 20:18:46
(CAD Page for CFS 071412-5) \nhttp://maps.google.com/maps?q=+41.31332%20-72.33125\nRespiratory Distress ALS\n9 LYME ST\nApt: 1A\nOL\nCross Streets : FERRY RD * ACADEMY LANE \nCaller: MC*NEMER,P HASTINGS\nDisp Time: 07/14/12 07:47:42
(CAD Page for CFS 071412-11) \nhttp://maps.google.com/maps?q=+41.28548%20-72.29464\nAbdominal Pain BLS\n9 HAYWAGON DR\nApt: \nOL       \nCross Streets : SHORE RD * CORD GRASS LANE \nCaller: MAZZOTTA, JOHN\nWater\Info: HLHY 11 HAYWAGON DR\n\nDisp Time: 07/14/12 09:37:42
(CAD Page for CFS 071412-79) \nhttp://maps.google.com/maps?q=+41.28034%20-72.28993\nCardiac Arrest ALS\n102 WEST END DR\nApt: \nOL       \nCross Streets : SIDEWALK LANE \nCaller: MONKS, WILLIAM\nWater\Info: HLFW63 CISTERN\n\nDisp Time: 07/14/12 20:56:51
(CAD Page for CFS 071512-13) \nhttp://maps.google.com/maps?q=+41.36070%20-72.29430\nInjured Person  BLS\n5 COACH DR\nApt: \nOL       \nCross Streets : GRASSY HILL RD \nCaller: AT&T MOBILITY\nWater\Info: HLFW38 94 GRASSY HILL RD\n\nDisp Time: 07/15/12 03:57:55
(CAD Page for CFS 071512-16) \nhttp://maps.google.com/maps?q=+41.30798%20-72.33295\nMVA Medic ALS\n22 SHORE RD\nApt: \nOL       \nCross Streets : FERRY RD * AMTRAK \nCaller: VERIZON WIRELESS\nWater\Info: HLFW07 300 FERRY RD\n\nDisp Time: 07/15/12 08:10:45
(CAD Page for CFS 071512-25) \nhttp://maps.google.com/maps?q=+41.28534%20-72.27652\nInjured Person  BLS\n69 OLD COLONY RD\nApt: \nOL       \nCross Streets : PURTILL AVE * HARTUNG PL \nCaller: \nWater\Info: HLHY 59 OLD COLONY\n\nDisp Time: 07/15/12 09:46:44\n\n\n

Agency name: Chester Hose Co. Location: Chester, CT 
Sender: @smtp107.sbc.mail.mud.yahoo.com,LogiSYS CAD

(CAD Page for CFS 062612-35) \nhttp://maps.google.com/maps?q=+41.40815%20-72.44095\nLife Call -Medical Alarm\n101 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : OLD DEPOT RD * GROTE RD \nCaller: MEDICAL ALARM\nWater\Info: Hydrant: 103 Mx Ave\nHydrant: 77 Mx Ave\nHydrant: Mx Ave/Grote Rd\n\nDisp Time: 06/26/12 14:06:39
(CAD Page for CFS 062612-50) \nhttp://maps.google.com/maps?q=+41.42297%20-72.44717\nPsychiatric BLS\n218 MIDDLESEX AVE\nApt: D22\nCH       \nCross Streets : CASTLE VIEW DR * DENLAR DR \nCaller: \nWater\Info: Hydrant: Mx Ave at shopping Center\nHydrant: Mx Ave (opp Castle View)\n\nDisp Time: 06/26/12 16:40:03
(CAD Page for CFS 062612-54) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nInjured Person  BLS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 06/26/12 18:25:39
(CAD Page for CFS 062612-56) \nhttp://maps.google.com/maps?q=+41.40794%20-72.51049\nFire Alarm\n87 CEDAR LAKE RD\nApt: \nCH       \nCross Streets : DAVID RD * JENNINGS POND RD \nCaller: ADT\nWater\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\nBoat launch, end of Bishop Road\n\nDisp Time: 06/26/12 19:05:07
(CAD Page for CFS 062612-67) \nhttp://maps.google.com/maps?q=+41.39946%20-72.47517\nGENERAL WEAKNESS\n3 S WIG HILL RD\nApt: 41\nCH       \nCross Streets : W MAIN ST * TURKEY HILL RD \nCaller: HEALTH MGMT,RYDERS\nWater\Info: Standpipe: West Main St/Hoopole Hill\nPond: South Wig/Wig Hill Rd\n\nDisp Time: 06/26/12 20:39:41
(CAD Page for CFS 062712-26) \nhttp://maps.google.com/maps?q=+41.38833%20-72.52768\nFire Alarm\n317 W MAIN ST\nApt: 14\nCH       \nCross Streets : BUTTER JONES RD * ROUTE 148 \nCaller: usa central\nWater\Info: Draft from Cedar Lake\n\nDisp Time: 06/27/12 11:15:30
(CAD Page for CFS 062712-60) \nhttp://maps.google.com/maps?q=+41.39896%20-72.46510\nWires Down -Call NU\n100 W MAIN ST\nApt: \nCH       \nCross Streets : SPRING ST * INSPIRATION LANE \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: 82 West Main\nWaterhole: West Main/Hoopole Hill\n\nDisp Time: 06/27/12 17:12:38
(CAD Page for CFS 062912-6) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nGENERAL WEAKNESS\n268 MIDDLESEX AVE\nApt: 1\nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: VZWU\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 06/29/12 07:50:36
(CAD Page for CFS 062912-43) \nhttp://maps.google.com/maps?q=+41.40970%20-72.44025\nMinor MVA -No Medic\nGROTE RD and MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GROTE RD \nCaller: \nDisp Time: 06/29/12 16:15:27
(CAD Page for CFS 063012-98) \nhttp://maps.google.com/maps?q=+41.39946%20-72.47517\nFire Alarm\n3 S WIG HILL RD\nApt: \nCH       \nCross Streets : W MAIN ST * TURKEY HILL RD \nCaller: USA Central\nWater\Info: Standpipe: West Main St/Hoopole Hill\nPond: South Wig/Wig Hill Rd\n\nDisp Time: 06/30/12 20:36:10
(CAD Page for CFS 070112-20) \nhttp://maps.google.com/maps?q=+41.40086%20-72.44209\nUnconcious/Unresponsive ALS\n48 MIDDLESEX AVE\nApt: \nCH\nCross Streets : PRATT ST * RAILROAD AVE \nCaller: SAYBROOK AT HADDAM,THE\nWater\Info: Hydrant: Mx Ave/Main St\nHydrant: 37 Mx Ave (north of Gilbert Hill)\nHydrant: 77 Mx Ave\n\nDisp Time: 07/01/12 11:23:14
(CAD Page for CFS 070112-34) \nhttp://maps.google.com/maps?q=+41.40936%20-72.42899\nDrowning ALS\n61 DOCK RD\nApt: \nCH\nCross Streets : VALLEY RAILROAD \nCaller: \nWater\Info: Hydrant: in front of Cozy Castle\nDraft from Connecticut River\n\nDisp Time: 07/01/12 13:45:55
(CAD Page for CFS 070312-17) \nhttp://maps.google.com/maps?q=+41.40690%20-72.43349\nPolice General\n60 RAILROAD AVE\nApt: \nCH       \nCross Streets : VALLEY RAILROAD \nCaller: SPRINT NEXTEL - IDEN\nWater\Info: Hydrant: 60 Railroad Ave (Ch. Auto/Marine)\nConnecticut River, end of Railroad Ave\n\nDisp Time: 07/03/12 08:48:29
(CAD Page for CFS 070312-28) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nAbdominal Pain ALS\n268 MIDDLESEX AVE\nApt: \nCH\nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/03/12 11:13:01
(CAD Page for CFS 070412-4) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nInjured Person  BLS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/04/12 02:50:29
(CAD Page for CFS 070412-18) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nSYNCOPE\nMain at the market\nApt: \nch\nCaller: \nDisp Time: 07/04/12 10:36:58
(CAD Page for CFS 070412-45) \nhttp://maps.google.com/maps?q=+41.40903%20-72.51273\nOverdose ALS\n99 CEDAR LAKE RD\nApt: \nCH       \nCross Streets : DAVID RD * JENNINGS POND RD \nCaller: FIXED ATTMO 8006356840 O\nWater\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\nBoat launch, end of Bishop Road\n\nDisp Time: 07/04/12 16:05:07
(CAD Page for CFS 070412-49) \nhttp://maps.google.com/maps?q=+41.42297%20-72.44717\nBasic Life Support \n218 MIDDLESEX AVE\nApt: C14\nCH\nCross Streets : CASTLE VIEW DR * DENLAR DR \nCaller: LANE,FRANCES\nDisp Time: 07/04/12 16:52:25
(CAD Page for CFS 070512-33) \nhttp://maps.google.com/maps?q=+41.38551%20-72.45010\nMVA Medic ALS\n1 S65\nApt: \nCH     \nCross Streets : EXIT 5 SB * ENTR 5 SB \nCaller: T-Mobile, USA\nDisp Time: 07/05/12 11:50:22
(CAD Page for CFS 070512-63) \nhttp://maps.google.com/maps?q=+41.40527%20-72.50705\nInjured Person  BLS\nCEDAR LAKE RD and DAVID RD\nApt: \nCH       \nCross Streets : CEDAR LAKE RD * BROOKSIDE RD \nCaller: car 7\nDisp Time: 07/05/12 19:04:43
(CAD Page for CFS 070612-28) \nhttp://maps.google.com/maps?q=+41.42839%20-72.45273\nFire Alarm\n136 GOOSE HILL RD\nApt: \nCH       \nCross Streets : OLD COUNTY RD * MIDDLESEX AVE \nCaller: adt op ogm\nWater\Info: Standpipe: 104 Goose, south end of pond\nBoat launch, end of Parkers Point La\n\nDisp Time: 07/06/12 12:44:32
(CAD Page for CFS 070612-43) \nhttp://maps.google.com/maps?q=+41.40156%20-72.50703\nGENERAL SICKNESS\n21 LAUREL ST\nApt: \nCH       \nCross Streets : CEDAR ST \nCaller: REDAK,HARVEY & JUSTINE\nWater\Info: Standpipe: Cedar Lake opp Birch St\n\nDisp Time: 07/06/12 15:05:35
(CAD Page for CFS 070712-35) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nBasic Life Support \n268 MIDDLESEX AVE\nApt: \nCH\nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/07/12 14:09:22
(CAD Page for CFS 070812-52) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nAbdominal Pain BLS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/08/12 17:19:37
(CAD Page for CFS 070812-72) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nGENERAL SICKNESS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/08/12 21:12:30
(CAD Page for CFS 070912-8) \nhttp://maps.google.com/maps?q=+41.42031%20-72.44348\nChest Pain ALS\n57 CASTLE VIEW DR\nApt: \nCH\nCross Streets : KIRTLAND AVE * MIDDLESEX AVE \nCaller: COOK,WILLIAM\nDisp Time: 07/09/12 07:20:58
(CAD Page for CFS 070912-21) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nAbdominal Pain BLS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/09/12 10:47:44
(CAD Page for CFS 070912-26) \nhttp://maps.google.com/maps?q=+41.41022%20-72.46832\nInjured Person  BLS\n34 DEEP HOLLOW RD\nApt: \nCH       \nCross Streets : WIG HILL RD \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: Deep Hollow/Liberty\n\nDisp Time: 07/09/12 11:31:58
(CAD Page for CFS 071012-2) \nhttp://maps.google.com/maps?q=+41.40470%20-72.45490\nCardiac Arrest ALS\n3 RIDGE RD\nApt: \nCH       \nCross Streets : HIGH ST * JOHNSON RD \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: Ridge Rd/High St\nHydrant: 17 Ridge Rd\n\nDisp Time: 07/10/12 00:42:31
(CAD Page for CFS 071012-26) \nhttp://maps.google.com/maps?q=+41.42352%20-72.45718\nFire Alarm\n13 HIGH FIELD LANE\nApt: \nCH       \nCross Streets : GOOSE HILL RD \nCaller: alarm systems inc op 897\nWater\Info: Standpipe: 104 Goose, south end of pond\n\nDisp Time: 07/10/12 10:41:35
(CAD Page for CFS 071012-28) \nhttp://maps.google.com/maps?q=+41.38834%20-72.50771\nTraumatic Injury ALS\n51 WINTHROP RD\nApt: \nCH       \nCross Streets : PINE KNOLL DR * AVIATION DR \nCaller: WHELEN ENGINEERING CO\nWater\Info: Standpipe: pond at Whelen\n\nWater\Info: Draft from Cedar Lake\nStandpipe: pond at Whelen\n\nDisp Time: 07/10/12 10:58:49
(CAD Page for CFS 071012-59) \nhttp://maps.google.com/maps?q=+41.42204%20-72.49747\nAdvanced Life Support\n2 N78\nApt: \nCH       \nCross Streets : ENTR 7 NB * TURKEY HILL RD \nCaller: VERIZON WIRELESS\nDisp Time: 07/10/12 22:34:14
(CAD Page for CFS 071112-45) \nhttp://maps.google.com/maps?q=+41.38973%20-72.43520\nPsychiatric BLS\n8 READ ST\nApt: c\nDR\nCross Streets : PROSPECT ST * KIRTLAND ST \nCaller: SCRIVEN,DAVID,A\nDisp Time: 07/11/12 14:55:08
(CAD Page for CFS 071112-53) \nhttp://maps.google.com/maps?q=+41.38834%20-72.50771\nInjured Person  BLS\n51 WINTHROP RD\nApt: \nCH       \nCross Streets : PINE KNOLL DR * AVIATION DR \nCaller: WHELEN ENGINEERING CO\nWater\Info: Standpipe: pond at Whelen\n\nWater\Info: Draft from Cedar Lake\nStandpipe: pond at Whelen\n\nDisp Time: 07/11/12 16:59:51
(CAD Page for CFS 071112-64) \nhttp://maps.google.com/maps?q=+41.42297%20-72.44717\nLife Call -Medical Alarm\n218 MIDDLESEX AVE\nApt: A1\nCH       \nCross Streets : CASTLE VIEW DR * DENLAR DR \nCaller: LINK TO LIFE\nWater\Info: Hydrant: Mx Ave at shopping Center\nHydrant: Mx Ave (opp Castle View)\n\nDisp Time: 07/11/12 22:59:58
(CAD Page for CFS 071212-9) \nhttp://maps.google.com/maps?q=+41.39946%20-72.47517\nFire Alarm\n3 S WIG HILL RD\nApt: \nCH       \nCross Streets : W MAIN ST * TURKEY HILL RD \nCaller: usa centeral\nWater\Info: Standpipe: West Main St/Hoopole Hill\nPond: South Wig/Wig Hill Rd\n\nDisp Time: 07/12/12 08:06:48
(CAD Page for CFS 071212-13) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nPsychiatric BLS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/12/12 08:49:35
(CAD Page for CFS 071212-30) \nhttp://maps.google.com/maps?q=+41.39948%20-72.47023\nMinor MVA -No Medic\n129 W MAIN ST\nApt: \nCH       \nCross Streets : SPRING ST * INSPIRATION LANE \nCaller: SPRINTPCS\nWater\Info: Waterhole: West Main/Hoopole Hill\n\nDisp Time: 07/12/12 11:57:46
(CAD Page for CFS 071212-40) \nhttp://maps.google.com/maps?q=+41.38994%20-72.43497\nPsychiatric BLS\n12 READ ST\nApt: C\nDR       \nCross Streets : PROSPECT ST * KIRTLAND ST \nCaller: MOBILE CRISIS * KATHY\nWater\Info: CORNER KIRTLAND & READ\n\nDisp Time: 07/12/12 14:46:07
(CAD Page for CFS 071212-68) \nhttp://maps.google.com/maps?q=+41.37923%20-72.55943\nStructure Fire\n42 SWAN LAKE TR\nApt: \nKW\nCross Streets : BRIDLE PATH TR * BOULDER TR \nCaller: DAIGLE,GEORGE A\nDisp Time: 07/12/12 20:27:26
(CAD Page for CFS 071212-69) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nALTERED MENTAL STATUS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/12/12 20:44:39
(CAD Page for CFS 071312-53) \nhttp://maps.google.com/maps?q=+41.38833%20-72.52768\nLift Assist BLS\n317 W MAIN ST\nApt: 6203\nCH\nCross Streets : BUTTER JONES RD * ROUTE 148 \nCaller: CHESTER VILLAGE WEST\nDisp Time: 07/13/12 16:39:45
(CAD Page for CFS 071312-60) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nALTERED MENTAL STATUS\n132 MAIN ST\nApt: 2\nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/13/12 18:53:31
(CAD Page for CFS 071312-69) \nhttp://maps.google.com/maps?q=+41.39629%20-72.45059\nGENERAL SICKNESS\n69 MAPLE ST\nApt: \nCH\nCross Streets : PROSPECT ST * STRAITS RD \nCaller: CROMARTY,JOHN & ANN\nDisp Time: 07/13/12 20:31:33
(CAD Page for CFS 071412-43) \nhttp://maps.google.com/maps?q=+41.40640%20-72.47694\nChest Pain ALS\n56 WIG HILL RD\nApt: \nCH       \nCross Streets : N67 * S76 \nCaller: SPRINTPCS\nWater\Info: Standpipe: Wig Hill/South Wig\n\nWater\Info: Hydrant: Deep Hollow/Liberty St\nStandpipe: Wig Hill/South Wig\n\nDisp Time: 07/14/12 14:46:18
(CAD Page for CFS 071412-80) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nALTERED MENTAL STATUS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: SLEEPER,E\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/14/12 21:04:41
(CAD Page for CFS 071412-82) \nhttp://maps.google.com/maps?q=+41.40732%20-72.46606\nElectrical Fire Pole/Wire\n15 WIG HILL RD\nApt: \nCH       \nCross Streets : PLEASANT ST * N67 \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: Deep Hollow/Liberty St\nStandpipe: Wig Hill/South Wig\n\nDisp Time: 07/14/12 21:39:44
(CAD Page for CFS 071512-3) \nhttp://maps.google.com/maps?q=+41.40681%20-72.43185\nInjured Person  BLS\n72 RAILROAD AVE\nApt: \nCH       \nCross Streets : VALLEY RAILROAD \nCaller: \nWater\Info: Hydrant: 60 Railroad Ave (Ch. Auto/Marine)\nConnecticut River, end of Railroad Ave\n\nDisp Time: 07/15/12 00:19:03
(CAD Page for CFS 071512-50) \nhttp://maps.google.com/maps?q=+41.41271%20-72.41878\nMarine Rescue\n54 SELDEN RD\nApt: \nLY\nCross Streets : JOSHUATOWN RD \nCaller: \nDisp Time: 07/15/12 17:34:41
(CAD Page for CFS 071512-60) \nhttp://maps.google.com/maps?q=+41.38833%20-72.52768\nInjured Person  BLS\n317 W MAIN ST\nApt: 5101\nCH\nCross Streets : BUTTER JONES RD * ROUTE 148 \nCaller: CHESTER VILLAGE WEST\nDisp Time: 07/15/12 21:00:50
(CAD Page for CFS 071612-7) \nhttp://maps.google.com/maps?q=+41.40586%20-72.50800\nElectrical Fire Pole/Wire\n75 CEDAR LAKE RD\nApt: \nCH       \nCross Streets : DAVID RD * JENNINGS POND RD \nCaller: HAMILTON,ROBERT\nWater\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\nBoat launch, end of Bishop Road\n\nDisp Time: 07/16/12 06:24:20
(CAD Page for CFS 071712-67) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nInjured Person  BLS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/17/12 18:21:10
(CAD Page for CFS 071812-28) \nhttp://maps.google.com/maps?q=+41.39415%20-72.51026\nMinor MVA -No Medic\n250 W MAIN ST\nApt: \nCH       \nCross Streets : WINTHROP RD * SYPHER RD \nCaller: ATTMO\nWater\Info: Draft from Cedar Lake\n\nDisp Time: 07/18/12 13:43:58
(CAD Page for CFS 071812-36) \nhttp://maps.google.com/maps?q=+41.42893%20-72.45178\nPsychiatric BLS\n268 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : GOOSE HILL RD * SAYBROOK RD \nCaller: EAGLE LANDING\nWater\Info: Boat launch, end of Parkers Point La\n\nDisp Time: 07/18/12 14:56:46
(CAD Page for CFS 071812-60) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nLOW BLOOD PRESSURE\n132 MAIN ST\nApt: 2\nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/18/12 20:33:15
(CAD Page for CFS 071912-17) \nhttp://maps.google.com/maps?q=+41.38833%20-72.52768\nGENERAL SICKNESS\n317 W MAIN ST\nApt: 1007\nCH       \nCross Streets : BUTTER JONES RD * ROUTE 148 \nCaller: CHESTER VILLAGE WEST\nWater\Info: Draft from Cedar Lake\n\nDisp Time: 07/19/12 09:52:21
(CAD Page for CFS 072012-50) \nhttp://maps.google.com/maps?q=+41.45723%20-72.52968\nMVA Medic ALS\n2 N89\nApt: \nHD       \nCross Streets : BEAVER MEADOW RD * ENTR 8 NB \nCaller: VERIZON WIRELESS\nDisp Time: 07/20/12 18:27:33
(CAD Page for CFS 072112-10) \nhttp://maps.google.com/maps?q=+41.39529%20-72.47178\nRespiratory Distress ALS\n23 HOOP POLE HILL RD\nApt: \nCH       \nCross Streets : W MAIN ST * PINNACLE LANE \nCaller: DEROO, ROBERT\nWater\Info: Waterhole: West Main/Hoophole Hill\nWaterhole: West Main/West Wig Hill\n\nDisp Time: 07/21/12 07:17:36
(CAD Page for CFS 072112-39) \nhttp://maps.google.com/maps?q=+41.39946%20-72.47517\nAdvanced Life Support\n3 S WIG HILL RD\nApt: \nCH       \nCross Streets : W MAIN ST * TURKEY HILL RD \nCaller: HEALTH MGMT,RYDERS\nWater\Info: Standpipe: West Main St/Hoopole Hill\nPond: South Wig/Wig Hill Rd\n\nDisp Time: 07/21/12 14:31:19
(CAD Page for CFS 072212-28) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nInjured Person  BLS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/22/12 10:53:45
(CAD Page for CFS 072212-28) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nALTERED MENTAL STATUS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/22/12 10:53:45
(CAD Page for CFS 072212-51) \nhttp://maps.google.com/maps?q=+41.40673%20-72.43442\nBasic Life Support \nRAILROAD AVE and GROTE RD\nApt: \nCH       \nCross Streets : MARINA VIEW DR * GROTE RD \nCaller: \nDisp Time: 07/22/12 14:05:50
(CAD Page for CFS 072312-13) \nhttp://maps.google.com/maps?q=+41.39405%20-72.46024\nChest Pain ALS\n41 BOKUM RD\nApt: \nCH       \nCross Streets : GORHAM RD * W BRIDGE ST \nCaller: MARVIN, SALLY\nWater\Info: Hydrant: Bokum Road/West Main\nHydrant: W Bridge St/W Bridge La, DR\n\nDisp Time: 07/23/12 08:06:52
(CAD Page for CFS 072312-42) \nhttp://maps.google.com/maps?q=+41.40202%20-72.44430\nInjured Person  BLS\n132 MAIN ST\nApt: \nCH       \nCross Streets : SCHOOL LANE * MIDDLESEX AVE \nCaller: CHESTERFIELDS HEALTH CAR\nWater\Info: Hydrant: Main St, west of School La\nHydrant: Main St, in front of Chesterfield's\nHydrant: Main St/Mx Av\n\nDisp Time: 07/23/12 16:28:23
(CAD Page for CFS 072312-67) \nhttp://maps.google.com/maps?q=+41.40302%20-72.45104\nInjured Person  BLS\n1 MAIN ST\nApt: \nCH       \nCross Streets : WATER ST * SPRING ST \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: Main/Water Streets\nHydrant: Main/Maple Streets\n\nDisp Time: 07/23/12 19:50:40
(CAD Page for CFS 072412-36) \nhttp://maps.google.com/maps?q=+41.41880%20-72.44481\nUnconcious/Unresponsive ALS\n189 MIDDLESEX AVE\nApt: \nCH       \nCross Streets : KINGS HWY * CASTLE VIEW DR \nCaller: VERIZON WIRELESS\nWater\Info: Hydrant: Mx Ave/Kings Hwy\nHydrant: Mx Ave at shopping Center\n\nDisp Time: 07/24/12 12:50:07
(CAD Page for CFS 072412-39) \nhttp://maps.google.com/maps?q=+41.40600%20-72.44194\nPsychiatric BLS\n86 MIDDLESEX AVE\nApt: \nCH\nCross Streets : OLD DEPOT RD * GROTE RD \nCaller: GATEWAY COMMUNITY TREATM\nDisp Time: 07/24/12 13:30:12
(CAD Page for CFS 072412-41) \nhttp://maps.google.com/maps?q=+41.38834%20-72.50771\nHIGH BLOOD PRESSURE\n51 WINTHROP RD\nApt: \nCH       \nCross Streets : PINE KNOLL DR * AVIATION DR \nCaller: WHELEN ENGINEERING CO\nWater\Info: Standpipe: pond at Whelen\n\nWater\Info: Draft from Cedar Lake\nStandpipe: pond at Whelen\n\nDisp Time: 07/24/12 13:41:49

Contact: Active911
Agency name: Westbrook Fire Dept Location: Westbrook, CT 
Sender: LogiSYS@smtp114.sbc.mail.ne1.yahoo.com, CAD@smtp114.sbc.mail.ne1.yahoo.com
  
(CAD Page for CFS 091312-46) Reference\nTANKER 463 IN SERVICE\nApt: \nWB\nCaller: 411\nDisp Time: 09/13/12 13:55:28\n\nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000
(CAD Page for CFS 091312-71) Respiratory Distress ALS\n1 S6564\nApt: \nWB       \nCross Streets : ESSEX RD * ENTR 65 SB \nCaller: \nDisp Time: 09/13/12 20:01:59\n\nhttp://maps.google.com/maps?q=+41.29185%20-72.44573
(CAD Page for CFS 091312-83) Bleeding ALS -Arterial\n97 SEASIDE AVE\nApt: \nWB       \nCross Streets : PERIGEE LANE * APOGEE LANE \nCaller: TIDELAWN MANOR/REST HOME\nDisp Time: 09/13/12 22:14:34\n\nhttp://maps.google.com/maps?q=+41.28008%20-72.45554
(CAD Page for CFS 091412-35) SYNCOPE\n10 OAK DR\nApt: \nWB       \nCross Streets : LILAC LANE \nCaller: ROONEY,BARBARA\nDisp Time: 09/14/12 15:26:22\n\nhttp://maps.google.com/maps?q=+41.27655%20-72.48555
(CAD Page for CFS 091412-47) Traumatic Injury ALS\n156 MC VEAGH RD\nApt: \nWB       \nCross Streets : WILLARD AVE * MEETINGHOUSE LANE \nCaller: VERIZON WIRELESS\nDisp Time: 09/14/12 17:04:08\n\nhttp://maps.google.com/maps?q=+41.29750%20-72.45377
(CAD Page for CFS 091512-5) SYNCOPE\n54 EDGEWOOD DR\nApt: \nWB       \nCross Streets : CROSS RD * MAL A BAR DR \nCaller: AXELROD,MICHAEL\nDisp Time: 09/15/12 01:43:28\n\nhttp://maps.google.com/maps?q=+41.33231%20-72.49024

*/

public class CTMiddlesexCountyParserTest extends BaseParserTest {
  
  public CTMiddlesexCountyParserTest() {
    setParser(new CTMiddlesexCountyParser(), "MIDDLESEX COUNTY", "CT");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(DURHAM FIRE CALL CAD Page for CFS 061312-31) \n" +
        "http://maps.google.com/maps?q=+41.48618%20-72.65719\n" +
        "Fire Alarm\n" +
        "18 WEATHERVANE HILL\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE \n" +
        "Caller: ADT OP YSG\n" +
        "Disp Time: 06/13/12 11:36:52",

        "ID:061312-31",
        "GPS:+41.48618 -72.65719",
        "CALL:Fire Alarm",
        "ADDR:18 WEATHERVANE HILL",
        "CITY:DURHAM",
        "X:MAIDEN LANE",
        "NAME:ADT OP YSG",
        "DATE:06/13/12",
        "TIME:11:36:52");

    doTest("T2",
        "(DURHAM FIRE CALL CAD Page for CFS 061312-47) \n" +
        "http://maps.google.com/maps?q=+41.44852%20-72.70119\n" +
        "Fire Alarm\n" +
        "471 NEW HAVEN RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : SAW MILL RD * CANTERBURY DR \n" +
        "Caller: \n" +
        "Disp Time: 06/13/12 18:03:43",

        "ID:061312-47",
        "GPS:+41.44852 -72.70119",
        "CALL:Fire Alarm",
        "ADDR:471 NEW HAVEN RD",
        "CITY:DURHAM",
        "X:SAW MILL RD & CANTERBURY DR",
        "DATE:06/13/12",
        "TIME:18:03:43");

    doTest("T3",
        "(DURHAM FIRE CALL CAD Page for CFS 061412-5) \n" +
        "http://maps.google.com/maps?q=+41.48025%20-72.66325\n" +
        "Unconcious/Unresponsive ALS\n" +
        "MAIDEN LANE and BEAR ROCK RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : SYCAMORE DR * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/14/12 04:22:21",

        "ID:061412-5",
        "GPS:+41.48025 -72.66325",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:MAIDEN LANE and BEAR ROCK RD",
        "MADDR:MAIDEN LANE & BEAR ROCK RD",
        "CITY:DURHAM",
        "X:SYCAMORE DR & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/14/12",
        "TIME:04:22:21");

    doTest("T4",
        "(CAD Page for CFS 061512-51) \n" +
        "http://maps.google.com/maps?q=+41.43734%20-72.71928\n" +
        "Fire Alarm\n" +
        "809 NEW HAVEN RD\n" +
        "Apt: -R\n" +
        "DH       \n" +
        "Cross Streets : COE RD * FORLINE RD \n" +
        "Caller: \n" +
        "Water\\Info: SEND EMS NON-EMERGENCY ON FIRE ALARMS AT THIS LOCATION\n\n" +
        "Disp Time: 06/15/12 15:35:55",

        "ID:061512-51",
        "GPS:+41.43734 -72.71928",
        "CALL:Fire Alarm",
        "ADDR:809 NEW HAVEN RD",
        "APT:-R",
        "CITY:DURHAM",
        "X:COE RD & FORLINE RD",
        "DATE:06/15/12",
        "TIME:15:35:55");

    doTest("T5",
        "(CAD Page for CFS 062012-32) \n" +
        "http://maps.google.com/maps?q=+41.48282%20-72.68172\n" +
        "Minor MVA -No Medic\n" +
        "310 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE * TALCOTT LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/20/12 12:24:24",

        "ID:062012-32",
        "GPS:+41.48282 -72.68172",
        "CALL:Minor MVA -No Medic",
        "ADDR:310 MAIN ST",
        "CITY:DURHAM",
        "X:MAIDEN LANE & TALCOTT LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:06/20/12",
        "TIME:12:24:24");

    doTest("T6",
        "(CAD Page for CFS 062112-63) \n" +
        "http://maps.google.com/maps?q=+41.47446%20-72.68228\n" +
        "MVA Medic ALS\n" +
        "68 MAPLE AVE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : JOHNS WAY * OLD CEMETERY RD \n" +
        "Caller: SPRINTPCS\n" +
        "Disp Time: 06/21/12 17:22:22",

        "ID:062112-63",
        "GPS:+41.47446 -72.68228",
        "CALL:MVA Medic ALS",
        "ADDR:68 MAPLE AVE",
        "CITY:DURHAM",
        "X:JOHNS WAY & OLD CEMETERY RD",
        "NAME:SPRINTPCS",
        "DATE:06/21/12",
        "TIME:17:22:22");

    doTest("T7",
        "(CAD Page for CFS 062212-43) \n" +
        "http://maps.google.com/maps?q=+41.47400%20-72.68024\n" +
        "Minor MVA -No Medic\n" +
        "154 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : FOWLER AVE * OLD CEMETERY RD \n" +
        "Caller: \n" +
        "Disp Time: 06/22/12 15:48:27",

        "ID:062212-43",
        "GPS:+41.47400 -72.68024",
        "CALL:Minor MVA -No Medic",
        "ADDR:154 MAIN ST",
        "CITY:DURHAM",
        "X:FOWLER AVE & OLD CEMETERY RD",
        "DATE:06/22/12",
        "TIME:15:48:27");

    doTest("T8",
        "(CAD Page for CFS 062312-10) \n" +
        "http://maps.google.com/maps?q=+41.47818%20-72.68108\n" +
        "Minor MVA -No Medic\n" +
        "MAIN ST and WALLINGFORD RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WALLINGFORD RD * MAIDEN LANE \n" +
        "Caller: \n" +
        "Disp Time: 06/23/12 07:42:19",

        "ID:062312-10",
        "GPS:+41.47818 -72.68108",
        "CALL:Minor MVA -No Medic",
        "ADDR:MAIN ST and WALLINGFORD RD",
        "MADDR:MAIN ST & WALLINGFORD RD",
        "CITY:DURHAM",
        "X:WALLINGFORD RD & MAIDEN LANE",
        "DATE:06/23/12",
        "TIME:07:42:19");

    doTest("T9",
        "(CAD Page for CFS 062312-66) \n" +
        "http://maps.google.com/maps?q=+41.47828%20-72.67083\n" +
        "Wires Down -Call NU\n" +
        "135 PICKETT LANE\n" +
        "Apt: \n" +
        "DH\n" +
        "Cross Streets : MAIN ST * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/23/12 21:06:27",

        "ID:062312-66",
        "GPS:+41.47828 -72.67083",
        "CALL:Wires Down -Call NU",
        "ADDR:135 PICKETT LANE",
        "CITY:DURHAM",
        "X:MAIN ST & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/23/12",
        "TIME:21:06:27");

    doTest("T10",
        "(CAD Page for CFS 062412-49) \n" +
        "http://maps.google.com/maps?q=+41.47896%20-72.68120\n" +
        "Minor MVA -No Medic\n" +
        "238 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WALLINGFORD RD * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/24/12 14:21:09",

        "ID:062412-49",
        "GPS:+41.47896 -72.68120",
        "CALL:Minor MVA -No Medic",
        "ADDR:238 MAIN ST",
        "CITY:DURHAM",
        "X:WALLINGFORD RD & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/24/12",
        "TIME:14:21:09");

    doTest("T11",
        "(CAD Page for CFS 062512-13) \n" +
        "http://maps.google.com/maps?q=+41.33698%20-72.58493\n" +
        "Structure Fire\n" +
        "24 COW PEN HILL RD\n" +
        "Apt: \n" +
        "KW\n" +
        "Cross Streets : GREEN HILL RD * COOKS LANE \n" +
        "Caller: BROWN,ROBERT F\n" +
        "Disp Time: 06/25/12 08:30:13",

        "ID:062512-13",
        "GPS:+41.33698 -72.58493",
        "CALL:Structure Fire",
        "ADDR:24 COW PEN HILL RD",
        "CITY:KILLINGWORTH",
        "X:GREEN HILL RD & COOKS LANE",
        "NAME:BROWN,ROBERT F",
        "DATE:06/25/12",
        "TIME:08:30:13");

    doTest("T12",
        "(CAD Page for CFS 062512-65) \n" +
        "http://maps.google.com/maps?q=+41.48772%20-72.64230\n" +
        "Fire Alarm\n" +
        "255 JOHNSON LANE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE * HADDAM QUARTER RD \n" +
        "Caller: adt\n" +
        "Disp Time: 06/25/12 16:21:16",

        "ID:062512-65",
        "GPS:+41.48772 -72.64230",
        "CALL:Fire Alarm",
        "ADDR:255 JOHNSON LANE",
        "CITY:DURHAM",
        "X:MAIDEN LANE & HADDAM QUARTER RD",
        "NAME:adt",
        "DATE:06/25/12",
        "TIME:16:21:16");

    doTest("T13",
        "(CAD Page for CFS 062512-87) \n" +
        "http://maps.google.com/maps?q=+41.49094%20-72.65092\n" +
        "Electrical Fire Pole/Wire\n" +
        "HADDAM QUARTER RD and ARBUTUS ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WINTERBERRY LANE * HADDAM QUARTER RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/25/12 20:31:21",

        "ID:062512-87",
        "GPS:+41.49094 -72.65092",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:HADDAM QUARTER RD and ARBUTUS ST",
        "MADDR:HADDAM QUARTER RD & ARBUTUS ST",
        "CITY:DURHAM",
        "X:WINTERBERRY LANE & HADDAM QUARTER RD",
        "NAME:VERIZON WIRELESS",
        "DATE:06/25/12",
        "TIME:20:31:21");

    doTest("T14",
        "(CAD Page for CFS 062612-1) \n" +
        "http://maps.google.com/maps?q=+41.46590%20-72.67495\n" +
        "Brush Fire\n" +
        "HIGGANUM RD and CHERRY LANE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MADISON RD * CHERRY LANE \n" +
        "Caller: \n" +
        "Disp Time: 06/26/12 00:16:19",

        "ID:062612-1",
        "GPS:+41.46590 -72.67495",
        "CALL:Brush Fire",
        "ADDR:HIGGANUM RD and CHERRY LANE",
        "MADDR:HIGGANUM RD & CHERRY LANE",
        "CITY:DURHAM",
        "X:MADISON RD & CHERRY LANE",
        "DATE:06/26/12",
        "TIME:00:16:19");

    doTest("T15",
        "(CAD Page for CFS 063012-41) \n" +
        "http://maps.google.com/maps?q=+41.46674%20-72.65959\n" +
        "Electrical Fire Pole/Wire\n" +
        "291 HIGGANUM RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : TRINITY HILL DR * BEAR ROCK RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/30/12 11:30:15",

        "ID:063012-41",
        "GPS:+41.46674 -72.65959",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:291 HIGGANUM RD",
        "CITY:DURHAM",
        "X:TRINITY HILL DR & BEAR ROCK RD",
        "NAME:VERIZON WIRELESS",
        "DATE:06/30/12",
        "TIME:11:30:15");

    doTest("T16",
        "(CAD Page for CFS 070512-9) \n" +
        "http://maps.google.com/maps?q=+41.49594%20-72.64658\n" +
        "Fire Alarm\n" +
        "23 CHEYENNE TR\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : ARBUTUS ST \n" +
        "Caller: early detection\n" +
        "Disp Time: 07/05/12 07:03:07",

        "ID:070512-9",
        "GPS:+41.49594 -72.64658",
        "CALL:Fire Alarm",
        "ADDR:23 CHEYENNE TR", // Not Mapping
        "CITY:DURHAM",
        "X:ARBUTUS ST",
        "NAME:early detection",
        "DATE:07/05/12",
        "TIME:07:03:07");

    doTest("T17",
        "(CAD Page for CFS 070712-30) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Public Service\n" +
        "U:OLD JOHNSON LANE AND MILBROOK\n" +
        "Apt: \n" +
        "MD\n" +
        "Caller: MD\n" +
        "Disp Time: 07/07/12 13:36:50",

        "ID:070712-30",
        "CALL:Public Service",
        "ADDR:OLD JOHNSON LANE AND MILBROOK",
        "CITY:MIDDLETOWN",
        "NAME:MD",
        "DATE:07/07/12",
        "TIME:13:36:50");

    doTest("T18",
        "(CAD Page for CFS 070712-87) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Structure Fire\n" +
        "U:U:ROUTE 149 AND ROUTE 16\n" +
        "Apt: \n\n" +
        "Caller: \n" +
        "Disp Time: 07/08/12 01:23:01",

        "ID:070712-87",
        "CALL:Structure Fire",
        "ADDR:ROUTE 149 AND ROUTE 16",
        "DATE:07/08/12",
        "TIME:01:23:01");
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(CAD Page for CFS 062212-75) \n" +
        "http://maps.google.com/maps?q=+41.28611%20-72.27805\n" +
        "Psychiatric BLS\n" +
        "63 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOCCE LANE * MARTINO RD \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 06/22/12 23:37:06",

        "ID:062212-75",
        "GPS:+41.28611 -72.27805",
        "CALL:Psychiatric BLS",
        "ADDR:63 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:BOCCE LANE & MARTINO RD",
        "DATE:06/22/12",
        "TIME:23:37:06");

    doTest("T2",
        "(CAD Page for CFS 062612-31) \n" +
        "http://maps.google.com/maps?q=+41.28835%20-72.27751\n" +
        "Basic Life Support \n" +
        "25 SWAN AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 36 SWAN AV\n\n" +
        "Disp Time: 06/26/12 12:58:25",

        "ID:062612-31",
        "GPS:+41.28835 -72.27751",
        "CALL:Basic Life Support",
        "ADDR:25 SWAN AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "DATE:06/26/12",
        "TIME:12:58:25");

    doTest("T3",
        "(CAD Page for CFS 062612-38) \n" +
        "http://maps.google.com/maps?q=+41.30446%20-72.25576\n" +
        "BEE STING REACTION\n" +
        "3 FOX CHASE LANE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : OAKRIDGE DR \n" +
        "Caller: \n" +
        "Water\\Info: TSFW56 21 OAKRIDGE @ BOAT LAUNCH\n\n" +
        "Disp Time: 06/26/12 14:38:18",

        "ID:062612-38",
        "GPS:+41.30446 -72.25576",
        "CALL:BEE STING REACTION",
        "ADDR:3 FOX CHASE LANE",
        "CITY:OLD LYME",
        "X:OAKRIDGE DR",
        "DATE:06/26/12",
        "TIME:14:38:18");

    doTest("T4",
        "(CAD Page for CFS 062712-10) \n" +
        "http://maps.google.com/maps?q=+41.34336%20-72.30941\n" +
        "GENERAL WEAKNESS\n" +
        "115 SILL LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WILLS RIDGE RD * BOSTON POST RD \n" +
        "Caller: BISHOP,CRAIG\n" +
        "Disp Time: 06/27/12 08:14:33",

        "ID:062712-10",
        "GPS:+41.34336 -72.30941",
        "CALL:GENERAL WEAKNESS",
        "ADDR:115 SILL LANE",
        "CITY:OLD LYME",
        "X:WILLS RIDGE RD & BOSTON POST RD",
        "NAME:BISHOP,CRAIG",
        "DATE:06/27/12",
        "TIME:08:14:33");

    doTest("T5",
        "(CAD Page for CFS 062812-39) \n" +
        "http://maps.google.com/maps?q=+41.35931%20-72.29515\n" +
        "Seizures ALS\n" +
        "76 GRASSY HILL RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOSTON POST RD * COACH DR \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW38 94 GRASSY HILL @ BOAT LAUNCH\n\n" +
        "Disp Time: 06/28/12 18:01:46",

        "ID:062812-39",
        "GPS:+41.35931 -72.29515",
        "CALL:Seizures ALS",
        "ADDR:76 GRASSY HILL RD",
        "CITY:OLD LYME",
        "X:BOSTON POST RD & COACH DR",
        "NAME:VERIZON WIRELESS",
        "DATE:06/28/12",
        "TIME:18:01:46");

    doTest("T6",
        "(CAD Page for CFS 062912-14) \n" +
        "http://maps.google.com/maps?q=+41.30351%20-72.27782\n" +
        "Basic Life Support \n" +
        "30 WYCHWOOD RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : NOTTINGHAM DR * BROWNS LANE \n" +
        "Caller: HEAP,JOSEPH C\n" +
        "Water\\Info: TSFW49 20 THOMAS WAITE DR\n\n" +
        "Disp Time: 06/29/12 10:33:12",

        "ID:062912-14",
        "GPS:+41.30351 -72.27782",
        "CALL:Basic Life Support",
        "ADDR:30 WYCHWOOD RD",
        "CITY:OLD LYME",
        "X:NOTTINGHAM DR & BROWNS LANE",
        "NAME:HEAP,JOSEPH C",
        "DATE:06/29/12",
        "TIME:10:33:12");

    doTest("T7",
        "(CAD Page for CFS 062912-30) \n" +
        "http://maps.google.com/maps?q=+41.30316%20-72.26485\n" +
        "ALTERED MENTAL STATUS\n" +
        "285 MILE CREEK RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : WOOD RIDGE HILLS RD * CHESTNUT HILL RD \n" +
        "Caller: \n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Water\\Info: HLFW75 302 MILE CREEK RD\n\n" +
        "Disp Time: 06/29/12 12:57:32",

        "ID:062912-30",
        "GPS:+41.30316 -72.26485",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:285 MILE CREEK RD",
        "CITY:OLD LYME",
        "X:WOOD RIDGE HILLS RD & CHESTNUT HILL RD",
        "DATE:06/29/12",
        "TIME:12:57:32");

    doTest("T8",
        "(CAD Page for CFS 063012-53) \n" +
        "http://maps.google.com/maps?q=+41.28296%20-72.28382\n" +
        "SYNCOPE\n" +
        "5 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : CENTER BEACH AVE * SIDEWALK LANE \n" +
        "Caller: GARVIN'S RENTALS\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 06/30/12 12:49:28",

        "ID:063012-53",
        "GPS:+41.28296 -72.28382",
        "CALL:SYNCOPE",
        "ADDR:5 WEST END DR",
        "CITY:OLD LYME",
        "X:CENTER BEACH AVE & SIDEWALK LANE",
        "NAME:GARVIN'S RENTALS",
        "DATE:06/30/12",
        "TIME:12:49:28");

    doTest("T9",
        "(CAD Page for CFS 063012-65) \n" +
        "http://maps.google.com/maps?q=+41.31915%20-72.34690\n" +
        "MVA Medic ALS\n" +
        "2 N6970\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : RT9S TO I95N * EXIT 70 NB \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLHY BRIDGE * OSFD @ FILL POINT\n\n" +
        "Disp Time: 06/30/12 14:33:23",

        "ID:063012-65",
        "GPS:+41.31915 -72.34690",
        "CALL:MVA Medic ALS",
        "ADDR:2 N6970",
        "CITY:OLD LYME",
        "X:RT9S TO I95N & EXIT 70 NB",
        "NAME:AT&T MOBILITY",
        "DATE:06/30/12",
        "TIME:14:33:23");

    doTest("T10",
        "(CAD Page for CFS 063012-90) \n" +
        "http://maps.google.com/maps?q=+41.35479%20-72.30378\n" +
        "Basic Life Support \n" +
        "54 ROGERS LAKE TR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : AVON ST * TAMIAMI TR \n" +
        "Caller: BAKOLEDIS,A\n" +
        "Water\\Info: HLFW40 5 DEVITT LOOP\n\n" +
        "Water\\Info: HLFW74 22 TOWN WOODS RD\n\n" +
        "Disp Time: 06/30/12 17:36:37",

        "ID:063012-90",
        "GPS:+41.35479 -72.30378",
        "CALL:Basic Life Support",
        "ADDR:54 ROGERS LAKE TR",
        "CITY:OLD LYME",
        "X:AVON ST & TAMIAMI TR",
        "NAME:BAKOLEDIS,A",
        "DATE:06/30/12",
        "TIME:17:36:37");

    doTest("T11",
        "(CAD Page for CFS 063012-103) \n" +
        "http://maps.google.com/maps?q=+41.36244%20-72.29684\n" +
        "GENERAL WEAKNESS\n" +
        "55 HICKORY ST\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : AVENUE F * AVENUE G \n" +
        "Caller: WANAT,GEORGE\n" +
        "Disp Time: 06/30/12 21:09:24",

        "ID:063012-103",
        "GPS:+41.36244 -72.29684",
        "CALL:GENERAL WEAKNESS",
        "ADDR:55 HICKORY ST",
        "CITY:OLD LYME",
        "X:AVENUE F & AVENUE G",
        "NAME:WANAT,GEORGE",
        "DATE:06/30/12",
        "TIME:21:09:24");

    doTest("T12",
        "(CAD Page for CFS 070112-44) \n" +
        "http://maps.google.com/maps?q=+41.30718%20-72.29227\n" +
        "Seizures ALS\n" +
        "5 FLAT ROCK HILL RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : MILE CREEK RD * BROWNS LANE \n" +
        "Caller: PEARSON,MARK & BRENDA\n" +
        "Disp Time: 07/01/12 15:55:41",

        "ID:070112-44",
        "GPS:+41.30718 -72.29227",
        "CALL:Seizures ALS",
        "ADDR:5 FLAT ROCK HILL RD",
        "CITY:OLD LYME",
        "X:MILE CREEK RD & BROWNS LANE",
        "NAME:PEARSON,MARK & BRENDA",
        "DATE:07/01/12",
        "TIME:15:55:41");

    doTest("T13",
        "(CAD Page for CFS 070112-75) \n" +
        "http://maps.google.com/maps?q=+41.28461%20-72.27786\n" +
        "Unconcious/Unresponsive ALS\n" +
        "88 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : POND RD \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 07/01/12 17:44:58",

        "ID:070112-75",
        "GPS:+41.28461 -72.27786",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:88 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:POND RD",
        "DATE:07/01/12",
        "TIME:17:44:58");

    doTest("T14",
        "(CAD Page for CFS 070212-31) \n" +
        "http://maps.google.com/maps?q=+41.30627%20-72.25845\n" +
        "Injured Person  BLS\n" +
        "436 SHORE RD\n" +
        "Apt: 108\n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD * RIVERDALE LANDING \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW55 8 BANK RD MARINA\n\n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Water\\Info: BAYBERRY MOTEL * KNOX BOX * R OF OFFICE DOOR * MASTER KEY FOR ALL ROOMS\n\n" +
        "Disp Time: 07/02/12 11:33:49",

        "ID:070212-31",
        "GPS:+41.30627 -72.25845",
        "CALL:Injured Person  BLS",
        "ADDR:436 SHORE RD",
        "APT:108",
        "CITY:OLD LYME",
        "X:MILE CREEK RD & RIVERDALE LANDING",
        "NAME:VERIZON WIRELESS",
        "DATE:07/02/12",
        "TIME:11:33:49");

    doTest("T15",
        "(CAD Page for CFS 070212-32) \n" +
        "http://maps.google.com/maps?q=+41.30123%20-72.27529\n" +
        "Injured Person  BLS\n" +
        "3 CHANTICLEER LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WYCHWOOD RD \n" +
        "Caller: POLLACK,LITA\n" +
        "Disp Time: 07/02/12 12:16:00",

        "ID:070212-32",
        "GPS:+41.30123 -72.27529",
        "CALL:Injured Person  BLS",
        "ADDR:3 CHANTICLEER LANE",
        "CITY:OLD LYME",
        "X:WYCHWOOD RD",
        "NAME:POLLACK,LITA",
        "DATE:07/02/12",
        "TIME:12:16:00");

    doTest("T16",
        "(CAD Page for CFS 070212-37) \n" +
        "http://maps.google.com/maps?q=+41.33535%20-72.31360\n" +
        "Respiratory Distress ALS\n" +
        "48 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOGGY HOLE RD * BLACKWELL LANE \n" +
        "Caller: BARBATO,CHRISTINE\n" +
        "Water\\Info: HLFW30 40 BOSTON POST RD\n\n" +
        "Disp Time: 07/02/12 13:25:45",

        "ID:070212-37",
        "GPS:+41.33535 -72.31360",
        "CALL:Respiratory Distress ALS",
        "ADDR:48 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:BOGGY HOLE RD & BLACKWELL LANE",
        "NAME:BARBATO,CHRISTINE",
        "DATE:07/02/12",
        "TIME:13:25:45");

    doTest("T17",
        "(CAD Page for CFS 070412-42) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Basic Life Support \n" +
        "hartford av\n" +
        "Apt: \n" +
        "ol\n" +
        "Caller: \n" +
        "Disp Time: 07/04/12 14:58:30",

        "ID:070412-42",
        "CALL:Basic Life Support",
        "ADDR:hartford av",
        "MADDR:hartford ave",
        "CITY:OLD LYME",
        "DATE:07/04/12",
        "TIME:14:58:30");

    doTest("T18",
        "(CAD Page for CFS 070412-57) \n" +
        "http://maps.google.com/maps?q=+41.28034%20-72.28979\n" +
        "Injured Person  BLS\n" +
        "100 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SIDEWALK LANE \n" +
        "Caller: KAYLIN,WALTER\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 07/04/12 18:20:14",

        "ID:070412-57",
        "GPS:+41.28034 -72.28979",
        "CALL:Injured Person  BLS",
        "ADDR:100 WEST END DR",
        "CITY:OLD LYME",
        "X:SIDEWALK LANE",
        "NAME:KAYLIN,WALTER",
        "DATE:07/04/12",
        "TIME:18:20:14");

    doTest("T19",
        "(CAD Page for CFS 070512-31) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Psychiatric BLS\n" +
        "OLD SHORE RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Caller: CSP\n" +
        "Disp Time: 07/05/12 11:40:22",

        "ID:070512-31",
        "CALL:Psychiatric BLS",
        "ADDR:OLD SHORE RD",
        "CITY:OLD LYME",
        "NAME:CSP",
        "DATE:07/05/12",
        "TIME:11:40:22");

    doTest("T20",
        "(CAD Page for CFS 070512-54) \n" +
        "http://maps.google.com/maps?q=+41.30798%20-72.30020\n" +
        "Psychiatric BLS\n" +
        "25 ROWLAND RD\n" +
        "Apt: -1\n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD \n" +
        "Caller: COOK,RICHARD J\n" +
        "Water\\Info: HLFW32 70 ROWLAND RD\n\n" +
        "Disp Time: 07/05/12 15:58:07",

        "ID:070512-54",
        "GPS:+41.30798 -72.30020",
        "CALL:Psychiatric BLS",
        "ADDR:25 ROWLAND RD",
        "APT:-1",
        "CITY:OLD LYME",
        "X:MILE CREEK RD",
        "NAME:COOK,RICHARD J",
        "DATE:07/05/12",
        "TIME:15:58:07");

    doTest("T21",
        "(CAD Page for CFS 070512-66) \n" +
        "http://maps.google.com/maps?q=+41.34836%20-72.29934\n" +
        "Injured Person  BLS\n" +
        "166 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : TOWN WOODS RD * BOUGHTON RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW84 9 BOUGHTON RD\n\n" +
        "Water\\Info: HLFW34 172 BOSTON POST RD\n\n" +
        "Disp Time: 07/05/12 20:10:31",

        "ID:070512-66",
        "GPS:+41.34836 -72.29934",
        "CALL:Injured Person  BLS",
        "ADDR:166 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:TOWN WOODS RD & BOUGHTON RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/05/12",
        "TIME:20:10:31");

    doTest("T22",
        "(CAD Page for CFS 070512-68) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Respiratory Distress ALS\n" +
        "HAWKS nest beach rd\n" +
        "Apt: e5\n" +
        "ol\n" +
        "Caller: \n" +
        "Disp Time: 07/05/12 20:38:57",

        "ID:070512-68",
        "CALL:Respiratory Distress ALS",
        "ADDR:HAWKS nest beach rd",   // Not mapping
        "APT:e5",
        "CITY:OLD LYME",
        "DATE:07/05/12",
        "TIME:20:38:57");

    doTest("T23",
        "(CAD Page for CFS 070512-75) \n" +
        "http://maps.google.com/maps?q=+41.28771%20-72.27810\n" +
        "Chest Pain ALS\n" +
        "36 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: PAPPACENO,J\n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 07/05/12 23:32:28",

        "ID:070512-75",
        "GPS:+41.28771 -72.27810",
        "CALL:Chest Pain ALS",
        "ADDR:36 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "NAME:PAPPACENO,J",
        "DATE:07/05/12",
        "TIME:23:32:28");

    doTest("T24",
        "(CAD Page for CFS 070612-8) \n" +
        "http://maps.google.com/maps?q=+41.32356%20-72.32825\n" +
        "MVA Medic ALS\n" +
        "1 S7070\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LYME ST * NECK RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: TSFW50 1 ENTERPRISE DR\n\n" +
        "Disp Time: 07/06/12 08:12:48",

        "ID:070612-8",
        "GPS:+41.32356 -72.32825",
        "CALL:MVA Medic ALS",
        "ADDR:1 S7070",
        "CITY:OLD LYME",
        "X:LYME ST & NECK RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/06/12",
        "TIME:08:12:48");

    doTest("T25",
        "(CAD Page for CFS 070612-12) \n" +
        "http://maps.google.com/maps?q=+41.28749%20-72.27522\n" +
        "Injured Person  BLS\n" +
        "33 GORTON AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BROUGHEL AVE * MAPLE AVE \n" +
        "Caller: EPSTEIN, ELAINE\n" +
        "Water\\Info: HLHY 34 GORTON AV\n\n" +
        "Disp Time: 07/06/12 08:34:11",

        "ID:070612-12",
        "GPS:+41.28749 -72.27522",
        "CALL:Injured Person  BLS",
        "ADDR:33 GORTON AVE",
        "CITY:OLD LYME",
        "X:BROUGHEL AVE & MAPLE AVE",
        "NAME:EPSTEIN, ELAINE",
        "DATE:07/06/12",
        "TIME:08:34:11");

    doTest("T26",
        "(CAD Page for CFS 070612-22) \n" +
        "http://maps.google.com/maps?q=+41.34414%20-72.30615\n" +
        "Respiratory Distress ALS\n" +
        "124 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SUNSET DR * APPLE TREE DR \n" +
        "Caller: EBBETS, MARGARET\n" +
        "Water\\Info: HLFW21 97 SILL LA\n\n" +
        "Disp Time: 07/06/12 10:20:39",

        "ID:070612-22",
        "GPS:+41.34414 -72.30615",
        "CALL:Respiratory Distress ALS",
        "ADDR:124 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:SUNSET DR & APPLE TREE DR",
        "NAME:EBBETS, MARGARET",
        "DATE:07/06/12",
        "TIME:10:20:39");

    doTest("T27",
        "(CAD Page for CFS 070612-32) \n" +
        "http://maps.google.com/maps?q=+41.28270%20-72.30608\n" +
        "Traumatic Injury ALS\n" +
        "9 SPRINGFIELD RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : HOWARD RD * SEASIDE LANE \n" +
        "Caller: BRADLEY W PATRICK\n" +
        "Water\\Info: HLFW48 4 GRISWOLD PT\n\n" +
        "Disp Time: 07/06/12 13:43:39",

        "ID:070612-32",
        "GPS:+41.28270 -72.30608",
        "CALL:Traumatic Injury ALS",
        "ADDR:9 SPRINGFIELD RD",
        "CITY:OLD LYME",
        "X:HOWARD RD & SEASIDE LANE",
        "NAME:BRADLEY W PATRICK",
        "DATE:07/06/12",
        "TIME:13:43:39");

    doTest("T28",
        "(CAD Page for CFS 070612-44) \n" +
        "http://maps.google.com/maps?q=+41.30684%20-72.26255\n" +
        "Respiratory Distress ALS\n" +
        "2 ASCOT LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : CHESTNUT HILL RD \n" +
        "Caller: KATZ,BARBARA\n" +
        "Disp Time: 07/06/12 15:06:14",

        "ID:070612-44",
        "GPS:+41.30684 -72.26255",
        "CALL:Respiratory Distress ALS",
        "ADDR:2 ASCOT LANE",
        "CITY:OLD LYME",
        "X:CHESTNUT HILL RD",
        "NAME:KATZ,BARBARA",
        "DATE:07/06/12",
        "TIME:15:06:14");

    doTest("T29",
        "(CAD Page for CFS 070612-90) \n" +
        "http://maps.google.com/maps?q=+41.28541%20-72.28234\n" +
        "Traumatic Injury ALS\n" +
        "54 COLUMBUS AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * AVENUE A \n" +
        "Caller: YOUNG,PAUL\n" +
        "Water\\Info: HLHY 244 SHORE RD\n\n" +
        "Disp Time: 07/06/12 23:13:15",

        "ID:070612-90",
        "GPS:+41.28541 -72.28234",
        "CALL:Traumatic Injury ALS",
        "ADDR:54 COLUMBUS AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & AVENUE A",
        "NAME:YOUNG,PAUL",
        "DATE:07/06/12",
        "TIME:23:13:15");

    doTest("T30",
        "(CAD Page for CFS 070712-31) \n" +
        "http://maps.google.com/maps?q=+41.28541%20-72.28234\n" +
        "ALTERED MENTAL STATUS\n" +
        "54 COLUMBUS AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * AVENUE A \n" +
        "Caller: YOUNG,PAUL\n" +
        "Water\\Info: HLHY 244 SHORE RD\n\n" +
        "Disp Time: 07/07/12 13:38:33",

        "ID:070712-31",
        "GPS:+41.28541 -72.28234",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:54 COLUMBUS AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & AVENUE A",
        "NAME:YOUNG,PAUL",
        "DATE:07/07/12",
        "TIME:13:38:33");

    doTest("T31",
        "(CAD Page for CFS 070712-47) \n" +
        "http://maps.google.com/maps?q=+41.32367%20-72.32745\n" +
        "Respiratory Distress ALS\n" +
        "85 LYME ST\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : HALLS RD * EXIT 70 SB \n" +
        "Caller: LLC,OPEN OPPORTUNITY\n" +
        "Water\\Info: HLFW10 11 HALLS RD\n\n" +
        "Disp Time: 07/07/12 15:53:40",

        "ID:070712-47",
        "GPS:+41.32367 -72.32745",
        "CALL:Respiratory Distress ALS",
        "ADDR:85 LYME ST",
        "CITY:OLD LYME",
        "X:HALLS RD & EXIT 70 SB",
        "NAME:LLC,OPEN OPPORTUNITY",
        "DATE:07/07/12",
        "TIME:15:53:40");

    doTest("T32",
        "(CAD Page for CFS 070912-46) \n" +
        "http://maps.google.com/maps?q=+41.30123%20-72.27529\n" +
        "Lift Assist BLS\n" +
        "3 CHANTICLEER LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WYCHWOOD RD \n" +
        "Caller: POLLACK,LITA\n" +
        "Disp Time: 07/09/12 13:53:24",

        "ID:070912-46",
        "GPS:+41.30123 -72.27529",
        "CALL:Lift Assist BLS",
        "ADDR:3 CHANTICLEER LANE",
        "CITY:OLD LYME",
        "X:WYCHWOOD RD",
        "NAME:POLLACK,LITA",
        "DATE:07/09/12",
        "TIME:13:53:24");

    doTest("T33",
        "(CAD Page for CFS 071012-36) \n" +
        "http://maps.google.com/maps?q=+41.32120%20-72.33965\n" +
        "Psychiatric BLS\n" +
        "21 NECK RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : ENTR 70 SB * OLD BRIDGE RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW24 OL MARINA\n\n" +
        "Disp Time: 07/10/12 13:51:15",

        "ID:071012-36",
        "GPS:+41.32120 -72.33965",
        "CALL:Psychiatric BLS",
        "ADDR:21 NECK RD",
        "CITY:OLD LYME",
        "X:ENTR 70 SB & OLD BRIDGE RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/10/12",
        "TIME:13:51:15");

    doTest("T34",
        "(CAD Page for CFS 071012-61) \n" +
        "http://maps.google.com/maps?q=+41.28525%20-72.28076\n" +
        "Hazmat\n" +
        "60 CORSINO AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * BISCAYNE BLVD \n" +
        "Caller: TROOP-F\n" +
        "Water\\Info: HLHY S6S SHORE RD\n\n" +
        "Disp Time: 07/10/12 22:53:16",

        "ID:071012-61",
        "GPS:+41.28525 -72.28076",
        "CALL:Hazmat",
        "ADDR:60 CORSINO AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & BISCAYNE BLVD",
        "NAME:TROOP-F",
        "DATE:07/10/12",
        "TIME:22:53:16");

    doTest("T35",
        "(CAD Page for CFS 071112-37) \n" +
        "http://maps.google.com/maps?q=+41.28551%20-72.27319\n" +
        "Injured Person  BLS\n" +
        "59 SALTAIRE DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BELLAIRE RD * SEA LANE \n" +
        "Caller: MARSHALL,JAMES R\n" +
        "Water\\Info: HLHY 70 SEASPRAY RD\n\n" +
        "Disp Time: 07/11/12 12:58:30",

        "ID:071112-37",
        "GPS:+41.28551 -72.27319",
        "CALL:Injured Person  BLS",
        "ADDR:59 SALTAIRE DR",
        "CITY:OLD LYME",
        "X:BELLAIRE RD & SEA LANE",
        "NAME:MARSHALL,JAMES R",
        "DATE:07/11/12",
        "TIME:12:58:30");

    doTest("T36",
        "(CAD Page for CFS 071112-39) \n" +
        "http://maps.google.com/maps?q=+41.30741%20-72.25650\n" +
        "Advanced Life Support\n" +
        "445 SHORE RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : RIVERDALE LANDING * RIVER RD \n" +
        "Caller: csp\n" +
        "Water\\Info: HLFW55 8 BANK RD MARINA\n\n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Disp Time: 07/11/12 13:37:00",

        "ID:071112-39",
        "GPS:+41.30741 -72.25650",
        "CALL:Advanced Life Support",
        "ADDR:445 SHORE RD",
        "CITY:OLD LYME",
        "X:RIVERDALE LANDING & RIVER RD",
        "NAME:csp",
        "DATE:07/11/12",
        "TIME:13:37:00");

    doTest("T37",
        "(CAD Page for CFS 071112-60) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Marine Rescue\n" +
        "CT RIVER MARKER 7\n" +
        "Apt: \n" +
        "OL\n" +
        "Caller: OLD SAYBROOK\n" +
        "Disp Time: 07/11/12 20:48:21",

        "ID:071112-60",
        "CALL:Marine Rescue",
        "ADDR:CT RIVER MARKER 7",
        "CITY:OLD LYME",
        "NAME:OLD SAYBROOK",
        "DATE:07/11/12",
        "TIME:20:48:21");

    doTest("T38",
        "(CAD Page for CFS 071112-66) \n" +
        "http://maps.google.com/maps?q=+41.29445%20-72.25405\n" +
        "Advanced Life Support\n" +
        "53 HILLCREST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SARGENT RD * CARRINGTON RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: TSFW57 BOAT BASIN\n\n" +
        "Disp Time: 07/11/12 23:53:52",

        "ID:071112-66",
        "GPS:+41.29445 -72.25405",
        "CALL:Advanced Life Support",
        "ADDR:53 HILLCREST RD",
        "CITY:OLD LYME",
        "X:SARGENT RD & CARRINGTON RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/11/12",
        "TIME:23:53:52");

    doTest("T39",
        "(CAD Page for CFS 071212-17) \n" +
        "http://maps.google.com/maps?q=+41.28875%20-72.27919\n" +
        "Fall 10  -ALS\n" +
        "18 PORTLAND AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 51 PORTLAND AV\n\n" +
        "Disp Time: 07/12/12 09:57:25",

        "ID:071212-17",
        "GPS:+41.28875 -72.27919",
        "CALL:Fall 10  -ALS",
        "ADDR:18 PORTLAND AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "DATE:07/12/12",
        "TIME:09:57:25");

    doTest("T40",
        "(CAD Page for CFS 071212-35) \n" +
        "http://maps.google.com/maps?q=+41.33588%20-72.31274\n" +
        "Advanced Life Support\n" +
        "58 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOGGY HOLE RD * BLACKWELL LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW30 40 BOSTON POST RD\n\n" +
        "Disp Time: 07/12/12 13:22:33",

        "ID:071212-35",
        "GPS:+41.33588 -72.31274",
        "CALL:Advanced Life Support",
        "ADDR:58 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:BOGGY HOLE RD & BLACKWELL LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:07/12/12",
        "TIME:13:22:33");

    doTest("T41",
        "(CAD Page for CFS 071312-12) \n" +
        "http://maps.google.com/maps?q=+41.34942%20-72.28587\n" +
        "Advanced Life Support\n" +
        "249 BOSTON POST RD\n" +
        "Apt: 1\n" +
        "OL       \n" +
        "Cross Streets : LORDS MEADOW LANE * LYMEWOOD HOUSING \n" +
        "Caller: CANCRO,CARMINE\n" +
        "Water\\Info: HLFW35 245 BOSTON POST RD\n\n" +
        "Water\\Info: LYMEWOOD HOUSING * 1ST BLDG ON LEFT * KNOX BOX TO RIGHT OF FRONT DOOR\n\n" +
        "Disp Time: 07/13/12 07:34:26",

        "ID:071312-12",
        "GPS:+41.34942 -72.28587",
        "CALL:Advanced Life Support",
        "ADDR:249 BOSTON POST RD",
        "APT:1",
        "CITY:OLD LYME",
        "X:LORDS MEADOW LANE & LYMEWOOD HOUSING",
        "NAME:CANCRO,CARMINE",
        "DATE:07/13/12",
        "TIME:07:34:26");

    doTest("T42",
        "(CAD Page for CFS 071312-32) \n" +
        "http://maps.google.com/maps?q=+41.31145%20-72.40325\n" +
        "Structure Fire\n" +
        "1 PHEASANT HILL LANE\n" +
        "Apt: \n" +
        "OS       \n" +
        "Cross Streets : INGHAM HILL RD * WILD APPLE LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 07/13/12 11:53:06",

        "ID:071312-32",
        "GPS:+41.31145 -72.40325",
        "CALL:Structure Fire",
        "ADDR:1 PHEASANT HILL LANE",
        "CITY:OLD SAYBROOK",
        "X:INGHAM HILL RD & WILD APPLE LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:07/13/12",
        "TIME:11:53:06");

    doTest("T43",
        "(CAD Page for CFS 071312-40) \n" +
        "http://maps.google.com/maps?q=+41.34791%20-72.34145\n" +
        "Seizures ALS\n" +
        "17 COULT LANE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : NECK RD * TANTUMMAHEAG RD \n" +
        "Caller: GEIST,MICHELE\n" +
        "Water\\Info: TSFW72 10 TANTUMMAHEAG RD\n\n" +
        "Disp Time: 07/13/12 13:02:27",

        "ID:071312-40",
        "GPS:+41.34791 -72.34145",
        "CALL:Seizures ALS",
        "ADDR:17 COULT LANE",
        "CITY:OLD LYME",
        "X:NECK RD & TANTUMMAHEAG RD",
        "NAME:GEIST,MICHELE",
        "DATE:07/13/12",
        "TIME:13:02:27");

    doTest("T44",
        "(CAD Page for CFS 071312-65) \n" +
        "http://maps.google.com/maps?q=+41.29526%20-72.25557\n" +
        "Seizures ALS\n" +
        "33 HILLCREST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : CONNECTICUT RD * OAK RD \n" +
        "Caller: BERG,IRENE W\n" +
        "Water\\Info: TSFW57 BOAT BASIN\n\n" +
        "Disp Time: 07/13/12 19:33:06",

        "ID:071312-65",
        "GPS:+41.29526 -72.25557",
        "CALL:Seizures ALS",
        "ADDR:33 HILLCREST RD",
        "CITY:OLD LYME",
        "X:CONNECTICUT RD & OAK RD",
        "NAME:BERG,IRENE W",
        "DATE:07/13/12",
        "TIME:19:33:06");

    doTest("T45",
        "(CAD Page for CFS 071312-68) \n" +
        "http://maps.google.com/maps?q=+41.28572%20-72.28076\n" +
        "Chest Pain ALS\n" +
        "54 CORSINO AVE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : LIBERTY ST * BISCAYNE BLVD \n" +
        "Caller: SCHMIDT,EDWARD L\n" +
        "Disp Time: 07/13/12 20:18:46",

        "ID:071312-68",
        "GPS:+41.28572 -72.28076",
        "CALL:Chest Pain ALS",
        "ADDR:54 CORSINO AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & BISCAYNE BLVD",
        "NAME:SCHMIDT,EDWARD L",
        "DATE:07/13/12",
        "TIME:20:18:46");

    doTest("T46",
        "(CAD Page for CFS 071412-5) \n" +
        "http://maps.google.com/maps?q=+41.31332%20-72.33125\n" +
        "Respiratory Distress ALS\n" +
        "9 LYME ST\n" +
        "Apt: 1A\n" +
        "OL\n" +
        "Cross Streets : FERRY RD * ACADEMY LANE \n" +
        "Caller: MC*NEMER,P HASTINGS\n" +
        "Disp Time: 07/14/12 07:47:42",

        "ID:071412-5",
        "GPS:+41.31332 -72.33125",
        "CALL:Respiratory Distress ALS",
        "ADDR:9 LYME ST",
        "APT:1A",
        "CITY:OLD LYME",
        "X:FERRY RD & ACADEMY LANE",
        "NAME:MC*NEMER,P HASTINGS",
        "DATE:07/14/12",
        "TIME:07:47:42");

    doTest("T47",
        "(CAD Page for CFS 071412-11) \n" +
        "http://maps.google.com/maps?q=+41.28548%20-72.29464\n" +
        "Abdominal Pain BLS\n" +
        "9 HAYWAGON DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * CORD GRASS LANE \n" +
        "Caller: MAZZOTTA, JOHN\n" +
        "Water\\Info: HLHY 11 HAYWAGON DR\n\n" +
        "Disp Time: 07/14/12 09:37:42",

        "ID:071412-11",
        "GPS:+41.28548 -72.29464",
        "CALL:Abdominal Pain BLS",
        "ADDR:9 HAYWAGON DR",
        "CITY:OLD LYME",
        "X:SHORE RD & CORD GRASS LANE",
        "NAME:MAZZOTTA, JOHN",
        "DATE:07/14/12",
        "TIME:09:37:42");

    doTest("T48",
        "(CAD Page for CFS 071412-79) \n" +
        "http://maps.google.com/maps?q=+41.28034%20-72.28993\n" +
        "Cardiac Arrest ALS\n" +
        "102 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SIDEWALK LANE \n" +
        "Caller: MONKS, WILLIAM\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 07/14/12 20:56:51",

        "ID:071412-79",
        "GPS:+41.28034 -72.28993",
        "CALL:Cardiac Arrest ALS",
        "ADDR:102 WEST END DR",
        "CITY:OLD LYME",
        "X:SIDEWALK LANE",
        "NAME:MONKS, WILLIAM",
        "DATE:07/14/12",
        "TIME:20:56:51");

    doTest("T49",
        "(CAD Page for CFS 071512-13) \n" +
        "http://maps.google.com/maps?q=+41.36070%20-72.29430\n" +
        "Injured Person  BLS\n" +
        "5 COACH DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : GRASSY HILL RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW38 94 GRASSY HILL RD\n\n" +
        "Disp Time: 07/15/12 03:57:55",

        "ID:071512-13",
        "GPS:+41.36070 -72.29430",
        "CALL:Injured Person  BLS",
        "ADDR:5 COACH DR",
        "CITY:OLD LYME",
        "X:GRASSY HILL RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/15/12",
        "TIME:03:57:55");

    doTest("T50",
        "(CAD Page for CFS 071512-16) \n" +
        "http://maps.google.com/maps?q=+41.30798%20-72.33295\n" +
        "MVA Medic ALS\n" +
        "22 SHORE RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : FERRY RD * AMTRAK \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW07 300 FERRY RD\n\n" +
        "Disp Time: 07/15/12 08:10:45",

        "ID:071512-16",
        "GPS:+41.30798 -72.33295",
        "CALL:MVA Medic ALS",
        "ADDR:22 SHORE RD",
        "CITY:OLD LYME",
        "X:FERRY RD & AMTRAK",
        "NAME:VERIZON WIRELESS",
        "DATE:07/15/12",
        "TIME:08:10:45");

    doTest("T51",
        "(CAD Page for CFS 071512-25) \n" +
        "http://maps.google.com/maps?q=+41.28534%20-72.27652\n" +
        "Injured Person  BLS\n" +
        "69 OLD COLONY RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : PURTILL AVE * HARTUNG PL \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 59 OLD COLONY\n\n" +
        "Disp Time: 07/15/12 09:46:44\n\n\n",

        "ID:071512-25",
        "GPS:+41.28534 -72.27652",
        "CALL:Injured Person  BLS",
        "ADDR:69 OLD COLONY RD",
        "CITY:OLD LYME",
        "X:PURTILL AVE & HARTUNG PL",
        "DATE:07/15/12",
        "TIME:09:46:44");
  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "(CAD Page for CFS 062612-35) \n" +
        "http://maps.google.com/maps?q=+41.40815%20-72.44095\n" +
        "Life Call -Medical Alarm\n" +
        "101 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : OLD DEPOT RD * GROTE RD \n" +
        "Caller: MEDICAL ALARM\n" +
        "Water\\Info: Hydrant: 103 Mx Ave\n" +
        "Hydrant: 77 Mx Ave\n" +
        "Hydrant: Mx Ave/Grote Rd\n\n" +
        "Disp Time: 06/26/12 14:06:39",

        "ID:062612-35",
        "GPS:+41.40815 -72.44095",
        "CALL:Life Call -Medical Alarm",
        "ADDR:101 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:OLD DEPOT RD & GROTE RD",
        "NAME:MEDICAL ALARM",
        "DATE:06/26/12",
        "TIME:14:06:39");

    doTest("T2",
        "(CAD Page for CFS 062612-50) \n" +
        "http://maps.google.com/maps?q=+41.42297%20-72.44717\n" +
        "Psychiatric BLS\n" +
        "218 MIDDLESEX AVE\n" +
        "Apt: D22\n" +
        "CH       \n" +
        "Cross Streets : CASTLE VIEW DR * DENLAR DR \n" +
        "Caller: \n" +
        "Water\\Info: Hydrant: Mx Ave at shopping Center\n" +
        "Hydrant: Mx Ave (opp Castle View)\n\n" +
        "Disp Time: 06/26/12 16:40:03",

        "ID:062612-50",
        "GPS:+41.42297 -72.44717",
        "CALL:Psychiatric BLS",
        "ADDR:218 MIDDLESEX AVE",
        "APT:D22",
        "CITY:CHESTER",
        "X:CASTLE VIEW DR & DENLAR DR",
        "DATE:06/26/12",
        "TIME:16:40:03");

    doTest("T3",
        "(CAD Page for CFS 062612-54) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "Injured Person  BLS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 06/26/12 18:25:39",

        "ID:062612-54",
        "GPS:+41.40202 -72.44430",
        "CALL:Injured Person  BLS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:06/26/12",
        "TIME:18:25:39");

    doTest("T4",
        "(CAD Page for CFS 062612-56) \n" +
        "http://maps.google.com/maps?q=+41.40794%20-72.51049\n" +
        "Fire Alarm\n" +
        "87 CEDAR LAKE RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : DAVID RD * JENNINGS POND RD \n" +
        "Caller: ADT\n" +
        "Water\\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\n" +
        "Boat launch, end of Bishop Road\n\n" +
        "Disp Time: 06/26/12 19:05:07",

        "ID:062612-56",
        "GPS:+41.40794 -72.51049",
        "CALL:Fire Alarm",
        "ADDR:87 CEDAR LAKE RD",
        "CITY:CHESTER",
        "X:DAVID RD & JENNINGS POND RD",
        "NAME:ADT",
        "DATE:06/26/12",
        "TIME:19:05:07");

    doTest("T5",
        "(CAD Page for CFS 062612-67) \n" +
        "http://maps.google.com/maps?q=+41.39946%20-72.47517\n" +
        "GENERAL WEAKNESS\n" +
        "3 S WIG HILL RD\n" +
        "Apt: 41\n" +
        "CH       \n" +
        "Cross Streets : W MAIN ST * TURKEY HILL RD \n" +
        "Caller: HEALTH MGMT,RYDERS\n" +
        "Water\\Info: Standpipe: West Main St/Hoopole Hill\n" +
        "Pond: South Wig/Wig Hill Rd\n\n" +
        "Disp Time: 06/26/12 20:39:41",

        "ID:062612-67",
        "GPS:+41.39946 -72.47517",
        "CALL:GENERAL WEAKNESS",
        "ADDR:3 S WIG HILL RD",
        "APT:41",
        "CITY:CHESTER",
        "X:W MAIN ST & TURKEY HILL RD",
        "NAME:HEALTH MGMT,RYDERS",
        "DATE:06/26/12",
        "TIME:20:39:41");

    doTest("T6",
        "(CAD Page for CFS 062712-26) \n" +
        "http://maps.google.com/maps?q=+41.38833%20-72.52768\n" +
        "Fire Alarm\n" +
        "317 W MAIN ST\n" +
        "Apt: 14\n" +
        "CH       \n" +
        "Cross Streets : BUTTER JONES RD * ROUTE 148 \n" +
        "Caller: usa central\n" +
        "Water\\Info: Draft from Cedar Lake\n\n" +
        "Disp Time: 06/27/12 11:15:30",

        "ID:062712-26",
        "GPS:+41.38833 -72.52768",
        "CALL:Fire Alarm",
        "ADDR:317 W MAIN ST",
        "APT:14",
        "CITY:CHESTER",
        "X:BUTTER JONES RD & ROUTE 148",
        "NAME:usa central",
        "DATE:06/27/12",
        "TIME:11:15:30");

    doTest("T7",
        "(CAD Page for CFS 062712-60) \n" +
        "http://maps.google.com/maps?q=+41.39896%20-72.46510\n" +
        "Wires Down -Call NU\n" +
        "100 W MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SPRING ST * INSPIRATION LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: 82 West Main\n" +
        "Waterhole: West Main/Hoopole Hill\n\n" +
        "Disp Time: 06/27/12 17:12:38",

        "ID:062712-60",
        "GPS:+41.39896 -72.46510",
        "CALL:Wires Down -Call NU",
        "ADDR:100 W MAIN ST",
        "CITY:CHESTER",
        "X:SPRING ST & INSPIRATION LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:06/27/12",
        "TIME:17:12:38");

    doTest("T8",
        "(CAD Page for CFS 062912-6) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "GENERAL WEAKNESS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: 1\n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: VZWU\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 06/29/12 07:50:36",

        "ID:062912-6",
        "GPS:+41.42893 -72.45178",
        "CALL:GENERAL WEAKNESS",
        "ADDR:268 MIDDLESEX AVE",
        "APT:1",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:VZWU",
        "DATE:06/29/12",
        "TIME:07:50:36");

    doTest("T9",
        "(CAD Page for CFS 062912-43) \n" +
        "http://maps.google.com/maps?q=+41.40970%20-72.44025\n" +
        "Minor MVA -No Medic\n" +
        "GROTE RD and MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GROTE RD \n" +
        "Caller: \n" +
        "Disp Time: 06/29/12 16:15:27",

        "ID:062912-43",
        "GPS:+41.40970 -72.44025",
        "CALL:Minor MVA -No Medic",
        "ADDR:GROTE RD and MIDDLESEX AVE",
        "MADDR:GROTE RD & MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GROTE RD",
        "DATE:06/29/12",
        "TIME:16:15:27");

    doTest("T10",
        "(CAD Page for CFS 063012-98) \n" +
        "http://maps.google.com/maps?q=+41.39946%20-72.47517\n" +
        "Fire Alarm\n" +
        "3 S WIG HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : W MAIN ST * TURKEY HILL RD \n" +
        "Caller: USA Central\n" +
        "Water\\Info: Standpipe: West Main St/Hoopole Hill\n" +
        "Pond: South Wig/Wig Hill Rd\n\n" +
        "Disp Time: 06/30/12 20:36:10",

        "ID:063012-98",
        "GPS:+41.39946 -72.47517",
        "CALL:Fire Alarm",
        "ADDR:3 S WIG HILL RD",
        "CITY:CHESTER",
        "X:W MAIN ST & TURKEY HILL RD",
        "NAME:USA Central",
        "DATE:06/30/12",
        "TIME:20:36:10");

    doTest("T11",
        "(CAD Page for CFS 070112-20) \n" +
        "http://maps.google.com/maps?q=+41.40086%20-72.44209\n" +
        "Unconcious/Unresponsive ALS\n" +
        "48 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : PRATT ST * RAILROAD AVE \n" +
        "Caller: SAYBROOK AT HADDAM,THE\n" +
        "Water\\Info: Hydrant: Mx Ave/Main St\n" +
        "Hydrant: 37 Mx Ave (north of Gilbert Hill)\n" +
        "Hydrant: 77 Mx Ave\n\n" +
        "Disp Time: 07/01/12 11:23:14",

        "ID:070112-20",
        "GPS:+41.40086 -72.44209",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:48 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:PRATT ST & RAILROAD AVE",
        "NAME:SAYBROOK AT HADDAM,THE",
        "DATE:07/01/12",
        "TIME:11:23:14");

    doTest("T12",
        "(CAD Page for CFS 070112-34) \n" +
        "http://maps.google.com/maps?q=+41.40936%20-72.42899\n" +
        "Drowning ALS\n" +
        "61 DOCK RD\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : VALLEY RAILROAD \n" +
        "Caller: \n" +
        "Water\\Info: Hydrant: in front of Cozy Castle\n" +
        "Draft from Connecticut River\n\n" +
        "Disp Time: 07/01/12 13:45:55",

        "ID:070112-34",
        "GPS:+41.40936 -72.42899",
        "CALL:Drowning ALS",
        "ADDR:61 DOCK RD",
        "CITY:CHESTER",
        "X:VALLEY RAILROAD",
        "DATE:07/01/12",
        "TIME:13:45:55");

    doTest("T13",
        "(CAD Page for CFS 070312-17) \n" +
        "http://maps.google.com/maps?q=+41.40690%20-72.43349\n" +
        "Police General\n" +
        "60 RAILROAD AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : VALLEY RAILROAD \n" +
        "Caller: SPRINT NEXTEL - IDEN\n" +
        "Water\\Info: Hydrant: 60 Railroad Ave (Ch. Auto/Marine)\n" +
        "Connecticut River, end of Railroad Ave\n\n" +
        "Disp Time: 07/03/12 08:48:29",

        "ID:070312-17",
        "GPS:+41.40690 -72.43349",
        "CALL:Police General",
        "ADDR:60 RAILROAD AVE",
        "CITY:CHESTER",
        "X:VALLEY RAILROAD",
        "NAME:SPRINT NEXTEL - IDEN",
        "DATE:07/03/12",
        "TIME:08:48:29");

    doTest("T14",
        "(CAD Page for CFS 070312-28) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Abdominal Pain ALS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/03/12 11:13:01",

        "ID:070312-28",
        "GPS:+41.42893 -72.45178",
        "CALL:Abdominal Pain ALS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/03/12",
        "TIME:11:13:01");

    doTest("T15",
        "(CAD Page for CFS 070412-4) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "Injured Person  BLS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/04/12 02:50:29",

        "ID:070412-4",
        "GPS:+41.40202 -72.44430",
        "CALL:Injured Person  BLS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/04/12",
        "TIME:02:50:29");

    doTest("T16",
        "(CAD Page for CFS 070412-18) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "SYNCOPE\n" +
        "Main at the market\n" +
        "Apt: \n" +
        "ch\n" +
        "Caller: \n" +
        "Disp Time: 07/04/12 10:36:58",

        "ID:070412-18",
        "CALL:SYNCOPE",
        "ADDR:Main at the market",
        "CITY:CHESTER",
        "DATE:07/04/12",
        "TIME:10:36:58");

    doTest("T17",
        "(CAD Page for CFS 070412-45) \n" +
        "http://maps.google.com/maps?q=+41.40903%20-72.51273\n" +
        "Overdose ALS\n" +
        "99 CEDAR LAKE RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : DAVID RD * JENNINGS POND RD \n" +
        "Caller: FIXED ATTMO 8006356840 O\n" +
        "Water\\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\n" +
        "Boat launch, end of Bishop Road\n\n" +
        "Disp Time: 07/04/12 16:05:07",

        "ID:070412-45",
        "GPS:+41.40903 -72.51273",
        "CALL:Overdose ALS",
        "ADDR:99 CEDAR LAKE RD",
        "CITY:CHESTER",
        "X:DAVID RD & JENNINGS POND RD",
        "NAME:FIXED ATTMO 8006356840 O",
        "DATE:07/04/12",
        "TIME:16:05:07");

    doTest("T18",
        "(CAD Page for CFS 070412-49) \n" +
        "http://maps.google.com/maps?q=+41.42297%20-72.44717\n" +
        "Basic Life Support \n" +
        "218 MIDDLESEX AVE\n" +
        "Apt: C14\n" +
        "CH\n" +
        "Cross Streets : CASTLE VIEW DR * DENLAR DR \n" +
        "Caller: LANE,FRANCES\n" +
        "Disp Time: 07/04/12 16:52:25",

        "ID:070412-49",
        "GPS:+41.42297 -72.44717",
        "CALL:Basic Life Support",
        "ADDR:218 MIDDLESEX AVE",
        "APT:C14",
        "CITY:CHESTER",
        "X:CASTLE VIEW DR & DENLAR DR",
        "NAME:LANE,FRANCES",
        "DATE:07/04/12",
        "TIME:16:52:25");

    doTest("T19",
        "(CAD Page for CFS 070512-33) \n" +
        "http://maps.google.com/maps?q=+41.38551%20-72.45010\n" +
        "MVA Medic ALS\n" +
        "1 S65\n" +
        "Apt: \n" +
        "CH     \n" +
        "Cross Streets : EXIT 5 SB * ENTR 5 SB \n" +
        "Caller: T-Mobile, USA\n" +
        "Disp Time: 07/05/12 11:50:22",

        "ID:070512-33",
        "GPS:+41.38551 -72.45010",
        "CALL:MVA Medic ALS",
        "ADDR:1 S65",
        "CITY:CHESTER",
        "X:EXIT 5 SB & ENTR 5 SB",
        "NAME:T-Mobile, USA",
        "DATE:07/05/12",
        "TIME:11:50:22");

    doTest("T20",
        "(CAD Page for CFS 070512-63) \n" +
        "http://maps.google.com/maps?q=+41.40527%20-72.50705\n" +
        "Injured Person  BLS\n" +
        "CEDAR LAKE RD and DAVID RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : CEDAR LAKE RD * BROOKSIDE RD \n" +
        "Caller: car 7\n" +
        "Disp Time: 07/05/12 19:04:43",

        "ID:070512-63",
        "GPS:+41.40527 -72.50705",
        "CALL:Injured Person  BLS",
        "ADDR:CEDAR LAKE RD and DAVID RD",
        "MADDR:CEDAR LAKE RD & DAVID RD",
        "CITY:CHESTER",
        "X:CEDAR LAKE RD & BROOKSIDE RD",
        "NAME:car 7",
        "DATE:07/05/12",
        "TIME:19:04:43");

    doTest("T21",
        "(CAD Page for CFS 070612-28) \n" +
        "http://maps.google.com/maps?q=+41.42839%20-72.45273\n" +
        "Fire Alarm\n" +
        "136 GOOSE HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : OLD COUNTY RD * MIDDLESEX AVE \n" +
        "Caller: adt op ogm\n" +
        "Water\\Info: Standpipe: 104 Goose, south end of pond\n" +
        "Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/06/12 12:44:32",

        "ID:070612-28",
        "GPS:+41.42839 -72.45273",
        "CALL:Fire Alarm",
        "ADDR:136 GOOSE HILL RD",
        "CITY:CHESTER",
        "X:OLD COUNTY RD & MIDDLESEX AVE",
        "NAME:adt op ogm",
        "DATE:07/06/12",
        "TIME:12:44:32");

    doTest("T22",
        "(CAD Page for CFS 070612-43) \n" +
        "http://maps.google.com/maps?q=+41.40156%20-72.50703\n" +
        "GENERAL SICKNESS\n" +
        "21 LAUREL ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : CEDAR ST \n" +
        "Caller: REDAK,HARVEY & JUSTINE\n" +
        "Water\\Info: Standpipe: Cedar Lake opp Birch St\n\n" +
        "Disp Time: 07/06/12 15:05:35",

        "ID:070612-43",
        "GPS:+41.40156 -72.50703",
        "CALL:GENERAL SICKNESS",
        "ADDR:21 LAUREL ST",
        "CITY:CHESTER",
        "X:CEDAR ST",
        "NAME:REDAK,HARVEY & JUSTINE",
        "DATE:07/06/12",
        "TIME:15:05:35");

    doTest("T23",
        "(CAD Page for CFS 070712-35) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Basic Life Support \n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/07/12 14:09:22",

        "ID:070712-35",
        "GPS:+41.42893 -72.45178",
        "CALL:Basic Life Support",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/07/12",
        "TIME:14:09:22");

    doTest("T24",
        "(CAD Page for CFS 070812-52) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Abdominal Pain BLS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/08/12 17:19:37",

        "ID:070812-52",
        "GPS:+41.42893 -72.45178",
        "CALL:Abdominal Pain BLS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/08/12",
        "TIME:17:19:37");

    doTest("T25",
        "(CAD Page for CFS 070812-72) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "GENERAL SICKNESS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/08/12 21:12:30",

        "ID:070812-72",
        "GPS:+41.42893 -72.45178",
        "CALL:GENERAL SICKNESS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/08/12",
        "TIME:21:12:30");

    doTest("T26",
        "(CAD Page for CFS 070912-8) \n" +
        "http://maps.google.com/maps?q=+41.42031%20-72.44348\n" +
        "Chest Pain ALS\n" +
        "57 CASTLE VIEW DR\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : KIRTLAND AVE * MIDDLESEX AVE \n" +
        "Caller: COOK,WILLIAM\n" +
        "Disp Time: 07/09/12 07:20:58",

        "ID:070912-8",
        "GPS:+41.42031 -72.44348",
        "CALL:Chest Pain ALS",
        "ADDR:57 CASTLE VIEW DR",
        "CITY:CHESTER",
        "X:KIRTLAND AVE & MIDDLESEX AVE",
        "NAME:COOK,WILLIAM",
        "DATE:07/09/12",
        "TIME:07:20:58");

    doTest("T27",
        "(CAD Page for CFS 070912-21) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Abdominal Pain BLS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/09/12 10:47:44",

        "ID:070912-21",
        "GPS:+41.42893 -72.45178",
        "CALL:Abdominal Pain BLS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/09/12",
        "TIME:10:47:44");

    doTest("T28",
        "(CAD Page for CFS 070912-26) \n" +
        "http://maps.google.com/maps?q=+41.41022%20-72.46832\n" +
        "Injured Person  BLS\n" +
        "34 DEEP HOLLOW RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : WIG HILL RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: Deep Hollow/Liberty\n\n" +
        "Disp Time: 07/09/12 11:31:58",

        "ID:070912-26",
        "GPS:+41.41022 -72.46832",
        "CALL:Injured Person  BLS",
        "ADDR:34 DEEP HOLLOW RD",
        "CITY:CHESTER",
        "X:WIG HILL RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/09/12",
        "TIME:11:31:58");

    doTest("T29",
        "(CAD Page for CFS 071012-2) \n" +
        "http://maps.google.com/maps?q=+41.40470%20-72.45490\n" +
        "Cardiac Arrest ALS\n" +
        "3 RIDGE RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : HIGH ST * JOHNSON RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: Ridge Rd/High St\n" +
        "Hydrant: 17 Ridge Rd\n\n" +
        "Disp Time: 07/10/12 00:42:31",

        "ID:071012-2",
        "GPS:+41.40470 -72.45490",
        "CALL:Cardiac Arrest ALS",
        "ADDR:3 RIDGE RD",
        "CITY:CHESTER",
        "X:HIGH ST & JOHNSON RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/10/12",
        "TIME:00:42:31");

    doTest("T30",
        "(CAD Page for CFS 071012-26) \n" +
        "http://maps.google.com/maps?q=+41.42352%20-72.45718\n" +
        "Fire Alarm\n" +
        "13 HIGH FIELD LANE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD \n" +
        "Caller: alarm systems inc op 897\n" +
        "Water\\Info: Standpipe: 104 Goose, south end of pond\n\n" +
        "Disp Time: 07/10/12 10:41:35",

        "ID:071012-26",
        "GPS:+41.42352 -72.45718",
        "CALL:Fire Alarm",
        "ADDR:13 HIGH FIELD LANE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD",
        "NAME:alarm systems inc op 897",
        "DATE:07/10/12",
        "TIME:10:41:35");

    doTest("T31",
        "(CAD Page for CFS 071012-28) \n" +
        "http://maps.google.com/maps?q=+41.38834%20-72.50771\n" +
        "Traumatic Injury ALS\n" +
        "51 WINTHROP RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : PINE KNOLL DR * AVIATION DR \n" +
        "Caller: WHELEN ENGINEERING CO\n" +
        "Water\\Info: Standpipe: pond at Whelen\n\n" +
        "Water\\Info: Draft from Cedar Lake\n" +
        "Standpipe: pond at Whelen\n\n" +
        "Disp Time: 07/10/12 10:58:49",

        "ID:071012-28",
        "GPS:+41.38834 -72.50771",
        "CALL:Traumatic Injury ALS",
        "ADDR:51 WINTHROP RD",
        "CITY:CHESTER",
        "X:PINE KNOLL DR & AVIATION DR",
        "NAME:WHELEN ENGINEERING CO",
        "DATE:07/10/12",
        "TIME:10:58:49");

    doTest("T32",
        "(CAD Page for CFS 071012-59) \n" +
        "http://maps.google.com/maps?q=+41.42204%20-72.49747\n" +
        "Advanced Life Support\n" +
        "2 N78\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : ENTR 7 NB * TURKEY HILL RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 07/10/12 22:34:14",

        "ID:071012-59",
        "GPS:+41.42204 -72.49747",
        "CALL:Advanced Life Support",
        "ADDR:2 N78",
        "CITY:CHESTER",
        "X:ENTR 7 NB & TURKEY HILL RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/10/12",
        "TIME:22:34:14");

    doTest("T33",
        "(CAD Page for CFS 071112-45) \n" +
        "http://maps.google.com/maps?q=+41.38973%20-72.43520\n" +
        "Psychiatric BLS\n" +
        "8 READ ST\n" +
        "Apt: c\n" +
        "DR\n" +
        "Cross Streets : PROSPECT ST * KIRTLAND ST \n" +
        "Caller: SCRIVEN,DAVID,A\n" +
        "Disp Time: 07/11/12 14:55:08",

        "ID:071112-45",
        "GPS:+41.38973 -72.43520",
        "CALL:Psychiatric BLS",
        "ADDR:8 READ ST",
        "APT:c",
        "CITY:DEEP RIVER",
        "X:PROSPECT ST & KIRTLAND ST",
        "NAME:SCRIVEN,DAVID,A",
        "DATE:07/11/12",
        "TIME:14:55:08");

    doTest("T34",
        "(CAD Page for CFS 071112-53) \n" +
        "http://maps.google.com/maps?q=+41.38834%20-72.50771\n" +
        "Injured Person  BLS\n" +
        "51 WINTHROP RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : PINE KNOLL DR * AVIATION DR \n" +
        "Caller: WHELEN ENGINEERING CO\n" +
        "Water\\Info: Standpipe: pond at Whelen\n\n" +
        "Water\\Info: Draft from Cedar Lake\n" +
        "Standpipe: pond at Whelen\n\n" +
        "Disp Time: 07/11/12 16:59:51",

        "ID:071112-53",
        "GPS:+41.38834 -72.50771",
        "CALL:Injured Person  BLS",
        "ADDR:51 WINTHROP RD",
        "CITY:CHESTER",
        "X:PINE KNOLL DR & AVIATION DR",
        "NAME:WHELEN ENGINEERING CO",
        "DATE:07/11/12",
        "TIME:16:59:51");

    doTest("T35",
        "(CAD Page for CFS 071112-64) \n" +
        "http://maps.google.com/maps?q=+41.42297%20-72.44717\n" +
        "Life Call -Medical Alarm\n" +
        "218 MIDDLESEX AVE\n" +
        "Apt: A1\n" +
        "CH       \n" +
        "Cross Streets : CASTLE VIEW DR * DENLAR DR \n" +
        "Caller: LINK TO LIFE\n" +
        "Water\\Info: Hydrant: Mx Ave at shopping Center\n" +
        "Hydrant: Mx Ave (opp Castle View)\n\n" +
        "Disp Time: 07/11/12 22:59:58",

        "ID:071112-64",
        "GPS:+41.42297 -72.44717",
        "CALL:Life Call -Medical Alarm",
        "ADDR:218 MIDDLESEX AVE",
        "APT:A1",
        "CITY:CHESTER",
        "X:CASTLE VIEW DR & DENLAR DR",
        "NAME:LINK TO LIFE",
        "DATE:07/11/12",
        "TIME:22:59:58");

    doTest("T36",
        "(CAD Page for CFS 071212-9) \n" +
        "http://maps.google.com/maps?q=+41.39946%20-72.47517\n" +
        "Fire Alarm\n" +
        "3 S WIG HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : W MAIN ST * TURKEY HILL RD \n" +
        "Caller: usa centeral\n" +
        "Water\\Info: Standpipe: West Main St/Hoopole Hill\n" +
        "Pond: South Wig/Wig Hill Rd\n\n" +
        "Disp Time: 07/12/12 08:06:48",

        "ID:071212-9",
        "GPS:+41.39946 -72.47517",
        "CALL:Fire Alarm",
        "ADDR:3 S WIG HILL RD",
        "CITY:CHESTER",
        "X:W MAIN ST & TURKEY HILL RD",
        "NAME:usa centeral",
        "DATE:07/12/12",
        "TIME:08:06:48");

    doTest("T37",
        "(CAD Page for CFS 071212-13) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Psychiatric BLS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/12/12 08:49:35",

        "ID:071212-13",
        "GPS:+41.42893 -72.45178",
        "CALL:Psychiatric BLS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/12/12",
        "TIME:08:49:35");

    doTest("T38",
        "(CAD Page for CFS 071212-30) \n" +
        "http://maps.google.com/maps?q=+41.39948%20-72.47023\n" +
        "Minor MVA -No Medic\n" +
        "129 W MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SPRING ST * INSPIRATION LANE \n" +
        "Caller: SPRINTPCS\n" +
        "Water\\Info: Waterhole: West Main/Hoopole Hill\n\n" +
        "Disp Time: 07/12/12 11:57:46",

        "ID:071212-30",
        "GPS:+41.39948 -72.47023",
        "CALL:Minor MVA -No Medic",
        "ADDR:129 W MAIN ST",
        "CITY:CHESTER",
        "X:SPRING ST & INSPIRATION LANE",
        "NAME:SPRINTPCS",
        "DATE:07/12/12",
        "TIME:11:57:46");

    doTest("T39",
        "(CAD Page for CFS 071212-40) \n" +
        "http://maps.google.com/maps?q=+41.38994%20-72.43497\n" +
        "Psychiatric BLS\n" +
        "12 READ ST\n" +
        "Apt: C\n" +
        "DR       \n" +
        "Cross Streets : PROSPECT ST * KIRTLAND ST \n" +
        "Caller: MOBILE CRISIS * KATHY\n" +
        "Water\\Info: CORNER KIRTLAND & READ\n\n" +
        "Disp Time: 07/12/12 14:46:07",

        "ID:071212-40",
        "GPS:+41.38994 -72.43497",
        "CALL:Psychiatric BLS",
        "ADDR:12 READ ST",
        "APT:C",
        "CITY:DEEP RIVER",
        "X:PROSPECT ST & KIRTLAND ST",
        "NAME:MOBILE CRISIS * KATHY",
        "DATE:07/12/12",
        "TIME:14:46:07");

    doTest("T40",
        "(CAD Page for CFS 071212-68) \n" +
        "http://maps.google.com/maps?q=+41.37923%20-72.55943\n" +
        "Structure Fire\n" +
        "42 SWAN LAKE TR\n" +
        "Apt: \n" +
        "KW\n" +
        "Cross Streets : BRIDLE PATH TR * BOULDER TR \n" +
        "Caller: DAIGLE,GEORGE A\n" +
        "Disp Time: 07/12/12 20:27:26",

        "ID:071212-68",
        "GPS:+41.37923 -72.55943",
        "CALL:Structure Fire",
        "ADDR:42 SWAN LAKE TR",
        "CITY:KILLINGWORTH",
        "X:BRIDLE PATH TR & BOULDER TR",
        "NAME:DAIGLE,GEORGE A",
        "DATE:07/12/12",
        "TIME:20:27:26");

    doTest("T41",
        "(CAD Page for CFS 071212-69) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "ALTERED MENTAL STATUS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/12/12 20:44:39",

        "ID:071212-69",
        "GPS:+41.42893 -72.45178",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/12/12",
        "TIME:20:44:39");

    doTest("T42",
        "(CAD Page for CFS 071312-53) \n" +
        "http://maps.google.com/maps?q=+41.38833%20-72.52768\n" +
        "Lift Assist BLS\n" +
        "317 W MAIN ST\n" +
        "Apt: 6203\n" +
        "CH\n" +
        "Cross Streets : BUTTER JONES RD * ROUTE 148 \n" +
        "Caller: CHESTER VILLAGE WEST\n" +
        "Disp Time: 07/13/12 16:39:45",

        "ID:071312-53",
        "GPS:+41.38833 -72.52768",
        "CALL:Lift Assist BLS",
        "ADDR:317 W MAIN ST",
        "APT:6203",
        "CITY:CHESTER",
        "X:BUTTER JONES RD & ROUTE 148",
        "NAME:CHESTER VILLAGE WEST",
        "DATE:07/13/12",
        "TIME:16:39:45");

    doTest("T43",
        "(CAD Page for CFS 071312-60) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "ALTERED MENTAL STATUS\n" +
        "132 MAIN ST\n" +
        "Apt: 2\n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/13/12 18:53:31",

        "ID:071312-60",
        "GPS:+41.40202 -72.44430",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:132 MAIN ST",
        "APT:2",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/13/12",
        "TIME:18:53:31");

    doTest("T44",
        "(CAD Page for CFS 071312-69) \n" +
        "http://maps.google.com/maps?q=+41.39629%20-72.45059\n" +
        "GENERAL SICKNESS\n" +
        "69 MAPLE ST\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : PROSPECT ST * STRAITS RD \n" +
        "Caller: CROMARTY,JOHN & ANN\n" +
        "Disp Time: 07/13/12 20:31:33",

        "ID:071312-69",
        "GPS:+41.39629 -72.45059",
        "CALL:GENERAL SICKNESS",
        "ADDR:69 MAPLE ST",
        "CITY:CHESTER",
        "X:PROSPECT ST & STRAITS RD",
        "NAME:CROMARTY,JOHN & ANN",
        "DATE:07/13/12",
        "TIME:20:31:33");

    doTest("T45",
        "(CAD Page for CFS 071412-43) \n" +
        "http://maps.google.com/maps?q=+41.40640%20-72.47694\n" +
        "Chest Pain ALS\n" +
        "56 WIG HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : N67 * S76 \n" +
        "Caller: SPRINTPCS\n" +
        "Water\\Info: Standpipe: Wig Hill/South Wig\n\n" +
        "Water\\Info: Hydrant: Deep Hollow/Liberty St\n" +
        "Standpipe: Wig Hill/South Wig\n\n" +
        "Disp Time: 07/14/12 14:46:18",

        "ID:071412-43",
        "GPS:+41.40640 -72.47694",
        "CALL:Chest Pain ALS",
        "ADDR:56 WIG HILL RD",
        "CITY:CHESTER",
        "X:N67 & S76",
        "NAME:SPRINTPCS",
        "DATE:07/14/12",
        "TIME:14:46:18");

    doTest("T46",
        "(CAD Page for CFS 071412-80) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "ALTERED MENTAL STATUS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: SLEEPER,E\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/14/12 21:04:41",

        "ID:071412-80",
        "GPS:+41.40202 -72.44430",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:SLEEPER,E",
        "DATE:07/14/12",
        "TIME:21:04:41");

    doTest("T47",
        "(CAD Page for CFS 071412-82) \n" +
        "http://maps.google.com/maps?q=+41.40732%20-72.46606\n" +
        "Electrical Fire Pole/Wire\n" +
        "15 WIG HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : PLEASANT ST * N67 \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: Deep Hollow/Liberty St\n" +
        "Standpipe: Wig Hill/South Wig\n\n" +
        "Disp Time: 07/14/12 21:39:44",

        "ID:071412-82",
        "GPS:+41.40732 -72.46606",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:15 WIG HILL RD",
        "CITY:CHESTER",
        "X:PLEASANT ST & N67",
        "NAME:VERIZON WIRELESS",
        "DATE:07/14/12",
        "TIME:21:39:44");

    doTest("T48",
        "(CAD Page for CFS 071512-3) \n" +
        "http://maps.google.com/maps?q=+41.40681%20-72.43185\n" +
        "Injured Person  BLS\n" +
        "72 RAILROAD AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : VALLEY RAILROAD \n" +
        "Caller: \n" +
        "Water\\Info: Hydrant: 60 Railroad Ave (Ch. Auto/Marine)\n" +
        "Connecticut River, end of Railroad Ave\n\n" +
        "Disp Time: 07/15/12 00:19:03",

        "ID:071512-3",
        "GPS:+41.40681 -72.43185",
        "CALL:Injured Person  BLS",
        "ADDR:72 RAILROAD AVE",
        "CITY:CHESTER",
        "X:VALLEY RAILROAD",
        "DATE:07/15/12",
        "TIME:00:19:03");

    doTest("T49",
        "(CAD Page for CFS 071512-50) \n" +
        "http://maps.google.com/maps?q=+41.41271%20-72.41878\n" +
        "Marine Rescue\n" +
        "54 SELDEN RD\n" +
        "Apt: \n" +
        "LY\n" +
        "Cross Streets : JOSHUATOWN RD \n" +
        "Caller: \n" +
        "Disp Time: 07/15/12 17:34:41",

        "ID:071512-50",
        "GPS:+41.41271 -72.41878",
        "CALL:Marine Rescue",
        "ADDR:54 SELDEN RD",
        "CITY:LYME",
        "X:JOSHUATOWN RD",
        "DATE:07/15/12",
        "TIME:17:34:41");

    doTest("T50",
        "(CAD Page for CFS 071512-60) \n" +
        "http://maps.google.com/maps?q=+41.38833%20-72.52768\n" +
        "Injured Person  BLS\n" +
        "317 W MAIN ST\n" +
        "Apt: 5101\n" +
        "CH\n" +
        "Cross Streets : BUTTER JONES RD * ROUTE 148 \n" +
        "Caller: CHESTER VILLAGE WEST\n" +
        "Disp Time: 07/15/12 21:00:50",

        "ID:071512-60",
        "GPS:+41.38833 -72.52768",
        "CALL:Injured Person  BLS",
        "ADDR:317 W MAIN ST",
        "APT:5101",
        "CITY:CHESTER",
        "X:BUTTER JONES RD & ROUTE 148",
        "NAME:CHESTER VILLAGE WEST",
        "DATE:07/15/12",
        "TIME:21:00:50");

    doTest("T51",
        "(CAD Page for CFS 071612-7) \n" +
        "http://maps.google.com/maps?q=+41.40586%20-72.50800\n" +
        "Electrical Fire Pole/Wire\n" +
        "75 CEDAR LAKE RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : DAVID RD * JENNINGS POND RD \n" +
        "Caller: HAMILTON,ROBERT\n" +
        "Water\\Info: Standpipe: Cedar Lake Rd/Lakeview Ave\n" +
        "Boat launch, end of Bishop Road\n\n" +
        "Disp Time: 07/16/12 06:24:20",

        "ID:071612-7",
        "GPS:+41.40586 -72.50800",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:75 CEDAR LAKE RD",
        "CITY:CHESTER",
        "X:DAVID RD & JENNINGS POND RD",
        "NAME:HAMILTON,ROBERT",
        "DATE:07/16/12",
        "TIME:06:24:20");

    doTest("T52",
        "(CAD Page for CFS 071712-67) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "Injured Person  BLS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/17/12 18:21:10",

        "ID:071712-67",
        "GPS:+41.40202 -72.44430",
        "CALL:Injured Person  BLS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/17/12",
        "TIME:18:21:10");

    doTest("T53",
        "(CAD Page for CFS 071812-28) \n" +
        "http://maps.google.com/maps?q=+41.39415%20-72.51026\n" +
        "Minor MVA -No Medic\n" +
        "250 W MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : WINTHROP RD * SYPHER RD \n" +
        "Caller: ATTMO\n" +
        "Water\\Info: Draft from Cedar Lake\n\n" +
        "Disp Time: 07/18/12 13:43:58",

        "ID:071812-28",
        "GPS:+41.39415 -72.51026",
        "CALL:Minor MVA -No Medic",
        "ADDR:250 W MAIN ST",
        "CITY:CHESTER",
        "X:WINTHROP RD & SYPHER RD",
        "NAME:ATTMO",
        "DATE:07/18/12",
        "TIME:13:43:58");

    doTest("T54",
        "(CAD Page for CFS 071812-36) \n" +
        "http://maps.google.com/maps?q=+41.42893%20-72.45178\n" +
        "Psychiatric BLS\n" +
        "268 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GOOSE HILL RD * SAYBROOK RD \n" +
        "Caller: EAGLE LANDING\n" +
        "Water\\Info: Boat launch, end of Parkers Point La\n\n" +
        "Disp Time: 07/18/12 14:56:46",

        "ID:071812-36",
        "GPS:+41.42893 -72.45178",
        "CALL:Psychiatric BLS",
        "ADDR:268 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:GOOSE HILL RD & SAYBROOK RD",
        "NAME:EAGLE LANDING",
        "DATE:07/18/12",
        "TIME:14:56:46");

    doTest("T55",
        "(CAD Page for CFS 071812-60) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "LOW BLOOD PRESSURE\n" +
        "132 MAIN ST\n" +
        "Apt: 2\n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/18/12 20:33:15",

        "ID:071812-60",
        "GPS:+41.40202 -72.44430",
        "CALL:LOW BLOOD PRESSURE",
        "ADDR:132 MAIN ST",
        "APT:2",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/18/12",
        "TIME:20:33:15");

    doTest("T56",
        "(CAD Page for CFS 071912-17) \n" +
        "http://maps.google.com/maps?q=+41.38833%20-72.52768\n" +
        "GENERAL SICKNESS\n" +
        "317 W MAIN ST\n" +
        "Apt: 1007\n" +
        "CH       \n" +
        "Cross Streets : BUTTER JONES RD * ROUTE 148 \n" +
        "Caller: CHESTER VILLAGE WEST\n" +
        "Water\\Info: Draft from Cedar Lake\n\n" +
        "Disp Time: 07/19/12 09:52:21",

        "ID:071912-17",
        "GPS:+41.38833 -72.52768",
        "CALL:GENERAL SICKNESS",
        "ADDR:317 W MAIN ST",
        "APT:1007",
        "CITY:CHESTER",
        "X:BUTTER JONES RD & ROUTE 148",
        "NAME:CHESTER VILLAGE WEST",
        "DATE:07/19/12",
        "TIME:09:52:21");

    doTest("T57",
        "(CAD Page for CFS 072012-50) \n" +
        "http://maps.google.com/maps?q=+41.45723%20-72.52968\n" +
        "MVA Medic ALS\n" +
        "2 N89\n" +
        "Apt: \n" +
        "HD       \n" +
        "Cross Streets : BEAVER MEADOW RD * ENTR 8 NB \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 07/20/12 18:27:33",

        "ID:072012-50",
        "GPS:+41.45723 -72.52968",
        "CALL:MVA Medic ALS",
        "ADDR:2 N89",
        "CITY:HADDAM",
        "X:BEAVER MEADOW RD & ENTR 8 NB",
        "NAME:VERIZON WIRELESS",
        "DATE:07/20/12",
        "TIME:18:27:33");

    doTest("T58",
        "(CAD Page for CFS 072112-10) \n" +
        "http://maps.google.com/maps?q=+41.39529%20-72.47178\n" +
        "Respiratory Distress ALS\n" +
        "23 HOOP POLE HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : W MAIN ST * PINNACLE LANE \n" +
        "Caller: DEROO, ROBERT\n" +
        "Water\\Info: Waterhole: West Main/Hoophole Hill\n" +
        "Waterhole: West Main/West Wig Hill\n\n" +
        "Disp Time: 07/21/12 07:17:36",

        "ID:072112-10",
        "GPS:+41.39529 -72.47178",
        "CALL:Respiratory Distress ALS",
        "ADDR:23 HOOP POLE HILL RD",
        "CITY:CHESTER",
        "X:W MAIN ST & PINNACLE LANE",
        "NAME:DEROO, ROBERT",
        "DATE:07/21/12",
        "TIME:07:17:36");

    doTest("T59",
        "(CAD Page for CFS 072112-39) \n" +
        "http://maps.google.com/maps?q=+41.39946%20-72.47517\n" +
        "Advanced Life Support\n" +
        "3 S WIG HILL RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : W MAIN ST * TURKEY HILL RD \n" +
        "Caller: HEALTH MGMT,RYDERS\n" +
        "Water\\Info: Standpipe: West Main St/Hoopole Hill\n" +
        "Pond: South Wig/Wig Hill Rd\n\n" +
        "Disp Time: 07/21/12 14:31:19",

        "ID:072112-39",
        "GPS:+41.39946 -72.47517",
        "CALL:Advanced Life Support",
        "ADDR:3 S WIG HILL RD",
        "CITY:CHESTER",
        "X:W MAIN ST & TURKEY HILL RD",
        "NAME:HEALTH MGMT,RYDERS",
        "DATE:07/21/12",
        "TIME:14:31:19");

    doTest("T60",
        "(CAD Page for CFS 072212-28) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "Injured Person  BLS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/22/12 10:53:45",

        "ID:072212-28",
        "GPS:+41.40202 -72.44430",
        "CALL:Injured Person  BLS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/22/12",
        "TIME:10:53:45");

    doTest("T61",
        "(CAD Page for CFS 072212-28) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "ALTERED MENTAL STATUS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/22/12 10:53:45",

        "ID:072212-28",
        "GPS:+41.40202 -72.44430",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/22/12",
        "TIME:10:53:45");

    doTest("T62",
        "(CAD Page for CFS 072212-51) \n" +
        "http://maps.google.com/maps?q=+41.40673%20-72.43442\n" +
        "Basic Life Support \n" +
        "RAILROAD AVE and GROTE RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : MARINA VIEW DR * GROTE RD \n" +
        "Caller: \n" +
        "Disp Time: 07/22/12 14:05:50",

        "ID:072212-51",
        "GPS:+41.40673 -72.43442",
        "CALL:Basic Life Support",
        "ADDR:RAILROAD AVE and GROTE RD",
        "MADDR:RAILROAD AVE & GROTE RD",
        "CITY:CHESTER",
        "X:MARINA VIEW DR & GROTE RD",
        "DATE:07/22/12",
        "TIME:14:05:50");

    doTest("T63",
        "(CAD Page for CFS 072312-13) \n" +
        "http://maps.google.com/maps?q=+41.39405%20-72.46024\n" +
        "Chest Pain ALS\n" +
        "41 BOKUM RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : GORHAM RD * W BRIDGE ST \n" +
        "Caller: MARVIN, SALLY\n" +
        "Water\\Info: Hydrant: Bokum Road/West Main\n" +
        "Hydrant: W Bridge St/W Bridge La, DR\n\n" +
        "Disp Time: 07/23/12 08:06:52",

        "ID:072312-13",
        "GPS:+41.39405 -72.46024",
        "CALL:Chest Pain ALS",
        "ADDR:41 BOKUM RD",
        "CITY:CHESTER",
        "X:GORHAM RD & W BRIDGE ST",
        "NAME:MARVIN, SALLY",
        "DATE:07/23/12",
        "TIME:08:06:52");

    doTest("T64",
        "(CAD Page for CFS 072312-42) \n" +
        "http://maps.google.com/maps?q=+41.40202%20-72.44430\n" +
        "Injured Person  BLS\n" +
        "132 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : SCHOOL LANE * MIDDLESEX AVE \n" +
        "Caller: CHESTERFIELDS HEALTH CAR\n" +
        "Water\\Info: Hydrant: Main St, west of School La\n" +
        "Hydrant: Main St, in front of Chesterfield's\n" +
        "Hydrant: Main St/Mx Av\n\n" +
        "Disp Time: 07/23/12 16:28:23",

        "ID:072312-42",
        "GPS:+41.40202 -72.44430",
        "CALL:Injured Person  BLS",
        "ADDR:132 MAIN ST",
        "CITY:CHESTER",
        "X:SCHOOL LANE & MIDDLESEX AVE",
        "NAME:CHESTERFIELDS HEALTH CAR",
        "DATE:07/23/12",
        "TIME:16:28:23");

    doTest("T65",
        "(CAD Page for CFS 072312-67) \n" +
        "http://maps.google.com/maps?q=+41.40302%20-72.45104\n" +
        "Injured Person  BLS\n" +
        "1 MAIN ST\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : WATER ST * SPRING ST \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: Main/Water Streets\n" +
        "Hydrant: Main/Maple Streets\n\n" +
        "Disp Time: 07/23/12 19:50:40",

        "ID:072312-67",
        "GPS:+41.40302 -72.45104",
        "CALL:Injured Person  BLS",
        "ADDR:1 MAIN ST",
        "CITY:CHESTER",
        "X:WATER ST & SPRING ST",
        "NAME:VERIZON WIRELESS",
        "DATE:07/23/12",
        "TIME:19:50:40");

    doTest("T66",
        "(CAD Page for CFS 072412-36) \n" +
        "http://maps.google.com/maps?q=+41.41880%20-72.44481\n" +
        "Unconcious/Unresponsive ALS\n" +
        "189 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : KINGS HWY * CASTLE VIEW DR \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: Hydrant: Mx Ave/Kings Hwy\n" +
        "Hydrant: Mx Ave at shopping Center\n\n" +
        "Disp Time: 07/24/12 12:50:07",

        "ID:072412-36",
        "GPS:+41.41880 -72.44481",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:189 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:KINGS HWY & CASTLE VIEW DR",
        "NAME:VERIZON WIRELESS",
        "DATE:07/24/12",
        "TIME:12:50:07");

    doTest("T67",
        "(CAD Page for CFS 072412-39) \n" +
        "http://maps.google.com/maps?q=+41.40600%20-72.44194\n" +
        "Psychiatric BLS\n" +
        "86 MIDDLESEX AVE\n" +
        "Apt: \n" +
        "CH\n" +
        "Cross Streets : OLD DEPOT RD * GROTE RD \n" +
        "Caller: GATEWAY COMMUNITY TREATM\n" +
        "Disp Time: 07/24/12 13:30:12",

        "ID:072412-39",
        "GPS:+41.40600 -72.44194",
        "CALL:Psychiatric BLS",
        "ADDR:86 MIDDLESEX AVE",
        "CITY:CHESTER",
        "X:OLD DEPOT RD & GROTE RD",
        "NAME:GATEWAY COMMUNITY TREATM",
        "DATE:07/24/12",
        "TIME:13:30:12");

    doTest("T68",
        "(CAD Page for CFS 072412-41) \n" +
        "http://maps.google.com/maps?q=+41.38834%20-72.50771\n" +
        "HIGH BLOOD PRESSURE\n" +
        "51 WINTHROP RD\n" +
        "Apt: \n" +
        "CH       \n" +
        "Cross Streets : PINE KNOLL DR * AVIATION DR \n" +
        "Caller: WHELEN ENGINEERING CO\n" +
        "Water\\Info: Standpipe: pond at Whelen\n\n" +
        "Water\\Info: Draft from Cedar Lake\n" +
        "Standpipe: pond at Whelen\n\n" +
        "Disp Time: 07/24/12 13:41:49",

        "ID:072412-41",
        "GPS:+41.38834 -72.50771",
        "CALL:HIGH BLOOD PRESSURE",
        "ADDR:51 WINTHROP RD",
        "CITY:CHESTER",
        "X:PINE KNOLL DR & AVIATION DR",
        "NAME:WHELEN ENGINEERING CO",
        "DATE:07/24/12",
        "TIME:13:41:49");

  }
  
  @Test
  public void testActive911D() {

    doTest("T1",
        "(CAD Page for CFS 091312-46) Reference\n" +
        "TANKER 463 IN SERVICE\n" +
        "Apt: \n" +
        "WB\n" +
        "Caller: 411\n" +
        "Disp Time: 09/13/12 13:55:28\n\n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000",

        "ID:091312-46",
        "CALL:Reference",
        "ADDR:TANKER 463 IN SERVICE",
        "CITY:WESTBROOK",
        "NAME:411",
        "DATE:09/13/12",
        "TIME:13:55:28");

    doTest("T2",
        "(CAD Page for CFS 091312-71) Respiratory Distress ALS\n" +
        "1 S6564\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : ESSEX RD * ENTR 65 SB \n" +
        "Caller: \n" +
        "Disp Time: 09/13/12 20:01:59\n\n" +
        "http://maps.google.com/maps?q=+41.29185%20-72.44573",

        "ID:091312-71",
        "GPS:+41.29185 -72.44573",
        "CALL:Respiratory Distress ALS",
        "ADDR:1 S6564",
        "CITY:WESTBROOK",
        "X:ESSEX RD & ENTR 65 SB",
        "DATE:09/13/12",
        "TIME:20:01:59");

    doTest("T3",
        "(CAD Page for CFS 091312-83) Bleeding ALS -Arterial\n" +
        "97 SEASIDE AVE\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : PERIGEE LANE * APOGEE LANE \n" +
        "Caller: TIDELAWN MANOR/REST HOME\n" +
        "Disp Time: 09/13/12 22:14:34\n\n" +
        "http://maps.google.com/maps?q=+41.28008%20-72.45554",

        "ID:091312-83",
        "GPS:+41.28008 -72.45554",
        "CALL:Bleeding ALS -Arterial",
        "ADDR:97 SEASIDE AVE",
        "CITY:WESTBROOK",
        "X:PERIGEE LANE & APOGEE LANE",
        "NAME:TIDELAWN MANOR/REST HOME",
        "DATE:09/13/12",
        "TIME:22:14:34");

    doTest("T4",
        "(CAD Page for CFS 091412-35) SYNCOPE\n" +
        "10 OAK DR\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : LILAC LANE \n" +
        "Caller: ROONEY,BARBARA\n" +
        "Disp Time: 09/14/12 15:26:22\n\n" +
        "http://maps.google.com/maps?q=+41.27655%20-72.48555",

        "ID:091412-35",
        "GPS:+41.27655 -72.48555",
        "CALL:SYNCOPE",
        "ADDR:10 OAK DR",
        "CITY:WESTBROOK",
        "X:LILAC LANE",
        "NAME:ROONEY,BARBARA",
        "DATE:09/14/12",
        "TIME:15:26:22");

    doTest("T5",
        "(CAD Page for CFS 091412-47) Traumatic Injury ALS\n" +
        "156 MC VEAGH RD\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : WILLARD AVE * MEETINGHOUSE LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 09/14/12 17:04:08\n\n" +
        "http://maps.google.com/maps?q=+41.29750%20-72.45377",

        "ID:091412-47",
        "GPS:+41.29750 -72.45377",
        "CALL:Traumatic Injury ALS",
        "ADDR:156 MCVEAGH RD",
        "CITY:WESTBROOK",
        "X:WILLARD AVE & MEETINGHOUSE LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:09/14/12",
        "TIME:17:04:08");

    doTest("T6",
        "(CAD Page for CFS 091512-5) SYNCOPE\n" +
        "54 EDGEWOOD DR\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : CROSS RD * MAL A BAR DR \n" +
        "Caller: AXELROD,MICHAEL\n" +
        "Disp Time: 09/15/12 01:43:28\n\n" +
        "http://maps.google.com/maps?q=+41.33231%20-72.49024",

        "ID:091512-5",
        "GPS:+41.33231 -72.49024",
        "CALL:SYNCOPE",
        "ADDR:54 EDGEWOOD DR",
        "CITY:WESTBROOK",
        "X:CROSS RD & MAL A BAR DR",
        "NAME:AXELROD,MICHAEL",
        "DATE:09/15/12",
        "TIME:01:43:28");

  }
  
  public static void main(String[] args) {
    new CTMiddlesexCountyParserTest().generateTests("T1");
  }
}