package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Middlesex County, CT
Contact: Donald Izzo <dizzo32@gmail.com>
Sender: administrator@valleyshore911.org
(CAD Page for CFS 040213-44) Injured Person  BLS\n33 PARKER LANE\nApt: \nWB       \nCross Streets : SALT ISLAND RD \nCaller: VERIZON WIRELESS\nDisp
(CAD Page for CFS 040313-17) Bleeding ALS -Arterial\n107 BUSHY HILL RD\nApt: \nDR       \nCross Streets : NATURE TR * LYNN RD \nCaller: SANTERRE,T
(CAD Page for CFS 040413-1) Inside Smoke -Structure Fire\n324 COLD SPRING DR\nApt: \nWB\nCross Streets : PLYMOUTH RD \nCaller: KNECHT,ROBIN\nDisp T
(CAD Page for CFS 061213-43) Seizures ALS\n60 POND MEADOW RD\nApt: \nWB       \nCross Streets : AMTRAK RAILROAD * WESTBROOK INDUSTRIAL PARK RD \nCa

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

Contact: Active911
Agency name: Westbrook Fire Dept Location: Westbrook, CT 
Sender: LogiSYS@smtp114.sbc.mail.ne1.yahoo.com, CAD@smtp114.sbc.mail.ne1.yahoo.com
  
(CAD Page for CFS 091312-46) Reference\nTANKER 463 IN SERVICE\nApt: \nWB\nCaller: 411\nDisp Time: 09/13/12 13:55:28\n\nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000
(CAD Page for CFS 091312-71) Respiratory Distress ALS\n1 S6564\nApt: \nWB       \nCross Streets : ESSEX RD * ENTR 65 SB \nCaller: \nDisp Time: 09/13/12 20:01:59\n\nhttp://maps.google.com/maps?q=+41.29185%20-72.44573
(CAD Page for CFS 091312-83) Bleeding ALS -Arterial\n97 SEASIDE AVE\nApt: \nWB       \nCross Streets : PERIGEE LANE * APOGEE LANE \nCaller: TIDELAWN MANOR/REST HOME\nDisp Time: 09/13/12 22:14:34\n\nhttp://maps.google.com/maps?q=+41.28008%20-72.45554
(CAD Page for CFS 091412-35) SYNCOPE\n10 OAK DR\nApt: \nWB       \nCross Streets : LILAC LANE \nCaller: ROONEY,BARBARA\nDisp Time: 09/14/12 15:26:22\n\nhttp://maps.google.com/maps?q=+41.27655%20-72.48555
(CAD Page for CFS 091412-47) Traumatic Injury ALS\n156 MC VEAGH RD\nApt: \nWB       \nCross Streets : WILLARD AVE * MEETINGHOUSE LANE \nCaller: VERIZON WIRELESS\nDisp Time: 09/14/12 17:04:08\n\nhttp://maps.google.com/maps?q=+41.29750%20-72.45377
(CAD Page for CFS 091512-5) SYNCOPE\n54 EDGEWOOD DR\nApt: \nWB       \nCross Streets : CROSS RD * MAL A BAR DR \nCaller: AXELROD,MICHAEL\nDisp Time: 09/15/12 01:43:28\n\nhttp://maps.google.com/maps?q=+41.33231%20-72.49024

Contact: Active911
Agency name: Old Lyme Ambulance
Location: Old Lyme, CT, United States
Sender: LogiSYS CAD

