package net.anei.cadpage;

import java.net.URLEncoder;
import java.util.Properties;


/**
 * This clas is responsible for parsing useful information from an SMS page message
 */
public class SmsMsgParser {

  private String strBody = "";
  private String strCall = "";
  private String strAddress = "";
  private String strCity = "";
  private String strApt = "";
  private String strCross = "";
  private String strBox= "" ;
  private String strADC= "" ;
  private String strUnit= "" ;
  private String strState="";
  private String strMap = "";
private String strTemp;
  
  /**
   * Return original message text
   */
  public String getBody() {
    return strBody;
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

  public String getFullAddress() {
    StringBuilder sb = new StringBuilder(strAddress);
    if (strCity.length() > 0) {
      sb.append(" ");
      sb.append(strCity);
    } 
    if (strState.length() > 0) {
      sb.append(" ");
      sb.append(strState);
    }
    
    String strFullAddress = URLEncoder.encode(sb.toString());
    //strFullAddress = strFullAddress + "&z=9";
    return strFullAddress;
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
   * @return the call ADC
   */
  public String getADC() {
    return strADC;
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
    String[] phrases = new String[]{"Call:", "TYPE:", "Map:", "(Corvallis Alert)","Cad:","OCSO E911:"};
    if (iLocation > phrases.length) return false;
    return (msgText.indexOf(phrases[iLocation-1]) >= 0);
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
        }

  }

  private void decodeLCFRPage(String body) {
      // Take call from SMS Message and divide data up.
      // Sample Call "Call:


        Log.v("decodeLCFRPage: Message Body of:" + body);
        strState = "VA";
        String[] AData = body.split(",");
        
        strCall = AData[0].substring(AData[0].indexOf("Call:",0)+5);
        // Need to check for single address or Intersection address.
        if (AData[1].contains("/")  ){
          // This is an intersection and not a street
           String[] strTemp = AData[1].split("/");
          strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
          strAddress = strAddress + " and " +  strTemp[1].substring(0,(strTemp[1].indexOf("-")));
          strCity = strTemp[0].substring(strTemp[0].indexOf("-")+1);
        }else {
          strAddress = AData[1].substring(0,(AData[1].indexOf("-")));
          strCity = AData[1].substring(AData[1].indexOf("-")+1,AData[1].indexOf("Apt")-1);
        }
        // Intersection address has a / and two  - cities
        if (strAddress.length() < 4) {
          strAddress = "Error Street not Found.";
        }
        if (strCity.compareTo("CH") == 0  ){ strCity="Chantilly";}
        else if (strCity.compareTo("LB")==0){ strCity="Leesburg";}
        else if (strCity.compareTo("AL")==0){ strCity="Aldie";}
        else if (strCity.compareTo("ST")==0){ strCity="Sterling";}
        else if (strCity.compareTo("MB")==0){ strCity="Middleburg";}
        else if (strCity.compareTo("AB")==0){ strCity="Ashburn";}
        else if (strCity.compareTo("SP")==0){ strCity="Sterling";}
        else if (strCity.compareTo("BL")==0){ strCity="Bluemont";}
        else if (strCity.compareTo("CE")==0){ strCity="Centreville";}
        else if (strCity.compareTo("HA")==0){ strCity="Hamilton";}
        else if (strCity.compareTo("LV")==0){ strCity="Lovettsville";}
        else if (strCity.compareTo("PA")==0){ strCity="Paris";}
        else if (strCity.compareTo("PV")==0){ strCity="Purceville";}
        else if (strCity.compareTo("PS")==0){ strCity="Paeonian";}
        else if (strCity.compareTo("RH")==0){ strCity="Round Hill";}
        else if (strCity.compareTo("UP")==0){ strCity="Upperville";}
        else if (strCity.compareTo("FX19")==0){ strCity="Fairfax";}
        else if (strCity.compareTo("FX")==0){ strCity="Fairfax";}
        else if (strCity.compareTo("FQ")==0){ strCity="Faquier";}
        else if (strCity.length() < 1){ strCity="Error";}
      
        try {
        strApt = AData[1].substring(AData[1].indexOf("Apt:"));
        strCross = AData[2].substring(5);
        strUnit = AData[3];
        strBox = AData[4].substring(4);
        strADC = AData[5].substring(4,AData[5].indexOf("["));
        } catch (Exception ex) {
          if (Log.DEBUG) Log.v("Exception in DecodePage-" + ex.toString());
        }
  }

  private void decodeSuffolkPage(String body) {
    /* Sample Suffolk Page
     * TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16
     * or  TYPE: STRUCTURE FIRE LOC: 81 NEW HAMPSHIRE AV NBAYSH  CROSS: E FORKS RD / E 3 AV CODE: 69-D-10 TIME: 16:36:48
     * 
     */
    
      Log.v("DecodeSuffolkPage: Message Body of:" + body);
      
      String[] AData = body.split(":");
      strState="NY";
      String tmpAddress = "";
      try {
      strCall = AData[1].substring(0,(AData[1].length()-4));
      // Need to check for single address or Intersection address.
      if (AData[2].contains("/")  ){
        // This is an intersection and not a street
         String[] strTemp = AData[2].split("/");
        //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
         tmpAddress = strTemp[0];
        tmpAddress = tmpAddress + " and " +  strTemp[1];
      }else {
        tmpAddress = AData[2];
      }
      if (tmpAddress.contains("BRENTW")){
       strAddress= tmpAddress.substring(0,tmpAddress.lastIndexOf("BRENTW"));
       strCity = "Brentwood";
      } else if (strAddress.contains("NBAYSH")){
       strAddress= tmpAddress.substring(0, tmpAddress.lastIndexOf("NBAYSH")); 
       strCity = "Bay Shore ";
      } else if (strAddress.contains("BAYSHO")){
         strAddress= tmpAddress.substring(0, tmpAddress.lastIndexOf("NBAYSH")); 
         strCity = "Bay Shore ";
      }
      // Intersection address has a / and two  - cities
      if (strAddress.length() < 4) {
        strAddress = "Error Street not Found.";
      }
      
    

      //strApt = AData[1].substring(AData[1].indexOf("Apt:"));
      strApt= "";
      strCross =  AData[3].substring(0,(AData[3].length()-5));
      strUnit = ""; //AData[3];
      strBox = "";//AData[4].substring(4);
      strADC = "";//AData[5].substring(4,AData[5].indexOf("["));
      } catch (Exception ex) {
        if (Log.DEBUG) Log.v("Exception in decodeSuffolk-" + ex.toString());
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
      String tmpAddress="";
      strState="TX";
     // String[] AData = body.split(":");
      String strBody = body.substring(16);
      try { 
    	  String[] AData = strBody.split(":");
      strCall = AData[3];
      // Need to check for single address or Intersection address.
      if (AData[0].contains("/")  ){
        // This is an intersection and not a street
         String[] strTemp = AData[0].split("/");
         strTemp[0] = strTemp[0].substring(2);
        //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
         tmpAddress = strTemp[0];

        tmpAddress = tmpAddress + " and " +  strTemp[1].substring(0,strTemp[1].indexOf(","));
      }else {
        tmpAddress = AData[0].substring(1,AData[0].indexOf(","));
      }
      if (! strCall.contains("MA-MUTUAL AID")){
    	  strCity = "Humble";
      } else {
    	  strCity = "";
      }
      // Intersection address has a / and two  - cities
      strAddress= tmpAddress;
      if (strAddress.length() < 4) {
        strAddress = "Error Street not Found.";
      }

      //strApt = AData[1].substring(AData[1].indexOf("Apt:"));
      strApt= "";
      strADC = AData[1].substring(0,AData[1].length()-4);//AData[5].substring(4,AData[5].indexOf("["));
      strUnit = AData[4].substring(0,(AData[4].length()-5)); //AData[3];
      strCross =  AData[5];
      strBox = "";//AData[4].substring(4);  
      } catch (IndexOutOfBoundsException ex) {
        Log.v("Exception in decodeHarris-" + ex.getMessage());
      }
  }
  

  private void decodeBentonCoPage(String body) {
      
      // Sample Benton County Page
      // (Corvallis Alert) INC: CODE 1 MEDICAL\nADD:1740 MAIN ST\nAPT:\nCITY:PHILOMATH\nX:N 17TH ST * N 18TH ST\nMAP:540-365\nCFS:0907010-119\nDIS:PHILOMATH FIRE
      
      Log.v("DecodeBentonCo: Message Body of:" + body);
      strState="OR";
      Properties props = parseMessage(body);
      
      strCall=props.getProperty("INC", "");
      strAddress=props.getProperty("ADD", "");
      strCity=props.getProperty("CITY", "");
      strApt =props.getProperty("APT", "");
      strCross=props.getProperty("X", "");
      strMap=props.getProperty("MAP", "");
      strBox="";
      strADC="";
      strUnit="";
  }

  /**
   * General purpose message parser.  Parses 
   * @param body
   * @return
   */
  private Properties parseMessage(String body) {
      Properties props = new Properties();
      String[] lines = body.split("\n");
      for (String line : lines) {
          int ndx = line.indexOf(':');
          if (ndx < 0 || ndx+1 == line.length()) continue;
          String key = line.substring(0, ndx).trim();
          String value = line.substring(ndx+1).trim();
          ndx = key.lastIndexOf(' ');
          if (ndx >= 0) key = key.substring(ndx+1);
          props.put(key, value);
      }
      return props;
  }
  
  private void decodeOconeePage(String body) {
	    /* Sample Oconee Page
	     CSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046 
OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728 
OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR
OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE
OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53
	     */
	    
	      Log.v("DecodeOconeePage: Message Body of:" + body);
	      String tmpAddress="";
	      strState="GA";
	     // String[] AData = body.split(":");
	      String strBody = body.substring(16);
	      try { 
	    	  String[] AData = strBody.split(":");
	      strCall = AData[3];
	      // Need to check for single address or Intersection address.
	      if (AData[0].contains("/")  ){
	        // This is an intersection and not a street
	         String[] strTemp = AData[0].split("/");
	         strTemp[0] = strTemp[0].substring(2);
	        //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
	         tmpAddress = strTemp[0];

	        tmpAddress = tmpAddress + " and " +  strTemp[1].substring(0,strTemp[1].indexOf(","));
	      }else {
	        tmpAddress = AData[0].substring(1,AData[0].indexOf(","));
	      }
	      if (! strCall.contains("MA-MUTUAL AID")){
	    	  strCity = "Humble";
	      } else {
	    	  strCity = "";
	      }
	      // Intersection address has a / and two  - cities
	      strAddress= tmpAddress;
	      if (strAddress.length() < 4) {
	        strAddress = "Error Street not Found.";
	      }

	      //strApt = AData[1].substring(AData[1].indexOf("Apt:"));
	      strApt= "";
	      strADC = AData[1].substring(0,AData[1].length()-4);//AData[5].substring(4,AData[5].indexOf("["));
	      strUnit = AData[4].substring(0,(AData[4].length()-5)); //AData[3];
	      strCross =  AData[5];
	      strBox = "";//AData[4].substring(4);  
	      } catch (IndexOutOfBoundsException ex) {
	        Log.v("Exception in decodeOconee-" + ex.getMessage());
	      }
  	}
  private void decodeHerkimerPage(String body) {
	    /* Sample Oconee Page
	     CSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046 
OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728 
OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR
OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE
OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53
	     */
	    
	      Log.v("DecodeHerkimerPage: Message Body of:" + body);
	      String tmpAddress="";
	      strState="NY";
	     // String[] AData = body.split(":");
	      String strBody = body.substring(16);
	      try { 
	    	  String[] AData = strBody.split(":");
	      strCall = AData[3];
	      // Need to check for single address or Intersection address.
	      if (AData[0].contains("/")  ){
	        // This is an intersection and not a street
	         String[] strTemp = AData[0].split("/");
	         strTemp[0] = strTemp[0].substring(2);
	        //strAddress = strTemp[0].substring(0,(strTemp[0].indexOf("-")));
	         tmpAddress = strTemp[0];

	        tmpAddress = tmpAddress + " and " +  strTemp[1].substring(0,strTemp[1].indexOf(","));
	      }else {
	        tmpAddress = AData[0].substring(1,AData[0].indexOf(","));
	      }
	      if (! strCall.contains("MA-MUTUAL AID")){
	    	  strCity = "Humble";
	      } else {
	    	  strCity = "";
	      }
	      // Intersection address has a / and two  - cities
	      strAddress= tmpAddress;
	      if (strAddress.length() < 4) {
	        strAddress = "Error Street not Found.";
	      }

	      //strApt = AData[1].substring(AData[1].indexOf("Apt:"));
	      strApt= "";
	      strADC = AData[1].substring(0,AData[1].length()-4);//AData[5].substring(4,AData[5].indexOf("["));
	      strUnit = AData[4].substring(0,(AData[4].length()-5)); //AData[3];
	      strCross =  AData[5];
	      strBox = "";//AData[4].substring(4);  
	      } catch (IndexOutOfBoundsException ex) {
	        Log.v("Exception in decodeHerkimer-" + ex.getMessage());
	      }
	  }
}
