package net.anei.cadpage.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralParser extends SmartAddressParser {
  
  private static final Pattern DELIM_PATTERN = Pattern.compile(";|,|\\*|\\n|\\b[A-Z][A-Za-z0-9-#]*:|\\bC/S:|\\b[A-Z][A-Za-z]*#");
  private static final Pattern CALL_ID_PATTERN = Pattern.compile("\\d[\\d-]+\\d");
  private static final Pattern UNIT_PATTERN = Pattern.compile("([A-Z]+[0-9]+\\s+)+");
  
  // Field types that we can identify 
  private enum FieldType {SKIP, CALL, PLACE, ADDRESS, CITY, APT, CROSS, BOX, UNIT, MAP, ID, PHONE, SUPP, CODE, SRC};
  
  // Map of keywords to field types
  private Map<String, FieldType> keywordMap = new HashMap<String, FieldType>();
  
  public GeneralParser() {
    super("","");
    
    // Initialize keyword map
    loadMap(FieldType.SKIP, "TIME", "TOA", "DATE", "TM");
    loadMap(FieldType.CALL, "CALL", "TYPE", "TYP", "CT", "NAT", "NATURE", "INC");
    loadMap(FieldType.PLACE, "NAME", "COMMON", "CN", "O");
    loadMap(FieldType.ADDRESS, "ADDRESS", "LOC", "ADDR", "AD", "ADR", "ADD", "LOCATION");
    loadMap(FieldType.CITY, "CITY", "CTY", "VENUE", "VEN");
    loadMap(FieldType.APT, "APT");
    loadMap(FieldType.CROSS, "CROSS", "X", "XS", "XST", "XST2", "X-ST", "C/S", "CS", "BTWN");
    loadMap(FieldType.BOX, "BOX", "BX", "ADC");
    loadMap(FieldType.UNIT, "UNIT", "UNITS", "RESPONSE", "DUE", "UNTS", "UNT");
    loadMap(FieldType.MAP, "MAP", "GRID", "GRIDS", "QUADRANT", "QUAD");
    loadMap(FieldType.ID, "ID", "CFS", "RUN", "EVT#");
    loadMap(FieldType.PHONE, "PHONE", "PH");
    loadMap(FieldType.SUPP, "INFO", "CMT", "CMT1", "CMT2", "SCRIPT", "COMMENTS", "RMK");
    loadMap(FieldType.SRC, "STA", "ST", "DISP", "DIS", "DIST", "DISTRICT", "AGENCY");
  }
  
  private void loadMap(FieldType type, String ... keywords) {
    for (String keyword : keywords) {
      keywordMap.put(keyword, type);
    }
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Accept anything, but only if there is a valid sender filter
    if (ManagePreferences.filter().length() <= 1) return false;
    
    // Starting with CAD: confuses things
    if (body.startsWith("CAD:")) body = body.substring(4).trim();

    // Parse text into different fields separated by delimiters
    // that match DELIM_PATTERN
    Matcher match = DELIM_PATTERN.matcher(body);
    String nextDelim = "";
    int pt = 0;

    String last = null;

    while (nextDelim != null) {
      
      // Parse the next field
      String delim = nextDelim;
      String fld;
      if (match.find(pt)) {
        nextDelim = body.substring(match.start(), match.end());
        fld = body.substring(pt, match.start());
        pt = match.end();
      } else {
        nextDelim = null;
        fld = body.substring(pt);
      }
      fld = fld.trim();
      
      // fld is the data field being processed
      // delim is the delimiter that started this field
      
      // If zero length field, nothing to worry about
      if (fld.length() == 0) continue;
      
      // Check delimiter to see if this is something we recognize?
      FieldType type = null;
      if (delim.endsWith(":")) {
        type = keywordMap.get(delim.substring(0, delim.length()-1).toUpperCase());
      } else if (delim.endsWith("#")) {
        type = FieldType.ID;
      }
      
      // If we have found a recognizable keyword, assign this field to that keyword value
      if (type != null) {
        
        switch (type) {
        
        case SKIP:
          break;
          
        case CALL:
          if (fld.length() > 2) data.strCall = fld;
          break;
          
        case PLACE:
          data.strPlace = fld;
          break;
          
        case ADDRESS:
          StartType st = (data.strCall.length() == 0 ? StartType.START_CALL :
                          data.strPlace.length() == 0 ? StartType.START_PLACE : StartType.START_SKIP);
          parseAddress(st, fld, data);
          data.strSupp = getLeft();
          
          // If we have some leading call info, use it.  If not, 
          // treat the last unidentified field as the call
          if (data.strCall.length() == 0 && last != null) data.strCall = last;

          break;
          
        case CITY:
          data.strCity = fld;
          break;
          
        case APT:
          data.strApt = fld;
          break;
          
        case CROSS:
          if (data.strCross.length() > 0) data.strCross += " & ";
          data.strCross += fld;
          break;
          
        case BOX:
          data.strBox = fld;
          break;
          
        case UNIT:
          data.strUnit = fld;
          break;
          
        case MAP:
          data.strMap = fld;
          break;
          
        case ID:
          data.strCallId = fld;
          break;
          
        case PHONE:
          data.strPhone = fld;
          break;
          
        case SUPP:
          if (data.strSupp.length() > 0) data.strSupp += " / ";
          data.strSupp += fld;
          break;
          
        case CODE:
          data.strCode = fld;
          break;
          
        case SRC:
          data.strSource = fld;
          break;
          
        }
      }

      // Otherwise we have to try to figure out fields by position
      else {
        
        // If we haven't found an address yet, see if this is it
        if (data.strAddress.length() == 0) {
          StartType st = (data.strCall.length() == 0 ? StartType.START_CALL :
                          data.strPlace.length() == 0 ? StartType.START_PLACE : StartType.START_SKIP);
          parseAddress(st, fld, data);
          if (getStatus() > 0) {
            // Bingo!  Anything past the address goes into info
            data.strSupp = getLeft();
            
            // If we have some leading call info, use it.  If not, 
            // treat the last unidentified field as the call
            if (data.strCall.length() == 0 && last != null) data.strCall = last;
            continue;
          }
          
          // No go, Reset any field that might been set by our miscalculation
          data.strCall = data.strAddress = "";
        }
        
        // Does this look like a call ID?
        if (data.strCallId.length() == 0 && CALL_ID_PATTERN.matcher(fld).matches()) {
          data.strCallId = fld;
          continue;
        }
        
        // Nope, lets see if it looks like a unit list
        if (data.strUnit.length() == 0 && UNIT_PATTERN.matcher(fld + " ").matches()) {
          data.strUnit = fld;
          continue;
        }
        
        // None of the above
        // If we haven't found an address yet, save this field for use as a possible
        // call field when we find the address. 
        if (data.strAddress.length() == 0) {
          last = fld;
          continue;
        }
        
        // If field has an &, assume it is a set of cross streets
        if (data.strCross.length() == 0 && fld.contains("&")) {
          data.strCross = fld;
          continue;
        }
        
        // If field parse out as an complete address
        // Assume it is a cross street
        if (checkAddress(fld) > 0) {
          if (data.strCross.length() > 0) data.strCross += " & ";
          data.strCross += fld;
          continue;
        }
        
        // If we have found an address but have no call description, assume this is it
        if (data.strCall.length() == 0) {
          data.strCall = fld;
          continue;
        }
        
        // Otherwise bundle this into supplemental info
        StringBuilder sb = new StringBuilder(data.strSupp);
        if (sb.length() > 0 && delim.length()>0 && ",;\n".indexOf(delim.charAt(0))<0) sb.append(' ');
        if (sb.length() > 0 || 
            delim.length() > 0 && Character.isUpperCase(delim.charAt(0))) sb.append(delim);
        if (sb.length() > 0) sb.append(' ');
        sb.append(fld);
        data.strSupp = sb.toString();
      }
    }
    
    return data.strAddress.length() > 0;
  }
}