(CAD Page for CFS 041613-34) SYNCOPE\n114 MILE CREEK RD\nApt: \nOL       \nCross Streets : BUTTONBALL RD * ROWLAND RD \nCaller: WILLARD, SAMUEL\nWater\Info: HLFW16 80 MILE CREEK RD\n\nDisp Time: 04/16/13 15:07:58\n\nhttp://maps.google.com/maps?q=+41.30615%20-72.30125
(CAD Page for CFS 041413-82) SYNCOPE\n249 BOSTON POST RD\nApt: 13\nOL       \nCross Streets : LORDS MEADOW LANE * LYMEWOOD HOUSING \nCaller: \nWater\Info: HLFW35 245 BOSTON POST RD\n\nWater\Info: LYMEWOOD HOUSING * 1ST BLDG ON LEFT * KNOX BOX TO RIGHT OF FRONT DOOR\n\nDisp Time: 04/14/13 19:20:57\n\nhttp://maps.google.com/maps?q=+41.34942%20-72.28587
(CAD Page for CFS 041413-78) ALTERED MENTAL STATUS\n11 HILLSIDE RD\nApt: \nOL\nCross Streets : LEDGEWOOD DR * BOSTON POST RD \nCaller: MC*ELROY,JOHN D\nDisp Time: 04/14/13 18:01:06\n\nhttp://maps.google.com/maps?q=+41.33926%20-72.31168
(CAD Page for CFS 041313-54) Chest Pain ALS\n32 BUTTONBALL RD\nApt: \nOL       \nCross Streets : SHORE RD * AMTRAK \nCaller: SPRINTPCS\nWater\Info: HLFW28 36 BUTTONBALL RD\n\nDisp Time: 04/13/13 14:09:55\n\nhttp://maps.google.com/maps?q=+41.28976%20-72.30506
(CAD Page for CFS 041113-8) ALTERED MENTAL STATUS\n19 HALLS RD\nApt: \nOL       \nCross Streets : LYME ST * DAVIS RD E \nCaller: LAWRENCE & MEMORIAL PHYS\nWater\Info: HLFW09 REAR OLD LYME SHOPPING CENTER\n\nWater\Info: OL FAMILY PRACTICE * KNOX BOX * LEFT OF THE FRONT DOOR\n\nWater\Info: OLD LYME SHOPPING CENTER * KNOX BOX * BY ENTRANCE TO 2ND FLR OFFICES * R SIDE OF ENTRY DOORS\n\nDisp Time: 04/11/13 09:42:26\n\nhttp://maps.google.com/maps?q=+41.32386%20-72.32980
(CAD Page for CFS 040913-16) MVA Medic ALS\n1 S7170\nApt: \nOL       \nCross Streets : FOUR MILE RIVER RD * ENTR 71 SB \nCaller: \nWater\Info: TSFW50 1 ENTERPRISE DR\n\nDisp Time: 04/09/13 08:58:36\n\nhttp://maps.google.com/maps?q=+41.32223%20-72.26015
(CAD Page for CFS 040813-24) Brush Fire\n79 ROWLAND RD\nApt: \nOL\nCross Streets : MILE CREEK RD \nCaller: ALGER,F W\nDisp Time: 04/08/13 11:38:05\n\nhttp://maps.google.com/maps?q=+41.31458%20-72.29105
(CAD Page for CFS 040713-1) Injured Person  BLS\n13 CONNECTICUT RD\nApt: \nOL       \nCross Streets : SHORE ACRES RD * RIDGEWOOD RD \nCaller: VERIZON WIRELESS\nWater\Info: HLFW57 BOAT BASIN\n\nDisp Time: 04/07/13 00:44:47\n\nhttp://maps.google.com/maps?q=+41.29559%20-72.25789
(CAD Page for CFS 040613-50) Structure Fire\n30 BEN FRANKLIN RD\nApt: \nOL       \nCross Streets : MILE CREEK RD \nCaller: WHITLEY,J. PETER\nWater\Info: TSFW16 80 MILE CREEK RD\n\nDisp Time: 04/06/13 16:18:34\n\nhttp://maps.google.com/maps?q=+41.30330%20-72.31361
(CAD Page for CFS 040613-50) Brush Fire\n30 BEN FRANKLIN RD\nApt: \nOL       \nCross Streets : MILE CREEK RD \nCaller: WHITLEY,J. PETER\nWater\Info: TSFW16 80 MILE CREEK RD\n\nDisp Time: 04/06/13 16:18:34\n\nhttp://maps.google.com/maps?q=+41.30330%20-72.31361

*/

public class CTMiddlesexCountyParserTest extends BaseParserTest {
  
