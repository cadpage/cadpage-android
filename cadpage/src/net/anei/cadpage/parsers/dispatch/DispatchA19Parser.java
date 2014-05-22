package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Bell County, TX
 */
public class DispatchA19Parser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Incident #: (.*?)\n +CAD Call ID #: (.*?)\n");
  private static final Pattern SUBJECT_PTN = Pattern.compile("(?:DISPATCH)?INCIDENT # ([-,A-Z0-9]+)");
  private static final Pattern HASH_DELIM = Pattern.compile("(?<=[A-Z]) ?#(?= )");
  private static final Pattern FIELD_BREAK = Pattern.compile(" (ACTIVE CALL|REPORTED|Type|Zone|Phone):");
  private static final Pattern FIELD_DELIM = Pattern.compile(" *\n+ *");
  
  public DispatchA19Parser(String defCity, String defState) {
    super(defCity, defState,
           "INCIDENT:ID? LONG_TERM_CAD:ID? ACTIVE_CALL:ID? PRIORITY:PRI? REPORTED:TIMEDATE? Nature:CALL! Type:SKIP! Address:ADDR! Zone:MAP! City:CITY! SearchAddresss:SKIP? LAT-LON:GPS? Responding_Units:UNIT! Directions:INFO! INFO+ Comments:INFO? INFO+ Contact:NAME Phone:PHONE");

  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.lookingAt()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = append(match.group(1).trim(), "/", match.group(2).trim());
      return true;
    }
    
    match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) data.strCallId = match.group(1);
    
    body = HASH_DELIM.matcher(body).replaceAll(":");
    body = FIELD_BREAK.matcher(body).replaceAll("\n$1:");
    return parseFields(FIELD_DELIM.split(body), data);
  }
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      data.strCallId = append(data.strCallId, "/", field);
    }
  }
  
  private static final Pattern ADDR_APT_PTN = Pattern.compile("(?:APT|RM|SUITE) *(.*)|\\d+[A-Z]?", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String apt = null;
      String place = null;
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        apt = field.substring(pt+1).trim();
        field = field.substring(0,pt);
        pt = field.lastIndexOf(';');
        if (pt >= 0) {
          place = field.substring(pt+1).trim();
          field = field.substring(0,pt).trim();
        }
      }
      if (apt != null) {
        if (place != null) {
          String tmp = checkApt(place);
          if (tmp != null) {
            place = apt;
            apt = tmp;
          }
        } else {
          String tmp = checkApt(apt);
          if (tmp != null) {
            apt = tmp;
          } else {
            place = apt;
            apt = "";
          }
        }
      }
      if (apt != null && place == null) {
      }
      if (place != null) data.strPlace = place;
      super.parse(field, data);
      if (apt != null) data.strApt = append(data.strApt, "-", apt);
    }
    
    private String checkApt(String field) {
      Matcher match = ADDR_APT_PTN.matcher(field);
      if (!match.matches()) return null;
      String apt = match.group(1);
      if (apt == null) apt = field;
      return apt;
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }

  private static final Pattern DATE_TIME_OPER_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d{4}) - .*");
  private static final Pattern PHONE_GPS_PTN = Pattern.compile("CALLBACK=([-()\\d]+) LAT=([-+]\\d+\\.\\d+) LON=([-+]\\d+\\.\\d+) UNC=\\d+");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("ProQA Fire.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_OPER_PTN.matcher(field);
      if (match.matches()) {
        data.strTime = match.group(1);
        data.strDate = match.group(2);
        return;
      }
      
      match = PHONE_GPS_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = match.group(1);
        setGPSLoc(match.group(2) + "," + match.group(3), data);
        return;
      }
      
      if (INFO_JUNK_PTN.matcher(field).matches()) return;
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO TIME DATE GPS";
    }
  }
  
  // phone field has to contain a digit
  private static final Pattern LEGIT_PHONE_PTN = Pattern.compile(".*\\d.*");
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (!LEGIT_PHONE_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("PHONE")) return new MyPhoneField();
    return super.getField(name);
  }
}
