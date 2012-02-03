package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
San Bernardino County, CA
Contact: support@active911.com

[] | TU - T>W Cypress Ave / S Center St - REDC >LOC INFO: >AGN MAP:RED045 -TB MAP:648 B2 >X ST: >E261,MS261,AMR33>COMMENTS:GREEN 300 vs BLACK SEDAN,External Case Number 'RED _1200689' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: \n
[] | HEART->1600 E Citrus Ave -A REDC >LOC INFO:DR HOENSHELL >AGN MAP:RED069 -TB MAP:608 F7 >X ST:N DEARBORN ST/S LA SALLE ST >E261,MS261,AMR37>COMMENTS:[ProQA Session Aborted] ALLIED AGENCY,External Case Number 'RED _1200691' added for Redlands.,Automatic C\n
[] | SICK-D>105 Terracina Blvd -106-a REDC >LOC INFO:BROOKSIDE HEALTH >AGN MAP:RED043 -TB MAP:647 H2 >X ST:BROOKSIDE AVE/CORDOVA AVE >E264,ME263R,AMR39>COMMENTS:793-2271,[ProQA Script] Dispatch code: 26D01 85 year old, Male, Conscious, Breathing. Sick Person\n
[] | PS - P>27320 W Lugonia Ave - RED >LOC INFO:TARGET (RED) >AGN MAP:RED092 -TB MAP:607 H5 >X ST:INDIANA CT/N ALABAMA ST >E264>COMMENTS:CHILD LOCKED IN A WHITE CADILAC CTS,RED,External Case Number 'RED _1200693' added for Redlands.,\n
[] | UNC-D2>205 Judson St -C REDC >LOC INFO:JUDSON APTS >AGN MAP:RED068 -TB MAP:608 E7 >X ST:CENTRAL AVE/LARAMIE AVE >E261,MS261,AMR32>COMMENTS:[ProQA Script] Dispatch code: 31D02 35 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Un\n
[] | CP-D2 >1331 W Colton Ave - REDC >LOC INFO:HUSTLER CLUB-DE JA VU >AGN MAP:RED078 -TB MAP:607 J6 >X ST:INDUSTRIAL PARK AVE/TRI-CITY CENTER DR >E264,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06252000 LON:-117.203372 METERS:57 %:063,ENTER THROUGH THE BACK IOF THE B\n
[] | ABD-A1>101 W Redlands Blvd - REDC >LOC INFO:SAVON DRUG STORE >AGN MAP:RED066 -TB MAP:608 B7 >X ST:N 4TH ST/3RD ST >E261,MS261,AMR35>COMMENTS:PT IN PHARMACY,[ProQA Script] Dispatch code: 01A01 45 year old, Female, Conscious, Breathing. Abdominal Pain / P\n
[] | FALL-B>620 E Highland Ave -26 REDC >LOC INFO:BRASWELLS CHATEAU >AGN MAP:RED046 -TB MAP:648 D2 >X ST:E REDLANDS BLVD/ROOSEVELT RD >E262,MS261,AMR30>COMMENTS:WPH2 LAT:34.04472100 LON:-117.164211 METERS:41 %:095,[ProQA Script] Dispatch code: 17B02G 97 year\n
[] | BIRTH->1320 Industrial Park Ave - REDC >LOC INFO:BURGER KING >AGN MAP:RED078 -TB MAP:607 J6 >X ST:W COLTON AVE/TRI-CITY CENTER DR >E264,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06319600 LON:-117.200990 METERS:14 %:063,[ProQA Script] Dispatch code: 24B02 21 yea\n
[] | UNC-A1>626 N Dearborn St -87 REDC >LOC INFO:ORANGE GROVE MHP >AGN MAP:RED082 -TB MAP:608 F6 >X ST:INDEPENDENCE AVE/STILLMAN AVE >E261,ME263R,AMR39>COMMENTS:WPH2 LAT:34.06163000 LON:-117.143354 METERS:28 %:063,[ProQA Script] Dispatch code: 31A01 52 year \n
[] | CI - C>1270 W Park Ave - REDC >LOC INFO:REDLANDS CITY YARDS >AGN MAP:RED065 -TB MAP:607 J7 >X ST:TENNESSEE ST/KANSAS ST >T261,BC705,ME263R,E264>COMMENTS:PD OS FIRE ALARM ACTIVATION,External Case Number 'RED _1200702' added for Redlands.,\n
[] | CA- Co>350 Terracina Blvd - REDC >LOC INFO:RCH >AGN MAP:RED036 -TB MAP:647 J3 >X ST:LAUREL AVE/W FERN AVE >E262>COMMENTS:ZONE 1 GENERAL FIRE ALARM,REDC,External Case Number 'RED _1200703' added for Redlands.,\n
[] | CVA-C4>222 Primrose Ave - REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C1 >X ST:No X-Street/HIBISCUS DR >E261,MS261,AMR34>COMMENTS:WPH2 LAT:34.04711400 LON:-117.171829 METERS:14 %:095,[ProQA Script] Dispatch code: 28C04L 60 year old, Female, Conscious, B\n
[] | UNKM-B>1678 W Redlands Blvd - REDC >LOC INFO:99 CENT STORE >AGN MAP:RED077 -TB MAP:607 H6 >X ST:ALABAMA ST/IOWA ST >E264,ME263R,AMR39>COMMENTS:MAN DOWN INSIDE STORE ATTEMPTING TO GET FURTHER,External Case Number 'RED _1200705' added for Redlands.,Automa\n
[] | TU - T>N University St / E San Bernardino Ave - REDC >LOC INFO: >AGN MAP:RED110 -TB MAP:608 D4 >X ST: >E261,MS261,AMR39>COMMENTS:401,REDC,External Case Number 'RED _1200707' added for Redlands.,Automatic Case Number(s) issued for Ground Ambulance: AMB12\n
[] | FALL-A>365 Los Robles Crst - REDC >LOC INFO: >AGN MAP:RED039 -TB MAP:648 E2 >X ST:OAK ST/No X-Street >E262,AMR34,MS261>COMMENTS:WPH2 LAT:34.03896000 LON:-117.159169 METERS:21 %:095,[ProQA Script] Dispatch code: 17A01G 71 year old, Female, Conscious, Bre\n
[] | UNC-D1>2050 W Redlands Blvd - REDC >LOC INFO:WALMART (RED) >AGN MAP:RED076 -TB MAP:607 G6 >X ST:NEW JERSEY ST/CALIFORNIA ST >E264,MS261,AMR31>COMMENTS:WPH2 LAT:34.06325000 LON:-117.225730 METERS:51 %:090,**PT AT MCDONALDS INSIDE WALMART**,60 YOF FAINTED\n
[] | FC -St>620 E Highland Ave -4 REDC >LOC INFO:BRASWELLS CHATEAU >AGN MAP:RED046 -TB MAP:648 D2 >X ST:E REDLANDS BLVD/ROOSEVELT RD >T261,BC705,E262,E261,ME263,ME9,MS261,OSHA02,6FGND3>COMMENTS:SMOKE SHOWING FROM HEATING SYST IN ROOM #4,REDLANDS - CITY,Exter\n
[] | SICK-D>450 Judson St -98 REDC >LOC INFO:SYLVAN MOBILE >AGN MAP:RED081 -TB MAP:608 E6 >X ST:LARAMIE AVE/SYLVAN BLVD >E261,MS261,AMR35>COMMENTS:[Address: 450 JUDSON ST] [Medium] [Unknown] FOR UNIT #99 ONLY - VIDEO-TRANSLATOR RELAY FOR DEAF-SIGN LANGUAGE R\n
[] | DIA-C1>1325 Pacific St - REDC >LOC INFO: >AGN MAP:RED038 -TB MAP:648 C3 >X ST:W CRESCENT AVE/BALBOA CT >E262,MS261,AMR33,E262>COMMENTS:WPH2 LAT:34.03305900 LON:-117.177429 METERS:32 %:095,[ProQA Script] Dispatch code: 13C01 83 year old, Male, Conscious,\n
[] | ALL-C1>1666 Brookside Ave - REDC >LOC INFO: >AGN MAP:RED043 -TB MAP:647 H2 >X ST:CASCADE ST/TERRACINA BLVD >E264,ME263,AMR39>COMMENTS:WPH2 LAT:34.04496800 LON:-117.211869 METERS:19 %:063,[ProQA Script] Dispatch code: 02C01 27 year old, Male, Conscious, \n
[] | CI - C>250 E Fern Ave -109 REDC >LOC INFO: >AGN MAP:RED055 -TB MAP:648 C1 >X ST:SONORA ST/MYRTLE ST >T261,BC705,E261,E264>COMMENTS:[Address: 250 E FERN AVE] [Medium] [Unknown] FERNWOOD CONDOS RESIDENT IN WHEELCHAIR UNABLE TO EVACUATE WITHOUT ASSISTANCE,\n

 */

public class CASanBernardinoCountyParser extends FieldProgramParser {
  
  public CASanBernardinoCountyParser() {
    super("SAN BERNARDINO COUNTY", "CA",
           "CALL! ADDR! LOC_INFO:PLACE AGN_MAP:MAP! X_ST:X! UNIT COMMENTS:INFO");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("| ")) return false;
    body = body.substring(2).trim();
    return parseFields(body.split(">"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES);
      data.strApt = p.getLastOptional(" -");
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-TB MAP:", "- ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern PRO_QA_PTN = Pattern.compile(" *\\[ProQA .*?\\] *");
  private static final Pattern CODE_PTN = Pattern.compile("\\bDispatch code: *(\\w+)\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(",External");
      field = PRO_QA_PTN.matcher(field).replaceAll(" ");
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(0,match.start()) + " " + field.substring(match.end());
      }
      field = field.replaceAll("  +", " ").trim();
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "RED", "REDLANDS",
      "REDC", "REDLANDS"
  });
}
