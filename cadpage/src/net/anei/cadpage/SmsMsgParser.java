package net.anei.cadpage;

import java.util.Properties;


/**
 * This clas is responsible for parsing useful information from an SMS page message
 * See end of source for future pending district information.
 */
public class SmsMsgParser {

  private String strBody = "";
  private String strCall = "";
  private String strAddress = "";
  private String strCity = "";
  private String strApt = "";
  private String strCross = "";
  private String strBox= "" ;
  private String strUnit= "" ;
  private String strState="";
  private String strMap = "";
  private String strCallId = "";
  private String defCity = "";
  private String defState="";
  
  /**
   * Return original message text
   */
  public String getBody() {
    return strBody;
  }
  
  /**
   * @return call ID
   */
  public String getCallId() {
    return strCallId;
  }

  /**
   * @return the Call description
   */
  public String getCall() {
    return strCall;
  }

  /**
   * @return the call address
   */
  public String getAddress() {
    return strAddress;
  }

  public String getMapAddress() {
    StringBuilder sb = new StringBuilder(strAddress);
    String city = strCity;
    if (city.length() == 0) city = defCity;
    if (city.length() > 0) {
      sb.append(",");
      sb.append(city);
    } 
    String state = strState;
    if (state.length() == 0) state = defState;
    if (state.length() > 0) {
      sb.append(",");
      sb.append(state);
    }
    
    return sb.toString();
	}
  /**
   * @return the call city
   */
  public String getCity() {
    return strCity;
  }

  /**
   * @return the call city
   */
  public String getState() {
    return strState;
  }

  /**
   * @return the call appt number
   */
  public String getApt() {
    return strApt;
  }

  /**
   * @return the call Cross street description
   */
  public String getCross() {
    return strCross;
  }

  /**
   * @return the call box
   */
  public String getBox() {
    return strBox;
  }

  /**
   * @return the call unit
   */
  public String getUnit() {
    return strUnit;
  }
  
  /**
   * @return map code
   */
  public String getMap() {
    return strMap;
  }
  
  /**
   * @return true if this message contain the text phrases that indicate it is 
   * a valid page message
   * @return true
   */
  public static boolean isPageMsg(String msgText) {

    // Next look up location code and use it to see if this message contains the trigger phrase
    String sLocation = ManagePreferences.location();
    int iLocation = Integer.parseInt(sLocation);
    String[] phrases = new String[]{"Call:", "TYPE:", "Map:", "(Corvallis Alert)","Cad:","OCSO E911:","CAD:","***","***"};
    if (iLocation > phrases.length) return false;
    boolean result = (msgText.indexOf(phrases[iLocation-1]) >= 0);
    return result;
  }
  
  /**
   * constructor
   * @param strMessage SMS message text to be parsed
   */
  public SmsMsgParser(String strMessage) {

    // Save message text
    strBody = strMessage;
    
    // Decode the call page and place the data in the database
        switch (Integer.parseInt(ManagePreferences.location())) {
        case 1:
          decodeLCFRPage(strMessage);
          break;
        case 2:
          decodeSuffolkPage(strMessage);
          break;
        case 3: 
          decodeHarrisPage(strMessage);
          break;
        case 4:
          decodeBentonCoPage(strMessage);
          break;
        case 5:
        	decodeHerkimerPage(strMessage);
        	break;
        case 6:
        	decodeOconeePage(strMessage);
        	break;
        case 7:
        	decodeLivingstonPage(strMessage);
        	break;
        case 8:
        	decodeDixHillsPage(strMessage);
        	break;
        case 9:
        	decodeBabylonPage(strMessage); 
        	break;
        case 10:
        	decodeMaconPage(strMessage);
        	break;
        }

  }

