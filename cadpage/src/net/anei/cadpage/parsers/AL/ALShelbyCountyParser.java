package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Shelby County, AL
 */
public class ALShelbyCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("SHELBY(?: ?911)? ARNS ALERT");
  private static final String MARKER = "SHELBY ARNS ALERT / ";
  
  public ALShelbyCountyParser() {
    super("SHELBY COUNTY", "AL",
           "DATETIME ID SRC CALL PLACE ADDR! ADDR2? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "arns@shelby911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (SUBJECT_PTN.matcher(subject).matches()) break;
      
      if (body.startsWith(MARKER)) {
        body = body.substring(MARKER.length()).trim();
        break;
      }
      
      return false;
    } while (false);
    return parseFields(body.split("\n"), 6, data);
  }
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strDate = field.substring(0,pt);
      setTime(TIME_FMT, field.substring(pt+1), data);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern PLACE_SRC_PTN = Pattern.compile("[A-Z]{2}FD");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (PLACE_SRC_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strCross = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  // Backup address field is used if first address field does not contain an address
  private class MyAddress2Field extends AddressField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strAddress.length() > 0) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(": @")) {
        field = field.substring(3).trim();
        int pt = field.indexOf(':');
        if (pt < 0) pt = field.indexOf(' ');
        if (pt < 0) pt = field.length();
        String place = field.substring(0,pt);
        if (!PLACE_SRC_PTN.matcher(place).matches()) {
          data.strPlace = append(data.strPlace, " - ", place);
        }
        if (pt >= field.length()) return;
        field = field.substring(pt+1).trim();
      }
      String apt = "";
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        apt = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      data.strApt = append(data.strApt, " - ", apt);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(": @")) {
        field = field.substring(3).trim();
        if (! field.equals(data.strPlace)) data.strPlace = append(data.strPlace, " - ", field);
      }
      
      else if (field.startsWith(":")) {
        data.strApt = append(data.strApt, " - ", field.substring(1).trim());
      }
      else super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ADDR2")) return new MyAddress2Field();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