  public CTMiddlesexCountyParserTest() {
    setParser(new CTMiddlesexCountyParser(), "MIDDLESEX COUNTY", "CT");
  }
  
  @Test
  public void testDizzyo() {

    doTest("T1",
        "(CAD Page for CFS 040213-44) Injured Person  BLS\n" +
        "33 PARKER LANE\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : SALT ISLAND RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp",

        "ID:040213-44",
        "CALL:Injured Person  BLS",
        "ADDR:33 PARKER LANE",
        "CITY:WESTBROOK",
        "X:SALT ISLAND RD");

    doTest("T2",
        "(CAD Page for CFS 040313-17) Bleeding ALS -Arterial\n" +
        "107 BUSHY HILL RD\n" +
        "Apt: \n" +
        "DR       \n" +
        "Cross Streets : NATURE TR * LYNN RD \n" +
        "Caller: SANTERRE,T",

        "ID:040313-17",
        "CALL:Bleeding ALS -Arterial",
        "ADDR:107 BUSHY HILL RD",
        "CITY:DEEP RIVER",
        "X:NATURE TR & LYNN RD",
        "NAME:SANTERRE,T");

    doTest("T3",
        "(CAD Page for CFS 040413-1) Inside Smoke -Structure Fire\n" +
        "324 COLD SPRING DR\n" +
        "Apt: \n" +
        "WB\n" +
        "Cross Streets : PLYMOUTH RD \n" +
        "Caller: KNECHT,ROBIN\n" +
        "Disp T",

        "ID:040413-1",
        "CALL:Inside Smoke -Structure Fire",
        "ADDR:324 COLD SPRING DR",
        "CITY:WESTBROOK",
        "X:PLYMOUTH RD",
        "NAME:KNECHT,ROBIN");

    doTest("T4",
        "(CAD Page for CFS 061213-43) Seizures ALS\n" +
        "60 POND MEADOW RD\n" +
        "Apt: \n" +
        "WB       \n" +
        "Cross Streets : AMTRAK RAILROAD * WESTBROOK INDUSTRIAL PARK RD \n" +
        "Ca",

        "ID:061213-43",
        "CALL:Seizures ALS",
        "ADDR:60 POND MEADOW RD",
        "CITY:WESTBROOK",
        "X:AMTRAK RAILROAD & WESTBROOK INDUSTRIAL PARK RD");
  
  }
  