  private void decodeMaconPage(String body) {
	/*
Contact: Ryan Hursey <ryanhursey@gmail.com>
Sender: 8283420118
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1650 WIDE HORIZON DR FRANKLIN AAAAA, AAAAA 5555559999 Map: Grids:0,0
911 CENTER:90F >FIRE ALARM 120 RIVERVIEW ST FRANKLIN ANGEL MEDICAL CENTER 5555558411 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 289 SUTTON LN FRANKLIN AAAAA, AAAAAAA& AAAAAA 5555559999 Map: Grids:0,0
911 CENTER:MED >EMERGENCY RUN 248 HARRISON AVE XS: W MAIN ST TO BRYSON CITY RD FRANKLIN AAAAAA, CHARMAYNE 5555559999 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 11 CHATTACHOEE LN FRANKLIN VERIZON WIRELESS 5555559999
911 CENTER:C1 >EMERGENCY RUN 236 PAULINE AVE XS: ULCO DR FRANKLIN AAAAA, AAAAAAA P 5555559999 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1682 LEATHERMAN GAP RD FRANKLIN  AAA, ANGIE 5555559999 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 837 GEORGIA RD FRANKLIN AAAAA 5555558237 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 730 LAKESHORE DR FRANKLIN CHRISTIAN, JOHN SMITH 8285249999 Map: Grids:0,0
Sender: 8283711473
911 CENTER:50 >VEHICLE ACCIDENT 428 COWEETA CHURCH RD OTTO SMITH, J 828369999 Map: Grids:0,0
	 */
	  Log.v("decodeLCFRPage: Message Body of:" + body);
	  defState = "NC";
	  defCity = "MACON COUNTY";
	  body= body.replace(">","Call:");
	  
	  
}

private static Properties LCFRCityCodes = buildCodeTable(new String[]{
      "CH", "Chantilly",
      "LB", "Leesburg",
      "AL", "Aldie",
      "ST", "Sterling",
      "MB", "Middleburg",
      "AB", "Ashburn",
      "SP", "Sterling",
      "BL", "Bluemont",
      "CE", "Centreville",
      "HA", "Hamilton",
      "LV", "Lovettsville",
      "PA", "Paris",
      "PV", "Purceville",
      "PS", "Paeonian",
      "RH", "Round Hill",
      "UP", "Upperville",
      "FX19", "Fairfax",
      "FX", "Fairfax",
      "FQ", "Faquier"});
  private void decodeLCFRPage(String body) {
    /*
     * Reporting email: MadisonFD <madisonfd@windstream.net>
     * Call:12D02E-SEIZURES CONT,42914 OVERLY SQ-CH Apt:,X-St:NORRINGTON SQ KIR,A6092,Box:1908 ,ADC:5520 G06 [90]
     * Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]
     * Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]
     * Call:20D01H-HEAT EXPOSURE,STONE SPRINGS BLVD-AL/MINERAL SPRINGS CIR-AL Apt:,X-St:GREENSTONE DR & M,A6092 9942 ACO9,Box:0910 ,ADC:5520 B02 [77]
     */


    Log.v("decodeLCFRPage: Message Body of:" + body);
    defState = "VA";

    // Needs some massaging before it can be run through the standard parser
    body = body.replace(" Apt:", ",Apt:");
    Properties props = parseMessage(body, ",", new String[]{"Addr", "Unit"});
    strCall = props.getProperty("Call", "");
    parseAddress(props.getProperty("Addr", ""));
    strApt = props.getProperty("Apt", "");
    strCross = props.getProperty("X-st", "");
    strUnit = props.getProperty("Unit", "");
    strBox = props.getProperty("Box", "");
    strMap = props.getProperty("ADC", "");
    
    strCity = convertCodes(strCity, LCFRCityCodes);
  }

  private static String[] SuffolkCityCodes = new String[]{
    "BRENTW", "Brentwood",
    "NBAYSH", "Bay Shore",
    "BAYSHO", "Bay Shore"
  };
  private void decodeSuffolkPage(String body) {
    /* Sample Suffolk Page
Contact: Jason Pedota <jpedota805@gmail.com>
Sender: 6317967579
TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16
TYPE: STRUCTURE FIRE LOC: 81 NEW HAMPSHIRE AV NBAYSH  CROSS: E FORKS RD / E 3 AV CODE: 69-D-10 TIME: 16:36:48
TYPE: OPEN BURNING LOC: 65 GRANT AVE BRENTW CROSS: SUFFOLK AVE 18:39:20 CODE: 54-C-6
     */
    
      Log.v("DecodeSuffolkPage: Message Body of:" + body);
      defState="NY";
      defCity="SUFFOLK COUNTY";

      Properties props = parseMessage(body, new String[]{"LOC", "CROSS", "CODE", "TIME"});
      strCall = props.getProperty("TYPE", "");
      parseAddress(props.getProperty("LOC", ""));
      strCross = props.getProperty("CROSS", "");
      
      for (int ndx = 0; ndx<SuffolkCityCodes.length-1; ndx+= 2) {
        int ipt = strAddress.lastIndexOf(" " + SuffolkCityCodes[ndx]);
        if (ipt >= 0) {
          strAddress = strAddress.substring(0, ipt);
          strCity = SuffolkCityCodes[ndx+1];
          break;
        }
      }
  }

