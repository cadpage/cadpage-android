//Sender: rc.263@c-msg.net
package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDCharlesCountyAParser extends SmartAddressParser {
  
  private static final Pattern ID_PATTERN = Pattern.compile("(\\b[EF]\\d{9}(?: +\\d+))\\b");
  private static final Pattern MAP_PATTERN = Pattern.compile("\\b\\d{1,2} ?[A-Z]\\d{1,2}(?:-\\d?[A-Z]\\d{1,2})?\\b");
  private static final Pattern COUNTY_PATTERN = Pattern.compile("\\b[A-Z]{2,3} COUNTY\\b");
  private static final Pattern UNIT_PATTERN = Pattern.compile("(?:(?:\\b\\d{1,2}[A-D])\\b,? *)+");
  private static final Pattern DIR_OF_FIX_PATTERN = Pattern.compile("\\b([NSEW]) & O\\b");
  
  @Override
  public String getFilter() {
    return "@c-msg.net,dispatch@ccso.us,@sms.mdfiretech.com";
  }


  public MDCharlesCountyAParser() {
    super( "CHARLES COUNTY", "MD");
    setFieldList("CALL CITY UNIT ADDR APT PLACE CODE MAP INFO ID TIME");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Kick out any wayward version B messages that wander this way
    if (body.contains("\nmdft.us/")) return false;
    
    Matcher match = ID_PATTERN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1).replace(' ', '-');
      data.strTime = body.substring(match.end()).trim();
      body = body.substring(0,match.start()).trim();
    }
    
    // There is almost always a code pattern (or whatever it really is)
    // marking the end of the address
    match = MAP_PATTERN.matcher(body);
    if (!match.find()) return false;
    data.strMap = match.group();
    data.strSupp = body.substring(match.end()).trim();
    body = body.substring(0,match.start()).trim();
    
    String cancel = "";
    if (body.startsWith("Cancel Reason:")) {
      int pt = body.indexOf('\n');
      if (pt < 0) return false;
      cancel = body.substring(0,pt).trim();
      body = body.substring(pt+1).trim();
    }
    
    // Life gets easier if we can find a leading call description
    String call = CALL_LIST.getCode(body);
    if (call != null) {
      data.strCall = call;
      body = body.substring(call.length()).trim();
      body = stripFieldStart(body, ",");
    }
    
    // See if there is a mutual aid county following the call
    match = COUNTY_PATTERN.matcher(body);
    if (data.strCall.length() > 0 ? match.lookingAt() : match.find()) {
      call = body.substring(0,match.start());
      if (!call.contains(",")) {
        if (data.strCall.length() == 0) data.strCall = stripFieldEnd(call.trim(), ",");
        data.strCity = convertCodes(match.group(), COUNTY_TABLE);
        body = body.substring(match.end()).trim();
        body = stripFieldStart(body, ",");
      }
    }
    
    // See if we can find a unit field following the call description
    // This is only found for older calls
    match = UNIT_PATTERN.matcher(body);
    if (data.strCall.length() > 0 ? match.lookingAt() : match.find()) {
      if (data.strCall.length() == 0) data.strCall = stripFieldEnd(body.substring(0,match.start()).trim(), ",");
      data.strUnit = stripFieldEnd(match.group().trim(), ",");
      body = body.substring(match.end());
      body = stripFieldStart(body, ",");
    }
    
    // Anything following a trailing comma is a (probably) place name
    int flags = FLAG_NO_IMPLIED_APT;
    StartType st = StartType.START_ADDR;
    
    if (data.strCall.length() == 0)   {
      st = StartType.START_CALL;
      flags |= FLAG_START_FLD_REQ;
    }
    
    // See what we find in what is left
    parseAddress(st, flags, body, data);
    String left = getLeft();
    if (left.length() > 0) {
      int pt = left.indexOf(',');
      if (pt >= 0) {
        data.strAddress = append(data.strAddress, " ", left.substring(0,pt).trim());
        data.strPlace = left.substring(pt+1).trim();
      }
      else if (left.startsWith("/")) {
        data.strAddress = append(data.strAddress, " & ", left.substring(1).trim());
      } 
      else {
        data.strPlace = left;
      }
    }
    
    data.strAddress = DIR_OF_FIX_PATTERN.matcher(data.strAddress).replaceAll("$1/O");
    
    data.strCall = stripFieldEnd(data.strCall, ",");
    data.strCall = append(cancel, " - ", data.strCall);
    
    // If the place name we found looks like an apt number, move it
    if (data.strPlace.toUpperCase().startsWith("APT ")) {
      data.strApt = data.strPlace.substring(4).trim();
      data.strPlace = "";
    } else if (data.strPlace.startsWith("#")) {
      data.strApt = data.strPlace;
      data.strPlace = "";
    }
    
    return true;
  }
  
  @Override
  public CodeSet getCallList() {
    return CALL_LIST;
  }

  private static final CodeSet CALL_LIST = new CodeSet(
      "AFA SF DWELLING",
      "ASSIST THE AMBULANCE",
      "BOAT AT MARINA OR MARINA FIRE",
      "BOAT DISTRESS NOT TAKING ON WATER",
      "BURN ALS",
      "BURN BLS",
      "CHEST PAINS ALS",                                                                                                        
      "CHEST PAINS BLS",                                                                                                        
      "COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG",                                                                          
      "DIABETIC ALS",                                                                                                           
      "FALL ALS",                                                                                                               
      "FALL BLS",                                                                                                               
      "GAS LEAK INSIDE SF DWELLING",                                                                                        
      "HAZMAT INVESTIGATION",                                                                                               
      "MVC ALS",
      "MVC BLS",
      "MVC MOTORCYCLE ALS",
      "MVC MOTORCYCLE BLS",
      "MVC ROLLOVER EJECTED",
      "PERSON NOT BREATHING ALS",
      "PERSON NOT BREATHING BLS",
      "SEIZURES ALS",
      "SEIZURES BLS",
      "SIT FND CALL CANCELLED NO UNIT ENROUTE",
      "STROKE ALS",
      "STROKE BLS",
      "STRUC FIRE COMMERCIAL BLDG",
      "STRUC, ODOR OF SMOKE - NO FIRE, M/F DWELLING, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING",
      "STRUC ODOR OF SMOKE SF DWELLING",
      "TRANSFER (2) ENGINES",
      "TRANSFER FIRE",
      "TROUBLE BREATHING ALS",
      "UNCONSCIOUS ALS",
      "UNCONSCIOUS BLS",
      "WIRES DOWN/ARCING PRINCE",
      "WORKING FIRE ALERT",
      
      // Old stuff
      "ASSIST THE AMBULANCE, MISC"
      
  );
  
  private static Properties COUNTY_TABLE = buildCodeTable(new String[]{
      "CAL COUNTY", "CALVERT COUNTY",
      "KG COUNTY",  "KING GEORGE COUNTY/VA",
      "PG COUNTY",  "PRINCE GEORGES COUNTY",
      "SM COUNTY",  "ST MARYS COUNTY"
  }); 
}