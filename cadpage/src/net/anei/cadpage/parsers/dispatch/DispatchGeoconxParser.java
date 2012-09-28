package net.anei.cadpage.parsers.dispatch;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchGeoconxParser extends FieldProgramParser {
  
  private Set<String> citySet;
  private boolean noSubject; 
  
  public DispatchGeoconxParser(String defCity, String defState) {
    this(null, defCity, defState, false);
  }
  
  public DispatchGeoconxParser(Set<String> citySet, String defCity, String defState,
                           boolean noSubject) {
    super(defCity, defState,
           "CALL ( ADDR/Z END | NAMEPH? ADDR INFO+ )");
  }
  
  @Override
  public String getProgram() {
    return "CALL PHONE NAME PLACE ADDR CITY INFO";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String flds[] = body.split("\n");
    if (!subject.equals("E911")) {
      if (noSubject || flds.length < 3) return false;
    }
    if (!parseFields(flds, data)) return false;
    
    // SOmetimes, what we interpreted as a name should be a place
    if (checkPlace(data.strName)) {
      data.strPlace = data.strName;
      data.strName = "";
    }
    return true;
  }

  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}$");
  private static final Pattern DIGIT_PTN = Pattern.compile("\\b\\d{1,7}\\b");
  private class NamePhoneField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // A comma followed by a legitimate name indicates this is really an
      // address field, which we should not recognize
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String sCity = field.substring(pt+1).trim().toUpperCase();
        if (citySet != null && citySet.contains(sCity)) return false;
      }
      
      // Ditto if it contains an @
      if (field.indexOf('@') >= 0) return false;
      
      // Or a number with fewer than 8 digits
      // And does not end with a 10 digit phone number
      if (DIGIT_PTN.matcher(field).find()) {
        if (!PHONE_PTN.matcher(field).find()) return false;
      }
      
      parse(field, data);
      return true;
    }
    
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group();
        field = field.substring(0,match.start()).trim();
      }
      data.strName = field;
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private static final Pattern CITY_PTN = Pattern.compile(", *([A-Z]+ ?[A-Z]*)$", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile(", *((?:\\w+ *)?[-\\w]+)$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("&&", "&");
      
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        data.strCity = match.group(1).trim(); 
        field = field.substring(0,match.start()).trim();
      }
      
      match = APT_PTN.matcher(field);
      if (match.find()) {
        data.strApt = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      
      String tail = "";
      int pt = field.indexOf('@');
      if (pt >= 0) {
        tail = field.substring(pt);
        field = field.substring(0,pt).trim();
      }
      
      StartType st = (data.strName.length() > 0 ? StartType.START_ADDR : StartType.START_PLACE);
      parseAddress(st, FLAG_ANCHOR_END, field, data);
      if (st == StartType.START_PLACE){ 
        if (data.strAddress.length() == 0) {
          data.strAddress = data.strPlace;
        } else {
          data.strName = data.strPlace;
        }
        data.strPlace = "";
      }
      data.strAddress = append(data.strAddress, " ", tail);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NAMEPH")) return new NamePhoneField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