  private void decodeHarrisPage(String body) {
    /* Sample Harris Page
     * 11:58 W HILLSIDE DR/EASTEX FRWY, ; Map:414D Sub: Nat:MA-MUTUAL AID / ASSIST AGENCY Units:E91 T81 T73 E-E39 X-St:EASTEX

  1of2:09/06 11:56 W HILLSIDE DR/EASTEX FRWY, ; Map:414D Sub: Nat:MA-MUTUAL AID / ASSIST AGENCY Units:E91 T81 T73 E-L19 X-St:EASTEX

  1of2:09/06 11:28 19707 WOOD WALK LN, ; Map:337U Sub:PINEHURST OF ATASCOCITA Nat:09E01-ARREST - NOT BREATHING Units:E-M19 E-M29 E-7900

  1of2:09/05 08:56 19226 AQUATIC DR, ; Map:378A Sub:WALDEN ON LAKE HOUSTON Nat:52B01G-FIRE ALARM - RESIDENTIAL Units:ATFD E-E39 X-

  1of2:09/04 19:45 17219 KOBUK VALLEY CIR, ; Map:377E Sub:EAGLE SPRINGS Nat:67B03U-OUTSIDE FIRE - INVESTIGA Units:E-E39 X-St:*** Dead

  1of2:09/03 08:14 LILES LN/WOODLAND HILLS DR, ; Map:376H Sub:ATASCOCITA FOREST Nat:29-MOTOR VEHICLE INCIDENT Units:E-M19 E-E39 X-

    
     */
  
    Log.v("DecodeHarrisPage: Message Body of:" + body);
    defState="TX";
    defCity="HARRIS COUNTY";
    
    // Strip first 16 characters off of message
    if (body.length() <= 16) return;
    body = "Loc:" + body.substring(16);
    
    Properties props = parseMessage(body, new String[]{"Map", "Sub", "Nat", "Units", "X-St"});
    parseAddress(props.getProperty("Loc", ""));
    strMap = props.getProperty("Map", "");
    strCall = props.getProperty("Nat", "");
    strUnit = props.getProperty("Units", "");
    strCross = props.getProperty("X-st", "");
    
    // Strip extra stuff off of address line
    int ipt = strAddress.indexOf(',');
    if (ipt > 0) strAddress = strAddress.substring(0, ipt).trim();
    if (strCall.contains("MA-MUTUAL AID")) strCity = "Humble";
  }
  

  private void decodeBentonCoPage(String body) {
      
      // Sample Benton County Page
      // from: alerts@corvallis.ealertgov.com
      // (Corvallis Alert) INC: CODE 1 MEDICAL\nADD:1740 MAIN ST\nAPT:\nCITY:PHILOMATH\nX:N 17TH ST * N 18TH ST\nMAP:540-365\nCFS:0907010-119\nDIS:PHILOMATH FIRE
      // (Corvallis Alert) INC:COMM FIRE ALARM\nADD:421 S 19TH ST\nAPT:\nCITY:PHILOMATH\nX:ASH ST * CEDAR ST\nMAP:540-360\nCFS:100410-188\nDIS:PHILOMATH FIRE\nDIS:PHI
      
      Log.v("DecodeBentonCo: Message Body of:" + body);
      defState="OR";
      defCity="BENTON COUNTY";
      Properties props = parseMessage(body, "\n");
      
      strCall=props.getProperty("INC", "");
      strAddress=props.getProperty("ADD", "");
      strCity=props.getProperty("CITY", "");
      strApt =props.getProperty("APT", "");
      strCross=props.getProperty("X", "");
      strMap=props.getProperty("MAP", "");
      strCallId = props.getProperty("CFS", ""); 
  }


  private void decodeOconeePage(String body) {
    /* Sample Oconee Page
     * 
     * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046 
     * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728 
     * OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR
     * OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE
     * OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53
     */

    Log.v("DecodeOconeePage: Message Body of:" + body);
    defState="GA";
    defCity="Oconee";

    // Skip everything up to first colon
    int ipt = body.indexOf(':');
    if (ipt >= 0) body = body.substring(ipt+1).trim();

    // Skip phone number
    boolean skip = false;
    int mode = 0;
    int callCnt = 0;
    for (String token : body.split("\\s+")) {
      switch (mode) {
      
      // Processing call
      // Ignore phone number, terminated by numeric token which is assumed to
      // be start of address
      case 0:
        if (skip) {
          skip = false;
          continue;
        }
        if (token.equalsIgnoreCase("Phone:")) {
          strCall = "";
          callCnt = 0;
          skip = true;
          continue;
        }
        
        if (callCnt >= 3 || callCnt > 0 && token.matches("\\d{2,}")) {
        	mode++;
        	// no break, fall through to address processing
        } else {
          callCnt++;
          if (strCall.length() > 0) strCall += " ";
          strCall += token;
          break;
        }
        
      // Processing address
      // terminated by 7 digit call ID (We think)
      case 1:
        if (token.matches("\\d{7}")) {
          strCallId = token;
          mode++;
          break;
        }
        if (strAddress.length() > 0) strAddress += " ";
        strAddress += token;
        break;
        
      // Cross street processing
      // This actually looks more like an approach street, but assigning it
      // to cross will at least get it to display
      case 2:
        if (strCross.length() > 0) strCross += " ";
        strCross += token;
        break;
      }
    }
  }
  