  @Test
  public void testDurhamVolFire() {

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
        "GPS:+41.486180,-72.657190",
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
        "GPS:+41.448520,-72.701190",
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
        "GPS:+41.480250,-72.663250",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:MAIDEN LANE and BEAR ROCK RD",
        "MADDR:MAIDEN LANE & BEAR ROCK RD",
        "CITY:DURHAM",
        "X:SYCAMORE DR & MAIDEN LANE",
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
        "GPS:+41.437340,-72.719280",
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
        "GPS:+41.482820,-72.681720",
        "CALL:Minor MVA -No Medic",
        "ADDR:310 MAIN ST",
        "CITY:DURHAM",
        "X:MAIDEN LANE & TALCOTT LANE",
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
        "GPS:+41.474460,-72.682280",
        "CALL:MVA Medic ALS",
        "ADDR:68 MAPLE AVE",
        "CITY:DURHAM",
        "X:JOHNS WAY & OLD CEMETERY RD",
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
        "GPS:+41.474000,-72.680240",
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
        "GPS:+41.478180,-72.681080",
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
        "GPS:+41.478280,-72.670830",
        "CALL:Wires Down -Call NU",
        "ADDR:135 PICKETT LANE",
        "CITY:DURHAM",
        "X:MAIN ST & MAIDEN LANE",
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
        "GPS:+41.478960,-72.681200",
        "CALL:Minor MVA -No Medic",
        "ADDR:238 MAIN ST",
        "CITY:DURHAM",
        "X:WALLINGFORD RD & MAIDEN LANE",
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
        "GPS:+41.336980,-72.584930",
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
        "GPS:+41.487720,-72.642300",
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
        "GPS:+41.490940,-72.650920",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:HADDAM QUARTER RD and ARBUTUS ST",
        "MADDR:HADDAM QUARTER RD & ARBUTUS ST",
        "CITY:DURHAM",
        "X:WINTERBERRY LANE & HADDAM QUARTER RD",
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
        "GPS:+41.465900,-72.674950",
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
        "GPS:+41.466740,-72.659590",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:291 HIGGANUM RD",
        "CITY:DURHAM",
        "X:TRINITY HILL DR & BEAR ROCK RD",
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
        "GPS:+41.495940,-72.646580",
        "CALL:Fire Alarm",
        "ADDR:23 CHEYENNE TR",
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
        "MADDR:OLD JOHNSON LANE & MILBROOK",
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
        "MADDR:ROUTE 149 & ROUTE 16",
        "DATE:07/08/12",
        "TIME:01:23:01");

  }
  
  @Test
  public void testChesterHoseCo() {

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
        "GPS:+41.408150,-72.440950",
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
        "GPS:+41.422970,-72.447170",
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
        "GPS:+41.402020,-72.444300",
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
        "GPS:+41.407940,-72.510490",
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
        "GPS:+41.399460,-72.475170",
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
        "GPS:+41.388330,-72.527680",
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
        "GPS:+41.398960,-72.465100",
        "CALL:Wires Down -Call NU",
        "ADDR:100 W MAIN ST",
        "CITY:CHESTER",
        "X:SPRING ST & INSPIRATION LANE",
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
        "GPS:+41.428930,-72.451780",
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
        "GPS:+41.409700,-72.440250",
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
        "GPS:+41.399460,-72.475170",
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
        "GPS:+41.400860,-72.442090",
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
        "GPS:+41.409360,-72.428990",
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
        "GPS:+41.406900,-72.433490",
        "CALL:Police General",
        "ADDR:60 RAILROAD AVE",
        "CITY:CHESTER",
        "X:VALLEY RAILROAD",
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
        "GPS:+41.428930,-72.451780",
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
        "GPS:+41.402020,-72.444300",
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
        "GPS:+41.409030,-72.512730",
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
        "GPS:+41.422970,-72.447170",
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
        "GPS:+41.385510,-72.450100",
        "CALL:MVA Medic ALS",
        "ADDR:1 S65",
        "CITY:CHESTER",
        "X:EXIT 5 SB & ENTR 5 SB",
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
        "GPS:+41.405270,-72.507050",
        "CALL:Injured Person  BLS",
        "ADDR:CEDAR LAKE RD and DAVID RD",
        "MADDR:CEDAR LAKE RD & DAVID RD",
        "CITY:CHESTER",
        "X:CEDAR LAKE RD & BROOKSIDE RD",
        "NAME:car 7",
        "DATE:07/05/12",
        "TIME:19:04:43");

  }
  
  @Test
  public void testAWestbrookFire() {

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
        "GPS:+41.291850,-72.445730",
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
        "GPS:+41.280080,-72.455540",
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
        "GPS:+41.276550,-72.485550",
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
        "GPS:+41.297500,-72.453770",
        "CALL:Traumatic Injury ALS",
        "ADDR:156 MCVEAGH RD",
        "CITY:WESTBROOK",
        "X:WILLARD AVE & MEETINGHOUSE LANE",
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
        "GPS:+41.332310,-72.490240",
        "CALL:SYNCOPE",
        "ADDR:54 EDGEWOOD DR",
        "CITY:WESTBROOK",
        "X:CROSS RD & MAL A BAR DR",
        "NAME:AXELROD,MICHAEL",
        "DATE:09/15/12",
        "TIME:01:43:28");

  }
  
  @Test
  public void testOldLymeAmbulance2() {

    doTest("T1",
        "(CAD Page for CFS 041613-34) SYNCOPE\n" +
        "114 MILE CREEK RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BUTTONBALL RD * ROWLAND RD \n" +
        "Caller: WILLARD, SAMUEL\n" +
        "Water\\Info: HLFW16 80 MILE CREEK RD\n\n" +
        "Disp Time: 04/16/13 15:07:58\n\n" +
        "http://maps.google.com/maps?q=+41.30615%20-72.30125",

        "ID:041613-34",
        "CALL:SYNCOPE",
        "ADDR:114 MILE CREEK RD",
        "CITY:OLD LYME",
        "X:BUTTONBALL RD & ROWLAND RD",
        "NAME:WILLARD, SAMUEL",
        "DATE:04/16/13",
        "TIME:15:07:58",
        "GPS:+41.306150,-72.301250");

    doTest("T2",
        "(CAD Page for CFS 041413-82) SYNCOPE\n" +
        "249 BOSTON POST RD\n" +
        "Apt: 13\n" +
        "OL       \n" +
        "Cross Streets : LORDS MEADOW LANE * LYMEWOOD HOUSING \n" +
        "Caller: \n" +
        "Water\\Info: HLFW35 245 BOSTON POST RD\n\n" +
        "Water\\Info: LYMEWOOD HOUSING * 1ST BLDG ON LEFT * KNOX BOX TO RIGHT OF FRONT DOOR\n\n" +
        "Disp Time: 04/14/13 19:20:57\n\n" +
        "http://maps.google.com/maps?q=+41.34942%20-72.28587",

        "ID:041413-82",
        "CALL:SYNCOPE",
        "ADDR:249 BOSTON POST RD",
        "APT:13",
        "CITY:OLD LYME",
        "X:LORDS MEADOW LANE & LYMEWOOD HOUSING",
        "DATE:04/14/13",
        "TIME:19:20:57",
        "GPS:+41.349420,-72.285870");

    doTest("T3",
        "(CAD Page for CFS 041413-78) ALTERED MENTAL STATUS\n" +
        "11 HILLSIDE RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : LEDGEWOOD DR * BOSTON POST RD \n" +
        "Caller: MC*ELROY,JOHN D\n" +
        "Disp Time: 04/14/13 18:01:06\n\n" +
        "http://maps.google.com/maps?q=+41.33926%20-72.31168",

        "ID:041413-78",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:11 HILLSIDE RD",
        "CITY:OLD LYME",
        "X:LEDGEWOOD DR & BOSTON POST RD",
        "NAME:MC*ELROY,JOHN D",
        "DATE:04/14/13",
        "TIME:18:01:06",
        "GPS:+41.339260,-72.311680");

    doTest("T4",
        "(CAD Page for CFS 041313-54) Chest Pain ALS\n" +
        "32 BUTTONBALL RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * AMTRAK \n" +
        "Caller: SPRINTPCS\n" +
        "Water\\Info: HLFW28 36 BUTTONBALL RD\n\n" +
        "Disp Time: 04/13/13 14:09:55\n\n" +
        "http://maps.google.com/maps?q=+41.28976%20-72.30506",

        "ID:041313-54",
        "CALL:Chest Pain ALS",
        "ADDR:32 BUTTONBALL RD",
        "CITY:OLD LYME",
        "X:SHORE RD & AMTRAK",
        "DATE:04/13/13",
        "TIME:14:09:55",
        "GPS:+41.289760,-72.305060");

    doTest("T5",
        "(CAD Page for CFS 041113-8) ALTERED MENTAL STATUS\n" +
        "19 HALLS RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LYME ST * DAVIS RD E \n" +
        "Caller: LAWRENCE & MEMORIAL PHYS\n" +
        "Water\\Info: HLFW09 REAR OLD LYME SHOPPING CENTER\n\n" +
        "Water\\Info: OL FAMILY PRACTICE * KNOX BOX * LEFT OF THE FRONT DOOR\n\n" +
        "Water\\Info: OLD LYME SHOPPING CENTER * KNOX BOX * BY ENTRANCE TO 2ND FLR OFFICES * R SIDE OF ENTRY DOORS\n\n" +
        "Disp Time: 04/11/13 09:42:26\n\n" +
        "http://maps.google.com/maps?q=+41.32386%20-72.32980",

        "ID:041113-8",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:19 HALLS RD",
        "CITY:OLD LYME",
        "X:LYME ST & DAVIS RD E",
        "NAME:LAWRENCE & MEMORIAL PHYS",
        "DATE:04/11/13",
        "TIME:09:42:26",
        "GPS:+41.323860,-72.329800");

    doTest("T6",
        "(CAD Page for CFS 040913-16) MVA Medic ALS\n" +
        "1 S7170\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : FOUR MILE RIVER RD * ENTR 71 SB \n" +
        "Caller: \n" +
        "Water\\Info: TSFW50 1 ENTERPRISE DR\n\n" +
        "Disp Time: 04/09/13 08:58:36\n\n" +
        "http://maps.google.com/maps?q=+41.32223%20-72.26015",

        "ID:040913-16",
        "CALL:MVA Medic ALS",
        "ADDR:1 S7170",
        "CITY:OLD LYME",
        "X:FOUR MILE RIVER RD & ENTR 71 SB",
        "DATE:04/09/13",
        "TIME:08:58:36",
        "GPS:+41.322230,-72.260150");

    doTest("T7",
        "(CAD Page for CFS 040813-24) Brush Fire\n" +
        "79 ROWLAND RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : MILE CREEK RD \n" +
        "Caller: ALGER,F W\n" +
        "Disp Time: 04/08/13 11:38:05\n\n" +
        "http://maps.google.com/maps?q=+41.31458%20-72.29105",

        "ID:040813-24",
        "CALL:Brush Fire",
        "ADDR:79 ROWLAND RD",
        "CITY:OLD LYME",
        "X:MILE CREEK RD",
        "NAME:ALGER,F W",
        "DATE:04/08/13",
        "TIME:11:38:05",
        "GPS:+41.314580,-72.291050");

    doTest("T8",
        "(CAD Page for CFS 040713-1) Injured Person  BLS\n" +
        "13 CONNECTICUT RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE ACRES RD * RIDGEWOOD RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW57 BOAT BASIN\n\n" +
        "Disp Time: 04/07/13 00:44:47\n\n" +
        "http://maps.google.com/maps?q=+41.29559%20-72.25789",

        "ID:040713-1",
        "CALL:Injured Person  BLS",
        "ADDR:13 CONNECTICUT RD",
        "CITY:OLD LYME",
        "X:SHORE ACRES RD & RIDGEWOOD RD",
        "DATE:04/07/13",
        "TIME:00:44:47",
        "GPS:+41.295590,-72.257890");

    doTest("T9",
        "(CAD Page for CFS 040613-50) Structure Fire\n" +
        "30 BEN FRANKLIN RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD \n" +
        "Caller: WHITLEY,J. PETER\n" +
        "Water\\Info: TSFW16 80 MILE CREEK RD\n\n" +
        "Disp Time: 04/06/13 16:18:34\n\n" +
        "http://maps.google.com/maps?q=+41.30330%20-72.31361",

        "ID:040613-50",
        "CALL:Structure Fire",
        "ADDR:30 BEN FRANKLIN RD",
        "CITY:OLD LYME",
        "X:MILE CREEK RD",
        "NAME:WHITLEY,J. PETER",
        "DATE:04/06/13",
        "TIME:16:18:34",
        "GPS:+41.303300,-72.313610");

    doTest("T10",
        "(CAD Page for CFS 040613-50) Brush Fire\n" +
        "30 BEN FRANKLIN RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD \n" +
        "Caller: WHITLEY,J. PETER\n" +
        "Water\\Info: TSFW16 80 MILE CREEK RD\n\n" +
        "Disp Time: 04/06/13 16:18:34\n\n" +
        "http://maps.google.com/maps?q=+41.30330%20-72.31361",

        "ID:040613-50",
        "CALL:Brush Fire",
        "ADDR:30 BEN FRANKLIN RD",
        "CITY:OLD LYME",
        "X:MILE CREEK RD",
        "NAME:WHITLEY,J. PETER",
        "DATE:04/06/13",
        "TIME:16:18:34",
        "GPS:+41.303300,-72.313610");

  }
  
  public static void main(String[] args) {
    new CTMiddlesexCountyParserTest().generateTests("T1");
  }
}