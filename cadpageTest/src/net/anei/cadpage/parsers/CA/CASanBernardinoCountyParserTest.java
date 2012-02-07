package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CASanBernardinoCountyParserTest extends BaseParserTest {
  
  public CASanBernardinoCountyParserTest() {
    setParser(new CASanBernardinoCountyParser(), "SAN BERNARDINO COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[] | TU - T>W Cypress Ave / S Center St - REDC >LOC INFO: >AGN MAP:RED045 -TB MAP:648 B2 >X ST: >E261,MS261,AMR33>COMMENTS:GREEN 300 vs BLACK SEDAN,External Case Number 'RED _1200689' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: \n",
        "CALL:TU - T - TC with Unknown Injuries",
        "ADDR:W Cypress Ave & S Center St",
        "CITY:REDLANDS",
        "MAP:RED045 - 648 B2",
        "UNIT:E261,MS261,AMR33",
        "INFO:GREEN 300 vs BLACK SEDAN");

    doTest("T2",
        "[] | HEART->1600 E Citrus Ave -A REDC >LOC INFO:DR HOENSHELL >AGN MAP:RED069 -TB MAP:608 F7 >X ST:N DEARBORN ST/S LA SALLE ST >E261,MS261,AMR37>COMMENTS:[ProQA Session Aborted] ALLIED AGENCY,External Case Number 'RED _1200691' added for Redlands.,Automatic C\n",
        "CALL:HEART-",
        "ADDR:1600 E Citrus Ave",
        "APT:A",
        "CITY:REDLANDS",
        "PLACE:DR HOENSHELL",
        "MAP:RED069 - 608 F7",
        "X:N DEARBORN ST/S LA SALLE ST",
        "UNIT:E261,MS261,AMR37",
        "INFO:ALLIED AGENCY");

    doTest("T3",
        "[] | SICK-D>105 Terracina Blvd -106-a REDC >LOC INFO:BROOKSIDE HEALTH >AGN MAP:RED043 -TB MAP:647 H2 >X ST:BROOKSIDE AVE/CORDOVA AVE >E264,ME263R,AMR39>COMMENTS:793-2271,[ProQA Script] Dispatch code: 26D01 85 year old, Male, Conscious, Breathing. Sick Person\n",
        "CALL:SICK-D - Sick Person",
        "ADDR:105 Terracina Blvd",
        "APT:106-a",
        "CITY:REDLANDS",
        "PLACE:BROOKSIDE HEALTH",
        "MAP:RED043 - 647 H2",
        "X:BROOKSIDE AVE/CORDOVA AVE",
        "UNIT:E264,ME263R,AMR39",
        "CODE:26D01",
        "INFO:793-2271, 85 year old, Male, Conscious, Breathing. Sick Person");

    doTest("T4",
        "[] | PS - P>27320 W Lugonia Ave - RED >LOC INFO:TARGET (RED) >AGN MAP:RED092 -TB MAP:607 H5 >X ST:INDIANA CT/N ALABAMA ST >E264>COMMENTS:CHILD LOCKED IN A WHITE CADILAC CTS,RED,External Case Number 'RED _1200693' added for Redlands.,\n",
        "CALL:PS - P - Public Service",
        "ADDR:27320 W Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:TARGET (RED)",
        "MAP:RED092 - 607 H5",
        "X:INDIANA CT/N ALABAMA ST",
        "UNIT:E264",
        "INFO:CHILD LOCKED IN A WHITE CADILAC CTS,RED");

    doTest("T5",
        "[] | UNC-D2>205 Judson St -C REDC >LOC INFO:JUDSON APTS >AGN MAP:RED068 -TB MAP:608 E7 >X ST:CENTRAL AVE/LARAMIE AVE >E261,MS261,AMR32>COMMENTS:[ProQA Script] Dispatch code: 31D02 35 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Un\n",
        "CALL:UNC-D2 - Unconscious Person",
        "ADDR:205 Judson St",
        "APT:C",
        "CITY:REDLANDS",
        "PLACE:JUDSON APTS",
        "MAP:RED068 - 608 E7",
        "X:CENTRAL AVE/LARAMIE AVE",
        "UNIT:E261,MS261,AMR32",
        "CODE:31D02",
        "INFO:35 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Un");

    doTest("T6",
        "[] | CP-D2 >1331 W Colton Ave - REDC >LOC INFO:HUSTLER CLUB-DE JA VU >AGN MAP:RED078 -TB MAP:607 J6 >X ST:INDUSTRIAL PARK AVE/TRI-CITY CENTER DR >E264,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06252000 LON:-117.203372 METERS:57 %:063,ENTER THROUGH THE BACK IOF THE B\n",
        "CALL:CP-D2 - Chest Pains",
        "ADDR:1331 W Colton Ave",
        "CITY:REDLANDS",
        "PLACE:HUSTLER CLUB-DE JA VU",
        "MAP:RED078 - 607 J6",
        "X:INDUSTRIAL PARK AVE/TRI-CITY CENTER DR",
        "UNIT:E264,ME263R,AMR39",
        "INFO:WPH2 LAT:34.06252000 LON:-117.203372 METERS:57 %:063,ENTER THROUGH THE BACK IOF THE B");

    doTest("T7",
        "[] | ABD-A1>101 W Redlands Blvd - REDC >LOC INFO:SAVON DRUG STORE >AGN MAP:RED066 -TB MAP:608 B7 >X ST:N 4TH ST/3RD ST >E261,MS261,AMR35>COMMENTS:PT IN PHARMACY,[ProQA Script] Dispatch code: 01A01 45 year old, Female, Conscious, Breathing. Abdominal Pain / P\n",
        "CALL:ABD-A1 - Abdominal Pain",
        "ADDR:101 W Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:SAVON DRUG STORE",
        "MAP:RED066 - 608 B7",
        "X:N 4TH ST/3RD ST",
        "UNIT:E261,MS261,AMR35",
        "CODE:01A01",
        "INFO:PT IN PHARMACY, 45 year old, Female, Conscious, Breathing. Abdominal Pain / P");

    doTest("T8",
        "[] | FALL-B>620 E Highland Ave -26 REDC >LOC INFO:BRASWELLS CHATEAU >AGN MAP:RED046 -TB MAP:648 D2 >X ST:E REDLANDS BLVD/ROOSEVELT RD >E262,MS261,AMR30>COMMENTS:WPH2 LAT:34.04472100 LON:-117.164211 METERS:41 %:095,[ProQA Script] Dispatch code: 17B02G 97 year\n",
        "CALL:FALL-B - Fall Victim",
        "ADDR:620 E Highland Ave",
        "APT:26",
        "CITY:REDLANDS",
        "PLACE:BRASWELLS CHATEAU",
        "MAP:RED046 - 648 D2",
        "X:E REDLANDS BLVD/ROOSEVELT RD",
        "UNIT:E262,MS261,AMR30",
        "CODE:17B02G",
        "INFO:WPH2 LAT:34.04472100 LON:-117.164211 METERS:41 %:095, 97 year");

    doTest("T9",
        "[] | BIRTH->1320 Industrial Park Ave - REDC >LOC INFO:BURGER KING >AGN MAP:RED078 -TB MAP:607 J6 >X ST:W COLTON AVE/TRI-CITY CENTER DR >E264,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06319600 LON:-117.200990 METERS:14 %:063,[ProQA Script] Dispatch code: 24B02 21 yea\n",
        "CALL:BIRTH- - Childbirth",
        "ADDR:1320 Industrial Park Ave",
        "CITY:REDLANDS",
        "PLACE:BURGER KING",
        "MAP:RED078 - 607 J6",
        "X:W COLTON AVE/TRI-CITY CENTER DR",
        "UNIT:E264,ME263R,AMR39",
        "CODE:24B02",
        "INFO:WPH2 LAT:34.06319600 LON:-117.200990 METERS:14 %:063, 21 yea");

    doTest("T10",
        "[] | UNC-A1>626 N Dearborn St -87 REDC >LOC INFO:ORANGE GROVE MHP >AGN MAP:RED082 -TB MAP:608 F6 >X ST:INDEPENDENCE AVE/STILLMAN AVE >E261,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06163000 LON:-117.143354 METERS:28 %:063,[ProQA Script] Dispatch code: 31A01 52 year \n",
        "CALL:UNC-A1 - Unconscious Person",
        "ADDR:626 N Dearborn St",
        "APT:87",
        "CITY:REDLANDS",
        "PLACE:ORANGE GROVE MHP",
        "MAP:RED082 - 608 F6",
        "X:INDEPENDENCE AVE/STILLMAN AVE",
        "UNIT:E261,ME263R,AMR39",
        "CODE:31A01",
        "INFO:WPH2 LAT:34.06163000 LON:-117.143354 METERS:28 %:063, 52 year");

    doTest("T11",
        "[] | CI - C>1270 W Park Ave - REDC >LOC INFO:REDLANDS CITY YARDS >AGN MAP:RED065 -TB MAP:607 J7 >X ST:TENNESSEE ST/KANSAS ST >T261,BC705,ME263R,E264>COMMENTS:PD OS FIRE ALARM ACTIVATION,External Case Number 'RED _1200702' added for Redlands.,\n",
        "CALL:CI - C - Commercial Investigation",
        "ADDR:1270 W Park Ave",
        "CITY:REDLANDS",
        "PLACE:REDLANDS CITY YARDS",
        "MAP:RED065 - 607 J7",
        "X:TENNESSEE ST/KANSAS ST",
        "UNIT:T261,BC705,ME263R,E264",
        "INFO:PD OS FIRE ALARM ACTIVATION");

    doTest("T12",
        "[] | CA- Co>350 Terracina Blvd - REDC >LOC INFO:RCH >AGN MAP:RED036 -TB MAP:647 J3 >X ST:LAUREL AVE/W FERN AVE >E262>COMMENTS:ZONE 1 GENERAL FIRE ALARM,REDC,External Case Number 'RED _1200703' added for Redlands.,\n",
        "CALL:CA- Co",
        "ADDR:350 Terracina Blvd",
        "CITY:REDLANDS",
        "PLACE:RCH",
        "MAP:RED036 - 647 J3",
        "X:LAUREL AVE/W FERN AVE",
        "UNIT:E262",
        "INFO:ZONE 1 GENERAL FIRE ALARM,REDC");

    doTest("T13",
        "[] | CVA-C4>222 Primrose Ave - REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C1 >X ST:No X-Street/HIBISCUS DR >E261,MS261,AMR34>COMMENTS:WPH2 LAT:34.04711400 LON:-117.171829 METERS:14 %:095,[ProQA Script] Dispatch code: 28C04L 60 year old, Female, Conscious, B\n",
        "CALL:CVA-C4 - Stroke",
        "ADDR:222 Primrose Ave",
        "CITY:REDLANDS",
        "MAP:RED055 - 648 C1",
        "X:No X-Street/HIBISCUS DR",
        "UNIT:E261,MS261,AMR34",
        "CODE:28C04L",
        "INFO:WPH2 LAT:34.04711400 LON:-117.171829 METERS:14 %:095, 60 year old, Female, Conscious, B");

    doTest("T14",
        "[] | UNKM-B>1678 W Redlands Blvd - REDC >LOC INFO:99 CENT STORE >AGN MAP:RED077 -TB MAP:607 H6 >X ST:ALABAMA ST/IOWA ST >E264,ME263R,AMR39>COMMENTS:MAN DOWN INSIDE STORE ATTEMPTING TO GET FURTHER,External Case Number 'RED _1200705' added for Redlands.,Automa\n",
        "CALL:UNKM-B - Unk Medical (Man Down)",
        "ADDR:1678 W Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:99 CENT STORE",
        "MAP:RED077 - 607 H6",
        "X:ALABAMA ST/IOWA ST",
        "UNIT:E264,ME263R,AMR39",
        "INFO:MAN DOWN INSIDE STORE ATTEMPTING TO GET FURTHER");

    doTest("T15",
        "[] | TU - T>N University St / E San Bernardino Ave - REDC >LOC INFO: >AGN MAP:RED110 -TB MAP:608 D4 >X ST: >E261,MS261,AMR39>COMMENTS:401,REDC,External Case Number 'RED _1200707' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: AMB12\n",
        "CALL:TU - T - TC with Unknown Injuries",
        "ADDR:N University St & E San Bernardino Ave",
        "CITY:REDLANDS",
        "MAP:RED110 - 608 D4",
        "UNIT:E261,MS261,AMR39",
        "INFO:401,REDC");

    doTest("T16",
        "[] | FALL-A>365 Los Robles Crst - REDC >LOC INFO: >AGN MAP:RED039 -TB MAP:648 E2 >X ST:OAK ST/No X-Street >E262,AMR34,MS261>COMMENTS:WPH2 LAT:34.03896000 LON:-117.159169 METERS:21 %:095,[ProQA Script] Dispatch code: 17A01G 71 year old, Female, Conscious, Bre\n",
        "CALL:FALL-A - Fall Victim",
        "ADDR:365 Los Robles Crst",
        "CITY:REDLANDS",
        "MAP:RED039 - 648 E2",
        "X:OAK ST/No X-Street",
        "UNIT:E262,AMR34,MS261",
        "CODE:17A01G",
        "INFO:WPH2 LAT:34.03896000 LON:-117.159169 METERS:21 %:095, 71 year old, Female, Conscious, Bre");

    doTest("T17",
        "[] | UNC-D1>2050 W Redlands Blvd - REDC >LOC INFO:WALMART (RED) >AGN MAP:RED076 -TB MAP:607 G6 >X ST:NEW JERSEY ST/CALIFORNIA ST >E264,MS261,AMR31>COMMENTS:WPH2 LAT:34.06325000 LON:-117.225730 METERS:51 %:090,**PT AT MCDONALDS INSIDE WALMART**,60 YOF FAINTED\n",
        "CALL:UNC-D1 - Unconscious Person",
        "ADDR:2050 W Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:WALMART (RED)",
        "MAP:RED076 - 607 G6",
        "X:NEW JERSEY ST/CALIFORNIA ST",
        "UNIT:E264,MS261,AMR31",
        "INFO:WPH2 LAT:34.06325000 LON:-117.225730 METERS:51 %:090,**PT AT MCDONALDS INSIDE WALMART**,60 YOF FAINTED");

    doTest("T18",
        "[] | FC -St>620 E Highland Ave -4 REDC >LOC INFO:BRASWELLS CHATEAU >AGN MAP:RED046 -TB MAP:648 D2 >X ST:E REDLANDS BLVD/ROOSEVELT RD >T261,BC705,E262,E261,ME263,ME9,MS261,OSHA02,6FGND3>COMMENTS:SMOKE SHOWING FROM HEATING SYST IN ROOM #4,REDLANDS - CITY,Exter\n",
        "CALL:FC -St",
        "ADDR:620 E Highland Ave",
        "APT:4",
        "CITY:REDLANDS",
        "PLACE:BRASWELLS CHATEAU",
        "MAP:RED046 - 648 D2",
        "X:E REDLANDS BLVD/ROOSEVELT RD",
        "UNIT:T261,BC705,E262,E261,ME263,ME9,MS261,OSHA02,6FGND3",
        "INFO:SMOKE SHOWING FROM HEATING SYST IN ROOM #4,REDLANDS - CITY,Exter");

    doTest("T19",
        "[] | SICK-D>450 Judson St -98 REDC >LOC INFO:SYLVAN MOBILE >AGN MAP:RED081 -TB MAP:608 E6 >X ST:LARAMIE AVE/SYLVAN BLVD >E261,MS261,AMR35>COMMENTS:[Address: 450 JUDSON ST] [Medium] [Unknown] FOR UNIT #99 ONLY - VIDEO-TRANSLATOR RELAY FOR DEAF-SIGN LANGUAGE R\n",
        "CALL:SICK-D - Sick Person",
        "ADDR:450 Judson St",
        "APT:98",
        "CITY:REDLANDS",
        "PLACE:SYLVAN MOBILE",
        "MAP:RED081 - 608 E6",
        "X:LARAMIE AVE/SYLVAN BLVD",
        "UNIT:E261,MS261,AMR35",
        "INFO:[Address: 450 JUDSON ST] [Medium] [Unknown] FOR UNIT #99 ONLY - VIDEO-TRANSLATOR RELAY FOR DEAF-SIGN LANGUAGE R");

    doTest("T20",
        "[] | DIA-C1>1325 Pacific St - REDC >LOC INFO: >AGN MAP:RED038 -TB MAP:648 C3 >X ST:W CRESCENT AVE/BALBOA CT >E262,MS261,AMR33,E262>COMMENTS:WPH2 LAT:34.03305900 LON:-117.177429 METERS:32 %:095,[ProQA Script] Dispatch code: 13C01 83 year old, Male, Conscious,\n",
        "CALL:DIA-C1 - Diabetic Problem",
        "ADDR:1325 Pacific St",
        "CITY:REDLANDS",
        "MAP:RED038 - 648 C3",
        "X:W CRESCENT AVE/BALBOA CT",
        "UNIT:E262,MS261,AMR33,E262",
        "CODE:13C01",
        "INFO:WPH2 LAT:34.03305900 LON:-117.177429 METERS:32 %:095, 83 year old, Male, Conscious,");

    doTest("T21",
        "[] | ALL-C1>1666 Brookside Ave - REDC >LOC INFO: >AGN MAP:RED043 -TB MAP:647 H2 >X ST:CASCADE ST/TERRACINA BLVD >E264,ME263,AMR39>COMMENTS:WPH2 LAT:34.04496800 LON:-117.211869 METERS:19 %:063,[ProQA Script] Dispatch code: 02C01 27 year old, Male, Conscious, \n",
        "CALL:ALL-C1 - Allergies",
        "ADDR:1666 Brookside Ave",
        "CITY:REDLANDS",
        "MAP:RED043 - 647 H2",
        "X:CASCADE ST/TERRACINA BLVD",
        "UNIT:E264,ME263,AMR39",
        "CODE:02C01",
        "INFO:WPH2 LAT:34.04496800 LON:-117.211869 METERS:19 %:063, 27 year old, Male, Conscious,");

    doTest("T22",
        "[] | CI - C>250 E Fern Ave -109 REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C1 >X ST:SONORA ST/MYRTLE ST >T261,BC705,E261,E264>COMMENTS:[Address: 250 E FERN AVE] [Medium] [Unknown] FERNWOOD CONDOS RESIDENT IN WHEELCHAIR UNABLE TO EVACUATE WITHOUT ASSISTANCE,\n",
        "CALL:CI - C - Commercial Investigation",
        "ADDR:250 E Fern Ave",
        "APT:109",
        "CITY:REDLANDS",
        "MAP:RED055 - 648 C1",
        "X:SONORA ST/MYRTLE ST",
        "UNIT:T261,BC705,E261,E264",
        "INFO:[Address: 250 E FERN AVE] [Medium] [Unknown] FERNWOOD CONDOS RESIDENT IN WHEELCHAIR UNABLE TO EVACUATE WITHOUT ASSISTANCE,");

    doTest("T23",
        " | FALL-A>1240 Devon Pl - REDC >LOC INFO: >AGN MAP:RED095 -TB MAP:608 D5 >X ST:E BROCKTON AVE/BARBRA LN >ME263,AMR38>COMMENTS:[ProQA Script] Dispatch code: 17A01G 70 year old, Female, Conscious, Breathing. Falls. NOT DANGEROUS body area (On the ground or f",
        "CALL:FALL-A - Fall Victim",
        "ADDR:1240 Devon Pl",
        "CITY:REDLANDS",
        "MAP:RED095 - 608 D5",
        "X:E BROCKTON AVE/BARBRA LN",
        "UNIT:ME263,AMR38",
        "CODE:17A01G",
        "INFO:70 year old, Female, Conscious, Breathing. Falls. NOT DANGEROUS body area (On the ground or f");

    doTest("T24",
        " | CA- Co>111 W Lugonia Ave - REDC >LOC INFO:REDLANDS COMMUNITY CENTER >AGN MAP:RED094 -TB MAP:608 B5 >X ST:WASHINGTON ST/CLAY ST >E261>COMMENTS:FIRE SMOKE DETECTOR SOUTH ZONE4,External Case Number 'RED _1200732' added for Redlands.,",
        "CALL:CA- Co",
        "ADDR:111 W Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:REDLANDS COMMUNITY CENTER",
        "MAP:RED094 - 608 B5",
        "X:WASHINGTON ST/CLAY ST",
        "UNIT:E261",
        "INFO:FIRE SMOKE DETECTOR SOUTH ZONE4");

    doTest("T25",
        " | FU - U>Mission Rd / California St - LOMC >LOC INFO: >AGN MAP:LOM022 -TB MAP:647 F1 >X ST: >E264,MS251R,ME263,BC402>COMMENTS:WPH2 LAT:34.05005300 LON:-117.226889 METERS:14 %:095,RP STATES ON THE CORNER OF MISSION AND CALIFORNIA OFF THE ACCESS ROAD TO THE",
        "CALL:FU - U - Unknown Type Fire",
        "ADDR:Mission Rd & California St",
        "CITY:LOMC",
        "MAP:LOM022 - 647 F1",
        "UNIT:E264,MS251R,ME263,BC402",
        "INFO:WPH2 LAT:34.05005300 LON:-117.226889 METERS:14 %:095,RP STATES ON THE CORNER OF MISSION AND CALIFORNIA OFF THE ACCESS ROAD TO THE");

    doTest("T26",
        " | FV - V>1786 E Lugonia Ave - REDC >LOC INFO:STATER BROS (RED3) >AGN MAP:RED097 -TB MAP:608 G5 >X ST:REVELATION WAY/N WABASH AVE >ME263>COMMENTS:WPH2 LAT:34.06911800 LON:-117.139986 METERS:9 %:063,**DODGE CHARGER**,External Case Number 'RED _1200734' adde",
        "CALL:FV - V - Vehicle Fire",
        "ADDR:1786 E Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:STATER BROS (RED3)",
        "MAP:RED097 - 608 G5",
        "X:REVELATION WAY/N WABASH AVE",
        "UNIT:ME263",
        "INFO:WPH2 LAT:34.06911800 LON:-117.139986 METERS:9 %:063,**DODGE CHARGER**");

    doTest("T27",
        " | SICK-C>945 Salem Dr -6 REDC >LOC INFO:PLYMOUTH VILLAGE >AGN MAP:RED046 -TB MAP:648 D2 >X ST:STANDISH WAY/CARVER CIR >E261,MS261,AMR34>COMMENTS:WPH2 LAT:34.04314400 LON:-117.171807 METERS:25 %:063,[ProQA Script] Dispatch code: 26C01 95 year old, Female, ",
        "CALL:SICK-C - Sick Person",
        "ADDR:945 Salem Dr",
        "APT:6",
        "CITY:REDLANDS",
        "PLACE:PLYMOUTH VILLAGE",
        "MAP:RED046 - 648 D2",
        "X:STANDISH WAY/CARVER CIR",
        "UNIT:E261,MS261,AMR34",
        "CODE:26C01",
        "INFO:WPH2 LAT:34.04314400 LON:-117.171807 METERS:25 %:063, 95 year old, Female,");

    doTest("T28",
        " | SOB-C1>700 E Highland Ave -17-2 REDC >LOC INFO:COUNTRY VILLA >AGN MAP:RED047 -TB MAP:648 D2 >X ST:E REDLANDS BLVD/ROOSEVELT RD >E262,ME263,AMR37,MS261>COMMENTS:83 YOF, DIFF BREATHER,AMR ER,[ProQA Session Aborted] ALLIED AGENCY,External Case Number 'RED ",
        "CALL:SOB-C1 - Shortness of Breath",
        "ADDR:700 E Highland Ave",
        "APT:17-2",
        "CITY:REDLANDS",
        "PLACE:COUNTRY VILLA",
        "MAP:RED047 - 648 D2",
        "X:E REDLANDS BLVD/ROOSEVELT RD",
        "UNIT:E262,ME263,AMR37,MS261",
        "INFO:83 YOF, DIFF BREATHER,AMR ER, ALLIED AGENCY");

    doTest("T29",
        " | DIA-A1>1110 Oxford Dr -D REDC >LOC INFO: >AGN MAP:RED095 -TB MAP:608 C6 >X ST:E BROCKTON AVE/COURIER AVE >ME263,AMR33>COMMENTS:W911 LAT:34.06555700 LON:-117.170198 METERS:592 %:000,[ProQA Script] Dispatch code: 13A01 13 year old, Female, Conscious, Brea",
        "CALL:DIA-A1 - Diabetic Problem",
        "ADDR:1110 Oxford Dr",
        "APT:D",
        "CITY:REDLANDS",
        "MAP:RED095 - 608 C6",
        "X:E BROCKTON AVE/COURIER AVE",
        "UNIT:ME263,AMR33",
        "CODE:13A01",
        "INFO:W911 LAT:34.06555700 LON:-117.170198 METERS:592 %:000, 13 year old, Female, Conscious, Brea");

    doTest("T30",
        " | ALL-D2>841 Sinclair Ct - REDC >LOC INFO: >AGN MAP:RED125 -TB MAP:608 C4 >X ST:No X-Street/DUKE ST >ME263,AMR33>COMMENTS:WPH2 LAT:34.08204700 LON:-117.172344 METERS:6 %:090,[ProQA Script] Dispatch code: 02D02 53 year old, Female, Conscious, Breathing. Al",
        "CALL:ALL-D2 - Allergies",
        "ADDR:841 Sinclair Ct",
        "CITY:REDLANDS",
        "MAP:RED125 - 608 C4",
        "X:No X-Street/DUKE ST",
        "UNIT:ME263,AMR33",
        "CODE:02D02",
        "INFO:WPH2 LAT:34.08204700 LON:-117.172344 METERS:6 %:090, 53 year old, Female, Conscious, Breathing. Al");

    doTest("T31",
        " | SOB-C1>1249 Cornell Ave -E REDC >LOC INFO: >AGN MAP:RED096 -TB MAP:608 E5 >X ST:EDWARDS ST/N GROVE ST >ME263,AMR32>COMMENTS:[ProQA Script] Dispatch code: 06C01 19 year old, Male, Conscious, Breathing. Breathing Problems. Abnormal breathing. Caller State",
        "CALL:SOB-C1 - Shortness of Breath",
        "ADDR:1249 Cornell Ave",
        "APT:E",
        "CITY:REDLANDS",
        "MAP:RED096 - 608 E5",
        "X:EDWARDS ST/N GROVE ST",
        "UNIT:ME263,AMR32",
        "CODE:06C01",
        "INFO:19 year old, Male, Conscious, Breathing. Breathing Problems. Abnormal breathing. Caller State");

    doTest("T32",
        " | FC -St>217 Kaye Ct -A REDC >LOC INFO: >AGN MAP:RED068 -TB MAP:608 E7 >X ST:CENTRAL AVE/No X-Street >T261,BC706,E261,E262,ME263,E264,MS261,OSHA03>COMMENTS:WPH2 LAT:34.05860400 LON:-117.158654 METERS:121 %:090,HOUSE FULL OF SMOKE,REDC,External Case Number",
        "CALL:FC -St",
        "ADDR:217 Kaye Ct",
        "APT:A",
        "CITY:REDLANDS",
        "MAP:RED068 - 608 E7",
        "X:CENTRAL AVE/No X-Street",
        "UNIT:T261,BC706,E261,E262,ME263,E264,MS261,OSHA03",
        "INFO:WPH2 LAT:34.05860400 LON:-117.158654 METERS:121 %:090,HOUSE FULL OF SMOKE,REDC");

    doTest("T33",
        " | HEART->1301 California St - REDC >LOC INFO:KAISER >AGN MAP:RED091 -TB MAP:607 F5 >X ST:W LUGONIA AVE/ALMOND AVE >ME263,AMR38>COMMENTS:NURSE TREATMETN AREA 6 1ST FLOOR,[ProQA Script] Dispatch code: 19C04 65 year old, Female, Conscious, Breathing. Heart P",
        "CALL:HEART-",
        "ADDR:1301 California St",
        "CITY:REDLANDS",
        "PLACE:KAISER",
        "MAP:RED091 - 607 F5",
        "X:W LUGONIA AVE/ALMOND AVE",
        "UNIT:ME263,AMR38",
        "CODE:19C04",
        "INFO:NURSE TREATMETN AREA 6 1ST FLOOR, 65 year old, Female, Conscious, Breathing. Heart P");

    doTest("T34",
        " | HL-D3 >151 Judson St -116 REDC >LOC INFO:CITRUS ARMS >AGN MAP:RED068 -TB MAP:608 E7 >X ST:E CITRUS AVE/CENTRAL AVE >E261,MS261,AMR37>COMMENTS:[ProQA Script] Dispatch code: 21D03 65 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations. DANGEROU",
        "CALL:HL-D3 - Hemorrhage/Laceration",
        "ADDR:151 Judson St",
        "APT:116",
        "CITY:REDLANDS",
        "PLACE:CITRUS ARMS",
        "MAP:RED068 - 608 E7",
        "X:E CITRUS AVE/CENTRAL AVE",
        "UNIT:E261,MS261,AMR37",
        "CODE:21D03",
        "INFO:65 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations. DANGEROU");

    doTest("T35",
        " | FALL-B>945 Salem Dr -1 REDC >LOC INFO:ASSIST LIVING >AGN MAP:RED046 -TB MAP:648 D2 >X ST:STANDISH WAY/CARVER CIR >T261,ME263,AMR31>COMMENTS:WPH2 LAT:34.04302600 LON:-117.171550 METERS:41 %:063,[ProQA Script] Dispatch code: 17B01G 87 year old, Female, Co",
        "CALL:FALL-B - Fall Victim",
        "ADDR:945 Salem Dr",
        "APT:1",
        "CITY:REDLANDS",
        "PLACE:ASSIST LIVING",
        "MAP:RED046 - 648 D2",
        "X:STANDISH WAY/CARVER CIR",
        "UNIT:T261,ME263,AMR31",
        "CODE:17B01G",
        "INFO:WPH2 LAT:34.04302600 LON:-117.171550 METERS:41 %:063, 87 year old, Female, Co");

    doTest("T36",
        " | SOB-D2>422 Orange St - REDC >LOC INFO:PACIFIC DENTAL >AGN MAP:RED066 -TB MAP:608 B7 >X ST:W REDLANDS BLVD/W STUART AVE >T261,MS261,AMR37>COMMENTS:[ProQA Script] Dispatch code: 06D02 82 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICUL",
        "CALL:SOB-D2 - Shortness of Breath",
        "ADDR:422 Orange St",
        "CITY:REDLANDS",
        "PLACE:PACIFIC DENTAL",
        "MAP:RED066 - 608 B7",
        "X:W REDLANDS BLVD/W STUART AVE",
        "UNIT:T261,MS261,AMR37",
        "CODE:06D02",
        "INFO:82 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICUL");

    doTest("T37",
        " | UNKM-B>686 E Redlands Blvd -326 REDC >LOC INFO:CASA DE LA VISTA >AGN MAP:RED067 -TB MAP:608 C7 >X ST:E CLARK ST/E FERN AVE >E261,MS261,AMR31>COMMENTS:MEDICAL-ALARM COMPANY UNABLE TO REACH RESD,[ProQA Session Aborted] NO ANSWER WHEN RESD CALLED,External ",
        "CALL:UNKM-B - Unk Medical (Man Down)",
        "ADDR:686 E Redlands Blvd",
        "APT:326",
        "CITY:REDLANDS",
        "PLACE:CASA DE LA VISTA",
        "MAP:RED067 - 608 C7",
        "X:E CLARK ST/E FERN AVE",
        "UNIT:E261,MS261,AMR31",
        "INFO:MEDICAL-ALARM COMPANY UNABLE TO REACH RESD, NO ANSWER WHEN RESD CALLED");

    doTest("T38",
        " | UNC-A1>101 W Redlands Blvd - REDC >LOC INFO:CVS PHARMACY >AGN MAP:RED066 -TB MAP:608 B7 >X ST:N 4TH ST/3RD ST >T261,ME263,AMR39,MS261>COMMENTS:[ProQA Script] Dispatch code: 31A01 45 year old, Male, Conscious, Breathing. Unconscious / Fainting (Near). Fa",
        "CALL:UNC-A1 - Unconscious Person",
        "ADDR:101 W Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:CVS PHARMACY",
        "MAP:RED066 - 608 B7",
        "X:N 4TH ST/3RD ST",
        "UNIT:T261,ME263,AMR39,MS261",
        "CODE:31A01",
        "INFO:45 year old, Male, Conscious, Breathing. Unconscious / Fainting (Near). Fa");

    doTest("T39",
        " | CA- Co>1600 E Citrus Ave -A REDC >LOC INFO:EPIC MANAGMENT >AGN MAP:RED069 -TB MAP:608 F7 >X ST:N DEARBORN ST/S LA SALLE ST >E261>COMMENTS:GENERAKL FAP FIRE ALARM,External Case Number 'RED _1200760' added for Redlands.,",
        "CALL:CA- Co",
        "ADDR:1600 E Citrus Ave",
        "APT:A",
        "CITY:REDLANDS",
        "PLACE:EPIC MANAGMENT",
        "MAP:RED069 - 608 F7",
        "X:N DEARBORN ST/S LA SALLE ST",
        "UNIT:E261",
        "INFO:GENERAKL FAP FIRE ALARM");

    doTest("T40",
        " | UNC-D2>1418 5th Ave - REDC >LOC INFO: >AGN MAP:RED056 -TB MAP:648 F1 >X ST:E HIGHLAND AVE/MARION AVE >E261,MS261,AMR35>COMMENTS:[ProQA Script] Dispatch code: 31D02 75 year old, Male, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- ",
        "CALL:UNC-D2 - Unconscious Person",
        "ADDR:1418 5th Ave",
        "CITY:REDLANDS",
        "MAP:RED056 - 648 F1",
        "X:E HIGHLAND AVE/MARION AVE",
        "UNIT:E261,MS261,AMR35",
        "CODE:31D02",
        "INFO:75 year old, Male, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious --");

    doTest("T41",
        " | SZ-D2 >1150 Brookside Ave - REDC >LOC INFO:BEHIND GIOVANNIS PIZZA >AGN MAP:RED053 -TB MAP:648 A1 >X ST:No X-Street/No X-Street >E264,ME263,AMR34>COMMENTS:WPH2 LAT:34.05056800 LON:-117.196698 METERS:14 %:063,[ProQA Script] Dispatch code: 12D02E 31 year o",
        "CALL:SZ-D2 - Seizures",
        "ADDR:1150 Brookside Ave",
        "CITY:REDLANDS",
        "PLACE:BEHIND GIOVANNIS PIZZA",
        "MAP:RED053 - 648 A1",
        "X:No X-Street/No X-Street",
        "UNIT:E264,ME263,AMR34",
        "CODE:12D02E",
        "INFO:WPH2 LAT:34.05056800 LON:-117.196698 METERS:14 %:063, 31 year o");

    doTest("T42",
        " | SICK-C>411 E Palm Ave - REDC >LOC INFO:GOODWILL BOOKSTORE >AGN MAP:RED055 -TB MAP:648 D1 >X ST:LA PALOMA ST/E REDLANDS BLVD >E261,MS261,AMR34>COMMENTS:[ProQA Script] Dispatch code: 26C01 61 year old, Male, Conscious, Breathing. Sick Person (Specific Dia",
        "CALL:SICK-C - Sick Person",
        "ADDR:411 E Palm Ave",
        "CITY:REDLANDS",
        "PLACE:GOODWILL BOOKSTORE",
        "MAP:RED055 - 648 D1",
        "X:LA PALOMA ST/E REDLANDS BLVD",
        "UNIT:E261,MS261,AMR34",
        "CODE:26C01",
        "INFO:61 year old, Male, Conscious, Breathing. Sick Person (Specific Dia");

    doTest("T43",
        " | FALL-A>13082 South Ln - REDC >LOC INFO: >AGN MAP:RED019 -TB MAP:648 J5 >X ST:FREYA DR/SUTHERLAND DR >E262,MS261,AMR37>COMMENTS:[ProQA Script] Dispatch code: 17A01G 91 year old, Male, Conscious, Breathing. Falls. NOT DANGEROUS body area (On the ground or",
        "CALL:FALL-A - Fall Victim",
        "ADDR:13082 South Ln",
        "CITY:REDLANDS",
        "MAP:RED019 - 648 J5",
        "X:FREYA DR/SUTHERLAND DR",
        "UNIT:E262,MS261,AMR37",
        "CODE:17A01G",
        "INFO:91 year old, Male, Conscious, Breathing. Falls. NOT DANGEROUS body area (On the ground or");

    doTest("T44",
        " | TU - T>New Jersey St / W Redlands Blvd - REDC >LOC INFO: >AGN MAP:RED076 -TB MAP:607 G6 >X ST: >E264,ME263,AMR36>COMMENTS:REDLANDS,External Case Number 'RED _1200742' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: AMB12-006845",
        "CALL:TU - T - TC with Unknown Injuries",
        "ADDR:New Jersey St & W Redlands Blvd",
        "CITY:REDLANDS",
        "MAP:RED076 - 607 G6",
        "UNIT:E264,ME263,AMR36",
        "INFO:REDLANDS");

    doTest("T45",
        " | FALL ->725 Chestnut Ave - REDC >LOC INFO: >AGN MAP:RED045 -TB MAP:648 C2 >X ST:S CENTER ST/PACIFIC ST >E261,MS261,AMR36>COMMENTS:*** EMD COMPLETED WITH CARDS NOT PROQA ***,85 YOM,External Case Number 'RED _1200743' added for Redlands.,Automatic Case Num",
        "CALL:FALL - - Fall Victim",
        "ADDR:725 Chestnut Ave",
        "CITY:REDLANDS",
        "MAP:RED045 - 648 C2",
        "X:S CENTER ST/PACIFIC ST",
        "UNIT:E261,MS261,AMR36",
        "INFO:*** EMD COMPLETED WITH CARDS NOT PROQA ***,85 YOM");

    doTest("T46",
        " | TI - T>N University St / I 10 Fwy E - REDC >LOC INFO: >AGN MAP:RED067 -TB MAP:608 D7 >X ST: >ME263,AMR30>COMMENTS:[ProQA Session Aborted] ALLIED AGENCY,1 PT COMPLAINING OF PAIN,External Case Number 'RED _1200744' added for Redlands.,Automatic Case Numbe",
        "CALL:TI - T - TC with Injuries",
        "ADDR:N University St & I 10 Fwy E",
        "CITY:REDLANDS",
        "MAP:RED067 - 608 D7",
        "UNIT:ME263,AMR30",
        "INFO:ALLIED AGENCY,1 PT COMPLAINING OF PAIN");

    doTest("T47",
        " | CA- Co>1969 Orange Tree Ln - REDC >LOC INFO: >AGN MAP:RED091 -TB MAP:607 G6 >X ST:N NEVADA ST/UNNAMED DR >E264>COMMENTS:BUILDING OS & Y VALVE,External Case Number 'RED _1200745' added for Redlands.,",
        "CALL:CA- Co",
        "ADDR:1969 Orange Tree Ln",
        "CITY:REDLANDS",
        "MAP:RED091 - 607 G6",
        "X:N NEVADA ST/UNNAMED DR",
        "UNIT:E264",
        "INFO:BUILDING OS & Y VALVE");

    doTest("T48",
        " | HEART->1075 Parkford Dr - REDC >LOC INFO:76 STATION >AGN MAP:RED047 -TB MAP:648 E2 >X ST:MARSHALL ST/FORD ST >E262,MS261,AMR37>COMMENTS:PT INSIDE EMPLOYEE OFFICE,[ProQA Script] Dispatch code: 19C07 48 year old, Female, Conscious, Breathing. Heart Proble",
        "CALL:HEART-",
        "ADDR:1075 Parkford Dr",
        "CITY:REDLANDS",
        "PLACE:76 STATION",
        "MAP:RED047 - 648 E2",
        "X:MARSHALL ST/FORD ST",
        "UNIT:E262,MS261,AMR37",
        "CODE:19C07",
        "INFO:PT INSIDE EMPLOYEE OFFICE, 48 year old, Female, Conscious, Breathing. Heart Proble");

    doTest("T49",
        " | HCE-B1>27510 W Lugonia Ave - RED >LOC INFO:JAMBA JUICE (RED) >AGN MAP:RED093 -TB MAP:607 J5 >X ST:CITRUS PLAZA DR/INDIANA CT >E264,ME263,AMR33>COMMENTS:WPH2 LAT:34.07141400 LON:-117.204530 METERS:51 %:090,CHILD LOCKED IN GOLD CAMRY/POSS 9-10 MONTHS OLD,",
        "CALL:HCE-B1 - Heat/Cold Exposure",
        "ADDR:27510 W Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:JAMBA JUICE (RED)",
        "MAP:RED093 - 607 J5",
        "X:CITRUS PLAZA DR/INDIANA CT",
        "UNIT:E264,ME263,AMR33",
        "INFO:WPH2 LAT:34.07141400 LON:-117.204530 METERS:51 %:090,CHILD LOCKED IN GOLD CAMRY/POSS 9-10 MONTHS OLD,");

    doTest("T50",
        " | TU - T>Alabama St / I 10 Onrp W - REDC >LOC INFO: >AGN MAP:RED092 -TB MAP:607 H6 >X ST: >ME263,AMR33>COMMENTS:ON ALABAMA AT THE I 10 ONRAMP WESTBOUND,REDC,External Case Number 'RED _1200748' added for Redlands.,Automatic Case Number(s) issued for Ground",
        "CALL:TU - T - TC with Unknown Injuries",
        "ADDR:Alabama St & I 10 Onrp W",
        "CITY:REDLANDS",
        "MAP:RED092 - 607 H6",
        "UNIT:ME263,AMR33",
        "INFO:ON ALABAMA AT THE I 10 ONRAMP WESTBOUND,REDC");

    doTest("T51",
        " | UNC-D3>202 E State St - REDC >LOC INFO:STATE STREET DELI >AGN MAP:RED066 -TB MAP:608 C7 >X ST:N 6TH ST/7TH ST >E261,MS261,AMR32>COMMENTS:PT IFO DELI,[ProQA Script] Dispatch code: 31D03 84 year old, Male, Conscious, Breathing. Unconscious / Fainting (Nea",
        "CALL:UNC-D3 - Unconscious Person",
        "ADDR:202 E State St",
        "CITY:REDLANDS",
        "PLACE:STATE STREET DELI",
        "MAP:RED066 - 608 C7",
        "X:N 6TH ST/7TH ST",
        "UNIT:E261,MS261,AMR32",
        "CODE:31D03",
        "INFO:PT IFO DELI, 84 year old, Male, Conscious, Breathing. Unconscious / Fainting (Nea");

    doTest("T52",
        " | HL-B3 >814 S Grove St - REDC >LOC INFO:**STAGE** >AGN MAP:RED056 -TB MAP:648 E1 >X ST:E PALM AVE/BEGONIA CT >E262,ME263,AMR30>COMMENTS:WPH2 LAT:34.05204900 LON:-117.159662 METERS:16 %:095,*** 9-1-1 HANG UP - ATTEMPTING CALL BACK ***,**STAGE***,PER CHP F",
        "CALL:HL-B3 - Hemorrhage/Laceration",
        "ADDR:814 S Grove St",
        "CITY:REDLANDS",
        "PLACE:**STAGE**",
        "MAP:RED056 - 648 E1",
        "X:E PALM AVE/BEGONIA CT",
        "UNIT:E262,ME263,AMR30",
        "INFO:WPH2 LAT:34.05204900 LON:-117.159662 METERS:16 %:095,*** 9-1-1 HANG UP - ATTEMPTING CALL BACK ***,**STAGE***,PER CHP F");

    doTest("T53",
        " | UNKM-B>1555 Campus Ave - REDC >LOC INFO: >AGN MAP:RED082 -TB MAP:608 F6 >X ST:FALCON LN/N DEARBORN ST >E261,ME263,AMR33>COMMENTS:WPH2 LAT:34.06575000 LON:-117.149019 METERS:88 %:090,REDC,*** 9-1-1 HANG UP - ATTEMPTING CALL BACK ***,External Case Number ",
        "CALL:UNKM-B - Unk Medical (Man Down)",
        "ADDR:1555 Campus Ave",
        "CITY:REDLANDS",
        "MAP:RED082 - 608 F6",
        "X:FALCON LN/N DEARBORN ST",
        "UNIT:E261,ME263,AMR33",
        "INFO:WPH2 LAT:34.06575000 LON:-117.149019 METERS:88 %:090,REDC,*** 9-1-1 HANG UP - ATTEMPTING CALL BACK ***");

    doTest("T54",
        " | FALL-B>10 Terracina Blvd -126 REDC >LOC INFO:MISSION COMMONS-ASSISTED LIVING >AGN MAP:RED052 -TB MAP:647 H1 >X ST:BARTON RD/LADERA ST >E264,MS261,AMR33>COMMENTS:PT IS IN THE ASSISTED LIVING,ROOM 126,[ProQA Script] Dispatch code: 17B01 90 year old, Femal",
        "CALL:FALL-B - Fall Victim",
        "ADDR:10 Terracina Blvd",
        "APT:126",
        "CITY:REDLANDS",
        "PLACE:MISSION COMMONS-ASSISTED LIVING",
        "MAP:RED052 - 647 H1",
        "X:BARTON RD/LADERA ST",
        "UNIT:E264,MS261,AMR33",
        "CODE:17B01",
        "INFO:PT IS IN THE ASSISTED LIVING,ROOM 126, 90 year old, Femal");

    doTest("T55",
        " | UNC-C2>12835 17th St - REDC >LOC INFO: >AGN MAP:RED028 -TB MAP:649 B5 >X ST:OUTER 10 HWY S/FLORIDA ST >E262,MS261,AMR37>COMMENTS:56 YOM,External Case Number 'RED _1200718' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: AMB12-0",
        "CALL:UNC-C2 - Unconscious Person",
        "ADDR:12835 17th St",
        "CITY:REDLANDS",
        "MAP:RED028 - 649 B5",
        "X:OUTER 10 HWY S/FLORIDA ST",
        "UNIT:E262,MS261,AMR37",
        "INFO:56 YOM");

    doTest("T56",
        " | ABD-C3>140 W Pioneer Ave -133 REDC >LOC INFO: >AGN MAP:RED124 -TB MAP:608 B4 >X ST:WASHINGTON ST/CLAY ST >ME263,AMR38>COMMENTS:[Address: 140 W PIONEER AVE] [Medium] [Location Information] SPACE#79 RESIDENT IS LUCILLE RIEDEL / TEL 909-792-5262 / GATE COD",
        "CALL:ABD-C3 - Abdominal Pain",
        "ADDR:140 W Pioneer Ave",
        "APT:133",
        "CITY:REDLANDS",
        "MAP:RED124 - 608 B4",
        "X:WASHINGTON ST/CLAY ST",
        "UNIT:ME263,AMR38",
        "INFO:[Address: 140 W PIONEER AVE] [Medium] [Location Information] SPACE#79 RESIDENT IS LUCILLE RIEDEL / TEL 909-792-5262 / GATE COD");

    doTest("T57",
        " | CP-C2 >151 Palm Lane Dr E - REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C2 >X ST:No X-Street/E PALM AVE >E261,MS261,AMR39>COMMENTS:[ProQA Script] Dispatch code: 10C02 81 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Heart attack or a",
        "CALL:CP-C2 - Chest Pains",
        "ADDR:151 Palm Lane Dr E",
        "CITY:REDLANDS",
        "MAP:RED055 - 648 C2",
        "X:No X-Street/E PALM AVE",
        "UNIT:E261,MS261,AMR39",
        "CODE:10C02",
        "INFO:81 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Heart attack or a");

    doTest("T58",
        " | ASLT-B>605 E Redlands Blvd - REDC >LOC INFO:** STAGE ** JACK IN THE BOX >AGN MAP:RED067 -TB MAP:608 C7 >X ST:E CITRUS AVE/E CLARK ST >E261,MS261,AMR37>COMMENTS:[ProQA Session Aborted] ALLIED AGENCY,*** STAGE OUT OF THE AREA FOR LAW ENFORCEMENT ***,Exter",
        "CALL:ASLT-B - Assault",
        "ADDR:605 E Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:** STAGE ** JACK IN THE BOX",
        "MAP:RED067 - 608 C7",
        "X:E CITRUS AVE/E CLARK ST",
        "UNIT:E261,MS261,AMR37",
        "INFO:ALLIED AGENCY,*** STAGE OUT OF THE AREA FOR LAW ENFORCEMENT ***,Exter");

    doTest("T59",
        " | FALL-D>609 Georgia St - REDC >LOC INFO: >AGN MAP:RED081 -TB MAP:608 E6 >X ST:SYLVAN BLVD/STILLMAN AVE >E261,MS261,AMR33>COMMENTS:WPH2 LAT:34.06096500 LON:-117.155607 METERS:46 %:063,[ProQA Script] Dispatch code: 17D03 80 year old, Female, Conscious, Bre",
        "CALL:FALL-D - Fall Victim",
        "ADDR:609 Georgia St",
        "CITY:REDLANDS",
        "MAP:RED081 - 608 E6",
        "X:SYLVAN BLVD/STILLMAN AVE",
        "UNIT:E261,MS261,AMR33",
        "CODE:17D03",
        "INFO:WPH2 LAT:34.06096500 LON:-117.155607 METERS:46 %:063, 80 year old, Female, Conscious, Bre");

    doTest("T60",
        " | SOB-D4>27450 W Lugonia Ave - RED >LOC INFO:BED BATH & BEYOND (RED) >AGN MAP:RED092 -TB MAP:607 J5 >X ST:INDIANA CT/N ALABAMA ST >T261,ME263,AMR34>COMMENTS:PT IN PERSONAL CARE AREA,[ProQA Script] Dispatch code: 06D04 54 year old, Female, Conscious, Breat",
        "CALL:SOB-D4 - Shortness of Breath",
        "ADDR:27450 W Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:BED BATH & BEYOND (RED)",
        "MAP:RED092 - 607 J5",
        "X:INDIANA CT/N ALABAMA ST",
        "UNIT:T261,ME263,AMR34",
        "CODE:06D04",
        "INFO:PT IN PERSONAL CARE AREA, 54 year old, Female, Conscious, Breat");

    doTest("T61",
        " | UNC-D3>2140 Mentone Blvd -133 MEN >LOC INFO:FRIENDLY HILLS MHP >AGN MAP:MEN099 -TB MAP:609 A5 >X ST:CRAFTON AVE/PLUMWOOD LN >ME263,AMR39>COMMENTS:WPH2 LAT:34.06730500 LON:-117.118313 METERS:11 %:063,[ProQA Script] Dispatch code: 31D03 82 year old, Femal",
        "CALL:UNC-D3 - Unconscious Person",
        "ADDR:2140 Mentone Blvd",
        "APT:133",
        "CITY:MEN",
        "PLACE:FRIENDLY HILLS MHP",
        "MAP:MEN099 - 609 A5",
        "X:CRAFTON AVE/PLUMWOOD LN",
        "UNIT:ME263,AMR39",
        "CODE:31D03",
        "INFO:WPH2 LAT:34.06730500 LON:-117.118313 METERS:11 %:063, 82 year old, Femal");

    doTest("T62",
        " | SOB-D2>W San Bernardino Ave / California St - REDC >LOC INFO: >AGN MAP:RED106 -TB MAP:607 F4 >X ST: >E264,MS261,AMR37>COMMENTS:WPH2 LAT:34.06375400 LON:-117.213778 METERS:3035 %:090,CITY OF REDLANDS VEHICLE,[ProQA Script] Dispatch code: 06D02 35 year ol",
        "CALL:SOB-D2 - Shortness of Breath",
        "ADDR:W San Bernardino Ave & California St",
        "CITY:REDLANDS",
        "MAP:RED106 - 607 F4",
        "UNIT:E264,MS261,AMR37",
        "CODE:06D02",
        "INFO:WPH2 LAT:34.06375400 LON:-117.213778 METERS:3035 %:090,CITY OF REDLANDS VEHICLE, 35 year ol");

    doTest("T63",
        " | SOB-C1>1710 Barton Rd -208 REDC >LOC INFO:LLBMC >AGN MAP:RED052 -TB MAP:647 H1 >X ST:IOWA ST/TERRACINA BLVD >E264,MS261,AMR35>COMMENTS:83 YOF SOB,REDC,776,External Case Number 'RED _1200726' added for Redlands.,Automatic Case Number(s) issued for Ground",
        "CALL:SOB-C1 - Shortness of Breath",
        "ADDR:1710 Barton Rd",
        "APT:208",
        "CITY:REDLANDS",
        "PLACE:LLBMC",
        "MAP:RED052 - 647 H1",
        "X:IOWA ST/TERRACINA BLVD",
        "UNIT:E264,MS261,AMR35",
        "INFO:83 YOF SOB,REDC,776");

    doTest("T64",
        " | ZAP - >San Timoteo Canyon Rd / Beaumont Ave - REDC >LOC INFO: >AGN MAP:RED035 -TB MAP:647 H3 >X ST: >E261>COMMENTS:WPH2 LAT:34.01817700 LON:-117.188372 METERS:28 %:095,WIRES DOWN IN ROADWAY,External Case Number 'RED _1200727' added for Redlands.,",
        "CALL:ZAP - - Outside Elec Incident",
        "ADDR:San Timoteo Canyon Rd & Beaumont Ave",
        "CITY:REDLANDS",
        "MAP:RED035 - 647 H3",
        "UNIT:E261",
        "INFO:WPH2 LAT:34.01817700 LON:-117.188372 METERS:28 %:095,WIRES DOWN IN ROADWAY");

    doTest("T65",
        " | SOB-C1>812 Granada Ct - REDC >LOC INFO: >AGN MAP:RED078 -TB MAP:608 A6 >X ST:No X-Street/CARLSON AVE >ME263,AMR32,T261,MS261>COMMENTS:[ProQA Script] Dispatch code: 06C01 61 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing. ",
        "CALL:SOB-C1 - Shortness of Breath",
        "ADDR:812 Granada Ct",
        "CITY:REDLANDS",
        "MAP:RED078 - 608 A6",
        "X:No X-Street/CARLSON AVE",
        "UNIT:ME263,AMR32,T261,MS261",
        "CODE:06C01",
        "INFO:61 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing.");

    doTest("T66",
        " | FALL-B>Industrial Park Ave / W Colton Ave - REDC >LOC INFO:LONG JOHN SILVERS >AGN MAP:RED078 -TB MAP:607 J6 >X ST: >ME263,MS261,AMR36,E264>COMMENTS:WPH2 LAT:34.06314300 LON:-117.201955 METERS:9 %:090,[ProQA Script] Dispatch code: 17B01 88 year old, Male",
        "CALL:FALL-B - Fall Victim",
        "ADDR:Industrial Park Ave & W Colton Ave",
        "CITY:REDLANDS",
        "PLACE:LONG JOHN SILVERS",
        "MAP:RED078 - 607 J6",
        "UNIT:ME263,MS261,AMR36,E264",
        "CODE:17B01",
        "INFO:WPH2 LAT:34.06314300 LON:-117.201955 METERS:9 %:090, 88 year old, Male");

    doTest("T67",
        " | SICK-D>Jasmine St / E Brockton Ave - REDC >LOC INFO: >AGN MAP:RED097 -TB MAP:608 F6 >X ST: >ME263,MS261,AMR31,E261>COMMENTS:WPH2 LAT:34.06647900 LON:-117.147002 METERS:19 %:063,PT IN SILVER TOYOTA,External Case Number 'RED _1200730' added for Redlands.,",
        "CALL:SICK-D - Sick Person",
        "ADDR:Jasmine St & E Brockton Ave",
        "CITY:REDLANDS",
        "MAP:RED097 - 608 F6",
        "UNIT:ME263,MS261,AMR31,E261",
        "INFO:WPH2 LAT:34.06647900 LON:-117.147002 METERS:19 %:063,PT IN SILVER TOYOTA");
 }
  
  public static void main(String[] args) {
    new CASanBernardinoCountyParserTest().generateTests("T1");
  }
}