  private void decodeHerkimerPage(String body) {
	    /* 
	     * Sample Herkimer Pages
	     * Reporting email: Chris Conover <conovercj@ntcnet.com>
	     * Sender: HC911@herkimercounty.org
       * (EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
       * (MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
       * (EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
These may be new herkimer county pages that are not complatable with the previous ones.  Further information
has been requested.
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Paula, Wayne\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Willoughby, Ruby\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Jones, Ronald\n5419991234 MAP: 
	     */
	    
	      Log.v("DecodeHerkimerPage: Message Body of:" + body);
	      defState="NY";
	      
	      body = body.trim();
	      if (body.charAt(0) == '(') {
	        int pt = body.indexOf(')');
	        if (pt >= 1) {
	          strCall = body.substring(1, pt);
	          strCall = strCall.replaceAll("\\s*>", ">");
	          body = body.substring(pt+1).trim();
	        }
	      }
	      
	      // Strip CAD number off end of message
	      int pt = body.indexOf(" Cad:");
	      if (pt >= 0) {
	        strCallId = body.substring(pt+5).trim();
	        body = body.substring(0, pt).trim();
	      }
	      
	      // Address formatting is very strange.
	      // Parse by whitespace separated tokens terminated by an entry that
	      // contains a string of 3 or more 'A' characters.  The last entry 
	      // before the terminator is the city.
	      // And any tokens after an "XS:" token are added to the cross rather
	      // than the address
	      boolean cross = false;
	      for (String token : body.split("\\s+")) {
	        if (token.matches("AAA+")) break;
	        if (strCity.length() > 0) {
	          if (!cross) {
	            if (strAddress.length() > 0) strAddress += " ";
	            strAddress += strCity;
	          } else {
	            if (strCross.length() > 0) strCross += " ";
	            strCross += strCity;
	          }
	        }
          if (token.equals("XS:")) {
            cross = true;
            strCity = "";
          } else {
            strCity = token;
          }
	      }
	  }
  private void decodeLivingstonPage(String body) { // Issue 17 
	  /*
	   * CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE
HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10
04:17:07 ECOOK]
CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE
[09/23/10 21:45:06 ECOOK]
CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE:
P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious,
Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal
CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1
2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing.
Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.
	   */
	  Log.v("DecodeLivingstonPage: Message Body of:" + body);
      defState="MI";
      defCity = "Livingston";
      String tmpAddress="";
      body = body.trim();
      try { 
    	  String[] AData = body.split(";");
      strCall = AData[1];
      // Need to check for single address or Intersection address.
      if (AData[2].contains("/")  ){
        // This is an intersection and not a street
         String[] strTemp = AData[2].split("/");
         strTemp[0] = strTemp[0].substring(2);
        //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
         tmpAddress = strTemp[0];

        tmpAddress = tmpAddress + " and " +  strTemp[1].toString();
      }else {
        tmpAddress = AData[2].toString();
      }
      // Intersection address has a / and two  - cities
      strAddress= tmpAddress;
      if (strAddress.length() < 4) {
        strAddress = "Error Street not Found.";
      }

      //strApt = AData[1].substring(AData[1].indexOf("Apt:"));
      strApt= "";
      if (AData[3].length() <20) { //this is a cross street (guessing)
      strCross =  AData[3];
      strUnit = AData[4];
      } else {
    	  strCross = "";
    	  strUnit = AData[3]; //AData[3];
      }
      strBox = "";//AData[4].substring(4);  
      } catch (IndexOutOfBoundsException ex) {
        Log.v("Exception in decodeLivingston-" + ex.getMessage());
      }
  }
  
