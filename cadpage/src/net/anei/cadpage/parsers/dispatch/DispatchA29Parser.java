package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Starke County, IN
 */
public class DispatchA29Parser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^DISPATCH:([:A-Z\\d]+(?: FD)?) - (?:(\\d\\d?/\\d\\d?) (\\d\\d?:\\d\\d?) - )?");
  private static final Pattern DELIM = Pattern.compile("/+");
  private static final Pattern LABEL_PTN = Pattern.compile("[, ]*\\b([A-Z]+:.*)$");
  private static final Pattern DIR_OF_PTN = Pattern.compile(" (?:NO|SO|EA|WE|NORTH|SOUTH|EAST|WEST) OF ");

  public DispatchA29Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }

  public DispatchA29Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
    		  "CALLADDR1+? CALLADDR2! PLACE? SRC INFO+");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    data.strDate = getOptGroup(match.group(2));
    data.strTime = getOptGroup(match.group(3));
    body = body.substring(match.end()).trim();
    
    // Strip off some new labeled information
    match = LABEL_PTN.matcher(body);
    if (match.find()) {
      data.strSupp = match.group(1);
      body = body.substring(0,match.start());
    }

    
    body = body.replace("Apt/Unit", "Apt");
    return parseFields(DELIM.split(body, -1), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC DATE TIME " + super.getProgram() + " INFO";
  }
  
  // The address city class is complicated.  It comes in two flavors, the
  // first is an optional repeat and will not validate data fields.
  // The second always finishes thing up, and it will validate the data field
  private class MyCallAddressField extends AddressField {
    private boolean lastField;
    
    public MyCallAddressField(boolean lastField) {
      this.lastField = lastField;
    }
    
    @Override 
    public boolean canFail() {
      // only the last field processor can validate data
      return lastField;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Only the last data field can validate data, so this
      // will only be called for the last field.  For last
      // field processing, data is accepted only if it 
      // contains a comma
      if (!field.contains(",")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {

      // Split file up by commas
      String[] parts = field.split(",");

      // If this is the last field, it must contain a comma
      // hence at least two parts.  The last part is always the city
      int fldCnt =  parts.length;
      if (lastField) {
        if (fldCnt > 1) {
          String city = parts[fldCnt-1].trim();
          if (isCity(city)) {
            data.strCity = city;
            fldCnt--;
          }
        }
      }

      // Now step through the remaining parts
      for (int ndx = 0; ndx < fldCnt; ndx++) {
        String part = parts[ndx].trim();
        
        // If we have not yet found a call description, this is going to be it
        if (data.strCall.length() == 0) {
          
          // If this is the last field and there is only one part, we are going to
          // have to use the smart address parser to figure things out.
          // And it is going to need a lot of help
          if (lastField && fldCnt == 1) {
             
            // Dispatch doesn't the normal & or / interesection convention, the
            // use long NORTH OF type constucts.  To get these through the
            // smart address parser, we need to replace them all with &
            // then change them back on the other side.  To keep things
            // simple, we assume no more than one such construct per address
            String connector = null;
            if (!part.contains("&") && !part.contains("/")) {
             Matcher match = DIR_OF_PTN.matcher(part);
              if (match.find()) {
                connector = match.group();
                part = part.substring(0,match.start()) + " & " + part.substring(match.end());
              }
              int flags = FLAG_START_FLD_REQ | FLAG_ANCHOR_END;
              if (data.strCity.length() > 0) flags |= FLAG_NO_CITY; 
              parseAddress(StartType.START_CALL, flags, part, data);
              if (connector != null) data.strAddress = data.strAddress.replaceFirst(" & ", connector);
              return;
            }
          }
          
          // Otherwise, call descriptions generally do not end with numbers
          // So if we find one, assume it should be part of the address
          else {
            Matcher match = HOUSE_NUMBER_PTN1.matcher(part);
            if (match.find()) {
              data.strAddress = append(match.group(1), " ", getOptGroup(match.group(2)));
              part = part.substring(0,match.start()).trim();
            }
            data.strCall = part;
          }
          continue;
        }

        // If this is the first bit of address information
        // See if it starts with a sequence that looks like it should be appended 
        // to the call description
        Matcher match = CALL_EXTEND_PTN.matcher(part);
        if (match.find()) {
          char connect = (ndx == 0 ? '/' : ',');
          data.strCall = data.strCall + connect + match.group(1);
          part = part.substring(match.end());
        }
        
        // Now see if it starts with a house number/direction combination
        // that needs to be split up
        if (data.strAddress.length() == 0) {
          match = HOUSE_NUMBER_PTN2.matcher(part);
          if (match.find()) {
            data.strAddress = append(match.group(1), " ", getOptGroup(match.group(2)));
            part = part.substring(match.end()).trim();
          }
        }

        // Whatever is left is appended to the address
        data.strAddress = append(data.strAddress, " ", part);
      }
      
      // If this is the last address field, will finish up by
      // calling parseAddress to clean up the address
      if (lastField) {
        field = data.strAddress;
        data.strAddress = "";
        parseAddress(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR APT CITY";
    }
  }
  private static final Pattern HOUSE_NUMBER_PTN1 = Pattern.compile(" (\\d+) *([NSEW]?)$");
  private static final Pattern HOUSE_NUMBER_PTN2 = Pattern.compile("^(\\d+) *([NSEW]?)\\b");
  private static final Pattern CALL_EXTEND_PTN = Pattern.compile("^(AMBULANCE|MEDICAL|RESCUE)\\b *");
  
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("CALLBK=")) {
        data.strPhone = field.substring(7).trim();
      } else {
        data.strPlace = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE PHONE";
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String unit = "";
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        unit = field.substring(0,pt);
        field = field.substring(pt+1).trim();
      }
      Matcher match = UNIT_PTN.matcher(field);
      if (!match.matches()) return false;
      
      data.strUnit = unit;
      super.parse(match.group(1), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT SRC";
    }
  }
  private static final Pattern UNIT_PTN = Pattern.compile("([A-Z\\d]+:[A-Z\\d]+(?: FD)?)");
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALLADDR1")) return new MyCallAddressField(false);
    if (name.equals("CALLADDR2")) return new MyCallAddressField(true);
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = EXWY_PTN.matcher(addr).replaceAll("").trim();
    addr = DIR_OF_PTN.matcher(addr).replaceAll(" & ");
    return addr;
  }
  private static final Pattern EXWY_PTN = Pattern.compile("\\bEXWY\\b");
}
