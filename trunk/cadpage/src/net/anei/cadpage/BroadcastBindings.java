package net.anei.cadpage;

/**
 * Class defining permissions and bindings keys for used to broadcast 
 * information about an incoming CAD page to any listening 3rd part applications
 */
public class BroadcastBindings {
  
  public static final String PREFIX = "net.anei.cadpage.";
  
  // Apps must be granted this permission to receive Cadpage broadcasts
  public static final String PERMISSION =             PREFIX + "RECEIVE_CADPAGE";
  
  // Action code used to broadcast CAD page information
  public static final String ACTION =                 PREFIX + "CADPAGE_RECEIVED";

  // The rest of these are keys used to retrieve page information from the intent bundle
  // The first section describes characteristics of the actual raw message
  
  // (long) internal identification number assigned by Cadpage
  public static final String EXTRA_MSG_ID =             PREFIX + "EXTRA_MSG_ID"; 
  
  // (boolean) True if this old page information being republished 
  public static final String EXTRA_REPUBLISH =          PREFIX + "EXTRA_REPUBLISH";
  
  // (string) message sender
  public static final String EXTRA_FROM =               PREFIX + "EXTRA_FROM";
  
  // (string) message subject
  public static final String EXTRA_SUBJECT =            PREFIX + "EXTRA_SUBJECT";
  
  // (string) message text
  public static final String EXTRA_MESSAGE =            PREFIX + "EXTRA_MESSAGE";
  
  // (long) Received time as Java time
  public static final String EXTRA_TIME =               PREFIX + "EXTRA_TIME";
  
  // (string) location code This is an internal code defining which parser handled this message
  public static final String EXTRA_LOC_CODE =           PREFIX + "EXTRA_LOC_CODE";
  
  // (string) city or county associated with location parser
  public static final String EXTRA_LOC_CITY =           PREFIX + "EXTRA_LOC_CITY";
  
  // (string) state associated with location parser
  public static final String EXTRA_LOC_STATE =          PREFIX + "EXTRA_LOC_STATE";
  
  // (boolean) flag indicating Cadpage is not taking any user visible action in response
  // to an incoming CAD page
  public static final String EXTRA_QUIET_MODE =         PREFIX + "EXTRA_QUIET_MODE";
  
  // Everything else is information that has been parsed from the text message
  // These will not always be present
  
  // (string) code associated with call
  public static final String EXTRA_PARSE_CALL_CODE =    PREFIX + "EXTRA_PARSE_CALL_CODE";
  
  // (string) call description
  public static final String EXTRA_PARSE_CALL =         PREFIX + "EXTRA_PARSE_CALL";
  
  // (string) Supplemental call information
  public static final String EXTRA_PARSE_INFO =         PREFIX + "EXTRA_PARSE_INFO";
  
  // (string) common name of incident location
  public static final String EXTRA_PARSE_PLACE =        PREFIX + "EXTRA_PARSE_PLACE";
  
  // (string) incident address
  public static final String EXTRA_PARSE_ADDRESS =      PREFIX + "EXTRA_PARSE_ADDRESS";
  
  // (string) incident city or county  (only present if specified in message text)
  public static final String EXTRA_PARSE_CITY =         PREFIX + "EXTRA_PARSE_CITY";
  
  // (string) incident state (ditto)
  public static final String EXTRA_PARSE_STATE =        PREFIX + "EXTRA_PARSE_STATE";
  
  // (string) mapping address - this is the query string passed to Google Maps
  public static final String EXTRA_PARSE_MAP_ADDRESS =  PREFIX + "EXTRA_PARSE_MAP_ADDRESS";
  
  // (string) apartment/building/lot number
  public static final String EXTRA_PARSE_APT =          PREFIX + "EXTRA_PARSE_APT";
  
  // (string) cross streets
  public static final String EXTRA_PARSE_CROSS =        PREFIX + "EXTRA_PARSE_CROSS";
  
  // (string) map page or code
  public static final String EXTRA_PARSE_MAP =          PREFIX + "EXTRA_PARSE_MAP";
  
  // (string) box number
  public static final String EXTRA_PARSE_BOX =          PREFIX + "EXTRA_PARSE_BOX";
  
  // (string) responding agency code
  public static final String EXTRA_PARSE_AGENCY =       PREFIX + "EXTRA_PARSE_AGENCY";
  
  // (string) responding unit(s)
  public static final String EXTRA_PARSE_UNIT =         PREFIX + "EXTRA_PARSE_UNIT";
  
  // (string) call identification number assigned by dispatch
  public static final String EXTRA_PARSE_CALL_ID =      PREFIX + "EXTRA_PARSE_CALL_ID";
  
  // (string caller name
  public static final String EXTRA_PARSE_NAME =         PREFIX + "EXTRA_PARSE_NAME";
  
  // (string) caller phone number
  public static final String EXTRA_PARSE_PHONE =        PREFIX + "EXTRA_PARSE_PHONE";
  
  // (string) call priority
  public static final String EXTRA_PARSE_PRIORITY =     PREFIX + "EXTRA_PARSE_PRIORITY";
  
  // (string) radio channel
  public static final String EXTRA_PARSE_CHANNEL =      PREFIX + "EXTRA_PARSE_CHANNEL";
  
  // (string) GPS location
  public static final String EXTRA_PARSE_GPSLOC =       PREFIX + "EXTRA_GPS_LOC";
  
  // (String) Dispatch date 
  public static final String EXTRA_PARSE_DISP_DATE =    PREFIX + "EXTRA_DISP_DATE";
  
  // (String) Dispatch time
  public static final String EXTRA_PARSE_DISP_TIME =    PREFIX + "EXTRA_DISP_TIME";
  
  // (String) URL for additional Info
  public static final String EXTRA_PARSE_INFO_URL =     PREFIX + "EXTRA_INFO_URL";
  

}