 private void decodeBabylonPage(String body) {
	 /*
*** 13 - Structure Fire *** 147 CHERUBINA LN CS: LEADER AVE  / SKIDMORE RD TOA: 22:37 09/22/10 OIL BURNER NORTH BABYLON FC 2010-002398 HY: 8' 11
*** 13 - Structure Fire *** 514 MOUNT PL CS: ESSEX ST  / LAKEWAY DR TOA: 19:55 09/22/10 NORTH BABYLON FC 2010-002393 HY: 12' 533 MOUNT PL @ ESSE
*** 2nd/16 - Rescue *** 733 HIGHRIDGE RD CS: OCONNER RD  / NARLAND LN TOA: 20:46 09/22/10 a/m pysch emer NORTH BABYLON FC 2010-002395
*** 23 - Miscellaneous Fire *** SR CITZ APTS (5 BLDGS) COMPLEX 15 WEEKS RD CS: DEER PARK AVE  / MULHOLLAND DR TOA: 11:07 09/23/10 INVEST NORTH B
	  */
	 Log.v("DecodeBabylonPage: Message Body of:" + body);
	  defState="NY";
	  String tmpAddress="";
	  body = body.trim();
      if (body.contains("***")) {
	        int pt = body.indexOf("***");
	        if (pt >= 0) {
	          int pta = body.indexOf("***",pt+3);	
	          strCall = body.substring(pt+3, pta);
	          body = body.substring(pta+1).trim();
	          
	        }
	      }
      try {
    	  String[] AData = body.split(":");
          // Need to check for single address or Intersection address.
    	  strAddress = AData[0].substring(2,AData[0].length()-2);
          if (AData[1].contains("/")  ){
            // This is an intersection and not a street
             String[] strTemp = AData[1].split("/");
             //strTemp[0] = strTemp[0].substring(2);
            //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
             tmpAddress = strTemp[0];

            tmpAddress = tmpAddress + " and " +  strTemp[1].substring(0,strTemp[1].length()-3);
          }else {
            tmpAddress = AData[1].toString();
          }
          strCross = tmpAddress;
          strUnit = AData[3];
          if (body.contains("FC ")){
        	  int iStart = body.indexOf("FC ");
        	  int iEnd = body.indexOf(" ",iStart+3);
        	  if (iEnd <=0) {iEnd = body.length(); }
        	  strUnit = strUnit + " #" + body.substring(iStart+3, iEnd);      	  
          }
      }catch (IndexOutOfBoundsException ex) {
        Log.v("Exception in decodeDixHillsPage-" + ex.getMessage());
      }
      
	}

 private void decodeDixHillsPage(String body) {
		/*
contact: "Craig Caviness" <ccaviness@dixhillsfd.org>
sender: paging@dixhillsfd.xohost.com
2010-001784 23:36 *** 16- Rescue *** 17 BRYCEWOOD DR SPIEGEL, LORI A Dix Hills HQ ARISTA DR 31-A-1 UNCONSCIOUS / FAINTING (NEAR) CEWOOD DR DIXHIL TYPE:
2010-001779 10:34 *** 24/16- Mutual Aid *** 51 BALDWIN PATH  Dix Hills HQ
2010-001777 15:54 *** 16- Rescue ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST
2010-001778 15:54 *** 23- Misc Fire ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST
2010-001774 11:56 *** 13- Structure Fire *** 29 WHITE BIRCH DR FULGONI, MARISSA Dix Hills HQ BALSAM DR 52-B-1G ALARMS TE BIRCH DR DIXHIL TYPE: ALARMS 
2010-001766 05:54 *** 13- Structure Fire *** 29 WILDWOOD DR TRUEN, CRAIG Dix Hills HQ WHITNEY CT 60-C-1O GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) DWOOD
2010-001919 01:48 *** 16- Rescue *** 179 OAKFIELD AV BRUZZESE, ROCCO  SEAMAN NECK RD 6-D-3 RESPIRATORY KFIELD AV DIXHIL TYPE: RESPIRATORY LOC: 179  OAKFI
2010-001923 11:44 *** 16- Rescue *** 337 DEER PARK AV SUNRISE ASSISTED LIVING RED MAPLE LA Alert
		 */
	  Log.v("DecodeDixHillsPage: Message Body of:" + body);
	  defState="NY";
    defCity="Dix Hills";
	  body = body.trim();
	  int pt = body.indexOf("***");
	  if (pt < 0) return;
    int pta = body.indexOf("***",pt+3);	
    if (pta < 0) return;
    strCall = body.substring(pt+3, pta).trim();
    body = body.substring(pta+3).trim();
    int ptb = body.toUpperCase().indexOf(" DIX HILLS");
    if (ptb < 0) ptb = body.length();
    strAddress = body.substring(0, ptb);
    int ptc = strAddress.indexOf(",");
    if (ptc >= 0) {
      int ptd = strAddress.lastIndexOf(" ",ptc);
    	if (ptd >= 0) strAddress = strAddress.substring(0,ptd);
    }
	}
 
