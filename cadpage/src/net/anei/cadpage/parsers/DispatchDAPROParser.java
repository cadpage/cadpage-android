package net.anei.cadpage.parsers;

import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
/*
DAPRO Systems http://www.daprosystems.com/
Currently used by Rockingham, VA and Franklin, VA

*/

public class DispatchDAPROParser extends SmartAddressParser {
  
	  private String defCity;
	  private String defState;
	
  public void setDefaults(String defCity, String defState) {
		    this.defCity = defCity;
		    this.defState = defState;
		  }
  
  private static final String[] KEYWORDS = new String[]{"LOC", "CFS", "CROSS"};
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
    	"RMT", "Rocky Mount",
    	"BML", "Boones Mill",
    	"CAL", "Calaway",
        "BRO", "BROADWAY",
        "BRI", "BRIDGEWATER",
        "HAR", "HARRISONBURG",
        "SIN", "SINGERS GLEN",
        "CLO", "CLOVER HILL",
        "HIN", "HINTON",
        "MOU", "MOUNT CRAWFORD",
        "TIM", "TIMBERVILLE",
        "DAY", "DAYTON",
        "GRO", "GROTTOES",
        "MCG", "MCGAHEYSVILLE",
        "PEN", "PENN LAIRD",
        "ELK", "ELKTON",
        "WEY", "WEYERS CAVE",
        "NEW", "NEW MARKET",
        "STA", "STANLEY",
        "LUR", "LURAY",
        "SHE", "SHENANDOAH"
    });
  
  private static final Pattern MARKER = Pattern.compile("\\b[SRC]\\d\\d\\b");
  
  public DispatchDAPROParser() {
    super(CITY_CODE_TABLE);
    buildCallDictionary();
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
	   data.defState=defState;
	   data.defCity=defCity;
    
    // Locate the marker to determine where our part of the message starts
    Matcher match = MARKER.matcher(body);
    if (! match.find()) return false;
    body = body.substring(match.end()).trim();
    
    // Adjust it a bit and parse out the main fields
    body = "LOC:" + body.replaceAll(" CFS#", " CFS:");
    Properties props = parseMessage(body, KEYWORDS);
    
    // Lets do the easy ones first
    data.strCallId = props.getProperty("CFS", "");
    data.strCross = props.getProperty("CROSS", "");
    
    // OK, now to work out the address field
    // Google doesn't handle the "BLK" qualifier so get rid of it
    String sAddress = props.getProperty("LOC");
    sAddress = sAddress.replaceAll(" BLK ", " ");
    
    // See if we can identify a call description from our canned list
    String callDesc = getCallDesc(sAddress);
    if (callDesc != null) {
      
      // We got one, the call description comes off the front
      data.strCall = callDesc;
      sAddress = sAddress.substring(callDesc.length()).trim();
      
      // And the last word is the city
      int pt = sAddress.lastIndexOf(' ');
      if (pt >= 0) {
        data.strCity = sAddress.substring(pt+1);
        sAddress = sAddress.substring(0, pt).trim();
      }
      
      // Anything else an an address
      parseAddress(sAddress, data);
      
      // No call description match eh
      // We'll have to rely on the smart parser to save us
    } else {
      parseAddress(StartType.START_CALL, sAddress, data);
    }
    
    // Either way, we need to convert the city code
    data.strCity = convertCodes(data.strCity, CITY_CODE_TABLE);
    
    return true;
  }
  
  // This is a list of all of the expected call descriptions indexed by the first
  // word in each description
  private static TreeSet<String> callDictionary = new TreeSet<String>();
  
  /**
   * Build call description dictionary
   */
  private void buildCallDictionary() {
    
    // Loop through all call descriptions
    for (String call : new String[]{
        "EMS-OTHER",
        "EMS-OTHER/DEFINE",
        "EMS-ABDOMINAL PAIN",
        "EMS-ALLERGIC REACTION",
        "EMS-ALS ASSIST",
        "EMS-ALTERED LOC",
        "EMS-AMPUTATION",
        "EMS-ASSAULT; INJURIES FROM",
        "EMS-AVULSION",
        "EMS-BACK PAIN",
        "EMS-ANIMAL BITE",
        "EMS-BURNS",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-CHOKING",
        "EMS-CO INHALATION",
        "EMS-CODE BLUE",
        "EMS-DIABETIC EMERGENCY",
        "EMS-DIFFICULTY BREATHING",
        "EMS-PERSON DOWN",
        "EMS-ELECTROCUTION",
        "EMS-EYE PROBLEM",
        "EMS-FALLS",
        "EMS-GUNSHOT",
        "EMS-HEADACHE",
        "EMS-HEAT/COLD EXPOSURE",
        "EMS-HEMORRHAGING",
        "EMS-ILLNESS",
        "EMS-LACERATION",
        "EMS-MENTAL PROBLEM",
        "EMS-OB RELATED EVENT",
        "EMS-OVERDOSE/POISONING",
        "EMS-SEIZURES",
        "EMS-STAB WOUND",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "EMS-UNCONSCIOUS",
        "EMS-UNKNOWN MADICAL",
        "911 OPEN LINE",
        "AUTOMATIC FIRE ALARM",
        "AIRCRAFT INCIDENT",
        "MEDICAL ALARM",
        "ALARM SOUNDING",
        "ATTEMPTED SUICIDE",
        "BOMB THREAT",
        "BRUSH FIRE",
        "BRUSH FIRE THREATENING A STRUC",
        "CHIMNEY FIRE",
        "CO DETECTOR ACTIVATION",
        "POSSIBLE CO EVENT",
        "STRUCTURE COLLAPSE",
        "CONSTRUCTION ACCIDENT",
        "CONTROLLED BURN",
        "TRAFFIC CRASH",
        "TRAFFIC CRASH INVOLVING A BUS",
        "TRAFFIC CRASH W/PEDESTRIAN",
        "TRAFFIC CRASH INVOLVING A STRU",
        "DUMPSTER FIRE",
        "ELEVATOR ENTRAPMENT",
        "EXPLOSION",
        "FARM ACCIDENT",
        "FILL QUARTERS",
        "FORREST FIRE",
        "GRASS FIRE",
        "GRASS FIRE THREATENING A STRUC",
        "HAZMAT INCIDENT",
        "HAZMAT LEVEL 3 INCIDENT",
        "HOSTAGE/BARRICADE",
        "INDUSTRIAL ACCIDENT",
        "LANDING ZONE",
        "LINES DOWN",
        "LOCK OUT SERVICE",
        "MENTAL CASE",
        "MULCH FIRE",
        "MULCH FIRE THREATENING A STRUC",
        "ODOR INVESTIGATION",
        "ODOR INVESTIGATION IN STRUCTUR",
        "OFFICER INVOLVED SHOOTING",
        "SUSPICIOUS PACKAGE",
        "PUBLIC SERVICE CALL",
        "RAPE",
        "REKINDLE",
        "GROUND RESCUE",
        "GROUND SEARCH",
        "SMOKE INVESTIGATION",
        "LARGE SPILL",
        "SMALL SPILL",
        "STAND-BY",
        "POSSIBLE STRUCTURE FIRE",
        "STRUCTURE FIRE",
        "SUICIDE",
        "TECHNICAL RESCUE",
        "TRAIN CRASH",
        "TRAIN FIRE",
        "TRANSFORMER FIRE",
        "TRASH FIRE",
        "TREE FIRE",
        "TREE FIRE THREATENING A STRUCTUR",
        "UNAUTHORIZED BURN",
        "UNKNOWN SITUATION",
        "UNKNOWN FIRE",
        "VEHICLE FIRE",
        "VEHICLE FIRE THREATENING A STRUCTURE",
        "WATER EVENT",
        "WATER REMOVAL"
    }) callDictionary.add(call);
  }
  
  private String getCallDesc(String body) {
    
    // This is so clever, just search the call dictionary sorted set
    // for the entry less than or equal to the message body
    // If android supported the floor() function this would have been
    // perfect.  As it is, it will fail if the body consists of the call
    // description and nothing else.  Which really isn't realistic
    SortedSet<String> head =  callDictionary.headSet(body);
    if (head.isEmpty()) return null;
    String call = head.last();
    if (body.startsWith(call)) return call;
    return null;
  }
}
