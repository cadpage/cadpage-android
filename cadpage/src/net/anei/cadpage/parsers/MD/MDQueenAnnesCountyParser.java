package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDQueenAnnesCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:(?:qac911|QA911com):\\*)?[DG] ");
  private static final Pattern UNIT_PTN = Pattern.compile(" +([A-Z]{1,2}\\d{2})$");
  private static final Pattern BOX_PTN = Pattern.compile("(\\d{1,2}-\\d{1,2}) (.*?)((?: +(?:COMMERCIAL|MEDICAL|STILL|WATER RESCUE|RESCUE))?(?: +LOCAL)?)(?: +BOX)?");
  private static final Pattern PAREN_PTN = Pattern.compile(" *\\((.*?)\\) *");
  private static final Pattern MA_CALL_PTN = Pattern.compile("([A-Z]{4}) +MUTUAL AID\\b.*");
  
  public MDQueenAnnesCountyParser() {
    super("QUEEN ANNES COUNTY", "MD");
    setFieldList("BOX CALL CITY ADDR APT PLACE INFO UNIT");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BAY BRIDGE",
        "BENNETT POINT",
        "CASTLE MARINA",
        "CHANNEL MARKER",
        "CHESTER RIVER",
        "CHESTER STATION",
        "CHESTERVILLE BRIDGE",
        "CHURCH HILL",
        "COX NECK",
        "COX SAWMILL",
        "CRAB ALLEY",
        "DOUBLE CREEK POINT",
        "DULIN CLARK",
        "GRASONVILLE CEMETERY",
        "HICKORY RIDGE",
        "HOUGHTON HOUSE",
        "KENT NARROWS",
        "KING STORE",
        "LITTLE KIDWELL",
        "LOG CANOE",
        "LOVE POINT",
        "MACUM CREEK",
        "MARION QUIMBY",
        "MONROE MANOR",
        "OLD LOVE POINT",
        "OUTLET CENTER",
        "OYSTER COVE",
        "PERRYS CORNER",
        "PINEY NARROWS",
        "PRICE STATION",
        "QUEEN ANNE",
        "QUEEN NEVA",
        "ROLLING BRIDGE",
        "SCHOOL HOUSE",
        "SAYERS FOREST",
        "THOMPSON CREEK",
        "WEB FOOT",
        "WELLS COVE",
        "WINDSWEPT FARM",
        "WHITE HOUSE",
        "WYE HARBOR",
        "WYE MILLS"
    );
  }
  
  @Override
  public String getFilter() {
    return "qac911@qac.org,QA911com@qac.org,@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    Matcher match = MARKER.matcher(body);
    if (match.find()) body = body.substring(match.end());
    
    // Strip UNIT from end of text
    match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group(1);
      body = body.substring(0, match.start()).trim();
    } 
    
    // Strip box number from front of message and box description from end
    match = BOX_PTN.matcher(body);
    if (match.matches()) {
      data.strBox = append(match.group(3).trim(), " ", match.group(1));
      body = match.group(2).trim();
    }
    
    // Sometimes they put valid street names in parenthesis, which messes up
    // the address detection logic.
    match = PAREN_PTN.matcher(body);
    if (match.find() && checkAddress(match.group(1)) > 0) {
      body = body.substring(0,match.start()) + ' ' + match.group(1) + ' ' + body.substring(match.end());
      body = body.trim();
    }
    
    // For several reasons,the FLAG_AT_BOTH logic doesn't quit work, so we
    // will have to check for an @ and do the had work ourselves
    int pt = body.indexOf('@');
    if (pt < 0) {
      
      // No @ - Address parser can handle the rest
      parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ, body, data);
      data.strSupp = getLeft();
    } 
    
    else {
      
      // There is an @ - Split message body by the first @ and try to parser
      // both sides as an address
      String part1 = body.substring(0,pt).trim();
      String part2 = body.substring(pt+1).trim();
      Result res1 = parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, part1);
      Result res2 = parseAddress(StartType.START_ADDR, part2);
      if (res2.getExtStatus() > res1.getExtStatus()) {
        
        // Second part is the address
        // Split first part into call and place name
        res2.getData(data);
        data.strSupp = res2.getLeft();
        String call = CALL_LIST.getCode(part1, true);
        if (call == null) {
          data.strCall = part1;
        } else {
          data.strCall = call;
          data.strPlace = part1.substring(call.length()).trim();
        }
      }
      
      else {
        
        // First part is address
        // Entire second part is place name
        res1.getData(data);
        if (data.strAddress.length() == 0) data.strAddress = data.strPlace;
        data.strPlace = part2;
      }
    }
    
    // See if this is a mutual aid call that we can extract a city name from
    match = MA_CALL_PTN.matcher(data.strCall);
    if (match.matches()) {
      String city = MA_CITY_TABLE.getProperty(match.group(1));
      if (city != null) data.strCity = city;
    }
    
    // If not address was found, move place to info
    if (data.strAddress.length() == 0 && data.strSupp.length() == 0) {
      data.strSupp = data.strPlace;
      data.strPlace = "";
    }

    // Box is required, unless this was a mutual aid call
    return (data.strBox.length() > 0 || data.strCall.contains("MUTUAL AID"));
  }
  
  private static CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAINS",
      "ALLERGIC/REACTION",
      "ASSAULT",
      "BREATHING PROBLEMS",
      "CARDIAC ARREST",
      "CHEST PAINS",
      "CHIMNEY FIRE",
      "CHIMNEY FIRE",
      "CHOKING",
      "CITIZEN ASSIST",
      "CO ALARM",
      "COMMERCIAL BLDG FIRE",
      "COMMERCIAL VEH FIRE",
      "DIABETIC PROBLEMS",
      "DROWNING/DIVE ACCDNT",
      "DWELLING FIRE",
      "ELECTRICAL HAZARD",
      "ELEVATOR MALFUNCTION",
      "FAINTING",
      "FALLS",
      "FIRE ALARM",
      "FIRE TEST",
      "FIRE UNIT TRANSFER",
      "GENERAL FIRE ALARM",
      "HAZMAT",                                                                                                                                                                                                                                                
      "HAZMAT/SMALL SPILL",
      "HEADACHE",
      "HEART PROBLEMS",                                                                                                                                                                                                                                        
      "HEMORRHAGE/LACS",
      "INTENTIONAL OVERDOSE",
      "LG BRUSH/GRASS FIRE",
      "LOCK OUT OF VEHICLE",
      "LOCK OUT",
      "MLTPL DWELLING FIRE",
      "MVC INVOLVING A BUS",
      "MVC UNKNOWN INJURIES",
      "MVC W/ENTRAPMENT",
      "MVC W/INJURIES",
      "MVC W/ROLLOVER",
      "NEAR FAINTING",                                                                                                                                                                                                                                         
      "ODOR OF GAS INSIDE",
      "ODOR OF SMOKE INSIDE",
      "OUTSIDE FIRE",
      "OUTSIDE GAS LEAK",
      "PENETRATING TRAUMA",
      "PSYCHIATRIC",
      "PSYCHIATRIC/SUICIDE",
      "SEIZURES",
      "SERVICE CALL",
      "SICK PERSON",
      "SMALL OUTSIDE FIRE",
      "SMOKE DETECTOR",
      "SMOKE INVESTIGATION",
      "TRAILER FIRE",
      "TRAUMATIC INJURY",
      "UNCONSCIOUS",                                                                                                                                                                                                                                           
      "UNCONSCIOUS/FAINTING",
      "UNKNOWN PROBLEM",
      "VEH FIRE W/EXPOSURE",
      "WATER RESCUE",
      "WILDLAND FIRE DAVIDSON",                                                                                                                                                                                                                                
      "WIRES DOWN",
      
      "AACO MUTUAL AID",
      "KENT MUTUAL AID",
      "KENT MUTUAL AID MEDICAL",
      "KM06 MUTUAL AID MEDICAL",
      "MUTUAL AID"
  );
  
  private static final Properties MA_CITY_TABLE = buildCodeTable(new String[]{
      "AACO", "ANNE ARUNDEL COUNTY",
      "KENT", "KENT",
  });
}