 /** 
  * General purpose parser for formats where there is not a clear delimiter
  * between key: value item pairs.
  * @param body message body to be parsed
  * @param keyWords list of expected keywords
  * @return Properties object containing the parsed key: value pairs
  */
 private Properties parseMessage(String body, String[] keyWords) {
   StringBuffer sb = new StringBuffer(body);
   for (String keyWord : keyWords) {
     int ipt = sb.indexOf(" " + keyWord + ":");
     if (ipt >= 0) sb.setCharAt(ipt, '\n');
   }
   return parseMessage(sb.toString(), "\n");
 }

 /**
  * General purpose message parser for formats where there is a clear delimiter
  * between key: value data pairs 
  * @param body
  * @param delim line delimiter
  * @return
  */
 private Properties parseMessage(String body, String delim) {
   return parseMessage(body, delim, null);
 }
 
 /**
  * General purpose parser
  * @param body of message to be parsed
  * @param delim expression to be used to separate lines in message
  * @param missedKeys if not null, an array of keywords to be assigned to
  * lines that are missing a keyword
  * @return Properties object containing the parsed line tokens
  */
 private Properties parseMessage(String body, String delim, String[] missedKeys) {
   
     Properties props = new Properties();
     String[] lines = body.split(delim);
     int missed = 0;
     for (String line : lines) {
         line = line.trim();
         int ndx = line.indexOf(':');
         if (ndx < 0) {
           if (missedKeys != null && missed < missedKeys.length) {
             props.put(missedKeys[missed++], line);
           }
           continue;
         }
         if (ndx+1 == line.length()) continue;
         String key = line.substring(0, ndx).trim();
         String value = line.substring(ndx+1).trim();
         ndx = key.lastIndexOf(' ');
         if (ndx >= 0) key = key.substring(ndx+1);
         props.put(key, value);
     }
     return props;
 }

 /**
  * Parse address line into address and city fields
  * @param addressLine address line to be parsed
  */
 private void parseAddress(String addressLine) {
   for (String addr : addressLine.split("/")) {
     String[] tmp = addr.split("-");
     if (strAddress.length() > 0) strAddress += " and ";
     strAddress += tmp[0];
     if (tmp.length > 1) {
       tmp[1] = tmp[1].trim();
       int pta = tmp[1].indexOf(" ");
       if (pta <=0) pta = tmp[1].length();
       strCity = tmp[1].substring(0,pta);
     }
   }
 }

 /**
  * Build a code table for use by convertCodeTable
  * @param table array containing pairs of strings, each pair will be considered
  * as a key/value pair to be inserted into the code table
  * @return resulting code table
  */
 private static Properties buildCodeTable(String[] table) {
   Properties props = new Properties();
   for (int ndx = 0; ndx < table.length-1; ndx+=2) {
     props.put(table[ndx], table[ndx+1]);
   }
   return props;
 }

 /**
  * Convert any special codes in an item
  * @param item String item to be converted
  * @param codeTable table of codes with corresponding values
  * @return if item is a key to a codeTable entry, returns the associated value,
  * otherwise returns item
  */
 private String convertCodes(String item, Properties codeTable) {
   String value = codeTable.getProperty(item);
   return (value != null ? value : item);
 }
 
