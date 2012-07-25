package net.anei.cadpage.parsers.CT;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

*/

public class CTMiddlesexCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile(".*CAD Page for CFS (\\d{6,}-\\d+)");
  
  public CTMiddlesexCountyParser() {
    super(CITY_CODES, "MIDDLESEX COUNTY", "CT",
          "GPS! CALL! ADDR! Apt:APT! CITY! Cross_Streets:X? Caller:NAME! Disp_Time:DATETIME!");
  }

  @Override
  public String getFilter() {
    return ".sbc.mail.gq1.yahoo.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    return parseFields(body.split("\n"), 7, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern GPS_PATTERN = Pattern.compile("http://maps\\.google\\.com/maps\\?q=([-+]*\\d+\\.\\d+ +[-+]*\\d+\\.\\d+)");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("%20", " ");
      Matcher match = GPS_PATTERN.matcher(field);
      if (!match.matches()) abort();
      String gps =  match.group(1);
      if (!gps.equals("+-1.00000 --1.00000")) super.parse(match.group(1), data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      while (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" * ", " & ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("GPS")) return new MyGPSField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CH", "CHESTER",
      "ch", "CHESTER",
      "DH", "DURHAM",
      "dh", "DURHAM",
      "DR", "DEEP RIVER",
      "dr", "DEEP RIVER",
      "HD", "HADDAM",
      "hd", "HADDAM",
      "LY", "LYME",
      "ly", "LYME",
      "KW", "KILLINGWORTH",
      "kw", "KILLINGWORTH",
      "MD", "MIDDLETOWN",
      "md", "MIDDLETOWN",
      "OL", "OLD LYME",
      "ol", "OLD LYME",
      "OS", "OLD SAYBROOK",
      "os", "OLD SAYBROOK"
  });
}
