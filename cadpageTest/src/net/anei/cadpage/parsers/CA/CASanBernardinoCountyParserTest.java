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
        "CALL:TU - T",
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
        "INFO:ALLIED AGENCY,External Case Number 'R");

    doTest("T3",
        "[] | SICK-D>105 Terracina Blvd -106-a REDC >LOC INFO:BROOKSIDE HEALTH >AGN MAP:RED043 -TB MAP:647 H2 >X ST:BROOKSIDE AVE/CORDOVA AVE >E264,ME263R,AMR39>COMMENTS:793-2271,[ProQA Script] Dispatch code: 26D01 85 year old, Male, Conscious, Breathing. Sick Person\n",
        "CALL:SICK-D",
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
        "CALL:PS - P",
        "ADDR:27320 W Lugonia Ave",
        "CITY:REDLANDS",
        "PLACE:TARGET (RED)",
        "MAP:RED092 - 607 H5",
        "X:INDIANA CT/N ALABAMA ST",
        "UNIT:E264",
        "INFO:CHILD LOCKED IN A WHITE CADILAC CTS,RED");

    doTest("T5",
        "[] | UNC-D2>205 Judson St -C REDC >LOC INFO:JUDSON APTS >AGN MAP:RED068 -TB MAP:608 E7 >X ST:CENTRAL AVE/LARAMIE AVE >E261,MS261,AMR32>COMMENTS:[ProQA Script] Dispatch code: 31D02 35 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Un\n",
        "CALL:UNC-D2",
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
        "CALL:CP-D2",
        "ADDR:1331 W Colton Ave",
        "CITY:REDLANDS",
        "PLACE:HUSTLER CLUB-DE JA VU",
        "MAP:RED078 - 607 J6",
        "X:INDUSTRIAL PARK AVE/TRI-CITY CENTER DR",
        "UNIT:E264,ME263R,AMR39",
        "INFO:WPH2 LAT:34.06252000 LON:-117.203372 METERS:57 %:063,ENTER THROUGH THE BACK IOF THE B");

    doTest("T7",
        "[] | ABD-A1>101 W Redlands Blvd - REDC >LOC INFO:SAVON DRUG STORE >AGN MAP:RED066 -TB MAP:608 B7 >X ST:N 4TH ST/3RD ST >E261,MS261,AMR35>COMMENTS:PT IN PHARMACY,[ProQA Script] Dispatch code: 01A01 45 year old, Female, Conscious, Breathing. Abdominal Pain / P\n",
        "CALL:ABD-A1",
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
        "CALL:FALL-B",
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
        "CALL:BIRTH-",
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
        "CALL:UNC-A1",
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
        "CALL:CI - C",
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
        "CALL:CVA-C4",
        "ADDR:222 Primrose Ave",
        "CITY:REDLANDS",
        "MAP:RED055 - 648 C1",
        "X:No X-Street/HIBISCUS DR",
        "UNIT:E261,MS261,AMR34",
        "CODE:28C04L",
        "INFO:WPH2 LAT:34.04711400 LON:-117.171829 METERS:14 %:095, 60 year old, Female, Conscious, B");

    doTest("T14",
        "[] | UNKM-B>1678 W Redlands Blvd - REDC >LOC INFO:99 CENT STORE >AGN MAP:RED077 -TB MAP:607 H6 >X ST:ALABAMA ST/IOWA ST >E264,ME263R,AMR39>COMMENTS:MAN DOWN INSIDE STORE ATTEMPTING TO GET FURTHER,External Case Number 'RED _1200705' added for Redlands.,Automa\n",
        "CALL:UNKM-B",
        "ADDR:1678 W Redlands Blvd",
        "CITY:REDLANDS",
        "PLACE:99 CENT STORE",
        "MAP:RED077 - 607 H6",
        "X:ALABAMA ST/IOWA ST",
        "UNIT:E264,ME263R,AMR39",
        "INFO:MAN DOWN INSIDE STORE ATTEMPTING TO GET FURTHER");

    doTest("T15",
        "[] | TU - T>N University St / E San Bernardino Ave - REDC >LOC INFO: >AGN MAP:RED110 -TB MAP:608 D4 >X ST: >E261,MS261,AMR39>COMMENTS:401,REDC,External Case Number 'RED _1200707' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: AMB12\n",
        "CALL:TU - T",
        "ADDR:N University St & E San Bernardino Ave",
        "CITY:REDLANDS",
        "MAP:RED110 - 608 D4",
        "UNIT:E261,MS261,AMR39",
        "INFO:401,REDC");

    doTest("T16",
        "[] | FALL-A>365 Los Robles Crst - REDC >LOC INFO: >AGN MAP:RED039 -TB MAP:648 E2 >X ST:OAK ST/No X-Street >E262,AMR34,MS261>COMMENTS:WPH2 LAT:34.03896000 LON:-117.159169 METERS:21 %:095,[ProQA Script] Dispatch code: 17A01G 71 year old, Female, Conscious, Bre\n",
        "CALL:FALL-A",
        "ADDR:365 Los Robles Crst",
        "CITY:REDLANDS",
        "MAP:RED039 - 648 E2",
        "X:OAK ST/No X-Street",
        "UNIT:E262,AMR34,MS261",
        "CODE:17A01G",
        "INFO:WPH2 LAT:34.03896000 LON:-117.159169 METERS:21 %:095, 71 year old, Female, Conscious, Bre");

    doTest("T17",
        "[] | UNC-D1>2050 W Redlands Blvd - REDC >LOC INFO:WALMART (RED) >AGN MAP:RED076 -TB MAP:607 G6 >X ST:NEW JERSEY ST/CALIFORNIA ST >E264,MS261,AMR31>COMMENTS:WPH2 LAT:34.06325000 LON:-117.225730 METERS:51 %:090,**PT AT MCDONALDS INSIDE WALMART**,60 YOF FAINTED\n",
        "CALL:UNC-D1",
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
        "CALL:SICK-D",
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
        "CALL:DIA-C1",
        "ADDR:1325 Pacific St",
        "CITY:REDLANDS",
        "MAP:RED038 - 648 C3",
        "X:W CRESCENT AVE/BALBOA CT",
        "UNIT:E262,MS261,AMR33,E262",
        "CODE:13C01",
        "INFO:WPH2 LAT:34.03305900 LON:-117.177429 METERS:32 %:095, 83 year old, Male, Conscious,");

    doTest("T21",
        "[] | ALL-C1>1666 Brookside Ave - REDC >LOC INFO: >AGN MAP:RED043 -TB MAP:647 H2 >X ST:CASCADE ST/TERRACINA BLVD >E264,ME263,AMR39>COMMENTS:WPH2 LAT:34.04496800 LON:-117.211869 METERS:19 %:063,[ProQA Script] Dispatch code: 02C01 27 year old, Male, Conscious, \n",
        "CALL:ALL-C1",
        "ADDR:1666 Brookside Ave",
        "CITY:REDLANDS",
        "MAP:RED043 - 647 H2",
        "X:CASCADE ST/TERRACINA BLVD",
        "UNIT:E264,ME263,AMR39",
        "CODE:02C01",
        "INFO:WPH2 LAT:34.04496800 LON:-117.211869 METERS:19 %:063, 27 year old, Male, Conscious,");

    doTest("T22",
        "[] | CI - C>250 E Fern Ave -109 REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C1 >X ST:SONORA ST/MYRTLE ST >T261,BC705,E261,E264>COMMENTS:[Address: 250 E FERN AVE] [Medium] [Unknown] FERNWOOD CONDOS RESIDENT IN WHEELCHAIR UNABLE TO EVACUATE WITHOUT ASSISTANCE,\n",
        "CALL:CI - C",
        "ADDR:250 E Fern Ave",
        "APT:109",
        "CITY:REDLANDS",
        "MAP:RED055 - 648 C1",
        "X:SONORA ST/MYRTLE ST",
        "UNIT:T261,BC705,E261,E264",
        "INFO:[Address: 250 E FERN AVE] [Medium] [Unknown] FERNWOOD CONDOS RESIDENT IN WHEELCHAIR UNABLE TO EVACUATE WITHOUT ASSISTANCE,");
  }
  
  public static void main(String[] args) {
    new CASanBernardinoCountyParserTest().generateTests("T1");
  }
}