 /***************************************************************************
  * Pending district support
  * 
Centreville, MD
qac911:*D 4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS @500 CHURCH HILL RD COMMERCIAL BOX Q04
qac911:*D 4-5 MVC W/ENTRAPMENT RT301NB / RT304 RESCUE BOX Q04
qac911:*D 5-1 LG BRUSH/GRASS FIRE RT405 / WINDSWEPT FARM LN BRUSH BOX Q05
qac911:*D 4-5 UNCONSCIOUS/FAINTING RT301NB / ROLLING BRIDGE RD UNCONSCIOUS Q04
qac911:*D 5-2 MVC W/ROLLOVER RT301NB / HAYDEN RD RESCUE BOX Q05
qac911:*D 4-7 MVC W/ROLLOVER 1627 RUTHSBURG RD RESCUE BOX Q04

**********************************************************
Harford, MD
Under box number, the N in this case actually represents a 10## box. Also notice that a separate text is sent for each piece of equipment due on a box assignment (see the two last text messages below.
[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717
[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427
[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445
[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395
[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:E1011 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161

**********************************************************
Setauket, NY
AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51
AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS): 56 YOF SICK 26-A-5 IFO BUILDING at 5000 ROUTE 347, East Setauket  c/s: ARROWHEAD LN SOUTH   O: KOHLS . . 14:54:20
MISC CALL, CHIEFS INVESTIGATION: GENERAL FIRE ALARM 52C04 Residential (multiple) at 700H HEALTH SCIENCES DR, STONY BROOK  c/s: NICOLLS RD   O: CHAPIN APTS - S : 26-A-16 at 20 FAWN LN W, SOUTH SETAUKET  c/s: LONGBOW LN . . 00:20:06
AMBULANCE, HEMORRHAGE / LACERATIONS: 21-A-1 - 61 YOM - CUT TO HAND at 8 HOLLY LN, EAST SETAUKET  c/s: CRANE NECK RD . . 16:57:21
MISC CALL WITH RESCUE, MVA: 29-B-1U - INJURIES at C/O, Setauket  c/s: WIRELESS RD . . 16:08:02

**********************************************************
Prineville, OR
Reporting email: 5414603655@vzwpix.com
Sender:dispatch@prinevillepd.org

(PPD) 6:01 PM
NEW EVENT PFD
MED1
1201: 1271
228 SW MEADOWLAKES DR
PRINEVILLE

(PPD) 3:17 PM
NEW EVENT PFD
MVA
1201: 1273 / 1225
LAMONTA/PIONEER CUTSTOCK
PRINEVILLE

**********************************************************
Tipton County, IN (or TN?)
reporting email: Amy Lane <ammlane@gmail.com>
sender: CAD@tipco.com
CAD:A5,R45,T43,E42,E41,T46;STRUCTURE FIRE RESIDENTIAL;4003;3000 N US 31 NB
CAD:WEATHER;SEVERE WEATHER;CITY;121-A W MADISON ST
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E
CAD:A5,R45;INJURED IN FALL;4000;E VINE ST/S WASHINGTON ST;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall
CAD:A5,R45;UNKNOWN MEDICAL PROBLEM;4004;3421 N SR 19;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient with an unknown problem
CAD:A5,R45;INJURED IN FALL;4002;304 E 625 N;hx of dementia [10/06/10 18:51:56 DARCIR] [Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E
Notes: 4 digit number between description and address should be ignored

**********************************************************
Henry County, VA
reporting email: Lieutenant Pruitt <rdvrs602@ridgewayrescue.com>
sender:  *@ridgewayrescue.com

(CAD Call) 2010094339
R2-(1) DIFFICULTY BREATHING
 999 MORGAN FORD RD RIDGEWAY
 
(CAD Call) 2010094406
RFA-(3) FALL / FRACTURE
247 DEVONSHIRE DR RIDGEWAY
ALTERED MENTAL STATUS

(CAD Call) 2010094372
1 LEE FORD CAMP RD RIDGEWAY
@ 220 - TK & SUV

(CAD Call) 2010094604
RSI-(2) SICK UNKNOWN MEDICAL
 89 DAYLIGHT DR RIDGEWAY
 
(CAD Call) 2010095255
MOTOR VEHICLE CRASH
HENRY COUNTY PLYWOOD CO. 1580 PHOSPHO SPRINGS RD RIDGEWAY

(CAD Call) 2010095057
RSI-(2) SICK UNKNOWN MEDICAL
129 KIRK ST 4 MARTINSVILLE

(CAD Call) 2010095041
MOTOR VEHICLE CRASH
3 MARHILL DR RIDGEWAY

(CAD Call) 2010095011
R2-(1) DIFFICULTY BREATHING
999 MORGAN FORD RD RIDGEWAY

**********************************************************
Longview, TX
Contact: william freer <bfreer67@gmail.com>
Sender: cems@championems.com
Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102
FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P
RC:Run# 30209/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/1102
FRANCIS///EASTON/18:21/////<Unknown>/bp issues-- dizzy spells--
RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR
EVENT/ TATUM/Tatum vs Harmony////
(CAD - part 1 of 1) RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B
FORREST ACRES///TATUM/22:18/////<Unknown>/////
(CAD - part 1 of 1) RC:Run# 29764/*Non Life Emergency P/1/Overdose /
Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts:
32/CARTHAGE/17:23/////<Unknown>/////

**********************************************************
Andover Fire, Anoka county, Minnesota
Contact: Matt K <mattkohout@gmail.com>
Sender: cad.cad@co.anoka.mn.us
INC: field is an incident number
CAD MSG: *D A3   57       HANSON BLVD NW / ANDOVER BLVD NW  NE CORNER..SMOKE/CHARRED GRASS...SM FLAMES INC:10019729   [42]
CAD MSG: *D A3   39F      17844 XEON ST NW  FIRE ALARM... SMOKE OR HEAT UPSTAIRS OR IN GARAGE... SMALL DOG ONSITE INC:10019638  
CAD MSG: *D A3   45F      14950 HANSON BLVD NW @ANDOVER ELEMENTARY  PLANNED FIRE DRILL AT 1330 ... WILL CALL BACK WHEN COMPLETE INC:10019627   
CAD MSG: *D A3   57       A FIRE DEPT 3 @15929 CROSSTOWN BLVD NW  ** ILLEGAL BURN * IN MILLER WOODS THE NEW DEVELOPMENT INC:10019583   
CAD MSG: *D A3   32R      YMCA @15200 HANSON BLVD NW  ** SKATEBOARD PARK * 7 YO FE * FELL FRM A ACTIVITY BARS * DID LOOSE CONC IS CONC NOW * DIFF BREATHING AMB   
CAD MSG: *D A1   59       RR TRACKS / BUNKER LAKE BLVD NW  PD ACCIDENT/BLOCKING/NEED SGT TO RESPOND ALSO / FIRE RTN FOR WASH DOWN INC:10019310  
CAD MSG: *D A2   56       CO7 NW / CO58 NW  STRONG GAS ODOR IN THE AREA INC:10019278  
CAD MSG: *D A1   51       14015 DRAKE ST NW  POSS FIRE IN THE WALL...LOTS OF SMOKE FROM THE BASEMENT...EVERYONE ISOUT INC:10019127  

**********************************************************
Smyrna, GA
Contact: "Dustin Davey" <ddavey@ci.smyrna.ga.us>
Sender: cad@ci.smyrna.ga.us
CAD:FYI: ;STRUCTURE FIRE;2501 WOODLANDS DR SE;FLAMES INSIDE FUSE BOX INSIDE CALLERS APARTMENT. SMELLS WIRES BURNING. [08/08/10 22:53:28 DTHACKER];103157
CAD:Update: ;VEHICLE FIRE;S COBB DR SE/BOURNE DR SE;METRO PCS;OWNER OF VEH CALLED --- ADV ON 280 AT WH [10/11/10 17:46:52 ABERRY] blk dodge charger on fire [10/
CAD:FYI: ;VEHICLE FIRE;WINDY HILL RD SE/S COBB DR SE;METRO PCS;blk dodge charger on fire [10/11/10 17:46:16 DSNIVELY] ;104107
CAD:Update: ;STRUCTURE FIRE;501 WALTON WAY SE;S COBB DR SE;apt 501 [09/23/10 15:17:59 MBAGNATO] ;103832
CAD:FYI: ;FIRE GENERAL;4586-W VALLEY PKWY SE;S COBB DR SE;ASHLEY;heavy smoke [10/09/10 03:49:27 SMAHAMA] smoke coming from the unit below her [10/09/10 03:48:51

**********************************************************
Northglenn and Comerce City (Adams County), CO
contact: Brad Jones <brad@jones.name>
sender: dispatch@northglennambulance.com
- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/
- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/
- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/
- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/
- part 1 of 1
RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/

**********************************************************
Unknown from problem report
Contact: James Mayhew <kc4bpx@gmail.com>
Sender: e911@ps400.hanoverva.org <From%3Ae911@ps400.hanoverva.org>
Subject:(21777) a
Unit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295
MapRef:R Map 1591 VEH VS DEER, NO INJS, H

**********************************************************
Unknown from problem report, was trying Suffolk County
contact: "shiloe1@yahoo.com" <shiloe1@yahoo.com>
sender: news@1rwn.com
WANTAGH, NY (NASSAU) *M/C MVA* JERUSALEM AVE & DAFFODIL LN. WFD CHF 6900 RPTS M/C VS CAR. E692 O/S. A6918 TO TX AIDED. NY64

**********************************************************
Unknown from problem report
contact: Jason Baalman <jason.baalman@gmail.com>
sender: riprun@westamptonfire.org <From%3Ariprun@westamptonfire.org>
14:27:34
EMS E EMS Call
3400
22 WOODHURST DR
LAURELWOOD LA/LAURELWOOD LA
PREGNANT F/ STOMACH PAIN
**************************************************************************/
}
